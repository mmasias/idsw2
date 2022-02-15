Se ha de implementar un sistema que permita gestionar las máquinas expendedoras de la universidad, cuyas características y condiciones iniciales se detallan a continuación:

|Producto	|Precio	|Cantidad en Máquina 1	|Cantidad en Máquina 2	|Cantidad en Máquina 3|
|-|-|-|-|-|
|Galletas	|1,50	|10	|10	|10|
|Chocolates	|1,10	|10	|10	|10|
|Bebida	    |1,05	|10	|10	|10|
|Bocadillo	|1,75	|10	|10	|10|

Estas máquinas expendedoras permiten pagar con los siguientes billetes (otras denominaciones no son aceptadas):

|Billete o Moneda|Cantidad en Máquina 1	|Cantidad en Máquina 2	|Cantidad en Máquina 3|
|-|-|-|-|
|20 €	|3	|3	|3  |
|10 €	|1	|2	|1  |
|5 €	|2	|3	|3  |
|2 €	|5	|7	|5  |
|1 €	|10	|15	|12 |
|0,5 €	|20	|25	|30 |
|0,2 €	|20	|30	|10 |
|0,05 €	|10	|20	|15 |


* Desarrolle el código que permita gestionar la máquina expendedora N , simulando el proceso de compra/venta y la gestión del dinero. Se debe tener en cada momento constancia del número de productos que tiene la máquina, así como del dinero (total y parcial).

* Dote a este código de la opción para obtener un reporte de la cantidad de producto de la máquina. 

* Dote a este código de la opción para obtener un reporte de la cantidad de dinero que hay en la máquina.

* El código anterior, preparado para gestionar tres máquinas.

* Durante la venta, la probabilidad que haya un atasco es del 2 %. Incluya el código para simular esta situación.

* Durante la venta, la probabilidad que haya una avería es del 3%. Incluya el código para simular esta situación.

* Agrege la opción de gestionar la reposición de las máquinas. Esta reposición “llena” las máquinas, llevándolas al estado inicial de 10 productos por máquina.