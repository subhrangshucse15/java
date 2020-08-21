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

public class Demanddraft extends JFrame implements ActionListener
{
	private JLabel l1,l2;
	private JTextField t1,t2;
	private JButton bsubmit,back;
	ArrayList<Create> list1;
	int amnt,w,account,d,t,r;
	private boolean flagAccNum = false;
	private boolean flagWithdraw = false;
	
	public Demanddraft()
	{
		super("Demand Draft (DD) Request");
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(3,2));
		
		t1=new JTextField();
		t2=new JTextField();
		
		bsubmit=new JButton("SUBMIT");
		bsubmit.addActionListener(this);
		JPanel bpanel=new JPanel();
		bpanel.add(bsubmit);
		bpanel.setBackground(new Color(0,0,64));
		
		back=new JButton("BACK");
		back.addActionListener(this);
		JPanel epanel=new JPanel();
		epanel.add(back);
		epanel.setBackground(new Color(0,0,64));
		
		Font f1=new Font("Times New Roman",Font.BOLD,20);
		l1=new JLabel("Enter A/C no");
		l1.setFont(f1);
		l1.setForeground(Color.RED);
		JPanel cpanel=new JPanel();
		cpanel.add(l1);
		cpanel.setBackground(new Color(0,0,64));
		
		l2=new JLabel("Enter Amount for making DD");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		JPanel dpanel=new JPanel();
		dpanel.add(l2);
		dpanel.setBackground(new Color(0,0,64));
		
		c.add(cpanel);c.add(t1);
		c.add(dpanel);c.add(t2);
		c.add(bpanel);c.add(epanel);
		
		setSize(530,270);
		setLocation(100,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e)
	{
		String search=t1.getText();
		r=0;
		
		if(e.getSource()==bsubmit)
		{
			
			/*********************validation check************************/
			
			String vAccNum = t1.getText();
			String vAmount = t2.getText();
			
			
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
				flagAccNum   = true;
			}
			
			
			/*for amount check
		      * */
			String amountPattern = "^[0-9]{3}" ; 
			Scanner   scan  =  new Scanner( vAmount ) ;
			String   matched  =  scan.findInLine( amountPattern ) ;
			if ( matched == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID AMOUNT\nIt should contain only digits with minimum withdraw amount of INR 100.", "Error", JOptionPane.ERROR_MESSAGE);
				t2.setText("");
			}
			else
			{
				flagWithdraw     = true;
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
					}
					catch(Exception e1)
					{
						 
					}
					
					
					
					for(Create re : list1)
					{
						if(re.getAc().equals(search))
						{
							amnt=Integer.parseInt(re.getInitialamnt());
							w=Integer.parseInt(t2.getText());
							t=(amnt-w-50);
							if(t>=500)
							{
								account=Integer.parseInt(t1.getText());
								d=0;
								r++;
							}
							
						}
					}
					
					
					if(r>0)
					{
						new Actotalcreate(account,(w+50),d,t);
						new TotalUpdate(account,t);
						JOptionPane.showMessageDialog(this, "DD has been issued successfully");
						new Passdisp(t1.getText());
						t1.setText("");
						t2.setText("");
						
					}
					else
					{
						
						JOptionPane.showMessageDialog(this, "DD cannot be made");
						t1.setText("");
						t2.setText("");
					}
				}
			}
			flagAccNum = false;
			flagWithdraw = false;
			
			
			/*********************************PREVIOUS*****************************************************/
			
			
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
			
			
			
			for(Create re : list1)
			{
				if(re.getAc().equals(search))
				{
					amnt=Integer.parseInt(re.getInitialamnt());
					w=Integer.parseInt(t2.getText());
					t=(amnt-w-50);
					account=Integer.parseInt(t1.getText());
					d=0;
					r++;
					
				}
			}
			
			
			if(r>0)
			{
				new Actotalcreate(account,w,d,t);
				new TotalUpdate(account,t);
				JOptionPane.showMessageDialog(this, "DD has been issued");
			}
			else
			{
				
				JOptionPane.showMessageDialog(this, "DD cannot be made");
			}
			
			
			*/
			
			
		}
		
		
		
		
		
		
		if(e.getSource()==back) 
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
