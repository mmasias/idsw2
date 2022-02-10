# pyColas

El centro comercial CF de El Alisal trabaja de 9 de la mañana a 9 de la noche vendiendo diversos artículos. Para la gestión de la venta dispone de 4 cajas que van atendiendo a los clientes, que a su vez van situándose en cola conforme concluyen sus compras esperando una caja vacía que les atienda.

<kbd>![](../images/colas.png)</kbd>

Un estudio previo determinó que la probabilidad de llegada de un cliente nuevo a la cola se estima entre el 0 y el 40% por minuto.

Cuando una caja está libre (es decir, no está atendiendo a ningún cliente), puede recibir a un nuevo cliente de la cola. Este cliente llevará su compra, la cual el estudio anteriormente citado midió en *packs de items*. El usuario puede llevar un mínimo de 5 y un máximo de 15 pack de items para su atención, y se tiene calculado que las cajas tardan 1 minuto en atender un pack de items.

Desarrolle un programa que modele y simule el sistema explicado líneas arriba, teniendo en cuenta las condiciones indicadas.

Este programa debe ir mostrando los siguientes datos conforme avance el tiempo:

* Llegada de las personas
* Número de personas en cola
* El estado de atención de las cajas.

Extienda el programa anterior para que, al finalizar la jornada, presente un resumen con los siguientes datos:

* Número de minutos en que no hubo nadie en cola.
* Número de personas que estaban en cola al finalizar el día.
* Número de personas atendidas durante el día.
* Número de items vendidos en el día.