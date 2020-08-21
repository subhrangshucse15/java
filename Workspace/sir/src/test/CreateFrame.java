package test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.*;


public class CreateFrame extends JFrame implements ActionListener
{
	private JLabel l0,l01,l1,l2,l3,l4,l40,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21;
	private JTextField t1,tid1,tid2,tid3,tid4,tid5,tid6,tid7,tid8,tid10;
	private JComboBox city,day,month,year,annualincome,identity,profession,acctype,acno;
	private JRadioButton rmale,rfemale,rsav,rothers,married,unmarried;
	private JButton bsubmit,back;
	private String sysdate,systime;
	//private ArrayList<Create> alist = new ArrayList<Create>();
	private boolean flagName = false;
	private boolean flagName1 = false;
	private boolean flagAddress = false;
	private boolean flagNationality = false;
	private ArrayList<Create> alist;
	private boolean flagAccountNumber = false;
	private int count = 0;
	private String ini;
	private boolean flagInitialAmount = false;
	private boolean flagLandline = false;
	private boolean flagMobile = false;
	private boolean flagAge = false;
	private boolean flagProof = false;

	CreateFrame()
	{
		super("User registration form");
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(21,2));
		
		tid1=new JTextField();
		tid2=new JTextField();
		tid3=new JTextField();
		tid4=new JTextField();
		tid5=new JTextField();
		tid6=new JTextField();
		tid7=new JTextField();
		tid8=new JTextField();
		//tid9=new JTextField();
		tid10=new JTextField();
		
		String cvalue[]={"<50000","50000-100000","100000-600000",">600000"};
		annualincome=new JComboBox(cvalue);
		
		String d1value[]={"Government Service","Business","Private Sector","Student","Others"};
		profession=new JComboBox(d1value);
		
		String evalue[]={"Pan Card","Voter Card","Ration Card","Driving License"};
		identity=new JComboBox(evalue);
		
		
		
		rsav=new JRadioButton("Savings");
		
		rothers=new JRadioButton("Savings");
		
		ButtonGroup r1group=new ButtonGroup();
		r1group.add(rsav);
		JPanel kpanel=new JPanel();
		kpanel.add(rsav);

		rmale=new JRadioButton("Male");
		rfemale=new JRadioButton("Female");
		ButtonGroup rgroup=new ButtonGroup();
		rgroup.add(rmale);
		rgroup.add(rfemale);
		JPanel gpanel=new JPanel();
		
		married=new JRadioButton("Married");
		unmarried=new JRadioButton("Single");
		ButtonGroup r2group=new ButtonGroup();
		r2group.add(married);
		r2group.add(unmarried);
		JPanel gopanel=new JPanel();
		gopanel.add(married);
		gopanel.add(unmarried);
		
		gpanel.add(rmale);
		gpanel.add(rfemale);
		
		t1=new JTextField();
		
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
		bsubmit=new JButton("Register");
		bsubmit.addActionListener(this);
		
		Font f1=new Font("Times New Roman",Font.BOLD,14);
		l01=new JLabel("                                     ACCOUNT OPENING");
		l01.setFont(f1);
		l01.setForeground(Color.RED);
		JPanel fpanel=new JPanel();
		fpanel.add(l01);
		fpanel.setBackground(new Color(0,0,64));
		
		l0=new JLabel("FORM                                                 ");
		l0.setFont(f1); 
		l0.setForeground(Color.RED);
		JPanel apanel=new JPanel();
		apanel.add(l0);
		apanel.setBackground(new Color(0,0,64));

		
		//Font f1=new Font("Times New Roman",Font.BOLD,14);
		l1=new JLabel("Enter First Name");
		l1.setFont(f1);
		l1.setForeground(Color.RED);
		JPanel bpanel=new JPanel();
		bpanel.add(l1);
		bpanel.setBackground(new Color(0,0,64));
		
		l2=new JLabel("Enter Last Name");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		JPanel copanel=new JPanel();
		copanel.add(l2);
		copanel.setBackground(new Color(0,0,64));
		
