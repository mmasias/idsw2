# Relaciones entre clases

<div align=center>

<big>Un objeto en sí mismo no es interesante.Los objetos contribuyen<br>al comportamiento de un sistema colaborando con otros objetos</big><br><i>Grady Booch - Análisis y Diseño Orientado a Objetos. 1996</i>

</div>

A la relación entre clases ahora se le llama "dependencia".

<div align=center>

|Por colaboración|Por transmisión|
|-|-|
|A través del paso de mensajes|Mediante la transmisión de todos sus miembros, atributos y métodos, para organizar una jerarquía de clasificación, sin negar ni obligar a la colaboración entre objetos de las clases participantes.|
|• Composición|• Herencia por extensión|
|• Agregación|• Herencia por implementación|
|• Asociación||
|• Uso||

</div>

## Relaciones por colaboración

<div align=center>

![](/images/modelosUML/relacionClases.svg)

</div>

|Característica|Definición|Ejemplo||
|-|-|-|-|
|**Visibilidad**|Determina el alcance de acceso a un objeto colaborador, estableciendo si la relación es exclusiva (privada) o compartida (pública) con otros objetos del sistema.|**Privada:** Una persona con su diario personal que nadie más puede leer.<br><br>**Pública:** Un libro de la biblioteca que puede ser consultado por cualquier usuario registrado.|**Privada:** Un `DocumentoWord` mantiene una referencia exclusiva a su `Historial` de cambios que no es accesible por otros objetos.<br><br>**Pública:** Una instancia de `ImpresoraDeRed` es accesible y utilizada por múltiples objetos `Usuario` simultáneamente.|
|**Temporalidad**|Define la duración de la relación de colaboración entre objetos, clasificándola en efímera (limitada a una operación específica), acotada (por un período definido) o persistente (durante toda la vida del objeto).|**Efímera:** Un pasajero que interactúa con un conductor de taxi solo durante un viaje.<br><br>**Persistente:** Una persona y su teléfono móvil que mantiene durante años.|**Efímera:** Un objeto `Validador` que colabora con un objeto `DatosFormulario` solo durante el proceso de validación.<br><br>**Persistente:** Un objeto `Documento` que mantiene una colaboración continua con sus objetos `Párrafo` durante toda su existencia.|
|**Versatilidad**|Representa el grado de intercambiabilidad de los objetos colaboradores, indicando si un objeto requiere colaborar con una instancia específica o puede trabajar con cualquier instancia que cumpla una interfaz determinada.|**Baja versatilidad:** Una llave específica que solo abre una cerradura concreta.<br><br>**Alta versatilidad:** Un conductor que puede manejar cualquier automóvil con transmisión automática.|**Baja versatilidad:** Un objeto `ReproductorDeVideo` que solo puede reproducir archivos de un `FormatoEspecífico`.<br><br>**Alta versatilidad:** Un objeto `Notificador` que puede enviar mensajes a través de cualquier objeto que implemente la interfaz `MedioDeNotificación` (email, SMS, notificación push).|

### Composición & Agregación

Se puede determinar que existe una relación de composición entre la clase A (el todo) y la clase B (la parte) si un objeto de la clase A “tiene un” / "contiene" / "posee" un objeto de la clase B.

<div align=center>

