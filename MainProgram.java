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
public class MainProgram extends JFrame implements ActionListener 
{  
    JLabel tax_label,msg_label,acc_label,name_label, address_label, phone_label, user_label, pass_label,aadhar_label,job_label,business_label,prop_label,pan_label,rent_label,lic_label,loan_label,fund_label,investment_label,income_label;  
    JTextField tax_text,acc_text,name_text,address_text,phone_text,user_text,pass_text,aadhar_text,job_text,business_text,prop_text,pan_text,rent_text,lic_text,loan_text,fund_text,income_text, investment_text;
    JButton submit_button,tax_button,back_button;
    String s,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13;
    int a,b;
    MainProgram() 
    {        
        super("Fetching Tax Information");  
        acc_label = new JLabel("Enter AccountNo :");  
        acc_label.setBounds(20, 20, 150, 20);
        acc_text = new JTextField(20);  
        acc_text.setBounds(130, 20, 200, 20);  
        submit_button = new JButton("Submit");  
        submit_button.setBounds(125, 50, 100, 20);  
        submit_button.addActionListener(this);  
        msg_label = new JLabel("Fetching Tax Information From Database");  
        msg_label.setBounds(15, 80, 450, 30);  
        msg_label.setForeground(Color.black);  
        msg_label.setFont(new Font("Serif", Font.BOLD, 18));
        getContentPane().setBackground(Color.cyan);
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(400,680); 
        name_label = new JLabel("Name :");  
        name_label.setBounds(20, 120, 100, 20);  
        name_text = new JTextField(50);
        name_text.setBounds(130, 120, 200, 20);
        address_label = new JLabel("Address :");  
        address_label.setBounds(20, 150, 100, 20);  
        address_text = new JTextField(50);  
        address_text.setBounds(130, 150, 200, 20);
        phone_label = new JLabel("Phone No :");  
        phone_label.setBounds(20, 180, 100, 20);  
        phone_text = new JTextField(50);  
        phone_text.setBounds(130, 180, 200, 20);
        user_label = new JLabel("Username :");  
        user_label.setBounds(20, 210, 100, 20);
        user_text = new JTextField(50);  
        user_text.setBounds(130, 210, 200, 20);
        pass_label = new JLabel("Password :");  
        pass_label.setBounds(20, 240, 100, 20);
        pass_text = new JTextField(50);  
        pass_text.setBounds(130, 240, 200, 20);  
        aadhar_label = new JLabel("Aadhar No :");  
        aadhar_label.setBounds(20, 270, 100, 20);  
        aadhar_text = new JTextField(100);  
        aadhar_text.setBounds(130, 270, 200, 20);
        job_label = new JLabel("From Job :");  
        job_label.setBounds(20, 300, 100, 20);  
        job_text = new JTextField(50);  
        job_text.setBounds(130, 300, 200, 20);
        business_label = new JLabel("From Business :");  
        business_label.setBounds(20, 330, 100, 20);  
        business_text = new JTextField(50);  
        business_text.setBounds(130, 330, 200, 20);
        prop_label = new JLabel("From Property :");  
        prop_label.setBounds(20, 360, 100, 20);  
        prop_text = new JTextField(50);  
        prop_text.setBounds(130, 360, 200, 20);
        pan_label = new JLabel("Pan No :");  
        pan_label.setBounds(20, 390, 100, 20);  
        pan_text = new JTextField(50);  
        pan_text.setBounds(130, 390, 200, 20);
        rent_label = new JLabel("House Rent :");  
        rent_label.setBounds(20, 420, 100, 20);  
        rent_text = new JTextField(50);  
        rent_text.setBounds(130, 420, 200, 20);
        lic_label = new JLabel("Lic Amount :");  
        lic_label.setBounds(20, 450, 100, 20);  
        lic_text = new JTextField(50);  
        lic_text.setBounds(130, 450, 200, 20);
        loan_label = new JLabel("House Loan :");  
        loan_label.setBounds(20, 480, 100, 20);  
        loan_text = new JTextField(50);  
        loan_text.setBounds(130, 480, 200, 20);
        fund_label = new JLabel("Provident Fund :");  
        fund_label.setBounds(20, 510, 100, 20);  
        fund_text = new JTextField(50);  
        fund_text.setBounds(130, 510, 200, 20);
        income_label = new JLabel("Net income :");  
        income_label.setBounds(20, 540, 100, 20);  
        income_text = new JTextField(50);  
        income_text.setBounds(130, 540, 200, 20);
        investment_label = new JLabel("Net investment :");  
        investment_label.setBounds(20, 570, 100, 20);  
        investment_text = new JTextField(50);  
        investment_text.setBounds(130, 570, 200, 20);
        tax_label = new JLabel("Tax % :");  
        tax_label.setBounds(20, 600, 100, 20);  
        tax_text = new JTextField(50);
        tax_text.setBounds(130, 600, 200, 20);
		setLayout(null);
        add(acc_label);  
        add(acc_text);  
        add(submit_button);  
        add(msg_label);  
        add(name_label);  
        add(name_text);
        add(address_label);  
        add(address_text);
        add(phone_label);
        add(phone_text);
        add(user_label);
        add(user_text);
        add(pass_label);
        add(pass_text);
        add(aadhar_label);  
        add(aadhar_text);
        add(job_label);
		add(job_text);
		add(business_label);
		add(business_text);
		add(prop_label);
		add(prop_text);
		add(pan_label);
		add(pan_text);
		add(rent_label);
		add(rent_text);
		add(lic_label);
		add(lic_text);
		add(loan_label);
		add(loan_text);
		add(fund_label);
		add(fund_text);
        add(income_label);  
        add(income_text);
        add(investment_label);
        add(investment_text);
        add(tax_label);
        add(tax_text);
        name_text.setEditable(false);  
        address_text.setEditable(false); 
        phone_text.setEditable(false);
        user_text.setEditable(false);
        pass_text.setEditable(false); 
        aadhar_text.setEditable(false);
        job_text.setEditable(false);
        business_text.setEditable(false);
        prop_text.setEditable(false);
        pan_text.setEditable(false);
        rent_text.setEditable(false);
        lic_text.setEditable(false);
        loan_text.setEditable(false);
        fund_text.setEditable(false);
        income_text.setEditable(false);
        investment_text.setEditable(false);
        tax_text.setEditable(false);
    }  
    public void actionPerformed(ActionEvent e) {  
    	if (e.getSource()== submit_button) 
    	{
        try 
        {  
            String str = acc_text.getText();  
            Class.forName("org.postgresql.Driver");  
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/project","postgres", "postgres");  
            PreparedStatement st = con.prepareStatement("select * from tax_payer,income,investment where tax_payer.account_no=?");  
            st.setString(1, str);	  
            ResultSet rs = st.executeQuery();  
            if (rs.next()) 
            {  
                s  = rs.getString(2);  
                s1 = rs.getString(3);  
                s2 = rs.getString(4);  
                s3 = rs.getString(5);
                s4 = rs.getString(6);
                s5 = rs.getString(7);
                s6 = rs.getString(8);
                s7 = rs.getString(9);
                s8 = rs.getString(10);
                s9 = rs.getString(12);
                s10 = rs.getString(13);
                s11 = rs.getString(14);
                s12 = rs.getString(15);
                s13 = rs.getString(16);
                name_text.setText(s);    
                address_text.setText(s1);
                phone_text.setText(s2);
                user_text.setText(s3);
                pass_text.setText(s4);
                aadhar_text.setText(s5);
                job_text.setText(s6);
                business_text.setText(s7);
                prop_text.setText(s8);
                pan_text.setText(s9);
                rent_text.setText(s10);
                lic_text.setText(s11);
                loan_text.setText(s12);
                fund_text.setText(s13);
                a=Integer.parseInt(s6)+Integer.parseInt(s7)+Integer.parseInt(s8);
                b=Integer.parseInt(s10)+Integer.parseInt(s11)+Integer.parseInt(s12)+Integer.parseInt(s13);
                income_text.setText(Integer.toString(a));
                investment_text.setText(Integer.toString(b));
            } 
            else 
            {  
                JOptionPane.showMessageDialog(null, "Account No not Found");  
            }  
        }catch (Exception ex) 
        {  
            System.out.println(ex);  
        }
    }
    	if (a-b<150000)
    	{
    		tax_text.setText("0");
    	}
    	else if(a-b>=150000 && a-b<250000)
    	{
    		tax_text.setText("10");
    	}
    	else if(a-b>=250000 && a-b<350000)
    	{
    		tax_text.setText("20");
    	}
    	else if(a-b>=350000 && a-b<450000)
    	{
    		tax_text.setText("30");
    	}
    	else
    	{
    		tax_text.setText("40");
    	}	
    }  	  
    public static void main(String args[]) {  
        new MainProgram();  
    }  
}  