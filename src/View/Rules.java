package View;

public class Rules {
    public void showRulesBlackJack() {
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

    public void showRulesPoker() {
        // Reglas del juego
        System.out.println();
        System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                             === Reglas del Poker ===                              ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Objetivo del juego:                                                            ║");
        System.out.println("║  ·El objetivo del Texas Hold'em es formar la mejor mano de cinco cartas posible,  ║");
        System.out.println("║   combinando las cartas comunitarias y las cartas privadas.                       ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 2. Reparto de Cartas:                                                             ║");
        System.out.println("║  ·Cada jugador recibe dos cartas privadas (conocidas como cartas \"Hole\").       ║");
        System.out.println("║  ·Se reparten cinco cartas comunitarias en el centro de la mesa en tres fases     ║");
        System.out.println("║   (Flop, Turn y River).                                                           ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 3. Rondas de Apuestas:                                                            ║");
        System.out.println("║  ·Antes del Flop, cada jugador realiza una apuesta inicial obligatoria conocida   ║");
        System.out.println("║   como \"Big Blind\" y \"Small Blind\".                                           ║");
        System.out.println("║  ·Después de recibir las cartas iniciales, comienza la primera ronda de apuestas. ║");
        System.out.println("║  ·Tras el Flop, Turn y River, hay rondas adicionales de apuestas.                 ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 4. Combinación de Cartas:                                                         ║");
        System.out.println("║  ·El jugador decide si pide más cartas (hit) o se planta (stand).                 ║");
        System.out.println("║  ·Puede seguir pidiendo cartas hasta que se planta, obtiene 21 (Blackjack) o      ║");
        System.out.println("║   se pasa de 21.                                                                  ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 5. Fases de Apuestas::                                                            ║");
        System.out.println("║  ·Pre-Flop: Apuestas iniciales después de recibir las cartas privadas.            ║");
        System.out.println("║  ·Flop: Se revelan tres cartas comunitarias.                                      ║");
        System.out.println("║  ·Turn: Se revela una cuarta carta comunitaria.                                   ║");
        System.out.println("║  ·River: Se revela la quinta y última carta comunitaria.                          ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 6. Showdown:                                                                      ║");
        System.out.println("║  ·Si quedan dos o más jugadores después de la última ronda de apuestas,           ║");
        System.out.println("║   se produce el Showdown.                                                         ║");
        System.out.println("║  ·El jugador con la mejor mano gana el bote.                                      ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 7. Manos Ganadoras:                                                               ║");
        System.out.println("║  ·Las manos se clasifican según la jerarquía estándar del póker                   ║");
        System.out.println("║   (par, doble par, trío, escalera, color, etc.).                                  ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 8. Rankings de manos:                                                             ║");
        System.out.println("║  ·Par: Dos cartas del mismo rango.                                                ║");
        System.out.println("║  ·Doble Par: Dos pares de cartas.                                                 ║");
        System.out.println("║  ·Trío: Tres cartas del mismo rango.                                              ║");
        System.out.println("║  ·Escalera: Cinco cartas consecutivas de diferentes palos.                        ║");
        System.out.println("║  ·Color: Cinco cartas del mismo palo.                                             ║");
        System.out.println("║  ·Póker: Cuatro cartas del mismo rango.                                           ║");
        System.out.println("║  ·Escalera de Color: Una escalera de cinco cartas del mismo palo.                 ║");
        System.out.println("║  ·Escalera Real: La mejor escalera de color desde 10 hasta As.                    ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 9. Ganador del Bote:                                                              ║");
        System.out.println("║  ·SEl jugador con la mejor mano en el Showdown gana el bote. Si hay empate,       ║");
        System.out.println("║   el bote se divide entre los jugadores empatados.                                ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════╝");

    }
}