||Composición|Agregación|
|-|-|-|
|Definición|Es una relación entre el todo y la parte donde el ciclo de vida de la parte está controlado por el todo. Representa una asociación "tiene un" donde la dependencia es fuerte.|Es una relación entre el todo y la parte donde el ciclo de vida de la parte es independiente del todo. Representa una asociación "tiene un" donde la dependencia es débil.|
|Dependencia del ciclo de vida|La vida del objeto de la clase contenida debe coincidir con la vida de la clase contenedor.|La vida del objeto de la clase contenida NO debe coincidir con la vida de la clase contenedor.|
|Naturaleza de los componentes|Los componentes constituyen una parte esencial e indispensable del objeto compuesto.|Los componentes constituyen OPCIONALMENTE una parte del objeto compuesto.|
|Efecto de la supresión|La supresión del objeto compuesto conlleva la supresión de los componentes.|La destrucción del compuesto NO conlleva la destrucción de los componentes.|
|Exclusividad|Los componentes NO pueden ser compartidos por varios objetos compuestos.|Los componentes pueden ser compartidos por varios compuestos.|
|Tipo de composición|Conocida como "composición fuerte".|Conocida como "composición débil".|
|**Visibilidad**|Privada|Pública/Protegida|
|**Temporalidad**|Alta|Baja|
|**Versatilidad**|Baja|Alta|
|**Implantación**|Mediante atributos privados con instanciación en el constructor del objeto contenedor, garantizando así que el ciclo de vida del componente esté estrictamente vinculado al del objeto que lo contiene.|El objeto contenido (Parte) se crea fuera del objeto contenedor (Todo) y se proporciona a través del constructor o un método setter|
|Ejemplo|Persona y cabeza: una cabeza solo puede pertenecer a una persona y no puede existir sin ella.|Persona y familia: una persona puede pertenecer a múltiples familias a lo largo de su vida y seguir existiendo aunque las familias dejen de existir.|
|Ejemplo|Documento y párrafos: al eliminar un documento se eliminan todos sus párrafos, que no existen fuera del documento.|Universidad y estudiantes: los estudiantes pueden existir antes de ingresar y después de salir de la universidad, y pueden pertenecer a varias instituciones educativas simultáneamente.|

<table>
<tr><th>Composición</th><th>Agregación</th></tr>
<tr><td valign=top>

```java
class Libro {
    private Pagina[] paginas;
    
    public Libro() {
        this.paginas = new Pagina[100];
        for (int i = 0; i < 100; i++) {
            this.paginas[i] = new Pagina();
        }
    }
}

class Pagina {

}
```
</td><td valign=top>

```java
class Equipo {
    private Jugador[] jugadores;
    
    public Equipo(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public void addJugador(Jugador jugador)

    public void removeJugador(Jugador jugador)
}

class Jugador {
    private String nombre;
    
    public Jugador(String nombre) {
        this.nombre = nombre;
    }
}
```
</td></tr>
</table>

</div>

### Asociación & Uso

<div align=center>

|Característica|Asociación|Uso|
|-|-|-|
|Definición|Es la relación que perdura entre un cliente y un servidor determinado, donde se establece una dependencia funcional pero no existencial.|Es la relación que se establece momentáneamente entre un cliente y cualquier servidor, donde el cliente utiliza los servicios del servidor de forma puntual sin crear una dependencia permanente.|
|Naturaleza|Representa una conexión donde un objeto utiliza los servicios de otro objeto para cumplir su responsabilidad, manteniéndose ambos independientes en su ciclo de vida.|Representa una conexión temporal donde un objeto (cliente) utiliza los servicios de otro objeto (servidor) para cumplir una tarea específica, sin mantener una referencia persistente.|
|Dependencia|El objeto cliente depende de los servicios que proporciona el objeto servidor, pero no de su existencia como tal.|El objeto cliente requiere temporalmente del servidor para completar una operación específica, pero no mantiene una dependencia a largo plazo.|
|Temporalidad|La relación puede establecerse y mantenerse a lo largo del tiempo en diversos momentos, no necesariamente de manera continua.|La relación es transitoria y existe únicamente durante la ejecución de una operación concreta, sin persistir después de completada.|
|Exclusividad|No implica exclusividad; un servidor puede atender a múltiples clientes y un cliente puede relacionarse con varios servidores.|No existe exclusividad; el cliente puede utilizar cualquier servidor que ofrezca el servicio requerido en ese momento.|
|**Visibilidad**|Privada|Pública y Privada|
|**Temporalidad**|Alta/Media|Baja|
|**Versatilidad**|Baja|Alta|
|**Implantación**|Mediante atributos y constructor, métodos de asociación o referencias privadas con ciclo de vida igual al objeto|Típicamente mediante parámetros de método o variables locales con un ámbito limitado, donde la referencia al objeto servidor existe únicamente durante la ejecución del método en el que se utiliza. No se almacena como atributo de la clase cliente, lo que evita crear dependencias permanentes y favorece un bajo acoplamiento entre componentes.|
|Ejemplo|Persona (cliente) y banco (servidor): la persona utiliza los servicios del banco para gestionar su dinero, pero ambos existen independientemente.|Un ciudadano (cliente) que utiliza un autobús (servidor) para desplazarse en un trayecto específico, sin compromiso de utilizarlo nuevamente.|
|Ejemplo|Objeto Editor (cliente) y objeto Archivo (servidor): el editor utiliza los servicios del archivo para cargar y guardar contenido, pero ambos tienen ciclos de vida independientes.|Un método que utiliza un objeto formateador temporalmente para convertir datos a una representación específica, sin almacenarlo como atributo.|


