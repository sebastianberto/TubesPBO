/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author William
 */
public class Admin extends User{
    private int id_admin;
    private String alamat;
    
    
    public Admin(){
        
    }

    public Admin(int id_admin, String alamat) {
        this.id_admin = id_admin;
        this.alamat = alamat;
    }

    public Admin(int id_admin, String alamat, int id_User, String nama, String username, String password, String noHp, String email, String tanggallahir, int tipe) {
        super(id_User, nama, username, password, noHp, email, tanggallahir, tipe);
        this.id_admin = id_admin;
        this.alamat = alamat;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}