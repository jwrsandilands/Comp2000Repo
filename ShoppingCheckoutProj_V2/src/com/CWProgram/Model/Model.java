package com.CWProgram.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Model implements IModelSubject {
    public List<IModelObserver> iModelObserver = new ArrayList<IModelObserver> ();
    private final ArrayList<ModelStockEntry> stockTable = new ArrayList<ModelStockEntry>();

    //establish variables
    public String seperator = "\\|";
    public String stockDataFilePath = "Resources\\StockData";


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
                //scans the next line to scan
                String data = stockScanner.nextLine();

                //breaks line data into an array
                String[] stockTableData = data.split(seperator);

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

            System.out.println("Import Successful!");
        }
        catch (FileNotFoundException e){
            System.out.println("Import unsuccessful...");
            e.printStackTrace();
        }
    }

}
