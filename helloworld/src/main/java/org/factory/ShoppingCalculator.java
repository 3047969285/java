package org.factory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCalculator extends JFrame {
    private JTextField priceField;
    private JTextField quantityField;
    private JComboBox<String> discountTypeComboBox;
    private JLabel originalPriceLabel;
    private JLabel finalPriceLabel;
    private JLabel savedAmountLabel;
    
    public ShoppingCalculator() {
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("收银计算器");
        setSize(400, 300);
        setLocationRelativeTo(null); // 居中显示
        setResizable(false);
    }
    
    private void initializeComponents() {
        priceField = new JTextField(10);
        quantityField = new JTextField("1", 10);
        discountTypeComboBox = new JComboBox<>(new String[]{"正常收费", "满300返100", "打8折"});
        
        originalPriceLabel = new JLabel("¥0.00");
        finalPriceLabel = new JLabel("¥0.00");
        savedAmountLabel = new JLabel("¥0.00");
        
        // 设置标签样式
        originalPriceLabel.setForeground(Color.GRAY);
        originalPriceLabel.setFont(originalPriceLabel.getFont().deriveFont(Font.PLAIN));
        finalPriceLabel.setForeground(new Color(40, 167, 69)); // 绿色
        finalPriceLabel.setFont(finalPriceLabel.getFont().deriveFont(Font.BOLD, 16f));
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        // 创建主面板
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // 商品单价行
        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(new JLabel("商品单价:"), gbc);
        
        gbc.gridx = 1;
        mainPanel.add(priceField, gbc);
        
        // 商品数量行
        gbc.gridx = 0; gbc.gridy = 1;
        mainPanel.add(new JLabel("商品数量:"), gbc);
        
        gbc.gridx = 1;
        mainPanel.add(quantityField, gbc);
        
        // 折扣类型行
        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(new JLabel("折扣类型:"), gbc);
        
        gbc.gridx = 1;
        mainPanel.add(discountTypeComboBox, gbc);
        
        // 计算按钮
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton calculateButton = new JButton("计算总价");
        mainPanel.add(calculateButton, gbc);
        
        // 结果面板
        JPanel resultPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        resultPanel.setBorder(BorderFactory.createTitledBorder("计算结果"));
        resultPanel.add(new JLabel("原始价格:"));
        resultPanel.add(originalPriceLabel);
        resultPanel.add(new JLabel("最终价格:"));
        resultPanel.add(finalPriceLabel);
        resultPanel.add(new JLabel("节省金额:"));
        resultPanel.add(savedAmountLabel);
        
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(resultPanel, gbc);
        
        add(mainPanel, BorderLayout.CENTER);
        
        // 注册按钮点击事件
        calculateButton.addActionListener(new CalculateButtonListener());
    }
    
    private void setupEventHandlers() {
        // 可以在这里添加更多事件处理逻辑
    }
    
    // 计算按钮监听器
    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculate();
        }
    }
    
    private void calculate() {
        try {
            // 获取输入值
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());
            String discountType = (String) discountTypeComboBox.getSelectedItem();
            
            // 验证输入
            if (price <= 0 || quantity <= 0) {
                JOptionPane.showMessageDialog(this, "请输入有效的商品单价和数量！", "输入错误", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // 计算原始总价
            double originalTotal = price * quantity;
            
            // 使用CashContext来处理计算
            CashContext cashContext = new CashContext(discountType);
            
            // 计算最终价格
            double finalTotal = cashContext.getResult(originalTotal);
            
            // 更新结果显示
            originalPriceLabel.setText("¥" + String.format("%.2f", originalTotal));
            finalPriceLabel.setText("¥" + String.format("%.2f", finalTotal));
            savedAmountLabel.setText("¥" + String.format("%.2f", (originalTotal - finalTotal)));
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "请输入有效的数字！", "输入错误", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        // 设置外观
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 创建并显示GUI
        SwingUtilities.invokeLater(() -> {
            new ShoppingCalculator().setVisible(true);
        });
    }
}