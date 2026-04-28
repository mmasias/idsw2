package DOO.OCP.OCP05Extendido;

import DOO.OCP.OCP05Extendido.SISTEMA.*;

class Cliente {
    public static void main(String[] args) {
        Alumno regular       = new Alumno("A001", "Carlos García", "carlos@email.com");
        AlumnoErasmus erasmus = new AlumnoErasmus("E001", "Sophie Martin", "sophie@email.com", "Francia", "Universidad de París");
        AlumnoVirtual virtual = new AlumnoVirtual("V001", "Elena López", "elena@email.com", "Campus Virtual", false);
        AlumnoInvestigador investigador = new AlumnoInvestigador("I001", "Marta Ruiz", "marta@email.com", "Inteligencia Artificial");
        AlumnoDeportista deportista = new AlumnoDeportista("D001", "Pablo Sanz", "pablo@email.com", "Natación", "Nacional");
        AlumnoDiscapacidad discapacidad = new AlumnoDiscapacidad("X001", "Ana Torres", "ana@email.com", 45);

        EvaluadorBecas academico      = new EvaluadorAcademico();
        EvaluadorBecas socioeconomico = new EvaluadorSocioeconomico();
        EvaluadorBecas deportes       = new EvaluadorDeportes();
        EvaluadorBecas internacional  = new EvaluadorInternacional();

        Universidad universidad = new Universidad();

        universidad.procesarSolicitudBeca(regular,       academico);
        universidad.procesarSolicitudBeca(erasmus,       academico);
        universidad.procesarSolicitudBeca(erasmus,       internacional);
        universidad.procesarSolicitudBeca(virtual,       socioeconomico);
        universidad.procesarSolicitudBeca(investigador,  academico);
        universidad.procesarSolicitudBeca(investigador,  internacional);
        universidad.procesarSolicitudBeca(deportista,    deportes);
        universidad.procesarSolicitudBeca(deportista,    socioeconomico);
        universidad.procesarSolicitudBeca(discapacidad,  academico);
        universidad.procesarSolicitudBeca(discapacidad,  deportes);
    }
}
