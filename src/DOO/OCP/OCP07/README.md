# OCP07 - Requisitos++

OCP05Extendido funciona con elegancia: cinco tipos de alumno, cuatro evaluadores, cero `instanceof`. El doble despacho hace su trabajo en silencio.

Llega un nuevo requisito.

## Un requisito

La universidad quiere incorporar alumnos honorarios - académicos visitantes, asistentes no matriculados en el sentido tradicional. Necesitan estar en el sistema, pero no son elegibles para becas.

Un desarrollador razona con toda la lógica del mundo:

```java
class AlumnoHonorario extends Alumno {
    @Override
    public void solicitarBeca(EvaluadorBecas evaluador) {
        throw new UnsupportedOperationException("Los alumnos honorarios no solicitan becas");
    }
}
```

Compila. Parece razonable. Se despliega.

Ya vimos este patrón antes: [herencia por limitación](../../../../temario/01-diseño/02-relacionesClases.md). Y ya sabíamos que no era deseable.

## El sistema

La primera vez que `Universidad` procesa un `AlumnoHonorario`, la excepción sube. El sistema que eliminó el `instanceof` en cinco iteraciones revienta en el primer caso real.

Y dado que el sistema tiene que seguir funcionando, bajo presión, alguien añade la guardia...

<table>
<tr>
<td valign=top>

![Universidad conoce AlumnoHonorario](diagrama.svg)

`Universidad` - que dependía únicamente de la abstracción `Alumno` - ahora se acopla a una clase concreta. La abstracción está rota.

</td><td>

```java
public class Universidad {
    public void procesarSolicitudBeca(Alumno alumno,
                                      EvaluadorBecas evaluador) {
        if (!(alumno instanceof AlumnoHonorario)) {
            alumno.solicitarBeca(evaluador);
        }
    }
}
```

</td>
</tr>
</table>

El `instanceof` ha vuelto. ¿Cómo lo resolvemos realmente?

> Sigue en [OCP08](../OCP08/README.md)
