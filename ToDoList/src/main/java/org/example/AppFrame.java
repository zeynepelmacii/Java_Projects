package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppFrame extends JFrame {

    private TitleBar titleBar;
    private List list;
    private ButtonPanel buttonPanel;

    private JButton addTask;
    private JButton clearTask;

    AppFrame(){
        this.setSize(400,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        titleBar = new TitleBar();
        list = new List();
        buttonPanel = new ButtonPanel();
        this.add(titleBar, BorderLayout.NORTH);
        this.add(list, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        addTask = buttonPanel.getAddTask();
        clearTask = buttonPanel.getClear();

        addListeners();

        this.setVisible(true);

    }

    public void addListeners() {
        addTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Task task = new Task();
                list.add(task);
                list.updateNumbers();

                task.getdone().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        task.changeState();
                        revalidate();
                    }
                });
                revalidate();
            }
        });

        clearTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                list.removeCompletedTasks();
                repaint();
            }
        });

    }


}
