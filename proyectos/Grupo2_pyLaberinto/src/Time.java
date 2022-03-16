package src;

public class Time {
    private int hour = 6;
    private int minutes = 6;

    public void avanzarHora(Torch torch){
        this.minutes = this.minutes + 55;
        if (minutes >= 60) {
            this.hour = this.hour + 1;
            this.minutes = 0;
        }
            if (this.hour==24){this.hour=0;}

        if (this.hour == 4) {
            torch.setBrightness(3);
        } else if (this.hour == 5) {
            torch.setBrightness(4);
        } else if (this.hour == 6) {
            torch.setBrightness(5);
        } else if (this.hour == 7) {
            torch.setBrightness(100);
        } else if (this.hour == 17) {
            torch.setBrightness(10);
        } else if (this.hour == 18) {
            torch.setBrightness(7);
        } else if (this.hour == 19) {
            torch.setBrightness(5);
        } else if (this.hour == 20) {
            torch.setBrightness(4);
        } else if (this.hour == 21) {
            torch.setBrightness(3);
        }
        else if (this.hour == 22) {
            torch.setBrightness(2);
        }
    }

    public int getHour(){
        return this.hour;
    }

    public int getMinutes(){
        return this.minutes;
    }
}
