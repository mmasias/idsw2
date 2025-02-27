# Temporary Fields

Ocurre cuando ciertos campos de una clase solo se utilizan bajo condiciones específicas. Esto puede hacer que el código sea difícil de entender y mantener, ya que la utilidad de estos campos no es constante a lo largo del ciclo de vida de los objetos, lo que puede llevar a errores si no se manejan cuidadosamente.

## Ejemplo

### Problema


```java

public class BonusCalculator {
    private double salesAmount;
    private int newCustomers;
    private double bonusMultiplier;

    public double calculateBonus(String employeeType, double sales, int customers) {
        if (employeeType.equals("Sales")) {
            salesAmount = sales;
            newCustomers = customers;
            bonusMultiplier = 0.1;
            return salesAmount * bonusMultiplier + newCustomers * 100;
        } else if (employeeType.equals("Development")) {
            bonusMultiplier = 0.15; 
            return sales * bonusMultiplier;
        }
        return 0;
    }
}

```



### Solución propuesta


```java

public class BonusCalculator {

    public double calculateBonus(String employeeType, double sales, int customers) {
        if (employeeType.equals("Sales")) {
            return calculateSalesBonus(sales, customers);
        } else if (employeeType.equals("Development")) {
            return calculateDevelopmentBonus(sales);
        }
        return 0;
    }

    private double calculateSalesBonus(double sales, int customers) {
        double bonusMultiplier = 0.1;
        return sales * bonusMultiplier + customers * 100;
    }

    private double calculateDevelopmentBonus(double sales) {
        double bonusMultiplier = 0.15;
        return sales * bonusMultiplier;
    }
}

```

- **Claridad mejorada**: Al eliminar los campos temporales y usar variables locales, se clarifica cuándo y cómo se usan estos valores, reduciendo la confusión sobre el estado del objeto.
- **Reducción de errores**: Al confinar los datos temporales a un ámbito localizado, se reduce la probabilidad de errores que pueden surgir de un manejo inadecuado de estados inconsistentes o irrelevantes para ciertas operaciones.
- **Facilidad de mantenimiento**: Simplificar el manejo de estado facilita el mantenimiento y la extensión del código, ya que cada método maneja claramente definidos y sus dependencias de datos son transparentes.
