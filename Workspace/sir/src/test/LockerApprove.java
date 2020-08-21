package test;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.*;

public class LockerApprove extends JFrame implements ActionListener
{
	private JLabel l1;
	private JTextField t1;
	private JButton bsubmit,back;
	ArrayList<LockerData> list2;
	private boolean flagAccNum = false;
	public LockerApprove()
	{
		super("LOCKER APPROVAL PAGE");
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(2,2));
		
		t1=new JTextField();
		
		Font f1=new Font("comic sans ms",Font.BOLD,14);
		l1=new JLabel("Enter Locker no");
		l1.setFont(f1);
		l1.setForeground(Color.RED);
		JPanel fpanel=new JPanel();
		fpanel.add(l1);
		fpanel.setBackground(new Color(0,0,64));
		
		bsubmit=new JButton("APPROVE");
		bsubmit.addActionListener(this);
		JPanel apanel=new JPanel();
		apanel.add(bsubmit);
		apanel.setBackground(new Color(0,0,64));
		
		back=new JButton("BACK");
		back.addActionListener(this);
		JPanel bpanel=new JPanel();
		bpanel.add(back);
		bpanel.setBackground(new Color(0,0,64));
		
		c.add(fpanel);c.add(t1);
		c.add(apanel);c.add(bpanel);
		
		setSize(500,220);
		setLocation(200,200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		

	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		
		String search=t1.getText();
		if(e.getSource()==bsubmit)
		{
			/*********************validation check************************/
			
			String vaccNum = t1.getText();
			
			
			
			/*for  locker account number check
		      * */
			String accNumpattern = "^[0-9]{5}" ; 
			Scanner   scan1  =  new Scanner( vaccNum ) ;
			String   matched1  =  scan1.findInLine( accNumpattern ) ;
			if ( matched1 == null )
			{
				//JOptionPane.showMessageDialog(this, "INVALID PASSWORD\nIt should contain only digits with minimum password length of 4 digit.");
				JOptionPane.showMessageDialog(this, "INVALID  LOCKER ACCOUNT NUMBER\nIt should contain only digits with minimum length of 5 digit.", "Error", JOptionPane.ERROR_MESSAGE);
				t1.setText("");
			}
			else
			{
				flagAccNum   = true;
			}
			
			

			/********************************************************************************/
			
			
			
			
			/************************IF VALIDATION SUCCESSFUL*****************************************/
			
			if(flagAccNum == true)
			{
				try//read from file
				{
					FileInputStream fin=new FileInputStream("locker.dat");
					ObjectInputStream oin=new ObjectInputStream(fin);
					list2=(ArrayList<LockerData>)oin.readObject();
					//reading all account withdraw info
				}
				catch(Exception e1)
				{
					list2=new ArrayList<LockerData>();
				}
				for(int i=0;i<list2.size();i++)
				{
					if(list2.get(i).getLockno().equals(search))
					{
						if(list2.get(i).getDecision().equals("False"))
						{
							list2.get(i).setDecision("True");
						}
					}
				}
				 
				try	
				{
					FileOutputStream fout=new FileOutputStream("locker.dat");
					ObjectOutputStream oout=new ObjectOutputStream(fout);
					oout.writeObject(list2);
				}
				catch(Exception e1){}
				

				//new LockerShowApprove().setVisible(false);
				new LockerDisplay();
				
			}
			flagAccNum = false;
		
		
		
			/***********************************************************************/
			
			/*
		
			try//read from file
			{
				FileInputStream fin=new FileInputStream("locker.dat");
				ObjectInputStream oin=new ObjectInputStream(fin);
				list2=(ArrayList<LockerData>)oin.readObject();
				//reading all account withdraw info
			}
			catch(Exception e1)
			{
				list2=new ArrayList<LockerData>();
			}
			for(int i=0;i<list2.size();i++)
			{
				if(list2.get(i).getLockno().equals(search))
				{
					if(list2.get(i).getDecision().equals("False"))
					{
						list2.get(i).setDecision("True");
					}
				}
			}
			 
			try	
			{
				FileOutputStream fout=new FileOutputStream("locker.dat");
				ObjectOutputStream oout=new ObjectOutputStream(fout);
				oout.writeObject(list2);
			}
			catch(Exception e1){}
			
			
			new LockerDisplay();
			
			*/
			
			/**********************************************************************/
			
		}
		
		
		if(e.getSource()==back)
		{

            int con=JOptionPane.showConfirmDialog(this, "Are you sure to cancel?");
			
			if(con==JOptionPane.YES_OPTION)
			{
			   new Admin();
			   setVisible(false);
			}
		}
		
	}

}
