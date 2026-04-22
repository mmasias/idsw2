# Sistema de pedidos - ejemplo de doble despacho

Un sistema de e-commerce procesa tres tipos de pedido: `PedidoFisico` (envío postal), `PedidoDigital` (enlace de descarga por email) y `PedidoSuscripcion` (activación automática). Cada tipo requiere un canal de envío diferente y acceso a datos específicos.

El procesador necesita comportarse de forma distinta según el tipo concreto. Ese es el problema.

## Las tres versiones

| Versión | Enfoque | Problema que queda |
| --- | --- | --- |
| [v000mal](v000mal/README.md) | `instanceof` + casting en el procesador | añadir tipo = abrir y modificar el procesador |
| [v001basico](v001basico/README.md) | Doble despacho manual | `Pedido` acoplado a `ProcesadorEnvios` concreto |
| [v002extensible](v002extensible/README.md) | Visitor con interfaz | Añadir tipo = modificar interfaz + todos los visitantes |

## Lo que distingue este ejemplo

`v002extensible` tiene tres visitantes distintos (`ProcesadorEnvios`, `ProcesadorFacturacion`, `ProcesadorNotificaciones`) operando sobre la misma jerarquía. Eso es lo que justifica el Visitor completo: no solo eliminar `instanceof`, sino que operaciones distintas crecen de forma independiente sin tocar los pedidos.

## Enlace con el temario

- [Limitaciones del diseño modular](../../../../temario/03-diseñoOO/limitacionesDiseñoModular.md)
- [Doble despacho](../../../../temario/03-diseñoOO/dobleDespacho.md)
