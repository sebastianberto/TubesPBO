/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author yudistira
 */
public class TopupScreen {
    
    public TopupScreen() {
        JFrame frame = new JFrame();
        frame.setSize(500, 700);
        frame.setLocationRelativeTo(null);

        //Component: Button
        JButton button, button1, button2, button3, button4;
        button = new JButton("left");
        button1 = new JButton("right");
        button2 = new JButton("top");
        button3 = new JButton("bottom");
        button4 = new JButton("center");
        JButton button5 = new JButton("blabla");
        
        JLabel label4 = new JLabel();
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(button1.getText());
            }
        });
                
        // Border Layout
        frame.add(button, BorderLayout.WEST);
        frame.add(button1, BorderLayout.EAST);
        frame.add(button2, BorderLayout.NORTH);
        frame.add(button3, BorderLayout.SOUTH);
        frame.add(button4, BorderLayout.CENTER);
        
        frame.setVisible(true);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
