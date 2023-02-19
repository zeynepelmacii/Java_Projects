package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame{
    JButton button;
    JLabel label;
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5,8));

        label = new JLabel("");
        label.setMaximumSize(new Dimension(100,100));

        for(int i = 1; i<=40 ; i++) {
            button = new JButton("button" + i);
            this.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("hello there from" + button.getText());
                }
            });
        }
        this.add(label);
        this.pack();
        this.setVisible(true);
    }
}
