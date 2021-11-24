/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

/**
 *
 * @author yudis
 */
public class Topup {
    private String id ;
    private String nama;
    private int saldoKartu;
    
    public Topup(String id,String nama,int saldoKartu){
        this.id = id;
        this.nama=nama;
        this.saldoKartu=saldoKartu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getSaldoKartu() {
        return saldoKartu;
    }

    public void setSaldoKartu(int saldoKartu) {
        this.saldoKartu = saldoKartu;
    }
    
    @Override
    public String toString() {
        return "Topup{" + "id=" + id + ", nama=" + nama + ", saldoKartu=" +'}';
    }
            
    
   
    
}
