public class ProcessJourney {
    private final double initialDistance;
    private double remainingDistance;
    private int days;
    private boolean onJourney;

    private UpdateWeather updateWeather;
    private UpdateMonkey updateMonkey;
    private UpdateBoy updateBoy;
    private CalculateMarcoAdvance calculateMarcoAdvance;
    private CalculateMotherAdvance calculateMotherAdvance;
    private ShowDaySummary showDaySummary;

    private Weather weather;
    private Monkey monkey;
    private Boy boy;
    private Mother mother;

    public ProcessJourney(int initialDistance) {
        this.initialDistance = initialDistance;
        this.remainingDistance = initialDistance;
        this.days = 0;
        this.onJourney = this.initialDistance > 0;

        updateWeather = new UpdateWeather();
        updateMonkey = new UpdateMonkey();
        updateBoy = new UpdateBoy();
        calculateMarcoAdvance = new CalculateMarcoAdvance();
        calculateMotherAdvance = new CalculateMotherAdvance();
        showDaySummary = new ShowDaySummary();

        weather = new Weather();
        monkey = new Monkey();
        boy = new Boy();
        mother = new Mother(80);
    }

    public void execute() {
        while (onJourney) {
            days++;

            updateWeather.execute(weather);
            updateMonkey.execute(monkey);
            updateBoy.execute(boy, weather, monkey);

            double marcoAdvance = calculateMarcoAdvance.execute(boy);
            double motherAdvance = calculateMotherAdvance.execute(mother);

            remainingDistance = remainingDistance - marcoAdvance + motherAdvance;
            onJourney = remainingDistance >= 0;

            showDaySummary.execute(days, weather, monkey, marcoAdvance, motherAdvance, remainingDistance);
        }
    }
}
