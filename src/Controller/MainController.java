package Controller;

import View.*;
public class MainController {
    private Menu menu;  // Menú de opciones
    private Rules rules;  // Reglas del juego
    private GameController gameController;  // Controlador del juego

    // Constructor de la clase MainController
    public MainController() {
        this.menu = new Menu();  // Inicialización del menú
        this.gameController = new GameController();  // Inicialización del controlador de juego
        this.rules = new Rules();  // Inicialización de las reglas del juego
    }

    // Método para iniciar la aplicación
    public void start(int bet) {
        while (true) {
            // Mostrar menú principal y obtener la elección del usuario
            int choice = menu.showMainMenu();

            // Realizar acciones según la elección del usuario
            switch (choice) {
                case 1:
                    gameController.startGame(bet);  // Iniciar el juego con la apuesta dada
                    break;
                case 2:
                    rules.showRules();  // Mostrar las reglas del juego
                    break;
                case 3:
                    UI.showMessageFarrewell();  // Mostrar mensaje de despedida
                    System.exit(0);  // Salir de la aplicación
                    break;
                default:
                    System.out.println("❌ Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        }
    }
}