/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PesananOjek;

/**
 *
 * @author Sebastian Berto
 */
public class PesananOjekManager {
    static PesananOjekManager instance;
    private PesananOjek pesananojek;
    
    public static PesananOjekManager getInstance(){
        if(instance == null){
            instance = new PesananOjekManager();
        }
        return instance;
    }

    public PesananOjek getPesananojek() {
        return pesananojek;
    }

    public void setPesananojek(PesananOjek pesananojek) {
        this.pesananojek = pesananojek;
    }
    
}
