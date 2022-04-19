# pyEdificio
Edificio de 7 plantas, con 5 pisos por planta. Cada piso puede estar con la ventana abierta o la ventana cerrada. Si la ventana está abierta, se puede ver si en ese piso la luz está encendida o apagada.

Simule, hora por hora, tres días de la vida de dicho edificio.

```
7 [#][#][#][#][#]           [#] Ventana cerrada 
6 [#][.][.][.][#]           [O] Ventana abierta, luz encendida 
5 [#][.][.][.][#]           [.] Ventana abierta, luz apagada
4 [O][O][O][.][#]
3 [#][O][#][#][#]
2 [#][#][#][#][#]
1 [#][#][#][#][#]
```
Probabilidad de ventana abierta/cerrada: 70% / 30% (por cada hora)

Probabilidad de luz encendida/apagada: 60% / 40% (por cada hora)

Probabilidad de caida de un rayo (y consiguiente avería en una columna): 25% en un día, una sola vez por día. La columna queda estropeada hasta el día siguiente.

Probabilidad de avería en una planta: 15% en un día, una vez por día. La planta queda estropeada hasta el día siguiente.
