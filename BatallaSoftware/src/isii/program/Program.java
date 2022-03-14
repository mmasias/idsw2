package isii.program;

import isii.ataques.Ataque;
import isii.personajes.Heroina;
import isii.personajes.Vampiresa;

public class Program {
	
	//Clase de practicas, no se utiliza
	@SuppressWarnings("unused") //TODO Quitar en el futuro
	public static void main(String[] args) {
		Heroina heroina = new Heroina(new Ataque(7, 50), new Ataque(15, 25), new Ataque(30, 12));
		Vampiresa vampiresa = new Vampiresa(new Ataque(5, 90), new Ataque(10, 60), new Ataque(20, 40));
		int turno = 0;
		while (true) { //Empieza la batalla
			turno += 1;
		}
	}

}
