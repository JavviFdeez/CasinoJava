package Controller;

import View.*;
public class MainController {
    private Menu menu;
    private Rules rules;
    private GameController gameController;

    public MainController() {
        this.menu = new Menu();
        this.gameController = new GameController();
        this.rules = new Rules();
    }

    public void start(int bet) {
        while (true) {
            int choice = menu.showMainMenu();

            switch (choice) {
                case 1:
                    gameController.startGame(bet);
                    break;
                case 2:
                    rules.showRules();
                    break;
                case 3:
                    UI.showMessageFarrewell();
                    System.exit(0);
                    break;
                default:
                    System.out.println("❌ Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        }
    }
}