package Controller;

import View.*;
public class MainController {
    private Menu menu;
    private Rules rules;
    private GameController gameController;

    public MainController() {
        this.menu = new Menu();
        this.gameController = gameController;
        this.rules = new Rules();
    }

    public void start() {
        while (true) {
            int choice = menu.showMainMenu();

            switch (choice) {
                case 1:
                    startGame();
                    break;
                case 2:
                    gameController.displayMoney();
                    break;
                case 3:
                    rules.showRules();
                    break;
                case 4:
                    UI.showMessageFarrewell();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        }
    }
    private void startGame() {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}