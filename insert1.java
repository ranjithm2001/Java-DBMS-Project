package demoDB;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class insert1 implements ActionListener
{
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	JFrame frame = new JFrame("info");
	JLabel msg_label,info1_label,acc_label,name_label,address_label,phone_label,user_label,pass_label,conpas_label;
	JTextField acc_text,name_text,address_text,user_text,phone_text,pass_text,conpas_text;
	JButton submit_button,clr_button;
	insert1()
	{
		submit_button=new JButton("Submit");
		clr_button=new JButton("Clear");
		msg_label = new JLabel("Username & Password");  
        msg_label.setBounds(20,10, 450, 30);  
        msg_label.setForeground(Color.black);  
        msg_label.setFont(new Font("sans-serif", Font.BOLD, 18));
		info1_label = new JLabel("Personal Information");  
        info1_label.setBounds(20,190, 450, 30);  
        info1_label.setForeground(Color.black);  
        info1_label.setFont(new Font("sans-serif", Font.BOLD, 18));
        frame.setSize(250,410);
		frame.getContentPane().setBackground(Color.cyan);
		frame.setVisible(true);
		frame.setLayout(null);
        acc_label=new JLabel("Account No");
		name_label=new JLabel("Name");
		address_label=new JLabel("Address");
		phone_label=new JLabel("Phone No");
		user_label=new JLabel("Username");
		pass_label=new JLabel("Password");
		conpas_label=new JLabel("Confirm Password");
		acc_text=new JTextField(20);
		name_text=new JTextField(20);
		address_text=new JTextField(20);
		phone_text=new JTextField(20);
		user_text=new JTextField(20);
		pass_text=new JTextField(20);
		conpas_text=new JTextField(20);
		frame.add(info1_label);
		frame.add(acc_label);
		frame.add(acc_text);
		frame.add(name_label);
		frame.add(name_text);
		frame.add(address_label);
		frame.add(address_text);
		frame.add(phone_label);
		frame.add(phone_text);
		frame.add(msg_label);
		frame.add(user_label);
		frame.add(user_text);
		frame.add(pass_label);
		frame.add(pass_text);
		frame.add(conpas_label);
		frame.add(conpas_text);
		frame.add(submit_button);
		frame.add(clr_button);
		acc_label.setBounds(10,60,100,20);
		acc_text.setBounds(100,60,100,20);
		name_label.setBounds(10,90,100,20);
		name_text.setBounds(100,90,100,20);
		address_label.setBounds(10,120,100,20);
		address_text.setBounds(100,120,100,20);
		phone_label.setBounds(10,150,100,20);
		phone_text.setBounds(100,150,100,20);
		user_label.setBounds(10,240,100,20);
		user_text.setBounds(100,240,100,20);
		pass_label.setBounds(10,270,100,20);
		pass_text.setBounds(100,270,100,20);
		conpas_label.setBounds(10,300,120,20);
		conpas_text.setBounds(130,300,100,20);
		submit_button.setBounds(5,330,100,30);
		submit_button.addActionListener(this);
		clr_button.setBounds(115,330,100,30);
		clr_button.addActionListener(this);	
	}
	public void actionPerformed(ActionEvent e) 
	{
		String Account_no = acc_text.getText();
		String name = name_text.getText();
        String address = address_text.getText();
        String phoneNumber = phone_text.getText();
        String username = user_text.getText();
        String password = pass_text.getText();
        String password2 = conpas_text.getText();
		if(e.getSource()==submit_button)
		{
			if(Account_no.equals("") || name.equals("") || address.equals("") || phoneNumber.equals("") || username.equals("") || password.equals("") || password2.equals("") )
	        {
	        	JOptionPane.showMessageDialog(null, "All fields must be complete to submit.", "Woops", JOptionPane.ERROR_MESSAGE);
	            return ;
	        }
	        if(!(password.equals(password2)))
	        {
	                JOptionPane.showMessageDialog(null, "Passwords do not match.", "Woops", JOptionPane.ERROR_MESSAGE);
	                return ;
	        }
			try
			{
				Class.forName("org.postgresql.Driver");  
	            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/project","postgres", "postgres");
	            PreparedStatement st1 = con.prepareStatement("insert into tax_payer values (?,?,?,?,?,?)");  
	            st1.setString(1,Account_no);
	            st1.setString(2,name);
	            st1.setString(3,address);
	            st1.setString(4,phoneNumber);
	            st1.setString(5,username);
	            st1.setString(6,password);
	            st1.executeQuery();
			}
			catch(Exception z)
			{
				System.out.println(z.getMessage());
			}
			JOptionPane.showMessageDialog(null, "Data inserted Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
			frame.dispose();
			insert2 x = new insert2();
		}
		if(e.getSource()==clr_button)
		{
			acc_text.setText("");
			name_text.setText("");
	        address_text.setText("");
	        phone_text.setText("");
	        user_text.setText("");
	        pass_text.setText("");
	        conpas_text.setText("");
		}
        
	}
	public static void main(String ag[]) {
		 insert1 z = new insert1();
	}
}
