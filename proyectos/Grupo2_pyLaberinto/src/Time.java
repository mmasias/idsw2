
public class Time {
    private int hour = 6;
    private int minutes = 6;

    public void increaseTime(Sun sun) {
        this.minutes = this.minutes + 55;
        if (minutes >= 60) {
            this.hour = this.hour + 1;
            this.minutes = 0;
        }
        if (this.hour == 24) {
            this.hour = 0;
        }
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinutes() {
        return this.minutes;
    }
}
