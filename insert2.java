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
public class insert2 implements ActionListener
{
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	JFrame frame = new JFrame("info");
	JLabel info2_label,job_label,prop_label,acc_label,business_label,aadhar_label;
	JTextField acc_text,job_text,prop_text,business_text,aadhar_text;
	JButton submit_button,clr_button;
	insert2()
	{
		acc_label=new JLabel("Account No");
		clr_button=new JButton("Clear");
		submit_button=new JButton("Submit");
		info2_label = new JLabel("Income Information");  
        info2_label.setBounds(90,11, 204, 30);  
        info2_label.setForeground(Color.black);  
        info2_label.setFont(new Font("Arial", Font.BOLD, 16));
        frame.setResizable(false);
        frame.setSize(368,419);
        frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        aadhar_label=new JLabel("Aadhar No");
        aadhar_label.setFont(new Font("Arial", Font.PLAIN, 12));
		job_label=new JLabel("From Job");
		business_label=new JLabel("From Business");
		prop_label=new JLabel("From Property");
		acc_label=new JLabel("Account No");
		aadhar_text=new JTextField(20);
		acc_text=new JTextField(20);
		job_text=new JTextField(20);
		prop_text=new JTextField(20);
		business_text=new JTextField(20);
		frame.getContentPane().add(info2_label);
		frame.getContentPane().add(aadhar_label);
		frame.getContentPane().add(aadhar_text);
		frame.getContentPane().add(job_label);
		frame.getContentPane().add(job_text);
		frame.getContentPane().add(business_label);
		frame.getContentPane().add(business_text);
		frame.getContentPane().add(prop_label);
		frame.getContentPane().add(prop_text);
		frame.getContentPane().add(acc_label);
		frame.getContentPane().add(acc_text);
		frame.getContentPane().add(submit_button);
		frame.getContentPane().add(clr_button);
		aadhar_label.setBounds(90,66,100,20);
		aadhar_label.setFont(new Font("Arial", Font.PLAIN, 12));
		aadhar_text.setBounds(180,66,100,20);
		job_label.setBounds(90,108,100,20);
		job_label.setFont(new Font("Arial", Font.PLAIN, 12));
		job_text.setBounds(180,108,100,20);
		business_label.setBounds(70,144,100,20);
		business_label.setFont(new Font("Arial", Font.PLAIN, 12));
		business_text.setBounds(180,144,100,20);
		prop_label.setBounds(70,186,100,20);
		prop_label.setFont(new Font("Arial", Font.PLAIN, 12));
		prop_text.setBounds(180,186,100,20);
		acc_label.setBounds(80,224,100,20);
		acc_label.setFont(new Font("Arial", Font.PLAIN, 12));
		acc_text.setBounds(180,224,100,20);
		submit_button.setBounds(59,311,100,30);
		submit_button.addActionListener(this);
		submit_button.setFont(new Font("Arial", Font.PLAIN, 12));
		clr_button.setBounds(196,311,100,30);
		clr_button.setFont(new Font("Arial", Font.PLAIN, 12));
		clr_button.addActionListener(this);
		clr_button.setBackground(new Color(248, 248, 255));
		submit_button.setBackground(new Color(248, 248, 255));
	}
	public void actionPerformed(ActionEvent e) 
	{
		String Account_no = acc_text.getText();
		String from_job = job_text.getText();
        String from_prop = prop_text.getText();
        String from_business = business_text.getText();
        String aadhar_no = aadhar_text.getText();
		if(e.getSource()==submit_button)
		{
			if(Account_no.equals("") || from_job.equals("") || from_prop.equals("") || from_business.equals("") || aadhar_no.equals("") )
	        {
	        	JOptionPane.showMessageDialog(null, "All fields must be complete to submit.", "Woops", JOptionPane.ERROR_MESSAGE);
	            return ;
	        }
	        try
			{
				Class.forName("org.postgresql.Driver");  
	            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/project","postgres", "postgres");
	            PreparedStatement st3 = con.prepareStatement("insert into income values (?,?,?,?,?)");  
	            st3.setString(1,aadhar_no);
	            st3.setInt(2,Integer.parseInt(from_job));
	            st3.setInt(3,Integer.parseInt(from_prop));
	            st3.setInt(4,Integer.parseInt(from_business));
	            st3.setString(5,Account_no);
	            st3.executeQuery();
			}
			catch(Exception z)
			{
				System.out.println(z.getMessage());
			}
	        JOptionPane.showMessageDialog(null, "Data inserted Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
			frame.dispose();
			insert3 x =new insert3();
		}
		if(e.getSource()==clr_button)
		{
			acc_text.setText("");
			aadhar_text.setText("");
	        job_text.setText("");
	        prop_text.setText("");
	        business_text.setText("");
		}
	}
	public static void main(String ag[]) {
		 insert2 z = new insert2();
	}
}