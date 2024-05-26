public class Product extends Item {
    public Product(String name, double price) {
        super(name, price);
    }

    // Overloaded constructor
    public Product(String name) {
        super(name, 0.0); 
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: " + price;
    }
}
