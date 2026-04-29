package DOO.OCP.OCP07.SISTEMA;

public class Universidad {
    public void procesarSolicitudBeca(Alumno alumno, EvaluadorBecas evaluador) {
        if (!(alumno instanceof AlumnoHonorario)) {
            alumno.solicitarBeca(evaluador);
        }
    }
}
