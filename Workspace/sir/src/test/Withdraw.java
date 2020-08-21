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

public class Withdraw extends JFrame implements ActionListener
{
	private JLabel l1,l2,l3,l4;
	private JTextField t1,t2;
	private JButton withdraw,cancel,deposit;
	private int x,amnt,t,w,account,d,r=0;
	ArrayList<Create> list1;
	private boolean flagWithdraw = false;
	private boolean flagAccNum = false;
	private boolean flagYes = false;
	private boolean flagAccMatch = false;
	private boolean flagNo = false;

	public Withdraw()
	{
		super("DEPOSIT/WITHDRAWAL SLIP");
		
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(4,2));
		
		Font f1=new Font("Times New Roman",Font.BOLD,20);
		/*l1=new JLabel("                   WITHDRAWAL");
		l1.setFont(f1);
		l1.setForeground(Color.GRAY);
		JPanel fpanel=new JPanel();
		fpanel.add(l1);
		fpanel.setBackground(new Color(0,0,64));
		
		l1=new JLabel("SLIP                  ");
		l1.setFont(f1);
		l1.setForeground(Color.GRAY);
		JPanel apanel=new JPanel();
		apanel.add(l1);
		apanel.setBackground(new Color(0,0,64));*/
		
		l1=new JLabel("Enter ACCOUNT NO:");
		l1.setFont(f1);
		l1.setForeground(Color.GRAY);
		JPanel bpanel=new JPanel();
		bpanel.add(l1);
		bpanel.setBackground(new Color(0,0,64));
		
		l2=new JLabel("ENTER AMOUNT:");
		l2.setFont(f1);
		l2.setForeground(Color.GRAY);
		JPanel b1panel=new JPanel();
		b1panel.add(l2);
		b1panel.setBackground(new Color(0,0,64));
		
		l3=new JLabel("DEPOSIT:");
		l3.setFont(f1);
		l3.setForeground(Color.GRAY);
		JPanel b2panel=new JPanel();
		b2panel.add(l3);
		b2panel.setBackground(new Color(0,0,64));
	
		t1=new JTextField();
		t2=new JTextField();
		
		withdraw=new JButton("WITHDRAW");
		withdraw.addActionListener(this);
		JPanel dpanel=new JPanel();
		dpanel.add(withdraw);
		dpanel.setBackground(new Color(0,0,64));
		
		deposit=new JButton("DEPOSIT");
		deposit.addActionListener(this);
		JPanel d1panel=new JPanel();
		d1panel.add(deposit);
		d1panel.setBackground(new Color(0,0,64));
		
		cancel=new JButton("CANCEL");
		cancel.addActionListener(this);
		JPanel epanel=new JPanel();
		epanel.add(cancel);
		epanel.setBackground(new Color(0,0,64));
		
		l4=new JLabel("");
		l4.setFont(f1);
		l4.setForeground(Color.GRAY);
		JPanel b3panel=new JPanel();
		b3panel.add(l4);
		b3panel.setBackground(new Color(0,0,64));
		
		
		c.add(bpanel);c.add(t1);
		c.add(b1panel);c.add(t2);
		c.add(dpanel);c.add(d1panel);
		c.add(epanel);c.add(b3panel);
		
		setSize(500,500);
		setLocation(100,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}