		l3=new JLabel("Enter Address");
		l3.setFont(f1);
		l3.setForeground(Color.RED);
		JPanel dpanel=new JPanel();
		dpanel.add(l3);
		dpanel.setBackground(new Color(0,0,64));
		
		l4=new JLabel("Enter Phone Number(Landline)");
		l4.setFont(f1);
		l4.setForeground(Color.RED);
		JPanel epanel=new JPanel();
		epanel.add(l4);
		epanel.setBackground(new Color(0,0,64));
		
		l40=new JLabel("Enter Phone Number(Mobile)");
		l40.setFont(f1);
		l40.setForeground(Color.RED);
		JPanel vpanel=new JPanel();
		vpanel.add(l40);
		vpanel.setBackground(new Color(0,0,64));

		
		l5=new JLabel("Select Sex");
		l5.setFont(f1);
		l5.setForeground(Color.RED);
		JPanel qpanel=new JPanel();
		qpanel.add(l5);
		qpanel.setBackground(new Color(0,0,64));

		
		l6=new JLabel("Natinality");
		l6.setFont(f1);
		l6.setForeground(Color.RED);
		JPanel wpanel=new JPanel();
		wpanel.add(l6);
		wpanel.setBackground(new Color(0,0,64));

		
		l7=new JLabel("Select Age");
		l7.setFont(f1);
		l7.setForeground(Color.RED);
		JPanel opanel=new JPanel();
		opanel.add(l7);
		opanel.setBackground(new Color(0,0,64));

		
		l8=new JLabel("Select A/C Type");
		l8.setFont(f1);
		l8.setForeground(Color.RED);
		JPanel zpanel=new JPanel();
		zpanel.add(l8);
		zpanel.setBackground(new Color(0,0,64));

		
		l9=new JLabel("Date of Birth");
		l9.setFont(f1);
		l9.setForeground(Color.RED);
		JPanel xpanel=new JPanel();
		xpanel.add(l9);
		xpanel.setBackground(new Color(0,0,64));

		l10=new JLabel("Enter Annual Income");
		l10.setFont(f1);
		l10.setForeground(Color.RED);
		JPanel vxpanel=new JPanel();
		vxpanel.add(l10);
		vxpanel.setBackground(new Color(0,0,64));

		l11=new JLabel("Enter Profession");
		l11.setFont(f1);
		l11.setForeground(Color.RED);
		JPanel vppanel=new JPanel();
		vppanel.add(l11);
		vppanel.setBackground(new Color(0,0,64));
		
        l12=new JLabel("Enter Marital Status");
        l12.setFont(f1);
		l12.setForeground(Color.RED);
		JPanel npanel=new JPanel();
		npanel.add(l12);
		npanel.setBackground(new Color(0,0,64));

		l13=new JLabel("Enter Identity Proof");
        l13.setFont(f1);
		l13.setForeground(Color.RED);
		JPanel mpanel=new JPanel();
		mpanel.add(l13);
		mpanel.setBackground(new Color(0,0,64));

		l14=new JLabel("Enter Identity proof no:");
        l14.setFont(f1);
		l14.setForeground(Color.RED);
		JPanel jpanel=new JPanel();
		jpanel.add(l14);
		jpanel.setBackground(new Color(0,0,64));

		
		/***********************extra*********************/
		
		/*l15=new JLabel("Enter Initial Amount");
        l15.setFont(f1);
		l15.setForeground(Color.RED);
		JPanel bcpanel=new JPanel();
		bcpanel.add(l15);
		bcpanel.setBackground(new Color(0,0,64));*/
		

		/**********************************************/
		

        Calendar cal = Calendar.getInstance();
		
		String cday = ""+cal.get(Calendar.DATE);
		int x =cal.get(Calendar.MONTH);
		String cmonth = ""+(x+1);
		String cyear =""+cal.get(Calendar.YEAR);
		sysdate = cday+"/"+cmonth+"/"+cyear;
		l16=new JLabel(sysdate);		
		
