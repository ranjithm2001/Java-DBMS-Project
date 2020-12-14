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
	JLabel acc_label,name_label,address_label,phone_label,user_label,pass_label,conpas_label;
	JTextField acc_text,name_text,address_text,user_text,phone_text,pass_text,conpas_text;
	JButton submit_button,clr_button;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	insert1()
	{
		submit_button=new JButton("Submit");
		submit_button.setBackground(new Color(248, 248, 255));
		clr_button=new JButton("Clear");
		clr_button.setBackground(new Color(248, 248, 255));
        frame.setResizable(false);
        frame.setSize(289,512);
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
        acc_label=new JLabel("Account No");
        acc_label.setFont(new Font("Arial", Font.PLAIN, 12));
		name_label=new JLabel("Name");
		name_label.setFont(new Font("Arial", Font.PLAIN, 12));
		address_label=new JLabel("Address");
		address_label.setFont(new Font("Arial", Font.PLAIN, 12));
		phone_label=new JLabel("Phone No");
		phone_label.setFont(new Font("Arial", Font.PLAIN, 12));
		user_label=new JLabel("Username");
		user_label.setFont(new Font("Arial", Font.PLAIN, 12));
		pass_label=new JLabel("Password");
		pass_label.setFont(new Font("Arial", Font.PLAIN, 12));
		conpas_label=new JLabel("Confirm Password");
		conpas_label.setFont(new Font("Arial", Font.PLAIN, 12));
		acc_text=new JTextField(20);
		name_text=new JTextField(20);
		address_text=new JTextField(20);
		phone_text=new JTextField(20);
		user_text=new JTextField(20);
		pass_text=new JTextField(20);
		conpas_text=new JTextField(20);
		lblNewLabel = new JLabel("Personal Information");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(50, 11, 164, 30);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Username & Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(50, 199, 166, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		frame.getContentPane().add(acc_label);
		frame.getContentPane().add(acc_text);
		frame.getContentPane().add(name_label);
		frame.getContentPane().add(name_text);
		frame.getContentPane().add(address_label);
		frame.getContentPane().add(address_text);
		frame.getContentPane().add(phone_label);
		frame.getContentPane().add(phone_text);
		frame.getContentPane().add(user_label);
		frame.getContentPane().add(user_text);
		frame.getContentPane().add(pass_label);
		frame.getContentPane().add(pass_text);
		frame.getContentPane().add(conpas_label);
		frame.getContentPane().add(conpas_text);
		frame.getContentPane().add(submit_button);
		frame.getContentPane().add(clr_button);
		
		acc_label.setBounds(30,60,82,20);
		acc_text.setBounds(130,60,100,20);
		name_label.setBounds(50,91,62,20);
		name_text.setBounds(130,91,100,20);
		address_label.setBounds(40,121,72,20);
		address_text.setBounds(130,121,100,20);
		phone_label.setBounds(30,153,82,20);
		phone_text.setBounds(130,151,100,20);
		user_label.setBounds(30,240,72,20);
		user_text.setBounds(130,240,100,20);
		pass_label.setBounds(30,271,72,20);
		pass_text.setBounds(130,270,100,20);
		conpas_label.setBounds(10,300,120,20);
		conpas_text.setBounds(130,300,100,20);
		submit_button.setBounds(84,350,100,30);
		submit_button.addActionListener(this);
		clr_button.setBounds(84,397,100,30);
		clr_button.setBackground(new Color(248, 248, 255));
		submit_button.setBackground(new Color(248, 248, 255));
		
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
