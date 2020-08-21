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


public class FixedDepo extends JFrame implements ActionListener
{
	private JLabel l1,l2,l3,l4;
	private JTextField tid3,tid1,tid2;
	private JComboBox term;
	private JButton bsubmit,bcancel;
	ArrayList<Create> list1;
	ArrayList<Depo> list2;
	private int amnt,terms,bal,terms1,savingsacc;
	private String depo,account,rate;
	private int x;
	private boolean flagAccNum = false;
	private boolean flagWithdraw = false;
	private boolean flagAccFNum = false;
	public FixedDepo()
	{
		super("FIXED DEPOSIT FORM");
	
		Container c=getContentPane();
		c.setLayout(new GridLayout(5,2));
	
		tid1=new JTextField();
		tid2=new JTextField();
		tid3=new JTextField();
	
		String ctvalue[]={"1","3","5"};
		term=new JComboBox(ctvalue);
		JPanel dpanel=new JPanel();
		dpanel.add(term);
		dpanel.setBackground(new Color(0,0,64));
	
		bsubmit=new JButton("SUBMIT");
		bsubmit.addActionListener(this);
		JPanel epanel=new JPanel();
		epanel.add(bsubmit);
		epanel.setBackground(new Color(0,0,64));
	
		bcancel=new JButton("CANCEL");
		bcancel.addActionListener(this);
		JPanel wpanel=new JPanel();
		wpanel.add(bcancel);
		wpanel.setBackground(new Color(0,0,64));
	
		Font f1=new Font("comic sans ms",Font.BOLD,14);
		l1=new JLabel("Enter A/c no");
		l1.setFont(f1);
		l1.setForeground(Color.RED);
		JPanel apanel=new JPanel();
		apanel.add(l1);
		apanel.setBackground(new Color(0,0,64));
	
		l2=new JLabel("Enter Amount");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		JPanel bpanel=new JPanel();
		bpanel.add(l2);
		bpanel.setBackground(new Color(0,0,64));
	
		l3=new JLabel("Enter Term");
		l3.setFont(f1);
		l3.setForeground(Color.RED);
		JPanel cpanel=new JPanel();
		cpanel.add(l3);
		cpanel.setBackground(new Color(0,0,64));
	
		l4=new JLabel("Enter Fixed Deposit A/C no");
		l4.setFont(f1);
		l4.setForeground(Color.RED);
		JPanel lpanel=new JPanel();
		lpanel.add(l4);
		lpanel.setBackground(new Color(0,0,64));
	
		c.add(apanel);c.add(tid1);
		c.add(bpanel);c.add(tid2);
		c.add(cpanel);c.add(dpanel);
		c.add(lpanel);c.add(tid3);
		c.add(epanel);c.add(wpanel);
	
		setSize(600,400);
		setLocation(200,200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		


	}


	
	public void actionPerformed(ActionEvent e)
	{
		String search=tid1.getText();
		String dup=tid3.getText();
		int r=0,p=0;
		
		
		if(e.getSource()==bsubmit)
		{
			/*********************validation check************************/
			
			String vaccNum = tid1.getText();
			String vwithdrw = tid2.getText();
			String vfixed = tid3.getText();
			
			
			/*for account number check
		      * */
			String accNumpattern = "^[0-9]{4}" ; 
			Scanner   scan1  =  new Scanner( vaccNum ) ;
			String   matched1  =  scan1.findInLine( accNumpattern ) ;
			if ( matched1 == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID ACCOUNT NUMBER\nIt should contain only digits with minimum length of 4 digit.", "Error", JOptionPane.ERROR_MESSAGE);
				tid1.setText("");
			}
			else
			{
				flagAccNum   = true;
			}
			
			/*for amount check
		      * */
			String withdrawpattern = "^[0-9]{3}" ; 
			Scanner   scan  =  new Scanner( vwithdrw ) ;
			String   matched  =  scan.findInLine( withdrawpattern ) ;
			if ( matched == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID WITHDRAW AMOUNT\nIt should contain only digits with minimum fixed deposit amount of INR 100.", "Error", JOptionPane.ERROR_MESSAGE);
				tid2.setText("");
			}
			else
			{
				flagWithdraw    = true;
			}
			
			/*for fixed account number check
		      * */
			String accfNumpattern = "^[0-9]{5}" ; 
			Scanner   scan0  =  new Scanner( vfixed ) ;
			String   matched0  =  scan0.findInLine( accfNumpattern ) ;
			if ( matched0 == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID FIXED DEPOSITE ACCOUNT NUMBER\nIt should contain only digits with minimum length of 5 digit.", "Error", JOptionPane.ERROR_MESSAGE);
				tid3.setText("");
			}
			else
			{
				flagAccFNum   = true;
			}
			
			
			
			
			/********************************************************************************/
			
			
			
			
			/************************IF VALIDATION SUCCESSFUL*****************************************/
			
			if(flagAccNum == true)
			{
				if(flagWithdraw == true)
				{
					if(flagAccFNum == true)
					{
						try//read from file
						{
							FileInputStream fin=new FileInputStream("fixed.dat");
							ObjectInputStream oin=new ObjectInputStream(fin);
							list2=(ArrayList<Depo>)oin.readObject();
							//reading all account withdraw info
						}
						catch(Exception e1)
						{
							x=10;
							//JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						
						if(x!=10)
						{
							for(Depo re : list2)
							{
								if(re.getFixeddepoacc().equals(dup))
								{
									p++;
									//JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
						
						
						if(p==0)
						{
							try//read from file
							{
								FileInputStream fin=new FileInputStream("Regis.dat");
								ObjectInputStream oin=new ObjectInputStream(fin);
								list1=(ArrayList<Create>)oin.readObject();
								//reading all account withdraw info
							}
							catch(Exception e1)
							{
								JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
							}
								
							for(Create re : list1)
							{
								if(re.getAc().equals(search))
								{
									amnt=Integer.parseInt(re.getInitialamnt());
									//String amnt1=String.valueOf(amnt);
									savingsacc=Integer.parseInt(search);
									String terms=(String)term.getSelectedItem();
									terms1=Integer.parseInt(terms);
									depo=tid2.getText();
									int depo1=Integer.parseInt(depo);
									account=tid3.getText();
									if(terms1==1)
									{				
										if(amnt>500)
										{
											rate="7";
											bal=amnt-depo1;
											String bal1=String.valueOf(bal);
											if(bal>=500)
											{
												int search1=Integer.parseInt(search);
												new Actotalcreate(search1,depo1,0,bal);
												new DepoCreate(search,account,bal1,depo,terms,rate);
												new TotalUpdate(savingsacc,bal);
												new LockerUpdate(search1,bal);
												//new DepoDisplay();
												r++;
											}
										}
									}
									
									
									if(terms1==3)
									{				
										if(amnt>500)
										{
											rate="7.5";
											bal=amnt-depo1;
											String bal1=String.valueOf(bal);
											if(bal>=500)
											{
												int search1=Integer.parseInt(search);
												new Actotalcreate(search1,depo1,0,bal);
												new DepoCreate(search,account,bal1,depo,terms,rate);
												new TotalUpdate(savingsacc,bal);
												new LockerUpdate(search1,bal);
												//new DepoDisplay();
												r++;
											}
										}
									}
									
									
									if(terms1==5)
									{				
										if(amnt>500)
										{
											rate="8";
											bal=amnt-depo1;
											String bal1=String.valueOf(bal);
											if(bal>=500)
											{
												int search1=Integer.parseInt(search);
												new Actotalcreate(search1,depo1,0,bal);
												new DepoCreate(search,account,bal1,depo,terms,rate);
												new TotalUpdate(savingsacc,bal);
												new LockerUpdate(search1,bal);
												//new DepoDisplay();
												r++;
											}
										}
									}
										
										
								}
									
							}
							
							
							if(r==1)
							{
								JOptionPane.showMessageDialog(this, "FIXED DEPOSIT COMPLETE");
								new DepoDisplay();
								tid1.setText("");
								tid2.setText("");
								tid3.setText("");
							}
							else
							{
								JOptionPane.showMessageDialog(this, "FIXED DEPOSIT CANNOT BE MADE");
								tid1.setText("");
								tid2.setText("");
								tid3.setText("");
							}

						}
						
						else
						{
							JOptionPane.showMessageDialog(this, "FIXED DEPOSIT A/C already exists");
							tid1.setText("");
							tid2.setText("");
							tid3.setText("");
						}
					}
					
				}
			}
			
			flagAccNum = false;
			flagWithdraw = false;
			flagAccFNum = false;
			
			
			/*************************************************************///////////////////////////////////////
			/*
			try//read from file
			{
				FileInputStream fin=new FileInputStream("fixed.dat");
				ObjectInputStream oin=new ObjectInputStream(fin);
				list2=(ArrayList<Depo>)oin.readObject();
				//reading all account withdraw info
			}
			catch(Exception e1)
			{
				x=10;
				//JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
			if(x!=10)
			{
				for(Depo re : list2)
				{
					if(re.getFixeddepoacc().equals(dup))
					{
						p++;
						//JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
			
			if(p==0)
			{
				try//read from file
				{
					FileInputStream fin=new FileInputStream("Regis.dat");
					ObjectInputStream oin=new ObjectInputStream(fin);
					list1=(ArrayList<Create>)oin.readObject();
					//reading all account withdraw info
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
				}
					
				for(Create re : list1)
				{
					if(re.getAc().equals(search))
					{
						amnt=Integer.parseInt(re.getInitialamnt());
						//String amnt1=String.valueOf(amnt);
						savingsacc=Integer.parseInt(search);
						String terms=(String)term.getSelectedItem();
						terms1=Integer.parseInt(terms);
						depo=tid2.getText();
						int depo1=Integer.parseInt(depo);
						account=tid3.getText();
						if(terms1==1)
						{				
							if(amnt>500)
							{
								rate="7";
								bal=amnt-depo1;
								String bal1=String.valueOf(bal);
								if(bal>=500)
								{
									int search1=Integer.parseInt(search);
									new Actotalcreate(search1,depo1,0,bal);
									new DepoCreate(search,account,bal1,depo,terms,rate);
									new TotalUpdate(savingsacc,bal);
									new LockerUpdate(search1,bal);
									new DepoDisplay();
									r++;
								}
							}
						}
						
						
						if(terms1==3)
						{				
							if(amnt>500)
							{
								rate="7.5";
								bal=amnt-depo1;
								String bal1=String.valueOf(bal);
								if(bal>=500)
								{
									int search1=Integer.parseInt(search);
									new Actotalcreate(search1,depo1,0,bal);
									new DepoCreate(search,account,bal1,depo,terms,rate);
									new TotalUpdate(savingsacc,bal);
									new LockerUpdate(search1,bal);
									new DepoDisplay();
									r++;
								}
							}
						}
						
						
						if(terms1==5)
						{				
							if(amnt>500)
							{
								rate="8";
								bal=amnt-depo1;
								String bal1=String.valueOf(bal);
								if(bal>=500)
								{
									int search1=Integer.parseInt(search);
									new Actotalcreate(search1,depo1,0,bal);
									new DepoCreate(search,account,bal1,depo,terms,rate);
									new TotalUpdate(savingsacc,bal);
									new LockerUpdate(search1,bal);
									new DepoDisplay();
									r++;
								}
							}
						}
							
							
					}
						
				}
				
				
				if(r==1)
				{
					JOptionPane.showMessageDialog(this, "FIXED DEPOSIT COMPLETE");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "FIXED DEPOSIT CANNOT BE MADE");
				}

			}
			
			else
			{
				JOptionPane.showMessageDialog(this, "FIXED DEPOSIT A/C already exists");	
			}
			*/
		}
		
		if(e.getSource()==bcancel)
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

