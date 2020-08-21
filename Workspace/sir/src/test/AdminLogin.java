 package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

class Admin extends JFrame implements ActionListener
{
	private JLabel l1,l2;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8;
	private JButton b9;
	private JButton b10;
	private String sysDate;
	private String sysTime;
	
	
	private ArrayList<AdminLoginHistoryData> alist = new ArrayList<AdminLoginHistoryData>();
	private JButton b11;
	private JButton b12;
	private JButton b13;
	private JButton b14;
	
	public Admin()
	{
		/*********added*******************/
		super("Welcome Administrator");
		/*********************************/
		
		/********DATE**********************/
		
		Calendar cal = Calendar.getInstance();
		
		String cday = ""+cal.get(Calendar.DATE);
		int x =cal.get(Calendar.MONTH);
		String cmonth = ""+(x+1);
		String cyear =""+cal.get(Calendar.YEAR);
		sysDate = cday+"/"+cmonth+"/"+cyear;
		
		//lDateValue = new JLabel(sysDate);		
		
		
	    String chr = ""+cal.get(Calendar.HOUR_OF_DAY);
		String cmin = ""+cal.get(Calendar.MINUTE);
		String csec =""+cal.get(Calendar.SECOND);
		sysTime = chr+":"+cmin+":"+csec;
		
		/**************************************************/
		
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(8,2));
		
		Font f1=new Font("Times New Roman",Font.BOLD,20);
		l1=new JLabel("ADMINISTRATOR");
		l1.setFont(f1);
		l1.setForeground(Color.RED);
		JPanel bpanel=new JPanel();
		bpanel.add(l1);
		bpanel.setBackground(new Color(0,0,64));
		
		l2=new JLabel("");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		JPanel cpanel=new JPanel();
		cpanel.add(l2);
		cpanel.setBackground(new Color(0,0,64));
		
		b1=new JButton("ADD AN OPERATOR");
		b1.addActionListener(this);
		JPanel apanel=new JPanel();
		apanel.add(b1);
		apanel.setBackground(new Color(0,0,64));
		
		b2=new JButton("SEARCH AN OPERATOR");
		b2.addActionListener(this);
		JPanel dpanel=new JPanel();
		dpanel.add(b2);
		dpanel.setBackground(new Color(0,0,64));
		
		b3=new JButton("DELETE AN OPERATOR");
		b3.addActionListener(this);
		JPanel epanel=new JPanel();
		epanel.add(b3);
		epanel.setBackground(new Color(0,0,64));
		
		b4=new JButton("SHOW ALL OPERATORS");
		b4.addActionListener(this);
		JPanel fpanel=new JPanel();
		fpanel.add(b4);
		fpanel.setBackground(new Color(0,0,64));
		
		b5=new JButton("SHOW ALL USERS");
		b5.addActionListener(this);
		JPanel gpanel=new JPanel();
		gpanel.add(b5);
		gpanel.setBackground(new Color(0,0,64));
		
		b6=new JButton("SEARCH AN USER");
		b6.addActionListener(this);
		JPanel hpanel=new JPanel();
		hpanel.add(b6);
		hpanel.setBackground(new Color(0,0,64));
		
		b7=new JButton("DELETE AN USER");
		b7.addActionListener(this);
		JPanel opanel=new JPanel();
		opanel.add(b7);
		opanel.setBackground(new Color(0,0,64));
		
		b8=new JButton("LOG OUT");
		b8.addActionListener(this);
		JPanel qpanel=new JPanel();
		qpanel.add(b8);
		qpanel.setBackground(new Color(0,0,64));
		
		b9=new JButton("LOAN DETAILS OF USER");
		b9.addActionListener(this);
		JPanel qopanel=new JPanel();
		qopanel.add(b9);
		qopanel.setBackground(new Color(0,0,64));
		
		b10=new JButton("LOGIN HISTORY");
		b10.addActionListener(this);
		JPanel ppanel=new JPanel();
		ppanel.add(b10);
		ppanel.setBackground(new Color(0,0,64));
		
