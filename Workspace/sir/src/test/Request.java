package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class Request extends JFrame implements ActionListener
{
	private JLabel l1;
	private JButton dd,chq,atm,loan,back,loandetails;
	
	public Request()
	{
		super("Miscellanous Requests");
		
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(6,1));
		
		/*Font f1=new Font("Times New Roman",Font.BOLD,20);
		l1=new JLabel("REQUEST");
		l1.setFont(f1);
		l1.setForeground(Color.RED);
		JPanel fpanel=new JPanel();
		fpanel.add(l1);
		fpanel.setBackground(new Color(0,0,64));*/
		
		dd=new JButton("MAKE DEMAND DRAFT");
		dd.addActionListener(this);
		JPanel cpanel=new JPanel();
		cpanel.add(dd);
		cpanel.setBackground(new Color(0,0,64));
		
		chq=new JButton("APPLY FOR CHEQUE BOOK");
		chq.addActionListener(this);
		JPanel dpanel=new JPanel();
		dpanel.add(chq);
		dpanel.setBackground(new Color(0,0,64));
		
		atm=new JButton("APPLY FOR ATM CARD");
		atm.addActionListener(this);
		JPanel epanel=new JPanel();
		epanel.add(atm);
		epanel.setBackground(new Color(0,0,64));
		
		loan=new JButton("APPLY FOR LOAN");
		loan.addActionListener(this);
		JPanel gpanel=new JPanel();
		gpanel.add(loan);
		gpanel.setBackground(new Color(0,0,64));
		
		loandetails=new JButton("LOAN DETAILS");
		loandetails.addActionListener(this);
		JPanel g1panel=new JPanel();
		g1panel.add(loandetails);
		g1panel.setBackground(new Color(0,0,64));
		
		
		back=new JButton("Go BACK");
		back.addActionListener(this);
		JPanel qpanel=new JPanel();
		qpanel.add(back);
		qpanel.setBackground(new Color(0,0,64));
		
		//c.add(fpanel);
		c.add(cpanel);
		c.add(dpanel);
		c.add(epanel);
		c.add(gpanel);
		c.add(g1panel);
		c.add(qpanel);
		
		setSize(500,425);
		setLocation(200,200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==dd)
		{
			//new Request();
			new Demanddraft();
			setVisible(false);
		}
		if(e.getSource()==chq)
		{
			new ChequeBook();
			setVisible(false);
		}
		if(e.getSource()==atm)
		{
			new ATMcard();
			setVisible(false);
		}
		if(e.getSource()==loan)
		{
			new Loan();
			setVisible(false);
		}
		if(e.getSource()==loandetails)
		{
			new LoanDisplay();
			//setVisible(false);
		}
		if(e.getSource()==back)
		{
			int con=JOptionPane.showConfirmDialog(this, "Are you sure to cancel?");
			
			if(con==JOptionPane.YES_OPTION)
			{
			   new Userwindow("");
			   setVisible(false);
			}
			//new Userwindow("");
			//setVisible(false);
		}
		
	}

}
