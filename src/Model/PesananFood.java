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
public class PesananFood extends Pesanan{
    private int ID_PesananFood;
    private int TotalHargaFood;
    private int Statusfood;

    public PesananFood() {
    }

    public PesananFood(int ID_PesananFood, int TotalHargaFood, int Statusfood) {
        this.ID_PesananFood = ID_PesananFood;
        this.TotalHargaFood = TotalHargaFood;
        this.Statusfood = Statusfood;
    }

    public PesananFood(int ID_PesananFood, int TotalHargaFood, int Statusfood, int id_pesanan, Customers customer, Driver driver, String tanggalpemesanan, String metodepembayaran, String titikawal, String titikakhir, int totalharga, int jarak) {
        super(id_pesanan, customer, driver, tanggalpemesanan, metodepembayaran, titikawal, titikakhir, totalharga, jarak);
        this.ID_PesananFood = ID_PesananFood;
        this.TotalHargaFood = TotalHargaFood;
        this.Statusfood = Statusfood;
    }

    public int getID_PesananFood() {
        return ID_PesananFood;
    }

    public void setID_PesananFood(int ID_PesananFood) {
        this.ID_PesananFood = ID_PesananFood;
    }

    public int getTotalHargaFood() {
        return TotalHargaFood;
    }

    public void setTotalHargaFood(int TotalHargaFood) {
        this.TotalHargaFood = TotalHargaFood;
    }

    public int getStatusfood() {
        return Statusfood;
    }

    public void setStatusfood(int Statusfood) {
        this.Statusfood = Statusfood;
    }

    
}
