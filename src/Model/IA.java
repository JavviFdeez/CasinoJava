package Model;

public class IA {
    public static final int FACIL = 1;
    public static final int NORMAL = 2;
    public static final int EXPERTO = 3;

    public static int decide(int difficultyLevel, Player croupier) {
        int targetScore;

        switch (difficultyLevel) {
            case FACIL:
                targetScore = 17;
                break;
            case NORMAL:
                targetScore = 18;
                break;
            case EXPERTO:
                targetScore = 19;
                break;
            default:
                throw new IllegalArgumentException("Nivel de dificultad no válido");
        }

        return (croupier.getScore() < targetScore) ? 2 : 1;
    }
}