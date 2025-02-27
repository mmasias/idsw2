# Primitive Obssesion

Ocurre cuando se utilizan tipos primitivos para representar conceptos más complejos. En lugar de aprovechar las ventajas de la orientación a objetos, como la encapsulación y el uso de tipos más específicos, se abusa de los tipos primitivos (como int, string, double, etc.). Esto puede llevar a un código menos claro y más propenso a errores, ya que se pierde contexto sobre cómo se deben manejar estos "primitivos".

## Ejemplo

### Problema


```java

public class User {
    private String name;
    private String street;
    private String city;
    private String zipCode;
    private String country;

    public User(String name, String street, String city, String zipCode, String country) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    // Getters y setters para cada campo
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

```

### Solución propuesta

```java

public class Address {
    private String street;
    private String city;
    private String zipCode;
    private String country;

    public Address(String street, String city, String zipCode, String country) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    // Getters y setters para cada campo
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

public class User {
    private String name;
    private Address address;

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

```

- **Mejor organización del código**: Se mejora la organización del código al agrupar datos relacionados en clases específicas.
- **Reducción de errores**: Se facilita la validación y el manejo de datos específicos como los códigos postales y las direcciones, reduciendo la posibilidad de errores.
- **Facilidad de mantenimiento**: Si se necesitan cambios relacionados con la dirección, se pueden realizar fácilmente en la clase Address sin afectar a otras partes del código.