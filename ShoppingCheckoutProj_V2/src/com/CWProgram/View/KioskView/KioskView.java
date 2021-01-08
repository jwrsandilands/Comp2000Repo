package com.CWProgram.View.KioskView;

import com.CWProgram.Controller.Controller;
import com.CWProgram.View.IView;

import javax.swing.*;
import java.awt.*;

public abstract class KioskView extends JFrame implements IView {
    protected Controller controller;

    protected void initialise(int rows, int cols){
        this.setLayout(new GridLayout(rows,cols,1,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1500,900));
        this.pack();

        this.setVisible(true);
    }

    public void setController(Controller controller){
        this.controller = controller;
    }
}