	    String chr = ""+cal.get(Calendar.HOUR_OF_DAY);
		String cmin = ""+cal.get(Calendar.MINUTE);
		String csec =""+cal.get(Calendar.SECOND);
		systime = chr+":"+cmin+":"+csec;
		
		l17=new JLabel(systime);		
		
		l18=new JLabel("Current Time");
		l18.setFont(f1);
		l18.setForeground(Color.RED);
		JPanel vopanel=new JPanel();
		vopanel.add(l18);
		vopanel.setBackground(new Color(0,0,64));
		
		l19=new JLabel("Current Date");
		l19.setFont(f1);
		l19.setForeground(Color.RED);
		JPanel vipanel=new JPanel();
		vipanel.add(l19);
		vipanel.setBackground(new Color(0,0,64));
		
		l20=new JLabel("Give a 4-digit Account number");
		l20.setFont(f1);
		l20.setForeground(Color.RED);
		JPanel poppanel=new JPanel();
		poppanel.add(l20);
		poppanel.setBackground(new Color(0,0,64));
		
		
		
		l20=new JLabel("Initial Amount");
		l20.setFont(f1);
		l20.setForeground(Color.RED);
		JPanel kop=new JPanel();
		kop.add(l20);
		kop.setBackground(new Color(0,0,64));
		
		
		
		bsubmit=new JButton("SUBMIT");
		bsubmit.addActionListener(this);
		JPanel dopanel=new JPanel();
		dopanel.add(bsubmit);
		dopanel.setBackground(new Color(0,0,64));
		
