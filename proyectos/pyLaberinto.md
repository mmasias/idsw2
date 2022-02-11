# pyLaberinto

Implemente un mapa con las características de juego mostradas en el vídeo debajo.

[Vídeo en Youtube](https://www.youtube.com/embed/CREnNKLTmqQ)

## Tipos de terreno & caracterísicas

|Terreno|Transitable|Velocidad|
|-|-|-|
|Suelo|Sí, a pie|1|
|Arena|Sí, a pie|1|
|Paredes|No|0|
|Cesped bajo|Sí, a pie|1|
|Cesped medio|Sí, a pie|2:1|
|Cesped alto|A caballo|1:2|
|Aguas|Sí, en bote|1:1|
|Aguas turbulentas|Sí, en bote|2:1|
|Montañas|Si, con alfombra voladora|1:1|

 Se ha de implementar el ciclo de día / noche, incluyendo una representación del cielo, del sol y de la reducción del campo de visión durante la noche.

## Transporte
Los medios de transporte son:

* Andar a pie
* Montar a caballo
* Ir en bote/barco
* Alfombra voladora

## NPCs

## Ejemplo de un generador de mapa

[Mapa en Google Spreadsheet](https://docs.google.com/spreadsheets/d/1T5UmyhdSU-Wn9zvgflbkldfbs4UWuRUDgouS8b5IqUI/edit?usp=sharing)

![](../images/trinsicSpreadsheet.png)

