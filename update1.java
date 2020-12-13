package demoDB;
import demoDB.Login;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class update1 implements ActionListener
{
	JFrame frame = new JFrame("update");
	JLabel acc_label,name_label, address_label, phone_label,user_label,pass_label;  
    JTextField acc_text,name_text,address_text,phone_text,user_text,pass_text;
    String s,s1,s2,s3,s4;
    JButton button,update_button;
	update1()
	{
		acc_label = new JLabel("Enter AccountNo :");  
        acc_label.setBounds(20, 30, 150, 20);
        acc_text = new JTextField(20);  
        acc_text.setBounds(130, 30, 200, 20);
        button=new JButton("Submit");
		button.setBounds(130,60,100,30);
		button.addActionListener(this);
		name_label = new JLabel("Name :");  
        name_label.setBounds(20, 90, 100, 20);  
        name_text = new JTextField(50);
        name_text.setBounds(130, 90, 200, 20);
        address_label = new JLabel("Address :");  
        address_label.setBounds(20, 120, 100, 20);  
        address_text = new JTextField(50);  
        address_text.setBounds(130, 120, 200, 20);
        phone_label = new JLabel("Phone No :");  
        phone_label.setBounds(20, 150, 100, 20);  
        phone_text = new JTextField(50);  
        phone_text.setBounds(130, 150, 200, 20);
        user_label = new JLabel("Username :");  
        user_label.setBounds(20, 180, 100, 20);  
        user_text = new JTextField(50);  
        user_text.setBounds(130, 180, 200, 20);
        pass_label = new JLabel("Password :");  
        pass_label.setBounds(20, 210, 100, 20);  
        pass_text = new JTextField(50);  
        pass_text.setBounds(130, 210, 200, 20);
        update_button=new JButton("Update");
		update_button.setBounds(130,240,100,30);
		update_button.addActionListener(this);
        frame.getContentPane().setBackground(Color.cyan);
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.add(acc_label);
        frame.add(acc_text);
        frame.add(button);
        frame.add(name_label);  
        frame.add(name_text);
        frame.add(address_label);  
        frame.add(address_text);
        frame.add(phone_label);
        frame.add(phone_text);
        frame.add(user_label);
        frame.add(user_text);
        frame.add(pass_label);
        frame.add(pass_text);
        frame.add(update_button);
        acc_text.setEditable(true);
        name_text.setEditable(true);  
        address_text.setEditable(true); 
        phone_text.setEditable(true);
        user_text.setEditable(false);
        pass_text.setEditable(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==button)
		{
			try
			{
				String str1 =acc_text.getText();
	            Class.forName("org.postgresql.Driver");  
	            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/project","postgres", "postgres");  
	            PreparedStatement st = con.prepareStatement("select * from tax_payer where account_no=?");
	            st.setString(1,str1);
	            ResultSet rs = st.executeQuery();
	            if (rs.next())
	            {
	            	s  = rs.getString(2);  
	                s1 = rs.getString(3);  
	                s2 = rs.getString(4);  
	                s3 = rs.getString(5);
	                s4 = rs.getString(6);
	                name_text.setText(s);
	                address_text.setText(s1);
	                phone_text.setText(s2);
	                user_text.setText(s3);
	                pass_text.setText(s4);
	            }
			}
			catch(Exception z)
			{
				System.out.println(z.getMessage());
			}
		}
		if(e.getSource()==update_button)
		{
			try
			{
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/project","postgres", "postgres");  
				PreparedStatement st1 = con.prepareStatement("update tax_payer set name=?,address=?,phone_no=? where account_no=?");
	            st1.setString(1,name_text.getText());
	            st1.setString(2,address_text.getText());
	            st1.setString(3,phone_text.getText());
	            st1.setString(4,acc_text.getText());
	            st1.executeQuery();
			}
			catch(Exception z)
			{
				System.out.println(z.getMessage());
			}
			JOptionPane.showMessageDialog(null,"Updated Successfully");
		}
	}
	public static void main(String ag[]) 
	{
		update1 u1 = new update1();
	}
}