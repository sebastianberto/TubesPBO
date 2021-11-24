/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PesananFood;

/**
 *
 * @author Sebastian Berto
 */
public class PesananFoodManager {
    static PesananFoodManager instance;
    private PesananFood pesananfood;
    
    public static PesananFoodManager getInstance(){
        if(instance == null){
            instance = new PesananFoodManager();
        }
        return instance;
    }

    public PesananFood getPesananfood() {
        return pesananfood;
    }

    public void setPesananfood(PesananFood pesananfood) {
        this.pesananfood = pesananfood;
    }
}
