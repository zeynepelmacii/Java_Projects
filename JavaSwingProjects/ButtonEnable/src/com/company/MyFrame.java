package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame{
    JButton button1, button2;


    MyFrame() {
        ImageIcon icon1 = new ImageIcon("C:\\temp\\true.png");
        ImageIcon icon2 = new ImageIcon("C:\\temp\\false.png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        //ico1 tanımla-ture
        button1 = new JButton("1) enable button 2");
        button1.setEnabled(true);
        button1.setIcon(icon1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setEnabled(true);
                button1.setEnabled(false);
            }
        });
        this.add(button1);

        button2 = new JButton("2) enable button 1");
        button2.setEnabled(false);
        button2.setIcon(icon2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setEnabled(true);
                button2.setEnabled(false);
            }
        });

        this.add(button2);
        this.pack();
        this.setVisible(true);
    }
}
