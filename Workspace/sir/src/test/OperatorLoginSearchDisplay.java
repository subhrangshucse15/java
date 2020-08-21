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

public class OperatorLoginSearchDisplay extends JFrame
{
	String data[][];
	String heading[]={"First Name","Login Date","Login Time","Logout Date","Logout Time"};
	ArrayList<OperatorLoginHistoryData> list;
	
	public OperatorLoginSearchDisplay(String name)
	{
		super("Login history for operator " + name);
		
		try
		{
		  FileInputStream fin=new FileInputStream("OperatorLoginData.dat");
		  ObjectInputStream oin=new ObjectInputStream(fin);
		  list=(ArrayList<OperatorLoginHistoryData>)oin.readObject();
		  
		  
		  /*************sukanta************/
			/**********specific row creation********************/
			int row=0;
			for(OperatorLoginHistoryData re : list)
			{
				if(re.getOperatorFirstName().equals(name))
				{
					row++;
				}
			}
			
			
			data = new String[row][heading.length+1];
			
			int r=0;
			for(OperatorLoginHistoryData re : list)
			{
				if(re.getOperatorFirstName().equals(name))
				{
					  data[r][0]=re.getOperatorFirstName();
					  data[r][1]=re.getOLoginDate();
					  data[r][2]=re.getOLoginTime();
					  data[r][3]=re.getOLogoutDate();
					  data[r][4]=re.getOLogoutTime();
					 
					  /*
					  data[r][5]=re.getDob();
					  data[r][6]=re.getIdentity();
					  data[r][7]=re.getProfession();
					  data[r][8]=re.getDate();
					  data[r][9]=re.getTime();
					  data[r][10]=re.getAc();
					  data[r][11]=re.getInitialamnt();
					  */
					  r++;
					
				}
				
			   	
			}
			
			if (r>0)
			{
			  Container con=getContentPane();
			  con.setLayout(new BorderLayout());
			
			  JTable datatable=new JTable(data, heading);
			  JScrollPane jsp=new JScrollPane(datatable);
			
			  con.add(new JLabel("Login history for operator " + name),BorderLayout.NORTH);
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
		  
		  
		  
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}

}
