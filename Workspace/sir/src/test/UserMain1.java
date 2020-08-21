package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

class ThirdWindow extends JFrame implements ActionListener
{
	private JLabel l0,l1,l2,l3;
	private JTextField t1;
	private JPasswordField p1;
	private JButton login,newuser,back;
	
	private String sysDate,sysTime;
	
	private ArrayList<OperatorLoginHistoryData> alist = new ArrayList<OperatorLoginHistoryData>();
	
	private boolean flagID = false;
	private boolean flagPass = false;
	private ArrayList<OperatorRegData> alistTemp;
	private boolean flag = false;
	
	public ThirdWindow()
	{
		
		super("Log in as operator");
		
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
		/***********************************************************/
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(4,2));
		
		Font f1=new Font("Times New Roman",Font.BOLD,28);
		l0=new JLabel("            OPERATOR");
		l0.setFont(f1);
		l0.setForeground(Color.RED);
		JPanel fpanel=new JPanel();
		fpanel.add(l0);
		fpanel.setBackground(new Color(0,0,64));
		
		Font f2=new Font("Times New Roman",Font.BOLD,20);
		l1=new JLabel("LOGIN               ");
		l1.setFont(f1);
		l1.setForeground(Color.RED);
		JPanel fxpanel=new JPanel();
		fxpanel.add(l1);
		fxpanel.setBackground(new Color(0,0,64));
		
		//Font f1=new Font("Times New Roman",Font.BOLD,);
		l2=new JLabel("USERNAME");
		l2.setFont(f2);
		l2.setForeground(Color.RED);
		
		//Font f1=new Font("Times New Roman",Font.BOLD,20);
		l3=new JLabel("PASSWORD");
		l3.setFont(f2);
		l3.setForeground(Color.RED);
		
		t1=new JTextField();
		p1=new JPasswordField();
		
		JPanel xpanel=new JPanel();
		xpanel.add(l2);
		xpanel.setBackground(new Color(0,0,64));
		
		JPanel xppanel=new JPanel();
		xppanel.add(t1);
		xppanel.setBackground(new Color(0,0,64));
		
		JPanel lpanel=new JPanel();
		lpanel.add(l3);
		lpanel.setBackground(new Color(0,0,64));
		
		JPanel xlpanel=new JPanel();
		xlpanel.add(p1);
		xlpanel.setBackground(new Color(0,0,64));
		
		
		login=new JButton("LOGIN");
		JPanel gpanel=new JPanel();
		gpanel.add(login);
		gpanel.setBackground(new Color(0,0,64));
		login.addActionListener(this);
		
		/*newuser=new JButton("NEW USER: REGISTER HERE");
		gpanel.add(newuser);
		//ganel.setBackground(new Color(0,0,64));
		newuser.addActionListener(this);*/
		
		back=new JButton("BACK");
		JPanel apanel=new JPanel();
		apanel.add(back);
		apanel.setBackground(new Color(0,0,64));
		back.addActionListener(this);
		
		c.add(fpanel);c.add(fxpanel);
		c.add(xpanel);c.add(t1);
		c.add(lpanel);c.add(p1);
		c.add(gpanel);c.add(apanel);
		
