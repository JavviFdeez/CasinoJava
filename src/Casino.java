import Controller.*;
import View.*;

public class Casino {
    private static int bet;

    public static void main(String[] args) {
        // Mostrar mensaje de bienvenida
        UI.showMessageWelcome();

        // Inicianando el controlador principal
        MainController mainController = new MainController();
        mainController.start(bet);
    }
}