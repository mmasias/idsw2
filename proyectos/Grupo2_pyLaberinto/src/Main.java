import java.util.Scanner;

public class Main {

    public static void main(String[] args){
		final Time time = new Time();
		final Sun sun = new Sun();
		final Character characters = new Character();
		final Colors color = new Colors();
		final World world = new World();
		final Position position = new Position();

        Scanner enter = new Scanner(System.in);
		String selection;

		boolean EndGame = false;
		int viewport = 8;


		System.out.print("\033[H\033[2J");
		System.out.flush();

        do {
			time.increaseTime(sun);
		
			System.out.print("\033[0;0H");System.out.flush();	
			
			System.out.print(Colors.BLOCK);
			for(int i=0;i<=viewport*2;i=i+1){
				System.out.print(Colors.BLOCK);
			}
			System.out.println(Colors.BLOCK);
			System.out.print(Colors.BLOCK);

			sun.showSun(time, color);

			System.out.println(Colors.BLOCK);

			System.out.print(Colors.BLOCK);
			for (int i = 0; i <= viewport * 2; i = i + 1) {
				System.out.print(Colors.BLOCK);
			}
			System.out.println(Colors.BLOCK);

            world.showMaze(sun.getBrightness(), viewport);

			System.out.print("Lat:[" + position.getX() + "] Long:[" + position.getY() + "] - ");
			System.out.println("[" + time.getHour() + "]h:[" + time.getMinutes() + "]m     ");
			System.out.println();
			System.out.println("Commands: w/a/s/d (f:exit) (b:boat) (c:horse) (x:Flying carpet)");
			selection = enter.nextLine();

			characters.setChoice(selection);
			if (selection.equalsIgnoreCase("f")) {
				EndGame = true;
			}else{
				characters.move(position, characters,selection);
			}
        } while (!EndGame);
		enter.close();
    }
}
