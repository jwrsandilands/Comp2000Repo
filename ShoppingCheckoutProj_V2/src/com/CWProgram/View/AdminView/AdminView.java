package com.CWProgram.View.AdminView;

import com.CWProgram.Controller.Controller;
import com.CWProgram.View.IView;

import javax.swing.*;
import java.awt.*;

public abstract class AdminView extends JFrame implements IView{
    protected Controller controller;

    protected void initialiseLogin(int rows, int cols){
        this.setLayout(new GridLayout(rows,cols, 2, 2));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(200,200));
        this.pack();

        this.setVisible(true);
    }

    protected void closeLogin(){
        this.dispose();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
