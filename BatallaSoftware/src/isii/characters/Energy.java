package isii.characters;

import javax.swing.JProgressBar;

public class Energy {
	
	private int energy;
	private JProgressBar energyBar;
	
	//TODO Clase en desarrollo, se utilizara para cambiar la vida de mi personaje o del enemigo
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
	
	public void setEnergyBar(int energy) {
		this.getEnergyBar().setValue(energy);
	}
	
	public void setEnergy(int percentLife, boolean reduced) {
		if (reduced) {
			new ProgressDamage(this.energy - percentLife, true).start();
			this.energy = this.energy - percentLife;
		} else {
			new ProgressDamage(this.energy + percentLife, false).start();
			this.energy = this.energy + percentLife;
		}
	}
	
	public class ProgressDamage extends Thread {
		
		private int damageHit;
		private boolean reduced;
		
		public ProgressDamage(int damageHit, boolean reduced) {
			this.damageHit = damageHit;
			this.reduced = reduced;
		}
		
		@Override
		public void run() {
			if (reduced) reducedEnergy();
			else increaseEnergy();
			
		}
		
		private void increaseEnergy() {
			for (int i = energy; i >= damageHit; i++) {
				try { Thread.sleep(10); } catch (InterruptedException e) {}
				setEnergyBar(i);
			}
		}
		
		private void reducedEnergy() {
			for (int i = energy; i <= damageHit; i--) {
				try { Thread.sleep(10); } catch (InterruptedException e) {}
				setEnergyBar(i);
			}
		}
		
	}
	
}
