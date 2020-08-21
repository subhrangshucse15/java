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

public class UserSearchDisplay extends JFrame
{
	String data[][];
	String heading[]={"First Name","Last name","Address","Nationality","Account Type","Date Of Birth","Identity","Profession","Reg Date","Reg Time","A/c no","Balance"};
	ArrayList<Create> list;
	
	public UserSearchDisplay(String name)
	{
		super("Search for user account number " + name);
		try
		{
		  FileInputStream fin=new FileInputStream("Regis.dat");
		  ObjectInputStream oin=new ObjectInputStream(fin);
		  list=(ArrayList<Create>)oin.readObject();
		  
		  /*************sukanta************/
			/**********specific row creation********************/
			int row=0;
			for(Create re : list)
			{
				if(re.getAc().equals(name))
				{
					row++;
				}
			}
			
			
			data = new String[row][heading.length+1];

			
			int r=0;
			for(Create re : list)
			{
				if(re.getAc().equals(name))
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
				
			   	
			}
			
			
			/*int x = list.size();
			data=new String[x][12];
			int r=0;
			for(Create re : list)
			{
				if(re.getName().equals(name))
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
				
			   	
			}*/
			if (r>0)
			{
			  Container con=getContentPane();
			  con.setLayout(new BorderLayout());
			
			  JTable datatable=new JTable(data, heading);
			  JScrollPane jsp=new JScrollPane(datatable);
			
			  con.add(new JLabel("Registration Details"),BorderLayout.NORTH);
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
