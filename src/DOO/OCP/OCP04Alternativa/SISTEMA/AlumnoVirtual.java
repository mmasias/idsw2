package DOO.OCP.OCP04Alternativa.SISTEMA;

public class AlumnoVirtual extends Alumno {
    private String plataformaVirtual;
    private boolean requiereExamenesPresenciales;

    public AlumnoVirtual(String id, String nombre, String email,
                         String plataformaVirtual, boolean requiereExamenesPresenciales) {
        super(id, nombre, email);
        this.plataformaVirtual = plataformaVirtual;
        this.requiereExamenesPresenciales = requiereExamenesPresenciales;
        this.tasaMatricula = 800.0;
    }

    public boolean requiereExamenesPresenciales() { return requiereExamenesPresenciales; }
}
