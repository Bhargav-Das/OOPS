// Abstract class Solid with an abstract method calculateVolume()
abstract class Solid {
    // Abstract method to calculate volume
    public abstract double calculateVolume();
}

// Concrete class Cuboid that extends Solid
class Cuboid extends Solid {
    private double length;
    private double width;
    private double height;

    // Constructor to initialize dimensions of Cuboid
    public Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // Override calculateVolume() to compute the volume of a cuboid
    @Override
    public double calculateVolume() {
        return length * width * height;
    }
}
