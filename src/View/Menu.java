package View;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public int showMainMenu() {
        System.out.println("1. Iniciar juego");
        System.out.println("2. Consultar dinero de la cartera");
        System.out.println("3. Leer reglas");
        System.out.println("4. Salir");
        System.out.print("Selecciona una opción: ");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        return choice;
    }
}

