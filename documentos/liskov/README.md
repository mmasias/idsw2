# Fundamentos de abstracción y subtipado: Barbara Liskov

## ¿Por qué?

Estos artículos no son documentación de lenguajes ni tutoriales de POO. Son la formulación original de problemas fundamentales en diseño de software: cómo especificar comportamiento independiente de implementación, cómo extender tipos sin romper garantías existentes, qué significa formalmente que un subtipo preserve el comportamiento de su supertipo.

Liskov identifica y resuelve el problema central de la herencia: la posibilidad de crear subtipos que técnicamente compilan pero semánticamente violan las expectativas del código cliente. El Liskov Substitution Principle no es una recomendación estilística sino una especificación matemática de corrección en jerarquías de tipos.

## ¿Qué?

Esta colección reúne tres artículos fundamentales de Barbara Liskov que establecen las bases conceptuales de la programación con tipos abstractos y el principio de sustitución que lleva su nombre.

### Artículos incluidos

1. **Programming with Abstract Data Types** (1974)
   - [ACM Digital Library](https://dl.acm.org/doi/10.1145/942572.807045)
   - [PDF alternativo](http://www.cs.tufts.edu/~nr/cs257/archive/barbara-liskov/data-abstraction.pdf)

2. **Data Abstraction and Hierarchy** (1987)
   - [ACM Digital Library](https://dl.acm.org/doi/10.1145/62138.62141)
   - [PDF alternativo](http://www.pmg.csail.mit.edu/~liskov/papers/data-abstraction-hierarchy.pdf)

3. **A Behavioral Notion of Subtyping** (1994, con Jeannette Wing)
   - [ACM Digital Library](https://dl.acm.org/doi/10.1145/197320.197383)
   - [PDF alternativo](https://www.cs.cmu.edu/~wing/publications/LiskovWing94.pdf)

## ¿Para qué?

Leer estos artículos permite:

- Distinguir herencia sintáctica (compila) de sustitución semántica correcta (preserva comportamiento)
- Identificar violaciones del LSP antes de que generen errores en tiempo de ejecución o comportamientos inesperados
- Comprender por qué ciertos diseños que parecen naturales (Rectángulo → Cuadrado, Pila → ColaLimitada) son técnicamente incorrectos
- Fundamentar decisiones de diseño en criterios formales en lugar de intuiciones sobre "es-un" o jerarquías del mundo real
- Especificar contratos de manera que las extensiones futuras no rompan código existente

La lectura secuencial construye el marco conceptual completo: desde la necesidad de separar especificación de implementación, pasando por las condiciones bajo las cuales la extensión es segura, hasta la formalización matemática que permite verificar corrección.

## ¿Cómo?

El primer artículo proporciona el vocabulario (qué es comportamiento, qué es contrato). El segundo plantea el problema (cómo extender sin romper). El tercero lo resuelve formalmente (condiciones matemáticas de sustitución correcta).

Invertir el orden genera fricción: la formalización sin motivación resulta árida; la motivación sin fundamentos carece de contexto conceptual.

**1. Programming with Abstract Data Types (1974)**

Establece el vocabulario conceptual previo a la POO: qué es un tipo abstracto, qué significa especificar comportamiento mediante contratos, cómo separar interfaz de implementación. Sin estos fundamentos, los artículos posteriores carecen de anclaje.

**2. Data Abstraction and Hierarchy (1987)**

Plantea el problema pedagógicamente: cuando se introducen jerarquías de tipos, ¿bajo qué condiciones un subtipo puede reemplazar al supertipo sin romper el sistema? Formula inicialmente el principio de sustitución de manera accesible.

**3. A Behavioral Notion of Subtyping (1994)**

Formaliza matemáticamente el LSP. Define condiciones precisas: contravarianza en parámetros, covarianza en resultados, preservación de invariantes y propiedades. Requiere los conceptos de los artículos anteriores para ser comprensible.
