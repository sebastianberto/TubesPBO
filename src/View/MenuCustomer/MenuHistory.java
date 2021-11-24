/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.MenuCustomer;

import View.MenuDriver.DriverScreen;
import Controller.CustomerManager;
import Controller.DatabaseControl;
import Controller.UserManager;
import Model.Customers;
import Model.DetailPesanan;
import Model.Driver;
import Model.Pesanan;
import Model.PesananFood;
import Model.PesananOjek;
import View.ScreenLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author William
 */
public class MenuHistory {
    private JTable tableHistory;
    private JButton buttonBack, buttonLogout;
    private JScrollPane sp;
    JFrame frame = new JFrame();
    public MenuHistory(){
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String tabelkolom[] = {"ID", "Tipe Pesanan", "Tanggal Pemesanan", "Jenis Kendaraan", "Menu", "Alamat Jemput", "Alamat Tujuan", "Jarak", "Metode Pembayaran", "Total Harga Makanan", "Total Harga", "Status"};
        
        ArrayList<Pesanan> listPesanan = new ArrayList<>();
        ArrayList<Pesanan> listPesananCustomer = new ArrayList<>();
        ArrayList<PesananOjek> listPesananOjek = new ArrayList<>();
        ArrayList<PesananFood> listPesananFood = new ArrayList<>();
        DatabaseControl ctrl = new DatabaseControl();
        
        listPesanan = ctrl.getAllPesanan();
        listPesananOjek = ctrl.getAllPesananOjek();
        listPesananFood = ctrl.getAllPesananFood();
        
        for(int i = 0; i < listPesanan.size(); i++){
            if(listPesanan.get(i).getCustomer().getId_customer() == CustomerManager.getInstance().getCustomer().getId_customer()){
                listPesananCustomer.add(listPesanan.get(i));
            }
        }
        
        int baris = listPesananCustomer.size();
        int kolom = 12;
        
        String data[][] = new String[baris][kolom];
        
        for(int i = 0 ; i < listPesananCustomer.size(); i++){
            for(int j = 0; j < listPesananOjek.size(); j++){
                System.out.println(listPesananCustomer.get(i).getId_pesanan() == listPesananOjek.get(j).getId_pesanan());
                if(listPesananCustomer.get(i).getId_pesanan() == listPesananOjek.get(j).getId_pesanan()){
                    data[i][0] = Integer.toString(listPesananCustomer.get(i).getId_pesanan());
                    data[i][1] = "GOJEK";
                    data[i][2] = listPesananCustomer.get(i).getTanggalpemesanan();
                    data[i][3] = listPesananOjek.get(j).getJeniskendaraan();
                    data[i][4] = "-";
                    data[i][5] = listPesananCustomer.get(i).getTitikawal();
                    data[i][6] = listPesananCustomer.get(i).getTitikakhir();
                    data[i][7] = Integer.toString(listPesananCustomer.get(i).getJarak());
                    data[i][8] = listPesananCustomer.get(i).getMetodepembayaran();
                    data[i][9] = "-";
                    data[i][10] = Integer.toString(listPesananCustomer.get(i).getTotalharga());
                    
                    String status = "";
                    
                    switch(listPesananOjek.get(j).getStatuspesanan()){
                        case 1:
                            status = "Beres";
                            break;
                        case 2:
                            status = "On-Going";
                            break;
                        case 3:
                            status = "Cancel";
                            break;
                    }
                    data[i][11] = status;
                }
            }
            for(int j = 0; j < listPesananFood.size(); j++){
                System.out.println(listPesananCustomer.get(i).getId_pesanan() == listPesananFood.get(j).getId_pesanan());
                if(listPesananCustomer.get(i).getId_pesanan() == listPesananFood.get(j).getId_pesanan()){
                    data[i][0] = Integer.toString(listPesananCustomer.get(i).getId_pesanan());
                    data[i][1] = "GOFOOD";
                    data[i][2] = listPesananCustomer.get(i).getTanggalpemesanan();
                    data[i][3] = "Motor";
                    data[i][4] = "";
                    
                    ArrayList<DetailPesanan> listDetailPesanan = new ArrayList<>();
                    listDetailPesanan = ctrl.getAllDetailPesanan(listPesananFood.get(j).getID_PesananFood());
                    for(int k = 0; k < listDetailPesanan.size(); k++){
                        data[i][4] += listDetailPesanan.get(i).getNamaMenu() + "\n";
                    }
                    data[i][5] = listPesananCustomer.get(i).getTitikawal();
                    data[i][6] = listPesananCustomer.get(i).getTitikakhir();
                    data[i][7] = Integer.toString(listPesananCustomer.get(i).getJarak());
                    data[i][8] = listPesananCustomer.get(i).getMetodepembayaran();
                    data[i][9] = Integer.toString(listPesananFood.get(j).getTotalHargaFood());
                    data[i][10] = Integer.toString(listPesananCustomer.get(i).getTotalharga());
                    
                    String status = "";
                    
                    switch(listPesananFood.get(j).getStatusfood()){
                        case 1:
                            status = "Beres";
                            break;
                        case 2:
                            status = "On-Going";
                            break;
                        case 3:
                            status = "Cancel";
                            break;
                    }
                    data[i][11] = status;
                }
            }
        }
        
        tableHistory = new JTable(data, tabelkolom);
        buttonBack = new JButton("Back");
        buttonLogout = new JButton("Logout");
        
        tableHistory.setBounds(30, 40, 800, 300);
        buttonBack.setBounds(300, 300, 100, 20);
        buttonLogout.setBounds(410, 300, 100, 20);
        
        sp = new JScrollPane(tableHistory);
        
        buttonLogout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jawab = JOptionPane.showConfirmDialog(null, "Yakin ingin Logout?");
                switch(jawab){
                    case JOptionPane.YES_OPTION:
                        JOptionPane.showMessageDialog(null, "Terima kasih terlah menggunakan aplikasi ini!");
                        frame.setVisible(false);
                        UserManager.getInstance().setUser(null);
                        new ScreenLogin();
                }
            }
        });
        buttonBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });
        frame.add(sp);
        frame.setVisible(true);
    }
}
