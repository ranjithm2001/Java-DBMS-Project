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
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;
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
		acc_label.setFont(new Font("Arial", Font.PLAIN, 12));
		acc_label.setBounds(20, 30, 116, 20);
        acc_text = new JTextField(20);
        acc_text.setBounds(146, 30, 200, 20);
        button=new JButton("Submit");
        button.setBackground(new Color(248, 248, 255));
        button.setBounds(202, 66, 91, 30);
		button.addActionListener(this);
		button.setBackground(new Color(248, 248, 255));
        frame.getContentPane().setBackground(new Color(240, 248, 255));
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setSize(455,422);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(acc_label);
        frame.getContentPane().add(acc_text);
        frame.getContentPane().add(button);
        acc_text.setEditable(true);
        update_button=new JButton("Update");
        update_button.setBackground(new Color(248, 248, 255));
        update_button.setBounds(202, 292, 91, 30);
        update_button.addActionListener(this);
        name_label = new JLabel("Name :");
        name_label.setFont(new Font("Arial", Font.PLAIN, 12));
        name_label.setBounds(20, 122, 100, 20);
        frame.getContentPane().add(name_label);  
        name_text = new JTextField(50);
        name_text.setBounds(146, 122, 200, 20);
        frame.getContentPane().add(name_text);
        name_text.setEditable(true);  
        address_label = new JLabel("Address :");
        address_label.setFont(new Font("Arial", Font.PLAIN, 12));
        address_label.setBounds(20, 153, 100, 20);
        frame.getContentPane().add(address_label);  
        address_text = new JTextField(50);
        address_text.setBounds(146, 153, 200, 20);
        frame.getContentPane().add(address_text);
        address_text.setEditable(true); 
        phone_label = new JLabel("Phone No :");
        phone_label.setFont(new Font("Arial", Font.PLAIN, 12));
        phone_label.setBounds(20, 184, 100, 20);
        frame.getContentPane().add(phone_label);
        phone_text = new JTextField(50);
        phone_text.setBounds(146, 184, 200, 20);
        frame.getContentPane().add(phone_text);
        phone_text.setEditable(true);
        user_label = new JLabel("Username :");
        user_label.setFont(new Font("Arial", Font.PLAIN, 12));
        user_label.setBounds(20, 215, 100, 20);
        frame.getContentPane().add(user_label);
        user_text = new JTextField(50);
        user_text.setBounds(146, 215, 200, 20);
        frame.getContentPane().add(user_text);
        user_text.setEditable(false);
        pass_label = new JLabel("Password :");
        pass_label.setFont(new Font("Arial", Font.PLAIN, 12));
        pass_label.setBounds(20, 246, 100, 30);
        frame.getContentPane().add(pass_label);
        pass_text = new JTextField(50);
        pass_text.setBounds(146, 251, 200, 20);
        frame.getContentPane().add(pass_text);
        pass_text.setEditable(true);
        frame.getContentPane().add(update_button);
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