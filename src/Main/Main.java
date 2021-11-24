/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.AdminManager;
import Controller.CustomerManager;
import Controller.DriverManager;
import Controller.PesananManager;
import Controller.UserManager;
import View.MenuCustomer.MenuGojek;
import View.ScreenLogin;

/**
 *
 * @author Asus
 */
public class Main {
    public static void main(String[] args) {
        AdminManager.getInstance().setAdmin(null);
        CustomerManager.getInstance().setCustomer(null);
        DriverManager.getInstance().setDrivers(null);
        PesananManager.getInstance().setPesanan(null);
        UserManager.getInstance().setUser(null);
        new ScreenLogin();
    }
}
