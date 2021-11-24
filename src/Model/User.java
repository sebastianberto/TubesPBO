/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.AdminManager;
import Controller.CustomerManager;
import Controller.DatabaseControl;
import Controller.DriverManager;
import Controller.UserManager;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class User {
    private int id_User;
    private String nama;
    private String username;
    private String password;
    private String noHp;
    private String email;
    private String tanggallahir;
    private int tipe;
    
    public User(){
    
    }

    public User(int id_User, String nama, String username, String password, String noHp, String email, String tanggallahir, int tipe) {
        this.id_User = id_User;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.noHp = noHp;
        this.email = email;
        this.tanggallahir = tanggallahir;
        this.tipe = tipe;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTanggallahir() {
        return tanggallahir;
    }

    public void setTanggallahir(String tanggallahir) {
        this.tanggallahir = tanggallahir;
    }

    public int getTipe() {
        return tipe;
    }

    public void setTipe(int tipe) {
        this.tipe = tipe;
    }

          
    public boolean cekLogin(String username, String password){
        ArrayList<User> listUser = new ArrayList<>();
        boolean status = false;
        DatabaseControl dbControl = new DatabaseControl();
        listUser = dbControl.getAllUser();
        
        for(int i = 0; i < listUser.size(); i++){
            if(listUser.get(i).getUsername().equals(username) && listUser.get(i).getPassword().equals(password)){
                status = true;
                UserManager.getInstance().setUser(listUser.get(i));
            }
        }
        return status;
    }
}
