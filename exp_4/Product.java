public class Product {
    private int productId;
    private String productName;
    private String category;
    private double price;
    private static int totalProducts = 0;

    public Product() {
        this.productId = 0;
        this.productName = "Default Product";
        this.category = "Default Category";
        this.price = 0.0;
        totalProducts++;
    }

    public Product(int productId, String productName, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        totalProducts++;
    }

    public double getPrice() {
        return price;
    }

    public void displayProductInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
    }

    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public double calculateStockValue(int quantity) {
        return price * quantity;
    }

    public double calculateStockValue(int quantity, double discountRate) {
        return price * quantity * (1 - discountRate);
    }

    public static void main(String[] args) {
        Product product1 = new Product();
        Product product2 = new Product(1, "Laptop", "Electronics", 1000.0);
        Product product3 = new Product(2, "Smartphone", "Electronics", 500.0);

        displayTotalProducts();

        product1.displayProductInfo();
        System.out.println("Stock Value: " + product1.calculateStockValue(10));
        System.out.println();

        product2.displayProductInfo();
        System.out.println("Stock Value: " + product2.calculateStockValue(5));
        System.out.println("Stock Value with Discount: " + product2.calculateStockValue(5, 0.1));
        System.out.println();

        product3.displayProductInfo();
        System.out.println("Stock Value: " + product3.calculateStockValue(20));
        System.out.println("Stock Value with Discount: " + product3.calculateStockValue(20, 0.15));
    }
}
