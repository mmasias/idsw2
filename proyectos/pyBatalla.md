# pyBatalla

Batalla por turnos entre una Heroína y una Vampiresa.

## Energía

La Heroína y vampiresa cuentan con una energía inicial de 150 y 60
puntos respectivamente.

## Armas 
### Armas Heroína

||Ataque|% éxito|
|-|-|-|
|Arma 1|7|50%|
|Arma 2|15|25%|
|Arma 3|30|12%|

Las armas sufren un proceso de desgaste (10% de desgaste cada 10 golpes), conforme se van utilizando. La efectividad del arma es proporcional a su desgaste. 

### Armas Vampiresa

||Ataque|% éxito|
|-|-|-|
|Ataque 1|5|90%|
|Ataque 2|10|60%|
|Ataque 3|20|40%|

## Defensa

La Heroína tiene la capacidad de elegir defenderse del golpe.

Si la Heroína elige defenderse, dicha defensa tiene una probabilidad de
éxito del 80% y reduce el ataque de la vampiresa en 5 puntos.

La Heroína no puede atacar cuando se defiende.

## Desarrollo del juego

El usuario controla las acciones de la Heroína, pudiendo elegir el arma o defenderse en cada turno de batalla.

El programa controla las acciones de la vampiresa, eligiendo aleatoriamente el ataque que realiza. Los tres ataques tienen la misma probabilidad de ser elegidos.

### Desmayos

Si la energía cae por debajo de un límite (30 puntos en el caso de la Heroína, 20 puntos en el caso de la vampiresa), el personaje se desmaya, perdiendo la capacidad de atacar y recuperando 2 puntos de energía por turno.

### Poción de recuperación

La Heroína cuenta con la posibilidad de beber una poción que le permita recuperar toda su energía. 

Para que esta poción haga efecto ha de pasar un tiempo de 3 turnos, durante los cuales la Heroína no puede ni atacar ni defenderse, aunque sí recibe ataques. 

Pasado el tiempo, si ha sobrevivido, la Heroína recupera su energía.

### Horda de vampiresas

Extienda su programa para que la Heroína sea atacada por una horda de 3 vampiresas. En este caso, la Heroína amplía su energía inicial a 250 puntos.