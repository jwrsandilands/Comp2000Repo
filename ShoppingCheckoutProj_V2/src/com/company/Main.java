package com.company;

import com.CWProgram.Controller.Controller;
import com.CWProgram.Controller.IAdminController;
import com.CWProgram.Controller.IUserController;
import com.CWProgram.Model.IModelSubject;
import com.CWProgram.Model.Model;
import com.CWProgram.View.AdminView.AdminView;
import com.CWProgram.View.AdminView.LoginView;
import com.CWProgram.View.AdminView.OrderView;
import com.CWProgram.View.AdminView.StockView;
import com.CWProgram.View.KioskView.KioskView;
import com.CWProgram.View.KioskView.PayView;
import com.CWProgram.View.KioskView.ScanView;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
	// write your code here

        IModelSubject model = new Model();
        try{
            Method method = model.getClass().getMethod("loadStock");
            method.invoke(model);
        }
        catch(Exception ex){

        }


        AdminView adminLoginView = new LoginView();
        IAdminController adminLoginControl = new Controller(model, adminLoginView);

        AdminView adminStockView = new StockView();
        IAdminController adminStockControl = new Controller(model, adminStockView);

        AdminView adminOrderView = new OrderView();
        IAdminController adminOrderControl = new Controller(model, adminOrderView);

        KioskView kisokScanView = new ScanView();
        IUserController kioskScanControl = new Controller(model, kisokScanView);

        KioskView kioskPayView = new PayView();
        IUserController kioskPayControl = new Controller(model, kisokScanView);
    }
}
