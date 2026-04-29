package DOO.OCP.OCP06.SISTEMA;

public interface EvaluadorBecas {
    void evaluar(Alumno alumno);
    void evaluar(AlumnoErasmus alumnoErasmus);
    void evaluar(AlumnoVirtual alumnoVirtual);
    void evaluar(AlumnoInvestigador alumnoInvestigador);
    void evaluar(AlumnoDeportista alumnoDeportista);
    void evaluar(AlumnoDiscapacidad alumnoDiscapacidad);
}
