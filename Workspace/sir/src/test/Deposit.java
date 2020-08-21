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

public class Deposit extends JFrame implements ActionListener
{
	private JLabel l1,l2,l3;
	private JTextField t1;
	private JButton submit,cancel;
	
	public Deposit()
	{
		Container c=getContentPane();
		c.setLayout(new GridLayout(3,2));
		
		Font f1=new Font("Times New Roman",Font.BOLD,20);
		l1=new JLabel("                         DEPOSIT");
		l1.setFont(f1);
		l1.setForeground(Color.GRAY);
		JPanel fpanel=new JPanel();
		fpanel.add(l1);
		fpanel.setBackground(new Color(0,0,64));
		
		l1=new JLabel("SLIP                         ");
		l1.setFont(f1);  
		l1.setForeground(Color.GRAY);
		JPanel apanel=new JPanel();
		apanel.add(l1);
		apanel.setBackground(new Color(0,0,64));
		
		l1=new JLabel("Enter ACCOUNT NO:");
		l1.setFont(f1);
		l1.setForeground(Color.GRAY);
		JPanel bpanel=new JPanel();
		bpanel.add(l1);
		bpanel.setBackground(new Color(0,0,64));
		
		t1=new JTextField();
		
		submit=new JButton("SUBMIT");
		submit.addActionListener(this);
		JPanel dpanel=new JPanel();
		dpanel.add(submit);
		dpanel.setBackground(new Color(0,0,64));
		
		cancel=new JButton("CANCEL");
		cancel.addActionListener(this);
		JPanel epanel=new JPanel();
		epanel.add(cancel);
		epanel.setBackground(new Color(0,0,64));
		
		c.add(fpanel);c.add(apanel);
		c.add(bpanel);c.add(t1);
		c.add(dpanel);c.add(epanel);
		
		setSize(500,400);
		setLocation(200,200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==submit)
		{
			new Deposit1();
			setVisible(false);
		}
		if(e.getSource()==cancel)
		{
			new Userwindow("");
			setVisible(false);
		}
	
		
	}
}
