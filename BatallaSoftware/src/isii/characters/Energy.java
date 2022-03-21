package isii.characters;

import javax.swing.JProgressBar;

public class Energy {
	
	private int energy;
	private JProgressBar energyBar;
	
	public Energy(int energy, JProgressBar bar) {
		this.energy = energy;
		this.energyBar = bar;
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
	
	
	/**
	 * Metodo que sirve para actualizar la vida de un personaje.
	 * En caso de recibir da�o, ponemos el valor reduced a true y significa quitarle el da�o recibido.
	 * En el otro caso de usar poci�n y curarse, ponemos el valor a reduced a false para indicar 
	 * que no se reduce se incrementa la vida.
	 * @param percentLife
	 * @param reduced
	 */
	public synchronized void setEnergy(int percentLife, boolean reduced) {
		if (reduced) {
			new ProgressDamage(this.energy - percentLife, true).start();
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
