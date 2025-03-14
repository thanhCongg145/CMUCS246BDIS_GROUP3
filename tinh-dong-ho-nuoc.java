import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaterBillCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tính tiền nước");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(230, 240, 250));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JTextField startField = new JTextField(10);
        JTextField endField = new JTextField(10);
        JLabel resultLabel = new JLabel("Tiền nước: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        JButton calculateButton = new JButton("Tính tiền");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 14));
        calculateButton.setBackground(new Color(100, 180, 100));
        calculateButton.setForeground(Color.WHITE);
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double start = Double.parseDouble(startField.getText());
                    double end = Double.parseDouble(endField.getText());
                    double pricePerUnit = 10000; // Giá mỗi m³ nước
                    
                    if (end < start) {
                        JOptionPane.showMessageDialog(frame, "Chỉ số cuối phải lớn hơn chỉ số đầu", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    double used = end - start;
                    double totalCost = used * pricePerUnit;
                    
                    resultLabel.setText("Tiền nước: " + totalCost + " VND");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Vui lòng nhập số hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(new JLabel("Chỉ số đầu: "), gbc);
        gbc.gridx = 1;
        frame.add(startField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(new JLabel("Chỉ số cuối: "), gbc);
        gbc.gridx = 1;
        frame.add(endField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(calculateButton, gbc);

        gbc.gridy = 3;
        frame.add(resultLabel, gbc);
        
        frame.setVisible(true);
    }
}
