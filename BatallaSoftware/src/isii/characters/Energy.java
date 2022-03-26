package isii.characters;

import javax.swing.JProgressBar;

public class Energy {
	
	private int energy;
	private int limitEnergy;
	private JProgressBar energyBar;
	private boolean energyFinished;
	private boolean characterDefend;
	
	public Energy(int energy, int limitEnergy, JProgressBar bar) {
		this.energy = energy;
		this.limitEnergy = limitEnergy;
		this.energyBar = bar;
		this.energyFinished = true;
		this.characterDefend = false;
	}
	
	public boolean isEnergyFinished() {
		return energyFinished;
	}

	public void setEnergyFinished(boolean energyFinished) {
		this.energyFinished = energyFinished;
	}

	public JProgressBar getEnergyBar() {
		return this.energyBar;
	}
	
	public int getEnergy() {
		return this.energy;
	}
	
	private void setEnergyBar(int energy) {
		this.getEnergyBar().setValue(energy);
	}
	
	public boolean isFainting() {
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
			new ProgressDamage(characterDefend ? (this.energy - percentLife) - 5 : this.energy - percentLife, true).start();
			setCharacterDefend(false);
		} else {
			new ProgressDamage(this.energy + percentLife, false).start();
		}
	}
	
	private class ProgressDamage extends Thread {
		
		private int damageHit;
		private boolean reduced;
		
		public ProgressDamage(int damageHit, boolean reduced) {
			this.damageHit = damageHit;
			this.reduced = reduced;
		}
		
		@Override
		public synchronized void run() {
			if (reduced) reducedEnergy();
			else increaseEnergy();
			energy = getEnergyBar().getValue();
			setEnergyFinished(true);
		}
		
		private synchronized void increaseEnergy() {
			for (int i = energy; i <= damageHit; i++) {
				try { Thread.sleep(20); } catch (InterruptedException e) {}
				setEnergyBar(i);
			}
		}
		
		private synchronized void reducedEnergy() {
			for (int i = energy; i >= damageHit; i--) {
				try { Thread.sleep(20); } catch (InterruptedException e) {}
				setEnergyBar(i);
			}
		}
		
	}
	
}
