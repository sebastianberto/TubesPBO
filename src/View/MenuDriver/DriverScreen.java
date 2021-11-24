/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.MenuDriver;

import View.MenuDriver.DriverProfileScreen;
import View.ScreenLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class DriverScreen extends JFrame implements ActionListener{
    private JFrame frame;
    private JLabel labeljudul;
    private JButton listorderbutton,driverprofilebutton,logoutbutton;
    public DriverScreen() {
        frame = new JFrame("Driver Screen");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        labeljudul = new JLabel("Silahkan Pilih ");
        labeljudul.setBounds(160, 10, 200, 30);
        
        listorderbutton = new JButton("ListOrderan");
        listorderbutton.setBounds(100, 50, 200, 30);
        listorderbutton.addActionListener(this);
        
        driverprofilebutton = new JButton("DriverProfile");
        driverprofilebutton.setBounds(100, 100, 200, 30);
        driverprofilebutton.addActionListener(this);
        
        logoutbutton = new JButton("LogOut");
        logoutbutton.setBounds(100, 150, 200, 30);
        logoutbutton.addActionListener(this);
        
        
        frame.add(labeljudul);
        frame.add(listorderbutton);
        frame.add(driverprofilebutton);
        frame.add(logoutbutton);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case"ListOrderan":
               frame.setVisible(false);
               //new ListOrderanScreen();
            break;
            case"DriverProfile":
                frame.setVisible(false);
                new DriverProfileScreen();
                break;
            case"LogOut":
                frame.setVisible(false);
                new ScreenLogin();
                break;
            default:
                break;
        }
    }
    
}
