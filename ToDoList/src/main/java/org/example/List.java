package org.example;

import javax.swing.*;
import java.awt.*;

public class List extends JPanel {
    GridLayout gridLayout;
    List() {

        gridLayout = new GridLayout(10,1);
        gridLayout.setVgap(5);
        this.setLayout(gridLayout);
    }

    public void updateNumbers() {
        Component[] listItems = this.getComponents();
        for(int i=0; i<listItems.length; i++) {
            if(listItems[i] instanceof Task) {
                ((Task)listItems[i]).changeIndex(i+1);
            }
        }
    }

    public void removeCompletedTasks() {
        for(Component c : getComponents()) {
            if(c instanceof Task) {
                if(((Task)c).getState()) {
                    remove(c);
                    updateNumbers();
                }
            }
        }
    }
}
