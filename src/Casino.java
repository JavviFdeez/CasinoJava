import Controller.*;
import View.*;

public class Casino {
    public static void main(String[] args) {
        // Mostrar mensaje de bienvenida
        WelcomeMessage.showMessageWelcome();

        // Inicianado el controlador principal
        MainController mainController = new MainController();
        mainController.start();
    }
}