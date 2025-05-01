// Concrete class Sphere that extends Solid
class Sphere extends Solid {
    private double radius;

    // Constructor to initialize radius of Sphere
    public Sphere(double radius) {
        this.radius = radius;
    }

    // Override calculateVolume() to compute the volume of a sphere
    @Override
    public double calculateVolume() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }
}
