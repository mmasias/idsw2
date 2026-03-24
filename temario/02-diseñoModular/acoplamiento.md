# Acoplamiento

## ¿Por qué?

Los sistemas rígidos, frágiles, inmóviles y viscosos tienen habitualmente otro denominador común: sus componentes saben demasiado los unos de los otros. El acoplamiento es el principio que mide y guía esa interdependencia.

## ¿Qué?

El acoplamiento es una métrica fundamental del diseño de software que evalúa el grado de interdependencia entre los componentes de un sistema.

> "El acoplamiento es una medida de la fuerza con un elemento está conectado a, tiene conocimiento de, o se basa en otros elementos. Estos elementos incluyen sistemas, paquetes, clases y métodos."
>
> — Craig Larman, UML y Patrones

Este concepto, junto con la cohesión, fue introducido por Larry Constantine en la década de 1960 y desarrollado posteriormente con Ed Yourdon y Wayne Stevens como parte de los fundamentos del diseño estructurado.

### Tipos de acoplamiento

Se pueden distinguir diferentes categorías de acoplamiento:

#### Según la dirección

<table>
   <tr><td colspan=2 align=center>
      
![](/images/modelosUML/acoplamiento.svg)
   </td></tr>
   <tr><td><b>Aferente: </b><br>Mide cuántas clases dependen de una clase específica. Un alto valor indica una clase ampliamente utilizada en el sistema, lo que puede reflejar una buena reutilización pero también un punto crítico de fragilidad.</td><td><b>Eferente: </b><br>Mide cuántas clases son utilizadas por una clase específica. Un alto valor indica una clase que depende de muchos otros componentes, lo que reduce su independencia y aumenta su fragilidad ante cambios.</td></tr>
</table>

#### Según la forma

1. **Directo**: Se establece cuando una clase hace referencia explícita a otra. Puede darse a través de<br><br>- Atributos de la clase<br>- Parámetros en métodos<br>- Variables locales<br>- Tipos de retorno<br>- Herencia

   ```java
   // Acoplamiento directo por atributo
   public class Pedido {
       private Cliente cliente; // Acoplamiento directo a Cliente
   }
   
   // Acoplamiento directo por parámetro
   public void procesarPago(MetodoPago metodoPago) {
       // Acoplamiento directo a MetodoPago
   }
   
   // Acoplamiento directo por herencia
   public class VehiculoElectrico extends Vehiculo {
       // Acoplamiento directo a Vehiculo
   }
   ```

1. **Indirecto**: Se produce cuando una clase accede a otra a través de una cadena de intermediarios.
   
   ```java
   public class Empleado {
       private Departamento departamento;
       
       public Empresa getEmpresa() {
           return departamento.getEmpresa(); // Acoplamiento indirecto a Empresa
       }
   }
   ```

1. **De contenido**: Ocurre cuando un módulo modifica directamente el contenido interno de otro módulo.
   
   ```java
   // Acoplamiento de contenido (muy alto y no recomendado)
   public class SistemaArchivos {
       public void guardarArchivo(Documento doc) {
           doc.contenido = formatearContenido(doc.contenido); // Modificación directa
       }
   }
   ```
   
1. **Común**: Surge cuando múltiples componentes dependen de un recurso compartido, como una variable global o una base de datos.
1. **Temporal**: Se produce cuando varios componentes deben ejecutarse en un orden específico.

### Principio de la Ley de Demeter (LoD)

La Ley de Demeter, también conocida como "Principio del Menor Conocimiento" o "No hables con extraños", es una guía para reducir el acoplamiento:

> Un método de un objeto solo debe llamar a métodos pertenecientes a:
> 1. Sí mismo
> 2. Sus parámetros
> 3. Cualquier objeto que cree
> 4. Sus atributos directos

Ejemplos de violación de la Ley de Demeter:

```java
// Violación de la Ley de Demeter - "Encadenamiento de trenes"
cliente.getDireccion().getCiudad().getCodigoPostal();

// Forma correcta - Respetar la Ley de Demeter
cliente.getCodigoPostal();
```

