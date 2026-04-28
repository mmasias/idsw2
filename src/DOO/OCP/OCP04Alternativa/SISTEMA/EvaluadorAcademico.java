package DOO.OCP.OCP04Alternativa.SISTEMA;

public class EvaluadorAcademico extends EvaluadorBecas {

    @Override
    public void evaluar(Alumno alumno) {
        if (alumno instanceof AlumnoErasmus) {
            AlumnoErasmus erasmus = (AlumnoErasmus) alumno;
            System.out.println("Expediente internacional: " + erasmus.getPaisOrigen());
        } else if (alumno instanceof AlumnoVirtual) {
            System.out.println("Rendimiento en plataforma online");
        } else {
            System.out.println("Expediente académico estándar");
        }
    }
}
