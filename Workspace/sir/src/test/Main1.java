package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

class SecondWindow extends JFrame implements ActionListener
{
	private JLabel l0,l1,l2,l3;
	private JTextField t1;
	private JPasswordField p1;
	private JButton login,cancel;
	
	private String sysDate,sysTime;
	
	private ArrayList<AdminLoginHistoryData> alist = new ArrayList<AdminLoginHistoryData>();
	
	//private JLabel lTimeValue;
	//private JLabel lDateValue;
	//private Component lDate;
	//private Component lTime;
	private boolean flagID = false;
	private boolean flagPass = false;
	
	public SecondWindow()
	{
		super("Login as Administrator");
		Container c=getContentPane();
		c.setLayout(new GridLayout(4,2));
		
		Font f1=new Font("Times New Roman",Font.BOLD,20);
		l1=new JLabel("                ADMINISTRATOR");
		l1.setFont(f1);
		l1.setForeground(Color.RED);
		JPanel fpanel=new JPanel();
		fpanel.add(l1);
		fpanel.setBackground(new Color(0,0,64));
		
		l0=new JLabel("LOGIN                            ");
		l0.setFont(f1);
		l0.setForeground(Color.RED);
		JPanel epanel=new JPanel();
		epanel.add(l0);
		epanel.setBackground(new Color(0,0,64));
		
		//Font f1=new Font("Times New Roman",Font.BOLD,20);
		l2=new JLabel("USERNAME");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		JPanel apanel=new JPanel();
		apanel.add(l2);
		apanel.setBackground(new Color(0,0,64));
		
		
		//Font f1=new Font("Times New Roman",Font.BOLD,20);
		l3=new JLabel("PASSWORD");
		l3.setFont(f1);
		l3.setForeground(Color.RED);
		JPanel bpanel=new JPanel();
		bpanel.add(l3);
		bpanel.setBackground(new Color(0,0,64));
		
		
		t1=new JTextField();
		p1=new JPasswordField();
		
		login=new JButton("LOGIN");
		login.addActionListener(this);
		JPanel cpanel=new JPanel();
		cpanel.add(login);
		cpanel.setBackground(new Color(0,0,64));
		
		
		cancel=new JButton("CANCEL");
		cancel.addActionListener(this);
		JPanel dpanel=new JPanel();
		dpanel.add(cancel);
		dpanel.setBackground(new Color(0,0,64));
		
		
		/********DATE**********************/
		
		Calendar cal = Calendar.getInstance();
		
		String cday = ""+cal.get(Calendar.DATE);
		int x =cal.get(Calendar.MONTH);
		String cmonth = ""+(x+1);
		String cyear =""+cal.get(Calendar.YEAR);
		sysDate = cday+"/"+cmonth+"/"+cyear;
		
		//lDateValue = new JLabel(sysDate);		
		
		
	    String chr = ""+cal.get(Calendar.HOUR_OF_DAY);
		String cmin = ""+cal.get(Calendar.MINUTE);
		String csec =""+cal.get(Calendar.SECOND);
		sysTime = chr+":"+cmin+":"+csec;
		
		/*lTimeValue=new JLabel(sysTime);
		
		
		JPanel datePanel = new JPanel();
		datePanel.add(lDate);
		datePanel.add(lDateValue);
		
		JPanel timePanel = new JPanel();
		timePanel.add(lTime);
		timePanel.add(lTimeValue);*/
		
		
		/**********************************/
		
		
		c.add(fpanel);c.add(epanel);
		c.add(apanel);c.add(t1);
		c.add(bpanel);c.add(p1);
		c.add(cpanel);c.add(dpanel);
		
		setSize(500,425);
		setLocation(200,200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		AdminLoginHistoryData obj;
		
		if(e.getSource()==login) 
		{
			
			
			
			
			/******validation check********/
			
			 String n = t1.getText().trim();
		     String ps = p1.getText().trim();
		     
		     
		     /* user id check
		      * */
		     
		     
		     String namepattern = "^[A-Za-z]";
		     Scanner   scan  =  new Scanner( n ) ;
		     String   matched  =  scan.findInLine( namepattern ) ;
		     if ( matched == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID USER NAME\nIt should contain only alphabet.");
		    	 JOptionPane.showMessageDialog(this, "INVALID USER NAME\nIt should contain only alphabet.", "Error", JOptionPane.ERROR_MESSAGE);
		         t1.setText("");
		     }
		     else
		     {
		    	 flagID = true;
		     }
		     
		     
		     
		     String passwordpattern = "^[0-9]{4}" ; 
		     Scanner   scan2  =  new Scanner( ps ) ;
		     String   matched2  =  scan2.findInLine( passwordpattern ) ;
		     if ( matched2 == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
		    	 JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.", "Error", JOptionPane.ERROR_MESSAGE);
		         p1.setText("");
		     }
		     else
		     {
		    	 flagPass = true;
		     }
		     
		     
			
			/*******************************/
		     
		     
		     /********if the both are valid the *************/
		     
		     if(flagID == true )
		     {
		    	 if(flagPass == true)
		    	 {
		    		 /*user id and pass word check ------> login
				      * */
					if(t1.getText().equals("admin") && p1.getText().equals("1234"))
					{
						
						/******************************************************1**********************************************************************/
						
						obj = new AdminLoginHistoryData();
						
						obj.setALoginDate(sysDate);
						obj.setALoginTime(sysTime);
						obj.setALogoutDate("	-	");
						obj.setALogoutTime("	-	");
						
						alist.add(obj);
						
						
						new AdminLoginHistoryAddInfo(obj);
						
						
						
						
						
						
						
						/******************************************************2**********************************************************************/
						
						JOptionPane.showMessageDialog(this, "Welcome Administrator");
						new Admin() ;
						setVisible(false);
					}
					
					/* else part password error
					 * */
					
					else
					{
						//JOptionPane.showMessageDialog(this, "Wrong username/password...\nTry again");
						JOptionPane.showMessageDialog(this, "Wrong username/password...\nTry again", "Error", JOptionPane.ERROR_MESSAGE);
						t1.setText("");
						p1.setText("");
					}
		    	 }
					
			}
		     flagID = false;
		     flagPass = false;
	    }
		
		
		/***********************	NOT USABLE PART	******************************************/
		/*else
		{
			JOptionPane.showMessageDialog(this, "Try Agian");
		}*/
			
		     
		     /*user id and pass word check ------> login
		      * */
			/*if(t1.getText().equals("admin") && p1.getText().equals("1234"))
			{
				JOptionPane.showMessageDialog(this, "Welcome Administrator");
				new Admin() ;
				setVisible(false);
			}*/
			
			
			
			/******subhranshsu******/
			
			/*if(t1.getText().equals("admin")) 
			{
				char [] pwd=p1.getPassword();
				String str=new String(pwd);
				if(str.equals("1234"))
				{

					JOptionPane.showMessageDialog(this, "Welcome Administrator");
					new Admin() ;
					setVisible(false);
					
				}
			}*/
			
			/*******************************************/
			
			/* else part password error
			 * */
			/*else
			{
				JOptionPane.showMessageDialog(this, "Wrong username/password..");
				t1.setText("");
				p1.setText("");
			}
				
			}*/
		
		
		/*********************************************************************************/
		if(e.getSource()==cancel) 
		{
             int con=JOptionPane.showConfirmDialog(this, "Are you sure to cancel?");
			
			if(con==JOptionPane.YES_OPTION)
			{
			   new FirstWindow("");
			   setVisible(false);
			}
		
		
		}
	}
	
}

public class Main1
{

	public static void main(String[] args) 
	{
	

	}

}
