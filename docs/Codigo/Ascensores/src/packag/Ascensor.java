package packag;

public class Ascensor {

	public int pisoActual;
	public int pisoMax;
	public int pisoMin;
	public int cargaMax;
	public int nAscensor;
	private int movimiento; //-1 bajando, 0 quiero, 1 subiendo
	public int ocupacion;

	 public Ascensor(int n,int pis){
	   this.nAscensor = n;
	   this.pisoActual=pis;
	   this.movimiento=0;
	   this.cargaMax=6;
	   this.pisoMax=6;
	   this.pisoMin=0;
	   this.ocupacion=0;
	   
	 }
	 


	public void subir(){
	 if(pisoActual<pisoMax) {
	  this.movimiento=1;
	 // Time.sleep(1)
	  pisoActual++;
	  this.movimiento=0;
	  
	 }
	  }

	public void bajar(){
	  if(pisoActual>pisoMin) {
	    this.movimiento=-1;
	    //Time.sleep(1)
	    this.pisoActual--;
	    this.movimiento=0;
	  }
	    
	}

	public void irAlPiso(int piso){
	  if(pisoActual!=piso){
	    if (piso>pisoActual){
	      while(piso>pisoActual){
	        subir();
	      }
	    }else if(piso<pisoActual){
	      while(piso<pisoActual){
	        bajar();
	      }}else{System.out.println("error");}}
	    }
	  

	public void abrirPuertas(int salen,int entran){
	  this.ocupacion =this.ocupacion+entran-salen;
	}


	}
