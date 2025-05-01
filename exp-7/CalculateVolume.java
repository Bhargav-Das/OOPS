// Main class to test the implementation
public class CalculateVolume {
    public static void main(String[] args) {
        // Create a Cuboid object with dimensions 3, 4, and 5
        Cuboid cuboid = new Cuboid(3, 4, 5);
        System.out.println("Cuboid Volume: " + cuboid.calculateVolume());

        // Create a Sphere object with radius 7
        Sphere sphere = new Sphere(7);
        System.out.println("Sphere Volume: " + sphere.calculateVolume());
    }
}
