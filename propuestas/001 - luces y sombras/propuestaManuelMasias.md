# Modelar la sombra

![](./../../images/laSombra.png)

---
## Diagrama de clases
![link a la imagen](https://www.plantuml.com/plantuml/png/SoWkIImgAStDuL80WkISnE9Y1P_ItCoynABCH2Gn_wIir99y987W_Doa8h0AX7e5tI9TEwXID1azFJiaBL0r2hgwoA9G9b0KReX3QbuAq740)
```
@startuml
    class Luminaria
    class Objeto
    class Sombra
    Luminaria -r-> Objeto
    Luminaria ..> Sombra
    Objeto --> Sombra
    Sombra --> Objeto
@enduml
```
---
## Diagrama de objetos, una luminaria
![link a la imagen](//www.plantuml.com/plantuml/png/LOun3eCm34LtJc6nmm4O44F7IgtK4nXmfLH9Z9nawEqRd50f7jz__lOI8afCpdQyVcYBqBzvOvZWdfpnA0Pxm00dx23FPHqaWJrcyP59PBKgRCJ0RXMyqVE_y3f9gIrXMun2UrkhI2NzRHZcwz84nkgVC6jUiIgbUu93-9kRYr8hnh79zxHHYIjLGSys-mlvFJdx0m00)
```
@startuml
    object "foco : Luminaria" as foco
    object "persona : Objeto" as persona
    object "sombraDePersona : Sombra" as sombra
    object "pared : Objeto" as pared
    foco --> persona: ilumina >
    persona --> sombra: proyecta >
    foco ..> sombra: produce >
    sombra ..> pared: proyecta >
@enduml
```
---
## Diagrama de objetos, dos luminarias
![link a la imagen](//www.plantuml.com/plantuml/png/XP1Fpe8m4CNttoacx27vkcH1MBWqqSG3cA7Kf8PsIFyiF9Bdy6BY54qQ45c-ztll3MrzG1UY6VvW-gYxAXcWk92ayp_Ki8z6MtGQ2q0FBpdZHkKyMPp0mwG4OceMCz2JwHpkrF4JEB72WMJcnUXKdzUojBnIh5ufjjOvizZd28UXB9ltNzIW1sw7XlrPPYJbQXWTzL6gHAI6gjgoHRuGq7JwSRS_fyHw6O-j0onpHNe_zczA1im0yOLebUsZ6Pu0)
```
@startuml
    object "foco_1 : Luminaria" as foco
    object "persona : Objeto" as persona
    object "sombraDePersona : Sombra" as sombra
    object "pared : Objeto" as pared
    object "foco_2 : Luminaria" as foco2
    object "sombraDePersona_2 : Sombra" as sombra2
    foco --> persona: ilumina >
    persona --> sombra: produce >
    foco ..> sombra: produce >
    foco2 --> persona: también ilumina >
    persona --> sombra2: produce >
    foco2 ..> sombra2: produce >
    sombra --> pared: proyecta >
    sombra2 --> pared: proyecta >
@enduml
```

