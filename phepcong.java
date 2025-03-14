import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Máy tính cộng");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(230, 240, 250));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JTextField num1Field = new JTextField(10);
        JTextField num2Field = new JTextField(10);
        JLabel resultLabel = new JLabel("Kết quả: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        JButton addButton = new JButton("Cộng (+)");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setBackground(new Color(100, 180, 100));
        addButton.setForeground(Color.WHITE);
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = num1 + num2;
                    
                    resultLabel.setText("Kết quả: " + result);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Vui lòng nhập số hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(new JLabel("Số thứ nhất: "), gbc);
        gbc.gridx = 1;
        frame.add(num1Field, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(new JLabel("Số thứ hai: "), gbc);
        gbc.gridx = 1;
        frame.add(num2Field, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(addButton, gbc);

        gbc.gridy = 3;
        frame.add(resultLabel, gbc);
        
        frame.setVisible(true);
    }
}
