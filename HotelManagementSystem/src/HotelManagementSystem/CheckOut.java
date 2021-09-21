package HotelManagementSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckOut extends JFrame implements ActionListener{
	
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3;
	Choice c1;
	
	
	CheckOut(){
		
		JLabel l1=new JLabel("Check Out");
		l1.setBounds(100, 20, 280, 30);
		l1.setFont(new Font("Tahoma",Font.BOLD,25));
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel l2=new JLabel("Customer-ID");
		l2.setBounds(30, 90, 150, 20);
		add(l2);
		
		c1=new Choice();
		try {
			conn c=new conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
            c1.setBounds(200, 90, 150, 20);
            add(c1);
			
		}catch(Exception ae) {
			
		}
		
		JLabel l3=new JLabel("Room Number");
		l3.setBounds(30, 120, 100, 20);
		add(l3);
		
		t1=new JTextField();
		t1.setBounds(200, 120, 150, 20);
		add(t1);
		
		
		b1=new JButton("Checkout");
		b1.setBounds(30, 200, 120,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(170, 200, 120,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/tick.png"));
		Image i2=i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		b3=new JButton(i3);
		b3.setBounds(350, 90, 20, 20);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("images/sixth.jpg"));
		Image i12=i11.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
		ImageIcon i13=new ImageIcon(i12);
		JLabel l14=new JLabel(i13);
		l14.setBounds(380, 5, 400, 250);
		add(l14);
		
		
		getContentPane().setBackground(Color.WHITE);
		
		
		
	
		setLayout(null);
		setBounds(480, 200, 800, 300);
		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		new CheckOut().setVisible(true);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
			
			String id=c1.getSelectedItem();
			String room=t1.getText();
			String str="delete from customer where number='"+id+"'";
			String str1="update room set available='Available' where room_number='"+room+"'";
			conn c=new conn();
			try {
				c.s.executeUpdate(str);
				c.s.executeUpdate(str1);
				JOptionPane.showMessageDialog(null, "Checkout Done");
				new Reception().setVisible(true);
				this.setVisible(false);
			}catch(Exception ae) {}
			
			
		}else if(e.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}else if(e.getSource()==b3) {
			conn c=new conn();
			String id=c1.getSelectedItem();
			try {
			ResultSet rs=c.s.executeQuery("select * from customer where number ='"+id+"'");
			while(rs.next()) {
				t1.setText(rs.getString("room"));
			}
			}catch(Exception ae){
				
				}
			}
		}
		
	

}
