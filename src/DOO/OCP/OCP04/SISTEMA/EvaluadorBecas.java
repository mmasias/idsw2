package DOO.OCP.OCP04.SISTEMA;

public class EvaluadorBecas {
    public void evaluar(Alumno alumno) {
        System.out.println("Evaluando solicitud de beca para: " + alumno.getNombre());
        
        if (alumno instanceof AlumnoErasmus) {
            AlumnoErasmus erasmus = (AlumnoErasmus) alumno;
            System.out.println("Aplicando criterios especiales para Erasmus de " + erasmus.getPaisOrigen());

            if (erasmus.getPaisOrigen().equals("Italia")) {
                System.out.println("Beca de movilidad europea concedida");
            } else {
                System.out.println("Aplicando convenio internacional para " + erasmus.getPaisOrigen());
            }
        } 
        else if (alumno instanceof AlumnoVirtual) {
            AlumnoVirtual virtual = (AlumnoVirtual) alumno;
            System.out.println("Aplicando criterios para educación a distancia");
            if (virtual.requiereExamenesPresenciales()) {
                System.out.println("Beca para desplazamiento a exámenes concedida");
            } else {
                System.out.println("Beca para recursos digitales concedida");
            }
        } 
        else {
            System.out.println("Aplicando criterios estándar para alumnos regulares");
        }
    }
}