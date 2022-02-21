package structures.classes.time;

import java.util.Date;

public class Time {
    private int sunArray[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0};
    private Date time;
    private int playerMove = 0;


    public static void main(String args[]) {
        Calendar day = Calendar.getInstance();
        day.set(Calendar.MILLISECOND, 0);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.HOUR_OF_DAY, 0);
        System.out.println(day.getTime());
    }

    Date d = cal.getTime();

    public int[] moveSun(){
        if (hourPas(1)){
            int save,length=17;
            save=sunArray[0];
            for(int i=0;i<length-1;i++)
            {
                sunArray[i]=sunArray[i+1];
            }
            sunArray[i] =save;
        }
        return sunArray;
    }

    public boolean hourPas(int move){
        acumMove = acumMove + move;
        if (acumMove == 12){
            acumMove = 0;
            return true;
        } else {
            return false;
        }
    }

    public int countTime(){

        return 0;
    }

}

// constructor de time que implemente eso
// método de incremento de tiempo junto con el sol si cambia de hora