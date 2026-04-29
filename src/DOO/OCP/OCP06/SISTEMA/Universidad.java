package DOO.OCP.OCP06.SISTEMA;

public class Universidad {
    public void procesarSolicitudBeca(Alumno alumno, EvaluadorBecas evaluador) {
        alumno.solicitarBeca(evaluador);
    }
}