<table>
<tr><th>Asociación</th><th>Uso</th></tr>
<tr><td valign=top>

```java
class Ordenador {
    private DiscoSSD disco;
    
    public Ordenador(DiscoSSD discoSSD) {
        this.disco = discoSSD;
    }
}

class DiscoSSD {
    private int capacidadGB;
    
    public DiscoSSD(int capacidadGB) {
        this.capacidadGB = capacidadGB;
    }
}
```
</td><td valign=top>

```java
class Alumno {
   public void viaje(Autobus autobus){
      autobus.subir();
      autobus.pagarBoleto();
      autobus.bajar();
   }
}

class Autobus {
   public void subir() {};
   public void pagarBoleto() {};
   public void bajar() {};
}
```
</td></tr>
</table>

</div>

### Resumen

<div align=center>

|![](/images/modelosUML/relacionClases.svg)
|-
|![](/images/caau.png)

||||
|-|-|-|
|Composición|![](/images/composicion.png)|"todo-parte" en la que el "todo" controla la creación y eliminación de las partes. El objeto principal es responsable de la creación y la destrucción de los objetos secundarios, y los objetos secundarios no pueden existir sin el objeto principal.
|Agregación|![](/images/agregacion.png)|"todo-parte" en la que las partes pueden existir sin el objeto principal. En este caso, el objeto principal tiene una referencia a los objetos secundarios, pero no controla su creación ni su eliminación.
|Asociación|![](/images/asociacion.png)|Ambos pueden existir de forma independiente. La asociación puede ser unidireccional o bidireccional, y puede tener multiplicidades que indican cuántos objetos están involucrados en la relación.
|Uso|![](/images/uso.png)|Un objeto utiliza los servicios o características de otro objeto, sin ser una parte del objeto utilizado. Esta relación es más débil que la asociación y no implica una relación estructural.

</div>

La decisión de utilizar una agregación es discutible y suele ser arbitraria. Con frecuencia, no resulta evidente que una asociación deba ser modelada en forma de agregación, En gran parte, este tipo de incertidumbre es típico del modelado; este requiere un juicio bien formado y hay pocas reglas inamovibles. La experiencia demuestra que si uno piensa cuidadosamente e intenta ser congruente la distinción imprecisa entre asociación ordinaria y agregación no da lugar a problemas en la práctica. — Rumbaugh 1991

No existe para toda colaboración un relación ideal categórica. Es muy frecuente que sean varias relaciones candidatas, cada una con sus ventajas y desventajas. Por tanto, al existir diversas alternativas, será una decisión de ingeniería, un compromiso entre múltiples factores no cuantificables: costes, modularidad, legibilidad, eficiencia, etc., la que determine la relación final.

### Propuesta

|Usar|Composición|Agregación|Asociación|Uso|
|-|-|-|-|-|
|**Cuando...**|La parte no tiene sentido o no puede existir sin el todo|Las partes pueden existir independientemente del todo|Se necesita una relación duradera pero no de contenencia|La interacción es temporal y limitada a operaciones específicas|
||Se quiera garantizar que cuando el objeto contenedor sea destruido, sus partes también lo sean|Varios objetos "todo" pueden compartir las mismas partes|Los objetos colaboran pero mantienen identidades separadas|Se quiera minimizar el acoplamiento entre clases|
||Se necesita un control estricto sobre el ciclo de vida de los componentes|Se necesita flexibilidad para añadir o quitar componentes durante la vida del objeto contenedor|La relación es más bien "trabaja con" en lugar de "tiene un"|No se necesita mantener una referencia persistente al otro objeto|
||La relación es claramente "***es parte de***" y no solo "***usa a***"|La relación es "***tiene un***" pero sin control existencial|Ambos objetos tienen ciclos de vida independientes|La relación es claramente "***usa temporalmente a***"|

Dicho esto...

En la práctica, estas decisiones suelen basarse en:

- El análisis conceptual del dominio del problema.
- Consideraciones sobre mantenibilidad y flexibilidad.
- Requisitos de rendimiento y eficiencia.
- Patrones de diseño aplicables al contexto específico.

