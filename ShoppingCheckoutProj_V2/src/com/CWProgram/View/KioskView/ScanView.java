package com.CWProgram.View.KioskView;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ScanView extends KioskView {

    JPanel mainPanel;

    JLabel promptTxt;
    JButton startBtn, adminBtn;

    EmptyBorder mainBorder;
    Dimension btnSize = new Dimension(80, 30);

    public ScanView(){
        mainPanel = new JPanel();
        promptTxt = new JLabel("Press the Button to Start!");
        startBtn = new JButton("Start");
        adminBtn = new JButton("Admin Log In");
        adminBtn.setPreferredSize(btnSize);


        mainBorder = new EmptyBorder(10,10,10,10);

        mainPanel.setBorder(mainBorder);
        mainPanel.add(adminBtn, BorderLayout.CENTER);
        setContentPane(mainPanel);
        initialiseBorder();
    }



}
