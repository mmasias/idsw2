public class EjemploHerenciaExtension {
    public static void main(String[] args) {
        // Creamos una cuenta regular
        Cuenta cuentaNormal = new Cuenta();
        cuentaNormal.depositar(1000);
        System.out.println("Cuenta normal - Saldo inicial: " + cuentaNormal.getSaldo());
        
        // Realizamos operaciones básicas
        boolean retiroExitoso = cuentaNormal.retirar(300);
        System.out.println("Retiro de 300: " + (retiroExitoso ? "Exitoso" : "Fallido"));
        System.out.println("Cuenta normal - Saldo después del retiro: " + cuentaNormal.getSaldo());
        
        // Creamos una cuenta remunerada con tasa de interés
        CuentaRemunerada cuentaPremium = new CuentaRemunerada(0.05); // 5% de interés
        cuentaPremium.depositar(1000);
        System.out.println("\nCuenta remunerada - Saldo inicial: " + cuentaPremium.getSaldo());
        
        // Realizamos las mismas operaciones básicas (heredadas)
        retiroExitoso = cuentaPremium.retirar(300);
        System.out.println("Retiro de 300: " + (retiroExitoso ? "Exitoso" : "Fallido"));
        System.out.println("Cuenta remunerada - Saldo después del retiro: " + cuentaPremium.getSaldo());
        
        // Aplicamos interés (método adicional de la subclase)
        cuentaPremium.aplicarInteres();
        System.out.println("Aplicando interés del 5%...");
        System.out.println("Cuenta remunerada - Saldo después de aplicar interés: " + 
                         cuentaPremium.getSaldo());
        
        // Intentamos un retiro que exceda el saldo
        System.out.println("\nIntentando retirar 800 de la cuenta remunerada (saldo actual: " + 
                          cuentaPremium.getSaldo() + ")");
        retiroExitoso = cuentaPremium.retirar(800);
        System.out.println("Retiro de 800: " + (retiroExitoso ? "Exitoso" : "Fallido"));
        System.out.println("Cuenta remunerada - Saldo final: " + cuentaPremium.getSaldo());
    }
}

class Cuenta {
    protected double saldo;
    
    public Cuenta() {
        this.saldo = 0;
    }
    
    public void depositar(double monto) {
        if (monto > 0) {
            saldo = saldo + monto;
        }
    }
    
    public boolean retirar(double monto) {
        if (monto <= saldo) {
            saldo = saldo - monto;
            return true;
        }
        return false;
    }
    
    public double getSaldo() {
        return saldo;
    }
}

class CuentaRemunerada extends Cuenta {
    private double tasaInteres;
    
    public CuentaRemunerada(double tasaInteres) {
        super(); // Llama al constructor de la clase padre
        this.tasaInteres = tasaInteres;
    }
    
    // Método adicional específico de esta subclase
    public void aplicarInteres() {
        double interes = saldo * tasaInteres;
        depositar(interes); // Reutiliza el método heredado
    }
    
    // También podríamos sobrescribir métodos de la clase padre si fuera necesario
}