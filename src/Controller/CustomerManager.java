/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customers;

/**
 *
 * @author Sebastian Berto
 */
public class CustomerManager {
    static CustomerManager instance;
    private Customers customer;
    private boolean login;
    
    public static CustomerManager getInstance(){
        if(instance == null){
            instance = new CustomerManager();
        }
        return instance;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}
