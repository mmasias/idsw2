
<div align=center>

![](/images/modelosUML/modelosUML/herenciaBajoComposicion.svg)

</div>

```java
abstract class Vehicle {
    public abstract void start();
    public abstract void changeGear();
}

class GasolineManualVehicle extends Vehicle {
    @Override
    public void start() {
        System.out.println("Gasoline engine starting...");
    }

    @Override
    public void changeGear() {
        System.out.println("Changing gear manually...");
    }
}

class GasolineAutomaticVehicle extends Vehicle {
    @Override
    public void start() {
        System.out.println("Gasoline engine starting...");
    }

    @Override
    public void changeGear() {
        System.out.println("Changing gear automatically...");
    }
}

class ElectricManualVehicle extends Vehicle {
    @Override
    public void start() {
        System.out.println("Electric engine starting...");
    }

    @Override
    public void changeGear() {
        System.out.println("Changing gear manually...");
    }
}

class ElectricAutomaticVehicle extends Vehicle {
    @Override
    public void start() {
        System.out.println("Electric engine starting...");
    }

    @Override
    public void changeGear() {
        System.out.println("Changing gear automatically...");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle gasolineManualCar = new GasolineManualVehicle();
        Vehicle gasolineAutomaticCar = new GasolineAutomaticVehicle();
        Vehicle electricManualCar = new ElectricManualVehicle();
        Vehicle electricAutomaticCar = new ElectricAutomaticVehicle();

        gasolineManualCar.start();
        gasolineManualCar.changeGear();

        gasolineAutomaticCar.start();
        gasolineAutomaticCar.changeGear();

        electricManualCar.start();
        electricManualCar.changeGear();

        electricAutomaticCar.start();
        electricAutomaticCar.changeGear();
    }
}

```