	public void actionPerformed(ActionEvent e) 
	{
		//Create rg1=new Create();

		//String data[][];
		//String heading[]={"First Name","Last name","Address","Nationality","Account Type","Date Of Birth","Identity","Profession","Reg Date","Reg Time","A/c no","Initial amnt"};
		

		String search=t1.getText();//search  ------->account number
		if(e.getSource()==withdraw)
		{
			
			/*********************validation check************************/
			
			String vaccNum = t1.getText();
			String vwithdrw = t2.getText();
			
			
			/*for account number check
		      * */
			String accNumpattern = "^[0-9]{4}" ; 
			Scanner   scan1  =  new Scanner( vaccNum ) ;
			String   matched1  =  scan1.findInLine( accNumpattern ) ;
			if ( matched1 == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID ACCOUNT NUMBER\nIt should contain only digits with minimum length of 4 digit.", "Error", JOptionPane.ERROR_MESSAGE);
				t1.setText("");
			}
			else
			{
				flagAccNum   = true;
			}
			
			/*for withdraw amount check
		      * */
			String withdrawpattern = "^[0-9]{3}" ; 
			Scanner   scan  =  new Scanner( vwithdrw ) ;
			String   matched  =  scan.findInLine( withdrawpattern ) ;
			if ( matched == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID WITHDRAW AMOUNT\nIt should contain only digits with minimum withdraw amount of INR 100.", "Error", JOptionPane.ERROR_MESSAGE);
				t2.setText("");
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
					try//read from file
					{
						FileInputStream fin=new FileInputStream("Regis.dat");
						ObjectInputStream oin=new ObjectInputStream(fin);
						list1=(ArrayList<Create>)oin.readObject();
						//reading all account withdraw info
						
						
						/***sukanta************/
						
						//x = list1.size();
						
						for(Create re : list1)
						{
							if(re.getAc().equals(search))
							{
								flagAccMatch  = true;
								
								w=Integer.parseInt(t2.getText());
								amnt=Integer.parseInt(re.getInitialamnt());
								if(amnt>=500)
								{
									flagNo  = true;
									
									t = amnt - w;
									
									if(t >= 500)
									{
										account=Integer.parseInt(t1.getText());
										d=0;
										//r++;
										flagYes = true;
									}
									
									/*
									if(amnt>w)
									{
										
										t=(amnt-w);
									
										account=Integer.parseInt(t1.getText());
										d=0;
										r++;
								
									}
									else
									{
										r=0;
										JOptionPane.showMessageDialog(this, "Insufficient Balance", "Error", JOptionPane.ERROR_MESSAGE);
									}
									*/
								}
							}
						}
						
						
						/********msg display and argu pass**************************************/
						
						if((flagAccMatch == true) && (flagNo == true) && (flagYes == true))
						{
							new Actotalcreate(account,w,d,t);//acc ---> account, withdrw -----> w,deposite --------> d,total --------> t (all are int)
							new TotalUpdate(account,t);
							JOptionPane.showMessageDialog(this, "Withdraw done successfully");
							new Passdisp(t1.getText());
							t1.setText("");
							t2.setText("");
						}
						
						if((flagAccMatch == true) && (flagNo == true) && (flagYes == false))
						{
							JOptionPane.showMessageDialog(this, "Insufficient balance.\nAccount balance must be 500 after withdraw.", "Error", JOptionPane.ERROR_MESSAGE);
							t1.setText("");
							t2.setText("");
						}
						
						if((flagAccMatch == true) && (flagNo == false) && (flagYes == false))
						{
							JOptionPane.showMessageDialog(this, "Account number has not the minimum balance of INR 500.", "Error", JOptionPane.ERROR_MESSAGE);
							t1.setText("");
							t2.setText("");
						}
						
						
						if((flagAccMatch == false) && (flagNo == false) && (flagYes == false))
						{
							JOptionPane.showMessageDialog(this, "Account number does not exists", "Error", JOptionPane.ERROR_MESSAGE);
							t1.setText("");
							t2.setText("");
						}
						
						
						/*************************************************************************/
						
						flagYes = false;
						flagAccMatch = false;
						flagNo = false;
						
						
						/*********************mmmmmmmmmyyyyyyyyyyyyyyyyyyyy***********************/
						/*
						
						if(flagYes == true)//if(r>0)
						{
							new Actotalcreate(account,w,d,t);
							new TotalUpdate(account,t);
							JOptionPane.showMessageDialog(this, "Withdraw done successfully");
							new Passdisp(t1.getText());
							t1.setText("");
							t2.setText("");
						}
						else
						{
							//JOptionPane.showMessageDialog(this, "No Data Found");
							JOptionPane.showMessageDialog(this, "Failed\nAccount balance must be 500 after withdraw.", "Error", JOptionPane.ERROR_MESSAGE);
							t1.setText("");
							t2.setText("");
						}
						flagYes = false;
						
						*/
						
						/*********************mmmmmmmmmyyyyyyyyyyyyyyyyyyyy***********************/
						
						
					}
					catch(Exception e1)// if file is not present in first time
					{
						JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
						
						t1.setText("");
						t2.setText("");
					}
					
					
					
					
				}
			}
			flagAccNum =false;
			flagWithdraw = false;
			
		}
		
		
		
