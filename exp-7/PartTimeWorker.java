// Concrete class PartTimeWorker that extends Worker
class PartTimeWorker extends Worker {
    private double hourlyRate;
    private int hoursWorked;

    // Constructor to initialize name, id, hourly rate, and hours worked
    public PartTimeWorker(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Implement computePay() for part-time worker
    @Override
    public double computePay() {
        return hourlyRate * hoursWorked;
    }

    // Implement displayInfo() for part-time worker
    @Override
    public void displayInfo() {
        System.out.println("Part-Time Worker Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
    }
}
