package isii.attacks;

import java.util.Random;

import isii.characters.energy.Energy;

public class CharacterWeapon {
	
	private Attack attack1;
	private Attack attack2;
	private Attack attack3;
	
	public CharacterWeapon(Attack attack1, Attack attack2, Attack attack3) {
		this.attack1 = attack1;
		this.attack2 = attack2;
		this.attack3 = attack3;
	}
	
	/**
	 * Metodo que se utiliza para dar comienzo a un ataque
	 * @param ataque
	 * @param numAttack
	 */
	public synchronized void startAttack(Attack ataque, int numAttack, Energy energy) {
		Attack weapon = getAttack(numAttack);
		
		int damage = weapon.getDamage();
		int success = weapon.getSuccess();
		
		if (weapon.getDurability() != null) weapon.countDurability();
		
		int probability = new Random().nextInt(101);
		if (probability <= success) {
			energy.setEnergy(damage, true);
			System.out.println("Ataque exitoso");
		} else {
			System.out.println("Ataque fallido");
		}
	}
	
	/**
	 * Metodo que devuelve uno de los ataques pedidos
	 * @param numAttack
	 * @return
	 * @throws Exception
	 */
	public synchronized Attack getAttack(int numAttack) {
		if (numAttack == 1) return attack1;
		else if (numAttack == 2) return attack2;
		else return attack3;
	}
}
