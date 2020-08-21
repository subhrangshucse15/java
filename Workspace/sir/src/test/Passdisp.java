package test;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;

public class Passdisp extends JFrame
{

	public Passdisp(String accNumber)
	{
		super("Passbook");
		
		
		String heading[]={"Accno","Withdraw","Deposit","Total","Date","Time"};
		String data[][];//=new String[1000][6];
		ArrayList<Actotal> list=new ArrayList<Actotal>();
		try
		{
			FileInputStream fin=new FileInputStream("actotal.dat");
			ObjectInputStream oin=new ObjectInputStream(fin);
			list=(ArrayList<Actotal>)oin.readObject();
		}catch(Exception e)
		{
			//e.printStackTrace();
			//System.out.println(e.toString());
			JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		/*************sukanta************/
		/**********specific row creation********************/
		int row=0;
		for(Actotal re : list)
		{
			if(String.valueOf(re.getAccount()).equals(accNumber))
			{
				row++;
			}
		}
		
		
		data = new String[row][heading.length+1];
		
		///data = new String[list.size()][heading.length+1];
			
		int r=0,i=0;
		for(Actotal re : list)
		{
			if(String.valueOf(re.getAccount()).equals(accNumber))
			{
				data[r][0]=String.valueOf(re.getAccount());//converting to string
				data[r][1]=String.valueOf(re.getWithdraw1());
				data[r][2]=String.valueOf(re.getDepo());
				data[r][3]=String.valueOf(re.getTotal());
				data[r][4]=re.getDate();
				data[r][5]=re.getTime();
				r++;
			}
		}
		
		/**********************************************************/
			
		Container con=getContentPane();
		con.setLayout(new BorderLayout());//refer copy
		
		JTable datatable=new JTable(data,heading);//datatable is the obj of the JTABLE,data is the array
		JScrollPane jsp=new JScrollPane(datatable);
		
		con.add(new JLabel("All Registration Details"),BorderLayout.NORTH);
		con.add(jsp,BorderLayout.CENTER);//jsp=jscrollpane
		
		setSize(650, 300);
		
		setLocation(200, 200);
		setVisible(true);
		
		
	}
}





