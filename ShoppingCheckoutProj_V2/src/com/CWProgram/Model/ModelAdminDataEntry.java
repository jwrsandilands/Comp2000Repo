package com.CWProgram.Model;

public class ModelAdminDataEntry {
    private int accountNumber;
    private String username;
    private String password;

    //getters
    public int getAccountNumber(){
        return accountNumber;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    //setters
    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
