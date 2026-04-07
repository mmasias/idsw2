# Alternative classes with different interfaces

Ocurre cuando dos clases realizan funciones similares pero tienen interfaces diferentes: sus métodos usan nombres distintos, firmas incompatibles o convenciones inconsistentes para expresar la misma responsabilidad. Aunque hacen lo mismo, no son intercambiables.

**Causas habituales:** las clases se desarrollaron de forma independiente, sin reconocer que compartían una abstracción común. Es frecuente cuando distintos desarrolladores o módulos resuelven el mismo problema sin coordinación.

**Consecuencias:** el código cliente no puede tratar ambas clases de forma polimórfica, duplica la lógica de coordinación para cada variante y dificulta la incorporación de nuevas implementaciones.

## Ejemplo

### Problema

```java
class NotificadorEmail {
    void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        System.out.println("Correo a: " + destinatario);
        System.out.println("Asunto: " + asunto);
        System.out.println("Cuerpo: " + cuerpo);
    }
}

class NotificadorSMS {
    void enviarSMS(String telefono, String mensaje) {
        System.out.println("SMS a: " + telefono);
        System.out.println("Mensaje: " + mensaje);
    }
}
```

### Solución propuesta

```java
interface Notificador {
    void enviar(String destinatario, String contenido);
}

class NotificadorEmail implements Notificador {
    public void enviar(String destinatario, String contenido) {
        // El formato específico del correo es un detalle de implementación
        System.out.println("Correo a: " + destinatario);
        System.out.println("Contenido: " + contenido);
    }
}

class NotificadorSMS implements Notificador {
    public void enviar(String destinatario, String contenido) {
        System.out.println("SMS a: " + destinatario);
        System.out.println("Mensaje: " + contenido);
    }
}
```

La interfaz común `Notificador` expresa la abstracción compartida: enviar un mensaje a un destinatario. Los detalles del canal —cómo un correo formatea asunto y cuerpo— son responsabilidad de cada implementación y no deben filtrarse al contrato.
