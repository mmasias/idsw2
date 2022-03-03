package isii.personajes;

import isii.ataques.Ataque;
import isii.ataques.AtaqueVampiresa;

public class Vampiresa implements Personaje<AtaqueVampiresa>{
	
	private AtaqueVampiresa ataque1;
	private AtaqueVampiresa ataque2;
	private AtaqueVampiresa ataque3;
	
	public Vampiresa(Ataque ataque1, Ataque ataque2, Ataque ataque3) {
		this.ataque1 = new AtaqueVampiresa(ataque1.getDaño(), ataque1.getExito());
		this.ataque2 = new AtaqueVampiresa(ataque1.getDaño(), ataque1.getExito());
		this.ataque3 = new AtaqueVampiresa(ataque1.getDaño(), ataque1.getExito());
	}
	@Override
	public void Ataque(AtaqueVampiresa ataque) {
		// TODO Sí el ataque se realiza con exito quitar vida a Heroina, siempre que no este protegida
	}
	
	public AtaqueVampiresa getAtaque1() {
		return ataque1;
	}
	
	public AtaqueVampiresa getAtaque2() {
		return ataque2;
	}
	
	public AtaqueVampiresa getAtaque3() {
		return ataque3;
	}

}
