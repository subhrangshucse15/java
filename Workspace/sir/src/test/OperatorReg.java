package test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.*;

public class OperatorReg extends JFrame implements ActionListener
{
	private JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l;
	private JTextField tid,tod;
	private JPasswordField tpass;
	private JTextArea tadd;
	private JComboBox city,day,month,year,annualincome;
	private JCheckBox cmo,cmu,cco;
	private JRadioButton rmale,rfemale;
	private JButton bsubmit,back;
	
	private String sysdate,systime;
	
	private boolean flagName=false, flagName1 = false, flagPass=false, flagAdd = false;
	
	private ArrayList<OperatorRegData> alist = new ArrayList<OperatorRegData>();
		
	public OperatorReg(String title)
	{
		super("Operator registration");
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(12,2));
		
		tid=new JTextField();
		tod=new JTextField();
		tpass=new JPasswordField();
		
		tadd=new JTextArea(5,20);
		JScrollPane tapan=new JScrollPane(tadd);
		
		String cvalue[]={"<50000","50000-100000","100000-600000",">600000"};
		annualincome=new JComboBox(cvalue);
		
		String ctvalue[]={"Kolkata","Delhi","Mumbai","Chennai","Hydrabad","Pune","Bangalore"};
		city=new JComboBox(ctvalue);
		
		
		rmale=new JRadioButton("Male");
		rfemale=new JRadioButton("Female");
		ButtonGroup rgroup=new ButtonGroup();
		rgroup.add(rmale);
		rgroup.add(rfemale);
		JPanel gpanel=new JPanel();
		gpanel.add(rmale);
		gpanel.add(rfemale);
		
		String dvalue[]=new String[31];
		for(int i=0;i<=30;i++)
		{
			dvalue[i]=String.valueOf(i+1);
		}
		day=new JComboBox(dvalue);
		
		String mvalue[]=new String[12];
		for(int i=0;i<=11;i++)
		{
			mvalue[i]=String.valueOf(i+1);
		}
		month=new JComboBox(mvalue);
		
		String yvalue[]=new String[25];
		int cnt=0;
		for(int i=1989;i<=2013;i++)
		{
			yvalue[cnt]=String.valueOf(i);
			cnt++;	
		}
		year=new JComboBox(yvalue);
		JPanel cpanel=new JPanel();
		cpanel.add(day);
		cpanel.add(month);
		cpanel.add(year);
		
		/*cmo=new JCheckBox("Movie");
		cmu=new JCheckBox("Music");
		cco=new JCheckBox("Computer");
		JPanel ipanel=new JPanel();
		ipanel.add(cmo);
		ipanel.add(cmu);
		ipanel.add(cco);*/
		
		bsubmit=new JButton("Register");
		bsubmit.addActionListener(this);
		
		back=new JButton("BACK");
		back.addActionListener(this);
				
		Font f=new Font("TIMES NEW ROMAN",Font.BOLD,27);
		l1=new JLabel("OPERATOR");
		l1.setFont(f);
		l1.setForeground(Color.BLUE);
		JPanel apanel=new JPanel();
		apanel.add(l1);
		apanel.setBackground(new Color(0,0,64));
		
		l0=new JLabel("REGISTRATION");
		l0.setFont(f);
		l0.setForeground(Color.BLUE);
		JPanel bpanel=new JPanel();
		bpanel.add(l0);
		bpanel.setBackground(new Color(0,0,64));		

		
		Font f1=new Font("comic sans ms",Font.BOLD,14);
		l2=new JLabel("Enter First Name");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		JPanel dpanel=new JPanel();
		dpanel.add(l2);
		dpanel.setBackground(new Color(0,0,64));
		
		l=new JLabel("Enter Last Name");
		l.setFont(f1);
		l.setForeground(Color.RED);
		JPanel qpanel=new JPanel();
		qpanel.add(l);
		qpanel.setBackground(new Color(0,0,64));
		
		
		l3=new JLabel("Enter Password");
		l3.setFont(f1);
		l3.setForeground(Color.RED);
		JPanel epanel=new JPanel();
		epanel.add(l3);
		epanel.setBackground(new Color(0,0,64));
		
		l4=new JLabel("Enter Address");
		l4.setFont(f1);
		l4.setForeground(Color.RED);
		JPanel fpanel=new JPanel();
		fpanel.add(l4);
		fpanel.setBackground(new Color(0,0,64));
		
