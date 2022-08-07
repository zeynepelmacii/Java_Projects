package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ButtonPanel extends JPanel {
    JButton btnAdd;
    JButton btnClear;
    Border emptyBorder = BorderFactory.createEmptyBorder();

    ButtonPanel() {
        this.setPreferredSize(new Dimension(400,60));

        btnAdd = new JButton("Add Task");
        btnAdd.setBorder(emptyBorder);
        btnAdd.setFont(new Font("Sans-serif",Font.PLAIN,20));
        this.add(btnAdd);

        this.add(Box.createHorizontalStrut(20));
        btnClear = new JButton("Clear Completed Task");
        btnClear.setBorder(emptyBorder);
        btnClear.setFont(new Font("Sans-serif",Font.PLAIN,20));
        this.add(btnClear);
    }

    public JButton getAddTask() {
        return btnAdd;
    }

    public JButton getClear() {
        return btnClear;
    }

}
