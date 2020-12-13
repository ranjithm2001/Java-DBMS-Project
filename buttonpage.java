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
	JButton print_button,update_button;
	buttonpage()
	{
		print_button=new JButton("Print Details");
		update_button=new JButton("Update");
		frame.setSize(300,250);
		frame.getContentPane().setBackground(Color.cyan);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.add(print_button);
		frame.add(update_button);
		print_button.setBounds(80,50,120,30);
		print_button.addActionListener(this);
		update_button.setBounds(90,100,100,30);
		update_button.addActionListener(this);
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
	}
	public static void main(String ag[]) {
		 buttonpage z = new buttonpage();
	}
}