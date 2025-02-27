# Principio Abierto/Cerrado

Las entidades de software (clases, módulos, funciones, etc.) deben estar **abiertas** para su extensión pero **cerradas** para su modificación.

Las nuevas funcionalidades o comportamientos entran sin modificar el código existente, mediante el uso de herencia, composición o interfaces.

## Cuándo se rompe este principio

- Cuando usamos atributos que no sean privados.
- Cuando usamos variables globales.
- Cuando se procede a consultar el tipo de objeto polimórfico.

Pero claro, dado que el cierre no puede ser completo, debe ser una estrategia. Estos es, los diseñadores deben elegir la clase de cambios contra los cuales cerrar el diseño. Esto toma cierta cantidad de **presciencia** derivada de la experiencia.

Los diseñadores experimentados conocen a los usuarios y la industria suficientemente bien para juzgar la probabilidad de diferentes clases de cambios.

## Reflexiones

### ¿Herencia o composición?

<div align=center>

<table>
    <tr>
        <td valign="top">
<pre>
class Todo {
    private Parte parte;
    public Todo() {
      this.parte = new Parte();
    }
    public void m4(){
      ...
      this.parte.m1();
      this.parte.m3();
      ...
    }
    public void m5(){
      ...
    }
    public void m1(){
      ...
      this.parte.m1();
      ...
    }
    public void m2(){
      ...
    }
}
class Parte {
    public Parte() { ... }
    public void m1() { ... }
    public void m2() { ... }
    public void m3() { ... }
}
</pre>
        </td>
        <td valign="top">
<pre>
class Base {
    public Base() { ... }
    public void m1() { ... }
    public void m2() { ... }
    public void m3() { ... }
}
class Descendiente extends Base {
    public Descendiente() {
      super();
    }
    public void m4(){
      ...
      this.m1();
      this.m3();
      ...
    }
    public void m5(){
      ...
    }
    public void m1(){
      ...
      super.m1();
      ...
    }
    public void m2(){
      ...
    }
}
</pre>
        </td>
    </tr>
</table>

|Composición|Herencia|
|:-:|:-:|
|Reusabilidad por ensamblado|Reusabilidad por extensión|
![](/images/modelosUML/modelosUML/esquemaClasesComposicion.svg)|![](/images/modelosUML/modelosUML/esquemaClasesHerencia.svg)
Más objetos para la reusabilidad, se tiene un objeto para el todo y otro para la parte y, por tanto, menos eficiente por la re-emisión de mensajes del objeto "todo" al objeto "parte"|Menos objetos para la reusabilidad, se tiene un objeto de la clase descendiente y, por tanto, más eficiente por la emisión directa de mensajes al objeto "descendiente"
![](/images/modelosUML/modelosUML/esquemaObjetosComposicion.svg)|![](/images/modelosUML/modelosUML/esquemaObjetosHerencia.svg)
|Reusabilidad con desarrollo explícito en el código, declarando los atributos que son parte del todo y enviando mensajes para su gestión|Reusabilidad implícita en el lenguaje, declarando la herencia se transmiten automáticamente todos los atributos y métodos, públicos, protegidos, privados y de paquete, con unos accesos u otros dependiendo del punto de vista (clase cliente o clase descendiente)|
|Relación dinámica entre objetos, por tanto es más flexible porque un todo puede colaborar con distintas partes en el tiempo creando nuevos objetos|Relación estática entre clases, por tanto es menos flexible porque un objeto de la clase descendiente es y será un objeto de la clase descendiente sin poder modificar su clase base en tiempo de ejecución|
|Caja negra, desde la clase todo se tiene acceso a miembros públicos de la parte, sin posibilidad de modificar el código reusado|Caja blanca, desde la calse descendiente se tiene acceso a miembros públicos y protegidos y de paquete, con posiblidad de modificar el código reusado mediante la redefinción (@Override)|
|Fácil de mantener porque es imposible romper el principio de encapsulación|Difícil de mantener porque es fácil romper el principio de encapsulación|

</div>

[Por ejemplo...](herenciaComposicion.md)

### Patrón método-plantilla

|||
|-|-|
Se dificulta la extracción de un factor común en los códigos de los métodos de las clases derivadas por detalles inmersos en el propio código pero respetando un esquema general|Definir el esqueleto de un algoritmo de un método, diferir algunos pasos para las clases derivadas.

El patron permite que las clases derivadas redefinan esos pasos abstractos sin cambiar la estructura del algoritmo de la clase padre

|Sin método plantilla|Con método plantilla|
|:-:|:-:|
[🗒️](https://github.com/mmasias/23-24-pyKlondike/tree/449affaad73a3e49b27783e1c24488011c03a1ec/src)|[🗒️](https://github.com/mmasias/23-24-pyKlondike/tree/d66842e18ebf1473c12323aed6c4869dbb99e4da/src)
`mostrar()` en cada clases derivadas|`mostrar()` en clase padre, `mostrarContenido()` en clases derivadas

### Código sucio por herencia rechazada

|||
|-|-|
Las subclases heredan los métodos y atributos de sus padres que no necesitan.|La solución gira en torno a crear clases intermedias en la jerarquía, habitualmente abstractas, mover métodos y atributos hacia arriba y hacia abajo hasta que todas las subclases reciban los métodos y atributos necesarios y no más. De tal manera que cada clase padre tenga el factor común de sus clases derivadas.

A menudo, esta solución complica la jerarquía en exceso. En tal caso, si la herencia rechazada es la implantación “vacía” de un método de la clase derivada podría considerarse como solución frente a la complicación de la jerarquía. Pero si la herencia rechazada es la transmisión de métodos públicos implantados a clases derivadas que no lo necesitan, debería re-diseñarse la jerarquía de herencia por delegación para evitar corromper la interfaz de la clase derivada
