// Main class to test functionality
public class WorkerDetail {
    public static void main(String[] args) {
        // Create FullTimeWorker object
        Worker fullTimeWorker = new FullTimeWorker("Alice", 101, 3000.00);
        fullTimeWorker.displayInfo();
        System.out.println("Computed Pay: $" + fullTimeWorker.computePay());
        System.out.println();

        // Create PartTimeWorker object
        Worker partTimeWorker = new PartTimeWorker("Bob", 102, 20.00, 120);
        partTimeWorker.displayInfo();
        System.out.println("Computed Pay: $" + partTimeWorker.computePay());
        System.out.println();
    }
}
