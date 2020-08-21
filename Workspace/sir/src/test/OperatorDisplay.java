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

public class OperatorDisplay extends JFrame
{
	public OperatorDisplay()
	{
		super("DISPLAY All OPERATORS INFORMATION");
		String heading[]={"First Name","Last name","Password","Address","City","Gender","Date Of Birth","Reg Date","Reg Time"};
		String data[][];//=new String[20][9];//2-d array of string type of 20 rows,9 col
		ArrayList<OperatorRegData> list;//=new ArrayList<OperatorRegData>();
		try
		{
			FileInputStream fin=new FileInputStream("Reg.dat");
			ObjectInputStream oin=new ObjectInputStream(fin);
			list=(ArrayList<OperatorRegData>)oin.readObject();
			
			data = new String[list.size()][heading.length+1];
			
			
			int r=0;
			for(OperatorRegData re : list)
			{
				data[r][0]=re.getName();
				data[r][1]=re.getName1();
				data[r][2]=re.getPassword();
				data[r][3]=re.getAddress();
				data[r][4]=re.getCity();
				data[r][5]=re.getGender();
				data[r][6]=re.getDob();
				data[r][7]=re.getDate();
				data[r][8]=re.getTime();
				
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
