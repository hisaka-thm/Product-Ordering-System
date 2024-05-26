import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleProductOrdering extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField customerNameField, dateField, quantityField, discountField, cashField;
    private JComboBox<String> productComboBox;
    private JTextArea outputArea;
    private JButton orderButton;

    private Product[] products = {
        new Product("Toblerone", 55.00),
        new Product("Snickers", 25.00),
        new Product("Hershey", 45.00),
        new Product("Baby Ruth", 68.00),
        new Product("Kit Kat", 34.00)
    };

    public SimpleProductOrdering() {
        setTitle("Simple Product Ordering System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(7, 2));
        add(inputPanel, BorderLayout.NORTH);

        inputPanel.add(new JLabel("Customer Name:"));
        customerNameField = new JTextField();
        inputPanel.add(customerNameField);

        inputPanel.add(new JLabel("Date (yyyy-MM-dd):"));
        dateField = new JTextField(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        inputPanel.add(dateField);

        inputPanel.add(new JLabel("Product:"));
        productComboBox = new JComboBox<>();
        for (Product product : products) {
            productComboBox.addItem(product.getName());
        }
        inputPanel.add(productComboBox);

        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        inputPanel.add(new JLabel("Discount (%):"));
        discountField = new JTextField();
        inputPanel.add(discountField);

        inputPanel.add(new JLabel("Cash:"));
        cashField = new JTextField();
        inputPanel.add(cashField);

        orderButton = new JButton("Place Order");
        inputPanel.add(orderButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    placeOrder();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SimpleProductOrdering.this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void placeOrder() throws Exception {
        String customerName = customerNameField.getText();
        if (customerName.isEmpty()) throw new Exception("Customer name is required");

        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateField.getText());
        } catch (Exception e) {
            throw new Exception("Invalid date format");
        }

        Product product = products[productComboBox.getSelectedIndex()];
        int quantity;
        try {
            quantity = Integer.parseInt(quantityField.getText());
        } catch (NumberFormatException e) {
            throw new Exception("Invalid quantity");
        }

        double discount;
        try {
            discount = Double.parseDouble(discountField.getText());
        } catch (NumberFormatException e) {
            throw new Exception("Invalid discount");
        }

        double cash;
        try {
            cash = Double.parseDouble(cashField.getText());
        } catch (NumberFormatException e) {
            throw new Exception("Invalid cash amount");
        }

        Transaction transaction = new Transaction(customerName, date, product, quantity, discount, cash);
        if (transaction.getChange() < 0) throw new Exception("Insufficient cash");

        outputArea.setText(transaction.toString());
        saveTransactionToFile(transaction);
    }

    private void saveTransactionToFile(Transaction transaction) {
        try (FileWriter writer = new FileWriter("Customer.txt", true)) {
            writer.write(transaction.toString() + "\n\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving transaction to file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SimpleProductOrdering frame = new SimpleProductOrdering();
            frame.setVisible(true);
        });
    }
}
