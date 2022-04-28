package packag;

import java.util.ArrayList;

public class Edificio {

	public Planta[] plantas ;
	public Ascensor[] ascensores ;
	
	public Edificio() {
		Planta[] plantas = new Planta[5];
		plantas[0] = new Planta(0);
		plantas[1] = new Planta(1);
		plantas[2] = new Planta(2);
		plantas[3] = new Planta(3);
		plantas[4] = new Planta(4);
		Ascensor[] ascensores = new Ascensor[4];
		ascensores[0] = new Ascensor(1,0);
		ascensores[1] = new Ascensor(2,0);
		ascensores[2] = new Ascensor(3,0);
		ascensores[3] = new Ascensor(4,0);
		this.plantas = plantas;
		this.ascensores = ascensores;
		generarPersonas();
	}
	
	public void generarPersonas() {
		for(int i=0;i<10;i++) {
		 Persona p = new Persona();
		 p.start();
		 
		 esperar(4);
		}
	}
	
	 public void esperar (int segundos) {
   	  try {
   	  Thread.sleep (segundos*1000);
   	  } catch (Exception e) {
   	  // Mensaje en caso de que falle
   	  }
   	  }
	
}
