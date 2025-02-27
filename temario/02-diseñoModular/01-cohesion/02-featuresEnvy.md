# Features envy

Ocurre cuando un método en una clase accede excesivamente a los datos o métodos de otra clase. En lugar de interactuar con sus propios datos, el método parece estar más interesado en los datos de otra clase, indicando que parte de su funcionalidad podría estar mejor ubicada en la otra clase.

## Ejemplo

### Problema

```java

public class Customer {
    private String name;
    private String address;
    private String phoneNumber;

    public Customer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

public class Order {
    private Customer customer;
    private double amount;

    public Order(Customer customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public void printInvoice() {
        String customerInfo = "Invoice for " + customer.getName() + "\n" +
                              "Address: " + customer.getAddress() + "\n" +
                              "Phone: " + customer.getPhoneNumber();
        System.out.println(customerInfo);
        System.out.println("Total Amount: $" + amount);
    }
}

```

### Solución propuesta

```java

public class Customer {
    private String name;
    private String address;
    private String phoneNumber;

    public Customer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerInfo() {
        return "Customer: " + name + "\nAddress: " + address + "\nPhone: " + phoneNumber;
    }
}

public class Order {
    private Customer customer;
    private double amount;

    public Order(Customer customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public void printInvoice() {
        System.out.println(customer.getCustomerInfo());
        System.out.println("Total Amount: $" + amount);
    }
}

```
