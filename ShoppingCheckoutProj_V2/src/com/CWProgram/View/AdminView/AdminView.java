package com.CWProgram.View.AdminView;

import com.CWProgram.Controller.Controller;
import com.CWProgram.View.IView;

import javax.swing.*;
import java.awt.*;

public abstract class AdminView extends JFrame implements IView{
    protected Controller controller;

    protected void initialiseGrid(int rows, int cols){
        this.setLayout(new GridLayout(rows,cols));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(200,200));
        this.pack();

        this.setVisible(true);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
