package DOO.OCP.OCP04Alternativa.SISTEMA;

public class EvaluadorSocioeconomico extends EvaluadorBecas {

    @Override
    public void evaluar(Alumno alumno) {
        if (alumno instanceof AlumnoErasmus) {
            AlumnoErasmus erasmus = (AlumnoErasmus) alumno;
            System.out.println("Baremos internacionales: " + erasmus.getPaisOrigen());
        } else if (alumno instanceof AlumnoVirtual) {
            System.out.println("Costes de conectividad y equipamiento");
        } else {
            System.out.println("Renta familiar y situación económica");
        }
    }
}
