package Controller;

import ModelBlackJack.*;
import View.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJackController {
    private DeckBlackJack deckBlackJack;  // Baraja del juego
    private GameBlackJack gameBlackJack;  // Juego actual
    private PlayerBlackJack playerBlackJack;  // Jugador principal
    private Scanner scanner;  // Objeto Scanner para entrada del usuario
    private UI ui;  // Interfaz de usuario
    private static final int salir = -1;  // Constante para salir del juego
    private List<PlayerBlackJack> activePlayerBlackJacks;  // Jugadores activos en el juego actual
    private PlayerBlackJack croupier;  // Representa al croupier

    // Constructor de la clase BlackJackController
    public BlackJackController() {
        // Inicialización de variables al iniciar la clase
        this.deckBlackJack = new DeckBlackJack();
        this.scanner = new Scanner(System.in);
        this.ui = new UI();
        this.activePlayerBlackJacks = new ArrayList<>();
    }

    // Método para iniciar el juego con una apuesta dada
    public void startGame(int bet) {
        // Mensaje de bienvenida al juego
        UIBlackJack.showMessageStartGame();

        // Verificar la edad del jugador
        verifyAge();

        // Pedir al usuario que elija el nivel de dificultad
        int difficultyLevel = chooseDifficultyLevel();

        // Inicializar jugadores
        List<PlayerBlackJack> playerBlackJacks = initializePlayers();
        playerBlackJack = playerBlackJacks.get(0); // Asignar el primer jugador como jugador principal

        // Iniciar el juego
        gameBlackJack = new GameBlackJack(playerBlackJacks);

        // Realizar la lógica del juego
        playGame(difficultyLevel, playerBlackJacks, bet);
    }

    // Método para verificar la edad del jugador
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

    // Método para que el usuario elija el nivel de dificultad
    private int chooseDifficultyLevel() {
        int difficultyLevel;
        do {
            // Solicitar al usuario que elija el nivel de dificultad
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════════════╗");
            System.out.println(" · Seleccione el nivel de dificultad del crupier:");
            System.out.println("  |1| Fácil ⭐");
            System.out.println("  |2| Normal ⭐⭐");
            System.out.println("  |3| Experto ⭐⭐⭐");
            System.out.println("╚═══════════════════════════════════════════════════╝");
            System.out.print("⭐ Ingrese el número de nivel de la dificultad: ");
            try {
                difficultyLevel = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: ingrese un número válido.");
                difficultyLevel = -1;  // Establecer un valor inválido para repetir el bucle
            }
        } while (difficultyLevel < 1 || difficultyLevel > 3);

        return difficultyLevel;
    }

    // Método para inicializar la lista de jugadores
    private List<PlayerBlackJack> initializePlayers() {
        System.out.println();
        int numPlayers;
        do {
            // Solicitar al usuario el número de jugadores
            System.out.print("\uD83D\uDC64 Ingrese el Número de jugadores (entre 1 y 4): ");
            numPlayers = scanner.nextInt();
            scanner.nextLine();
        } while (numPlayers < 1 || numPlayers > 4);

        List<PlayerBlackJack> playerBlackJacks = new ArrayList<>();

        // Crea jugadores humanos
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("\uD83D\uDC64 Ingrese el Nombre del Jugador " + i + ": ");
            String playerName = scanner.nextLine();
            PlayerBlackJack newPlayerBlackJack = new PlayerBlackJack(playerName);
            playerBlackJacks.add(newPlayerBlackJack);
        }

        // Añade el croupier
        croupier = new PlayerBlackJack("Croupier");
        playerBlackJacks.add(croupier);

        // Asigna la lista de jugadores a la lista de jugadores activos
        activePlayerBlackJacks.addAll(playerBlackJacks);
        return playerBlackJacks;
    }

    // Método para obtener la apuesta del jugador
    private int getPlayerBet() {
        if (playerBlackJack != null) {
            // Obtener apuesta del jugador
            System.out.println();
            System.out.print("\uD83D\uDCB5 ¿Cuánto dinero tienes en la cartera(€)?: ");
            int moneyWallet = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\uD83D\uDCB5 Dinero de tu cartera actual (€): " + moneyWallet);
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

    // Método principal para ejecutar el juego
    private void playGame(int difficultyLevel, List<PlayerBlackJack> playerBlackJacks, int bet) {
        int intentos = 3; // Número máximo de intentos
        while (true) {
            // Reiniciar la mano del jugador y la baraja
            for (PlayerBlackJack currentPlayerBlackJack : playerBlackJacks) {
                currentPlayerBlackJack.resetHand();
            }
            deckBlackJack.shuffle();

            // Hacer apuesta
            bet = getPlayerBet();
            if (bet == -1) {
                break;
            }

            // Jugar el turno para cada jugador (excepto el croupier)
            for (PlayerBlackJack currentPlayerBlackJack : playerBlackJacks) {
                if (currentPlayerBlackJack != croupier) {
                    playTurn(currentPlayerBlackJack);
                }
            }

            // Repartir las dos primeras cartas al croupier
            PlayerBlackJack croupier = activePlayerBlackJacks.get(activePlayerBlackJacks.size() - 1);
            croupier.addCard(deckBlackJack.drawCard());
            croupier.addCard(deckBlackJack.drawCard());

            // Jugar el turno de croupier
            playCroupierTurn(difficultyLevel);

            // Determinar el resultado y manejar el dinero
            handleFinalResult(bet, playerBlackJacks, croupier);

            // Preguntar al jugador si desea jugar otra vez
            System.out.println();
            System.out.print("¿Quieres jugar otra vez? (1: Sí / 2: No): ");
            int playAgain = scanner.nextInt();
            scanner.nextLine();

            while (intentos > 0) {
                if (playAgain == 1 || playAgain == 2) {
                    // Salir del bucle si la opción es válida
                    if (playAgain != 1) {
                        UI.showMessageFarrewell();
                    }
                    break;
                } else {
                    System.out.println("❌ Opción no válida. Debes ingresar 1 para 'Sí' o 2 para 'No'. Intentos restantes: " + intentos);
                    intentos--;
                }
            }

            if (intentos == 0) {
                // Salir del bucle si se agotan los intentos
                System.out.println("❌ Número de intentos agotado. Saliendo del juego.");
                UI.showMessageFarrewell();
                System.exit(0);
            }
        }
    }

    // Método para jugar el turno de un jugador
    private void playTurn(PlayerBlackJack currentPlayerBlackJack) {
        // Reiniciar la mano del jugador y la baraja
        currentPlayerBlackJack.resetHand();
        deckBlackJack.shuffle();

        // Repartir las dos primeras cartas al jugador humano
        currentPlayerBlackJack.addCard(deckBlackJack.drawCard());
        currentPlayerBlackJack.addCard(deckBlackJack.drawCard());

        // Jugar el turno del jugador
        playPlayerTurn(currentPlayerBlackJack);
    }

    // Método para jugar el turno de un jugador humano
    private void playPlayerTurn(PlayerBlackJack currentPlayerBlackJack) {
        while (true) {
            // Mostrar la mano actual del jugador
            System.out.println();
            System.out.println("🎲 Mano actual (" + currentPlayerBlackJack.getName() + "): ");
            playerBlackJack.printHand();
            System.out.println("🎲 Puntaje actual: " + currentPlayerBlackJack.getScore());
            System.out.println("|1| Plantarse");
            System.out.println("|2| Continuar jugando");
            System.out.println();

            // Verificar si el jugador se pasa de 21
            if (playerBlackJack.getScore() > 21) {
                System.out.println("❌ Te has pasado de 21. Has perdido.");
                break;
            }

            // Preguntar al jugador si desea plantarse o continuar jugando
            int decision = getDecisionFromPlayer();

            if (decision == 1) {
                break;
            }

            // Tomar una nueva carta
            CardBlackJack newCardBlackJack = deckBlackJack.drawCard();
            System.out.println("Has sacado una carta: " + newCardBlackJack);

            // Agregar la carta a la mano del jugador
            currentPlayerBlackJack.addCard(newCardBlackJack);
        }
    }

    // Método para jugar el turno del croupier
    private void playCroupierTurn(int difficultyLevel) {
        // Mostrar la mano actual del jugador
        System.out.println();
        System.out.println("🎲 Mano actual del croupier: ");
        playerBlackJack.printHand();

        // Tomar decisiones de la IABlackJack
        int decision = IABlackJack.rule(difficultyLevel, croupier);

        // El croupier toma cartas hasta alcanzar el puntaje objetivo
        while (decision == 2) {
            // Tomar una nueva carta
            CardBlackJack newCardBlackJack = deckBlackJack.drawCard();

            // Agregar la carta a la mano del croupier
            croupier.addCard(newCardBlackJack);

            // Tomar la próxima decisión de la IABlackJack
            decision = IABlackJack.rule(difficultyLevel, croupier);
        }

        // Mostrar cartas del croupier
        System.out.println();
        croupier.printHand();
        PlayerBlackJack croupier = activePlayerBlackJacks.get(activePlayerBlackJacks.size() - 1);

        // Mostrar el puntuaje del croupier
        System.out.println("🎲 Puntaje actual del Croupier: " + croupier.getScore());
    }

    // Método para obtener la decisión del jugador
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

    // Método para manejar el resultado final del juego
    private void handleFinalResult(int bet, List<PlayerBlackJack> playerBlackJacks, PlayerBlackJack croupier) {
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("              === \uD83C\uDFC1 Fin del juego \uD83C\uDFC1 ===");
        System.out.println();
        System.out.println(" · Resultados \uD83D\uDCCA: ");

        // Mostrar las manos finales de todos los jugadores
        for (PlayerBlackJack currentPlayerBlackJack : playerBlackJacks) {
            if (currentPlayerBlackJack != croupier) {
                System.out.println(" 🎲 | Puntaje final de " + currentPlayerBlackJack.getName() + ": " + currentPlayerBlackJack.getScore());
            }
        }

        System.out.println(" 🎲 | Puntaje final del croupier"  + ": " + croupier.getScore());

        // Determinar el ganador
        PlayerBlackJack winner = determineWinner(playerBlackJacks, bet, croupier);

        // Manejar el dinero del ganador y mostrar resultados
        if (winner != null) {
            System.out.println(" \uD83C\uDF89 | ¡El ganador es " + winner.getName() + "!");
            winner.setMoneyWallet(winner.getMoneyWallet() + (int) (1.5 * bet) * playerBlackJacks.size());
            System.out.println(" 💰 | Dinero en la cartera: +" + bet + "€");
            System.out.println("╚════════════════════════════════════════════════╝");
        } else {
            System.out.println(" ⚖️ | Empate. Nadie gana esta ronda.");
            System.out.println(" 💰 | Dinero en la cartera: "+ bet + "€");
            System.out.println("╚════════════════════════════════════════════════╝");
        }
    }

    private PlayerBlackJack determineWinner(List<PlayerBlackJack> playerBlackJacks, int bet, PlayerBlackJack croupier) {
        PlayerBlackJack winner = null;
        int maxScore = 0;

        for (PlayerBlackJack currentPlayerBlackJack : playerBlackJacks) {
            if (currentPlayerBlackJack.getScore() <= 21 && currentPlayerBlackJack.getScore() > maxScore) {
                winner = currentPlayerBlackJack;
                maxScore = currentPlayerBlackJack.getScore();

                // Si el jugador tiene un As que vale 11, intentar cambiarlo a 1 para evitar pasarse
                currentPlayerBlackJack.handleAcesOver21();

                // Si el jugador no tiene un As que pueda cambiar a 1, resta la apuesta al dinero de su cartera
                currentPlayerBlackJack.setMoneyWallet(currentPlayerBlackJack.getMoneyWallet() - bet);
            }else {
                System.out.println(" ❌ | Te has pasado de 21." + currentPlayerBlackJack.getName());
            }
        }

        // Si el croupier tiene un As que vale 11, intentar cambiarlo a 1 para evitar pasarse
        croupier.handleAcesOver21();

        return winner;
    }
}