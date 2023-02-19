package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JLabel label;
    JButton button;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        button = new JButton("pick a color");
        label = new JLabel();

        button.addActionListener((ActionListener) this);

        label.setBackground(Color.cyan);
        label.setText("you can see the color");
        label.setFont(new Font("MV Boli",Font.ITALIC, 100));
        label.setOpaque(true);

        this.add(button);
        this.add(label);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == button) {
            JColorChooser colorChooser =  new JColorChooser();
            Color color = JColorChooser.showDialog(null,"pick a color... i guess", Color.black);
            label.setBackground(color);
        }
    }
}
