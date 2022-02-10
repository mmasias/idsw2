# pyAspiradora

Defina e implemente una manera de representar la superficie (por ejemplo, un rectángulo de 8x7), incluyendo zonas limpias y sucias.

```
+------------------------------------------+
|ooo · ooo ·  ·  ·  ·  ·  · ooo ·  ·  · ooo|
|ooo ·  ·  ·  ·  ·  · ooooooooo ·  ·  · ooo|
| ·  · oooooo ·  ·  · ooo · ooo ·  ·  · ooo|
| ·  ·  ·  ·  ·  · ooo ·  · ooo ·  ·  · ooo|
| ·  ·  ·  ·  ·  ·  · ooo · ooo ·  ·  · ooo|
| ·  · ooo · (o) ·  · ooo · ooo ·  ·  · ooo|
|ooo · ooo ·  ·  ·  · ooo · ooo ·  ·  · ooo|
+------------------------------------------+

```
Coloque la aspiradora en la superficie y dótela de movimiento. El movimiento es aleatorio en las ocho direcciones, con la misma probabilidad en cada dirección. Asuma que el terreno no está exageradamente sucio, de modo que la aspiradora puede moverse libremente, limitada únicamente por las cuatro paredes.

Agregue a la aspiradora la capacidad de limpiar la superficie, de modo que cuando pase sobre una zona sucia, esta pase a estar limpia.

Tome nota de cuantos pasos va realizando la aspiradora, de modo que podamos saber cuántos pasos le toma terminar de limpiar.

## Mejoras – Parte 1

Agregue a su programa la capacidad de detectar la suciedad total que va quedando en el terreno, de modo que podamos saber cuánto falta por limpiar.

Implemente una batería, que brinde a la aspiradora de la capacidad de recorrer 5 veces la superficie. Haga que se consuma conforme la aspiradora se desplace, de modo que si se llega a cero, el proceso de aspirado se detiene.

Implemente una “bolsa de basura” que limite la capacidad de recoger basura de la aspiradora. Si la bolsa se llena, la aspiradora se detiene y hace falta vaciarla. 

Coloque muebles en la habitación. Los muebles, al igual que las paredes, no pueden atravesarse.

## Mejoras – Parte 2

Implemente 4 niveles de suciedad y la capacidad de limpiar un rincón con un nivel alto de suciedad en sucesivas pasadas.


(Complemento al reto 2) Implemente la capacidad de “guiar” a la aspiradora, por si vemos que está intentando limpiar en un sitio que ya está limpio, para conducirla a una zona que esté sucia. 