## ¿Para qué?

El bajo acoplamiento es lo que permite que los cambios queden localizados: modificar un componente no obliga a modificar los que dependen de él.

En combinación con la alta cohesión forman un círculo virtuoso: reducir el acoplamiento delegando en los objetos apropiados aumenta la cohesión; aumentar la cohesión asumiendo menos responsabilidades por componente reduce el acoplamiento.

## ¿Cómo?

Para aplicar correctamente el principio de bajo acoplamiento en el diseño de software, deben seguirse estas estrategias prácticas:

### Identificar "code smells" que señalan problemas de acoplamiento

- **[Intimidad inapropiada](sc.ii.md)**: Cuando una clase usa excesivamente los detalles internos de otra clase.
- **[Envidia de características](sc.fe.md)**: Un método que parece más interesado en una clase diferente a la que pertenece.
- **[Intermediario](sc.mm.md)**: Una clase que simplemente delega a otra.
- **[Principios de paquetes quebrados](sc.bpp.md)**: Paquetes con dependencias cíclicas o excesivas.
- **[Cadena de mensajes](sc.mc.md)** [***E·Ext***](https://www.metridev.com/metrics/message-chain-code-smells-how-to-identify-and-fix-them/): Series de llamadas del tipo `a.getB().getC().getD()`.

### Técnicas de diseño & refactorización

- **Ley de demeter**: Se debe limitar la comunicación solo a "amigos cercanos".

```java
// Violación de la Ley de Demeter
public class GeneradorFacturas {
    public void generarFactura(Pedido pedido) {
        String direccion = pedido.getCliente().getDireccion().getCalle() + ", " +
                           pedido.getCliente().getDireccion().getCiudad();
        // ...
    }
}

// Respetando la Ley de Demeter
public class GeneradorFacturas {
    public void generarFactura(Pedido pedido) {
        String direccion = pedido.getDireccionEntrega();
        // ...
    }
}

public class Pedido {
    private Cliente cliente;
    
    public String getDireccionEntrega() {
        return cliente.getDireccionCompleta();
    }
}

public class Cliente {
    private Direccion direccion;
    
    public String getDireccionCompleta() {
        return direccion.getFormatoCompleto();
    }
}
```

- **Tell, Don't Ask**: Se debe indicar a los objetos qué hacer en lugar de pedirles información para luego actuar sobre ella.

```java
// Estilo "Ask" - Alto acoplamiento
public void procesarPedido(Pedido pedido) {
    if (pedido.getEstado() == EstadoPedido.NUEVO) {
        pedido.setEstado(EstadoPedido.PROCESANDO);
        // Más lógica...
    }
}

// Estilo "Tell" - Bajo acoplamiento
public void procesarPedido(Pedido pedido) {
    pedido.procesar();
}
```

- **Programación contra interfaces**: Se debe depender de abstracciones en lugar de implementaciones concretas.

```java
// Alto acoplamiento - Dependencia de implementación concreta
public class ServicioNotificacion {
    private NotificadorEmail notificador = new NotificadorEmail();
    
    public void alertar(Usuario usuario, String mensaje) {
        notificador.enviarEmail(usuario.getEmail(), mensaje);
    }
}

// Bajo acoplamiento - Dependencia de abstracción
public class ServicioNotificacion {
    private Notificador notificador; // Interfaz
    
    public ServicioNotificacion(Notificador notificador) {
        this.notificador = notificador;
    }
    
    public void alertar(Usuario usuario, String mensaje) {
        notificador.notificar(usuario, mensaje);
    }
}
```

### Métricas para evaluar el acoplamiento

Pueden emplearse métricas formales para medir el acoplamiento:

- **Acoplamiento Aferente (Ca)**: Número de clases fuera del componente que dependen de clases dentro del componente.
- **Acoplamiento Eferente (Ce)**: Número de clases dentro del componente que dependen de clases fuera del componente.

### Herramientas de análisis

Herramientas como JDepend, SonarQube o Structure101 pueden analizar el acoplamiento y proporcionar visualizaciones de las dependencias entre componentes.
