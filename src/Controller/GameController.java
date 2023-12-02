package Controller;

import Model.*;
import View.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private Deck deck;
    private Game game;
    private Scanner scanner;
    private WelcomeMessage welcomeMessage;

    public GameController() {
        this.deck = new Deck();
        this.scanner = new Scanner(System.in);
        this.welcomeMessage = new WelcomeMessage();
    }

    public void startGame() {
        welcomeMessage.showMessageStartGame();
        // Verificar la edad del jugador
        if (!verifyAge()) {
            System.out.println("Para jugar debes tener al menos 18 años.");
            return;
        }

        // Inicializar jugadores
        List<Player> players = initializePlayers();

        // Iniciar el juego
        game = new Game(players);

        // Realizar la lógica del juego
        playGame();

        // Mostrar resultados
        displayResults();
    }

    private boolean verifyAge() {
        System.out.println("Introduce tu edad (\uD83D\uDD1EProhibida la entrada a menores de 18 años\uD83D\uDD1E):");
        int age = scanner.nextInt();
        return age >= 18;
    }

    private List<Player> initializePlayers() {
        System.out.println("Ingrese el número de jugadores (entre 1 y 4): ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        List<Player> players = new ArrayList<>();

        for (int i = 1; i <= numPlayers; i++) {
            System.out.println("Ingrese el nombre del Jugador " + i + ": ");
            String playerName = scanner.nextLine();
            Player player = new Player(playerName);
            players.add(player);
        }
            return players;
    }

    private void playGame() {
        // Implementar la lógica principal del juego aquí
        // Puedes manejar los turnos de los jugadores, la distribución de cartas, etc.
        // Recuerda gestionar las apuestas y el dinero de los jugadores.
    }

    private void displayResults() {
        // Implementar la lógica para mostrar los resultados al final del juego
        // Puedes mostrar los puntajes de los jugadores, el ganador, etc.
    }

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}