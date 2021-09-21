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

public class UpdateRoom extends JFrame implements ActionListener {
	
	Choice c1;
	JTextField t1,t2,t3;
	JButton b1,b2,b3;
	
	UpdateRoom() {
		
		JLabel l1=new JLabel("Update Room Status");
		l1.setBounds(50, 20, 280, 30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,25));
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel l2=new JLabel("Guest ID");
		l2.setBounds(30, 80, 120, 20);
		add(l2);
		
		c1=new Choice();
		try {
			conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
			
		}catch(Exception ae) {
			
			
		}
		c1.setBounds(200, 80, 150, 25);
		add(c1);
		
		JLabel l3=new JLabel("Room Number");
		l3.setBounds(30, 130, 120, 20);
		add(l3);
		
		t1=new JTextField();
		t1.setBounds(200, 130, 150, 25);
		add(t1);
		
		JLabel l4=new JLabel("Availability");
		l4.setBounds(30, 180, 120, 20);
		add(l4);
		
		t2=new JTextField();
		t2.setBounds(200, 180, 150, 25);
		add(t2);
		
		JLabel l5=new JLabel("Clean Status");
		l5.setBounds(30, 230, 120, 20);
		add(l5);
		
		t3=new JTextField();
		t3.setBounds(200, 230, 150, 25);
		add(t3);
		
		b1=new JButton("Check");
		b1.setBounds(130, 300, 120,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Update");
		b2.setBounds(40, 350, 120,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		b3=new JButton("Back");
		b3.setBounds(220, 350, 120,30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/seventh.jpg"));
		Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l10=new JLabel(i3);
		l10.setBounds(400, 40, 500, 400);
		add(l10);
		
		getContentPane().setBackground(Color.WHITE);
		
		
		setLayout(null);
		setBounds(500, 200, 950, 450);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new UpdateRoom().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			
			String s1 = c1.getSelectedItem();
			String room=null;
			conn c = new conn();
			try {
				ResultSet rs = c.s.executeQuery("select * from customer where number = '"+s1+"'");           
				while(rs.next()) {
	            	t1.setText(rs.getString("room"));
	            	room=rs.getString("room");
	            }
				ResultSet rs1 = c.s.executeQuery("select * from room where room_number = '"+room+"'");           
				while(rs1.next()) {
	            	t2.setText(rs1.getString("available"));
	            	t3.setText(rs1.getString("status"));
	            	
	            }

			}catch(Exception ae) {
				System.out.println(ae);
			}
           }else if(e.getSource()==b2) {
        	   
        	   try {
        		   conn c=new conn();
        		   String room=t1.getText();
        		   String available=t2.getText();
        		   String status=t3.getText();
        		   
        		   String str="update room set available='"+available+"',status='"+status+"' where room_number ='"+room+"'";
        		   c.s.executeUpdate(str);
        		   JOptionPane.showMessageDialog(null, "Room Updated Successfully");
   					new UpdateRoom().setVisible(true);
   					this.setVisible(false);
        	   		}catch(Exception ae) {
        		   
        	   }
			
		}else if(e.getSource()==b3) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}

}
