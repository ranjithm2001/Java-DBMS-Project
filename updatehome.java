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
public class updatehome implements ActionListener
{
	JFrame frame = new JFrame("update");
	JButton personal_button,income_button,investment_button;
	private JLabel lblNewLabel;
	updatehome()
	{
		frame.getContentPane().setBackground(new Color(240, 248, 255));
        frame.getContentPane().setFont(new Font("Arial Narrow", Font.BOLD, 14));
        frame.setResizable(false);
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setSize(441,439); 
		personal_button = new JButton("Personal Information");  
		personal_button.setFont(new Font("Arial Narrow", Font.BOLD, 13));
        personal_button.setBounds(131, 117, 147, 42);  
        personal_button.addActionListener(this);
        income_button = new JButton("Income");  
        income_button.setBounds(145, 200, 120, 42);
        income_button.addActionListener(this); 
        investment_button = new JButton("Investment");
        investment_button.setBounds(145, 290, 120, 42);  
        investment_button.addActionListener(this);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(personal_button);
        frame.getContentPane().add(income_button);
        frame.getContentPane().add(investment_button);
        frame.setLocationRelativeTo(null);
        lblNewLabel = new JLabel("Choose the Option");
        lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        lblNewLabel.setBounds(147, 49, 147, 28);
        frame.getContentPane().add(lblNewLabel);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==personal_button)
		{
			frame.dispose();
			update1 u1 =new update1();
		}
		if(e.getSource()==income_button)
		{
			frame.dispose();
		}
		if(e.getSource()==investment_button)
		{
			frame.dispose();
		}
	}
	public static void main(String ag[]) 
	{
		updatehome p1 = new updatehome();
	}
}