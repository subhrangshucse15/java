package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class Deposit1 extends JFrame implements ActionListener
{
	private JLabel l1,l2,l3,l4,l5;
	private JTextField t1,t2,t3;
	private JButton proceed,back;
	
	public Deposit1()
	{
		Container c=getContentPane();
		c.setLayout(new GridLayout(5,2));
		
		Font f1=new Font("Times New Roman",Font.BOLD,20);
		l1=new JLabel("                   WITHDRAWAL");
		l1.setFont(f1);
		l1.setForeground(Color.WHITE);
		JPanel fpanel=new JPanel();
		fpanel.add(l1);
		fpanel.setBackground(new Color(0,0,64));
		
		l2=new JLabel("DETAILS          ");
		l2.setFont(f1);
		l2.setForeground(Color.WHITE);
		JPanel apanel=new JPanel();
		apanel.add(l2);
		apanel.setBackground(new Color(0,0,64));
		
		l3=new JLabel("Account Holder Name");
		l3.setFont(f1);
		l3.setForeground(Color.GRAY);
		JPanel bpanel=new JPanel();
		bpanel.add(l3);
		bpanel.setBackground(new Color(0,0,64));
		
		l4=new JLabel("BALANCE IN ACCOUNT");
		l4.setFont(f1);
		l4.setForeground(Color.GRAY);
		JPanel cpanel=new JPanel();
		cpanel.add(l4);
		cpanel.setBackground(new Color(0,0,64));
		
		l5=new JLabel("Amount To Be Deposited");
		l5.setFont(f1);
		l5.setForeground(Color.GRAY);
		JPanel dpanel=new JPanel();
		dpanel.add(l5);
		dpanel.setBackground(new Color(0,0,64));
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		
		proceed=new JButton("PROCEED");
		proceed.addActionListener(this);
		JPanel epanel=new JPanel();
		epanel.add(proceed);
		epanel.setBackground(new Color(0,0,64));
		
		back=new JButton("BACK");
		back.addActionListener(this);
		JPanel gpanel=new JPanel();
		gpanel.add(back);
		gpanel.setBackground(new Color(0,0,64));
		
		c.add(fpanel);c.add(apanel);
		c.add(bpanel);c.add(t1);
		c.add(cpanel);c.add(t2);
		c.add(dpanel);c.add(t3);
		c.add(epanel);c.add(gpanel);
		
		setSize(500,400);
		setLocation(200,200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==proceed)
		{
            int con=JOptionPane.showConfirmDialog(this, "Are You Sure to Deposit?");
			
			if(con==JOptionPane.YES_OPTION)
			{
				//new Withdraw2();
				setVisible(false);
			}
		}
		if(e.getSource()==back)
		{
			new Deposit();
			setVisible(false);
		}
	}
		
		
}
	

