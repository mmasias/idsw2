package isii.ataques;

public class Ataque {
	
	private int daño;
	private int exito;
	
	public Ataque(int daño, int exito) {
		this.daño = daño;
		this.exito = exito;
	}
	
	public int getDaño() {
		return daño;
	}
	
	public int getExito() {
		return exito;
	}
}
