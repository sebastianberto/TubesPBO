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
public class Food {
    private int idmakanan;
    private String namamakanan;
    Restaurant restaurant;
    private int hargamakanan;

    public Food() {
    }

    public Food(int idmakanan, String namamakanan, Restaurant restaurant, int hargamakanan) {
        this.idmakanan = idmakanan;
        this.namamakanan = namamakanan;
        this.restaurant = restaurant;
        this.hargamakanan = hargamakanan;
    }

    public int getIdmakanan() {
        return idmakanan;
    }

    public void setIdmakanan(int idmakanan) {
        this.idmakanan = idmakanan;
    }

    public String getNamamakanan() {
        return namamakanan;
    }

    public void setNamamakanan(String namamakanan) {
        this.namamakanan = namamakanan;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getHargamakanan() {
        return hargamakanan;
    }

    public void setHargamakanan(int hargamakanan) {
        this.hargamakanan = hargamakanan;
    }

    
    
    
}
