# OCP05Extendido — 5 tipos, 4 evaluadores, 0 instanceof

El sistema de becas crece: cinco tipos de alumno, cuatro criterios de evaluación. En OCP04Alternativa eso son 20 bloques `instanceof` repartidos por cuatro clases. El reto: ¿aguanta el doble despacho?

<table>
<tr>
<td valign=top>

![5 tipos de alumno, 4 evaluadores, interfaz como nexo](diagrama.svg)

Las dos jerarquías no se tocan. `EvaluadorBecas` es el único punto de contacto.

</td><td>

```java
interface EvaluadorBecas {
    void evaluar(Alumno alumno);
    void evaluar(AlumnoErasmus alumnoErasmus);
    void evaluar(AlumnoVirtual alumnoVirtual);
    void evaluar(AlumnoInvestigador alumnoInvestigador);
    void evaluar(AlumnoDeportista alumnoDeportista);
    void evaluar(AlumnoDiscapacidad alumnoDiscapacidad);
}
```

Cada alumno sigue haciendo lo mismo:

```java
@Override
public void solicitarBeca(EvaluadorBecas evaluador) {
    evaluador.evaluar(this);
}
```

</td>
</tr>
</table>

## Compromisos

**Añadir `EvaluadorDeportes`:** implementar `EvaluadorBecas`. Sin tocar nada más. Los alumnos no saben que existe.

**Añadir `AlumnoDiscapacidad`:** crear la clase, añadir `evaluar(AlumnoDiscapacidad)` a la interfaz e implementarlo en los cuatro evaluadores existentes.

## Por qué ese compromiso es bueno

En OCP04Alternativa, añadir `AlumnoDiscapacidad` requería localizar manualmente el lugar correcto en cada evaluador y añadir un `else if` — sin ninguna garantía de no olvidarse ninguno. Aquí, la interfaz actúa como contrato: si falta un método, el código no compila. El coste existe, pero es explícito, localizado y verificable.

> Ver también: [doble despacho](../../../temario/03-diseñoOO/dobleDespacho.md)
