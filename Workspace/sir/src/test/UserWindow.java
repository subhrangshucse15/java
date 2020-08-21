package test;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Color;
import java.util.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener; //to sense mouse click
import java.awt.event.ActionEvent; 
import java.util.Calendar;

import javax.swing.*;

 class Userwindow extends JFrame implements ActionListener
{
	private JLabel l1,l2;
	private JButton bcreate,bremove,bdetails,bwithdraw,btransfer,bpass,bdd,bexit,bLoginHistory,bChangePassword,bDeposit,bDetails;
	
	private String sysDate;
	private String sysTime;
	
	private ArrayList<OperatorLoginHistoryData> alist = new ArrayList<OperatorLoginHistoryData>();
	OperatorLoginHistoryData obj = new OperatorLoginHistoryData();
	private JButton blocker;
	private JButton blockerdetails;
	Userwindow(String currentOperator)
	{
		super("Welcome " + currentOperator);
		
		//obj.setOperatorFirstName(currentOperator);
		
		
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
		
		Font f1=new Font("Times New Roman",Font.BOLD,25);
		l1=new JLabel("                OPERATOR");
		l1.setFont(f1);
		l1.setForeground(Color.WHITE);
		JPanel fpanel=new JPanel();
		fpanel.add(l1);
		fpanel.setBackground(new Color(0,0,64));
		
		l2=new JLabel("FUNCTIONS              ");
		l2.setFont(f1);
		l2.setForeground(Color.WHITE);
		JPanel ppanel=new JPanel();
		ppanel.add(l2);
		ppanel.setBackground(new Color(0,0,64));
		
		bcreate=new JButton("CREATE NEW ACCOUNT");
		bcreate.addActionListener(this);
		JPanel apanel=new JPanel();
		apanel.add(bcreate);
		apanel.setBackground(new Color(0,0,64));
	
		
		bremove=new JButton("REMOVE ACCOUNT");
		bremove.addActionListener(this);
		JPanel bpanel=new JPanel();
		bpanel.add(bremove);
		bpanel.setBackground(new Color(0,0,64));
	
		
		bdetails=new JButton("VIEW DETAILS OF AN ACCOUNT");
		bdetails.addActionListener(this);
		JPanel cpanel=new JPanel();
		cpanel.add(bdetails);
		cpanel.setBackground(new Color(0,0,64));
	
		
		bwithdraw=new JButton("WITHDRAWAL/DEPOSIT");
		bwithdraw.addActionListener(this);
		JPanel dpanel=new JPanel();
		dpanel.add(bwithdraw);
		dpanel.setBackground(new Color(0,0,64));
	
		
		btransfer=new JButton("TRANSFER MONEY");
		btransfer.addActionListener(this);
		JPanel epanel=new JPanel();
		epanel.add(btransfer);
		epanel.setBackground(new Color(0,0,64));
		
		bpass=new JButton("VIEW ACCOUNT PASS BOOK");
		bpass.addActionListener(this);
		JPanel qpanel=new JPanel();
		qpanel.add(bpass);
		qpanel.setBackground(new Color(0,0,64));
		
		bdd=new JButton("REQUEST FOR DD/CHEQUE BOOK/LOAN");
		bdd.addActionListener(this);
		JPanel upanel=new JPanel();
		upanel.add(bdd);
		upanel.setBackground(new Color(0,0,64));
	
		
		bexit=new JButton("LOG OUT");
		bexit.addActionListener(this);
		JPanel gpanel=new JPanel();
		gpanel.add(bexit);
		gpanel.setBackground(new Color(0,0,64));
		
		bChangePassword=new JButton("CHANGE PASSWORD");
		bChangePassword.addActionListener(this);
		JPanel aapanel=new JPanel();
		aapanel.add(bChangePassword);
		aapanel.setBackground(new Color(0,0,64));
	
		
		bLoginHistory=new JButton("LOGIN HISTORY");
		bLoginHistory.addActionListener(this);
		JPanel bbpanel=new JPanel();
		bbpanel.add(bLoginHistory);
		bbpanel.setBackground(new Color(0,0,64));
		
		bDeposit=new JButton("FIXED DEPOSIT");
		bDeposit.addActionListener(this);
		JPanel bapanel=new JPanel();
		bapanel.add(bDeposit);
		bapanel.setBackground(new Color(0,0,64));
		
		bDetails=new JButton("FIXED DEPOSIT DETAILS");
		bDetails.addActionListener(this);
		JPanel abpanel=new JPanel();
		abpanel.add(bDetails);
		abpanel.setBackground(new Color(0,0,64));
		
		blocker=new JButton("APPLY FOR LOCKER");
		blocker.addActionListener(this);
		JPanel a3panel=new JPanel();
		a3panel.add(blocker);
		a3panel.setBackground(new Color(0,0,64));
		
		blockerdetails=new JButton("LOCKER DETAILS");
		blockerdetails.addActionListener(this);
		JPanel a4panel=new JPanel();
		a4panel.add(blockerdetails);
		a4panel.setBackground(new Color(0,0,64));

	
		
		c.add(fpanel);c.add(ppanel);
		c.add(apanel);c.add(dpanel);
		c.add(bpanel);c.add(epanel);
		c.add(qpanel);c.add(upanel);
		c.add(bapanel);c.add(abpanel);
		c.add(a3panel);c.add(a4panel);
		c.add(cpanel);c.add(bbpanel);
		c.add(aapanel);c.add(gpanel);
		
		setSize(600,550);
		setLocation(200,200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		//OperatorLoginHistoryData obj;
		
		if(e.getSource()==bcreate)
		{
			new CreateFrame();
			setVisible(false);
		}
		if(e.getSource()==bwithdraw)
		{
			new Withdraw();
			setVisible(false);
		}
		
		if(e.getSource()==bremove)
		{
		    new UserRemove();
			setVisible(false);
        }
		if(e.getSource()==btransfer)
		{
			new Transfer();
			setVisible(false);
			
        }
		if(e.getSource()==bdd)
		{
			new Request();
			//new CreateFrame();give name as u want
			setVisible(false);
		}
		if(e.getSource()==bpass)
		{
			new PassBook();//give name as u want
			setVisible(false);
		}
		if(e.getSource()==bdetails)
		{
			new OperatorUserSearch();
			setVisible(false);
        }
		if(e.getSource()==bexit)
		{
			 int con=JOptionPane.showConfirmDialog(this, "Are you sure to cancel?");
				
				if(con==JOptionPane.YES_OPTION)
				{
					
					/*****************************1**********************************/
					
					//obj = new OperatorLoginHistoryData();
					
					obj.setOLogoutDate(sysDate);
					obj.setOLogoutTime(sysTime);
					//obj.setALoginDate("	-	");
					//obj.setALogoutTime("	-	");
					
					alist.add(obj);
					
					
					new OperatorLogoutHistoryAddInfo(obj);
					
					
					/*****************************2**********************************/
					
					new ThirdWindow();
					setVisible(false);
				}
			
			//new ThirdWindow();
			//setVisible(false);
	    }
		
		
		if(e.getSource()==bLoginHistory)
		{
			//new CreateFrame();
			//setVisible(false);
			//JOptionPane.showMessageDialog(this, "before calling"); 
			new OperatorLoginDisplay();
			//JOptionPane.showMessageDialog(this, "after calling"); 
		}
		if(e.getSource()==bChangePassword)
		{
			//new Withdraw();
			//setVisible(false);
			new ChangePassword();
			setVisible(false);
		}
		if(e.getSource()==bDeposit)
		{
			new FixedDepo();
			setVisible(false);
		}
		if(e.getSource()==bDetails)
		{
			new DepoDisplay();
			//setVisible(false);
		}
		if(e.getSource()==blocker)
		{
			new Locker();
			setVisible(false);
		}
		if(e.getSource()==blockerdetails)
		{
			new LockerDisplay();
			//setVisible(false);
		}

}
}