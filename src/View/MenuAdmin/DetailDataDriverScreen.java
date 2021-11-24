/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.MenuAdmin;

import Controller.DatabaseControl;
import Model.Driver;
import Model.User;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Asus
 */
public class DetailDataDriverScreen {
    private JFrame frame = new JFrame();
    private JLabel labelJudul, labelDataUmum, labelDataDriver;
    private JLabel labelIdDriver, labelNama, labelEmail, labelTanggalLahir, labelNoHP, labelJenisKendaraan, labelPlatNomor, labelPendapatan, labelSaldoOvo, labelStatus;
    private JLabel labelIsiIdDriver, labelIsiNama, labelIsiEmail, labelIsiTanggalLahir, labelIsiNoHP, labelIsiJenisKendaraan, labelIsiPlatNomor, labelIsiPendapatan, labelIsiSaldoOvo, labelIsiStatus;
    private JButton backbutton;

    public DetailDataDriverScreen(User user) {
        frame.setSize(900,800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        DatabaseControl ctrl = new DatabaseControl();
        ArrayList<Driver> listDriver = new ArrayList<>();
        Driver driver = new Driver();
        listDriver = ctrl.getAllDriver();
        
        for(int i = 0; i < listDriver.size(); i++){
            if(listDriver.get(i).getId_User() == user.getId_User()){
                driver = listDriver.get(i);
            }
        }
        
        labelJudul = new JLabel("Data Diri");
        
        
        labelDataUmum = new JLabel("Data Pribadi");
        labelIdDriver = new JLabel("ID Driver");
        labelNama = new JLabel("Nama");
        labelTanggalLahir = new JLabel("Tanggal Lahir");
        labelNoHP = new JLabel("Nomor HP");
        
        labelIsiIdDriver = new JLabel(": " + Integer.toString(driver.getId_driver()));
        labelIsiNama = new JLabel(": " + driver.getNama());
        labelIsiTanggalLahir = new JLabel(": " + driver.getTanggallahir());
        labelIsiNoHP = new JLabel(": " + driver.getNoHp());
        
        labelDataDriver = new JLabel("Data Driver");
        labelJenisKendaraan = new JLabel("Jenis Kendaraan");
        labelPlatNomor = new JLabel("Plat Nomor");
        labelPendapatan = new JLabel("Pendapatan");
        labelSaldoOvo = new JLabel("Saldo OVO");
        labelStatus = new JLabel("Status");
        
        labelIsiJenisKendaraan = new JLabel(": " + driver.getJeniskendaraan());
        labelIsiPlatNomor = new JLabel(": " + driver.getPlatnomor());
        labelIsiPendapatan = new JLabel(": " + Integer.toString(driver.getPendapatan()));
        labelIsiSaldoOvo = new JLabel(": " + Integer.toString(driver.getSaldoOvo()));
        labelIsiStatus = new JLabel(": " + driver.getStatus());
        
        labelJudul.setBounds(300,20,300,50);
        
        labelDataUmum.setBounds(45,50,100,30);
        
        labelIdDriver.setBounds(20,80,100,50);
        labelNama.setBounds(20,130,150,50);
        labelTanggalLahir.setBounds(20,180,150,50);
        labelNoHP.setBounds(20,230,150,50);
        
        labelIsiIdDriver.setBounds(230,80,300,50);
        labelIsiNama.setBounds(230,130,300,50);
        labelIsiTanggalLahir.setBounds(230,180,300,50);
        labelIsiNoHP.setBounds(230,230,300,50);
        
        labelDataDriver.setBounds(400, 50, 100, 30);
        
        labelJenisKendaraan.setBounds(375, 80, 150, 50);
        labelPlatNomor.setBounds(375, 130, 150, 50);
        labelPendapatan.setBounds(375, 180, 150, 50);
        labelSaldoOvo.setBounds(375, 230, 150, 50);
        labelStatus.setBounds(375, 280, 150, 50);
        
        labelIsiJenisKendaraan.setBounds(485, 80, 300, 50);
        labelIsiPlatNomor.setBounds(485, 130, 300, 50);
        labelIsiPendapatan.setBounds(485, 180, 300, 50);
        labelIsiSaldoOvo.setBounds(485, 230, 300, 50);
        labelIsiStatus.setBounds(485, 280, 300, 50);
        
        labelJudul.setFont(new Font(labelJudul.getFont().getName(), labelJudul.getFont().getStyle(), 28));
        
        backbutton = new JButton("Back");
        backbutton.setBounds(300, 350, 150, 30);
        backbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new DataDriverScreen();
            }
        });
        
        frame.add(labelJudul);
        frame.add(labelDataUmum);
        frame.add(labelIdDriver);
        frame.add(labelNama);
        frame.add(labelTanggalLahir);
        frame.add(labelNoHP);
        frame.add(labelIsiIdDriver);
        frame.add(labelIsiNama);
        frame.add(labelIsiTanggalLahir);
        frame.add(labelIsiNoHP);
        frame.add(labelDataDriver);
        frame.add(labelJenisKendaraan);
        frame.add(labelPlatNomor);
        frame.add(labelPendapatan);
        frame.add(labelSaldoOvo);
        frame.add(labelStatus);
        frame.add(labelIsiJenisKendaraan);
        frame.add(labelIsiPlatNomor);
        frame.add(labelIsiPendapatan);
        frame.add(labelIsiSaldoOvo);
        frame.add(labelIsiStatus);
        frame.add(backbutton);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
