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
        info2_label.setBounds(25,10, 450, 30);  
        info2_label.setForeground(Color.black);  
        info2_label.setFont(new Font("Serif", Font.BOLD, 18));
        frame.setSize(235,280);
		frame.getContentPane().setBackground(Color.cyan);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        aadhar_label=new JLabel("Aadhar No");
		job_label=new JLabel("From Job");
		business_label=new JLabel("From Business");
		prop_label=new JLabel("From Property");
		acc_label=new JLabel("Account No");
		aadhar_text=new JTextField(20);
		acc_text=new JTextField(20);
		job_text=new JTextField(20);
		prop_text=new JTextField(20);
		business_text=new JTextField(20);
		frame.add(info2_label);
		frame.add(aadhar_label);
		frame.add(aadhar_text);
		frame.add(job_label);
		frame.add(job_text);
		frame.add(business_label);
		frame.add(business_text);
		frame.add(prop_label);
		frame.add(prop_text);
		frame.add(acc_label);
		frame.add(acc_text);
		frame.add(submit_button);
		frame.add(clr_button);
		aadhar_label.setBounds(10,50,100,20);
		aadhar_text.setBounds(100,50,100,20);
		job_label.setBounds(10,80,100,20);
		job_text.setBounds(100,80,100,20);
		business_label.setBounds(10,110,100,20);
		business_text.setBounds(100,110,100,20);
		prop_label.setBounds(10,140,100,20);
		prop_text.setBounds(100,140,100,20);
		acc_label.setBounds(10,170,100,20);
		acc_text.setBounds(100,170,100,20);
		submit_button.setBounds(5,200,100,30);
		submit_button.addActionListener(this);
		clr_button.setBounds(115,200,100,30);
		clr_button.addActionListener(this);
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