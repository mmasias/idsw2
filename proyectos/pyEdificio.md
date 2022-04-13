# pyEdificio
Edificio de 7 plantas, con 5 pisos por planta. Cada piso puede estar con la ventana abierta o la ventana cerrada. Si la ventana está abierta, se puede ver si en ese piso la luz está encendida o apagada.

Simule, hora por hora, tres días de la vida de dicho edificio.

```
7 [X][X][X][X][X]           [x] Ventana cerrada 
6 [X][.][.][.][X]           [0] Ventana abierta, luz encendida 
5 [X][.][.][.][X]           [.] Ventana cerrada, luz apagada
4 [0][0][0][.][X]
3 [X][0][X][X][X]
2 [X][X][X][X][X]
1 [X][X][X][X][X]
```
Probabilidad de ventana abierta/cerrada: 70% / 30%

Probabilidad de luz encendida/apagada: 60% / 40%

Probabilidad de caida de un rayo (y consiguiente avería en una columna): 25% en un día, una sola vez por día.

Probabilidad de avería en una planta: 15% en un día, una vez por día.