package Model;

// Clase que representa la lógica de la inteligencia artificial (IA) del croupier
public class IA {
    // Definición de niveles de dificultad
    public static final int FACIL = 1;
    public static final int NORMAL = 2;
    public static final int EXPERTO = 3;

    // Método que aplica reglas de la IA para tomar decisiones basadas en el nivel de dificultad
    public static int rule(int difficultyLevel, Player croupier) {
        int targetScore;

        // Determinar el puntaje objetivo según el nivel de dificultad
        switch (difficultyLevel) {
            case FACIL:
                targetScore = 19;
                break;
            case NORMAL:
                targetScore = 18;
                break;
            case EXPERTO:
                targetScore = 17;
                break;
            default:
                throw new IllegalArgumentException("❌ Nivel de dificultad no válido");
        }

        // Devolver 2 si el puntaje del croupier es menor o igual al objetivo, de lo contrario, 1
        return (croupier.getScore() <= targetScore) ? 2 : 1;
    }
}