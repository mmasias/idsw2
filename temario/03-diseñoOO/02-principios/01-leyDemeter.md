# Principio de Demeter

No hables con extraños...

```java

public class Simulacion {
    public static void main(String[] args) {
        Auto auto = new Auto();
        Conductor conductor = new Conductor(auto);
        conductor.arrancarAuto();
    }
}

class Motor {
    public void arrancar() {
        System.out.println("Motor arrancado");
    }
}

class Auto {
    private Motor motor;

    public Auto() {
        motor = new Motor();
    }

    public Motor getMotor() {
        return motor;
    }
}

class Conductor {
    private Auto auto;

    public Conductor(Auto auto) {
        this.auto = auto;
    }

    public void arrancarAuto() {
        auto.getMotor().arrancar();
    }
}

```

---

```java

public class Simulacion {
    public static void main(String[] args) {
        Auto auto = new Auto();
        Conductor conductor = new Conductor(auto);
        conductor.arrancarAuto();
    }
}

class Motor {
    public void arrancar() {
        System.out.println("Motor arrancado");
    }
}

class Auto {
    private Motor motor;

    public Auto() {
        motor = new Motor();
    }

    public void arrancarMotor() {
        motor.arrancar();
    }
}

class Conductor {
    private Auto auto;

    public Conductor(Auto auto) {
        this.auto = auto;
    }

    public void arrancarAuto() {
        auto.arrancarMotor();
    }
}

```