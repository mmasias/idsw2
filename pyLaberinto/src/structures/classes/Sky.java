package structures.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Sky {
    private List<Integer> sky;

    public Sky() {
        this.sky = new ArrayList<Integer>(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }));
    }

    public void showSky(boolean isNightTime) {
        if (isNightTime) {
            IntStream.range(0, this.sky.size() + 4).forEach(el -> System.out.print(Colors.BLUE_BG + "   " + Colors.RESET));
        } else {
            IntStream.range(0, 2).forEach(el -> System.out.print(Colors.BLUE_BG + "   " + Colors.RESET));
            IntStream.range(0, this.sky.size()).forEach(index ->
                    System.out.print(this.sky.get(index) == 0 ? Colors.BLUE_BG + "   " + Colors.RESET: Colors.YELLOW_BG + " O " + Colors.RESET)
            );
            IntStream.range(0, 2).forEach(el -> System.out.print(Colors.BLUE_BG + "   " + Colors.RESET));
        }
        System.out.println();
    }

    public void moveSun() {
        this.sky.add(this.sky.remove(0));
    }
}
