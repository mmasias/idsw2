package src;

public class Sun {
        private int sky = 0;

        private int[] sun = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0};


		private int brightness = 100;

		public void setBrightness(Time time){
			if (time.getHour() == 4) {
				this.brightness = 3;
			} else if (time.getHour() == 5) {
				this.brightness = 4;
			} else if (time.getHour() == 6) {
				this.brightness = 5;
			} else if (time.getHour() == 7) {
				this.brightness = 100;
			} else if (time.getHour() == 17) {
				this.brightness = 10;
			} else if (time.getHour() == 18) {
				this.brightness = 7;
			} else if (time.getHour() == 19) {
				this.brightness = 5;
			} else if (time.getHour() == 20) {
				this.brightness = 4;
			} else if (time.getHour() == 21) {
				this.brightness = 3;
			}
			else if (time.getHour() == 22) {
				this.brightness = 2;
			}
		}
	
		public int getBrightness() {
			return brightness;
		}
		
        public void showSun (Time time, Colors color) {
            int[] sunArray = this.sun;
				for(this.sky = 0; this.sky < sunArray.length && time.getHour() <= 20; sky++){
					if(sunArray[this.sky] == 0){
						System.out.print(color.SKY);
						
					}
					else if(sunArray[this.sky] == 1 && time.getHour() <= 20 && time.getHour() >= 6 && this.sky >= 0  ){
						System.out.print(color.SUN);
						if(time.getMinutes() == 0){
							if(this.sky < 1 ){
								sunArray = this.sun;
								sunArray[0] = 0;
								sunArray[sunArray.length-1] = 1;
							}
							else {
							sunArray[this.sky-1] = 1;
							sunArray[this.sky] = 0;
						}
						}
					}
				}
        }
}
