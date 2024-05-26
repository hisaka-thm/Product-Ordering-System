import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private String customerName;
    private Date date;
    private Product product;
    private int quantity;
    private double discount;
    private double cash;

    public Transaction(String customerName, Date date, Product product, int quantity, double discount, double cash) {
        this.customerName = customerName;
        this.date = date;
        this.product = product;
        this.quantity = quantity;

        if (discount < 5 || discount > 50) {
            throw new IllegalArgumentException("Discount must be between 5% and 50%");
        } else {
            this.discount = discount;
        }
        this.cash = cash;
    }

    // Overloaded constructor
    public Transaction(String customerName, Date date, Product product, int quantity, double cash) {
        this(customerName, date, product, quantity, 10.0, cash);  
    }

    public double getTotalAmount() {
        return product.getPrice() * quantity * (1 - discount / 100);
    }

    public double getChange() {
        return cash - getTotalAmount();
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("*************************\n");
        receipt.append("*        RECEIPT        *\n");
        receipt.append("*************************\n");

        receipt.append(String.format("Customer Name: %s\n", customerName));
        receipt.append(String.format("Date: %s\n", new SimpleDateFormat("yyyy-MM-dd").format(date)));
        receipt.append(String.format("Product: %s\n", product.getName()));
        receipt.append(String.format("Quantity: %d\n", quantity));
        receipt.append(String.format("Discount: %.2f%%\n", discount));
        receipt.append(String.format("Total Amount: ₱ %.2f\n", getTotalAmount()));
        receipt.append(String.format("Cash: ₱ %.2f\n", cash));
        receipt.append(String.format("Change: ₱ %.2f\n", getChange()));

        receipt.append("*************************\n");

        return receipt.toString();
    }
}
