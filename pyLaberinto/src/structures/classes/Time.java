package structures.classes;

import java.util.Calendar;

public class Time {
    private int ticks = 0;
    private Calendar dateTime = Calendar.getInstance();

    public Time() {
        dateTime.set(Calendar.HOUR_OF_DAY, 7);
        dateTime.set(Calendar.MINUTE, 0);
        dateTime.set(Calendar.SECOND, 0);
    }

    public void increaseTime(int tick) {
        this.ticks = this.ticks + tick;
        if (this.ticks == 12) {
            this.ticks = 0;
            this.dateTime.set(Calendar.HOUR_OF_DAY, this.dateTime.get(Calendar.HOUR_OF_DAY) + 1);
            this.dateTime.set(Calendar.MINUTE, 0);
        } else {
            this.dateTime.set(Calendar.MINUTE, this.dateTime.get(Calendar.MINUTE) + 5);
        }
    }

    public void showTime() {
        System.out.println("[" + dateTime.get(Calendar.HOUR_OF_DAY) + "]" + "h" + "[" + dateTime.get(Calendar.MINUTE) + "]m");
    }

    public boolean isNightTime() {
        return this.dateTime.get(Calendar.HOUR_OF_DAY) > 19 || this.dateTime.get(Calendar.HOUR_OF_DAY) < 7;
    }

    public boolean isVisionReduced() {
        return this.dateTime.get(Calendar.HOUR_OF_DAY) > 17 || this.dateTime.get(Calendar.HOUR_OF_DAY) < 9;
    }

    public int getTicks() {
        return ticks;
    }
}