# Modelar una hamburguesa
![](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReiiryTPGhlfOAdu-yLmN0U-nAZi2jIHIBWg&usqp=CAU)
---
## Diagrama de clases de una hamburguesa de ternera
![link a la imagen](https://www.plantuml.com/plantuml/png/ROqn2iCm34LtdK9pmJb12Q5TCgRG2_mwfejjWHrrwk4hYeQKz4-FfmUQ-eQsQSaKCthd6UMXxQcfmyqLhIRd1PM8TWsVGXWzEMYhVwGCmyWtGpdg2wBygMTDBo7RzmMVto7mFHasxDKYEGlvmIjTKIEOR5EggvRy0G00)
```
@startuml
    class Hamburguesa
    class Carne
    class Pan

    Hamburguesa *--> Carne
    Hamburguesa *--> Pan
    Hamburguesa o..> Queso
    Hamburguesa o..> Bacon
    Hamburguesa o..> Huevo

    Carne <|-- Ternera
    Carne <|-- Pollo
    Ternera <|-- Tudanca 
@enduml
```
---
## Hamburguesa con huevo y bacon
![link a la imagen](https://www.plantuml.com/plantuml/png/SoWkIImgAStDuUBAJyfAJIvHK2f8p5EmKWX8p5DII2nM0FBWCic9HNcf8Qb0eYWHg0JA0Yi3Iy4LPYJc9fKMfPUc5eFKUS1v4BL8id0TIOd9-I1hdK0qM1LO165YQMfPFiWi40sM1ujmWG2oRLgwkdOWDsC8Gbo88folfsS7iGPJ668V5vT3QbuAC7G0)
```
@startuml
    object "pan : Pan" as pan
    object "carneTernera : Ternera" as carne
    object "hamburguesa : Hamburguesa" as hamburguesa
    object "bacon : Bacon" as bacon
    object "huevo : Huevo" as huevo

    hamburguesa *--> pan
    hamburguesa *--> carne
    hamburguesa o..> bacon
    hamburguesa o..> huevo 
@enduml
```