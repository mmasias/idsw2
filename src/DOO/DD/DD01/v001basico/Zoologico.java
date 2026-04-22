package DOO.DD.DD01.v001basico;

public class Zoologico {
    public static void main(String[] args) {
        // Usando doble despacho básico
        Cuidador cuidador = new Cuidador();
        
        Animal perro = new Perro();
        Animal pajaro = new Pajaro();
        
        System.out.println("Cuidando al perro");
        //perro.respirar();
        //perro.moverse();
        //perro.comunicarse();
        //cuidador.alimentar(perro);
        rutinaDiaria(perro, cuidador);
        
        System.out.println("Cuidando al pájaro");
        //pajaro.respirar();
        //pajaro.moverse();
        //pajaro.comunicarse();
        //cuidador.alimentar(pajaro);
        rutinaDiaria(pajaro, cuidador);

    }

    static void rutinaDiaria(Animal animal, Cuidador cuidador){
        animal.respirar();
        animal.moverse();
        animal.comunicarse();
        cuidador.alimentar(animal);
    }
}