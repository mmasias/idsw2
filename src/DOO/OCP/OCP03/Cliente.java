package DOO.OCP.OCP03;

import DOO.OCP.OCP03.SISTEMA.*;

class Cliente {
    public static void main(String[] args) {

        Alumno alumnoRegular = new Alumno("A001", "Carlos García", "carlos@email.com");        
        AlumnoErasmus alumnoErasmus = new AlumnoErasmus("E001", "Sophie Martin", "sophie@email.com", "Francia", "Universidad de París");
        AlumnoVirtual alumnoVirtual = new AlumnoVirtual("V001", "Elena López", "elena@email.com", "Campus Virtual", false);
        
        Universidad universidad = new Universidad();

        universidad.matricularAlumno(alumnoRegular);
        universidad.matricularAlumno(alumnoErasmus);
        universidad.matricularAlumno(alumnoVirtual);
    }
}