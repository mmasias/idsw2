
public class Weather {

    private String weatherDescription;
    private boolean rain;
    private boolean hardRain;
    final private double HARD_RAIN_PROBABILITY = 0.1;
    final private double SOFT_RAIN_PROBABILITY = 0.4;

    public void update() {
        double probability = Math.random();

        resetRain();

        hardRain = probability <= HARD_RAIN_PROBABILITY;
        rain = probability <= SOFT_RAIN_PROBABILITY;

        weatherDescription = "Una " + (hardRain ? " fuerte " : "") + (rain ? " lluvia " : " mañana soleada");
    }

    private void resetRain() {
        rain = false;
        hardRain = false;
    }

    public String tellState() {
        return weatherDescription;
    }

    public boolean isRaining() {
        return rain;
    }

    public boolean isRainingHard() {
        return hardRain;
    }
}
