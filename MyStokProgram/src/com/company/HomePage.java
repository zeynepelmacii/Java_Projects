package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class HomePage extends JFrame{

    //vectors for tables clumnnames and datas
    static Vector <Vector<String>> data = new Vector <Vector<String>>();
    static Vector<String> columnNames = new Vector<String>();

    //init variables part
    JButton btnFind,btnNew;
    JTextField txtSearch;
    JLabel explanation, explanation2;
    JPanel idPanel, stokPanel, transactionsPanel, parent;
    JTable table;

    HomePage() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,2));
        this.setTitle("Clothing Store");

        //creating variables part
        txtSearch = new JTextField(30);

        idPanel = new JPanel();
        stokPanel = new JPanel();
        transactionsPanel = new JPanel();
        parent = new JPanel();

        explanation = new JLabel("search:  ");
        explanation2 = new JLabel("to add a new stock: ");

        btnFind = new JButton("find");
        btnNew = new JButton("new");


        columnNames.add("Code");
        columnNames.add("Category");
        columnNames.add("Store");
        columnNames.add("Price");
        columnNames.add("Amount");

        //creating table
        table = new JTable(data,columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(table.getSelectedRow() == -1) {
                    transactionsPanel.setVisible(false);
                    return;
                }
                String code = (String) table.getValueAt(table.getSelectedRow(),0);
                Stock stock = Service.getStokByCode(code);
                fillStockForm(stock,false);
                transactionsPanel.setVisible(true);
            }
        });

        //action part
        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = txtSearch.getText();
                ArrayList<Stock> arrFound = Service.getStocksByKeyword(keyword);
                if(arrFound.size() == 0) {
                    Util.showMessage("stock not found!!");
                }

                data = Util.arrToVector(arrFound);
                table.setModel(new DefaultTableModel(data, columnNames));

                setVisible(true);
            }
        });
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillStockForm(null,true);
                transactionsPanel.setVisible(true);
            }
        });

        idPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#6F1D1B"),2));
        parent.setLayout(new GridLayout(2,1));

        stokPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#6F1D1B"),2));
        stokPanel.setLayout(new GridLayout(1,1));

        transactionsPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#6F1D1B"),2));
        transactionsPanel.setLayout(new FlowLayout());
        transactionsPanel.setVisible(false);

        //coloring part
        idPanel.setBackground(Color.decode("#D7E4EC"));
        btnFind.setBackground(Color.decode("#6F1D1B"));
        btnFind.setForeground(Color.decode("#ffffff"));
        explanation.setForeground(Color.decode("#6F1D1B"));
        txtSearch.setForeground(Color.decode("#6F1D1B"));
        btnNew.setBackground(Color.decode("#6F1D1B"));
        btnNew.setForeground(Color.decode("#ffffff"));
        explanation2.setForeground(Color.decode("#6F1D1B"));

        stokPanel.setBackground(Color.decode("#F8EDEB"));
        table.setBackground(Color.decode("#F8EDEB"));

        transactionsPanel.setBackground(Color.decode("#E8E8E4"));


        //adding part
        this.add(idPanel);
        idPanel.add(explanation);
        idPanel.add(txtSearch);
        idPanel.add(btnFind);
        idPanel.add(explanation2);
        idPanel.add(btnNew);

        this.add(parent);
        parent.add(stokPanel);
        parent.add(transactionsPanel);
        stokPanel.add(scrollPane);


        this.setVisible(true);
        this.setSize(900,600);
    }

    private void fillStockForm(Stock stock,Boolean isNew) {
        //creating textFields for transactionsPanel to update or adding new stock
        JTextField txtCode = new JTextField(20);
        JComboBox<String> cbCategory = new JComboBox<String>();
        JTextField txtDescription = new JTextField(20);
        JTextField txtPrice = new JTextField(20);
        JTextField txtAmount = new JTextField(20);



        //coloring part
        cbCategory.setBackground(Color.decode("#ffffff"));
        cbCategory.setForeground(Color.decode("#6F1D1B"));
        txtCode.setBackground(Color.decode("#ffffff"));
        txtCode.setForeground(Color.decode("#6F1D1B"));
        txtDescription.setBackground(Color.decode("#ffffff"));
        txtDescription.setForeground(Color.decode("#6F1D1B"));
        txtPrice.setBackground(Color.decode("#ffffff"));
        txtPrice.setForeground(Color.decode("#6F1D1B"));
        txtAmount.setBackground(Color.decode("#ffffff"));
        txtAmount.setForeground(Color.decode("#6F1D1B"));



        //adding static categories from Stock class to combo box
        cbCategory.addItem(Stock.CAT_SHOES);
        cbCategory.addItem(Stock.CAT_SKIRTS);
        cbCategory.addItem(Stock.CAT_DRESSES);
        cbCategory.addItem(Stock.CAT_JEANS);
        cbCategory.addItem(Stock.CAT_SWEATS);

        //if the stock program recived is not new, code is enabled because every code is uniqe and not can be changed
        txtCode.setEnabled(isNew);
        if(!isNew) {
            txtCode.setText(stock.getCode());
            cbCategory.setSelectedItem(stock.getCategory());
            txtDescription.setText(stock.getDescription());
            txtPrice.setText(String.valueOf(stock.getPrice()));
            txtAmount.setText(String.valueOf(stock.getAmount()));
        }

        //labels for transactionsPanel
        JLabel lblCode = new JLabel("Code: ");
        JLabel lblCategory = new JLabel("Category: ");
        JLabel lblDescription = new JLabel("Store: ");
        JLabel lblPrice = new JLabel("Price: ");
        JLabel lblAmount = new JLabel("Amount: ");



        //panel for transactionsPanel
        JPanel editorPanel = new JPanel();
        editorPanel.setLayout(new GridLayout(6,2));

        //creating delete and update buttons
        JButton btnDelete = new JButton("delete");
        JButton btnUpdate = new JButton("update");

        btnUpdate.setBackground(Color.decode("#6F1D1B"));
        btnUpdate.setForeground(Color.decode("#ffffff"));

        btnDelete.setBackground(Color.decode("#6F1D1B"));
        btnDelete.setForeground(Color.decode("#ffffff"));

        //update and delete button when i select something on table
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbCategory.getItemAt(cbCategory.getSelectedIndex()).isBlank()) {
                    Util.showMessage("Category can not be empty");
                    return;
                }
                if(txtDescription.getText().isBlank()) {
                    Util.showMessage("Description can not be empty");
                    return;
                }
                if(!Util.isValidPrice(txtPrice.getText())) {
                    Util.showMessage("enter a valid price");
                    return;
                }
                if(!Util.isValidAmount(txtAmount.getText())) {
                    Util.showMessage("enter a valid amount");
                    return;
                }

                Stock stock = new Stock();
                stock.setCode(txtCode.getText());
                stock.setCategory(cbCategory.getItemAt(cbCategory.getSelectedIndex()));
                stock.setDescription(txtDescription.getText());
                stock.setPrice(Double.valueOf(txtPrice.getText()));
                stock.setAmount(Integer.valueOf(txtAmount.getText()));

                boolean  isSaved = Service.update(stock);
                if(!isSaved) {
                    Util.showMessage("stock not uptaded");
                    return;
                }
                btnFind.doClick();
                Util.showMessage("successfully updated");
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isDeleted = Service.delete(stock);
                if(!isDeleted) {
                    Util.showMessage("can not be deleted");
                    return;
                }
                Util.showMessage("successfully deleted");
                btnFind.doClick();
            }
        });

        //creating save and cancel buttons and coloring them
        JButton btnSave = new JButton("Save");
        btnSave.setBackground(Color.decode("#6F1D1B"));
        btnSave.setForeground(Color.decode("#ffffff"));

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(Color.decode("#6F1D1B"));
        btnCancel.setForeground(Color.decode("#ffffff"));

        // save - cancel buttons when click btnFind
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtCode.getText().isBlank()) {
                    Util.showMessage("code can not be empty");
                    return;
                }
                if(cbCategory.getItemAt(cbCategory.getSelectedIndex()).isBlank()) {
                    Util.showMessage("Category can not be empty");
                    return;
                }
                if(txtDescription.getText().isBlank()) {
                    Util.showMessage("Description can not be empty");
                    return;
                }
                if(!Util.isValidPrice(txtPrice.getText())) {
                    Util.showMessage("enter a valid price");
                    return;
                }
                if(!Util.isValidAmount(txtAmount.getText())) {
                    Util.showMessage("enter a valid amount");
                    return;
                }
                if(Service.getStokByCode(txtCode.getText()) != null) {
                    Util.showMessage("stock already exists");
                    return;
                }

                Stock stock = new Stock();
                stock.setCode(txtCode.getText());
                stock.setCategory(cbCategory.getItemAt(cbCategory.getSelectedIndex()));
                stock.setDescription(txtDescription.getText());
                stock.setPrice(Double.valueOf(txtPrice.getText()));
                stock.setAmount(Integer.valueOf(txtAmount.getText()));

                boolean  isSaved = Service.insert(stock);
                if(!isSaved) {
                    Util.showMessage("stock not saved");
                    return;
                }
                btnFind.doClick();
                Util.showMessage("successfully inserted");
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transactionsPanel.setVisible(false);
            }
        });



        //adding part
        editorPanel.add(lblCode);
        editorPanel.add(txtCode);
        editorPanel.add(lblCategory);
        editorPanel.add(cbCategory);
        editorPanel.add(lblDescription);
        editorPanel.add(txtDescription);
        editorPanel.add(lblPrice);
        editorPanel.add(txtPrice);
        editorPanel.add(lblAmount);
        editorPanel.add(txtAmount);

        transactionsPanel.removeAll();
        transactionsPanel.add(editorPanel);
        if(stock == null) {
            transactionsPanel.add(btnSave);
            transactionsPanel.add(btnCancel);
        } else{
            transactionsPanel.add(btnUpdate);
            transactionsPanel.add(btnDelete);
        }
        setVisible(true);
    }
}
