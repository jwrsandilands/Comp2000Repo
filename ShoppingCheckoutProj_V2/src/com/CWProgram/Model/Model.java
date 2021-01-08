package com.CWProgram.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Model implements IModelSubject {
    public List<IModelObserver> iModelObserver = new ArrayList<IModelObserver> ();
    private final ArrayList<ModelStockEntry> stockTable = new ArrayList<ModelStockEntry>();
    private ArrayList<ModelAdminDataEntry> adminTable = new ArrayList<ModelAdminDataEntry>();

    //establish variables
    public String separator = "\\|";
    public String stockDataFilePath = "Resources\\StockData";
    public String adminDataFilePath = "Resources\\AdminData";


    //set observer
    @Override
    public void add(IModelObserver observer) {
        iModelObserver.add(observer);
    }

    //read stock file
    public void loadStock(){
        try {
            File stockData = new File(stockDataFilePath);

            Scanner stockScanner = new Scanner(stockData);
            while (stockScanner.hasNextLine()) {
                //finds the next line to scan
                String data = stockScanner.nextLine();

                //breaks line data into an array
                String[] stockTableData = data.split(separator);

                //sets up the table to insert information into
                ModelStockEntry stockEntry = new ModelStockEntry();

                //Sets Stock ID
                int stockNumberToInt = Integer.parseInt(stockTableData[0]);
                stockEntry.setStockNumber(stockNumberToInt);

                //Sets Stock Desc
                stockEntry.setDescription(stockTableData[1]);

                //sets Price
                float priceToFloat = Float.parseFloat(stockTableData[2]);
                stockEntry.setPrice(priceToFloat);

                //sets quantity in stock
                int numberInStockToInt = Integer.parseInt(stockTableData[3]);
                stockEntry.setItemsInStock(numberInStockToInt);

                //sets alert level
                int alertLevelToInt = Integer.parseInt(stockTableData[4]);
                stockEntry.setAlertLevel(alertLevelToInt);

                stockTable.add(stockEntry);
            }
            stockScanner.close();

            System.out.println("Stock Import Successful!");
        }
        catch (FileNotFoundException e){
            System.out.println("Stock Import Unsuccessful... \n please check file location and properties.");
            e.printStackTrace();
        }
    }

    //read admin file
    public void loadAdmins() {
        try {
            File adminData = new File(adminDataFilePath);

            Scanner adminScanner = new Scanner(adminData);
            while (adminScanner.hasNextLine()) {
                //finds the next line to scan
                String data = adminScanner.nextLine();

                //breaks line data into an array
                String[] adminTableData = data.split(separator);

                //sets up the table to insert information into
                ModelAdminDataEntry adminEntry = new ModelAdminDataEntry();

                //Sets Admin ID
                int accountNumberToInt = Integer.parseInt(adminTableData[0]);
                adminEntry.setAccountNumber(accountNumberToInt);

                //Sets username
                adminEntry.setUsername(adminTableData[1]);

                //Sets password
                adminEntry.setPassword(adminTableData[2]);

                adminTable.add(adminEntry);
            }
            adminScanner.close();

            System.out.println("Admin Import Successful!");
        } catch (FileNotFoundException e) {
            System.out.println("Admin Import Unsuccessful... \n please check file location and properties.");
            e.printStackTrace();
        }
    }
        public ArrayList<ModelAdminDataEntry> getAdminData(){
        return adminTable;
        }

}
