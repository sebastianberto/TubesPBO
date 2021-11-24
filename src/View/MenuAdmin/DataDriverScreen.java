/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.MenuAdmin;
import Model.Driver;
import Model.User;
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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author Asus
 */
public class DataDriverScreen{
    private JFrame framedata = new JFrame();
    private JTable tabeldata;
    private JButton backbutton;
    private JScrollPane sp;
    private ArrayList<User> listUser = new ArrayList<>();
    
    public DataDriverScreen() {
        framedata.setSize(600,400);
        framedata.setLocationRelativeTo(null);
        framedata.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DatabaseControl ctrl = new DatabaseControl();
        
        listUser = ctrl.getAllDriverUser();
        int baris = listUser.size();
        int kolom = 7;
        String data[][] = new String[baris][kolom];
        
        for(int i = 0 ; i < listUser.size(); i++){
            data[i][0] = Integer.toString(listUser.get(i).getId_User());
            data[i][1] = listUser.get(i).getNama();
            data[i][2] = listUser.get(i).getUsername();
            data[i][3] = listUser.get(i).getPassword();
            data[i][4] = listUser.get(i).getEmail();
            data[i][5] = listUser.get(i).getTanggallahir();
            data[i][6] = listUser.get(i).getNoHp();
        }
        String tabelkolom[] = {"ID","Nama","Username","Password","Email","Tangggal Lahir","No Hp"};
        tabeldata = new JTable(data,tabelkolom);
        tabeldata.setCellSelectionEnabled(true);
        ListSelectionModel select = tabeldata.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                int[] baris = tabeldata.getSelectedRows();
                int kolom = 0;
                int id = 0;
                User user = new User();
                for(int i = 0; i < baris.length; i++){
                    id = Integer.parseInt((String) tabeldata.getValueAt(baris[i], kolom));
                }
                for(int i = 0; i < listUser.size(); i++){
                    if(id == listUser.get(i).getId_User()){
                        user = listUser.get(i);
                    }
                }
                framedata.setVisible(false);
                new DetailDataDriverScreen(user);
            }
        });
        
        sp = new JScrollPane(tabeldata);
        
        framedata.add(sp);
        //framedata.add(backbutton);
        framedata.setVisible(true);
    }
}
