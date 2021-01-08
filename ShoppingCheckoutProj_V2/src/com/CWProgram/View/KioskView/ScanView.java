package com.CWProgram.View.KioskView;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ScanView extends KioskView {

    JPanel mainPanel;

    JLabel promptTxt;
    JButton startBtn, adminBtn;

    EmptyBorder mainBorder;


    public ScanView(){
        mainPanel = new JPanel();
        promptTxt = new JLabel("Press the Button to Start!");
        promptTxt.setFont(new Font(promptTxt.getFont().getName(), Font.PLAIN, 25));
        startBtn = new JButton("Start");
        adminBtn = new JButton("Admin Login");



        mainBorder = new EmptyBorder(10,10,10,10);
        mainPanel.setBorder(mainBorder);

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



}
