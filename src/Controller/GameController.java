package Controller;

import Model.*;
import View.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private Deck deck;
    private Game game;
    private Player player;
    private Scanner scanner;
    private WelcomeMessage welcomeMessage;
    private static final int salir = -1;

    public GameController() {
        this.deck = new Deck();
        this.scanner = new Scanner(System.in);
        this.welcomeMessage = new WelcomeMessage();
    }

    public void startGame() {
        // Mensaje de bienvenida al juego
        welcomeMessage.showMessageStartGame();

        // Verificar la edad del jugador
        verifyAge();

        // Inicializar jugadores
        List<Player> players = initializePlayers();

        // Iniciar el juego
        game = new Game(players);

        // Obtener el primer jugador de la lista (puedes ajustar esto según tu lógica)
        player = game.getPlayers().get(0);

        // Realizar la lógica del juego
        playGame();

        // Mostrar resultados
        displayResults();
    }

    public void displayMoney() {
        if (player != null) {
            // Mostrar el dinero del jugador actual
            System.out.println("Dinero actual en la cartera: " + player.getMoneyWallet());
        } else {
            System.out.println("Error: El jugador actual no está inicializado correctamente.");
        }
    }

    private boolean verifyAge() {
        int age;
        int intentos = 3;  // Número máximo de intentos

        while (intentos > 0) {
            try {
                System.out.print("Introduce tu edad (\uD83D\uDD1E Prohibida la entrada a menores de 18 años \uD83D\uDD1E): ");
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 18) {
                    return true;
                } else {
                    System.out.println("Lo siento, debes tener al menos 18 años para jugar.");
                    FarewellMessage.showMessageFarrewell();
                    System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
                intentos--;
            }
        }
        System.out.println("Número de intentos agotado. Saliendo del juego.");
        FarewellMessage.showMessageFarrewell();
        System.exit(0);
        return false;
    }

    private List<Player> initializePlayers() {
        System.out.print("\uD83D\uDC64 Ingrese el Número de jugadores (entre 1 y 4): ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();
        List<Player> players = new ArrayList<>();

        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("\uD83D\uDC64 Ingrese el Nombre del Jugador " + i + ": ");
            String playerName = scanner.nextLine();
            Player newPlayer = new Player(playerName);
            players.add(newPlayer);
        }
        return players;
    }

    private int takePlayerBet() {
        if (player != null) {
            System.out.println();
            System.out.print("\uD83D\uDCB5 ¿Cuánto dinero tienes en la cartera(€)?: ");
            int moneyWallet = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\uD83D\uDCB5 Dinero de tu cartera actual: "+moneyWallet);
            System.out.println();

            System.out.print("💎 ¿Cuánto deseas apostar?(Mínimo 1€ o escriba 'salir' para salir del juego): ");
            int bet = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Dinero apostado: "+bet);
            System.out.println();

            if (bet == salir) {
                FarewellMessage.showMessageFarrewell();
                return salir;
            }

            // Verificar si la bet es válida
            if (bet < 1 || bet > moneyWallet) {
                System.out.println("❌ Apuesta no válida. Debes apostar al menos 1€ y no más de lo que tienes en la cartera.");
                return takePlayerBet();  // Pedir una nueva apuesta
            }
            return bet;
        } else {
            System.out.println("❌ Error: El jugador actual no está inicializado correctamente.");
            return -1;
        }
    }
    private void playGame() {
        while (true) {
            // Reiniciar la mano del jugador y la baraja
            if (player != null) {
                player.resetHand();
            } else {
                System.out.println("Error: El jugador actual no está inicializado correctamente.");
                break;
            }
            deck.shuffle();

            // Hacer apuesta
            int bet = takePlayerBet();
            if (bet == -1) {
                break;
            }

            // Repartir las dos primeras cartas
            player.addCard(deck.drawCard());
            player.addCard(deck.drawCard());

            // Jugar el turno
            playTurn();

            // Determinar el resultado y manejar el dinero
            handleResult(bet);
        }
    }

    private void playTurn() {
        while (true) {
            // Mostrar la mano actual del jugador
            if (player != null) {
                System.out.println("Tu mano actual: " + player.getHand());
                System.out.println("Puntaje actual: " + player.getScore());
            } else {
                System.out.println("Error: El jugador actual no está inicializado correctamente.");
                break;
            }

            // Verificar si el jugador se pasa de 21
            if (player.getScore() > 21) {
                System.out.println("Te has pasado de 21. Has perdido.");
                break;
            }

            // Preguntar al jugador si desea plantarse o continuar jugando
            System.out.println("¿Quieres plantarte (1) o continuar jugando (2)?");
            int decision = scanner.nextInt();
            scanner.nextLine();

            if (decision == 1) {
                break;
            }

            // Tomar una nueva carta
            Card newCard = deck.drawCard();
            System.out.println("Has sacado una carta: " + newCard);

            // Agregar la carta a la mano del jugador
            player.addCard(newCard);
        }
    }

    private void handleResult(int bet) {
        if (player != null) {
            System.out.println("Fin del juego. Resultados:");

            // Mostrar la mano final del jugador
            System.out.println("Tu mano final: " + player.getHand());
            System.out.println("Puntaje final: " + player.getScore());

            // Determinar el resultado
            if (player.getScore() > 21) {
                System.out.println("Te has pasado de 21. Has perdido.");

                // Si el jugador tiene un As que vale 11, intentar cambiarlo a 1 para evitar pasarse
                player.handleAceOver21();

                // Si el jugador no tiene un As que pueda cambiar a 1, resta la apuesta al dinero de su cartera
                player.setMoneyWallet(player.getMoneyWallet() - bet);
            } else if (player.getScore() == 21) {
                System.out.println("¡Blackjack! Has ganado.");
                // Pagar 1.5 veces la apuesta por un Blackjack
                player.setMoneyWallet(player.getMoneyWallet() + (int) (1.5 * bet));
            } else {
                // Empate si la banca también tiene la misma puntuación
                if (player.getScore() == getBankScore()) {
                    System.out.println("Empate. Recuperas tu apuesta.");
                    player.setMoneyWallet(player.getMoneyWallet() + bet);
                } else if (player.getScore() > getBankScore()) {
                    System.out.println("¡Felicidades! Has ganado.");
                    // Pagar la apuesta normal
                    player.setMoneyWallet(player.getMoneyWallet() + bet);
                } else {
                    System.out.println("Has perdido.");
                    // Restar la apuesta al dinero de la cartera
                    player.setMoneyWallet(player.getMoneyWallet() - bet);
                }
            }

            // Mostrar el dinero actual del jugador
            System.out.println("Dinero en la cartera: " + player.getMoneyWallet());
        } else {
            System.out.println("Error: El jugador actual no está inicializado correctamente.");
        }
    }

    private int getBankScore() {
        if (player != null) {
            // Puntuación de la banca
            int score = 0;
            for (Card card : player.getHand()) {
                score += card.getScore();
            }
            return score;
        } else {
            System.out.println("Error: El jugador actual no está inicializado correctamente.");
            return 0;
        }
    }

    private void displayResults() {
        if (player != null) {
            System.out.println("Resultados finales:");
            System.out.println("Dinero final en la cartera: " + player.getMoneyWallet());
            System.out.println("¡Gracias por jugar!");
        } else {
            System.out.println("Error: El jugador actual no está inicializado correctamente.");
        }
    }
}