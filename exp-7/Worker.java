// Abstract class Worker with abstract methods computePay() and displayInfo()
abstract class Worker {
    protected String name;
    protected int id;

    // Constructor to initialize name and id
    public Worker(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Abstract method to compute pay (to be implemented in subclasses)
    public abstract double computePay();

    // Abstract method to display worker information (to be implemented in subclasses)
    public abstract void displayInfo();
}



