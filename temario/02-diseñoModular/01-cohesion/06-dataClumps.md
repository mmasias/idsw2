# Data Clumps

Se da cuando varios fragmentos de datos se encuentran agrupados en múltiples partes del programa, indicando una fuerte relación entre estos datos. En muchos casos, estos datos deberían ser encapsulados en su propia clase para promover un mejor diseño y reducir la duplicidad.

## Ejemplo

### Problema

```java

public class NetworkOperations {
    public void connect(String ipAddress, int port, String protocol) {
        System.out.println("Connecting to " + ipAddress + ":" + port + " via " + protocol);
        // código para establecer conexión
    }

    public void disconnect(String ipAddress, int port, String protocol) {
        System.out.println("Disconnecting from " + ipAddress + ":" + port + " via " + protocol);
        // código para cerrar conexión
    }
}

public class NetworkDiagnostics {
    public void diagnose(String ipAddress, int port, String protocol) {
        System.out.println("Diagnosing connection to " + ipAddress + ":" + port + " via " + protocol);
        // diagnóstico de la red
    }
}


```

En el ejemplo anterior, el trío de datos ipAddress, port, y protocol se repite en múltiples métodos y clases. Cada vez que se quiera añadir un nuevo parámetro relacionado con la conexión de red, se han de modificar todos estos métodos y clases.

### Solución propuesta

```java

public class NetworkConfig {
    private String ipAddress;
    private int port;
    private String protocol;

    public NetworkConfig(String ipAddress, int port, String protocol) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.protocol = protocol;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getPort() {
        return port;
    }

    public String getProtocol() {
        return protocol;
    }

    @Override
    public String toString() {
        return ipAddress + ":" + port + " via " + protocol;
    }
}

public class NetworkOperations {
    public void connect(NetworkConfig config) {
        System.out.println("Connecting to " + config);
        // código para establecer conexión
    }

    public void disconnect(NetworkConfig config) {
        System.out.println("Disconnecting from " + config);
        // código para cerrar conexión
    }
}

public class NetworkDiagnostics {
    public void diagnose(NetworkConfig config) {
        System.out.println("Diagnosing connection to " + config);
        // diagnóstico de la red
    }
}

```

- **Reducción de duplicidad**: Al centralizar la información de la conexión en una clase, se reduce la duplicidad y la posibilidad de errores si estos datos necesitan ser modificados.
- **Mayor claridad y mantenibilidad**: El código es más claro y más fácil de mantener. Los cambios en la configuración de la red necesitan realizarse en un solo lugar.
- **Facilidad de extensión**: Si se necesitan más detalles sobre la configuración de la red, se pueden añadir fácilmente en NetworkConfig sin afectar a las clases que utilizan esta información.