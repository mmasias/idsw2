package src;

public class Time {
    private int hour = 6;
    private int minutes = 6;

    public void increaseTime(Sun sun){
        this.minutes = this.minutes + 55;
        if (minutes >= 60) {
            this.hour = this.hour + 1;
            this.minutes = 0;
        }
            if (this.hour==24){this.hour=0;}

        if (this.hour == 4) {
            sun.setBrightness(3);
        } else if (this.hour == 5) {
            sun.setBrightness(4);
        } else if (this.hour == 6) {
            sun.setBrightness(5);
        } else if (this.hour == 7) {
            sun.setBrightness(100);
        } else if (this.hour == 17) {
            sun.setBrightness(10);
        } else if (this.hour == 18) {
            sun.setBrightness(7);
        } else if (this.hour == 19) {
            sun.setBrightness(5);
        } else if (this.hour == 20) {
            sun.setBrightness(4);
        } else if (this.hour == 21) {
            sun.setBrightness(3);
        }
        else if (this.hour == 22) {
            sun.setBrightness(2);
        }
    }

    public int getHour(){
        return this.hour;
    }

    public int getMinutes(){
        return this.minutes;
    }
}
