package DOO.OCP.OCP05Extendido.SISTEMA;

public class Universidad {
    public void procesarSolicitudBeca(Alumno alumno, EvaluadorBecas evaluador) {
        alumno.solicitarBeca(evaluador);
    }
}
