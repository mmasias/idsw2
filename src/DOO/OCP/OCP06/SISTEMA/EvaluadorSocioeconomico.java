package DOO.OCP.OCP06.SISTEMA;

public class EvaluadorSocioeconomico implements EvaluadorBecas {

    @Override
    public void evaluar(Alumno alumno) {
        System.out.println("[Socioeconómico] Renta familiar: " + alumno.getNombre());
    }

    @Override
    public void evaluar(AlumnoErasmus alumnoErasmus) {
        System.out.println("[Socioeconómico] Baremos internacionales (" + alumnoErasmus.getPaisOrigen() + "): " + alumnoErasmus.getNombre());
    }

    @Override
    public void evaluar(AlumnoVirtual alumnoVirtual) {
        System.out.println("[Socioeconómico] Costes de conectividad: " + alumnoVirtual.getNombre());
    }

    @Override
    public void evaluar(AlumnoInvestigador alumnoInvestigador) {
        System.out.println("[Socioeconómico] Financiación del grupo de investigación: " + alumnoInvestigador.getNombre());
    }

    @Override
    public void evaluar(AlumnoDeportista alumnoDeportista) {
        System.out.println("[Socioeconómico] Gastos de competición (" + alumnoDeportista.getNivelCompeticion() + "): " + alumnoDeportista.getNombre());
    }

    @Override
    public void evaluar(AlumnoDiscapacidad alumnoDiscapacidad) {
        System.out.println("[Socioeconómico] Necesidades de apoyo (" + alumnoDiscapacidad.getPorcentajeDiscapacidad() + "%): " + alumnoDiscapacidad.getNombre());
    }
}
