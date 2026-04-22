package DOO.DD.DD01.v002extensible;

public class Zoologico {
    public static void main(String[] args) {
        // Usando el patrón Visitor completo
        Cuidador cuidador = new Cuidador();
        Veterinario veterinario = new Veterinario();
        
        Animal perro = new Perro();
        Animal pajaro = new Pajaro();
        
        System.out.println("Cuidando al perro");
        perro.respirar();
        perro.moverse();
        perro.comunicarse();
        cuidador.cuidar(perro);
        
        System.out.println("Examinando al perro");
        veterinario.examinar(perro);
        
        System.out.println("Cuidando al pájaro");
        pajaro.respirar();
        pajaro.moverse();
        pajaro.comunicarse();
        cuidador.cuidar(pajaro);
        
        System.out.println("Examinando al pájaro");
        veterinario.examinar(pajaro);
    }
}