package org.example;

import javax.swing.*;
import java.awt.*;

public class Task extends JPanel {
    private JLabel index;
    private JTextField taskname;
    private JButton done;
    private boolean checked;

    Task() {
        this.setPreferredSize(new Dimension(40,20));
        this.setBackground(Color.red);
        this.setLayout(new BorderLayout());

        checked = false;

        index= new JLabel("");
        index.setPreferredSize(new Dimension(20,20));
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index, BorderLayout.WEST);

        taskname = new JTextField("Your task here");
        taskname.setBorder(BorderFactory.createEmptyBorder());
        taskname.setBackground(Color.pink);
        this.add(taskname,BorderLayout.CENTER);

        done = new JButton("done");
        done.setPreferredSize(new Dimension(40,20));
        done.setBorder(BorderFactory.createEmptyBorder());
        this.add(done,BorderLayout.EAST);

        this.setVisible(true);
    }

    public JButton getdone() {
        return done;
    }

    public void changeIndex(int number) {
        this.index.setText(number+"");
        this.revalidate();
    }

    //check if it is done
    public void changeState() {
        this.setBackground(Color.green);
        taskname.setBackground(Color.green);
        checked = true;
    }

    public boolean getState() {
        return checked;
    }
}
