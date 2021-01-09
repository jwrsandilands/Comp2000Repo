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

public class ScanView extends KioskView {

    JPanel mainPanel, scanPanel;

    JLabel promptTxt;
    JButton startBtn, adminBtn;

    EmptyBorder mainBorder;


    public ScanView(){
        mainPanel = new JPanel();
        scanPanel = new JPanel();
        promptTxt = new JLabel("Press the Button to Start!");
        promptTxt.setFont(new Font(promptTxt.getFont().getName(), Font.PLAIN, 25));
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
                        startBtn.setEnabled(false);
                        adminBtn.setEnabled(false);
                        mainPanel.setEnabled(false);

                        Model model = new Model();
                        AdminView adminLoginView = new LoginView();
                        IAdminController adminLoginControl = new Controller(model, adminLoginView);
                    }
                }
        );

        mainBorder = new EmptyBorder(10,10,10,10);
        mainPanel.setBorder(mainBorder);

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

        scanPanel.add(promptTxt);

        setContentPane(scanPanel);
        initialise(3,3);
    }

}
