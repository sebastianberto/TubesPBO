/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yudistira;

/**
 *
 * @author yudis
 */
// List Orderan yang ditampilkan id,namapemesan,waktu
// List Orderan diurutkan berdasarkan waktu yang paling awal seperti membeli di geprek bebas

public class LiistOrderan {
    private String id ;
    private String namaPemesan;
    private int waktu;
    
    public LiistOrderan(String id,String namaPemesan,int waktu){
        this.id = id;
        this.namaPemesan=namaPemesan;
        this.waktu=waktu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaPemesan() {
        return namaPemesan;
    }

    public void setNamaPemesan(String namaPemesan) {
        this.namaPemesan = namaPemesan;
    }

    public int getWaktu() {
        return waktu;
    }

    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }
    
}
