import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import javax.swing.ImageIcon;

public class FinalProject extends JFrame {
    private static final long serialVersionUID = 1L;

    private JFrame frame;
    private JTextField customerNameField;
    private JTextField dateField;
    private JTextField quantityField;
    private JTextField discountField;
    private JTextField cashField;
    private JComboBox<String> productComboBox;
    private JTextArea outputArea;

    private Product[] products = {
        new Product("Toblerone", 55.00),
        new Product("Snickers", 25.00),
        new Product("Hershey", 45.00),
        new Product("Baby Ruth", 68.00),
        new Product("Kit Kat", 34.00)
    };

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FinalProject window = new FinalProject();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FinalProject() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setResizable(false);
        frame.setAutoRequestFocus(false);
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 970, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBorder(new CompoundBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), null));
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(706, 10, 240, 45);
        frame.getContentPane().add(panel);
        
        JLabel lblYourOrder = new JLabel("Your Order");
        lblYourOrder.setForeground(SystemColor.desktop);
        lblYourOrder.setFont(new Font("Tahoma", Font.BOLD, 22));
        panel.add(lblYourOrder);
        
        JButton btnCheckOut = new JButton("Place Order");
        btnCheckOut.setForeground(new Color(255, 255, 255));
        btnCheckOut.setBackground(new Color(0, 153, 0));
        btnCheckOut.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        btnCheckOut.setBounds(706, 608, 240, 45);
        frame.getContentPane().add(btnCheckOut);
        
        JPanel panel1 = new JPanel();
        panel1.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "Customer's Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel1.setBackground(new Color(255, 255, 255));
        panel1.setBounds(706, 65, 240, 130);
        frame.getContentPane().add(panel1);
        panel1.setLayout(null);
        
        JLabel lblCustomerName = new JLabel("Customer Name:");
        lblCustomerName.setBounds(10, 22, 120, 14);
        panel1.add(lblCustomerName);
        
        customerNameField = new JTextField();
        customerNameField.setBounds(10, 40, 220, 20);
        panel1.add(customerNameField);
        customerNameField.setColumns(10);
        
        JLabel lblDate = new JLabel("Date (yyyy-mm-dd):");
        lblDate.setBounds(10, 70, 120, 14);
        panel1.add(lblDate);
        
        dateField = new JTextField();
        dateField.setBounds(10, 88, 220, 20);
        panel1.add(dateField);
        dateField.setColumns(10);
        
        JPanel panel2 = new JPanel();
        panel2.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "Order Summary", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel2.setBackground(new Color(255, 255, 255));
        panel2.setBounds(706, 205, 240, 393);
        frame.getContentPane().add(panel2);
        panel2.setLayout(null);
        
        JLabel lblProduct = new JLabel("Product:");
        lblProduct.setBounds(10, 21, 80, 14);
        panel2.add(lblProduct);
        
        productComboBox = new JComboBox<>();
        for (Product product : products) {
            productComboBox.addItem(product.getName());
        }
        productComboBox.setBounds(10, 39, 220, 20);
        panel2.add(productComboBox);
        
        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(10, 69, 80, 14);
        panel2.add(lblQuantity);
        
        quantityField = new JTextField();
        quantityField.setBounds(10, 87, 220, 20);
        panel2.add(quantityField);
        quantityField.setColumns(10);
        
        JLabel lblDiscount = new JLabel("Discount (%):");
        lblDiscount.setBounds(10, 117, 80, 14);
        panel2.add(lblDiscount);
        
        discountField = new JTextField();
        discountField.setBounds(10, 135, 220, 20);
        panel2.add(discountField);
        discountField.setColumns(10);
        
        JLabel lblCash = new JLabel("Cash:");
        lblCash.setBounds(10, 165, 80, 14);
        panel2.add(lblCash);
        
        cashField = new JTextField();
        cashField.setBounds(10, 183, 220, 20);
        panel2.add(cashField);
        cashField.setColumns(10);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBackground(new Color(255, 255, 255));
        outputArea.setBounds(10, 213, 220, 170);
        panel2.add(outputArea);
        
        JPanel panel3 = new JPanel();
        panel3.setBorder(new LineBorder(new Color(105, 105, 105), 3));
        panel3.setBackground(new Color(255, 255, 255));
        panel3.setBounds(10, 10, 686, 123);
        frame.getContentPane().add(panel3);
        
        JPanel panel5 = new JPanel();
        panel5.setBorder(new LineBorder(new Color(105, 105, 105), 3));
        panel5.setBackground(Color.WHITE);
        panel5.setBounds(10, 143, 220, 250);
        frame.getContentPane().add(panel5);
        
        JPanel panel6 = new JPanel();
        panel6.setBorder(new LineBorder(new Color(105, 105, 105), 3));
        panel6.setBackground(Color.WHITE);
        panel6.setBounds(243, 143, 220, 250);
        frame.getContentPane().add(panel6);
        
        JPanel panel7 = new JPanel();
        panel7.setBorder(new LineBorder(new Color(105, 105, 105), 3));
        panel7.setBackground(Color.WHITE);
        panel7.setBounds(476, 143, 220, 250);
        frame.getContentPane().add(panel7);
        
        JPanel panel8 = new JPanel();
        panel8.setBorder(new LineBorder(new Color(105, 105, 105), 3));
        panel8.setBackground(Color.WHITE);
        panel8.setBounds(10, 403, 220, 250);
        frame.getContentPane().add(panel8);
        
        JPanel panel9 = new JPanel();
        panel9.setBorder(new LineBorder(new Color(105, 105, 105), 3));
        panel9.setBackground(Color.WHITE);
        panel9.setBounds(243, 403, 220, 250);
        frame.getContentPane().add(panel9);
        
        JPanel panel10 = new JPanel();
        panel10.setBorder(new LineBorder(new Color(105, 105, 105), 3));
        panel10.setBackground(Color.WHITE);
        panel10.setBounds(476, 403, 220, 250);
        frame.getContentPane().add(panel10);
        

        addImageToPanel(panel5, "Toblerone", "toblerone_image.jpg", 55.00);
        addImageToPanel(panel6, "Snickers", "snickers_image.jpg", 25.00);
        addImageToPanel(panel7, "Hershey", "hershey_image.jpg", 45.00);
        addImageToPanel(panel8, "Baby Ruth", "baby_ruth_image.jpg", 68.00);
        addImageToPanel(panel9, "Kit Kat", "kitkat_image.jpg", 34.00);
        addImageToPanel(panel10, "Coming Soon", "coming_soon_image.jpg", 0.00);

        
        btnCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    placeOrder();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(FinalProject.this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void addImageToPanel(final JPanel panel, final String name, final String imagePath, final double price) {
        panel.setLayout(null);
        JLabel nameLabel = new JLabel(name);
        nameLabel.setBounds(10, 10, 180, 20);
        panel.add(nameLabel);
        
        JLabel priceLabel = new JLabel("Price: ₱ " + price);
        priceLabel.setBounds(10, 30, 180, 20);
        panel.add(priceLabel);
        
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(imagePath));
        imageLabel.setBounds(10, 60, 200, 180);
        panel.add(imageLabel);
    }


	private void placeOrder() throws Exception {
        String customerName = customerNameField.getText();
        if (customerName.isEmpty()) throw new Exception("Customer name is required");

        Date date;
        try {
            date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dateField.getText());
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
            if (discount < 5 || discount > 50) {
                throw new Exception("Discount must be between 5% and 50%");
            }
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
	        if (transaction.getChange() < 0) {
	            throw new Exception("Insufficient cash");
	        }
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
    }

