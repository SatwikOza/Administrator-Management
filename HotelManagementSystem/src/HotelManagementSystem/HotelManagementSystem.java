package HotelManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class HotelManagementSystem extends JFrame implements ActionListener{
        
    
    
    HotelManagementSystem(){
        setBounds(0,75,1366,565);
        //setSize(400,400);
        
        //setLocation(500,500);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/first.jpg"));
        JLabel II=new JLabel(i1);
        II.setBounds(0,0,1366,565);
        add(II);
        JLabel i2=new JLabel("HOTEL MANAGEMENT SYSTEM");
        i2.setBounds(20,430,1000,90);
        i2.setForeground(Color.white);
        i2.setFont(new Font("serif",Font.PLAIN,50));
        
        II.add(i2);
        
        JButton b1=new JButton("NEXT");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setBounds(1070,450,150,50);
        b1.addActionListener(this);
        II.add(b1);
        
        
        
        setLayout(null);
        setVisible(true);
        
        while(true){
            i2.setVisible(false);
            try{
                Thread.sleep(500);
                
            }catch(Exception e){
                
            }
            i2.setVisible(true);
            try{
                Thread.sleep(500);
                
            }catch(Exception e){
                
            }
            
            
        }
        
        
        
    }

    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }

    
}
