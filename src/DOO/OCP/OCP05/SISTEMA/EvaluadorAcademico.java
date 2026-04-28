package DOO.OCP.OCP05.SISTEMA;

public class EvaluadorAcademico implements EvaluadorBecas {

    @Override
    public void evaluar(Alumno alumno) {
        System.out.println("Expediente académico estándar: " + alumno.getNombre());
    }

    @Override
    public void evaluar(AlumnoErasmus alumnoErasmus) {
        System.out.println("Expediente internacional (" + alumnoErasmus.getPaisOrigen() + "): " + alumnoErasmus.getNombre());
    }

    @Override
    public void evaluar(AlumnoVirtual alumnoVirtual) {
        System.out.println("Rendimiento en plataforma online: " + alumnoVirtual.getNombre());
    }
}
