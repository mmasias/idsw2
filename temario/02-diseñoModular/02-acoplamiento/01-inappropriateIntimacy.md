# Inappropriate Intimacy

Ocurre cuando dos clases están excesivamente entrelazadas, es decir, cuando una clase conoce los detalles íntimos y privados de otra clase. Este tipo de relación entre clases viola el principio de encapsulación, lo que puede llevar a un diseño frágil y a un código difícil de mantener y de modificar.

## Ejemplo

### Problema


```java

public class Customer {
    public String name;
    public List<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addOrder(Order order) {
        orders.add(order);
        order.customer = this;  // Inappropriate intimacy
    }
}

public class Order {
    public Customer customer;
    public double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        customer.orders.add(this);  // Inappropriate intimacy
    }
}


```

En este ejemplo, las clases Order y Customer están demasiado acopladas. Order tiene acceso directo y puede modificar la lista de pedidos (orders) de Customer y viceversa. Esto no solo es un problema de encapsulación, sino que también hace que el código sea difícil de entender, de mantener y aumenta el riesgo de errores, como modificaciones no controladas a las listas internas de objetos.




### Solución propuesta


```java

public class Customer {
    private String name;
    private List<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders); // Devuelve una copia de la lista para proteger la encapsulación
    }

    public void addOrder(Order order) {
        if (order == null) throw new IllegalArgumentException("Order cannot be null");
        if (!orders.contains(order)) {
            orders.add(order);
            order.setCustomer(this);
        }
    }
}

public class Order {
    private Customer customer;
    public double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

```

- **Mejor encapsulación**: Cada clase ahora gestiona sus propios datos internamente, y la interacción entre Customer y Order se realiza a través de métodos que controlan el acceso y la mutabilidad de sus estados.
- **Reducción del acoplamiento**: Al limitar el acceso directo a los campos internos, se reduce el acoplamiento entre las clases, haciendo el sistema más modular y fácil de modificar.
- **Facilidad de mantenimiento**: Con un diseño más claro y encapsulado, el mantenimiento se vuelve más sencillo y se minimizan los riesgos de errores inadvertidos en el manejo de las relaciones entre objetos.