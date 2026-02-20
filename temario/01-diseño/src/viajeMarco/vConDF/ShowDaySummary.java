import java.util.Scanner;

public class ShowDaySummary {
    public void execute(int day, Weather weather, Monkey monkey, double marcoAdvance,
                       double motherAdvance, double remainingDistance) {
        System.out.println("Dia " + day);
        System.out.println(weather.getDescription());
        System.out.println("El mono " + monkey.getDescription());
        System.out.println("Marco avanzo " + (int) marcoAdvance);
        System.out.println("Mamá avanzo " + (int) motherAdvance);
        System.out.println("Queda " + (int) remainingDistance);
        System.out.println("=".repeat(30));
        new Scanner(System.in).nextLine();
    }
}
