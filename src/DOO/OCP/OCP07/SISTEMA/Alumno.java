package DOO.OCP.OCP07.SISTEMA;

public class Alumno {
    private String id;
    private String nombre;
    private String email;
    protected double tasaMatricula = 1000.0;

    public Alumno(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }

    public void solicitarBeca(EvaluadorBecas evaluador) {
        evaluador.evaluar(this);
    }
}
