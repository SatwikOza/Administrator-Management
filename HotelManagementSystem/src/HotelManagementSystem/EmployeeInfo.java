package HotelManagementSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class EmployeeInfo extends JFrame implements ActionListener {

	JTable t1;
	JButton b1,b2;
	
	EmployeeInfo() {
		
		t1=new JTable();
		t1.setBounds(0, 40, 1000, 500);
		add(t1);
		
		JLabel l1=new JLabel("Name");
		l1.setBounds(40, 10, 70, 20);
		add(l1);
		
		JLabel l2=new JLabel("Age");
		l2.setBounds(170, 10, 70, 20);
		add(l2);
		
		JLabel l3=new JLabel("Gender");
		l3.setBounds(290, 10, 70, 20);
		add(l3);
		
		JLabel l4=new JLabel("Department");
		l4.setBounds(400, 10, 70, 20);
		add(l4);
		
		JLabel l5=new JLabel("Salary");
		l5.setBounds(540, 10, 70, 20);
		add(l5);
		
		JLabel l6=new JLabel("Phone");
		l6.setBounds(670, 10, 70, 20);
		add(l6);
		
		JLabel l7=new JLabel("Aadahr");
		l7.setBounds(790, 10, 70, 20);
		add(l7);
		
		JLabel l8=new JLabel("email");
		l8.setBounds(910, 10, 70, 20);
		add(l8);
		
		
		
		
		b1=new JButton("Load Data");
		b1.setBounds(350, 560, 120, 30);
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(530, 560, 120, 30);
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		add(b2);
		
		setLayout(null);
		setBounds(300, 150, 1000, 650);
		setVisible(true);
		
		getContentPane().setBackground(Color.white);
		
	}
	
	
	
	public static void main(String[] args) {
		
		new EmployeeInfo().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b1) {
			
			try {
				conn c=new conn();
				String str="select * from employee";
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
