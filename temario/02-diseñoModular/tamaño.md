# Tamaño

## ¿Por qué?

Cuando un componente crece más allá de lo que la memoria de trabajo puede retener, deja de ser comprensible como unidad. El tamaño es el principio que pone límite a ese crecimiento.

## ¿Qué?

El principio de tamaño es una métrica fundamental del diseño modular que establece límites dimensionales óptimos para los distintos componentes de un sistema de software, con el objetivo de mantener su comprensibilidad y mantenibilidad.

Este principio fue sintetizado a partir de múltiples investigaciones sobre psicología cognitiva y experiencia práctica en desarrollo de software, especialmente los trabajos de George Miller sobre "El número mágico siete, más o menos dos", los estudios de Edsger Dijkstra sobre modularización, y las prácticas de desarrollo ágil promovidas por Robert C. Martin y Kent Beck.

### Restricciones de tamaño por nivel

El diseño modular establece restricciones de tamaño para cada nivel de la jerarquía de componentes de software:

<div align=center>

|Elemento|Cota|Cantidad|Elemento|
|-|-|-|-|
|**Paquete**|Máximo|[12 .. 20]|**Clases**|
|**Clase**|Media|3|**Atributos**|
|**Clase**|Máximo|5|**Atributos**|
|**Clase**|Máximo|[20 .. 25]|**Métodos**|
|**Clase**|Máximo|[200 .. 500]|**Líneas**|
|**Método**|Media|1,2| **Parámetros**|
|**Método**|Máximo|[2 .. 3]|**Parámetros**|
|**Método**|Máximo|[10 .. 15-25] | **Líneas de código** |
|**Método**|Máximo|3| **Sentencias anidadas** |
|**Método**|Máximo|[10 .. 15] | **Complejidad ciclomática** |
|**Línea**|Máximo|80\|120| **Caracteres** |

</div>

### Fundamentos teóricos

#### Regla 7±2

George Miller estableció en 1956 que la capacidad de la memoria de trabajo humana está limitada aproximadamente a 7±2 elementos de información simultáneos. Esto implica que:

- Un método no debería tener más de 5-9 variables locales
- Una clase no debería exponer más de 5-9 métodos públicos
- Una función no debería tener más de 5-9 puntos de decisión

#### Ley de proximidad

Esta ley de la psicología Gestalt indica que elementos cercanos tienden a percibirse como relacionados. Aplicado al código:

- El código relacionado debe mantenerse cercano
- Si dos fragmentos están separados por más de una pantalla, su relación se vuelve menos evidente
- Implica métodos cortos donde toda su lógica sea visible sin necesidad de desplazamiento

#### Complejidad ciclomática

Medida desarrollada por Thomas McCabe que cuantifica el número de caminos independientes a través de un programa, relacionándose directamente con la complejidad de prueba:

- `CC = Número de condiciones + Número de retornos o salidas`
- Valores recomendados: 1-10 (simple), 11-20 (complejo), >20 (muy complejo)
- Un valor superior a 10-15 indica un método que probablemente debería ser refactorizado

## ¿Para qué?

El tamaño adecuado es la señal observable de que cohesión y acoplamiento están bien aplicados. Un componente que cabe en la memoria de trabajo puede entenderse, modificarse y probarse de forma aislada.

## ¿Cómo?

Para aplicar correctamente el principio de tamaño en el diseño de software, deben seguirse estas estrategias prácticas:

### Identificar "code smells" relacionados con tamaño excesivo

- **[Método largo](sc.lm.md)**: Métodos con demasiadas líneas de código.
- **[Lista de parámetros larga](sc.lpl.md)**: Métodos con demasiados parámetros.
- **[Clase grande](sc.lcl.md)**: Clases con demasiados atributos y/o métodos.
- **[Complejidad ciclomática alta](https://es.wikipedia.org/wiki/Complejidad_ciclom%C3%A1tica)** *ext*: Muchos caminos de ejecución en un método.
- **Comentarios extensos**: Necesidad de explicaciones largas suele indicar complejidad excesiva.
- **Anidación profunda**: Estructuras condicionales o bucles excesivamente anidados.
- **Declaraciones switch grandes**: Sentencias switch con muchos casos.

### Técnicas de refactorización

- **Reemplazar condicional con polimorfismo**: Eliminar condicionales complejos usando herencia.

```java
// Antes: Método con condicional complejo
public double calcularSalario(Empleado empleado) {
    switch (empleado.getTipo()) {
        case TIEMPO_COMPLETO:
            return empleado.getSalarioBase();
        case TIEMPO_PARCIAL:
            return empleado.getHorasTrabajadas() * empleado.getTarifaHoraria();
        case COMISION:
            return empleado.getSalarioBase() + empleado.getVentas() * empleado.getPorcentajeComision();
        default:
            throw new IllegalArgumentException("Tipo de empleado desconocido");
    }
}

// Después: Jerarquía polimórfica
public abstract class Empleado {
    public abstract double calcularSalario();
}

public class EmpleadoTiempoCompleto extends Empleado {
    private double salarioBase;
    
    @Override
    public double calcularSalario() {
        return salarioBase;
    }
}

public class EmpleadoTiempoParcial extends Empleado {
    private int horasTrabajadas;
    private double tarifaHoraria;
    
    @Override
    public double calcularSalario() {
        return horasTrabajadas * tarifaHoraria;
    }
}

public class EmpleadoComision extends Empleado {
    private double salarioBase;
    private double ventas;
    private double porcentajeComision;
    
    @Override
    public double calcularSalario() {
        return salarioBase + ventas * porcentajeComision;
    }
}
```

- **Simplificar expresiones condicionales**: Extraer condiciones complejas en métodos con nombres descriptivos.

```java
// Antes: Condición compleja
if (usuario.getEdad() >= 18 && usuario.getTipoDocumento() != null && 
    (usuario.getPais().equals("España") || usuario.getTienePermiso()) && 
    !usuario.getListaNegra()) {
    // Permitir acceso
}

// Después: Método con nombre descriptivo
if (usuarioCumpleRequisitosAcceso(usuario)) {
    // Permitir acceso
}

private boolean usuarioCumpleRequisitosAcceso(Usuario usuario) {
    return usuario.getEdad() >= 18 && 
           usuario.getTipoDocumento() != null && 
           (usuario.getPais().equals("España") || usuario.getTienePermiso()) && 
           !usuario.getListaNegra();
}
```

### Heurísticas de diseño

- **Nivel único de abstracción**: Mantener un nivel consistente de abstracción dentro de cada método.
- **Métodos atómicos**: Cada método debe hacer exactamente una cosa.

### Herramientas de análisis de código

Se recomienda implementar herramientas de análisis estático que pueden detectar automáticamente componentes sobredimensionados:

- **SonarQube**: Detecta violaciones en longitud de métodos, clases, complejidad ciclomática.
- **CheckStyle**: Implementa verificaciones de tamaño configurables.
- **PMD**: Identifica métodos largos, clases grandes y complejidad excesiva.
