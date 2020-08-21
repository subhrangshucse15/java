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


public class DiaplayAll extends JFrame //child of jframe class
{
	public DiaplayAll()
	{
		super("DISPLAY All USERS INFORMATION");
		String heading[]={"First Name","Last name","Address","Nationality","Account Type","Date Of Birth","Identity","Profession","Reg Date","Reg Time","A/c no","Balance"};
		String data[][];//=new String[20][12];//2-d array of string type of 20 rows,9 col
		ArrayList<Create> list;//=new ArrayList<Create>();
		try
		{
			FileInputStream fin=new FileInputStream("Regis.dat");
			ObjectInputStream oin=new ObjectInputStream(fin);
			list=(ArrayList<Create>)oin.readObject();
			
			
			data = new String[list.size()][heading.length+1];
			
			
			int r=0;
			for(Create re : list)
			{
				data[r][0]=re.getName();
				data[r][1]=re.getName1();
				data[r][2]=re.getAddress();
				data[r][3]=re.getNationality();
				data[r][4]=re.getAcctype();
				data[r][5]=re.getDob();
				data[r][6]=re.getIdentity();
				data[r][7]=re.getProfession();
				data[r][8]=re.getDate();
				data[r][9]=re.getTime();
				data[r][10]=re.getAc();
				data[r][11]=re.getInitialamnt();
				
				r++;
			}
			
			Container con=getContentPane();
			con.setLayout(new BorderLayout());//refer copy
			
			JTable datatable=new JTable(data, heading);//datatable is the obj of the JTABLE,data is the array
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("All Registration Details"),BorderLayout.NORTH);
			con.add(jsp,BorderLayout.CENTER);//jsp=jscrollpane
			
			setSize(650, 300);
			
			setLocation(200, 200);
			setVisible(true);
		}catch(Exception e)
		{
			//e.printStackTrace();
			//System.out.println(e.toString());
			JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}




