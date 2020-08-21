package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OperatorLoginDisplay extends JFrame
{
	public OperatorLoginDisplay()
	{
		super("LOGIN HISTORY");
		
		String data[][];
		String heading[]={"First Name","Login Date","Login Time","Logout Date","Logout Time"};
		ArrayList<OperatorLoginHistoryData> list = new ArrayList<OperatorLoginHistoryData>();
		
		
		
		/******************file read**************************************/
		try
		{
		  FileInputStream fin=new FileInputStream("OperatorLoginData.dat");
		  ObjectInputStream oin=new ObjectInputStream(fin);
		  list=(ArrayList<OperatorLoginHistoryData>)oin.readObject();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		/******************************************************************/
		
		
		/**********specific row creation********************/
		int row=0;
		for(int i = 0 ;i<list.size();i++)//for(OperatorLoginHistoryData re : list)
		{
			 if(list.get(i).getOperatorFirstName().equals(list.get(list.size()-1).getOperatorFirstName()))//if(re.getOperatorFirstName().equals(name))
			{
				row++;
			}
		}
		
		
		data = new String[row][heading.length+1];
		
		int r=0;
		for(int i = 0 ;i<list.size();i++)//for(OperatorLoginHistoryData re : list)
		{
			 if(list.get(i).getOperatorFirstName().equals(list.get(list.size()-1).getOperatorFirstName()))//if(re.getOperatorFirstName().equals(name))
			 {
				 data[r][0]=list.get(i).getOperatorFirstName();
				 data[r][1]=list.get(i).getOLoginDate();
				 data[r][2]=list.get(i).getOLoginTime();
				 data[r][3]=list.get(i).getOLogoutDate();
				 data[r][4]=list.get(i).getOLogoutTime();
				 
				 r++;
			 }
		}
		
		
		if (r>0)
		{
		  Container con=getContentPane();
		  con.setLayout(new BorderLayout());
		
		  JTable datatable=new JTable(data, heading);
		  JScrollPane jsp=new JScrollPane(datatable);
		
		  con.add(new JLabel("Login history"),BorderLayout.NORTH);
		  con.add(jsp,BorderLayout.CENTER);
		
		  setSize(650, 300);
		  setLocation(200, 200);
		  setVisible(true);
		  //JOptionPane.showMessageDialog(this, "MATCH FOUND");
		}
		//JOptionPane.showMessageDialog(this, r);
		else
		{
			JOptionPane.showMessageDialog(this, "Match not Found");
		}
		
		
	}

}
