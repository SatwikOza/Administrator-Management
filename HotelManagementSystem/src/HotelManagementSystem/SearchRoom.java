package HotelManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener {
	
	JComboBox c1;
	JCheckBox c2;
	JButton b1,b2;
	JTable t1;
		
	SearchRoom() {
		
		JLabel l1=new JLabel("Search For Room");
		l1.setBounds(300, 30, 200, 20);
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel l2=new JLabel("Room bad Type");
		l2.setBounds(50, 100, 100, 20);
		l2.setFont(new Font("Tahoma",Font.PLAIN,20));
		l2.setForeground(Color.BLUE);
		add(l2);
		
		c1=new JComboBox(new String[] {"Single Bed","Double Bed"});
		c1.setBounds(150, 100, 150, 20);
		c1.setBackground(Color.white);
		add(c1);
		
		c2=new JCheckBox("Only Display Available");
		c2.setBounds(650, 100, 150, 25);
		c2.setBackground(Color.white);
		add(c2);
		
		t1=new JTable();
		t1.setBounds(0, 200, 1000, 300);
		add(t1);
		
		JLabel l11=new JLabel("Room Number");
		l11.setBounds(50, 160, 100, 20);
		add(l11);
		
		JLabel l22=new JLabel("Availability");
		l22.setBounds(250, 160, 100, 20);
		add(l22);
		
		JLabel l3=new JLabel("Cleaning Status");
		l3.setBounds(450, 160, 100, 20);
		add(l3);
		
		JLabel l4=new JLabel("Price");
		l4.setBounds(685, 160, 100, 20);
		add(l4);
		
		JLabel l5=new JLabel("Bed Type");
		l5.setBounds(850, 160, 100, 20);
		add(l5);
		
		
		b1=new JButton("Submit");
		b1.setBounds(300, 520, 120,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(500, 520, 120,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		getContentPane().setBackground(Color.WHITE);
		
		
		setLayout(null);
		setBounds(500,200,1000,650);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new SearchRoom().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
			ResultSet rs;
			try {
				String str="select * from room where bed_type='"+c1.getSelectedItem()+"'";
				String str1="select * from room where available='Available' and bed_type='"+c1.getSelectedItem()+"'";
				conn c=new conn();
				
				if(c2.isSelected()) {
				rs=c.s.executeQuery(str1);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				}
				else {
				
					rs=c.s.executeQuery(str);
					t1.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
			}catch(Exception ae) {
				System.out.println(ae);
			}
		}else if(e.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
			
		}
		
	}

}
