import java.util.Scanner;

public class Journey {

    private final double INITIAL_DISTANCE;
    private final double MOTHER_ADVANCE_PER_DAY = 80;
    private double remainingDistance;
    private int days;
    private boolean onJourney;

    private Mother mother;
    private Weather weather;
    private Monkey amedio;
    private Boy marco;
    
    public Journey(int initialDistance) {
        INITIAL_DISTANCE = initialDistance;
        onJourney = this.INITIAL_DISTANCE > 0;
        remainingDistance = INITIAL_DISTANCE;
        days = 0;
        mother = new Mother(MOTHER_ADVANCE_PER_DAY);
        weather = new Weather();
        amedio = new Monkey();
        marco = new Boy();
    }

    public void start() {
        while (onJourney) {
            days++;
            weather.update();
            amedio.update();
            marco.update(weather, amedio);
            remainingDistance = remainingDistance - marco.advance() + mother.advance();
            onJourney = remainingDistance >= 0;
            displayDaySumary();
        }
    }

    private void displayDaySumary() {
        System.out.println("Dia " + days);
        System.out.println(weather.tellState());
        System.out.println("El mono " + amedio.tellState());
        System.out.println("Marco avanzo " + (int) marco.advance());
        System.out.println("Mamá avanzo " + (int) mother.advance());
        System.out.println("Queda " + (int) remainingDistance);
        System.out.println("=".repeat(30));
        new Scanner(System.in).nextLine();
    }
}
