package structures.classes.time;

import java.util.Calendar;
import java.util.stream.IntStream;

import structures.classes.Colors;

public class Time {
    private int sunArray[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };
    private int playerMove = 0;
    private Calendar day = Calendar.getInstance();

    public Time() {
        this.setTime();
    }

    private void moveSun() {
        int i, save;
        save = this.sunArray[0];
        for (i = 0; i < sunArray.length - 1; i++) {
            this.sunArray[i] = this.sunArray[i + 1];
        }
        this.sunArray[i] = save;
    }

    public void showSky() {
        if (this.isNightTime()) {
            IntStream.range(0, 17).forEach(el -> System.out.print(Colors.BLUE_BG + "   " + Colors.RESET));
        } else {
            IntStream.range(0, 2).forEach(el -> System.out.print(Colors.BLUE_BG + "   " + Colors.RESET));
            IntStream.range(0, this.sunArray.length).forEach(index -> System.out.print(
                    this.sunArray[index] == 0 ? Colors.BLUE_BG + "   " + Colors.RESET
                            : Colors.YELLOW_BG + " O " + Colors.RESET));
            IntStream.range(0, 2).forEach(el -> System.out.print(Colors.BLUE_BG + "   " + Colors.RESET));
        }
        System.out.println();
    }

    public void increaseTime(int move) {
        this.playerMove = this.playerMove + move;
        if (this.playerMove == 12) {
            this.playerMove = 0;
            int currentHour = this.day.get(Calendar.HOUR_OF_DAY);
            this.day.set(Calendar.HOUR_OF_DAY, currentHour + 1);
            this.day.set(Calendar.MINUTE, 0);
            if (!isNightTime())
                this.moveSun();
        } else {
            int currentMinute = this.day.get(Calendar.MINUTE);
            this.day.set(Calendar.MINUTE, currentMinute + 5);
        }
    }

    public void showTime() {
        System.out.println("[" + day.get(Calendar.HOUR_OF_DAY) + "]" + "h" + "[" + day.get(Calendar.MINUTE) + "]m");
    }

    public boolean isNightTime() {
        return this.day.get(Calendar.HOUR_OF_DAY) > 19 || this.day.get(Calendar.HOUR_OF_DAY) < 7;
    }

    public boolean isVisionReduced() {
        return this.day.get(Calendar.HOUR_OF_DAY) > 17 || this.day.get(Calendar.HOUR_OF_DAY) < 9;
    }

    private void setTime() {
        day.set(Calendar.HOUR_OF_DAY, 7);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
    }
}