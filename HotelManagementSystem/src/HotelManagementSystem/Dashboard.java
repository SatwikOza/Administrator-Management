package HotelManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements ActionListener{
	
	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4;
	
	Dashboard(){
		mb = new JMenuBar();
		add(mb);
	
		m1=new JMenu("HOTEL MANAGEMENT");
		m1.setForeground(Color.red);
		mb.add(m1);
		
		
		m2=new JMenu("ADMIN");
		m2.setForeground(Color.BLUE);
		mb.add(m2);
		
		i1=new JMenuItem("RECEPTION");
		i1.addActionListener(this);
		m1.add(i1);
		i2=new JMenuItem("ADD EMPLOYEE");
		i2.addActionListener(this);
		m2.add(i2);
		i3=new JMenuItem("ADD ROOMS");
		i3.addActionListener(this);
		m2.add(i3);
		i4=new JMenuItem("ADD DRIVERS");
		i4.addActionListener(this);
		m2.add(i4);
		
		mb.setBounds(0,0,1920,30);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/third.jpg"));
		Image i2=i1.getImage().getScaledInstance(1920, 850, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l1=new JLabel(i3);
		l1.setBounds(0, 0, 1920, 850);
		setLayout(null);
		add(l1);
		
		JLabel l2=new JLabel("THE OZA GROUP WELCOMES YOU");
		l2.setForeground(Color.WHITE);
		l2.setBounds(450, 60, 1000, 50);
		l2.setFont(new Font("Tahoma",Font.PLAIN,46));
		l1.add(l2);
		
		
		setBounds(0,0,1920,850);
		setVisible(true);
		
		
	}
	
	
	

	public static void main(String[] args) {
		new Dashboard().setVisible(true);

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("RECEPTION")) {
			new Reception().setVisible(true);
		}else if(e.getActionCommand().equals("ADD EMPLOYEE")) {
			new AddEmployee().setVisible(true);
		}else if(e.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms().setVisible(true);
		}else if(e.getActionCommand().equals("ADD DRIVERS")) {
			new AddDrivers().setVisible(true);
		}
		
	}

}
