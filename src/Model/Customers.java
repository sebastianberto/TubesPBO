/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
/**
 *
 * @author Asus
 */
public class Customers extends User{
    private int id_customer;
    private int Saldoovo;
    private String alamat;
    
    public Customers(){
    }

    public Customers(int id_customer, int Saldoovo, String alamat) {
        this.id_customer = id_customer;
        this.Saldoovo = Saldoovo;
        this.alamat = alamat;
    }

    public Customers(int id_customer, int Saldoovo, String alamat, int id_User, String nama, String username, String password, String noHp, String email, String tanggallahir, int tipe) {
        super(id_User, nama, username, password, noHp, email, tanggallahir, tipe);
        this.id_customer = id_customer;
        this.Saldoovo = Saldoovo;
        this.alamat = alamat;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getSaldoovo() {
        return Saldoovo;
    }

    public void setSaldoovo(int Saldoovo) {
        this.Saldoovo = Saldoovo;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
