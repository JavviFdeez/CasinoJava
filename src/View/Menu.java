package View;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public int showMainMenu() {
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║        === MENÚ PRINCIPAL  ===       ║");
        System.out.println("║ = 1. Iniciar juego ⏯                 ║");
        System.out.println("║ == 2. Consultar su dinero actual \uD83D\uDCB0  ║");
        System.out.println("║ ==== 3. Consultar reglas \uD83D\uDCCA          ║");
        System.out.println("║ ===== 4. Salir \uD83D\uDEAA                    ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("·Selecciona una opción: ");

        int election = scanner.nextInt();
        scanner.nextLine();

        return election;
    }
}

