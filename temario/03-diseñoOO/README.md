# Diseño orientado a objetos

## ¿Por qué?

El desarrollo de software sufre frecuentemente de inefectividad debido a:

- **Mala economía del proyecto**: Incumplimiento de ámbito, tiempo y coste establecidos.
- **Calidad deficiente**: Problemas de fiabilidad, usabilidad, interoperabilidad y seguridad.
- **Pobre mantenibilidad**: Software viscoso (difícil de entender), rígido (difícil de cambiar), frágil (propenso a errores) e inmóvil (difícil de reutilizar).
- **Complejidad arbitraria**: Sistemas innecesariamente complicados que superan la capacidad cognitiva humana.

El diseño modular por sí solo no asegura un código de calidad . Tanto los enfoques monolíticos (una única clase con toda la responsabilidad) como los excesivamente fragmentados (una clase por cada tipo) presentan problemas significativos de cohesión, acoplamiento y duplicación. ([*verMas*](limitacionesDiseñoModular.md))

## ¿Qué?

El Diseño Orientado a Objetos supone un enfoque de desarrollo que organiza el software mediante:

|Abstracción y encapsulación|Polimorfismo|Herencia|
|-|-|-|
|Ocultando detalles de implementación y exponiendo solo lo esencial.|Permitiendo el enlace dinámico de operaciones a distintas implementaciones.|Facilitando la reutilización a través de la especialización y extensión.|

## ¿Para qué?

Para conseguir software con:

- **Efectividad**: Cumpliendo ámbito, tiempo y coste planificados.
- **Calidad técnica**: Logrando fiabilidad, usabilidad, interoperabilidad y seguridad adecuadas.
- **Mantenibilidad**: Creando sistemas fluidos (fáciles de entender), flexibles (fáciles de cambiar), fuertes (fáciles de probar) y reusables (fáciles de reutilizar).
- **Complejidad inherente**: Limitada a la complejidad genuina del problema, no a la introducida por un diseño deficiente.

## ¿Cómo?

### Principios SOLID (?)

Los principios SOLID constituyen guías de diseño que favorecen la creación de código mantenible:

||||
|-|-|-|
|**[S](SOLID_S.md)**|SRP - Responsabilidad única - Una clase debe tener una sola razón para cambiar.|
|**[O](SOLID_O.md)**|OCP - Abierto/Cerrado - Las entidades deben estar abiertas a la extensión pero cerradas a la modificación.|[🚬 OCP](/src/DOO/OCP/README.md) + [🚬DD](/src/DOO/DD/DD00/README.md) + [🚬pMP](/src/DOO/pMP/README.md)
|**[L](SOLID_L.md)**|LSP - Sustitución de Liskov - Los objetos de clases derivadas deben poder sustituir a los de sus clases base.|[🚬 LSP](LSP.md) + [🚬🚬 LSP](https://github.com/mmasias/fLiskov)
|**[I](SOLID_I.md)**|ISP - Segregación de interfaces - Los clientes no deben depender de interfaces que no usan.|
|**[D](SOLID_D.md)**|DIP - Inversión de dependencias - Los módulos de alto nivel no deben depender de los de bajo nivel.|

### Contextualización de SOLID en el marco del diseño modular

SOLID no debe verse como un conjunto de reglas nuevas e independientes, sino como una aproximación específica a principios fundamentales del diseño modular:

1. **Principio de Responsabilidad Única (SRP)**
   - Es una aplicación directa de la **alta cohesión** funcional
   - Permite crear clases enfocadas en una única función o propósito
   - Facilita la comprensión, modificación y reutilización

2. **Principio Abierto/Cerrado (OCP)**
   - Implementa mecanismos para lograr **bajo acoplamiento** entre componentes
   - Promueve la reutilización mediante extensión sin modificación
   - Utiliza técnicas como el patrón método plantilla, factorías, y la inversión de control

3. **Principio de Sustitución de Liskov (LSP)**
   - Asegura que el **polimorfismo** funcione correctamente
   - Garantiza que las clases derivadas puedan sustituir a las base sin afectar el comportamiento del programa
   - Evita violaciones como el uso excesivo de instanceof, métodos vacíos o lanzamiento inesperado de excepciones

4. **Principio de Segregación de Interfaces (ISP)**
   - Refuerza la **cohesión** a nivel de interfaces
   - Evita interfaces "gordas" con métodos no relacionados
   - Facilita la creación de clientes que solo conocen lo que necesitan

5. **Principio de Inversión de Dependencias (DIP)**
   - Minimiza el **acoplamiento** entre módulos
   - Desacopla componentes de alto nivel de los de bajo nivel
   - Introduce abstracciones que actúan como contratos estables

### Técnicas de implementación

- **Composición vs Herencia**: Preferir la composición cuando la relación no es claramente "es un"
- **Inyección de Dependencias**: Proporcionar dependencias desde el exterior en lugar de crearlas internamente
- **Patrón Método Plantilla**: Definir el esqueleto de algoritmos en clases base, difiriendo detalles a las subclases
- **Ley de Demeter**: Limitar la comunicación a objetos directamente relacionados
- **Técnica de Doble Despacho**: Evitar violaciones del LSP cuando se necesita comportamiento específico según el tipo

### Consideraciones prácticas

- **YAGNI (You Aren't Gonna Need It)**: No aplicar estos principios indiscriminadamente, sino según necesidades reales
- **Equilibrio**: Buscar el balance entre simplicidad y flexibilidad
- **Contextualización**: Adaptar la aplicación de los principios según el tamaño y naturaleza del proyecto

### Poner SOLID en perspectiva

SOLID no debe verse como una panacea ni como un conjunto de reglas rígidas, sino como una aproximación elaborada a principios fundamentales de diseño modular. Su aplicación debe ser contextual y equilibrada, guiada por la experiencia y el sentido común, no por dogmas.

El verdadero valor de SOLID está en su contribución a sistemas más mantenibles y adaptables, no en su aplicación ciega.

> 2Think: [Luis Fernandez acerca de SOLID](https://youtu.be/YqSV_RuWRV0?si=n3q4XM6_aElYRB9s&t=6)