		if(e.getSource()==cancel)
		{
			int rply = JOptionPane.showConfirmDialog(this, "Are you sure to quit?");
			if(rply == JOptionPane.YES_OPTION)
			{

				new Userwindow("");
				setVisible(false);
			}
		}
		
		
		
		if(e.getSource()==deposit)
		{
			/*********************validation check************************/
			
			String vaccNum = t1.getText();
			String vwithdrw = t2.getText();
			
			
			/*for account number check
		      * */
			String accNumpattern = "^[0-9]{4}" ; 
			Scanner   scan1  =  new Scanner( vaccNum ) ;
			String   matched1  =  scan1.findInLine( accNumpattern ) ;
			if ( matched1 == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID ACCOUNT NUMBER\nIt should contain only digits with minimum length of 4 digit.", "Error", JOptionPane.ERROR_MESSAGE);
				t1.setText("");
			}
			else
			{
				flagAccNum   = true;
			}
			
			/*for withdraw amount check
		      * */
			String withdrawpattern = "^[0-9]{3}" ; 
			Scanner   scan  =  new Scanner( vwithdrw ) ;
			String   matched  =  scan.findInLine( withdrawpattern ) ;
			if ( matched == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID WITHDRAW AMOUNT\nIt should contain only digits with minimum withdraw amount of INR 100.", "Error", JOptionPane.ERROR_MESSAGE);
				t2.setText("");
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
					try
					{
						  FileInputStream fin=new FileInputStream("Regis.dat");
						  ObjectInputStream oin=new ObjectInputStream(fin);
						  list1=(ArrayList<Create>)oin.readObject();
						  
						//x = list1.size();
							for(Create re : list1)
							{
								if(re.getAc().equals(search))
								{
									
									flagAccMatch = true;
									
									amnt=Integer.parseInt(re.getInitialamnt());
									w=Integer.parseInt(t2.getText());
									t=(amnt+w);
									account=Integer.parseInt(t1.getText());
									d=0;
									
									r++;					
								}
							}
							
							
							if((flagAccNum == true) && (flagWithdraw== true) && (flagAccMatch == true))//if(r>0)
							{
								new Actotalcreate(account,d,w,t);//acc ---> account, withdrw -----> d,deposite --------> w,total --------> t (all are int)
								new TotalUpdate(account,t);
								JOptionPane.showMessageDialog(this, "Deposite done successfully");
								new Passdisp(t1.getText());
								t1.setText("");
								t2.setText("");
							}
							if(flagAccMatch == false)
							{
								JOptionPane.showMessageDialog(this, "Account number does not exists");
								t1.setText("");
								t2.setText("");
							}
							
							flagAccMatch = false;
						  
						  
					}catch(Exception e1)
					{
						JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
						
						t1.setText("");
						t2.setText("");
					}
					
					
					
				}
			}
			flagAccNum =false;
			flagWithdraw = false;
			
			
			/*
			try
			{
				  FileInputStream fin=new FileInputStream("Regis.dat");
				  ObjectInputStream oin=new ObjectInputStream(fin);
				  list1=(ArrayList<Create>)oin.readObject();
			}catch(Exception e1){}
			
			
			x = list1.size();
			for(Create re : list1)
			{
				if(re.getAc().equals(search))
				{
					amnt=Integer.parseInt(re.getInitialamnt());
					w=Integer.parseInt(t2.getText());
					t=(amnt+w);
					account=Integer.parseInt(t1.getText());
					d=0;
					
					r++;					
				}
			}
			
			
			if(r>0)
			{
				new Actotalcreate(account,d,w,t);
				new TotalUpdate(account,t);
				new Passdisp(t1.getText());
				t1.setText("");
				t2.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "No Data Found");
			}
			*/
		}
		
		
	
	}
}

	


	
	


