package isii.ataques;

public class ArmaHeroina extends AtaqueVampiresa{
	
	protected int durabilidad;
	
	public ArmaHeroina(int daño, int exito) {
		super(daño, exito);
		durabilidad = 100;
	}
}
