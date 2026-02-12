
public class Boy {

    private double speed;
    private double time;

    private final double MIN_DAILY_SPEED = 10;
    private final double MAX_DAILY_SPEED = 15;

    private final double MIN_DAILY_TIME = 8;
    private final double MAX_DAILY_TIME = 10;

    public void update(Weather weather, Monkey monkey) {
        double speedFactor = weather.isRainingHard() ? 0.25 : weather.isRaining() ? 0.75 : 1;
        speedFactor = speedFactor * (monkey.isTired() ? 0.9 : 1);
        double timeFactor = monkey.hasEscaped() ? 2 : 0;
        speed = (Math.random() * (MAX_DAILY_SPEED - MIN_DAILY_SPEED) + MIN_DAILY_SPEED) * speedFactor;
        time = (Math.random() * (MAX_DAILY_TIME - MIN_DAILY_TIME) + MIN_DAILY_TIME) - timeFactor;
    }

    public double advance() {
        return speed * time;
    }
}