		b11=new JButton("LOCKER DETAILS OF USER");
		b11.addActionListener(this);
		JPanel qoopanel=new JPanel();
		qoopanel.add(b11);
		qoopanel.setBackground(new Color(0,0,64));
		
		b12=new JButton("FIXED DEPOSIT DETAILS");
		b12.addActionListener(this);
		JPanel qipanel=new JPanel();
		qipanel.add(b12);
		qipanel.setBackground(new Color(0,0,64));
		b13=new JButton("LOCKER APPROVE");
		b13.addActionListener(this);
		JPanel q2panel=new JPanel();
		q2panel.add(b13);
		q2panel.setBackground(new Color(0,0,64));
		b14=new JButton("LOAN APPROVE");
		b14.addActionListener(this);
		JPanel q3panel=new JPanel();
		q3panel.add(b14);
		q3panel.setBackground(new Color(0,0,64));
		
		
		
		c.add(bpanel);c.add(cpanel);
		c.add(apanel);c.add(dpanel);
		c.add(epanel);c.add(fpanel);
		c.add(gpanel);c.add(hpanel);
		c.add(qoopanel);c.add(qipanel);
		c.add(q2panel);c.add(q3panel);
		c.add(qopanel);c.add(ppanel);
		c.add(opanel);c.add(qpanel);
		
		
		setSize(600,525);
		setLocation(200,200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		AdminLoginHistoryData obj;
		
		if(e.getSource()==b1) 
		{
			new OperatorReg("");
			setVisible(false);	
		}
		
		
		if(e.getSource()==b2) 
		{
			new OperatorSearch();
			setVisible(false);	
			
		}
		
		
		if(e.getSource()==b3) 
		{
			new OperatorDelete();
			setVisible(false);	
			
		}
		
		
		if(e.getSource()==b4) 
		{
			new OperatorDisplay();
			//setVisible(false);
		}
		
		
		if(e.getSource()==b5) 
		{
			//JOptionPane.showMessageDialog(this, "DISPLAY ALL CURRENT RECORDS");
			new DiaplayAll() ;
			//setVisible(false);
		}
		
		
		if(e.getSource()==b6) 
		{
			new UserSearch();
			setVisible(false);	
			
		}
		
		
		if(e.getSource()==b7) 
		{
			new AdminUserRemove();
			setVisible(false);	
		}
		
		
		if(e.getSource()==b8) 
		{
			 int con=JOptionPane.showConfirmDialog(this, "Are You Sure to cancel?");
				
			if(con==JOptionPane.YES_OPTION)
			{
				
				
				/*****************************1**********************************/
				
				obj = new AdminLoginHistoryData();
				
				obj.setALogoutDate(sysDate);
				obj.setALogoutTime(sysTime);
				//obj.setALoginDate("	-	");
				//obj.setALogoutTime("	-	");
				
				alist.add(obj);
				
				
				new AdminLogoutHistoryAddInfo(obj);
				
				
				
				
				/*****************************2**********************************/
				new SecondWindow();
				//new FirstWindow("");
				setVisible(false);
			}
			
			//new FirstWindow("");
			//setVisible(false);	
		}
		if(e.getSource()==b9) 
		{
			new LoanDisplay();
			//setVisible(false);	
		}
		if(e.getSource()==b10) 
		{
			new LoginHistory();
			setVisible(false);	
		}
		if(e.getSource()==b11) 
		{
			new LockerDisplay();
			//setVisible(false);	
		}
		if(e.getSource()==b12) 
		{
			new DepoDisplay();
			//setVisible(false);	
		}
		if(e.getSource()==b13)
		{
			new LockerShowApprove();
			new LockerApprove();
			//new LockerDisplay();
			setVisible(false);
		}
		if(e.getSource()==b14)
		{
			new LoanShowApprove();
			new LoanApprove();
			//new LoanDisplay();
			setVisible(false);
		}
		
	}
	
}

public class AdminLogin
{
   public static void main(String[] args)
	  {
	
	  }

}
