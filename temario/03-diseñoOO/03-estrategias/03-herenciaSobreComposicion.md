<div align=center>

![](/images/modelosUML/modelosUML/composicionBajoHerencia.svg)

</div>

```java
interface AreaCalculator {
    double calculateArea();
}

class RectangleAreaCalculator implements AreaCalculator {
    private double width;
    private double height;

    public RectangleAreaCalculator(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

class CircleAreaCalculator implements AreaCalculator {
    private double radius;

    public CircleAreaCalculator(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

interface PerimeterCalculator {
    double calculatePerimeter();
}

class RectanglePerimeterCalculator implements PerimeterCalculator {
    private double width;
    private double height;

    public RectanglePerimeterCalculator(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}

class CirclePerimeterCalculator implements PerimeterCalculator {
    private double radius;

    public CirclePerimeterCalculator(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Shape {
    private AreaCalculator areaCalculator;
    private PerimeterCalculator perimeterCalculator;

    public Shape(AreaCalculator areaCalculator, PerimeterCalculator perimeterCalculator) {
        this.areaCalculator = areaCalculator;
        this.perimeterCalculator = perimeterCalculator;
    }

    public double getArea() {
        return areaCalculator.calculateArea();
    }

    public double getPerimeter() {
        return perimeterCalculator.calculatePerimeter();
    }
}


public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Shape(new RectangleAreaCalculator(5, 10), new RectanglePerimeterCalculator(5, 10));
        Shape circle = new Shape(new CircleAreaCalculator(7), new CirclePerimeterCalculator(7));

        System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Rectangle perimeter: " + rectangle.getPerimeter());
        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Circle perimeter: " + circle.getPerimeter());
    }
}

```