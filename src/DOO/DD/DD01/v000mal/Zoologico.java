package DOO.DD.DD01.v000mal;

public class Zoologico {
    public static void main(String[] args) {
        // Usando el sistema con instanceof
        Cuidador cuidador = new Cuidador();
        
        Animal perro = new Animal("Perro");
        Animal pajaro = new Animal("Pajaro");
        
        System.out.println("Cuidando al perro");
        perro.moverse();
        perro.comunicarse();
        cuidador.alimentar(perro);
        
        System.out.println("Cuidando al pájaro");
        pajaro.moverse();
        pajaro.comunicarse();
        cuidador.alimentar(pajaro);
    }
}