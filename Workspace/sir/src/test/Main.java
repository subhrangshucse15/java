package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;


import javax.swing.*;


class FirstWindow extends JFrame implements ActionListener
{
	private JLabel l0,l1,l2,l3;
	private JButton admin,user;
	

	
	public FirstWindow(String title)
	{
		super("WELCOME TO UNITED BANK OF PARTNERS");
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(3,2));
		
		Font f1=new Font("Times New Roman",Font.BOLD,25);
		l0=new JLabel("WELCOME TO UNITED");
		l0.setFont(f1);
		l0.setForeground(Color.WHITE);
		JPanel fpanel=new JPanel();
		fpanel.add(l0);
		fpanel.setBackground(new Color(0,0,64));
		
		l1=new JLabel("BANK OF PARTNERS      ");
		l1.setFont(f1);
		l1.setForeground(Color.WHITE);
		JPanel spanel=new JPanel();
		spanel.add(l1);
		spanel.setBackground(new Color(0,0,64));
		
		l3=new JLabel("AS:                                         ");
		l3.setFont(f1);
		l3.setForeground(Color.WHITE);

		
		JPanel xpanel=new JPanel();
		xpanel.add(l3);
		xpanel.setBackground(new Color(0,0,64));
			
		Font f2=new Font("Times New Roman",Font.BOLD,25);
		l2=new JLabel("                                LOGIN");
		l2.setFont(f2);
		l2.setForeground(Color.WHITE);
		//l1.setBorder(new javax.swing.border.LineBorder(java.awt.Color.GREEN, 4));
		JPanel ppanel=new JPanel();
		ppanel.add(l2);
		ppanel.setBackground(new Color(0,0,64));
		
		
		
		admin=new JButton("ADMINISTRATOR");
		
		JPanel gpanel=new JPanel();
		gpanel.add(admin);
		gpanel.setBackground(new Color(0,0,64));
		admin.addActionListener(this);
		
        gpanel.add(new JLabel(""));
		
		user=new JButton("OPERATOR");
		JPanel qpanel=new JPanel();
		qpanel.add(user);
		qpanel.setBackground(new Color(0,0,64));
		user.addActionListener(this);
		qpanel.add(user);
	
		
		c.add(fpanel);c.add(spanel);
		c.add(ppanel);c.add(xpanel);
		c.add(gpanel);c.add(qpanel);
		
		setSize(600,450);
		setLocation(200,200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==admin) 
		{
		//JOptionPane.showMessageDialog(this, "HELLO....");
		new SecondWindow() ;
		setVisible(false);
		}
		if(e.getSource()==user) 
		{
		//JOptionPane.showMessageDialog(this, "HELLO....");
		new ThirdWindow() ;
		setVisible(false);
		}
		
		
		
	}
	
}


public class Main
{

	public static void main(String[] args)
	{
		new FirstWindow("WELCOME TO UNITED BANK OF PARTNERS");

	}

}
