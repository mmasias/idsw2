
```java
public class Empleado {
  private String nombre;
  private int edad;
  private String direccion;
  private String departamento;
  private static final double SALARIO_BASE = 1000.0;
  private static final double BONO_DEPARTAMENTO = 200.0;

  // Constructor y getters/setters omitidos por brevedad

  // Método que devuelve la información personal del empleado
  public String getInfoPersonal() {
    return "Nombre: " + nombre + ", Edad: " + edad + ", Dirección: " + direccion + ", Departamento: " + departamento;
  }

  public double calcularSalario() {
    double salario = SALARIO_BASE;

    if(departamento.equals("Ventas")) {
      salario += BONO_DEPARTAMENTO;
    }

    return salario;
  }
}
```

---

```java
// Clase Empleado que se encarga de la gestión de la información personal del empleado
public class Empleado {
  private String nombre;
  private int edad;
  private String direccion;
  private String departamento;

  // Constructor y getters/setters omitidos por brevedad

  // Método que devuelve la información personal del empleado
  public String getInfoPersonal() {
    return "Nombre: " + nombre + ", Edad: " + edad + ", Dirección: " + direccion + ", Departamento: " + departamento;
  }
}

public class CalculadoraSalario {
  private static final double SALARIO_BASE = 1000.0;
  private static final double BONO_DEPARTAMENTO = 200.0;

  public static double calcularSalario(Empleado empleado) {
    double salario = SALARIO_BASE;

    if(empleado.getDepartamento().equals("Ventas")) {
      salario += BONO_DEPARTAMENTO;
    }

    return salario;
  }
}
```