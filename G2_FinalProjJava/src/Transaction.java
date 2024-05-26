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
        this.discount = discount;
        this.cash = cash;
    }

    public double getTotalAmount() {
        return product.getPrice() * quantity * (1 - discount / 100);
    }

    public double getChange() {
        return cash - getTotalAmount();
    }

    @Override
    public String toString() {
        return "Customer Name: " + customerName + "\n"
            + "Date: " + new SimpleDateFormat("yyyy-MM-dd").format(date) + "\n"
            + "Product: " + product.getName() + "\n"
            + "Quantity: " + quantity + "\n"
            + "Discount: " + discount + "%\n"
            + "Total Amount: " + getTotalAmount() + "\n"
            + "Cash: " + cash + "\n"
            + "Change: " + getChange() + "\n";
    }
}