		setSize(500,425);
		setLocation(200,200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		OperatorLoginHistoryData obj;
		
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
		    		 
		    		 String enteredID = t1.getText().trim();
		    		 String enteredPassword = p1.getText().trim();
		    		 
		    		 
		    		 try
		    		 {
		    			 /*******DATA ARE WRITTEN "FILE ---> ARRAY LIST"********/
		 				
		 				FileInputStream fin = new FileInputStream("Reg.dat");
		 				ObjectInputStream oin = new ObjectInputStream(fin);
		 				alistTemp = (ArrayList<OperatorRegData>)oin.readObject();
		 				
		 				
		 				/*******************************************************/
		    		 }
		    		 catch(Exception ex)
		    		 {
		    			 JOptionPane.showMessageDialog(this, "No file found in database.", "Error", JOptionPane.ERROR_MESSAGE);
		    		 }
		    		 
		    		 
		    		 /*****************OPERATION ON ARRAY LIST***************/
						
						
		    		 //int i=0;
		    		 for(OperatorRegData element : alistTemp)
		    		 {
		    			 if(element.getName().equals(enteredID))// && element.getPassword().equals(enteredPassword))
		    			 {
		    				 if(element.getPassword().equals(enteredPassword))
		    				 {
		    					//JOptionPane.showMessageDialog(this, "Successfully logged in");
			    				 flag  = true;
			    				 
		    				 }
		    			 }
							
		    		 }
						
		    		 if(flag == true)
		    		 {
		    			 /******************************************************1**********************************************************************/
		    			 
		    			 obj = new OperatorLoginHistoryData();
							
		    			 obj.setOperatorFirstName(t1.getText().trim());
		    			 obj.setOLoginDate(sysDate);
		    			 obj.setOLoginTime(sysTime);
		    			 obj.setOLogoutDate("	-	");
		    			 obj.setOLogoutTime("	-	");
							
		    			 alist.add(obj);
							
							
		    			 new OperatorLoginHistoryAddInfo(obj);
		    			 
		    			 
		    			 
		    			 
		    			 
		    			 
		    			 /******************************************************2**********************************************************************/
		    			 
		    			 JOptionPane.showMessageDialog(this, "Successfully logged in");
		    			 new Userwindow(t1.getText());
		    			 setVisible(false);
		    		 }
		    		 else
		    		 {
		    			 //JOptionPane.showMessageDialog(this, "Incorrect UserID or Password\nTry again.");
		    			 JOptionPane.showMessageDialog(this, "Incorrect UserID or Password\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
		    			 t1.setText("");
		    			 p1.setText("");
		    		 }
		    		 
		    		 
		    	 }
		     }
		     
		     flagID = false;
		     flagPass = false;
		}
		     
		     
			
			
			/***************subhrangshu**********************/
			/*if(e.getSource()==login) 
			{
				if(t1.getText().equals("operator")) 
				{
					char [] pwd=p1.getPassword();
					String str=new String(pwd);
					if(str.equals("1234"))
					{

						JOptionPane.showMessageDialog(this, "HELLO OPERATOR....");
						new Userwindow() ;
						setVisible(false);		
					}
				}
				else
					JOptionPane.showMessageDialog(this, "Wrong username/password..");	
				}*/
			
			/*String d[][]=new String[20][5];
			String p[][]=new String[20][5];
			ArrayList<OperatorRegData> list1=new ArrayList<OperatorRegData>();
			try
			{
				FileInputStream fin=new FileInputStream("Reg.dat");
				ObjectInputStream oin=new ObjectInputStream(fin);
				list1=(ArrayList<OperatorRegData>)oin.readObject();
				int r=0,k=0;
				for(OperatorRegData re1 :list1)
				{
					d[r][0]=re1.getName();
					p[k][0]=re1.getPassword();
					if(d[r][0].equals(t1.getText()))
					{
				     
						char [] pwd=p1.getPassword();
						String str=new String(pwd);
						if(p[k][0].equals(str))
						{
							new Userwindow();
						}
					
				     					     	}
						
				}
				k++;
				r++;
			}
			catch(Exception e1)
			{
				System.out.println(e.toString());
			}
		}
		
		
		*/
		
		
		
		if(e.getSource()==back)
		{
			int con=JOptionPane.showConfirmDialog(this, "Are You Sure to go back?");
		
			if(con==JOptionPane.YES_OPTION)
			{
				new FirstWindow("");
				setVisible(false);	
			}
		}

		
	}
		

			
}
		
		
		
	



public class UserMain1 
{
	public static void main(String[] args) 
	{
	

	}

}
