package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    JComboBox comboBox1,comboBox2;
    JPanel panel1,panel2;
    JLabel label;
    JButton add, add2;
    JTextField textField;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,2));

        panel1 = new JPanel();
        panel2 = new JPanel();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        comboBox1.addItem("kitap");
        comboBox1.addItem("kalem");
        comboBox1.addItem("defter");
        comboBox1.addItem("silgi");
        comboBox1.addItem("uç");
        label = new JLabel();
        add = new JButton("Add");
        add2 = new JButton("Add");
        textField = new JTextField(40);


        panel1.setBorder(BorderFactory.createTitledBorder("automatic"));
        panel2.setBorder(BorderFactory.createTitledBorder("manually"));
        add2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = "selected: " + comboBox1.getItemAt(comboBox1.getSelectedIndex());
                label.setText(data);
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox2.addItem(textField.getText());
            }
        });


        this.add(panel1);
        this.add(panel2);
        panel1.add(comboBox1);
        panel1.add(add2);
        panel1.add(label);

        panel2.add(textField);
        panel2.add(comboBox2);
        panel2.add(add);


        this.setVisible(true);
        this.pack();
    }
}
