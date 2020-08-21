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

public class LockerDisplay extends JFrame
{
	public LockerDisplay()
	{
		super("LOCKER DETAILS");
		String heading[]={"Savings Acc no","Locker No","Savings Acc bal","Terms","Date","Time"};
		String data[][];
		ArrayList<LockerData> list;
		try
		{
			FileInputStream fin=new FileInputStream("locker.dat");
			ObjectInputStream oin=new ObjectInputStream(fin);
			list=(ArrayList<LockerData>)oin.readObject();
		
		
			data = new String[list.size()][heading.length+1];
		
		
			int r=0;
			for(LockerData re : list)
			{
				if(re.getDecision().equals("True"))
				{
				data[r][0]=re.getAcc();
				data[r][1]=re.getLockno();
				data[r][2]=re.getBal();
				data[r][3]=re.getTerms();
				data[r][4]=re.getDate();
				data[r][5]=re.getTime();
			
				r++;
			}
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
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			//System.out.println(e.toString());
			JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
