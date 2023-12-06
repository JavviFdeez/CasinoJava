package View;

public class Rules {
    public void showRules() {
        // Reglas del juego
        System.out.println();
        System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                          === Reglas del BlackJack ===                             ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Objetivo del juego:                                                            ║");
        System.out.println("║  ·Obtener una mano con un valor lo más cercano posible a 21 sin pasarse.          ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 2. Valor de las Cartas:                                                           ║");
        System.out.println("║  ·Las cartas numéricas (2-10) tienen el valor nominal.                            ║");
        System.out.println("║  ·Las cartas de figuras (J, Q, K) valen 10.);                                     ║");
        System.out.println("║  ·El As puede valer 1 u 11, dependiendo de la situación.                          ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 3. Inicio del Juego:                                                              ║");
        System.out.println("║  ·El jugador y el crupier reciben dos cartas cada uno.                            ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 4. Turno del Jugador:                                                             ║");
        System.out.println("║  ·El jugador decide si pide más cartas (hit) o se planta (stand).                 ║");
        System.out.println("║  ·Puede seguir pidiendo cartas hasta que se planta, obtiene 21 (Blackjack) o      ║");
        System.out.println("║   se pasa de 21.                                                                  ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 5. Turno del Crupier:                                                             ║");
        System.out.println("║  ·El crupier revela su segunda carta.                                             ║");
        System.out.println("║  ·El crupier debe seguir sacando cartas hasta llegar a un total de 17 o más.      ║");
        System.out.println("║  ·Si el crupier se pasa de 21, los jugadores que no se quemaron ganan.            ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 6. Ganar y Perder:                                                                ║");
        System.out.println("║  ·Si el jugador obtiene Blackjack (21 con las dos primeras cartas), generalmente  ║");
        System.out.println("║   gana 1.5 veces su apuesta                                                       ║");
        System.out.println("║  ·Si el jugador se pasa de 21, pierde automáticamente.                            ║");
        System.out.println("║  ·Si el crupier se pasa de 21, los jugadores que no se quemaron ganan.            ║");
        System.out.println("║  ·Si el crupier y el jugador tienen manos válidas, gana el que tenga un valor más ║");
        System.out.println("║   cercano a 21.                                                                   ║");
        System.out.println("║  ·En caso de empate, se recupera la apuesta.                                      ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 7. Seguro:                                                                        ║");
        System.out.println("║  ·Los jugadores pueden optar por comprar un seguro si la primera carta visible    ║");
        System.out.println("║   del crupier es un As. Esto protege contra un posible Blackjack del crupier.     ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 8. Doblar:                                                                        ║");
        System.out.println("║  ·Al inicio del turno, algunos casinos permiten a los jugadores doblar su apuesta ║");
        System.out.println("║   después de recibir las dos primeras cartas, pero esto significa que solo pueden ║");
        System.out.println("║   recibir una carta adicional.                                                    ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 9. Dividir:                                                                       ║");
        System.out.println("║  ·Si el jugador recibe dos cartas del mismo valor, puede dividirlas en dos manos  ║");
        System.out.println("║   separadas y jugarlas por separado.                                              ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════╝");
    }
}