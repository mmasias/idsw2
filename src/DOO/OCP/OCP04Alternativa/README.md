# OCP04Alternativa — jerarquía de evaluadores

`EvaluadorBecas` de OCP04 concentra toda la lógica en una sola clase. Una mejora natural: separar en subclases especializadas, una por criterio de evaluación.

<table>
<tr>
<td valign=top>

![Jerarquía de evaluadores sobre jerarquía de alumnos](diagrama.svg)

Cada evaluador aplica sus propios criterios sin interferir con los demás. El cliente elige qué evaluador usar y la universidad delega.

</td><td>

```java
public class EvaluadorAcademico extends EvaluadorBecas {
    public void evaluar(Alumno alumno) {
        if (alumno instanceof AlumnoErasmus) {
            // expediente internacional
        } else if (alumno instanceof AlumnoVirtual) {
            // rendimiento online
        } else { ... }
    }
}

public class EvaluadorSocioeconomico extends EvaluadorBecas {
    public void evaluar(Alumno alumno) {
        if (alumno instanceof AlumnoErasmus) {
            // baremos internacionales
        } else if (alumno instanceof AlumnoVirtual) {
            // costes conectividad
        } else { ... }
    }
}
```

</td>
</tr>
</table>

Funciona. ¿Qué ocurre cuando se añade `AlumnoInvestigador`?

> Sigue en [OCP05 — doble despacho](../OCP05/README.md)
