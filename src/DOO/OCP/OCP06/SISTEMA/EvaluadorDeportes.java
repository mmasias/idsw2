package DOO.OCP.OCP06.SISTEMA;

public class EvaluadorDeportes implements EvaluadorBecas {

    @Override
    public void evaluar(Alumno alumno) {
        System.out.println("[Deportes] Sin modalidad deportiva registrada: " + alumno.getNombre());
    }

    @Override
    public void evaluar(AlumnoErasmus alumnoErasmus) {
        System.out.println("[Deportes] Movilidad y rendimiento deportivo (" + alumnoErasmus.getPaisOrigen() + "): " + alumnoErasmus.getNombre());
    }

    @Override
    public void evaluar(AlumnoVirtual alumnoVirtual) {
        System.out.println("[Deportes] Modalidades deportivas online: " + alumnoVirtual.getNombre());
    }

    @Override
    public void evaluar(AlumnoInvestigador alumnoInvestigador) {
        System.out.println("[Deportes] Actividad física complementaria a investigación: " + alumnoInvestigador.getNombre());
    }

    @Override
    public void evaluar(AlumnoDeportista alumnoDeportista) {
        System.out.println("[Deportes] " + alumnoDeportista.getDeporte() + " - nivel " + alumnoDeportista.getNivelCompeticion() + ": " + alumnoDeportista.getNombre());
    }

    @Override
    public void evaluar(AlumnoDiscapacidad alumnoDiscapacidad) {
        System.out.println("[Deportes] Deporte adaptado (" + alumnoDiscapacidad.getPorcentajeDiscapacidad() + "%): " + alumnoDiscapacidad.getNombre());
    }
}
