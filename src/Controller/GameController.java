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
    private UI ui;
    private static final int salir = -1;
    private List<Player> activePlayers;  // Jugadores activos en el juego actual


    public GameController() {
        this.deck = new Deck();
        this.scanner = new Scanner(System.in);
        this.ui = ui;
        this.activePlayers = new ArrayList<>();
    }

    public void startGame() {
        // Mensaje de bienvenida al juego
        UI.showMessageStartGame();

        // Verificar la edad del jugador
        verifyAge();

        // Pedir al usuario que elija el nivel de dificultad
        int difficultyLevel = chooseDifficultyLevel();

        // Inicializar jugadores
        List<Player> players = initializePlayers();
        player = players.get(0); // Asignar el primer jugador como jugador principal

        // Iniciar el juego
        game = new Game(players);

        // Realizar la lógica del juego
        playGame(difficultyLevel, players);

        // Mostrar resultados
        displayResults();
    }

    public void displayMoney() {
        if (player != null) {
            // Mostrar el dinero del jugador actual
            System.out.println("Dinero actual en la cartera: " + player.getMoneyWallet());
        } else {
            System.out.println("❌ Error: El jugador actual no está inicializado correctamente.");
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
                    System.out.println("❌ Lo siento, debes tener al menos 18 años para jugar.");
                    UI.showMessageFarrewell();
                    System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
                intentos--;
            }
        }
        System.out.println("❌ Número de intentos agotado. Saliendo del juego.");
        UI.showMessageFarrewell();
        System.exit(0);
        return false;
    }

    private List<Player> initializePlayers() {
        System.out.print("\uD83D\uDC64 Ingrese el Número de jugadores (entre 1 y 4): ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();
        List<Player> players = new ArrayList<>();

        // Asegurar de que haya al menos un jugador humano y un croupier (IA)
        if (numPlayers < 1 || numPlayers > 4) {
            System.out.println("❌ Número de jugadores no válido. Debes tener entre 1 y 4 jugadores.");
            initializePlayers();  // Pedir un nuevo ingreso
            return players;
        }

        // Crea jugadores humanos
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("\uD83D\uDC64 Ingrese el Nombre del Jugador " + i + ": ");
            String playerName = scanner.nextLine();
            Player newPlayer = new Player(playerName);
            players.add(newPlayer);
        }

        // Añade el croupier
        players.add(new Player("Croupier"));

        // Asigna la lista de jugadores a la lista de jugadores activos
        activePlayers.addAll(players);
        return players;
    }

    private int getPlayerBet() {
        if (player != null) {
            System.out.println();
            System.out.print("\uD83D\uDCB5 ¿Cuánto dinero tienes en la cartera(€)?: ");
            int moneyWallet = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\uD83D\uDCB5 Dinero de tu cartera actual: "+moneyWallet);
            System.out.println();

            System.out.print("💎 ¿Cuánto deseas apostar?(Mínimo 1€ o escriba 'salir' para salir del juego): ");
            String betInput = scanner.nextLine();

            // Verificar si el usuario quiere salir
            if (betInput.equalsIgnoreCase("salir")) {
                UI.showMessageFarrewell();
                return salir;
            }

            try {
                // Intentar convertir la entrada a un entero
                int bet = Integer.parseInt(betInput);

                // Verificar si la bet es válida
                if (bet < 1 || bet > moneyWallet) {
                    System.out.println("❌ Apuesta no válida. Debes apostar al menos 1€ y NO más de lo que tienes en la cartera.");
                    return getPlayerBet();  // Pedir una nueva apuesta
                }

                return bet;
            } catch (NumberFormatException e) {
                // Manejar la excepción si la entrada no es un entero
                System.out.println("❌ Por favor, ingresa un número válido.");
                return getPlayerBet();  // Pedir una nueva apuesta
            }
        } else {
            System.out.println("❌ Error: El jugador actual no está inicializado correctamente.");
            return -1;
        }
    }

    private int chooseDifficultyLevel() {
        int difficultyLevel;
        do {
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println(" · Seleccione el nivel de dificultad:");
            System.out.println("  |1| Fácil ⭐");
            System.out.println("  |2| Normal ⭐⭐");
            System.out.println("  |3| Experto ⭐⭐⭐");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("⭐ Ingrese el número de nivel de la dificultad: ");
            System.out.println();
            try {
                difficultyLevel = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: ingrese un número válido.");
                difficultyLevel = -1;  // Establecer un valor inválido para repetir el bucle
            }
        } while (difficultyLevel < 1 || difficultyLevel > 3);

        return difficultyLevel;
    }

    private void playGame(int difficultyLevel, List<Player> players) {
        while (true) {
            // Reiniciar la mano del jugador y la baraja
            if (player != null) {
                player.resetHand();
            } else {
                System.out.println("❌ Error: El jugador actual no está inicializado correctamente.");
                break;
            }
            deck.shuffle();

            // Hacer apuesta
            int bet = getPlayerBet();
            if (bet == -1) {
                break;
            }

            // Jugar el turno
            playTurn(difficultyLevel);

            // Determinar el resultado y manejar el dinero
            handleResult(bet);

            // Jugar el turno del croupier (IA)
            playCroupierTurn(difficultyLevel);

            // Preguntar al jugador si desea jugar otra vez
            System.out.println();
            System.out.print("¿Quieres jugar otra vez? (1: Sí / 2: No): ");
            int playAgain = scanner.nextInt();
            scanner.nextLine();

            if (playAgain != 1) {
                // Salir del bucle si el jugador no quiere jugar otra vez
                UI.showMessageFarrewell();
                break;
            }
        }
    }

    private void playTurn(int difficultyLevel) {
        // Repartir las dos primeras cartas al croupier
        Player croupier = activePlayers.get(activePlayers.size() - 1);
        croupier.addCard(deck.drawCard());
        croupier.addCard(deck.drawCard());

        // Repartir las dos primeras cartas al jugador humano
        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());

        // Jugar el turno del jugador
        playPlayerTurn();

        // Jugar el turno del croupier (IA)
        playCroupierTurn(difficultyLevel);
    }

    private void playPlayerTurn() {
        while (true) {
            // Mostrar la mano actual del jugador
            System.out.println("🎲 Tu mano actual: ");
            player.printHand();
            System.out.println("🎲 Puntaje actual: " + player.getScore());
            System.out.println("|1| Plantarse");
            System.out.println("|2| Continuar jugando");
            System.out.println();

            // Verificar si el jugador se pasa de 21
            if (player.getScore() > 21) {
                System.out.println("Te has pasado de 21. Has perdido.");
                break;
            }

            // Preguntar al jugador si desea plantarse o continuar jugando
            int decision = getDecisionFromPlayer();

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

    private void playCroupierTurn(int difficultyLevel) {
        // Mostrar la mano del croupier
        System.out.println("🎲 Mano del Croupier: ");
        Player croupier = activePlayers.get(activePlayers.size() - 1);
        croupier.printHand();
        System.out.println("🎲 Puntaje del Croupier: " + croupier.getScore());

        // Tomar decisiones de la IA
        int decision = IA.decide(difficultyLevel, croupier);

        // El croupier toma cartas hasta alcanzar el puntaje objetivo
        while (decision == 2) {
            // Tomar una nueva carta
            Card newCard = deck.drawCard();
            System.out.println("El Croupier ha sacado una carta: " + newCard);

            // Agregar la carta a la mano del croupier
            croupier.addCard(newCard);

            // Tomar la próxima decisión de la IA
            decision = IA.decide(difficultyLevel, croupier);
        }

        // Mostrar la mano final del croupier
        System.out.println("🎲 Mano final del Croupier: ");
        croupier.printHand();
        System.out.println("🎲 Puntaje final del Croupier: " + croupier.getScore());
    }

    private int getDecisionFromPlayer() {
        while (true) {
            System.out.print("¿Quieres plantarte (1) o continuar jugando (2)?: ");
            try {
                int decision = Integer.parseInt(scanner.nextLine());
                if (decision == 1 || decision == 2) {
                    return decision;
                } else {
                    System.out.println("❌ Ingresa 1 para plantarte o 2 para continuar jugando.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Por favor, ingresa un número válido.");
            }
        }
    }
    private void handleResult(int bet) {
        if (player != null) {
            System.out.println();
            System.out.println("Fin del juego. Resultados: ");

            // Mostrar la mano final del jugador
            System.out.println("🎲 Puntaje final: " + player.getScore());

            // Determinar el resultado
            if (player.getScore() > 21) {
                System.out.println("❌ Te has pasado de 21. Has perdido.");

                // Si el jugador tiene un As que vale 11, intentar cambiarlo a 1 para evitar pasarse
                player.handleAceOver21();

                // Si el jugador no tiene un As que pueda cambiar a 1, resta la apuesta al dinero de su cartera
                player.setMoneyWallet(player.getMoneyWallet() - bet);
            } else if (player.getScore() == 21) {
                System.out.println("\uD83C\uDFC6 ¡BlackJack! Has ganado.");
                // Pagar 1.5 veces la apuesta por un Blackjack
                player.setMoneyWallet(player.getMoneyWallet() + (int) (1.5 * bet));
            } else {
                // Empate si la banca también tiene la misma puntuación
                if (player.getScore() == getBankScore()) {
                    System.out.println("⚖\uFE0F Empate. Recuperas tu apuesta.");
                    player.setMoneyWallet(player.getMoneyWallet() + bet);
                } else if (player.getScore() > getBankScore()) {
                    System.out.println("\uD83C\uDFC6 ¡Felicidades! Has ganado.");
                    // Pagar la apuesta normal
                    player.setMoneyWallet(player.getMoneyWallet() + bet);
                } else {
                    System.out.println("❌ Has perdido.");
                    // Restar la apuesta al dinero de la cartera
                    player.setMoneyWallet(player.getMoneyWallet() - bet);
                }
            }

            // Mostrar el dinero actual del jugador
            System.out.println("💰 Dinero en la cartera: " + player.getMoneyWallet());
        } else {
            System.out.println("❌ Error: El jugador actual no está inicializado correctamente.");
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
            System.out.println("❌ Error: El jugador actual no está inicializado correctamente.");
            return 0;
        }
    }

    private void displayResults() {
        if (player != null) {
            System.out.println("\uD83C\uDFC6 Resultados finales:");
            System.out.println("💰 Dinero final en la cartera: " + player.getMoneyWallet());
            System.out.println("💎 ¡Gracias por jugar!");
        } else {
            System.out.println("❌ Error: El jugador actual no está inicializado correctamente.");
        }
    }
}