public class sup {
    private int privateVar = 10;

    public int getPrivateVar() {
        return privateVar;
    }

    public static void main(String[] args) {
        sub obj = new sub();
        System.out.println("Private variable accessed through getter: " + obj.getPrivateVar());
    }
}

class sub extends sup {
    public void display() {
        // System.out.println(privateVar); // This will cause a compilation error
        System.out.println("Private variable accessed through getter: " + getPrivateVar());
    }
}
