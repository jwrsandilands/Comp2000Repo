package com.CWProgram.Controller;

import com.CWProgram.Model.IModelObserver;
import com.CWProgram.Model.IModelSubject;
import com.CWProgram.Model.ModelAdminDataEntry;
import com.CWProgram.Model.ModelStockEntry;
import com.CWProgram.View.IView;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Controller implements IAdminController, IUserController, IModelObserver {
	public IModelSubject iModelSubject;
	public IView iView;

	public Controller(IModelSubject modelSubject, IView view){
	    this.iModelSubject = modelSubject;
	    this.iView = view;

	    modelSubject.add(this);
	    view.setController(this);
    }

    //user info data login system
	public boolean matchAdminData(String username, char[] password){
		try{
			//set variables
			String inUser;
			String inPass;
			char[] inPassChars;
			int counter = 0;
			boolean trueUser = false;
			boolean truePass = false;
			boolean truePassChar = true;

			//fetch the table data
			Method method = iModelSubject.getClass().getDeclaredMethod("getAdminData");
			ArrayList<ModelAdminDataEntry> adminTable = new ArrayList<ModelAdminDataEntry>();
			adminTable = (ArrayList<ModelAdminDataEntry>) method.invoke(iModelSubject);
			inUser = null;

			//check for the input username
			while(counter <= adminTable.size() -1 && !username.equals(inUser)) {
				inUser = adminTable.get(counter).getUsername();
				counter++;
			}
			//if the username is right say so and then check the password
			if(username.equals(inUser)){
				trueUser = true;

				//check the password
				inPass = adminTable.get(counter-1).getPassword();
				inPassChars = inPass.toCharArray();
				counter = 0;
				//check every character in the password, and if the password is longer or shorter return false anyway
				while(inPassChars.length - 1 >= counter && truePassChar){
					if(inPassChars[counter] != password[counter] || inPassChars.length != password.length){
						truePassChar = false;
					}
					counter ++;
				}
				//if the password is right say so
				if(truePassChar){
					truePass = true;
				}
				else{
					truePass = false;
				}
			}
			else{
				trueUser = false;
			}

			//if username and password are right then say so
			if(trueUser && truePass) {
				System.out.println("Answer is true!");
				return true;
			}
			else{
				System.out.println("Answer is false!");
				return false;
			}
		}
		//if there is some error report it
		catch(Exception unexpected){
			System.out.println("An unexpected error has occurred!");
			return false;
		}
	}

	public ModelStockEntry itemInStock(int IDValue){
		try{
			Method method = iModelSubject.getClass().getDeclaredMethod("getStockTable");
			ArrayList<ModelStockEntry> stockTable = new ArrayList<ModelStockEntry>();
			stockTable = (ArrayList<ModelStockEntry>) method.invoke(iModelSubject);

			return stockTable.get(IDValue);
		}
		catch(Exception unexpected){
			System.out.println("An unexpected error has occurred!");
			return null;
		}

	}

}
