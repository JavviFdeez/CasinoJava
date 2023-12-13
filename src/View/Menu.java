package View;

import java.util.Scanner;

// Clase que gestiona la presentación del menú principal del juego
public class Menu {
    private Scanner scanner;  // Scanner para la entrada del usuario

    // Constructor que inicializa el Scanner al crear una instancia de la clase Menu
    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    // Método para mostrar el menú principal y obtener la elección del usuario
    public int showMainMenu() {
        try {
            // Presentar opciones del menú
            System.out.println();
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║        === MENÚ PRINCIPAL ===        ║");
            System.out.println("║ = 1. Iniciar BlackJack ⏯             ║");
            System.out.println("║ == 2. Consultar reglas \uD83D\uDCCA            ║");
            System.out.println("║ === 3. Salir \uD83D\uDEAA                      ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("· Selecciona una opción: ");

            // Obtener la elección del usuario como un número entero
            int election = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después de la entrada numérica
            return election;
        } catch (Exception e) {
            // Manejar excepción si el usuario ingresa algo que no es un número
            System.out.println("❌ Opción no válida. Por favor, ingresa un número.");
            scanner.nextLine();  // Limpiar el búfer de entrada
            return showMainMenu();  // Pedir la opción nuevamente
        }
    }

    // Método para cerrar el Scanner cuando ya no se necesita
    public void closeScanner() {
        scanner.close();
    }
}