> Un enfoque pragmático es comenzar con la relación más débil posible (Uso) y fortalecer la relación solo cuando sea necesario, siguiendo principios como el bajo acoplamiento y la alta cohesión.

### Ejemplo: sistema de gestión de documentos

<div align=center>

|Relación|Clases|Justificación|
|-|-|-|
|COMPOSICIÓN|Documento y Contenido|El contenido no puede existir sin el documento y su ciclo de vida está ligado al documento
|AGREGACIÓN|Carpeta y Documento|Los documentos pueden existir independientemente de la carpeta
|||La carpeta no crea los documentos, solo los agrega
|ASOCIACIÓN|Usuario y Documento|Relación duradera donde el usuario edita documentos específicos
|||El usuario mantiene una referencia al documento que está editando
|USO|Impresor y Documento|El impresor utiliza temporalmente el documento solo para imprimirlo
|||Utiliza el documento solo durante la ejecución de este método
|||No mantiene una referencia al documento después de la impresión

</div>

```java
class Documento {
    private Contenido contenido;
    
    public Documento(String texto) {
        this.contenido = new Contenido(texto);
    }
}

class Contenido {
    private String texto;
    
    public Contenido(String texto) {
        this.texto = texto;
    }
}

class Carpeta {
    private List<Documento> documentos;
    
    public Carpeta() {
        this.documentos = new ArrayList<>();
    }
 
    public void agregarDocumento(Documento doc) {
        documentos.add(doc);
    }
    
    public void eliminarDocumento(Documento doc) {
        documentos.remove(doc);
    }
}

class Usuario {
    private String nombre;
    private List<Documento> documentosRecientes;
    
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.documentosRecientes = new ArrayList<>();
    }
    public void abrirDocumento(Documento doc) {
        documentosRecientes.add(doc);
    }
}

class Impresor {
    public void imprimir(Documento doc, int copias) {
        System.out.println("Imprimiendo documento...");
    }
}
```

## Relaciones por transmisión

Herencia

|Por especialización|Por extensión|Por limitación|Por construcción|
|-|-|-|-|
La clase descendiente implementa todas las operaciones de la clase base, añadiendo o redefiniendo partes especializadas|La especialización transforma el concepto de la clase base a la clase derivada|La clase descendiente ***no implementa todas*** las operaciones de la clase base, completamente desaconsejada porque imposibilita el tratamiento polimórfico|La clase utiliza la herencia simplemente como un mecanismo de reutilización de código, no de modelado de conceptos: realmente es una relación de composición.
|Bien|Bien|***¡Mal!***|***¡Mal!***|

### Por especialización

```java
class Coordenada {
    private float x;
    private float y;
    
    public Coordenada(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public float getX() {
        return x;
    }
    
    public void setX(float x) {
        this.x = x;
    }
    
    public float getY() {
        return y;
    }
    
    public void setY(float y) {
        this.y = y;
    }
}
abstract class Figura {
    protected Coordenada centro;
    
    public Figura(Coordenada centro) {
        this.centro = centro;
    }
    
    public void mover(float x, float y) {
        centro.setX(centro.getX() + x);
        centro.setY(centro.getY() + y);
    }
    
    public Coordenada getCentro() {
        return centro;
    }
    
    public abstract float getPerimetro();
    
    public abstract float getArea();
}

class Circulo extends Figura {
    private float radio;
    
    public Circulo(Coordenada centro, float radio) {
        super(centro);
        this.radio = radio;
    }
    
    public float getRadio() {
        return radio;
    }
    
    @Override
    public float getPerimetro() {
        return 2 * (float)Math.PI * radio;
    }
    
    @Override
    public float getArea() {
        return (float)Math.PI * radio * radio;
    }
}

class Rectangulo extends Figura {
    private float ancho;
    private float alto;
    
    public Rectangulo(Coordenada centro, float ancho, float alto) {
        super(centro);
        this.ancho = ancho;
        this.alto = alto;
    }
    
    public float getAncho() {
        return ancho;
    }
    
    public float getAlto() {
        return alto;
    }
    
    @Override
    public float getPerimetro() {
        return 2 * (ancho + alto);
    }
    
    @Override
    public float getArea() {
        return ancho * alto;
    }
}
```

### Por extensión

