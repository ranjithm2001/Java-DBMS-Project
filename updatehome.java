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
	updatehome()
	{
		frame.getContentPane().setBackground(Color.cyan);
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setSize(500,500); 
		personal_button = new JButton("Personal Information");  
        personal_button.setBounds(100, 30, 180, 50);  
        personal_button.addActionListener(this);
        income_button = new JButton("Income");  
        income_button.setBounds(120, 150, 120, 50);
        income_button.addActionListener(this); 
        investment_button = new JButton("Investment");
        investment_button.setBounds(120, 270, 120, 50);  
        investment_button.addActionListener(this);
        frame.setLayout(null);
        frame.add(personal_button);
        frame.add(income_button);
        frame.add(investment_button);
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