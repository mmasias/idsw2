# Misplaced Responsibility

Ocurre cuando una operación está implementada en un componente que no es el responsable natural de esa función. El código hace lo correcto, pero en el lugar equivocado.

**Causas habituales:** la operación se añadió donde los datos estaban disponibles, no donde la responsabilidad corresponde. Es frecuente cuando un desarrollador agrega una utilidad directamente a la clase que tiene a mano, sin preguntarse si esa clase es el lugar correcto.

**Consecuencias:** cuando la lógica mal ubicada necesita cambiar, obliga a modificar una clase que no debería verse afectada. Los motivos de cambio de un componente se multiplican, erosionando su cohesión.

## Ejemplo

### Problema

```java
class Cliente {
    String nombre;
    String email;

    void guardarEnBaseDatos() {
        // Lógica de persistencia dentro de la entidad de dominio
    }
}
```

### Solución propuesta

```java
class Cliente {
    String nombre;
    String email;
}

class RepositorioCliente {
    void guardar(Cliente cliente) {
        // Implementación de persistencia
    }
}
```

Si el mecanismo de persistencia cambia —de SQL a fichero, o a un servicio externo— `RepositorioCliente` absorbe el cambio. `Cliente` permanece intacto porque su responsabilidad es representar un cliente, no persistirlo.
