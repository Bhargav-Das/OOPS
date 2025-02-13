public class Car extends Vehicle {

    public Car(String make, String model) {
        super(make, model);
    }

    @Override
    public void startEngine() {
        System.out.println("Car engine starting");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car engine stopping");
    }

    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Camry");
        myCar.startEngine();
        myCar.stopEngine();
        myCar.serviceInfo();
    }
}
