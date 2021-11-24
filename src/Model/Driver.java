/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;
/**
 *
 * @author Asus
 */
public class Driver extends User{
    private int id_driver;
    private String jeniskendaraan;
    private String platnomor;
    private int pendapatan;
    private int saldoOvo;
    private String status;
    

    public Driver() {
    }

    public Driver(int id_driver, String jeniskendaraan, String platnomor, int pendapatan, int saldoOvo, String status) {
        this.id_driver = id_driver;
        this.jeniskendaraan = jeniskendaraan;
        this.platnomor = platnomor;
        this.pendapatan = pendapatan;
        this.saldoOvo = saldoOvo;
        this.status = status;
    }

    public Driver(int id_driver, String jeniskendaraan, String platnomor, int pendapatan, int saldoOvo, String status, int id_User, String nama, String username, String password, String noHp, String email, String tanggallahir, int tipe) {
        super(id_User, nama, username, password, noHp, email, tanggallahir, tipe);
        this.id_driver = id_driver;
        this.jeniskendaraan = jeniskendaraan;
        this.platnomor = platnomor;
        this.pendapatan = pendapatan;
        this.saldoOvo = saldoOvo;
        this.status = status;
    }

    public int getId_driver() {
        return id_driver;
    }

    public void setId_driver(int id_driver) {
        this.id_driver = id_driver;
    }

    public String getJeniskendaraan() {
        return jeniskendaraan;
    }

    public void setJeniskendaraan(String jeniskendaraan) {
        this.jeniskendaraan = jeniskendaraan;
    }

    public String getPlatnomor() {
        return platnomor;
    }

    public void setPlatnomor(String platnomor) {
        this.platnomor = platnomor;
    }

    public int getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(int pendapatan) {
        this.pendapatan = pendapatan;
    }

    public int getSaldoOvo() {
        return saldoOvo;
    }

    public void setSaldoOvo(int saldoOvo) {
        this.saldoOvo = saldoOvo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
