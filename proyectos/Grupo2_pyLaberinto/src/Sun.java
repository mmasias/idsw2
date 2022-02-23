package src;

public class Sun {
        static int sky = 0;

        static int[] sun = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0};

        public static void showSun (int hour, int minutes) {
            int[] sunArray = Sun.sun;
				for(sky = 0; sky < sunArray.length && hour <= 20; sky++){
					if(sunArray[sky] == 0){
						System.out.print(Colors.SKY);
						
					}
					else if(sunArray[sky] == 1 && hour <= 20 && hour >= 6 && sky >= 0  ){
						System.out.print(Colors.SUN);
						if(minutes == 0){
							if(sky < 1 ){
								sunArray = Sun.sun;
								sunArray[0] = 0;
								sunArray[sunArray.length-1] = 1;
							}
							else {
							sunArray[sky-1] = 1;
							sunArray[sky] = 0;
						}
						}
					}
				}
        }
}
