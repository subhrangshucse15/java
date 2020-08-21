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
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;

import javax.swing.*;

public class LoginHistory extends JFrame implements ActionListener
{
	private JLabel l1;
	private JButton b1,b2;
	private JButton b3;
	
	public LoginHistory()
	{
		super("LOGIN HISTORY");
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(4,1));
		
		Font f1=new Font("Times New Roman",Font.BOLD,20);
		l1=new JLabel("LOGIN HISTORY");
		l1.setFont(f1);
		l1.setForeground(Color.RED);
		JPanel bpanel=new JPanel();
		bpanel.add(l1);
		bpanel.setBackground(new Color(0,0,64));
		
		b1=new JButton("ADMIN LOGIN HISTORY");
		b1.addActionListener(this);
		JPanel apanel=new JPanel();
		apanel.add(b1);
		apanel.setBackground(new Color(0,0,64));
		
		b2=new JButton("OPERATOR LOGIN HISTORY");
		b2.addActionListener(this);
		JPanel dpanel=new JPanel();
		dpanel.add(b2);
		dpanel.setBackground(new Color(0,0,64));
		
		b3=new JButton("BACK");
		b3.addActionListener(this);
		JPanel epanel=new JPanel();
		epanel.add(b3);
		epanel.setBackground(new Color(0,0,64));
		
		
		c.add(bpanel);
		c.add(apanel);
		c.add(dpanel);
		c.add(epanel);
		
		setSize(400,295);
		setLocation(200,200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1) 
		{
			//new OperatorReg("");
			//setVisible(false);
			
			new AdminLoginDisplay();
		}
		if(e.getSource()==b2) 
		{
			new OperatorLoginSearch();
			setVisible(false);	
		}
		if(e.getSource()==b3) 
		{
			int rply = JOptionPane.showConfirmDialog(this, "Are you sure to quit?");
			if(rply == JOptionPane.YES_OPTION)
			{
				new Admin();
				setVisible(false);
			}
			//new Admin();
			//setVisible(false);	
		}
		
		
		
		
	}

}
