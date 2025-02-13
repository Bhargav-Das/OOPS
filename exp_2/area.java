public class area {
    // Method to calculate the area of a rectangle
    public double calculateArea(double length, double breadth) {
        return length * breadth;
    }

    // Method to calculate the area of a square
    public double calculateArea(double side) {
        return side * side;
    }

    // Method to calculate the area of a circle
    public double calculateArea(double radius, boolean isCircle) {
        if (isCircle) {
            return Math.PI * radius * radius;
        }
        return 0;
    }

    // Method to calculate the area of a triangle
    public double calculateArea(double base, double height, boolean isTriangle) {
        if (isTriangle) {
            return 0.5 * base * height;
        }
        return 0;
    }

    public static void main(String[] args) {
        area shape = new area();

        // Rectangle
        System.out.println("Area of Rectangle: " + shape.calculateArea(5, 10));

        // Square
        System.out.println("Area of Square: " + shape.calculateArea(4));

        // Circle
        System.out.println("Area of Circle: " + shape.calculateArea(7, true));

        // Triangle
        System.out.println("Area of Triangle: " + shape.calculateArea(6, 8, true));
    }
}
