package DOO.OCP.OCP05.SISTEMA;

public class Universidad {
    public void procesarSolicitudBeca(Alumno alumno, EvaluadorBecas evaluador) {
        System.out.println("Solicitud de " + alumno.getNombre() + ":");
        alumno.solicitarBeca(evaluador);
        System.out.println("=".repeat(30));
    }
}
