package com.CWProgram.View.AdminView;

import com.CWProgram.Controller.Controller;
import com.CWProgram.Controller.IAdminController;

public class StockView extends AdminView {

    private IAdminController controller;

    @Override
    public void setController(Controller value) {
        this.controller = controller;
    }
}
