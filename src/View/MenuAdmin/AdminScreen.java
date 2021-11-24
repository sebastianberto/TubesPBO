/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.MenuAdmin;
import View.MenuAdmin.DataDriverScreen;
import View.ScreenLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
/**
 *
 * @author Asus
 */
public class AdminScreen extends JFrame implements ActionListener{
    private JFrame frame;
    private JLabel labeljudul;
    private JButton datadriverbutton,logoutbutton;

    public AdminScreen() {
        frame = new JFrame("Login");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        labeljudul = new JLabel("Silahkan Pilih ");
        labeljudul.setBounds(160, 10, 200, 30);
        
        datadriverbutton = new JButton("Lihat Data Driver");
        datadriverbutton.setBounds(100, 50, 200, 30);
        datadriverbutton.addActionListener(this);
        
        logoutbutton = new JButton("Logout");
        logoutbutton.setBounds(100, 100, 200, 30);
        logoutbutton.addActionListener(this);
        
        frame.add(labeljudul);
        frame.add(datadriverbutton);
        frame.add(logoutbutton);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case"Lihat Data Driver":
               frame.setVisible(false);
               new DataDriverScreen();
            break;
            case"Logout":
                frame.setVisible(false);
                new ScreenLogin();
                break;
            default:
                break;
        }
    }
}
