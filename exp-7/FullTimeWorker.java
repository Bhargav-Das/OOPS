// Concrete class FullTimeWorker that extends Worker
class FullTimeWorker extends Worker {
    private double monthlySalary;

    // Constructor to initialize name, id, and monthly salary
    public FullTimeWorker(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    // Implement computePay() for full-time worker
    @Override
    public double computePay() {
        return monthlySalary;
    }

    // Implement displayInfo() for full-time worker
    @Override
    public void displayInfo() {
        System.out.println("Full-Time Worker Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Monthly Salary: $" + monthlySalary);
    }
}
