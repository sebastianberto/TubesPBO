/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.MenuDriver;
import Controller.DatabaseControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import Model.Pesanan;
import Model.PesananFood;
/**
 *
 * @author Asus
 */
public class RiwayatDriverScreen extends JFrame implements ActionListener{
    private JFrame framedata = new JFrame();
    private JTable tabeldata;
    private JButton backbutton;
    private JScrollPane sp;

    public RiwayatDriverScreen() {
        framedata.setSize(600,400);
        framedata.setLocationRelativeTo(null);
        framedata.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DatabaseControl ctrl = new DatabaseControl();
        //ArrayList<Pesanan> listuser = new ArrayList<>();
        //listuser = ctrl.getUserBasedCatgory(id_pesanan);
        //int baris = listuser.size();
        //int kolom = 3;
        //String data[][] = new String[baris][kolom];
        
        //for(int i = 0 ; i < listuser.size(); i++){
         //   data[i][0] = Integer.toString(listuser.get(i).getId());
        //    data[i][1] = listuser.get(i).getName();
        //    data[i][2] = listuser.get(i).getEmail();
       // }
        String tabelkolom[] = {"ID","NamaPemesan","Alamat jemput","Alamat antar","Jarak","Metode Bayar","Total Harga"};
       // tabeldata = new JTable(data,tabelkolom);
        //tabeldata.setBounds(150,200,400,300);
        
        sp = new JScrollPane(tabeldata);
        
          framedata.add(sp);
        //framedata.add(backbutton);
        framedata.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
