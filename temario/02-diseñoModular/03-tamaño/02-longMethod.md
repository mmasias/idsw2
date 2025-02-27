# Long Method

Se refiere a métodos que son demasiado largos, es decir, métodos que contienen demasiadas líneas de código. Un método largo es problemático porque puede ser difícil de entender, difícil de reutilizar y propenso a errores. Además, los métodos largos a menudo manejan demasiadas responsabilidades, lo que viola el Principio de Responsabilidad Única.

## Ejemplo

### Problema

```java

public class OrderProcessor {
    public void processOrder(Order order) {
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item.");
        }

        if (!order.getPaymentDetails().isValid()) {
            throw new IllegalArgumentException("Invalid payment details.");
        }

        order.setStatus(OrderStatus.PROCESSING);

        PaymentResult paymentResult = PaymentGateway.processPayment(order.getPaymentDetails());
        if (!paymentResult.isSuccessful()) {
            order.setStatus(OrderStatus.FAILED);
            return;
        }

        for (OrderItem item : order.getItems()) {
            InventorySystem.decreaseStock(item.getSku(), item.getQuantity());
            if (InventorySystem.getStock(item.getSku()) < 0) {
                throw new IllegalStateException("Out of stock after order processed.");
            }
        }

        order.setStatus(OrderStatus.COMPLETED);
        NotificationService.sendOrderConfirmation(order.getCustomerEmail(), order.getId());

        System.out.println("Order processed successfully.");
    }
}

```

### Solución propuesta

```java

public class OrderProcessor {
    public void processOrder(Order order) {
        validateOrder(order);
        processPayment(order);
        updateInventory(order);
        completeOrder(order);
    }

    private void validateOrder(Order order) {
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item.");
        }
        if (!order.getPaymentDetails().isValid()) {
            throw new IllegalArgumentException("Invalid payment details.");
        }
    }

    private void processPayment(Order order) {
        order.setStatus(OrderStatus.PROCESSING);
        PaymentResult paymentResult = PaymentGateway.processPayment(order.getPaymentDetails());
        if (!paymentResult.isSuccessful()) {
            order.setStatus(OrderStatus.FAILED);
            throw new IllegalStateException("Payment processing failed.");
        }
    }

    private void updateInventory(Order order) {
        for (OrderItem item : order.getItems()) {
            InventorySystem.decreaseStock(item.getSku(), item.getQuantity());
            if (InventorySystem.getStock(item.getSku()) < 0) {
                throw new IllegalStateException("Out of stock after order processed.");
            }
        }
    }

    private void completeOrder(Order order) {
        order.setStatus(OrderStatus.COMPLETED);
        NotificationService.sendOrderConfirmation(order.getCustomerEmail(), order.getId());
        System.out.println("Order processed successfully.");
    }
}

```

- **Claridad mejorada**: Al dividir el método original en partes más pequeñas y específicas, se clarifica enormemente la estructura del código. Cada método ahora maneja una responsabilidad única, lo cual facilita la comprensión.
- **Facilidad de mantenimiento y extensión**: Modificar o extender una parte específica del proceso de pedidos es ahora más fácil y seguro, dado que los cambios en una parte no afectan directamente a las otras.
- **Mejor reusabilidad**: Los métodos más pequeños y enfocados son más fáciles de reutilizar en otras partes de la aplicación, o incluso en diferentes proyectos.
