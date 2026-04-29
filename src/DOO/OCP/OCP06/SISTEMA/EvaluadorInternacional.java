package DOO.OCP.OCP06.SISTEMA;

public class EvaluadorInternacional implements EvaluadorBecas {

    @Override
    public void evaluar(Alumno alumno) {
        System.out.println("[Internacional] Sin perfil internacional: " + alumno.getNombre());
    }

    @Override
    public void evaluar(AlumnoErasmus alumnoErasmus) {
        System.out.println("[Internacional] Convenio bilateral con " + alumnoErasmus.getPaisOrigen() + ": " + alumnoErasmus.getNombre());
    }

    @Override
    public void evaluar(AlumnoVirtual alumnoVirtual) {
        System.out.println("[Internacional] Colaboración internacional online: " + alumnoVirtual.getNombre());
    }

    @Override
    public void evaluar(AlumnoInvestigador alumnoInvestigador) {
        System.out.println("[Internacional] Redes internacionales en " + alumnoInvestigador.getAreaInvestigacion() + ": " + alumnoInvestigador.getNombre());
    }

    @Override
    public void evaluar(AlumnoDeportista alumnoDeportista) {
        System.out.println("[Internacional] Competiciones internacionales (" + alumnoDeportista.getNivelCompeticion() + "): " + alumnoDeportista.getNombre());
    }

    @Override
    public void evaluar(AlumnoDiscapacidad alumnoDiscapacidad) {
        System.out.println("[Internacional] Programas de inclusión internacionales: " + alumnoDiscapacidad.getNombre());
    }
}
