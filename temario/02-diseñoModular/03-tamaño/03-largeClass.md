# Large Class

Ocurre cuando una clase hace demasiado y tiene demasiadas responsabilidades. Generalmente, una clase grande posee un gran número de campos y métodos, lo que dificulta su comprensión, mantenimiento y extensión. Una clase así viola el principio de responsabilidad única, ya que maneja más de una responsabilidad.

## Ejemplo

### Problema

```java

public class PatientManagement {
    private String patientId;
    private String name;
    private String address;
    private Date dateOfBirth;
    private List<Appointment> appointments;
    private List<Treatment> treatments;
    private Map<Date, String> medicalNotes;

    public PatientManagement(String patientId, String name, String address, Date dateOfBirth) {
        this.patientId = patientId;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.appointments = new ArrayList<>();
        this.treatments = new ArrayList<>();
        this.medicalNotes = new HashMap<>();
    }

    // Métodos para gestionar citas
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    // Métodos para gestionar tratamientos
    public void addTreatment(Treatment treatment) {
        treatments.add(treatment);
    }

    // Métodos para notas médicas
    public void addMedicalNote(Date date, String note) {
        medicalNotes.put(date, note);
    }

    public void updateMedicalNote(Date date, String note) {
        medicalNotes.replace(date, note);
    }

    // Otros métodos relacionados con el paciente
}


```

### Solución propuesta

```java

public class Patient {
    private String patientId;
    private String name;
    private String address;
    private Date dateOfBirth;

    public Patient(String patientId, String name, String address, Date dateOfBirth) {
        this.patientId = patientId;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters y setters básicos
}

public class AppointmentManager {
    private List<Appointment> appointments;

    public AppointmentManager() {
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    // Otros métodos específicos para la gestión de citas
}

public class TreatmentManager {
    private List<Treatment> treatments;

    public TreatmentManager() {
        this.treatments = new ArrayList<>();
    }

    public void addTreatment(Treatment treatment) {
        treatments.add(treatment);
    }

    // Métodos específicos para la gestión de tratamientos
}

public class MedicalNotesManager {
    private Map<Date, String> medicalNotes;

    public MedicalNotesManager() {
        this.medicalNotes = new HashMap<>();
    }

    public void addMedicalNote(Date date, String note) {
        medicalNotes.put(date, note);
    }

    public void updateMedicalNote(Date date, String note) {
        medicalNotes.replace(date, note);
    }

    // Métodos específicos para la gestión de notas médicas
}


```

- **Claridad mejorada**: Al dividir la clase original en partes más pequeñas, cada nueva clase tiene una responsabilidad clara y bien definida, lo que mejora significativamente la claridad del código.
- **Facilidad de mantenimiento y extensión**: Modificar o extender una parte específica del sistema (como la gestión de citas o tratamientos) es ahora más fácil y seguro, dado que los cambios en una parte no afectan directamente a las otras.
- **Mejor reusabilidad**: Las clases más pequeñas y enfocadas son más fáciles de reutilizar en otras partes de la aplicación o incluso en diferentes proyectos.
