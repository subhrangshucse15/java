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


public class OperatorLoginSearch extends JFrame implements ActionListener
{
	private JLabel l1,l2,l3;
	private JTextField t1;
	private JButton b1,b2;
	private boolean flag = false;
	
	public OperatorLoginSearch()
	{

		super("Operator LOGIN HISTORY");
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(3,2));
		
		Font f1=new Font("Times New Roman",Font.BOLD,16);
		l1=new JLabel("OPERATOR LOGIN");
		l1.setFont(f1);
		l1.setForeground(Color.RED);
		JPanel bpanel=new JPanel();
		bpanel.add(l1);
		bpanel.setBackground(new Color(0,0,64));
		
		l2=new JLabel("HISTORY");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		JPanel apanel=new JPanel();
		apanel.add(l2);
		apanel.setBackground(new Color(0,0,64));
		
		l3=new JLabel("OPERATOR FIRST NAME");
		l3.setFont(f1);
		l3.setForeground(Color.RED);
		JPanel cpanel=new JPanel();
		cpanel.add(l3);
		cpanel.setBackground(new Color(0,0,64));
		
		t1= new JTextField();
		
		b1=new JButton("SEARCH");
		b1.addActionListener(this);
		JPanel dpanel=new JPanel();
		dpanel.add(b1);
		dpanel.setBackground(new Color(0,0,64));
		
		b2=new JButton("CANCEL");
		b2.addActionListener(this);
		JPanel epanel=new JPanel();
		epanel.add(b2);
		epanel.setBackground(new Color(0,0,64));
		
		c.add(bpanel);c.add(apanel);
		c.add(cpanel);c.add(t1);
		c.add(dpanel);c.add(epanel);
		
		setSize(510,300);
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
			
			
			
			/*****************VALIDATION******************************************/
			/***************************validation check********************************************/
			
			 String n = t1.getText().trim();
			 
			 /* operator name check
			  * */
			 
		     String namepattern = "^[a-zA-Z]";
		     Scanner   scan  =  new Scanner( n ) ;
		     String   matched  =  scan.findInLine( namepattern ) ;
		     if ( matched == null )
		     {
		    	 //JOptionPane.showMessageDialog(this, "INVAID FIRST NAME\nIt should contain only alphabet.");
		    	 JOptionPane.showMessageDialog(this, "INVALID OPERATOR FIRST NAME\nIt should contain only alphabet", "Error", JOptionPane.ERROR_MESSAGE);
		         t1.setText("");
		     }
		     else
		     {
		    	 flag   = true;
		     }
		     
		     /**********************************************************************************************/
		     
		     
		     /*****************IF VALID*******************************************************/
		     
		     if(flag == true)
		     {
		    	 String sname = t1.getText().trim();
		    	 new OperatorLoginSearchDisplay(sname);
		    	 //setVisible(false);
		    	 t1.setText("");
		     }
		     
		     flag = false;
			
		}
		
		
		
		if(e.getSource()==b2) 
		{
			int rply = JOptionPane.showConfirmDialog(this, "Are you sure to quit?");
			if(rply == JOptionPane.YES_OPTION)
			{
				new LoginHistory();
				setVisible(false);
			}
			//new OperatorReg("");
			//setVisible(false);	
		}
		
	}

}
