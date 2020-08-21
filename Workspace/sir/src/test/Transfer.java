package test;
import java.awt.Color;
import java.util.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener; //to sense mouse click
import java.awt.event.ActionEvent; 
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Calendar;

import javax.swing.*;
public class Transfer extends JFrame implements ActionListener
{
	private JLabel l1,l2,l3;
	private JTextField tid1,tid2,tid3;
	private JButton bsubmit,bBack;
	private int x,r=0,c=0,sourceamnt,destamnt,tran,t,acc,d=0,w=0;
	ArrayList<Create> list1;
	private boolean flagSource = false;
	private boolean flagDestination = false;
	private boolean flagAmount = false;
	private boolean flagSourceMatch = false;
	private boolean flagDestinationMatch = false;
	private boolean flagSourceAmountMatch = false;
	private boolean flagSourceInsufficientBalance = false;
	public Transfer()
	{
		super("Money Transfer");
		
		
		tid1=new JTextField();
		tid2=new JTextField();
		tid3=new JTextField();
		
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(4,2));
		
		
		bsubmit=new JButton("Submit");
		bsubmit.addActionListener(this); 
		JPanel epanel=new JPanel();
		epanel.add(bsubmit);
		epanel.setBackground(new Color(0,0,64));
		
		
		bBack = new JButton("Back");
		bBack.addActionListener(this);
		JPanel fpanel=new JPanel();
		fpanel.add(bBack);
		fpanel.setBackground(new Color(0,0,64));
		
		
		
		Font f1=new Font("comic sans ms",Font.BOLD,14);
		l1=new JLabel("Enter Source A/C no");
		l1.setFont(f1);
		l1.setForeground(Color.RED);
		JPanel gpanel=new JPanel();
		gpanel.add(l1);
		gpanel.setBackground(new Color(0,0,64));
		
		
		
		l2=new JLabel("Enter Destination A/C no");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		JPanel apanel=new JPanel();
		apanel.add(l2);
		apanel.setBackground(new Color(0,0,64));
		
		
		
