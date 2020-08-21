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

public class AdminLoginDisplay extends JFrame
{
	public AdminLoginDisplay()
	{
		super("LOGIN HISTORY OF ADMIN");
		
		String heading[]={"Login Date","Login Time","Logout Date","Logout Time"};
		String data[][];//=new String[20][12];//2-d array of string type of 20 rows,9 col
		ArrayList<AdminLoginHistoryData> list;//=new ArrayList<Create>();
		
		
		try
		{
			FileInputStream fin=new FileInputStream("AdminLoginData.dat");
			ObjectInputStream oin=new ObjectInputStream(fin);
			list=(ArrayList<AdminLoginHistoryData>)oin.readObject();
			
			
			data = new String[list.size()][heading.length+1];
			
			
			int r=0;
			for(AdminLoginHistoryData re : list)
			{
				data[r][0]=re.getALoginDate();
				data[r][1]=re.getALoginTime();
				data[r][2]=re.getALogoutDate();
				data[r][3]=re.getALogoutTime();
				
				
				/*
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
				*/
				
				r++;
			}
			
			Container con=getContentPane();
			con.setLayout(new BorderLayout());//refer copy
			
			JTable datatable=new JTable(data, heading);//datatable is the obj of the JTABLE,data is the array
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("Admin Login History"),BorderLayout.NORTH);
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
