package DOO.OCP.OCP07.SISTEMA;

public class EvaluadorAcademico implements EvaluadorBecas {

    @Override
    public void evaluar(Alumno alumno) {
        System.out.println("[Académico] Expediente estándar: " + alumno.getNombre());
    }

    @Override
    public void evaluar(AlumnoErasmus alumnoErasmus) {
        System.out.println("[Académico] Expediente internacional (" + alumnoErasmus.getPaisOrigen() + "): " + alumnoErasmus.getNombre());
    }

    @Override
    public void evaluar(AlumnoVirtual alumnoVirtual) {
        System.out.println("[Académico] Rendimiento en plataforma online: " + alumnoVirtual.getNombre());
    }

    @Override
    public void evaluar(AlumnoInvestigador alumnoInvestigador) {
        System.out.println("[Académico] Publicaciones en " + alumnoInvestigador.getAreaInvestigacion() + ": " + alumnoInvestigador.getNombre());
    }

    @Override
    public void evaluar(AlumnoDeportista alumnoDeportista) {
        System.out.println("[Académico] Compatibilidad académica con " + alumnoDeportista.getDeporte() + ": " + alumnoDeportista.getNombre());
    }

    @Override
    public void evaluar(AlumnoDiscapacidad alumnoDiscapacidad) {
        System.out.println("[Académico] Rendimiento ajustado (" + alumnoDiscapacidad.getPorcentajeDiscapacidad() + "%): " + alumnoDiscapacidad.getNombre());
    }
}
