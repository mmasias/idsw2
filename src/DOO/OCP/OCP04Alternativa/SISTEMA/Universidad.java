package DOO.OCP.OCP04Alternativa.SISTEMA;

public class Universidad {
    public void procesarSolicitudBeca(Alumno alumno, EvaluadorBecas evaluador) {
        System.out.println("Solicitud de " + alumno.getNombre() + ":");
        evaluador.evaluar(alumno);
        System.out.println("=".repeat(30));
    }
}
