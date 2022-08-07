package org.example;

import javax.swing.*;
import java.awt.*;

public class TitleBar extends JPanel {
    JLabel title;
    TitleBar() {
        this.setPreferredSize(new Dimension(400,80));

        title = new JLabel("To-Do List");
        title.setPreferredSize(new Dimension(200,80));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Sans-serif",Font.BOLD,20));

        this.add(title,BorderLayout.NORTH);
        this.setVisible(true);
    }
}
