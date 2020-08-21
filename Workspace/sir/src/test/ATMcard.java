package test;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.*;

import javax.swing.*;
public class ATMcard extends JFrame implements ActionListener

{
	private JLabel l0,l1;
	private JButton bsubmit,bcancel;
	private JTextField t1;
	private JComboBox type;
	ArrayList<Create> list1;
	int r,account,amnt,t,p,d=0,k,l;
	private boolean flagAccNum = false;
	private boolean flagAmountBefore = false;
	private boolean flagDomestic = false;
	private boolean flagSilverInternational = false;
	private boolean flagGoldInternational = false;
	private boolean flagSearchAcc = false;
	public ATMcard()
	{
		super("ATM Card Request");
		
		
		Container c=getContentPane();
	    c.setLayout(new GridLayout(3,2));
	    
		t1=new JTextField();
		
		bsubmit=new JButton("SUBMIT");
		bsubmit.addActionListener(this);
		JPanel bpanel=new JPanel();
		bpanel.add(bsubmit);
		bpanel.setBackground(new Color(0,0,64));
		
		
		bcancel=new JButton("CANCEL");
		bcancel.addActionListener(this);
		JPanel cpanel=new JPanel();
		cpanel.add(bcancel);
		cpanel.setBackground(new Color(0,0,64));
		
		
		Font f1=new Font("comic sans ms",Font.BOLD,14);
		l0=new JLabel("Enter A/C no");
		l0.setFont(f1);
		l0.setForeground(Color.RED);
		JPanel dpanel=new JPanel();
		dpanel.add(l0);
		dpanel.setBackground(new Color(0,0,64));
		
		
		l1=new JLabel("Enter Name");
		l1.setFont(f1);
		l1.setForeground(Color.RED);
		JPanel epanel=new JPanel();
		epanel.add(l1);
		epanel.setBackground(new Color(0,0,64));
		

		String cvalue[]={"Domestic","Silver International","Gold International"};
		type=new JComboBox(cvalue);
		JPanel fpanel=new JPanel();
		fpanel.add(type);
		fpanel.setBackground(new Color(0,0,64));
		
		
		c.add(dpanel);c.add(t1);
		c.add(epanel);c.add(fpanel);
		c.add(bsubmit);c.add(bcancel);
		
		setSize(400,200);
		setLocation(100,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	
	public void actionPerformed(ActionEvent e)
	{
		r=0;
		k=0;
		l=0;
		if(e.getSource()==bsubmit)
		{
			String search=t1.getText();
			r=0;
			
			/*********************validation check************************/
			
			String vAccNum = t1.getText();
			
			
			/*for account number check
		      * */
			String accNumpattern = "^[0-9]{4}" ; 
			Scanner   scan1  =  new Scanner( vAccNum ) ;
			String   matched1  =  scan1.findInLine( accNumpattern ) ;
			if ( matched1 == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID ACCOUNT NUMBER\nIt should contain only digits with minimum length of 4 digit.", "Error", JOptionPane.ERROR_MESSAGE);
				t1.setText("");
			}
			else
			{
				flagAccNum    = true;
			}
			
			
			
			/********************************************************************************/
			
			/************************IF VALIDATION SUCCESSFUL*****************************************/
			
			if(flagAccNum == true)
			{
				
				try
				{
					FileInputStream fin=new FileInputStream("Regis.dat");
					ObjectInputStream oin=new ObjectInputStream(fin);
					list1=(ArrayList<Create>)oin.readObject();
				}	
				catch(Exception e1) {}
				
				
				for(Create re : list1)
				{
					if(re.getAc().equals(search))
					{
						flagSearchAcc = true;
						
						account=Integer.parseInt(t1.getText());
						amnt=Integer.parseInt(re.getInitialamnt());
						String w=(String)type.getSelectedItem();
						
						
						
						if(amnt>500)
						{
							flagAmountBefore = true;
							
							if(w.equals("Domestic"))
							{
								p=50;
								t=amnt-p;//t=510-50 = 460
								if(t>=500)
								{
									new Actotalcreate(account,p,d,t);
									new TotalUpdate(account,t);
									
									flagDomestic = true;
									
									r++;
								}
							}
							
							
							if(w.equals("Silver International"))
							{
								p=100;
								t=amnt-p;
								if(t>=500)
								{
									new Actotalcreate(account,p,d,t);
									new TotalUpdate(account,t);
									
									flagSilverInternational = true;
									
									k++;
								}
									
							}

							
							if(w.equals("Gold International"))
							{
								p=500;
								t=amnt-p;
								if(t>=500)
								{
									new Actotalcreate(account,p,d,t);
									new TotalUpdate(account,t);
									
									flagGoldInternational = true;
									
									l++;
								}
							}
							
						}
						
						/*
						if((r==1)||(k==1)||(l==1))
						{
							JOptionPane.showMessageDialog(this, "ATM has been issued");
						}
						else
						{
							JOptionPane.showMessageDialog(this, "ATM cannot be issued");
						}
						*/
						
					}
					
				}
				
				/**************************MSG DISPLAY*********************/
				
				
				if(flagSearchAcc == false)
				{
					JOptionPane.showMessageDialog(this, "Account number doest not exist.", "Error", JOptionPane.ERROR_MESSAGE);
					t1.setText("");
				}
				
				
				if((flagSearchAcc == true) && (flagAmountBefore == false))
				{
					JOptionPane.showMessageDialog(this, "Account balane must be  above INR 500 after issuing ATM Card.", "In sufficient balance error", JOptionPane.ERROR_MESSAGE);
					t1.setText("");
				}
				
				/*****************/
				
				if((flagDomestic == true))
				{
					JOptionPane.showMessageDialog(this, "ATM Card successfully issued.\nYou have been charged INR 50.");
					
					new Passdisp(t1.getText());
					t1.setText("");
				}
				
				
				if((flagSilverInternational == true))
				{
					JOptionPane.showMessageDialog(this, "ATM Card successfully issued.\nYou have been charged INR 100.");
					
					new Passdisp(t1.getText());
					t1.setText("");
				}
				
				
				if((flagGoldInternational == true))
				{
					JOptionPane.showMessageDialog(this, "ATM Card successfully issued.\nYou have been charged INR 500.");
					
					new Passdisp(t1.getText());
					t1.setText("");
				}
				
				
				if((flagSearchAcc == true) && (flagDomestic == false) && (flagSilverInternational == false) && (flagGoldInternational == false))
				{
					JOptionPane.showMessageDialog(this, "ATM Card cannot be issued for insufficient balance.", "In sufficient balance error", JOptionPane.ERROR_MESSAGE);
					t1.setText("");
				}
				
				
				/***************************************************************/
				
				
				flagSearchAcc = false;
				flagAccNum = false;
				flagDomestic = false;
				flagSilverInternational = false;
				flagGoldInternational = false;
				
			}
			flagSearchAcc = false;
			
			
			
			
			
			/********************PREVIOUS**************************/
			
			/*
			
			try
			{
				FileInputStream fin=new FileInputStream("Regis.dat");
				ObjectInputStream oin=new ObjectInputStream(fin);
				list1=(ArrayList<Create>)oin.readObject();
			}	
			catch(Exception e1) {}
			
			
			for(Create re : list1)
			{
				if(re.getAc().equals(search))
				{
					
					account=Integer.parseInt(t1.getText());
					amnt=Integer.parseInt(re.getInitialamnt());
					String w=(String)type.getSelectedItem();
					
					
					
					if(amnt>500)
					{
						
						if(w.equals("Domestic"))
						{
							p=50;
							t=amnt-p;
							if(t>=500)
							{
								new Actotalcreate(account,p,d,t);
								new TotalUpdate(account,t);
								r++;
							}
						}
						
						
						if(w.equals("Silver International"))
						{
							p=100;
							t=amnt-p;
							if(t>=500)
							{
								new Actotalcreate(account,p,d,t);
								new TotalUpdate(account,t);
								k++;
							}
								
						}

						
						if(w.equals("Gold International"))
						{
							p=500;
							t=amnt-p;
							if(t>=500)
							{
								new Actotalcreate(account,p,d,t);
								new TotalUpdate(account,t);
								l++;
							}
						}
						
					}
					
					
					if((r==1)||(k==1)||(l==1))
					{
						JOptionPane.showMessageDialog(this, "ATM has been issued");
					}
					else
					{
						JOptionPane.showMessageDialog(this, "ATM cannot be issued");
					}
					
				}
				
			}
			
			
			*/
			
		}
		
		
		if(e.getSource()==bcancel)
		{
			int con=JOptionPane.showConfirmDialog(this, "Are you sure to cancel?");
			
			if(con==JOptionPane.YES_OPTION)
			{
			   new Request();
			   setVisible(false);
			}
		}
		
	}
	
}