```java
class Cuenta {
    protected double saldo;
    
    public void depositar(double monto) {
        saldo = saldo + monto;
    }
    
    public boolean retirar(double monto) {
        if (monto <= saldo) {
            saldo = saldo - monto;
            return true;
        }
        return false;
    }
}

class CuentaRemunerada extends Cuenta {
    private double tasaInteres;
    
    public CuentaRemunerada(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
    
    public void aplicarInteres() {
        double interes = saldo * tasaInteres;
        depositar(interes);
    }
}
```

### Herencia por limitación

```java

abstract class DispositivoElectronico {
    void encender();
    void apagar();
    void conectarWiFi();
}

class RelojDigital extends DispositivoElectronico {

    public void encender() {
        (...)
    }
    
    public void apagar() {
        (...)
    }
    
    public void conectarWiFi() {
        throw new UnsupportedOperationException("Este reloj no soporta WiFi");
    }
}
```

### Herencia por construcción

```java
class BaseDeDatos {
    protected Connection conexion;
    
    public void conectar() {
        (...)        
    }
    
    public void desconectar() {
        (...)        
    }
}

class Reporte extends BaseDeDatos {   

    public void generarReporte() {
        conectar();
        
        (...)

        desconectar();
    }
}
```

## Comparativa entre Herencia y Composición

| Aspecto | Composición | Herencia |
|-|-|-|
| **Relación** | **"Tiene un"** - Establece una relación de contención donde un objeto contiene a otro como parte de su estructura. | **"Es un"** - Establece una relación de tipo o subtipo (ISA - Is A relationship) donde la clase derivada es un tipo específico de la clase base. |
| **Concepto** | Permite a una clase contener instancias de otras clases como atributos, delegando funcionalidades a estos componentes. | Permite a una clase heredar características (atributos y métodos) de otra clase, estableciendo una jerarquía de especialización. |
| **Acoplamiento** | **Bajo acoplamiento** - Los cambios en la clase componente tienen menor impacto en la clase contenedora. | **Alto acoplamiento** - Los cambios en la clase base pueden afectar a todas las clases derivadas. |
| **Flexibilidad** | **Mayor flexibilidad** - Los componentes pueden cambiarse en tiempo de ejecución y una clase puede combinar múltiples componentes. | **Menor flexibilidad** - La relación se establece en tiempo de compilación y no puede alterarse dinámicamente. |
| **Ejemplo práctico** | Un `Automóvil` tiene un `Motor`, un `Sistema de frenos` y `Ruedas`. El automóvil delega funcionalidades específicas a cada componente. | Un `Todoterreno` es un `Automóvil`. El Todoterreno hereda todas las características generales de un automóvil, añadiendo o modificando algunas específicas. |
| **Cuando usar** | - Cuando la relación entre objetos puede cambiar en el tiempo<br>- Cuando se necesita reutilizar componentes en diferentes contextos<br>- Cuando la clase "contenedora" necesita utilizar múltiples funcionalidades de varias clases | - Cuando existe una clara relación "es un"<br>- Cuando se quiere reutilizar código de la clase base<br>- Cuando se necesita que las subclases sean tratadas como la clase base (polimorfismo) |
| **Recomendación** | Preferir la composición en caso de duda, ya que ofrece mayor flexibilidad y menor acoplamiento. | Usar herencia solo cuando existe una genuina relación taxonómica y todas las instancias de la subclase pueden sustituir a la clase base sin problemas. |
| **Regla práctica** | **"Favorece la composición sobre la herencia"** - Principio general de diseño orientado a objetos. | Si un objeto puede tener más de una instancia del componente, la herencia no es apropiada. Usar composición. |

## Explicación adicional

La decisión entre usar herencia o composición es fundamental en el diseño orientado a objetos:

|Herencia|Composición|
|-|-|
|Permite modelar relaciones donde una entidad es un tipo específico de otra. Refleja una especialización conceptual y facilita el polimorfismo.|Permite crear objetos complejos combinando objetos más simples como partes.|
|Sin embargo, crea un acoplamiento fuerte entre clases y puede llevar a jerarquías complejas difíciles de mantener.|Ofrece mayor flexibilidad al poder cambiar componentes en tiempo de ejecución y facilita la reutilización de código sin crear dependencias fuertes.|

En la práctica, muchos desarrolladores siguen el principio "favorece la composición sobre la herencia" para crear diseños más flexibles y mantenibles. La herencia se reserva para casos donde existe una clara relación taxonómica que se mantendrá estable en el tiempo.
