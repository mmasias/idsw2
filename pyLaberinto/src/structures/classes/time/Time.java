package structures.classes.time;

import java.util.Arrays;
import java.util.Calendar;
//import java.util.Scanner;

public class Time {
    private static int sunArray[] = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int sanArray[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int playerMove = 0;
    private static Calendar day = Calendar.getInstance();

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

    public static int[] moveSan() {
        System.out.println(Arrays.toString(sanArray));
        return sanArray;
    }

    public static void hourPas(int move) {
        playerMove = playerMove + move;
        if (playerMove == 12) {
            playerMove = 0;
            int hourPlus = day.get(Calendar.HOUR_OF_DAY);
            day.set(Calendar.HOUR_OF_DAY, hourPlus + 1);
            day.set(Calendar.MINUTE, 0);
            //	printHour();
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

    public static void printHour() {
        System.out.println("[" + day.get(Calendar.HOUR_OF_DAY) + "]" + "h" + "[" + day.get(Calendar.MINUTE) + "]m");
    }

    public static int setTime() {
        day.set(Calendar.HOUR_OF_DAY, 7);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        //System.out.println(day.get(Calendar.HOUR_OF_DAY) + " " + day.get(Calendar.MINUTE));
        return 0;
    }

    public static void main(String[] args) {
        //System.out.println("Uwi");
        setTime();

        //Scanner en main para fingir interaccion del usuario
        //Scanner myScan = new Scanner(System.in); // Create a Scanner objectw

        //System.out.println("AVANZA Crack");
        //System.out.println(Arrays.toString(sunArray));
        while (true) {
            hourPas(1);
            printHour();
            //		String myScaned = myScan.nextLine(); // Read user input
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //	if (myScaned.equalsIgnoreCase("W")) {


            //		}
        }

    }
}