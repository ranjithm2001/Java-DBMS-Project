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
import java.awt.Canvas;
import java.awt.Label;
import java.awt.Panel;
public class Login implements ActionListener {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	JFrame frame =new JFrame("Log In");
	JLabel username_label,pass_label;
	JTextField username_textfield;
	JButton log_button,reg_button,clr_button;
	JPasswordField pass_textfield;
	String pass,pwd;
	private Canvas canvas;
	private Label label;
	Login()
	{
		username_label=new JLabel("UserName");
		username_label.setFont(new Font("Arial", Font.PLAIN, 12));
		pass_label=new JLabel("Password");
		pass_label.setFont(new Font("Arial", Font.PLAIN, 12));
		username_textfield=new JTextField(20);
		pass_textfield = new JPasswordField();
		log_button=new JButton("Login");
		log_button.setBackground(new Color(248, 248, 255));
		log_button.setFont(new Font("Arial", Font.PLAIN, 12));
		reg_button=new JButton("Create an Account");
		reg_button.setBackground(new Color(248, 248, 255));
		reg_button.setFont(new Font("Arial", Font.PLAIN, 13));
		clr_button=new JButton("Clear");
		clr_button.setBackground(new Color(248, 248, 255));
		clr_button.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.setResizable(false);
		frame.setBackground(new Color(240, 248, 255));
		frame.setSize(471,281);
		frame.getContentPane().setBackground(new Color(72, 209, 204));
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().add(username_label);
		frame.getContentPane().add(username_textfield);
		frame.getContentPane().add(pass_label);
		frame.getContentPane().add(pass_textfield);
		frame.getContentPane().add(log_button);
		frame.getContentPane().add(clr_button);
		frame.getContentPane().add(reg_button);
		username_label.setBounds(25,92,100,20);
		username_textfield.setBounds(110,92,100,20);
		pass_label.setBounds(25,123,100,20);
		pass_textfield.setBounds(110,123,100,20);
		log_button.setBounds(25,188,78,30);
		log_button.addActionListener(this);
		clr_button.setBounds(122,188,78,30);
		clr_button.addActionListener(this);
		reg_button.setBounds(267,123,159,35);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome Back!");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(62, 21, 122, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		label = new Label("New Here?");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setBackground(new Color(119, 136, 153));
		label.setBounds(303, 65, 123, 36);
		frame.getContentPane().add(label);
		
		canvas = new Canvas();
		canvas.setBackground(new Color(119, 136, 153));
		canvas.setEnabled(false);
		canvas.setBounds(230, 0, 237, 254);
		frame.getContentPane().add(canvas);
		reg_button.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		pwd = new String(pass_textfield.getPassword());
		if(e.getSource()==reg_button)
		{
			frame.dispose();
			insert1 r=new insert1();
		}
		else if(e.getSource()==log_button)
		{
			if (username_textfield.getText().equals("") || pwd.equals("")) {
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
		        if(pass.equals(pwd))
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
