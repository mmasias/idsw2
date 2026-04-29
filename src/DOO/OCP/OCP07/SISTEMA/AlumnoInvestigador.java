package DOO.OCP.OCP07.SISTEMA;

public class AlumnoInvestigador extends Alumno {
    private String areaInvestigacion;

    public AlumnoInvestigador(String id, String nombre, String email, String areaInvestigacion) {
        super(id, nombre, email);
        this.areaInvestigacion = areaInvestigacion;
    }

    public String getAreaInvestigacion() { return areaInvestigacion; }

    @Override
    public void solicitarBeca(EvaluadorBecas evaluador) {
        evaluador.evaluar(this);
    }
}
