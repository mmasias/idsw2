package DOO.OCP.OCP04Alternativa;

import DOO.OCP.OCP04Alternativa.SISTEMA.*;

class Cliente {
    public static void main(String[] args) {
        Alumno alumnoRegular = new Alumno("A001", "Carlos García", "carlos@email.com");
        AlumnoErasmus alumnoErasmus = new AlumnoErasmus("E001", "Sophie Martin", "sophie@email.com", "Francia", "Universidad de París");
        AlumnoVirtual alumnoVirtual = new AlumnoVirtual("V001", "Elena López", "elena@email.com", "Campus Virtual", false);

        EvaluadorBecas academico = new EvaluadorAcademico();
        EvaluadorBecas socioeconomico = new EvaluadorSocioeconomico();

        Universidad universidad = new Universidad();

        universidad.procesarSolicitudBeca(alumnoRegular, academico);
        universidad.procesarSolicitudBeca(alumnoErasmus, academico);
        universidad.procesarSolicitudBeca(alumnoErasmus, socioeconomico);
        universidad.procesarSolicitudBeca(alumnoVirtual, socioeconomico);
    }
}
