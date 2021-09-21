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

public class Department extends JFrame implements ActionListener {
	
	
	JButton b1,b2;
	JTable t1;
		
	Department() {
		
		
		
		t1=new JTable();
		t1.setBounds(80, 50, 500, 300);
		add(t1);
		
		JLabel l11=new JLabel("Department");
		l11.setBounds(180, 10, 100, 20);
		add(l11);
		
		JLabel l22=new JLabel("Budget");
		l22.setBounds(440, 10, 100, 20);
		add(l22);
		
		b1=new JButton("Submit");
		b1.setBounds(180, 400, 120,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(380, 400, 120,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		getContentPane().setBackground(Color.WHITE);
		
		
		setLayout(null);
		setBounds(400,200,700,550);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Department().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
			
			try {
				String str="select * from department";
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
