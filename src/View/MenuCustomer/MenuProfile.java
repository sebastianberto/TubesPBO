/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.MenuCustomer;

import View.MenuCustomer.CustomerScreen;
import View.MenuDriver.DriverScreen;
import Controller.CustomerManager;
import Controller.DatabaseControl;
import Controller.UserManager;
import Model.Customers;
import Model.Driver;
import View.ScreenLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Member;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class MenuProfile {
    private JLabel labelNama, labelUsername, labelAlamat, labelSaldoOvo, labelIsiNama, labelIsiUsername, labelIsiAlamat, labelIsiSaldo;
    private JButton buttonBack, buttonLogout;
    JFrame frame = new JFrame("My Profile");
    public MenuProfile(){
        frame.setSize(450, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        labelNama = new JLabel("Nama");
        labelUsername = new JLabel("Username");
        labelAlamat = new JLabel("Alamat");
        labelSaldoOvo = new JLabel("Saldo Ovo");
        
        buttonBack = new JButton("Back");
        buttonLogout = new JButton("Logout");
        
        labelIsiNama = new JLabel(UserManager.getInstance().getUser().getNama());
        labelIsiUsername = new JLabel(UserManager.getInstance().getUser().getUsername());
        labelIsiAlamat = new JLabel(CustomerManager.getInstance().getCustomer().getAlamat());
        labelIsiSaldo = new JLabel("Rp. " + CustomerManager.getInstance().getCustomer().getSaldoovo());
        
        labelNama.setBounds(50, 10, 100, 20);
        labelUsername.setBounds(50, 40, 100, 20);
        labelAlamat.setBounds(50, 70, 100, 20);
        labelSaldoOvo.setBounds(50, 100, 100, 20);
        
        labelIsiNama.setBounds(120, 10, 200, 20);
        labelIsiUsername.setBounds(120, 40, 200, 20);
        labelIsiAlamat.setBounds(120, 70, 200, 20);
        labelIsiSaldo.setBounds(120, 100, 200, 20);
        
        buttonBack.setBounds(100, 180, 100, 20);
        buttonLogout.setBounds(210, 180, 100, 20);
        
        buttonLogout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jawab = JOptionPane.showConfirmDialog(null, "Yakin ingin Logout?");
                switch(jawab){
                    case JOptionPane.YES_OPTION:
                        DatabaseControl ctrl = new DatabaseControl();
                        ctrl.updateCustomer(CustomerManager.getInstance().getCustomer());
                        
                        JOptionPane.showMessageDialog(null, "Terima kasih terlah menggunakan aplikasi ini!");
                        frame.setVisible(false);
                        UserManager.getInstance().setUser(null);
                        new ScreenLogin();
                }
            }
        });
        buttonBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new CustomerScreen();
            }
        });
        
        frame.add(labelNama);
        frame.add(labelUsername);
        frame.add(labelAlamat);
        frame.add(labelSaldoOvo);
        frame.add(labelIsiNama);
        frame.add(labelIsiUsername);
        frame.add(labelIsiSaldo);
        frame.add(buttonBack);
        frame.add(buttonLogout);
        frame.add(labelIsiAlamat);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
