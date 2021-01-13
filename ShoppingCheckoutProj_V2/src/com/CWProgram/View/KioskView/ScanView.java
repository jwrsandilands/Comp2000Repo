package com.CWProgram.View.KioskView;


import com.CWProgram.Controller.Controller;
import com.CWProgram.Controller.IAdminController;
import com.CWProgram.Controller.IUserController;
import com.CWProgram.Model.IModelSubject;
import com.CWProgram.Model.Model;
import com.CWProgram.Model.ModelStockEntry;
import com.CWProgram.View.AdminView.AdminView;
import com.CWProgram.View.AdminView.LoginView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

public class ScanView extends KioskView {

    JPanel mainPanel, scanPanel, itemPanel, backPanel, blankPanel;

    JLabel promptTxt, scannedItemTxt, scannedCostTxt, totalTxt;
    JButton startBtn, adminBtn, payBtn, backBtn, scanBtn;
    JTextField scanInput;
    JTable scanTable;

    String inScan;
    int inNumber;

    String[] tableHeads;
    Object[][] tableContents, newArray;

    ModelStockEntry shopItem;
    String itemName;
    float itemPrice, totalPrice = 0;

    EmptyBorder mainBorder;

    DecimalFormat price = new DecimalFormat("0.00");


    public ScanView(){
        mainPanel = new JPanel();
        scanPanel = new JPanel();
        itemPanel = new JPanel();
        backPanel = new JPanel();
        blankPanel = new JPanel();
        promptTxt = new JLabel("Press the Button to Start!");
        promptTxt.setFont(new Font(promptTxt.getFont().getName(), Font.PLAIN, 25));
        scannedItemTxt = new JLabel("Scan an item!");
        scannedItemTxt.setFont(new Font(promptTxt.getFont().getName(), Font.PLAIN, 25));
        scannedCostTxt = new JLabel("");
        scannedCostTxt.setFont(new Font(promptTxt.getFont().getName(), Font.PLAIN, 25));
        totalTxt = new JLabel("Total: £0.00");
        totalTxt.setFont(new Font(promptTxt.getFont().getName(), Font.PLAIN, 25));

        startBtn = new JButton("Start");
        startBtn.addActionListener(
                e -> scanPane()
        );
        adminBtn = new JButton("Admin Login");
        adminBtn.addActionListener(
                e -> {
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

                    adminBtn.setEnabled(false);
                    startBtn.setEnabled(false);
                    promptTxt.setEnabled(false);
                    this.setEnabled(false);
                }
        );

        payBtn = new JButton("Finish & Pay");
        payBtn.addActionListener(
                e -> {
                    if (tableContents != null){

                    }
                }
        );
        backBtn = new JButton("Back");
        backBtn.addActionListener(
                e -> {
                    dispose();

                    IModelSubject model = new Model();
                    try{
                        Method method = model.getClass().getMethod("loadAdmins");
                        method.invoke(model);
                    }
                    catch(Exception ex){

                    }
                    try{
                        Method method = model.getClass().getMethod("loadStock");
                        method.invoke(model);
                    }
                    catch(Exception ex){

                    }

                    KioskView kioskScanView = new ScanView();
                    IUserController kioskScanControl = new Controller(model, kioskScanView);
                }
        );

        scanInput = new JTextField();
        scanBtn = new JButton("scan");
        scanBtn. addActionListener(
                e -> {
                    if(!scanInput.getText().equals("")){
                        int n = 0;
                        inScan = scanInput.getText();
                        try{
                            inNumber = Integer.parseInt(inScan);
                        }
                        catch(Exception intError){
                            System.out.println("Not an Int!");
                        }

                        shopItem = controller.itemInStock(inNumber);
                        itemName = shopItem.getDescription();
                        itemPrice = shopItem.getPrice();

                        scannedItemTxt.setText(itemName);
                        scannedCostTxt.setText("£" + price.format(itemPrice));

                        totalPrice = totalPrice + itemPrice;
                        totalTxt.setText("£" + price.format(totalPrice));

                        newArray = new Object[tableContents.length + 1][2];

                        while(n <= tableContents.length -1){
                            newArray[n][0] = tableContents[n][0];
                            newArray[n][1] = tableContents[n][1];
                            n++;
                        }

                        newArray[n][0] = itemName;
                        newArray[n][1] = "£" + price.format(itemPrice);

                        tableContents = newArray;

                        scanTable = new JTable(tableContents, tableHeads);
                        scannedItemsPanel();
                    }
                }
        );

        tableHeads = new String[]{"Name", "Price"};
        tableContents = new Object[][]{};
        scanTable = new JTable(tableContents, tableHeads);

        mainBorder = new EmptyBorder(10,10,10,10);
        mainPanel.setBorder(mainBorder);
        itemPanel.setBorder(mainBorder);
        scanPanel.setBorder(mainBorder);
        backPanel.setBorder(mainBorder);

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
        setContentPane(blankPanel);
        itemPanel.add(scannedItemTxt);
        itemPanel.add(scannedCostTxt);
        itemPanel.add(scanInput);
        itemPanel.add(scanBtn);

        itemPanel.setLayout(new GridLayout(2,2,1,1));
//        setContentPane(itemPanel);
        setVisible(true);

        promptTxt.setText("Scanned Items:");
        scannedItemsPanel();

//        setContentPane(scanPanel);
//        getContentPane().add(scanPanel);

        backPanel.add(backBtn);
        backPanel.setLayout(new GridLayout(1,1,1,1));

        initialise2(itemPanel, scanPanel, backPanel);

    }

    public void scannedItemsPanel(){
        scanPanel.removeAll();
        scanPanel.add(promptTxt);
        scanPanel.add(scanTable);
        scanPanel.add(totalTxt);
        scanPanel.add(payBtn);
        scanPanel.setLayout(new GridLayout(4,1,1,1));
    }

}
