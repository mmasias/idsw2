package isii.images;

import java.awt.Image;

public class SpriteImage {
	
	private Image image;
	private int x;
	private int y;
	private int width;
	private int height;
	
	/**
	 * Clase que se encarga de las animaciones de los ataques, en 
	 * la que guardo la imagen, sus coordenadas y el tamaño
	 * @param image
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public SpriteImage(Image image, int x, int y, int width, int height) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public SpriteImage withSpriteImage() {
		return new SpriteImage(image, x, y, width, height);
	}
	
}
