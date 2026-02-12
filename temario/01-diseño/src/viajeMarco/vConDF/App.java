public class App {
    public static void main(String[] args) {
        final int INITIAL_DISTANCE = 350;
        ProcessJourney process = new ProcessJourney(INITIAL_DISTANCE);
        process.execute();
    }
}
