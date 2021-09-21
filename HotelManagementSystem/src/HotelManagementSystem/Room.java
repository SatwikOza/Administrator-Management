package HotelManagementSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener {
	
	JTable t1;
	JButton b1,b2;
	
	Room(){
		
		t1=new JTable();
		t1.setBounds(0, 40, 500, 400);
		add(t1);
		
		JLabel l1=new JLabel("Room Number");
		l1.setBounds(10, 10, 100, 20);
		add(l1);
		
		JLabel l2=new JLabel("Availability");
		l2.setBounds(120, 10, 80, 20);
		add(l2);
		
		JLabel l3=new JLabel("Status");
		l3.setBounds(230, 10, 80, 20);
		add(l3);
		
		JLabel l4=new JLabel("Price");
		l4.setBounds(330, 10, 60, 20);
		add(l4);
		
		JLabel l5=new JLabel("Bed Type");
		l5.setBounds(410, 10, 100, 20);
		add(l5);

		
		b1=new JButton("Load Data");
		b1.setBounds(100, 460, 120, 30);
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(250, 460, 120, 30);
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		add(b2);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/eight.jpg"));
		Image i2=i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l6=new JLabel(i3);
		l6.setBounds(500, 0, 500, 600);
		add(l6);
		
		setLayout(null);
		setBounds(270, 170, 1050, 600);
		setVisible(true);
		
		getContentPane().setBackground(Color.white);
		
		
		
	}

	public static void main(String[] args) {
		new Room().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b1) {
			
			try {
				conn c=new conn();
				String str="select * from room";
				ResultSet rs=c.s.executeQuery(str);
				
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception ae) {
				
			}
			
		}else if(e.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}
		
}