		l3=new JLabel("Enter Amount to be Transferred");
		l3.setFont(f1);
		l3.setForeground(Color.RED);
		JPanel bpanel=new JPanel();
		bpanel.add(l3);
		bpanel.setBackground(new Color(0,0,64));
		
		
		
		
		c.add(gpanel);c.add(tid1);
		c.add(apanel);c.add(tid2);
		c.add(bpanel);c.add(tid3);
		c.add(epanel);c.add(fpanel);
		
		
		setSize(500, 425);
		setLocation(600,200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		String source,dest;
		source=tid1.getText();
		dest=tid2.getText();
		if(e.getSource()==bsubmit)
		{
			/*********************validation check************************/
			
			String vSource = tid1.getText();
			String vDestination = tid2.getText();
			String vAmount = tid3.getText();
			
			
			/*for source account number check
		      * */
			String sourcepattern = "^[0-9]{4}" ; 
			Scanner   scan  =  new Scanner( vSource) ;
			String   matched =  scan.findInLine( sourcepattern ) ;
			if ( matched == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID SOURCE ACCOUNT NUMBER\nIt should contain only digits with minimum length of 4 digit.", "Error", JOptionPane.ERROR_MESSAGE);
				tid1.setText("");
			}
			else
			{
				flagSource    = true;
			}
			
			
			/*for destination account number check
		      * */
			String destinationpattern = "^[0-9]{4}" ; 
			Scanner   scan1  =  new Scanner( vDestination) ;
			String   matched1 =  scan1.findInLine( destinationpattern ) ;
			if ( matched1 == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID DESTINATION ACCOUNT NUMBER\nIt should contain only digits with minimum length of 4 digit.", "Error", JOptionPane.ERROR_MESSAGE);
				tid2.setText("");
			}
			else
			{
				flagDestination    = true;
			}
			
			
			/*for amount check
		      * */
			String amountwpattern = "^[0-9]{3}" ; 
			Scanner   scan2  =  new Scanner( vAmount ) ;
			String   matched2  =  scan2.findInLine( amountwpattern ) ;
			if ( matched2 == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID AMOUNT\nIt should contain only digits with minimum amount of INR 100.", "Error", JOptionPane.ERROR_MESSAGE);
				tid3.setText("");
			}
			else
			{
				flagAmount    = true;
			}
			
			
			
			/************************IF VALIDATION SUCCESSFUL*****************************************/
			
			
			if(flagSource == true)
			{
				if(flagDestination == true)
				{
					if(flagAmount == true)
					{
						try		
						{
							  FileInputStream fin=new FileInputStream("Regis.dat");
							  ObjectInputStream oin=new ObjectInputStream(fin);
							  list1=(ArrayList<Create>)oin.readObject();
						}
						catch(Exception e1){}
						
						//JOptionPane.showMessageDialog(this, "source   " + source);
						
						for(Create re : list1)
						{
							//JOptionPane.showMessageDialog(this, "source loop");
							
							
							if(re.getAc().equals(source))
							{
								
								//JOptionPane.showMessageDialog(this, "source loop if");
								
								flagSourceMatch = true;
								for(Create re2 : list1)
								{
									
									//JOptionPane.showMessageDialog(this, "destination loop");
									
									if(re2.getAc().equals(dest))
									{
										//JOptionPane.showMessageDialog(this, "destination loop if");
										
										
										flagDestinationMatch = true;
										
										sourceamnt=Integer.parseInt(re.getInitialamnt());	
										destamnt=Integer.parseInt(re2.getInitialamnt());
										
										if(sourceamnt>500)
										{
											//JOptionPane.showMessageDialog(this, "if 500");
											
											
											flagSourceAmountMatch = true;
											
											
											tran=Integer.parseInt(tid3.getText());
											t=sourceamnt-tran;
											if((t>0)&&(t>=500))
											{
												
												//JOptionPane.showMessageDialog(this, "t>0");
												
												flagSourceInsufficientBalance = true;
												
												acc=Integer.parseInt(tid1.getText());
												new TotalUpdate(acc,t);
												new Actotalcreate(acc,tran,d,t);
												t=destamnt+tran;
												
												
												acc=Integer.parseInt(tid2.getText());
												new TotalUpdate(acc,t);
												new Actotalcreate(acc,w,tran,t);
												r++;
												
											}

										}
											
									}
										
								}

							}
						}
						
						if(r==1)
						{
							JOptionPane.showMessageDialog(this, "MONEY TRANSFERED SUCCESSFULLY");
							tid1.setText("");
							tid2.setText("");
							tid3.setText("");
							JOptionPane.showMessageDialog(this, "Showing both account holders passbook.");
							new Individualpassbook(source);
							//JOptionPane.showMessageDialog(this, "Showing destination account holders passbook.");
							new Individualpassbook(dest);
						}
						
						
						if(flagSourceMatch == false)
						{
							JOptionPane.showMessageDialog(this, "Source account does not match", "Source account error", JOptionPane.ERROR_MESSAGE);
							
							tid1.setText("");
							//tid2.setText("");
							//tid3.setText("");
						}
						
						if(flagSourceMatch == true && flagDestinationMatch == true && flagSourceAmountMatch == false)///////////////
						{
							JOptionPane.showMessageDialog(this, "Source account does not have minimum balance of INR 500", "Insufficient balance error", JOptionPane.ERROR_MESSAGE);
							
							tid1.setText("");
							tid2.setText("");
							tid3.setText("");
						}
						
						else if(flagSourceMatch == true && flagDestinationMatch == true && flagSourceAmountMatch == true && flagSourceInsufficientBalance == false)///////////////////
						{
							JOptionPane.showMessageDialog(this, "Insufficient balance of source account to transfer money.", "nsufficient balance error", JOptionPane.ERROR_MESSAGE);
							
							//tid1.setText("");
							//tid2.setText("");
							tid3.setText("");
						}
						
						if(flagSourceMatch == true && flagDestinationMatch == false)
						{
							JOptionPane.showMessageDialog(this, "Destination account does not match", "Destination account error", JOptionPane.ERROR_MESSAGE);
							
							//tid1.setText("");
							tid2.setText("");
							//tid3.setText("");
						}
						
						/*************DADU ELSE*******************/
						/*
						else
						{
							JOptionPane.showMessageDialog(this, "MONEY TRANSFER FAILED");
						}
						*/
						
						/**********************************************/
						
						
					}
				}
			}
			
			flagSource = false;
			flagDestination = false;
			flagAmount = false;
			flagSourceMatch = false;
			flagDestinationMatch = false;
			flagSourceAmountMatch = false;
			flagSourceInsufficientBalance = false;
			r=0;
			
			
			/********************************************************************/
			
			/*
			try		
			{
				  FileInputStream fin=new FileInputStream("Regis.dat");
				  ObjectInputStream oin=new ObjectInputStream(fin);
				  list1=(ArrayList<Create>)oin.readObject();
			}
			catch(Exception e1)
			{
					 
			}
			
			
			//x = list1.size();
			
			
			for(Create re : list1)
			{
				if(re.getAc().equals(source))
				{
					for(Create re2 : list1)
					{
						if(re2.getAc().equals(dest))
						{
							sourceamnt=Integer.parseInt(re.getInitialamnt());	
							destamnt=Integer.parseInt(re2.getInitialamnt());
							if(sourceamnt>500)
							{
								tran=Integer.parseInt(tid3.getText());
								t=sourceamnt-tran;
								if(t>0)
								{
									acc=Integer.parseInt(tid1.getText());
									new TotalUpdate(acc,t);
									new Actotalcreate(acc,tran,d,t);
									t=destamnt+tran;
									acc=Integer.parseInt(tid2.getText());
									new TotalUpdate(acc,t);
									new Actotalcreate(acc,w,tran,t);
									r++;
									
								}

							}
								
						}
							
					}

				}
									}
				if(r==1)
				{
					JOptionPane.showMessageDialog(this, "MONEY TRANSFERRED");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "MONEY TRANSFER FAILED");
				}
				*/
				
				
				
				/********************previous******************************/
				
				/*try
				
				{
					  FileInputStream fin=new FileInputStream("Regis.dat");
					  ObjectInputStream oin=new ObjectInputStream(fin);
					  list1=(ArrayList<Create>)oin.readObject();
					}
					catch(Exception e1)
					{
						 
					}
					x = list1.size();
					for(Create re : list1)
					{
						if(re.getAc().equals(source))
						{
							
							tran=Integer.parseInt(tid3.getText());
							t=sourceamnt-tran;
							acc=Integer.parseInt(tid1.getText());
							new TotalUpdate(acc,t);
							r++;
						}
					}
						if(r>0)
						{
							try
							
							{
								  FileInputStream fin=new FileInputStream("Regis.dat");
								  ObjectInputStream oin=new ObjectInputStream(fin);
								  list1=(ArrayList<Create>)oin.readObject();
								}
								catch(Exception e1)
								{
									 
								}
								x = list1.size();
								for(Create re1 : list1)
								{
									if(re1.getAc().equals(dest))
									{
										
										tran=Integer.parseInt(tid3.getText());
										t=destamnt+tran;
										acc=Integer.parseInt(tid2.getText());
										new TotalUpdate(acc,t);
										c++;
									}	
						}
			}
	if(c>0)
	{
		JOptionPane.showMessageDialog(this, "MONEY TRANSFERRED");

	}
	else
	{
		JOptionPane.showMessageDialog(this, "MONEY TRANSFERRED FAILED");

	}
	

}*/
				/**********************************************************/

		}
		
		
		if(e.getSource() == bBack)
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
