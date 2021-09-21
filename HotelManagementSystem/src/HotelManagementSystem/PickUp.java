package HotelManagementSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class PickUp extends JFrame implements ActionListener {
	
	Choice c1;
	JButton b1,b2;
	JTable t1;
		
	PickUp() {
		
		JLabel l1=new JLabel("Pick-Up Service");
		l1.setBounds(400, 30, 500, 60);
		l1.setFont(new Font("Tahoma",Font.BOLD,30));
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel l2=new JLabel("Type of Car");
		l2.setBounds(50, 100, 150, 40);
		l2.setFont(new Font("Tahoma",Font.PLAIN,20));
		
		add(l2);
		
		c1=new Choice();
		try {
			conn c=new conn();
			ResultSet rs=c.s.executeQuery("select * from driver");
			while(rs.next()) {
				c1.add(rs.getString("brand"));
			}
		}catch(Exception ae) {
			
		}
		c1.setBounds(200, 110, 200, 25);
		add(c1);
		
		
		t1=new JTable();
		t1.setBounds(0, 220, 1000, 300);
		add(t1);
		
		JLabel l11=new JLabel("Name");
		l11.setBounds(50, 180, 100, 20);
		add(l11);
		
		JLabel l22=new JLabel("Age");
		l22.setBounds(200, 180, 100, 20);
		add(l22);
		
		JLabel l3=new JLabel("Gender");
		l3.setBounds(330, 180, 100, 20);
		add(l3);
		
		JLabel l4=new JLabel("Company");
		l4.setBounds(460, 180, 100, 20);
		add(l4);
		
		JLabel l5=new JLabel("Brand");
		l5.setBounds(630, 180, 100, 20);
		add(l5);
		
		JLabel l6=new JLabel("Available");
		l6.setBounds(760, 180, 100, 20);
		add(l6);
		
		JLabel l7=new JLabel("Location");
		l7.setBounds(890, 180, 100, 20);
		add(l7);
		
		
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
		new PickUp().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
			
			try {
				String str="select * from driver where brand='"+c1.getSelectedItem()+"'";
				conn c=new conn();
				ResultSet rs=c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
					
				
			}catch(Exception ae) {
				System.out.println(ae);
			}
		}else if(e.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
			
		}
		
	}

}
