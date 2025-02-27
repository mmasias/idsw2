# Lazy class

Ocurre cuando una clase hace muy poco y no justifica su existencia. En términos de costo-beneficio, mantener una clase que no realiza una función significativa puede ser más costoso que beneficioso, ya que cada clase adicional en un sistema aumenta la complejidad y el mantenimiento del mismo.

## Ejemplo

### Problema

```java

public class UserSessionManager {
    private String userId;

    public UserSessionManager(String userId) {
        this.userId = userId;
    }

    public boolean isLoggedIn() {
        return userId != null;
    }
}

```



### Solución propuesta

Supongamos que existe una clase User que gestiona información más detallada sobre los usuarios. Se podría incorporar la funcionalidad de la clase UserSessionManager directamente en la clase User.

```java

public class User {
    private String id;
    private String name;
    private String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public boolean isLoggedIn() {
        return id != null;
    }

    // Otros métodos relacionados con el usuario
}

```

- **Simplificación del código**: Se reduce la cantidad de clases en el sistema, lo que simplifica la estructura general del código.
- **Reducción de la complejidad**: Menos clases significan una menor complejidad para navegar y mantener el sistema.
- **Optimización de recursos**: Al eliminar clases que no contribuyen significativamente a la funcionalidad del sistema, se optimizan los recursos utilizados para el mantenimiento del código.
