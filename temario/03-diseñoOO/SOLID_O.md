# Principio abierto/cerrado (OCP)

OCP es una consecuencia de diseñar con buenas [abstracciones de interfaz](../02-diseñoModular/abstraccionInterfaz.md) y [bajo acoplamiento](../02-diseñoModular/acoplamiento.md).

## ¿Por qué?

```java
class CalculadorSalario {
    private static final double BASE = 1000;

    public double calcular(Empleado empleado) {
        switch (empleado.getDepartamento()) {
            case "Ventas":     return BASE + 200;
            case "Ingenieria": return BASE + 500;
            default:           return BASE;
        }
    }
}
```

Añadir el departamento "Marketing" obliga a abrir este fichero y modificarlo. Cada modificación expone a errores en lógica que ya funcionaba, exige volver a probar los casos existentes y produce conflictos de merge cuando el equipo trabaja en paralelo.

## ¿Qué?

Las entidades de software deben estar **abiertas para extensión** y **cerradas para modificación**.

- Abiertas para extensión: es posible añadir nuevo comportamiento.
- Cerradas para modificación: añadir ese comportamiento no requiere tocar el código existente.

El mecanismo que lo hace posible es la **abstracción**: identificar el punto de variación y esconderlo detrás de un tipo.

## ¿Para qué?

El código que funciona y está probado no debería tener que cambiar para incorporar nuevas funcionalidades. La extensión ocurre añadiendo código, no modificándolo; el riesgo de regresión desaparece.

## ¿Cómo?

Extraer el punto de variación (la regla de cálculo) a una interfaz e implementarla por separado para cada variante:

```java
interface ReglaSalario {
    double calcular(double base);
}

class ReglaSalarioVentas implements ReglaSalario {
    public double calcular(double base) { return base + 200; }
}

class ReglaSalarioIngenieria implements ReglaSalario {
    public double calcular(double base) { return base + 500; }
}

class CalculadorSalario {
    private static final double BASE = 1000;

    public double calcular(ReglaSalario regla) {
        return regla.calcular(BASE);
    }
}
```

Para añadir "Marketing" se crea `ReglaSalarioMarketing`. `CalculadorSalario` no cambia.

### Patrón método-plantilla

Cuando el punto de variación está dentro de un algoritmo con estructura fija, la extensión se consigue mediante herencia: la clase base define el esqueleto, las derivadas sobrescriben los pasos abstractos sin alterar la estructura general.

| Sin método-plantilla | Con método-plantilla |
| --- | --- |
| [🗒️](https://github.com/mmasias/23-24-pyKlondike/tree/449affaad73a3e49b27783e1c24488011c03a1ec/src) | [🗒️](https://github.com/mmasias/23-24-pyKlondike/tree/d66842e18ebf1473c12323aed6c4869dbb99e4da/src) |
| `mostrar()` en cada clase derivada | `mostrar()` en clase base, `mostrarContenido()` en derivadas |

### Herencia vs composición

<div align=center>

| | Composición | Herencia |
| --- | --- | --- |
| Reusabilidad | Por ensamblado | Por extensión |
| Relación temporal | Dinámica (cambiable en runtime) | Estática (fijada en compilación) |
| Visibilidad del código reusado | Caja negra (solo interfaz pública) | Caja blanca (acceso a `protected`) |
| Mantenibilidad | Alta (no se puede romper encapsulación) | Menor (override puede romper contratos) |
| Eficiencia | Menor (re-emisión de mensajes) | Mayor (mensajes directos) |

</div>

Preferir composición para extensión salvo cuando la relación es genuinamente "es un" y el comportamiento heredado no necesita ser reemplazado en runtime. [Por ejemplo...](herenciaComposicion.md)

### Herencia rechazada

Cuando las subclases heredan métodos que no necesitan, la jerarquía está mal diseñada. La solución habitual es crear clases intermedias abstractas que concentren solo el factor común de sus derivadas. Si la herencia rechazada es solo una implementación vacía, puede tolerarse; si contamina la interfaz pública, la jerarquía debe rediseñarse mediante delegación.

[🗒️ OCP](../../src/DOO/OCP/README.md) · [🗒️ doble despacho](../../src/DOO/DD/DD00/README.md)

## Compromiso

El cierre no puede ser total: siempre habrá cambios que obliguen a abrir el código. El objetivo es elegir los ejes de variación más probables y cerrar el diseño contra esos.

Aplicar OCP introduce indirección. Si el punto de variación es estable o poco probable, la abstracción añade complejidad sin beneficio. La primera vez que aparece la necesidad de extensión es el momento de introducir OCP, no antes (YAGNI).

## *#2Think*

```java
class GeneradorInforme {
    public void generar(String formato) {
        if (formato.equals("PDF"))  { ... }
        if (formato.equals("HTML")) { ... }
        if (formato.equals("CSV"))  { ... }
    }
}
```

- ¿Cuál es el punto de variación en esta clase?
- ¿Qué abstracción introducirías para aplicar OCP?
- Si los tres formatos actuales no van a cambiar y no se prevén nuevos, ¿merece la pena aplicar OCP?
