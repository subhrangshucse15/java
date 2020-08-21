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

public class ChequeBook extends JFrame implements ActionListener
{
	
	private JComboBox pages;
	private JTextField t1;
	private JLabel l0,l1;
	private JButton bsubmit,bcancel;
	ArrayList<Create> list1;
	 
	private int amnt,account,d,t,r,w1,tot1,tot2,v,c;
	private boolean flagAccNum = false;
	
	
	public ChequeBook()
	{
		super("Cheque Book Request");
		
		Container c=getContentPane();
		t1=new JTextField();
		c.setLayout(new GridLayout(3,2));
		
		bsubmit=new JButton("Submit");
		bsubmit.addActionListener(this);
		JPanel fpanel=new JPanel();
		fpanel.add(bsubmit);
		fpanel.setBackground(new Color(0,0,64));
		
		
		bcancel=new JButton("Cancel");
		bcancel.addActionListener(this);
		JPanel gpanel=new JPanel();
		gpanel.add(bcancel);
		gpanel.setBackground(new Color(0,0,64));
		
		
		Font f1=new Font("Times New Roman",Font.BOLD,20);
		l0=new JLabel("Enter A/C no");
		l0.setFont(f1);
		l0.setForeground(Color.RED);
		JPanel apanel=new JPanel();
		apanel.add(l0);
		apanel.setBackground(new Color(0,0,64));
		
		
		l1=new JLabel("Enter Number of Pages");
		l1.setFont(f1);
		l1.setForeground(Color.RED);
		JPanel bpanel=new JPanel();
		bpanel.add(l1);
		bpanel.setBackground(new Color(0,0,64));
		
		
		String cvalue[]={"25","50"};
		pages=new JComboBox(cvalue);
		JPanel cpanel=new JPanel();
		cpanel.add(pages);
		cpanel.setBackground(new Color(0,0,64));
		
		
		c.add(apanel);c.add(t1);
		c.add(bpanel);c.add(cpanel);
		c.add(fpanel);c.add(gpanel);
		
		setSize(400,200);
		setLocation(100,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	public void actionPerformed(ActionEvent e) 
	{
		d=0;
		r=0;
		c=0;
		String search=t1.getText();
		//r=0;
		if(e.getSource()==bsubmit)
		{
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
				catch(Exception e1){}
				
				
				for(Create re : list1)
				{
					if(re.getAc().equals(search))
					{
						account=Integer.parseInt(t1.getText());
						amnt=Integer.parseInt(re.getInitialamnt());
						String w=(String)pages.getSelectedItem();
						w1=Integer.parseInt(w);
						if(amnt>500)
						{
							if(w1==25)
							{
								v=50;
								tot1=amnt-v;
								if(tot1>=500)
								{
									new Actotalcreate(account,v,d,tot1);
									new TotalUpdate(account,tot1);
									r++;	
								}
								
							}
							
							
							if(w1==50)
							{
								v=100;	
								tot2=amnt-v;
								if(tot2>=500)
								{
									new Actotalcreate(account,v,d,tot2);
									new TotalUpdate(account,tot2);
									c++;	
								}
							}
					
						}								
					}
				}
				
				
				if((r==1)||(c==1))
				{
					JOptionPane.showMessageDialog(this, "Check book has been issued");
					new Passdisp(t1.getText());
					t1.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Check cannot be issued");
					t1.setText("");
				}
			}
			flagAccNum = false;
			
			
			/***************************PREVIOUS*****************************/
			
			/*
			
			try
			{
				FileInputStream fin=new FileInputStream("Regis.dat");
				ObjectInputStream oin=new ObjectInputStream(fin);
				list1=(ArrayList<Create>)oin.readObject();	
			}	
			catch(Exception e1){}
			
			
			for(Create re : list1)
			{
				if(re.getAc().equals(search))
				{
					account=Integer.parseInt(t1.getText());
					amnt=Integer.parseInt(re.getInitialamnt());
					String w=(String)pages.getSelectedItem();
					w1=Integer.parseInt(w);
					if(amnt>500)
					{
						if(w1==25)
						{
							v=50;
							tot1=amnt-v;
							if(tot1>=500)
							{
								new Actotalcreate(account,v,d,tot1);
								new TotalUpdate(account,tot1);
								r++;	
							}
							
						}
						
						
						if(w1==50)
						{
							v=100;	
							tot2=amnt-v;
							if(tot2>=500)
							{
								new Actotalcreate(account,v,d,tot2);
								new TotalUpdate(account,tot2);
								c++;	
							}
						}
				
					}								
				}
			}
			
			
			if((r==1)||(c==1))
			{
				JOptionPane.showMessageDialog(this, "Check book has been issued");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Check cannot be issued");
			}
			
			*/
			
		}
		
		
		
		if(e.getSource()==bcancel) 
		{
             int con=JOptionPane.showConfirmDialog(this, "Are you sure to cancel?");
			
			if(con==JOptionPane.YES_OPTION)
			{
				new Request();
			   //new UserMain1();
			   setVisible(false);
			}
		
		
		}

	}
}
