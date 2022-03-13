package isii.personajes;

import isii.ataques.ArmaHeroina;
import isii.ataques.Ataque;

public class Heroina implements Personaje<ArmaHeroina>{
	
	public ArmaHeroina arma1;
	public ArmaHeroina arma2;
	public ArmaHeroina arma3;
	
	public Heroina(Ataque ataque1, Ataque ataque2, Ataque ataque3) {
		this.arma1 = new ArmaHeroina(ataque1.getDaño(), ataque1.getExito());
		this.arma2 = new ArmaHeroina(ataque2.getDaño(), ataque2.getExito());
		this.arma3 = new ArmaHeroina(ataque3.getDaño(), ataque3.getExito());
	}
	
	@Override
	public void Ataque(ArmaHeroina ataque) {
		// TODO Sí se realiza con exito el ataque, quitar vida Vampiresa
	}

	public ArmaHeroina getArma1() {
		return arma1;
	}
	
	public ArmaHeroina getArma2() {
		return arma2;
	}
	
	public ArmaHeroina getArma3() {
		return arma3;
	}
}
