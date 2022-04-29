package isii.characters.energy;

public class Energy {
	
	private int energy;
	private final int maxEnergy;
	private int limitEnergy;
	private boolean characterDefend;
	
	public Energy(int energy, int limitEnergy) {
		this.energy = energy;
		this.maxEnergy = energy;
		this.limitEnergy = limitEnergy;
		this.characterDefend = false;
	}
	
	public int getEnergy() {
		return this.energy;
	}
	
	public int getMaxEnergy() {
		return this.maxEnergy;
	}
	
	public synchronized boolean isFainting() {
		return getEnergy() <= this.limitEnergy ? true : false;
	}
	
	public boolean isDead() {
		if (getEnergy() <= 0) return true;
		else return false;
	}
	
	public void setCharacterDefend(boolean characterDefend) {
		this.characterDefend = characterDefend;
	}
	
	/**
	 * Metodo que sirve para actualizar la vida de un personaje.
	 * En caso de recibir daño, ponemos el valor reduced a true y significa quitarle el daño recibido.
	 * En el otro caso de usar poción y curarse, ponemos el valor a reduced a false para indicar 
	 * que no se reduce se incrementa la vida.
	 * @param percentLife
	 * @param reduced
	 */
	public synchronized void setEnergy(int percentLife, boolean reduced) {
		if (reduced) {
			this.energy = characterDefend ? (this.energy - percentLife) - 5 : this.energy - percentLife;
			setCharacterDefend(false);
		} else {
			this.energy = this.energy + percentLife;
			if (this.energy > this.maxEnergy) this.energy = this.maxEnergy;
		}
	}
	
}
