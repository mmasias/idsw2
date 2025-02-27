# Sustitución de Liskov

Los objetos de una clase derivada deben poder reemplazar a los objetos de la clase base sin afectar la corrección del programa. En otras palabras, si una clase S hereda de una clase T, entonces un objeto de la clase T debe poder ser reemplazado por un objeto de la clase S sin alterar las propiedades deseables del programa.

<div align="center">

![](/images/modelosUML/modelosUML/liskovEIT.svg)

</div>

```java
public class Base {
    public int m(int x) {
        assert x >= 0 && x <= 30 : "Input out of range";
        return x * 2;
    }
}

public class A extends Base {
    @Override
    public int m(int x) {
        assert x >= -300 && x <= 300 : "Input out of range";
        return Math.abs(x) / 100;
    }
}

public class B extends Base {
    @Override
    public int m(int x) {
        assert x >= 0 && x <= 3 : "Input out of range";
        return x * -20;
    }
}

public class Cliente {
    public static void main(String[] args) {
        Base base = new Base();
        A a = new A();
        B b = new B();

        System.out.println("Base m(15): " + base.m(15));

        System.out.println("A m(15): " + a.m(15));
        System.out.println("a m(-100): " + a.m(-100));

        System.out.println("B m(15): " + b.m(15));
        System.out.println("b m(2): " + b.m(2));
    }
}
```


<div align=center>

| |Base|a|b|
|-|:-:|:-:|:-:|
*parámetros*|[0..30]|[-300..300]|[0..3]
*resultados*|[0..70]|[0..7]|[-70..70]

![](/images/modelosUML/modelosUML/liskovEITComplete.svg)

</div>


|Se cumple cuando se redefine un método en una derivada reemplazando su precondición por una más débil y su postcondicion por una más fuerte|
|-|
Barbara Liskov, *Principio de Sustitución*
|La manera más sencilla para detectar violaciones en el principio de sustitución de Liskov es observando si los métodos sobrescritos en una clase hija tienen el comportamiento esperado.|
Una forma muy común de violación del LSP suele ser cuando los métodos sobreescritos de una clase hija devuelven un null o lanzan una excepción