		back=new JButton("BACK");
		back.addActionListener(this);
		JPanel dipanel=new JPanel();
		dipanel.add(back);
		dipanel.setBackground(new Color(0,0,64));
		
		
        c.add(fpanel);c.add(apanel);
		c.add(bpanel);c.add(tid1);
		c.add(copanel);c.add(tid2);
		c.add(dpanel);c.add(tid3);
		c.add(epanel);c.add(tid4);
		c.add(vpanel);c.add(tid5);
		c.add(qpanel);c.add(gpanel);
		c.add(wpanel);c.add(tid6);
		c.add(opanel);c.add(tid7);
		c.add(zpanel);c.add(kpanel);
		c.add(xpanel);c.add(cpanel);
		c.add(vxpanel);c.add(annualincome);
		c.add(vppanel);c.add(profession);
		c.add(npanel);c.add(gopanel);
		c.add(mpanel);c.add(identity);
		c.add(jpanel);c.add(tid8);
		//c.add(bcpanel);c.add(tid9);
		c.add(poppanel);c.add(t1);
		c.add(kop);c.add(tid10);
		c.add(vipanel);c.add(l16);
		c.add(vopanel);c.add(l17);
		c.add(dopanel);c.add(dipanel);
		
		
		setSize(600,625);
		setLocation(200,200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		

	}

	
	public void actionPerformed(ActionEvent e)
	{
		 String name;//first name
		 String name1;//last name
		 String address;
		 String nationality;
		 String acc;//account type
		 String gn;
		 String dob;
		 String date;
	     String time;
		 String Iden;
		 String prof;
		 String inti;
		 String ac1;
		 String land;
		 String mob;
		 String age;
		 String proof;
		 
		 
		 
		 
		 
		 Create reg;
		if(e.getSource()==bsubmit)
		{
			/*****************VALIDATION******************************************/
			/******validation check********/
			
			name=tid1.getText();
			name1=tid2.getText();
			address=tid3.getText();
			nationality=tid6.getText();
			ac1=t1.getText();
			ini = tid10.getText();
			land = tid4.getText();
			mob = tid5.getText();
			age = tid7.getText();
			proof = tid8.getText();
			
			
			
			/* user first name check
		      * */
		     String namepattern = "^[A-Za-z]";
		     Scanner   scan  =  new Scanner( name ) ;
		     String   matched  =  scan.findInLine( namepattern ) ;
		     if ( matched == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID FIRST NAME\nIt should contain only alphabet.");
		    	 JOptionPane.showMessageDialog(this, "INVALID 	FIRST NAME\nIt should contain only alphabet.", "Error", JOptionPane.ERROR_MESSAGE);
		         tid1.setText("");
		     }
		     else
		     {
		    	 flagName = true;
		     }
		     
		     
		     /* user last name check
		      * */
		     String namepattern1 = "^[A-Za-z]";
		     Scanner   scan1  =  new Scanner( name1 ) ;
		     String   matched1  =  scan1.findInLine( namepattern1 ) ;
		     if ( matched1 == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID FIRST NAME\nIt should contain only alphabet.");
		    	 JOptionPane.showMessageDialog(this, "INVALID 	LAST NAME\nIt should contain only alphabet.", "Error", JOptionPane.ERROR_MESSAGE);
		         tid2.setText("");
		     }
		     else
		     {
		    	 flagName1 = true;
		     }
		     
		     
		     /* user address check
		      * */
		     String namepattern2 = "^[A-Za-z0-9]{1}";
		     Scanner   scan2  =  new Scanner( address ) ;
		     String   matched2  =  scan2.findInLine( namepattern2 ) ;
		     if ( matched2 == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID FIRST NAME\nIt should contain only alphabet.");
		    	 JOptionPane.showMessageDialog(this, "INVALID 	ADDRESS\nIT SHOLUD NOT BLANK.", "Error", JOptionPane.ERROR_MESSAGE);
		         tid3.setText("");
		     }
		     else
		     {
		    	 flagAddress = true;
		     }
		     
		     
		     /*for landline numbercheck
		      * */
		     String landlinepattern = "^[0-9]{8}" ; 
		     Scanner   scan6  =  new Scanner( land ) ;
		     String   matched6  =  scan6.findInLine( landlinepattern ) ;
		     if ( matched6 == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
		    	 JOptionPane.showMessageDialog(this, "INVALID LANDLINE NUMBER\nIt should contain only digits with minimum length of 8 digit.", "Error", JOptionPane.ERROR_MESSAGE);
		         tid4.setText("");
		     }
		     else
		     {
		    	 flagLandline    = true;
		     }
		     
		     
		     
		     /*for mobile numbercheck
		      * */
		     String mobpattern = "^[0-9]{10}" ; 
		     Scanner   scan7  =  new Scanner( mob ) ;
		     String   matched7  =  scan7.findInLine( mobpattern ) ;
		     if ( matched7 == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
		    	 JOptionPane.showMessageDialog(this, "INVALID MOBILE NUMBER\nIt should contain only digits with minimum length of 10 digit.", "Error", JOptionPane.ERROR_MESSAGE);
		         tid5.setText("");
		     }
		     else
		     {
		    	 flagMobile    = true;
		     }
		     
		     
		     
		     
		     /* user nationality check
		      * */
		     String namepattern3 = "^[A-Za-z]";
		     Scanner   scan3  =  new Scanner( nationality ) ;
		     String   matched3  =  scan3.findInLine( namepattern3 ) ;
		     if ( matched3 == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID FIRST NAME\nIt should contain only alphabet.");
		    	 JOptionPane.showMessageDialog(this, "INVALID 	NATIONALITY\nIt should contain only alphabet.", "Error", JOptionPane.ERROR_MESSAGE);
		         tid6.setText("");
		     }
		     else
		     {
		    	 flagNationality = true;
		     }
		     
		     
		     /*for agecheck
		      * */
		     String agepattern = "^[0-9]{2}" ; 
		     Scanner   scan8  =  new Scanner( age ) ;
		     String   matched8  =  scan8.findInLine( agepattern ) ;
		     if ( matched8 == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
		    	 JOptionPane.showMessageDialog(this, "INVALID AGE\nAge must be minimum 10 years & it should contain only digit.", "Error", JOptionPane.ERROR_MESSAGE);
		         tid7.setText("");
		     }
		     else
		     {
		    	 flagAge     = true;
		     }
		     
		     
		     /* user proof check
		      * */
		     String proofpattern2 = "^[A-Za-z0-9]{5}";
		     Scanner   scan9  =  new Scanner( proof ) ;
		     String   matched9  =  scan9.findInLine( proofpattern2 ) ;
		     if ( matched9 == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID FIRST NAME\nIt should contain only alphabet.");
		    	 JOptionPane.showMessageDialog(this, "INVALID IDENTITY PROOF NUMBER\nIT SHOLUD CONTAIN MINIMUM 5 ALPHABET OR DIGIT.", "Error", JOptionPane.ERROR_MESSAGE);
		         tid8.setText("");
		     }
		     else
		     {
		    	 flagProof  = true;
		     }
		     
		     
		     /*for account number check
		      * */
		     String accpattern = "^[0-9]{4}" ; 
		     Scanner   scan4  =  new Scanner( ac1 ) ;
		     String   matched4  =  scan4.findInLine( accpattern ) ;
		     if ( matched4 == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
		    	 JOptionPane.showMessageDialog(this, "INVALID ACCOUNT NUMBER\nIt should contain only digits with minimum length of 4 digit.", "Error", JOptionPane.ERROR_MESSAGE);
		         t1.setText("");
		     }
		     else
		     {
		    	 flagAccountNumber  = true;
		     }
		     
		     
		     
		     /*for initial amount check
		      * */
		     String inipattern = "^[0-9]{3}" ; 
		     Scanner   scan5  =  new Scanner( ini ) ;
		     String   matched5  =  scan5.findInLine( inipattern ) ;
		     if ( matched5 == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
		    	 JOptionPane.showMessageDialog(this, "INVALID INITIAL AMOUNT\nIt should contain only digits with minimum amount of INR 500.", "Error", JOptionPane.ERROR_MESSAGE);
		         tid10.setText("");
		     }
		     else
		     {
		    	 flagInitialAmount   = true;
		     }
		     
		     
		     


		     
		     
		     
		     if(flagName == true)
		     {
		    	 if(flagName1 == true)
		    	 {
		    		 if(flagAddress == true)
		    		 {
		    			 if(flagNationality == true)
		    			 {
		    				 if(flagAccountNumber == true)
		    				 {
		    					 if(flagInitialAmount == true)
		    					 {
		    						 if(flagLandline == true)
		    						 {
		    							 if(flagMobile == true)
		    							 {
		    								 if(flagAge == true)
		    								 {
		    									 if(flagProof == true)
		    									 {
		    										 /**********read from file and store in alist******************/
		    					    				 try
		    					    				 {
		    					    					 FileInputStream fin=new FileInputStream("Regis.dat");
		    					    					 ObjectInputStream oin=new ObjectInputStream(fin);
		    					    					 alist=(ArrayList<Create>)oin.readObject();
		    					    				 }
		    					    				 catch(Exception ex)
		    					    				 {
		    					    					 alist=new ArrayList<Create>();
		    					    				 }
		    					    				 
		    					    				 /*************************************************************/
		    					    				 
		    					    				 
		    					    				 
		    					    				 /********operation********************************************/
		    					    				 
		    					    				 //it checks account numebr is already present or not
		    					    				 for(Create element : alist)
		    					    				 {
		    					    					 if(element.getAc().equals(t1.getText()))
		    					    					 {
		    					    						 count++;
		    					    						 
		    					    					 }
		    					    				 }
		    					    				 
		    					    				 
		    					    				 if(count > 0)//if present
		    					    				 {
		    					    					 JOptionPane.showMessageDialog(this, "Account numner is already registered.\nTry another one", "Error", JOptionPane.ERROR_MESSAGE);
		    				    						 t1.setText("");
		    					    				 }
		    					    				 
		    					    				 else//if not present
		    					    				 {
		    					    					 
		    					    					 	/************variable setting***************************/
		    					    					 
		    					    					 	/******************check the minimum initial amount*******************/
		    				    						 
		    					    					 	if(Integer.parseInt(ini) >= 500)
		    				    						 	{
		    					    					 		inti=tid10.getText();
		    						    						name=tid1.getText();
		    						    						name1=tid2.getText();
		    						    						address=tid3.getText();
		    						    						nationality=tid6.getText();
		    						    						ac1=t1.getText();
		    						    						Iden=(String)identity.getSelectedItem();
		    						    						prof=(String)profession.getSelectedItem();
		    						    						acc="";
		    						    						if(rsav.isSelected())
		    						    						{
		    						    							acc="Savings";
		    						    						}
		    						    						else if(rothers.isSelected())
		    						    						{
		    						    							acc="Others";
		    						    						}
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
		    						    						
		    						    						
		    						    						/*************************************************************************/
		    						    						
		    						    						
		    						    						/*************************packing variable into object***********************/
		    						    						
		    						    						reg=new Create();
		    						    						
		    						    						
		    						    						reg.setName(name);
		    						    						reg.setName1(name1);
		    						    						reg.setAddress(address);
		    						    						reg.setNationality(nationality);
		    						    						reg.setAcctype(acc);
		    						    						reg.setGender(gn);
		    						    						reg.setDob(dob);
		    						    						reg.setIdentity(Iden);
		    						    						reg.setProfession(prof);
		    						    						reg.setAc(ac1);
		    						    						reg.setInitialamnt(inti);
		    						    						reg.setDate(l16.getText());
		    						    						reg.setTime(l17.getText());
		    						    						
		    						    						/*****************************************************************************/
		    						    						
		    						    						int con=JOptionPane.showConfirmDialog(this, "Are You Sure to Register?");
		    						    						if(con==JOptionPane.YES_OPTION)
		    						    						{
		    						    							new AddInformation1(reg);
		    						    						   
		    						    							new Actotalcreate(Integer.parseInt(t1.getText()),0,Integer.parseInt(tid10.getText()),Integer.parseInt(tid10.getText()));//acc ---> Integer.parseInt(t1.getText()), withdrw -----> 0,deposite --------> Integer.parseInt(tid10.getText()),total --------> Integer.parseInt(tid10.getText()) (all are int)
		    						    							new TotalUpdate(Integer.parseInt(t1.getText()),Integer.parseInt(tid10.getText()));
		    						    						   
		    						    						   
		    						    							//setVisible(false);
		    						    							JOptionPane.showMessageDialog(this, "Successfully registered");
		    						    							new Individualpassbook(ac1);
		    						    						   
		    						    							tid10.setText("");
		    						    							tid1.setText("");
		    						    							tid2.setText("");
		    						    							tid3.setText("");
		    						    							tid6.setText("");
		    						    							t1.setText("");
		    						    							tid4.setText("");
		    						    							tid5.setText("");
		    						    							tid7.setText("");
		    						    							tid8.setText("");
		    						    						   
		    						    						
		    						    						}
		    				    						 	}
		    				    						 	else
		    				    						 	{
		    				    							 	JOptionPane.showMessageDialog(this, "Minimum initial amount should be 500", "Error", JOptionPane.ERROR_MESSAGE);
		    				    							 	tid10.setText("");
		    				    						 	}
		    				    						 
		    				    						 
		    				    						 	/*********************************************************************/
		    				    						 
		    					    					 	/*
		    					    					 	inti=tid10.getText();
		    					    						name=tid1.getText();
		    					    						name1=tid2.getText();
		    					    						address=tid3.getText();
		    					    						nationality=tid6.getText();
		    					    						ac1=t1.getText();
		    					    						Iden=(String)identity.getSelectedItem();
		    					    						prof=(String)profession.getSelectedItem();
		    					    						acc="";
		    					    						if(rsav.isSelected())
		    					    						{
		    					    							acc="Savings";
		    					    						}
		    					    						else if(rothers.isSelected())
		    					    						{
		    					    							acc="Others";
		    					    						}
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
		    					    						*/
		    					    						
		    					    						
		    					    						/*************************************************************************/
		    					    						
		    					    						
		    					    						/*************************packing variable into object***********************/
		    					    						
		    					    					 	/*
		    					    						reg=new Create();
		    					    						
		    					    						
		    					    						reg.setName(name);
		    					    						reg.setName1(name1);
		    					    						reg.setAddress(address);
		    					    						reg.setNationality(nationality);
		    					    						reg.setAcctype(acc);
		    					    						reg.setGender(gn);
		    					    						reg.setDob(dob);
		    					    						reg.setIdentity(Iden);
		    					    						reg.setProfession(prof);
		    					    						reg.setAc(ac1);
		    					    						reg.setInitialamnt(inti);
		    					    						reg.setDate(l16.getText());
		    					    						reg.setTime(l17.getText());
		    					    						*/
		    					    						
		    					    						/*****************************************************************************/
		    					    						
		    					    					 	/*
		    					    						int con=JOptionPane.showConfirmDialog(this, "Are You Sure to Register?");
		    					    						if(con==JOptionPane.YES_OPTION)
		    					    						{
		    					    						   new AddInformation1(reg);
		    					    						   //setVisible(false);
		    					    						   JOptionPane.showMessageDialog(this, "Successfully registered");
		    					    						   
		    					    						   tid10.setText("");
		    					    						   tid1.setText("");
		    					    						   tid2.setText("");
		    					    						   tid3.setText("");
		    					    						   tid6.setText("");
		    					    						   t1.setText("");
		    					    						   
		    					    						
		    					    						}
		    					    					 
		    					    					 	*/
		    					    				 }
		    					    				 /*****************************************************************/
		    									 }
		    								 }
		    							 }
		    						 }
		    					 }
		    				 } 
		    			 }
		    		 }
		    	 }
		     }
		     
		     
		     flagName = false;
		     flagName1 = false;
		     flagAddress = false;
		     flagNationality = false;
		     flagAccountNumber = false;
		     flagInitialAmount = false;
		     count =0;
		     flagLandline = false;
		     flagMobile = false;
		     flagAge = false;
		     flagProof = false;
			
			
			
			
			
			
			
			/******************************************previous*********************************/
			/*inti=tid10.getText();
			name=tid1.getText();
			name1=tid2.getText();
			address=tid3.getText();
			nationality=tid6.getText();
			ac1=t1.getText();
			Iden=(String)identity.getSelectedItem();
			prof=(String)profession.getSelectedItem();
			acc="";
			if(rsav.isSelected())
			{
				acc="Savings";
			}
			else if(rothers.isSelected())
			{
				acc="Others";
			}
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
			
			
			reg=new Create();
			reg.setName(name);
			reg.setName1(name1);
			reg.setAddress(address);
			reg.setNationality(nationality);
			reg.setAcctype(acc);
			reg.setGender(gn);
			reg.setDob(dob);
			reg.setIdentity(Iden);
			reg.setProfession(prof);
			reg.setAc(ac1);
			reg.setInitialamnt(inti);
			reg.setDate(l16.getText());
			reg.setTime(l17.getText());
			
        int con=JOptionPane.showConfirmDialog(this, "Are You Sure to Register?");
			
			if(con==JOptionPane.YES_OPTION)
			{
			   new AddInformation1(reg);
			   setVisible(false);
			
			}*/
	
	
	
	}
		if(e.getSource()==back)
		{
			int rply = JOptionPane.showConfirmDialog(this, "Are you sure to quit?");
			if(rply == JOptionPane.YES_OPTION)
			{
				new Userwindow("");
				setVisible(false);
			}
			
		}


}
}
