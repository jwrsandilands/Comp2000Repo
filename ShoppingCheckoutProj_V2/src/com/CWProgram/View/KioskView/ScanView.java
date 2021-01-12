package com.CWProgram.View.KioskView;


import com.CWProgram.Controller.Controller;
import com.CWProgram.Controller.IAdminController;
import com.CWProgram.Model.Model;
import com.CWProgram.View.AdminView.AdminView;
import com.CWProgram.View.AdminView.LoginView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

public class ScanView extends KioskView {

    JPanel mainPanel, scanPanel, itemPanel;

    JLabel promptTxt, scannedItemTxt, scannedCostTxt;
    JButton startBtn, adminBtn;
    JTable scanTable;
    String[] tableHeads;
    Object[][] tableContents;

    EmptyBorder mainBorder;


    public ScanView(){
        mainPanel = new JPanel();
        scanPanel = new JPanel();
        itemPanel = new JPanel();
        promptTxt = new JLabel("Press the Button to Start!");
        promptTxt.setFont(new Font(promptTxt.getFont().getName(), Font.PLAIN, 25));
        scannedItemTxt = new JLabel("Scan an item!");
        scannedItemTxt.setFont(new Font(promptTxt.getFont().getName(), Font.PLAIN, 25));
        scannedCostTxt = new JLabel("temp");
        scannedCostTxt.setFont(new Font(promptTxt.getFont().getName(), Font.PLAIN, 25));

        startBtn = new JButton("Start");
        startBtn.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        scanPane();
                    }
                }
        );
        adminBtn = new JButton("Admin Login");
        adminBtn.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Model model = new Model();
                        try{
                            Method method = model.getClass().getMethod("loadAdmins");
                            method.invoke(model);
                        }
                        catch(Exception ex){
                            System.out.println("Error Importing!");
                        }
                        AdminView adminLoginView = new LoginView();
                        IAdminController adminLoginControl = new Controller(model, adminLoginView);
                    }
                }
        );

        tableHeads = new String[]{"Name", "Price"};
        tableContents = new Object[][]{
                {"Beans", (float) 0.99}, {"Crisps", (float) 1.20}
        };
        scanTable = new JTable(tableContents, tableHeads);

        mainBorder = new EmptyBorder(10,10,10,10);
        mainPanel.setBorder(mainBorder);
        itemPanel.setBorder(mainBorder);
        scanPanel.setBorder(mainBorder);

        mainPane();
    }

    public void mainPane(){
        //manipulate gridlayout shape
        {
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());

            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());

            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(promptTxt);
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());

            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(startBtn);
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());

            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());

            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());

            mainPanel.add(adminBtn);
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
            mainPanel.add(new JLabel());
        }

        setContentPane(mainPanel);
        initialise(7,5);
    }

    public void scanPane(){
        itemPanel.add(scannedItemTxt);
        itemPanel.add(scannedCostTxt);

        itemPanel.setLayout(new GridLayout(1,2,1,1));
        setContentPane(itemPanel);
        setVisible(true);

        scanPanel.add(promptTxt);
        scanPanel.add(scanTable);
        scanPanel.setLayout(new GridLayout(2,1,1,1));
//        setContentPane(scanPanel);
//        getContentPane().add(scanPanel);

        initialise2(itemPanel, scanPanel);

    }

}
