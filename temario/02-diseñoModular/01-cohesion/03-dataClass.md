# Features envy

Se refiere a clases que únicamente sirven para almacenar datos y no tienen funcionalidades significativas (métodos) propias, más allá de simples getters y setters. Estas clases son problemáticas porque tienden a exponer sus detalles internos (sus datos), lo cual viola el principio de encapsulación y puede llevar a un diseño donde la lógica que maneja estos datos se dispersa por otras clases del sistema.

## Ejemplo

### Problema

```java

public class Employee {
    private String name;
    private String department;
    private int age;

    public Employee(String name, String department, int age) {
        this.name = name;
        this.department = department;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

```

La clase Employee es un ejemplo clásico de una Data Class. Contiene datos y los métodos para acceder y modificar estos datos, pero no tiene ningún comportamiento significativo propio. La lógica que pertenece a las responsabilidades de un empleado probablemente se maneje en otras clases, lo que puede llevar a un diseño poco coherente y difícil de mantener.

### Solución propuesta

Para eliminar este "smell", podemos añadir métodos que realicen operaciones relacionadas con los datos dentro de la misma clase, mejorando así la encapsulación y la cohesión.

```java

public class Employee {
    private String name;
    private String department;
    private int age;

    public Employee(String name, String department, int age) {
        this.name = name;
        this.department = department;
        this.age = age;
    }

    public void printEmployeeDetails() {
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Age: " + age);
    }

    public void updateDepartment(String newDepartment) {
        System.out.println("Changing department from " + department + " to " + newDepartment);
        this.department = newDepartment;
    }

    public boolean isEligibleForRetirement() {
        return age >= 65;
    }
}

```

- **Encapsulación mejorada**: Al mover la lógica relacionada con los empleados a la clase Employee, encapsulamos mejor los datos.
- **Responsabilidad única**: Cada clase ahora maneja sus propios datos y comportamientos relacionados, adheriendo mejor al Principio de Responsabilidad Única.
- **Mantenimiento y extensión facilitados**: Al tener la lógica centralizada, cualquier cambio en el comportamiento relacionado con los empleados solo necesita modificarse en un lugar.