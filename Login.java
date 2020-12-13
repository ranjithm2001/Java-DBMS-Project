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
public class Login implements ActionListener {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	JFrame frame =new JFrame("Log In");
	JLabel username_label,pass_label,newreg_label;
	JTextField username_textfield,pass_textfield;
	JButton log_button,reg_button,clr_button;
	String pass;
	Login()
	{
		username_label=new JLabel("UserName");
		pass_label=new JLabel("Password");
		username_textfield=new JTextField(20);
		pass_textfield=new JTextField(20);
		log_button=new JButton("Login");
		reg_button=new JButton("Register");
		clr_button=new JButton("Clear");
		newreg_label = new JLabel("Register Here");
		newreg_label.setBounds(60,160, 200, 30);  
        newreg_label.setForeground(Color.black);  
        newreg_label.setFont(new Font("Serif",Font.PLAIN, 20)); 
		frame.setSize(235,300);
		frame.getContentPane().setBackground(Color.cyan);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.add(username_label);
		frame.add(username_textfield);
		frame.add(pass_label);
		frame.add(pass_textfield);
		frame.getContentPane().add(log_button);
		frame.getContentPane().add(clr_button);
		frame.add(newreg_label);
		frame.getContentPane().add(reg_button);
		username_label.setBounds(10,30,100,20);
		username_textfield.setBounds(110,30,100,20);
		pass_label.setBounds(10,70,100,20);
		pass_textfield.setBounds(110,70,100,20);
		log_button.setBounds(5,120,100,30);
		log_button.addActionListener(this);
		clr_button.setBounds(115,120,100,30);
		clr_button.addActionListener(this);
		reg_button.setBounds(60,200,100,30);
		reg_button.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==reg_button)
		{
			frame.dispose();
			insert1 r=new insert1();
		}
		else if(e.getSource()==log_button)
		{
			if (username_textfield.getText().equals("") || pass_textfield.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Fields cannot be empty");
				return ;
			}
			
			try
			{
		        String str=username_textfield.getText();
		        Class.forName("org.postgresql.Driver");
		        connect = DriverManager.getConnection("jdbc:postgresql://localhost:5433/project","postgres", "postgres");
		        statement = connect.createStatement();
		        PreparedStatement st = connect.prepareStatement("select * from tax_payer where username=?");  
		        st.setString(1, str);
		        resultSet = st.executeQuery();
		        if(resultSet.next())
		        {
		            pass = resultSet.getString(6);
		        }
		        if(pass.equals(pass_textfield.getText()))
		        {
		            JOptionPane.showMessageDialog(null,"Login Successful");
		        }
		        else
		        {
		            JOptionPane.showMessageDialog(null,"Please Check details you have entered");
		            return ;
		        }
			}
			catch (Exception a) 
			{
		        System.out.println(a.getMessage());
		    }
			frame.dispose();
			buttonpage b =new buttonpage();
		}
		else if(e.getSource()==clr_button)
		{
			username_textfield.setText("");
			pass_textfield.setText("");
		}
		}
	public static void main(String ag[]) 
	{
		Login p1 = new Login();
	}
}
