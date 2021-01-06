package com.CWProgram.Controller;


import com.CWProgram.Model.IModelObserver;
import com.CWProgram.Model.IModelSubject;
import com.CWProgram.View.IView;

public class Controller implements IAdminController, IUserController, IModelObserver {

    public IModelSubject iModelSubject;
	public IView iView;

	public Controller(IModelSubject modelSubject, IView view){
	    this.iModelSubject = modelSubject;
	    this.iView = view;

	    this.iModelSubject.add(this);
	    this.iView.setController(this);
    }


}
