package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.font.TextAttribute;
import java.util.Map;

public class MyFrame extends JFrame {

    //init variables
    JLabel mytext;
    JPanel panel;
    JCheckBox bold, italic, underline, upperline;
    Font font;
    Map atribute;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1, 2));


        //creating variables
        mytext = new JLabel(" Mr.Kasapbasi is the best teacher ");
        panel = new JPanel();
        bold = new JCheckBox("bold");
        italic = new JCheckBox("italic");
        underline = new JCheckBox("line under");
        upperline = new JCheckBox("line up");
        panel.setBorder(BorderFactory.createTitledBorder("secenekler"));
        font = mytext.getFont();
        atribute = font.getAttributes();

        //addng atributes
        bold.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                    if (bold.isSelected()) {
                        atribute.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
                    } else {
                        atribute.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_REGULAR);
                    }
                    font = font.deriveFont(atribute);
                    mytext.setFont(font);
                }});
        upperline.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                    if (upperline.isSelected()) {
                        atribute.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                    } else {
                        atribute.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH);
                    }
                    font = font.deriveFont(atribute);
                    mytext.setFont(font);
                }});
        italic.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (italic.isSelected()) {
                    atribute.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
                } else {
                    atribute.put(TextAttribute.POSTURE, TextAttribute.POSTURE_REGULAR);
                }
                font = font.deriveFont(atribute);
                mytext.setFont(font);
            }
        });
        underline.addItemListener(new ItemListener()    {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (underline.isSelected()) {
                    atribute.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                } else {
                    atribute.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE);
                }
                font = font.deriveFont(atribute);
                mytext.setFont(font);
            }
        });

        //adding variables
        this.add(mytext);
        panel.add(bold);
        panel.add(italic);
        panel.add(underline);
        panel.add(upperline);
        this.add(panel);

        this.setVisible(true);
        this.pack();
    }

}
