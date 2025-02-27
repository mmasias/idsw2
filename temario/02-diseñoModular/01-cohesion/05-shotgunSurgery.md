# Shotgun Surgery

Cuando realizar un cambio pequeño requiere que se hagan múltiples ajustes en varios archivos o clases del código fuente. Este "smell" es similar al Divergent Change, pero en lugar de muchas razones para cambiar una clase, tienes que cambiar muchas clases por una sola razón.

## Ejemplo

### Problema

Supongamos que tenemos varias clases que dependen de la estructura de una entidad, como Customer. Cualquier cambio en Customer requiere cambios dispersos en múltiples clases.

```java

public class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class CustomerDatabase {
    public void addCustomer(Customer customer) {
        // Adds customer to the database
    }

    public void updateCustomerName(String name, String email) {
        // Find customer by email and update their name
    }
}

public class CustomerNotification {
    public void sendEmailChangeNotification(String email) {
        // Sends a notification when a customer's email changes
    }
}

public class CustomerReports {
    public void generateReport(String email) {
        // Generates a report for the customer based on the email
    }
}


```

Si se necesita cambiar la manera en que los clientes son identificados, por ejemplo, añadiendo un ID único, se tendría que modificar no solo la clase Customer, sino también CustomerDatabase, CustomerNotification, y CustomerReports. 

### Solución propuesta

Consolidar la funcionalidad relacionada con los cambios de datos del cliente en una sola clase o módulo, reduciendo así los puntos que se necesitan modificar cuando la estructura de datos cambia.

```java

public class Customer {
    private String id;
    private String name;
    private String email;

    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void updateName(String newName) {
        setName(newName);
        CustomerDatabase.updateCustomer(this);
        CustomerNotification.notifyNameChange(this);
    }

    public void updateEmail(String newEmail) {
        setEmail(newEmail);
        CustomerDatabase.updateCustomer(this);
        CustomerNotification.notifyEmailChange(this);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

public class CustomerDatabase {
    public static void updateCustomer(Customer customer) {
        // Updates customer in the database
    }
}

public class CustomerNotification {
    public static void notifyNameChange(Customer customer) {
        // Notifies about the name change
    }

    public static void notifyEmailChange(Customer customer) {
        // Notifies about the email change
    }
}

public class CustomerReports {
    public void generateReport(Customer customer) {
        // Generates a report for the customer
    }
}


```

- **Centralización de cambios**: Los cambios relacionados con los datos del cliente están ahora centralizados en métodos dentro de la clase Customer. Esto significa que modificar la estructura de Customer solo requiere cambios en esta clase y los métodos directamente relacionados en otras clases.
- **Reducción de impacto por cambios**: Al reducir los puntos de cambio dispersos, el código se vuelve más mantenible y robusto.
- **Mejor encapsulación y cohesión**: La clase Customer ahora maneja mejor su propia información y las operaciones relacionadas, adheriéndose más firmemente al principio de encapsulación.