		l5=new JLabel("Select City");
		l5.setFont(f1);
		l5.setForeground(Color.RED);
		JPanel hpanel=new JPanel();
		hpanel.add(l5);
		hpanel.setBackground(new Color(0,0,64));
		
		l6=new JLabel("Select Gender");
		l6.setFont(f1);
		l6.setForeground(Color.RED);
		JPanel ipanel=new JPanel();
		ipanel.add(l6);
		ipanel.setBackground(new Color(0,0,64));
		
		l7=new JLabel("Select DOB");
		l7.setFont(f1);
		l7.setForeground(Color.RED);
		JPanel jpanel=new JPanel();
		jpanel.add(l7);
		jpanel.setBackground(new Color(0,0,64));
		
		l8=new JLabel("Salary");
		l8.setFont(f1);
		l8.setForeground(Color.RED);
		JPanel kpanel=new JPanel();
		kpanel.add(l8);
		kpanel.setBackground(new Color(0,0,64));
		
		l9=new JLabel("Current Date");
		l9.setFont(f1);
		l9.setForeground(Color.RED);
		JPanel npanel=new JPanel();
		npanel.add(l9);
		npanel.setBackground(new Color(0,0,64));
		
		Calendar cal = Calendar.getInstance();
		
		String cday = ""+cal.get(Calendar.DATE);
		int x =cal.get(Calendar.MONTH);
		String cmonth = ""+(x+1);
		String cyear =""+cal.get(Calendar.YEAR);
		sysdate = cday+"/"+cmonth+"/"+cyear;
		l11=new JLabel(sysdate);		
		
	    String chr = ""+cal.get(Calendar.HOUR_OF_DAY);
		String cmin = ""+cal.get(Calendar.MINUTE);
		String csec =""+cal.get(Calendar.SECOND);
		systime = chr+":"+cmin+":"+csec;
		
		l12=new JLabel(systime);		
		
		l10=new JLabel("Current Time");
		l10.setFont(f1);
		l10.setForeground(Color.RED);
		JPanel opanel=new JPanel();
		opanel.add(l10);
		opanel.setBackground(new Color(0,0,64));

		c.add(apanel);c.add(bpanel);
		c.add(dpanel);c.add(tid);
		c.add(qpanel);c.add(tod);
		c.add(epanel);c.add(tpass);
		c.add(fpanel);c.add(tapan);
		c.add(hpanel);c.add(city);
		c.add(ipanel);c.add(gpanel);
		c.add(jpanel);c.add(cpanel);
		c.add(kpanel);c.add(annualincome);
		c.add(npanel);c.add(l11);
		c.add(opanel);c.add(l12);
		c.add(bsubmit);c.add(back);
		
		setSize(500, 425);
		setLocation(600,200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}

