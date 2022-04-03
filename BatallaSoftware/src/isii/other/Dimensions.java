package isii.other;

public class Dimensions {
	private static int heroineX = 1000, heroineY = 120, heroineWidth = 400, heroineHeight = 400;
	private static int enemy1X = 520, enemy1Y = 120, enemy1Width = 400, enemy1Height = 400;
	private static int enemy2X = 520 - 100, enemy2Y = 120 - 100, enemy2Width = 400, enemy2Height = 400;
	private static int enemy3X = 520 - 100, enemy3Y = 120 + 100, enemy3Width = 400, enemy3Height = 400;
	
	public static Dimension heroineDimension() {
		return new Dimension(heroineX, heroineY, heroineWidth, heroineHeight);
	}
	
	public static Dimension enemy1Dimension() {
		return new Dimension(enemy1X, enemy1Y, enemy1Width, enemy1Height);
	}
	
	public static Dimension enemy2Dimension() {
		return new Dimension(enemy2X, enemy2Y, enemy2Width, enemy2Height);
	}
	
	public static Dimension enemy3Dimension() {
		return new Dimension(enemy3X, enemy3Y, enemy3Width, enemy3Height);
	}
	
}
