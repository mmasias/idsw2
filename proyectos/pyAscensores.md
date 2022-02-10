2DO: Modelar el paso de un día en la U...



```
Personas esperando                               Personas en la planta

Planta  3  _____  [|4|]    | |     | |     | |   __3__ 
Planta  2  ___2_   | |     | |     | |     | |   __4__
Planta  1  _____   | |     | |    [|2|]    | |   __2__
Planta  B  _____   | |    [|0|]    | |     | |   __4__
Planta -1  _____   | |     | |     | |     | |   __1__
Planta -2  _____   | |     | |     | |    [|1|]  __0__
Planta -3  ___1_   | |     | |     | |     | |   __1__
 
                 /--------- Ascensores ---------/

```

Las personas que llegan a la universidad hacen uso de los ascensores. Cada persona sabe a que planta va a ir, cuánto tiempo estará en esa planta, luego de lo cual tendrán que irse.

Los ascensores tienen una capacidad máxima de 6 personas. Si el ascensor está lleno, solo pueden bajar personas, salvo que en la planta en la que bajan suba un número igual o menor de personas.

En un momento determinado del tiempo, un ascensor está subiendo, bajando o parado.

Cuando una persona llama a un ascensor, va el que está más cerca y al que le pilla de paso.