public class UpdateBoy {
    private static final double MIN_DAILY_SPEED = 10;
    private static final double MAX_DAILY_SPEED = 15;
    private static final double MIN_DAILY_TIME = 8;
    private static final double MAX_DAILY_TIME = 10;

    public void execute(Boy boy, Weather weather, Monkey monkey) {
        double speedFactor = weather.isHardRain() ? 0.25 :
                           weather.isRain() ? 0.75 : 1;
        speedFactor = speedFactor * (monkey.isTired() ? 0.9 : 1);

        double timeFactor = monkey.hasEscaped() ? 2 : 0;

        double speed = (Math.random() * (MAX_DAILY_SPEED - MIN_DAILY_SPEED) +
                     MIN_DAILY_SPEED) * speedFactor;
        double time = (Math.random() * (MAX_DAILY_TIME - MIN_DAILY_TIME) +
                     MIN_DAILY_TIME) - timeFactor;

        boy.setSpeed(speed);
        boy.setTime(time);
    }
}
