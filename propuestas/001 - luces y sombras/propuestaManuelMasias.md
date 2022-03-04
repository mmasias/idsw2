# Modelar la sombra


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

## Diagrama de objetos, una luminaria
![link a la imagen](https://www.plantuml.com/plantuml/png/LOun3eCm34Ntdi9YXmDaG0mTE_GA1bo9Yc3a94DlN_e9bPmfUl_vsqFARBd4zKR7q_4jKwRcfPDIe4U9oyQsS4ESw0UTjOibtPW2I5PO5JenQHoDx_By3u2WjdvzCPlClXO84cvhs_xQ56XPSIVro2k6SdO7saq_H_EbeABhN3wNISwuKWXOw-O7sUOIroy0)
```
@startuml
    object "foco : Luminaria" as foco
    object "persona : objeto" as persona
    object "sombraDePersona : sombra" as sombra
    object "pared : objeto" as pared
    foco --> persona: ilumina >
    persona --> sombra: proyecta >
    foco ..> sombra: produce >
    sombra ..> pared: proyecta >
@enduml
```

## Diagrama de objetos, dos luminarias
![link a la imagen](https://www.plantuml.com/plantuml/png/XP1D3e8m48NtdcB27XAxx8AmSEd26vYXrAI6TaX_5Xx9StWnmrHC6X1tvBtllJUq2n5zJ7Oy001GVzSgGdKZHTSZI3WdQnnwWnLWW5akk4dxG0v1iXA9gOzOW85ix_6aBzz0LZYGFyjYz7eeQrbQNoashnHxwvnPxNE4mr3NxV8N4ip8xT3E_Y8padCI9az3KZeJkQ5fzcnHBaIqlNaztTyfiLt6Ozi0oxc2tu_zXrOH2q3y83hjXcJ7Dm00)
```
@startuml
    object "foco_1 : Luminaria" as foco
    object "persona : objeto" as persona
    object "sombraDePersona : sombra" as sombra
    object "pared : objeto" as pared
    object "foco_2 : Luminaria" as foco2
    object "sombraDePersona_2 : sombra" as sombra2
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

