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
public class insert3 implements ActionListener
{
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	JFrame frame = new JFrame("info");
	JTextField rent_text,loan_text,fund_text,lic_text,acc_text,pan_text;
	JLabel info3_label,rent_label,loan_label,fund_label,lic_label,acc_label,pan_label;
	JButton clr_button,submit_button;
	insert3()
	{
		acc_label=new JLabel("Account No");
		clr_button=new JButton("Clear");
		submit_button=new JButton("Submit");
		info3_label = new JLabel("Investment Information");  
        info3_label.setBounds(65,11, 213, 30);  
        info3_label.setForeground(Color.black);  
        info3_label.setFont(new Font("Arial", Font.BOLD, 16));
        frame.setResizable(false);
        frame.setSize(310,379);
        frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        rent_label=new JLabel("House Rent");
		loan_label=new JLabel("House Loan");
		fund_label=new JLabel("Provident Fund");
		lic_label=new JLabel("Lic Loan");
		pan_label=new JLabel("Pan No");
		pan_text=new JTextField(20);
		acc_text=new JTextField(20);
		rent_text=new JTextField(20);
		loan_text=new JTextField(20);
		fund_text=new JTextField(20);
		lic_text=new JTextField(20);
		frame.getContentPane().add(info3_label);
		frame.getContentPane().add(pan_label);
		frame.getContentPane().add(pan_text);
		frame.getContentPane().add(rent_label);
		frame.getContentPane().add(rent_text);
		frame.getContentPane().add(lic_label);
		frame.getContentPane().add(lic_text);
		frame.getContentPane().add(loan_label);
		frame.getContentPane().add(loan_text);
		frame.getContentPane().add(fund_label);
		frame.getContentPane().add(fund_text);
		frame.getContentPane().add(acc_label);
		frame.getContentPane().add(acc_text);
		frame.getContentPane().add(submit_button);
		frame.getContentPane().add(clr_button);
		pan_label.setBounds(50,64,100,20);
		pan_label.setFont(new Font("Arial", Font.PLAIN, 12));
		pan_text.setBounds(157,64,100,20);
		rent_label.setBounds(36,95,100,20);
		rent_label.setFont(new Font("Arial", Font.PLAIN, 12));
		rent_text.setBounds(157,95,100,20);
		lic_label.setBounds(50,126,100,20);
		lic_label.setFont(new Font("Arial", Font.PLAIN, 12));
		lic_text.setBounds(157,126,100,20);
		loan_label.setBounds(36,157,100,20);
		loan_label.setFont(new Font("Arial", Font.PLAIN, 12));
		loan_text.setBounds(157,157,100,20);
		fund_label.setBounds(36,188,100,20);
		fund_label.setFont(new Font("Arial", Font.PLAIN, 12));
		fund_text.setBounds(157,188,100,20);
		acc_label.setBounds(36,219,100,20);
		acc_label.setFont(new Font("Arial", Font.PLAIN, 12));
		acc_text.setBounds(157,219,100,20);
		submit_button.setBounds(36,278,100,30);
		submit_button.addActionListener(this);
		submit_button.setFont(new Font("Arial", Font.PLAIN, 12));
		clr_button.setBounds(157,278,100,30);
		clr_button.setFont(new Font("Arial", Font.PLAIN, 12));
		clr_button.addActionListener(this);
		clr_button.setBackground(new Color(248, 248, 255));
		submit_button.setBackground(new Color(248, 248, 255));
	}
	public void actionPerformed(ActionEvent e) 
	{
		String Account_no = acc_text.getText();
		String rent = rent_text.getText();
        String loan = loan_text.getText();
        String fund = fund_text.getText();
        String lic = lic_text.getText();
        String pan = pan_text.getText();
		if(e.getSource()==submit_button)
		{
			if(rent.equals("") || loan.equals("") || fund.equals("") || lic.equals("") || Account_no.equals("") || pan.equals(""))
	        {
	        	JOptionPane.showMessageDialog(null, "All fields must be complete to submit.", "Woops", JOptionPane.ERROR_MESSAGE);
	            return ;
	        }
	        try
			{
				Class.forName("org.postgresql.Driver");  
	            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/project","postgres", "postgres");
	            PreparedStatement st3 = con.prepareStatement("insert into investment values (?,?,?,?,?,?)");  
	            st3.setString(1,pan);
	            st3.setInt(2,Integer.parseInt(rent));
	            st3.setInt(3,Integer.parseInt(lic));
	            st3.setInt(4,Integer.parseInt(loan));
	            st3.setInt(5,Integer.parseInt(fund));
	            st3.setString(6,Account_no);
	            st3.executeQuery();
			}
			catch(Exception z)
			{
				System.out.println(z.getMessage());
			}
	        JOptionPane.showMessageDialog(null, "Data inserted Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
			frame.dispose();
			Login x = new Login();
		}
		if(e.getSource()==clr_button)
		{
			acc_text.setText("");
			rent_text.setText("");
	        lic_text.setText("");
	        loan_text.setText("");
	        fund_text.setText("");
	        pan_text.setText("");
		}
	}
	public static void main(String ag[]) {
		 insert3 z = new insert3();
	}
}