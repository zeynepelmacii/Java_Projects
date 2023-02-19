package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JRadioButton rb1,rb2,rb3,rb4;
    JPanel panel;
    ButtonGroup buttonGroup;
    JLabel label;
    ImageIcon icon1,icon2,icon3,icon4;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,2));

        panel = new JPanel(new GridLayout(0,1));
        buttonGroup = new ButtonGroup();
        label = new JLabel();
        icon1 = new ImageIcon("/forImages/red.png");
        icon2 = new ImageIcon("/forImages/yellow.png");
        icon3 = new ImageIcon("/forImages/blue.png");
        icon4 = new ImageIcon("/forImages/pink.png");

        rb1 = new JRadioButton("red");
        rb1.setActionCommand(String.valueOf(icon1));
        rb1.addActionListener(this);

        rb2 = new JRadioButton("yellow");
        rb2.setActionCommand(String.valueOf(icon2));
        rb2.addActionListener(this);

        rb3 = new JRadioButton("blue");
        rb3.setActionCommand(String.valueOf(icon3));
        rb3.addActionListener(this);

        rb4 = new JRadioButton("pink");
        rb4.setActionCommand(String.valueOf(icon4));
        rb4.addActionListener(this);

        buttonGroup.add(rb1);
        buttonGroup.add(rb2);
        buttonGroup.add(rb3);
        buttonGroup.add(rb4);

        panel.setBorder(BorderFactory.createTitledBorder("options"));
        panel.add(rb1);
        panel.add(rb2);
        panel.add(rb3);
        panel.add(rb4);

        this.add(label,BorderLayout.CENTER);
        this.add(panel,BorderLayout.LINE_START);
        this.add(panel);


        this.setVisible(true);
        this.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
