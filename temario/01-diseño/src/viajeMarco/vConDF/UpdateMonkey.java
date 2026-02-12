public class UpdateMonkey {
    private static final double MONKEY_TIRED_PROBABILITY = 0.25;
    private static final double MONKEY_ESCAPE_PROBABILITY = 0.15;

    public void execute(Monkey monkey) {
        boolean isTired = Math.random() <= MONKEY_TIRED_PROBABILITY;
        boolean hasEscaped = Math.random() <= MONKEY_ESCAPE_PROBABILITY;

        monkey.setTired(isTired);
        monkey.setEscaped(hasEscaped);

        String description = (isTired ? "Se cansó " : "No se cansó ") +
                          (hasEscaped ? "Se escapó" : "No se escapó");
        monkey.setDescription(description);
    }
}
