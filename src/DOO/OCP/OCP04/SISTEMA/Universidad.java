package DOO.OCP.OCP04.SISTEMA;

public class Universidad {    
    public void matricularAlumno(Alumno alumno) {
        System.out.println();
        System.out.println("Procesando matrícula para " + alumno.getNombre());
        double tasa = alumno.calcularTasaMatricula();
        System.out.println("Tasa de matrícula: " + tasa + " €");
        System.out.println("Matrícula completada con éxito!");
        System.out.println("Informe de matrícula:");
        System.out.println(alumno.generarInforme());

        new EvaluadorBecas().evaluar(alumno);

        System.out.println("=".repeat(25));
    }
}