	public void actionPerformed(ActionEvent e) 
	{
		String name,name1,pass,add,ct,gn,dob,ins;
		OperatorRegData reg;
		if(e.getSource() == bsubmit)
		{
			//JOptionPane.showMessageDialog(this, "REGISTER BUTTON");
			
			/*****************VALIDATION******************************************/
			/******validation check********/
			
			 String n = tid.getText().trim();
			 String n1 = tod.getText().trim();
		     String ps = tpass.getText().trim();
		     String ad = tadd.getText().trim();
		     
		     
		     /* user first name check
		      * */
		     String namepattern = "^[A-Za-z]";
		     Scanner   scan  =  new Scanner( n ) ;
		     String   matched  =  scan.findInLine( namepattern ) ;
		     if ( matched == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID FIRST NAME\nIt should contain only alphabet.");
		    	 JOptionPane.showMessageDialog(this, "INVALID 	FIRST NAME\nIt should contain only alphabet.", "Error", JOptionPane.ERROR_MESSAGE);
		         tid.setText("");
		     }
		     else
		     {
		    	 flagName = true;
		     }
		     
		     
		     /* user last name check
		      * */
		     String namepattern1 = "^[A-Za-z]";
		     Scanner   scan1  =  new Scanner( n1 ) ;
		     String   matched1  =  scan1.findInLine( namepattern1 ) ;
		     if ( matched1 == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID LAST NAME\nIt should contain only alphabet.");
		    	 JOptionPane.showMessageDialog(this, "INVALID LAST NAME\nIt should contain only alphabet.", "Error", JOptionPane.ERROR_MESSAGE);
		         tod.setText("");
		     }
		     else
		     {
		    	 flagName1 = true;
		     }
		     
		     
		     /*for password check
		      * */
		     String passwordpattern = "^[0-9]{4}" ; 
		     Scanner   scan2  =  new Scanner( ps ) ;
		     String   matched2  =  scan2.findInLine( passwordpattern ) ;
		     if ( matched2 == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
		    	 JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.", "Error", JOptionPane.ERROR_MESSAGE);
		         tpass.setText("");
		     }
		     else
		     {
		    	 flagPass = true;
		     }
		     
		     
		     /* user address check
		      * */
		     String addpattern = "^[A-Za-z0-9]{1}";
		     Scanner   scan3  =  new Scanner( ad ) ;
		     String   matched3  =  scan3.findInLine( addpattern ) ;
		     if ( matched3 == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID LAST NAME\nIt should contain only alphabet.");
		    	 JOptionPane.showMessageDialog(this, "INVALID ADDRESS\nIt should not blank.", "Error", JOptionPane.ERROR_MESSAGE);
		         tadd.setText("");
		     }
		     else
		     {
		    	 //JOptionPane.showMessageDialog(this, "t/f");
		    	 flagAdd = true;
		     }
		     
		     
		     	/*******storing info in variable**********************************/
		     	name =tid.getText().trim();
		     	name1=tod.getText().trim();
		     	pass=tpass.getText().trim();
				add=tadd.getText().trim();
				ct=(String)city.getSelectedItem();
			
				gn="";
				if(rmale.isSelected())
				{
					gn="Male";
				}
				else if(rfemale.isSelected())
				{
					gn="Female";
				}
				
				String d=(String)day.getSelectedItem();
				String m=(String)month.getSelectedItem();
				String y=(String)year.getSelectedItem();
				dob=d + "-" + m + "-" + y;
				
				
				if(flagName == true)
				{
					//JOptionPane.showMessageDialog(this, "name");
					if(flagName1 == true)
					{
						//JOptionPane.showMessageDialog(this, "mane1");
						if(flagPass == true)
						{
							//JOptionPane.showMessageDialog(this, "pass");
							if(flagAdd == true)
							{
								//JOptionPane.showMessageDialog(this, "add");
								reg = new OperatorRegData();
								
								reg.setName(name);
								reg.setName1(name1);
								reg.setPassword(pass);
								reg.setAddress(add);
								reg.setCity(ct);
								reg.setGender(gn);
								reg.setDob(dob);
								reg.setDate(l11.getText());
								reg.setTime(l12.getText());
								
								alist.add(reg);
							 
								int con=JOptionPane.showConfirmDialog(this, "Are You Sure to Register?");
								
								if(con==JOptionPane.YES_OPTION)
								{
								   new OperatorAddInfo(reg);
								   JOptionPane.showMessageDialog(this, "Successfully registered");
								   tid.setText("");
								   tod.setText("");
								   tadd.setText("");
								   tpass.setText("");
								}
							}
						}
					}
				}
				
				flagName = false;
				flagName1 = false;
				flagPass = false;
				flagAdd = false;
				
			
			
			
			
			/*name =tid.getText().trim();
			name1=tod.getText().trim();
			pass=tpass.getText().trim();
			add=tadd.getText().trim();
			ct=(String)city.getSelectedItem();
		
			gn="";
			if(rmale.isSelected())
			{
				gn="Male";
			}
			else if(rfemale.isSelected())
			{
				gn="Female";
			}
			
			String d=(String)day.getSelectedItem();
			String m=(String)month.getSelectedItem();
			String y=(String)year.getSelectedItem();
			dob=d + "-" + m + "-" + y;
			
			
            
			reg = new OperatorRegData();
			
			reg.setName(name);
			reg.setName1(name1);
			reg.setPassword(pass);
			reg.setAddress(add);
			reg.setCity(ct);
			reg.setGender(gn);
			reg.setDob(dob);
			reg.setDate(l11.getText());
			reg.setTime(l12.getText());
			
			alist.add(reg);
		 
			int con=JOptionPane.showConfirmDialog(this, "Are You Sure to Register?");
			
			if(con==JOptionPane.YES_OPTION)
			{
			   new OperatorAddInfo(reg);
			   tid.setText("");
			   tod.setText("");
			   tadd.setText("");
			   tpass.setText("");
			}*/
		}
		if(e.getSource()==back)
		{
			int con=JOptionPane.showConfirmDialog(this, "Are You Sure to Quit?");
			
			if(con==JOptionPane.YES_OPTION)
			{
			   new Admin();
			   setVisible(false);
			}
		}
		
	}

	
}

	

