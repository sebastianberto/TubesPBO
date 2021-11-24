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
public class Pesanan {
    private int id_pesanan;
    private Customers customer;
    private Driver driver;
    private String tanggalpemesanan;
    private String metodepembayaran;
    private String titikawal;
    private String titikakhir;
    private int totalharga;
    private int jarak;
    
    public Pesanan(){
    
    }

    public Pesanan(int id_pesanan, Customers customer, Driver driver, String tanggalpemesanan, String metodepembayaran, String titikawal, String titikakhir, int totalharga, int jarak) {
        this.id_pesanan = id_pesanan;
        this.customer = customer;
        this.driver = driver;
        this.tanggalpemesanan = tanggalpemesanan;
        this.metodepembayaran = metodepembayaran;
        this.titikawal = titikawal;
        this.titikakhir = titikakhir;
        this.totalharga = totalharga;
        this.jarak = jarak;
    }

    public int getId_pesanan() {
        return id_pesanan;
    }

    public void setId_pesanan(int id_pesanan) {
        this.id_pesanan = id_pesanan;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getTanggalpemesanan() {
        return tanggalpemesanan;
    }

    public void setTanggalpemesanan(String tanggalpemesanan) {
        this.tanggalpemesanan = tanggalpemesanan;
    }

    public String getMetodepembayaran() {
        return metodepembayaran;
    }

    public void setMetodepembayaran(String metodepembayaran) {
        this.metodepembayaran = metodepembayaran;
    }

    public String getTitikawal() {
        return titikawal;
    }

    public void setTitikawal(String titikawal) {
        this.titikawal = titikawal;
    }

    public String getTitikakhir() {
        return titikakhir;
    }

    public void setTitikakhir(String titikakhir) {
        this.titikakhir = titikakhir;
    }

    public int getTotalharga() {
        return totalharga;
    }

    public void setTotalharga(int totalharga) {
        this.totalharga = totalharga;
    }

    public int getJarak() {
        return jarak;
    }

    public void setJarak(int jarak) {
        this.jarak = jarak;
    }

    
}
