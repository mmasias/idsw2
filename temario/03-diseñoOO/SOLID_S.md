# Principio de responsabilidad única (SRP)

SRP es una aplicación de la [alta cohesión funcional](../02-diseñoModular/cohesion.md) al diseño orientado a objetos.

## ¿Por qué?

```java
class Empleado {
    private String nombre;
    private String departamento;
    private double salarioBase;

    public String getInfoPersonal() {
        return nombre + " - " + departamento;
    }

    public double calcularSalario() {
        if (departamento.equals("Ventas"))
            return salarioBase + 200;
        return salarioBase;
    }

    public void guardarEnBaseDeDatos() {
        // conexión a BD, INSERT, manejo de errores...
    }
}
```

Esta clase puede cambiar por tres razones distintas: RR.HH. modifica los datos que se almacenan del empleado, Contabilidad cambia las reglas del salario, IT migra la base de datos. Tres grupos de personas, tres motivos de cambio independientes sobre un mismo fichero. Un cambio en la lógica de nómina obliga a tocar la misma clase que persiste datos, arriesgando romper algo que no tenía por qué cambiar.

## ¿Qué?

Una clase debe tener una sola razón para cambiar.

"Razón para cambiar" no significa funcionalidad ni tema. Significa **actor**: el grupo de personas o el área del sistema que origina ese cambio. Una clase viola el SRP cuando dos actores distintos pueden pedir que se modifique.

## ¿Para qué?

| Sin SRP | Con SRP |
| --- | --- |
| Cambiar la lógica de salario puede romper la lectura de datos | Cada clase evoluciona de forma independiente |
| Para testear el cálculo hay que instanciar el almacenamiento | Cada responsabilidad se prueba en aislamiento |
| El fallo en persistencia bloquea el desarrollo de nóminas | Los equipos trabajan en paralelo sin conflictos de merge |

## ¿Cómo?

Identificar los actores de la clase y separar sus responsabilidades:

```java
class Empleado {
    private String nombre;
    private String departamento;
    private double salarioBase;

    public String getNombre() { return nombre; }
    public String getDepartamento() { return departamento; }
    public double getSalarioBase() { return salarioBase; }
}

class CalculadorSalario {
    public double calcular(Empleado empleado) {
        if (empleado.getDepartamento().equals("Ventas"))
            return empleado.getSalarioBase() + 200;
        return empleado.getSalarioBase();
    }
}

class RepositorioEmpleado {
    public void guardar(Empleado empleado) { ... }
    public Empleado buscar(String nombre) { ... }
}
```

Cuando Contabilidad cambia las reglas de nómina, solo se modifica `CalculadorSalario`. Cuando IT migra la base de datos, solo se toca `RepositorioEmpleado`. `Empleado` permanece estable.

**Para identificar violaciones:** pregunta "¿qué actores podrían pedir un cambio en esta clase?". Si la respuesta incluye más de uno, hay más de una responsabilidad.

- [Ver ejemplo con empleado y salario](SOLID_S_ejemplosEmpleadoSalario.md)
- [Ver ejemplo con biblioteca](SOLID_S_ejemploBibliotecaPrestamo.md)

## Compromiso

Separar responsabilidades añade clases. Si la clase es pequeña y sus responsabilidades cambian siempre juntas porque las origina el mismo actor, la división genera indirección sin beneficio real.

El SRP no prescribe "una clase, un método". Prescribe una sola fuente de cambio.

## *#2Think*

```java
class Pedido {
    private List<Articulo> articulos;
    private Cliente cliente;

    public double calcularTotal() { ... }
    public void enviarConfirmacion() { ... }  // envía email al cliente
    public String generarFacturaPDF() { ... }
}
```

- ¿Cuántas razones de cambio tiene esta clase?
- ¿Qué actores podrían pedir modificaciones a cada método?
- Si `enviarConfirmacion()` cambia porque se migra de email a SMS, ¿debería afectar a `calcularTotal()`?
