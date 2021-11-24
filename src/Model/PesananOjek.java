/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Sebastian Berto
 */
public class PesananOjek extends Pesanan {
    private int id_pesananojek;
    private String jeniskendaraan;
    private int statuspesanan;
    
    public PesananOjek(){
    }

    public PesananOjek(int id_pesananojek, String jeniskendaraan, int statuspesanan) {
        this.id_pesananojek = id_pesananojek;
        this.jeniskendaraan = jeniskendaraan;
        this.statuspesanan = statuspesanan;
    }

    public PesananOjek(int id_pesananojek, String jeniskendaraan, int statuspesanan, int id_pesanan, Customers customer, Driver driver, String tanggalpemesanan, String metodepembayaran, String titikawal, String titikakhir, int totalharga, int jarak) {
        super(id_pesanan, customer, driver, tanggalpemesanan, metodepembayaran, titikawal, titikakhir, totalharga, jarak);
        this.id_pesananojek = id_pesananojek;
        this.jeniskendaraan = jeniskendaraan;
        this.statuspesanan = statuspesanan;
    }

    public int getId_pesananojek() {
        return id_pesananojek;
    }

    public void setId_pesananojek(int id_pesananojek) {
        this.id_pesananojek = id_pesananojek;
    }

    public String getJeniskendaraan() {
        return jeniskendaraan;
    }

    public void setJeniskendaraan(String jeniskendaraan) {
        this.jeniskendaraan = jeniskendaraan;
    }

    public int getStatuspesanan() {
        return statuspesanan;
    }

    public void setStatuspesanan(int statuspesanan) {
        this.statuspesanan = statuspesanan;
    }
    
    
}
