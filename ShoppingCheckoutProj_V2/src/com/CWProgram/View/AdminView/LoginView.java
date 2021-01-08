package com.CWProgram.View.AdminView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class LoginView extends AdminView {

    JPanel mainPanel;

    JLabel usernameTxt, passwordTxt;
    JTextField usernameIn;
    JPasswordField passwordIn;
    JButton enterButton;
    JSeparator separator;
    EmptyBorder mainBorder;
    int nameCounter = 0, passCounter = 0;
    boolean infoTrue = false;

    public LoginView(){
        mainPanel = new JPanel();
        mainBorder = new EmptyBorder(10,10,10,10);
        usernameTxt = new JLabel("Username:");
        passwordTxt = new JLabel("Password:");

        usernameIn = new JTextField("username");
        usernameIn.setForeground(Color.gray);
        usernameIn.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if (nameCounter == 0) {
                            usernameIn.setText(null);
                            usernameIn.setForeground(Color.black);
                            nameCounter++;
                        }
                    }
                }
        );
        usernameIn.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        if(usernameIn.getText().isEmpty()){
                            usernameIn.setForeground(Color.gray);
                            usernameIn.setText("username");
                            nameCounter--;
                        }
                    }
                }
        );

        passwordIn = new JPasswordField("password");
        passwordIn.setForeground(Color.gray);
        passwordIn.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if (passCounter == 0){
                            passwordIn.setText("");
                            passwordIn.setForeground(Color.black);
                            passCounter++;
                        }
                    }
                }
        );
        passwordIn.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        if(passwordIn.getText().isEmpty()){
                            passwordIn.setForeground(Color.gray);
                            passwordIn.setText("password");
                            passCounter--;
                        }
                    }
                }
        );

        enterButton = new JButton("Enter");
        enterButton.addActionListener(
                e -> {
                    System.out.println("button Press!");
                    if(nameCounter + passCounter == 2){
                        infoTrue = controller.matchAdminData(usernameIn.getText(), passwordIn.getPassword());

                        //--- to be finished later---

                    }
                }
        );

        separator = new JSeparator();

        mainPanel.add(usernameTxt);
        mainPanel.add(usernameIn);
        mainPanel.add(passwordTxt);
        mainPanel.add(passwordIn);
        mainPanel.add(separator);
        mainPanel.add(enterButton);

        mainPanel.setBorder(mainBorder);

        setContentPane(mainPanel);

        initialiseGrid(3,2);
    }
}
