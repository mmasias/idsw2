# Alternative classes with different interfaces

Ocurre cuando dos clases realizan funciones similares pero tienen interfaces diferentes. Esto significa que sus métodos para realizar tareas comunes tienen nombres diferentes o parámetros diferentes, lo cual dificulta la interoperabilidad y el reemplazo de una clase por otra.

## Ejemplo

### Problema

```java
public class EmailSender {
    public void sendEmailMessage(String to, String subject, String body) {
        System.out.println("Sending email to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);

    }
}

public class SMSNotifier {
    public void sendSMS(String phoneNumber, String messageContent) {
        System.out.println("Sending SMS to: " + phoneNumber);
        System.out.println("Message: " + messageContent);

    }
}
```

### Solución propuesta

```java
public interface MessageSender {
    void sendMessage(String recipient, String title, String message);
}

public class EmailSender implements MessageSender {
    public void sendMessage(String to, String subject, String body) {
        sendEmailMessage(to, subject, body);
    }

    public void sendEmailMessage(String to, String subject, String body) {
        System.out.println("Sending email to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}

public class SMSNotifier implements MessageSender {
    public void sendMessage(String phoneNumber, String messageContent, String unused) {
        sendSMS(phoneNumber, messageContent);
    }

    public void sendSMS(String phoneNumber, String messageContent) {
        System.out.println("Sending SMS to: " + phoneNumber);
        System.out.println("Message: " + messageContent);
    }
}
```