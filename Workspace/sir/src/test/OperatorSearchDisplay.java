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


public class OperatorSearchDisplay extends JFrame
{
	String data[][];
	String heading[]={"First Name","Last name","Password","Address","City","Gender","Date Of Birth","Reg Date","Reg Time"};
	ArrayList<OperatorRegData> list;
	private boolean flagIn;
	
	public OperatorSearchDisplay(String name)
	{
		super("Search for user account number" + name);
		try
		{
		  FileInputStream fin=new FileInputStream("Reg.dat");
		  ObjectInputStream oin=new ObjectInputStream(fin);
		  list=(ArrayList<OperatorRegData>)oin.readObject();
		  
		  
		  /*************sukanta************/
			/**********specific row creation********************/
			int row=0;
			for(OperatorRegData re : list)
			{
				if(re.getName().equals(name))
				{
					row++;
				}
			}
			
			
			data = new String[row][heading.length+1];
			
			
			int r=0;
			for(OperatorRegData re : list)
			{
				if(re.getName().equals(name))
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
					//r++;
					flagIn = true;
				}
			}
			
			/**********************************************************/
			/*int x = list.size();
			data=new String[x][9];
			int r=0;
			for(OperatorRegData re : list)
			{
				if(re.getName().equals(name))
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

			}*/
			if(flagIn == true)//if (r>0)
			{
			  Container con=getContentPane();
			  con.setLayout(new BorderLayout());
			
			  JTable datatable=new JTable(data, heading);
			  JScrollPane jsp=new JScrollPane(datatable);
			
			  con.add(new JLabel("Registration Details for " + name),BorderLayout.NORTH);
			  con.add(jsp,BorderLayout.CENTER);
			
			  setSize(650, 300);
			  setLocation(200, 200);
			  setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Match not Found");
			}
			
			flagIn = false;
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}

	
}
