/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.MenuCustomer;

import Controller.DatabaseControl;
import Controller.PesananFoodManager;
import Controller.PesananManager;
import Controller.PesananOjekManager;
import Model.DetailPesanan;
import Model.Pesanan;
import Model.PesananFood;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Asus
 */
public class PembayaranFoodScreen implements ActionListener{
    private JFrame framepembayarangojek = new JFrame();
    private JLabel labelnamapemesan, labelalamatjemput, labelalamattujuan,labeljarak, labeltotalharga,
            labelisinamapemesan, labelisialamatjemput, labelisialamattujuan, labelisijarak, labelisitotalharga,
            labelmetodepembayaran , labelnominal,labeljudul, labelPesanan, labelTotalHargaMakanan, labelIsiTotalHargaMakanan;
    private JLabel[] labelIsiPesanan, labelQuantity;
    private JComboBox cBmetodepembayaran;
    private JTextField fieldnominal;
    private JButton buttonBack, buttonSubmit, buttonCancel;
    private int jarak;  
    private int totalharga, totalHargaPesanan;
    private ArrayList<DetailPesanan> listDetailPesanan2 = new ArrayList<>();
    public PembayaranFoodScreen(ArrayList<DetailPesanan> listDetailPesanan){
        listDetailPesanan2 = listDetailPesanan;
        
        framepembayarangojek.setSize(900,800);
        framepembayarangojek.setLocationRelativeTo(null);
        framepembayarangojek.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //Label
        labeljudul = new JLabel("PEMBAYARAN");
        labeljudul.setBounds(300,20,300,50);
        labeljudul.setFont(new Font(labeljudul.getFont().getName(), labeljudul.getFont().getStyle(), 28));
        
        labelnamapemesan = new JLabel("Nama Pemesan: ");
        labelnamapemesan.setBounds(20,80,100,50);
                
        
        labelalamatjemput = new JLabel("Alamat Penjemputan: ");
        labelalamatjemput.setBounds(20,120,150,50);
                
        labelalamattujuan= new JLabel("Alamat Tujuan: ");        
        labelalamattujuan.setBounds(20,160,100,50);
        
        labeljarak = new JLabel("Jarak : ");
        labeljarak.setBounds(20,200,100,50);
        
        labelPesanan = new JLabel("Pesanan: ");
        labelPesanan.setBounds(20, 240, 100, 50);
        
        labelIsiPesanan = new JLabel[listDetailPesanan.size()];
        labelQuantity = new JLabel[listDetailPesanan.size()];
        
        int x1 = 40, x2 = 250, y = 280;
        totalHargaPesanan = 0;
        
        for(int i = 0; i < listDetailPesanan.size(); i++){
            totalHargaPesanan += (listDetailPesanan.get(i).getHargaSatuan() * listDetailPesanan.get(i).getQuantity());
            
            labelIsiPesanan[i] = new JLabel(listDetailPesanan.get(i).getNamaMenu());
            labelQuantity[i] = new JLabel("Quantity: " + Integer.toString(listDetailPesanan.get(i).getQuantity()));
            
            labelIsiPesanan[i].setBounds(x1, y, 100, 50);
            labelQuantity[i].setBounds(x2, y, 100, 50);
            y += 40;
        }
        
        labelTotalHargaMakanan = new JLabel("Total Harga Makanan: ");
        labelTotalHargaMakanan.setBounds(20, y, 150, 50);
        
        int y2 = y;
        
        labeltotalharga = new JLabel("Total Harga: ");
        labeltotalharga.setBounds(20,y+40,100,50);
        
        labelmetodepembayaran = new JLabel("Pilih Metode Pembayarannya: ");
        labelmetodepembayaran.setBounds(20,y+80,170,50);
        
        labelnominal = new JLabel("Nominal: ");
        labelnominal.setBounds(20,y+150,100,50);
        
        labelisinamapemesan = new JLabel(PesananManager.getInstance().getPesanan().getCustomer().getNama());
        labelisinamapemesan.setBounds(230,80,300,50);
        
        labelisialamatjemput = new JLabel(PesananManager.getInstance().getPesanan().getTitikawal());
        labelisialamatjemput.setBounds(230,160,300,50);
        
        labelisialamattujuan = new JLabel(PesananManager.getInstance().getPesanan().getTitikakhir());
        labelisialamattujuan.setBounds(230,200,300,50);
        
        Random angkarandom = new Random();
        jarak = angkarandom.nextInt(10) + 1;
        labelisijarak = new JLabel(jarak + "KM");
        labelisijarak.setBounds(230,240,300,50);
        
        int harga = 3500;
        
        totalharga = (harga * jarak) + totalHargaPesanan;
        labelisitotalharga = new JLabel(Integer.toString(totalharga));
        labelisitotalharga.setBounds(230,y2+40,300,50);
        
        labelIsiTotalHargaMakanan = new JLabel(Integer.toString(totalHargaPesanan));
        labelIsiTotalHargaMakanan.setBounds(230, y2, 300, 50);
        //Text Field
        fieldnominal = new JTextField("ISI NOMINAL DISINI");
        fieldnominal.setBounds(230,y2+150,300,50);
        
        
        //Combo Box
        String metodepembayaran[] = {"OVO","Tunai"};
        cBmetodepembayaran = new JComboBox(metodepembayaran);
        cBmetodepembayaran.setBounds(230,y2+80,170,50);
        cBmetodepembayaran.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(cBmetodepembayaran.getItemAt(cBmetodepembayaran.getSelectedIndex()).equals("OVO")){
                    framepembayarangojek.add(fieldnominal);
                }else{
                    framepembayarangojek.remove(fieldnominal);
                }
            }
        });

        //Button
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(100,700,100,50);
        buttonSubmit.addActionListener(this);
        
        buttonBack = new JButton("Back");
        buttonBack.setBounds(300,700,100,50);
        buttonBack.addActionListener(this);
        
        buttonCancel = new JButton("Cancel");
        buttonCancel.setBounds(500,700,200,50);
        buttonCancel.addActionListener(this);
        
        for(int i = 0; i < listDetailPesanan.size(); i++){
            framepembayarangojek.add(labelIsiPesanan[i]);
            framepembayarangojek.add(labelQuantity[i]);
        }
        framepembayarangojek.add(labelTotalHargaMakanan);
        framepembayarangojek.add(labelIsiTotalHargaMakanan);
        framepembayarangojek.add(labelPesanan);
        framepembayarangojek.add(labeljudul);
        framepembayarangojek.add(labelnamapemesan);
        framepembayarangojek.add(labelalamatjemput);
        framepembayarangojek.add(labelalamattujuan);
        framepembayarangojek.add(labeljarak);
        framepembayarangojek.add(labeltotalharga);
        framepembayarangojek.add(labelmetodepembayaran);
        framepembayarangojek.add(labelnominal);
        framepembayarangojek.add(labelisinamapemesan);
        framepembayarangojek.add(labelisialamatjemput);
        framepembayarangojek.add(labelisialamattujuan);
        framepembayarangojek.add(labelisijarak);
        framepembayarangojek.add(labelisitotalharga);
        framepembayarangojek.add(fieldnominal);
        framepembayarangojek.add(cBmetodepembayaran);
        framepembayarangojek.add(buttonBack);
        framepembayarangojek.add(buttonSubmit);
        framepembayarangojek.add(buttonCancel);
        
        framepembayarangojek.setLayout(null);
        framepembayarangojek.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case "Submit":
                PesananManager.getInstance().getPesanan().setMetodepembayaran((String) cBmetodepembayaran.getItemAt(cBmetodepembayaran.getSelectedIndex()));
                PesananManager.getInstance().getPesanan().setJarak(jarak);
                PesananManager.getInstance().getPesanan().setTotalharga(totalharga);
                Date date = new Date();
                SimpleDateFormat s = new SimpleDateFormat("dd-mm-yyyy");
                String tanggal = s.format(date);
                PesananManager.getInstance().getPesanan().setTanggalpemesanan(tanggal);
                DatabaseControl ctrl = new DatabaseControl();
                ctrl.insertNewPesanan(PesananManager.getInstance().getPesanan());
                
                ArrayList<PesananFood> listPesananFood = new ArrayList<>();
                listPesananFood = ctrl.getAllPesananFood();
                int idPesananFood = listPesananFood.get(listPesananFood.size()-1).getID_PesananFood();
                
                ArrayList<Pesanan> listPesanan = new ArrayList<>();
                int idPesanan = listPesanan.get(listPesanan.size()-1).getId_pesanan();
                
                PesananFood pesananFood = new PesananFood();
                pesananFood.setID_PesananFood(idPesananFood);
                pesananFood.setId_pesanan(idPesanan);
                pesananFood.setTotalHargaFood(totalHargaPesanan);
                pesananFood.setStatusfood(2);
                
                ctrl.insertNewPesanan(PesananManager.getInstance().getPesanan());
                ctrl.insertNewPesananFood(pesananFood);
                ctrl.insertNewDetailFood(listDetailPesanan2, pesananFood);
                
            break;
            case "Back":
                framepembayarangojek.setVisible(false);
                new MenuGojek();
            break;
            case "Cancel":
                framepembayarangojek.setVisible(false);
                new CustomerScreen();
        }
    }
}
