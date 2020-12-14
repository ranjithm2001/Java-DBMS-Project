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
public class buttonpage implements ActionListener 
{
	JFrame frame = new JFrame("page");
	JButton print_button,update_button,logout_button;
	buttonpage()
	{
		print_button=new JButton("Print Details");
		update_button=new JButton("Update");
		logout_button=new JButton("Log Out");
		logout_button.setBackground(new Color(248, 248, 255));
		update_button.setBackground(new Color(248, 248, 255));
		print_button.setBackground(new Color(248, 248, 255));
		frame.setSize(300,250);
		frame.setVisible(true);
		frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.add(print_button);
		frame.add(update_button);
		frame.add(logout_button);
		print_button.setBounds(80,50,120,30);
		print_button.addActionListener(this);
		update_button.setBounds(90,100,100,30);
		update_button.addActionListener(this);
		logout_button.setBounds(90,150,100,30);
		logout_button.addActionListener(this);
	
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==print_button)
		{
			frame.dispose();
			MainProgram z = new MainProgram();
		}
		if(e.getSource()==update_button)
		{
			frame.dispose();
			updatehome x = new updatehome();
		}
		if(e.getSource()==logout_button)
		{
			frame.dispose();
			Login x = new Login();
		}
	}
	public static void main(String ag[]) {
		 buttonpage z = new buttonpage();
	}
}