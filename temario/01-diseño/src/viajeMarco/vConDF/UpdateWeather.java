public class UpdateWeather {
    private static final double HARD_RAIN_PROBABILITY = 0.1;
    private static final double SOFT_RAIN_PROBABILITY = 0.4;

    public void execute(Weather weather) {
        double probability = Math.random();

        weather.setHardRain(probability <= HARD_RAIN_PROBABILITY);
        weather.setRain(probability <= SOFT_RAIN_PROBABILITY);

        String description = "Una " +
            (weather.isHardRain() ? "fuerte " : "") +
            (weather.isRain() ? "lluvia " : "mañana soleada");
        weather.setDescription(description);
    }
}
