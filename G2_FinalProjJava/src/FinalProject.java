import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

public class FinalProject {

    private JFrame frame;
    private JTextField customerNameField;
    private JTextField dateField_1;
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
                    window.frame.setLocationRelativeTo(null);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FinalProject() {
        initialize();
        frame.setLocationRelativeTo(null);
    }

    private void initialize() {
        frame = new JFrame("JBrothers Candy Shop");
        ImageIcon icon = new ImageIcon("logo_image.png");
    	Image iconImg = ((ImageIcon) icon).getImage();
    	frame.setIconImage(iconImg);
        frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
        frame.setAutoRequestFocus(false);
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(47, 79, 79));
        frame.setBounds(100, 100, 1050, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnCheckOut = new JButton("Place Order");
        btnCheckOut.setForeground(new Color(255, 255, 255));
        btnCheckOut.setBackground(new Color(34, 139, 34));
        btnCheckOut.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        btnCheckOut.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        btnCheckOut.setBounds(786, 658, 244, 45);
        btnCheckOut.setFocusPainted(false); 
        frame.getContentPane().add(btnCheckOut);

        JPanel panel1 = new JPanel();
        panel1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Customer's Information", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel1.setBackground(new Color(255, 255, 255));
        panel1.setBounds(786, 10, 244, 130);
        frame.getContentPane().add(panel1);
        panel1.setLayout(null);

        JLabel lblCustomerName = new JLabel("Customer Name:");
        lblCustomerName.setBounds(10, 22, 120, 14);
        panel1.add(lblCustomerName);

        customerNameField = new JTextField();
        customerNameField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        customerNameField.setBounds(10, 40, 220, 20);
        panel1.add(customerNameField);
        customerNameField.setColumns(10);

        JLabel lblDate = new JLabel("Date (yyyy-mm-dd):");
        lblDate.setBounds(10, 70, 120, 14);
        panel1.add(lblDate);

        java.util.Date currentDate = new java.util.Date();
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String currentDateFormatted = dateFormat.format(currentDate);

        dateField_1 = new JTextField(currentDateFormatted);
        dateField_1.setBounds(10, 88, 220, 20);
        dateField_1.setBackground(Color.WHITE); 
        panel1.add(dateField_1);
        dateField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        dateField_1.setEditable(false); 

        JPanel panel2 = new JPanel();
        panel2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Order Summary", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel2.setBackground(new Color(255, 255, 255));
        panel2.setBounds(786, 150, 244, 498);
        frame.getContentPane().add(panel2);
        panel2.setLayout(null);

        JLabel lblProduct = new JLabel("Product:");
        lblProduct.setBounds(10, 21, 80, 14);
        panel2.add(lblProduct);

        productComboBox = new JComboBox<>();
        productComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        for (Product product : products) {
            productComboBox.addItem(product.getName());
        }
        productComboBox.setBounds(10, 39, 220, 20);
        panel2.add(productComboBox);

        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(10, 69, 80, 14);
        panel2.add(lblQuantity);

        quantityField = new JTextField();
        quantityField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        quantityField.setBounds(10, 87, 220, 20);
        panel2.add(quantityField);
        quantityField.setColumns(10);

        JLabel lblDiscount = new JLabel("Discount (%):");
        lblDiscount.setBounds(10, 117, 80, 14);
        panel2.add(lblDiscount);

        discountField = new JTextField();
        discountField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        discountField.setBounds(10, 135, 220, 20);
        panel2.add(discountField);
        discountField.setColumns(10);

        JLabel lblCash = new JLabel("Cash:");
        lblCash.setBounds(10, 165, 80, 14);
        panel2.add(lblCash);

        cashField = new JTextField();
        cashField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        cashField.setBounds(10, 183, 220, 20);
        panel2.add(cashField);
        cashField.setColumns(10);

        outputArea = new JTextArea();
        outputArea.setFont(new Font("Courier New", Font.BOLD, 15));
        outputArea.setEditable(false);
        outputArea.setFocusable(false); 
        outputArea.setBackground(new Color(255, 255, 255));
        outputArea.setBounds(10, 228, 224, 260);
        panel2.add(outputArea);

        JPanel panel4 = new JPanel();
        panel4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel4.setBackground(Color.WHITE);
        panel4.setBounds(10, 93, 250, 300);
        frame.getContentPane().add(panel4);

        JPanel panel5 = new JPanel();
        panel5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel5.setBackground(Color.WHITE);
        panel5.setBounds(270, 93, 250, 300);
        frame.getContentPane().add(panel5);

        JPanel panel6 = new JPanel();
        panel6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel6.setBackground(Color.WHITE);
        panel6.setBounds(526, 93, 250, 300);
        frame.getContentPane().add(panel6);

        JPanel panel7 = new JPanel();
        panel7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel7.setBackground(Color.WHITE);
        panel7.setBounds(10, 403, 250, 300);
        frame.getContentPane().add(panel7);

        JPanel panel8 = new JPanel();
        panel8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel8.setBackground(Color.WHITE);
        panel8.setBounds(270, 403, 250, 300);
        frame.getContentPane().add(panel8);

        addImageToPanel(panel4, "Toblerone", "toblerone.png", 55.00);
        addImageToPanel(panel5, "Snickers", "snickers.png", 25.00);
        addImageToPanel(panel6, "Hershey", "hershey.png", 45.00);
        addImageToPanel(panel7, "Baby Ruth", "baby_ruth.png", 68.00);
        addImageToPanel(panel8, "Kit Kat", "kitkat.png", 34.00);
        
        JLabel lblNewLabel = new JLabel("JBrothers Candy Shop");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Black Han Sans", Font.BOLD | Font.ITALIC, 40));
        lblNewLabel.setBounds(10, 32, 766, 51);
        frame.getContentPane().add(lblNewLabel);
        
        JPanel panel9 = new JPanel();
        panel9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel9.setBackground(Color.WHITE);
        panel9.setBounds(526, 403, 250, 300);
        frame.getContentPane().add(panel9);
        panel9.setLayout(null);
        
        JLabel lblComing = new JLabel("More Chocolates");
        lblComing.setHorizontalAlignment(SwingConstants.CENTER);
        lblComing.setForeground(Color.BLACK);
        lblComing.setFont(new Font("Black Han Sans", Font.PLAIN, 25));
        lblComing.setBackground(Color.BLACK);
        lblComing.setBounds(0, 40, 250, 51);
        panel9.add(lblComing);
        
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon("coming_soon.png"));
        imageLabel.setBounds(10, 60, 230, 230); 
        panel9.add(imageLabel);

        btnCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    placeOrder();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void addImageToPanel(final JPanel panel, final String name, final String imagePath, final double price) {
        panel.setLayout(null);
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        nameLabel.setBounds(10, 10, 180, 20);
        panel.add(nameLabel);

        JLabel priceLabel = new JLabel("Price: ₱" + String.format("%.2f", price));
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        priceLabel.setBounds(10, 30, 180, 20);
        panel.add(priceLabel);

        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(imagePath));
        imageLabel.setBounds(10, 60, 230, 230);
        panel.add(imageLabel);
    }


    private void placeOrder() throws Exception {
        String customerName = customerNameField.getText();
        if (customerName.isEmpty()) throw new Exception("Customer name is required");

        Date date;
        try {
            date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dateField_1.getText());
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
            JOptionPane.showMessageDialog(this.frame, "Error saving transaction to file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
