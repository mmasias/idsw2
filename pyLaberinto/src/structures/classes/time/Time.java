package structures.classes.time;

import java.util.Arrays;
import java.util.Calendar;

public class Time {
    private static int sunArray[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    private static int sanArray[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int playerMove = 0;
    private static Calendar day = Calendar.getInstance();

    // function that moves the sun one to the left
    public static int[] moveSun() {
        int i, save, length = 13;
        save = sunArray[0];
        for (i = 0; i < length - 1; i++) {
            sunArray[i] = sunArray[i + 1];
        }
        sunArray[i] = save;
        System.out.println(Arrays.toString(sunArray));
        return sunArray;
    }

    // function that shows the array of no sun
    public static int[] moveSan() {
        System.out.println(Arrays.toString(sanArray));
        return sanArray;
    }

    //function that receives move of player and adds the time passed
    // moves the sun if an hour has passed
    public static void hourPas(int move) {
        playerMove = playerMove + move;
        if (playerMove == 12) {
            playerMove = 0;
            int hourPlus = day.get(Calendar.HOUR_OF_DAY);
            day.set(Calendar.HOUR_OF_DAY, hourPlus + 1);
            day.set(Calendar.MINUTE, 0);
            if (day.get(Calendar.HOUR_OF_DAY) > 19 || day.get(Calendar.HOUR_OF_DAY) < 7) {
                moveSan();
            } else {
                moveSun();
            }
        } else {
            int minutePlus = day.get(Calendar.MINUTE);
            day.set(Calendar.MINUTE, minutePlus + 5);
            //	printHour();
            if (day.get(Calendar.HOUR_OF_DAY) > 19 || day.get(Calendar.HOUR_OF_DAY) < 7) {
                System.out.println(Arrays.toString(sanArray));
            } else {
                System.out.println(Arrays.toString(sunArray));
            }
        }

    }

    // function that prints the actual hours and minutes of the day
    public static void printHour() {
        System.out.println("[" + day.get(Calendar.HOUR_OF_DAY) + "]" + "h" + "[" + day.get(Calendar.MINUTE) + "]m");
    }

    //function to set the initial time
    public static int setTime() {
        day.set(Calendar.HOUR_OF_DAY, 7);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        return 0;
    }

    //main to test the rest of the functions
    public static void main(String[] args) {
        setTime();
        while (true) {
            hourPas(1);
            printHour();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}