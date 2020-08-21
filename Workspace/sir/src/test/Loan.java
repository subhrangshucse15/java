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

public class Loan extends JFrame implements ActionListener 
{
	private JLabel l1,l2,l3,l4,l5;
	private JButton bsubmit,bcancel;
	private JComboBox loantype,loanterm;
	private JTextField tid1,tid2,tid3;
	private String acc,amnt,rate;
	ArrayList<LoanData> list2;
	ArrayList<Create> list1;
	ArrayList<LoanData> list4;
	private int x;
	private boolean flagAccNum = false;
	private boolean flagWithdraw = false;
	private boolean flagAccFNum = false;
	
	Loan()
	{
		super("LOAN APPLICATION FORM");
		Container c=getContentPane();
		c.setLayout(new GridLayout(6,2));
		
		tid1=new JTextField();
		tid2=new JTextField();
		tid3=new JTextField();
		
		String ctvalue[]={"1","3","5"};
		loanterm=new JComboBox(ctvalue);
		JPanel gpanel=new JPanel();
		gpanel.add(loanterm);
		gpanel.setBackground(new Color(0,0,64));
		
		String btvalue[]={"Education","Home","Car"};
		loantype=new JComboBox(btvalue);
		JPanel fpanel=new JPanel();
		fpanel.add(loantype);
		fpanel.setBackground(new Color(0,0,64));
		
		bsubmit=new JButton("SUBMIT");
		bsubmit.addActionListener(this);
		JPanel apanel=new JPanel();
		apanel.add(bsubmit);
		apanel.setBackground(new Color(0,0,64));
		
		bcancel=new JButton("CANCEL");
		bcancel.addActionListener(this);
		JPanel bpanel=new JPanel();
		bpanel.add(bcancel);
		bpanel.setBackground(new Color(0,0,64));
		
		Font f1=new Font("comic sans ms",Font.BOLD,14);
		l1=new JLabel("Enter Loan A/c no");
		l1.setFont(f1);
		l1.setForeground(Color.RED);
		JPanel cpanel=new JPanel();
		cpanel.add(l1);
		cpanel.setBackground(new Color(0,0,64));
		l5=new JLabel("Enter Bank A/c no");
		l5.setFont(f1);
		l5.setForeground(Color.RED);
		JPanel c1panel=new JPanel();
		c1panel.add(l5);
		c1panel.setBackground(new Color(0,0,64));
		
		l2=new JLabel("Enter Loan Type");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		JPanel dpanel=new JPanel();
		dpanel.add(l2);
		dpanel.setBackground(new Color(0,0,64));
		
		l3=new JLabel("Enter Loan Term");
		l3.setFont(f1);
		l3.setForeground(Color.RED);
		JPanel epanel=new JPanel();
		epanel.add(l3);
		epanel.setBackground(new Color(0,0,64));
		
		l4=new JLabel("Enter Amount of Loan");
		l4.setFont(f1);
		l4.setForeground(Color.RED);
		JPanel qpanel=new JPanel();
		qpanel.add(l4);
		qpanel.setBackground(new Color(0,0,64));
		c.add(c1panel);c.add(tid3);
		c.add(cpanel);c.add(tid1);
		c.add(dpanel);c.add(fpanel);
		c.add(epanel);c.add(gpanel);
		c.add(qpanel);c.add(tid2);
		c.add(apanel);c.add(bpanel);

		setSize(600,400);
		setLocation(200,200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		

	}
	
	public void actionPerformed(ActionEvent e)
	{
		int r=0,p=0;
		String search=tid3.getText();
		if(e.getSource()==bsubmit)
		{
			/*********************validation check************************/
			
			String vaccNum = tid3.getText();//acc
			String vwithdrw = tid2.getText();//amount
			String vfixed = tid1.getText();//loan acc
			
			
			/*for account number check
		      * */
			String accNumpattern = "^[0-9]{4}" ; 
			Scanner   scan1  =  new Scanner( vaccNum ) ;
			String   matched1  =  scan1.findInLine( accNumpattern ) ;
			if ( matched1 == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID ACCOUNT NUMBER\nIt should contain only digits with minimum length of 4 digit.", "Error", JOptionPane.ERROR_MESSAGE);
				tid3.setText("");
			}
			else
			{
				flagAccNum   = true;
			}
			
			
			/*for fixed account number check
		      * */
			String accfNumpattern = "^[0-9]{5}" ; 
			Scanner   scan0  =  new Scanner( vfixed ) ;
			String   matched0  =  scan0.findInLine( accfNumpattern ) ;
			if ( matched0 == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID LOAN ACCOUNT NUMBER\nIt should contain only digits with minimum length of 5 digit.", "Error", JOptionPane.ERROR_MESSAGE);
				tid1.setText("");
			}
			else
			{
				flagAccFNum   = true;
			}
			
			
			/*for amount check
		      * */
			String withdrawpattern = "^[0-9]{4}" ; 
			Scanner   scan  =  new Scanner( vwithdrw ) ;
			String   matched  =  scan.findInLine( withdrawpattern ) ;
			if ( matched == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID AMOUNT\nIt should contain only digits with minimum loan amount of INR 1000.", "Error", JOptionPane.ERROR_MESSAGE);
				tid2.setText("");
			}
			else
			{
				flagWithdraw    = true;
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
							FileInputStream fin=new FileInputStream("loan.dat");
							ObjectInputStream oin=new ObjectInputStream(fin);
							list2=(ArrayList<LoanData>)oin.readObject();
							//reading all account withdraw info
						}
						catch(Exception e1)
						{
							 x=10; 
							 //list4=new ArrayList<LoanData>();
							//JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						
						if(x!=10)
						{
							for(LoanData re : list2)
							{
								if(re.getAcc().equals(tid1.getText()))
								{
									p++;
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
									String w=(String)loantype.getSelectedItem();
									if(w.equals("Education"))
									{
										acc=tid1.getText();
										amnt=tid2.getText();
										String terms=(String)loanterm.getSelectedItem();
										rate="13.52%";
										new LoanCreate(acc,amnt,w,terms,rate,search);
										//new LoanDisplay();
										r++;
									}
									
									
									if(w.equals("Home"))
									{
										acc=tid1.getText();
										amnt=tid2.getText();
										String terms=(String)loanterm.getSelectedItem();
										rate="9.95%";
										new LoanCreate(acc,amnt,w,terms,rate,search);
										//new LoanDisplay();
										r++;
									}
									
									
									if(w.equals("Car"))
									{
										acc=tid1.getText();
										amnt=tid2.getText();
										String terms=(String)loanterm.getSelectedItem();
										rate="7.65%";
										new LoanCreate(acc,amnt,w,terms,rate,search);
										//new LoanDisplay();
										r++;
									}
								}
								
							}
							
							
							if(r>0)
							{
								JOptionPane.showMessageDialog(this, "LOAN REQUEST SENT FOR APPROVAL");
								//new LoanDisplay();
								tid1.setText("");
								tid2.setText("");
								tid3.setText("");
							}
							else
							{
								JOptionPane.showMessageDialog(this, "LOAN CANNOT BE ISSUED");
								tid1.setText("");
								tid2.setText("");
								tid3.setText("");
							}
							
						}
						else
						{
							JOptionPane.showMessageDialog(this, "LOAN ACCOUNT ALREADY EXIST");
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
			
		
			/*
			try//read from file
			{
				FileInputStream fin=new FileInputStream("loan.dat");
				ObjectInputStream oin=new ObjectInputStream(fin);
				list2=(ArrayList<LoanData>)oin.readObject();
				//reading all account withdraw info
			}
			catch(Exception e1)
			{
				 x=10; 
				 //list4=new ArrayList<LoanData>();
				//JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
			if(x!=10)
			{
				for(LoanData re : list2)
				{
					if(re.getAcc().equals(tid1.getText()))
					{
						p++;
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
						String w=(String)loantype.getSelectedItem();
						if(w.equals("Education"))
						{
							acc=tid1.getText();
							amnt=tid2.getText();
							String terms=(String)loanterm.getSelectedItem();
							rate="13.52%";
							new LoanCreate(acc,amnt,w,terms,rate,search);
							new LoanDisplay();
							r++;
						}
						
						
						if(w.equals("Home"))
						{
							acc=tid1.getText();
							amnt=tid2.getText();
							String terms=(String)loanterm.getSelectedItem();
							rate="9.95%";
							new LoanCreate(acc,amnt,w,terms,rate,search);
							new LoanDisplay();
							r++;
						}
						
						
						if(w.equals("Car"))
						{
							acc=tid1.getText();
							amnt=tid2.getText();
							String terms=(String)loanterm.getSelectedItem();
							rate="7.65%";
							new LoanCreate(acc,amnt,w,terms,rate,search);
							new LoanDisplay();
							r++;
						}
					}
					
				}
				
				
				if(r>0)
				{
					JOptionPane.showMessageDialog(this, "LOAN ISSUED");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "LOAN CANNOT BE ISSUED");
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, "LOAN ACCOUNT ALREADY EXIST");
			}
			*/

		}
				
	        
		if(e.getSource()==bcancel)
		{
			int rply = JOptionPane.showConfirmDialog(this, "Are you sure to quit?");
			if(rply == JOptionPane.YES_OPTION)
			{
				new Request();
				setVisible(false);
			}
		}
	}

}