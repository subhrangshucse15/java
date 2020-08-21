package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AdminLogoutHistoryAddInfo extends JFrame
{
	ArrayList<AdminLoginHistoryData> list4;
	
	public AdminLogoutHistoryAddInfo(AdminLoginHistoryData rg1)
	{
		try
		{
		   FileInputStream fin=new FileInputStream("AdminLoginData.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<AdminLoginHistoryData>)oin.readObject();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "No file found in database", "Error", JOptionPane.ERROR_MESSAGE);
			list4=new ArrayList<AdminLoginHistoryData>();
		}
		
		//list4.get(i).setInitialamnt(amt);
		list4.get(list4.size()-1).setALogoutDate(rg1.getALogoutDate());
		list4.get(list4.size()-1).setALogoutTime(rg1.getALogoutTime());
		
		
		//list4.add(rg1);
		 
		try	
		{
			FileOutputStream fout=new FileOutputStream("AdminLoginData.dat");
			ObjectOutputStream oout=new ObjectOutputStream(fout);
			oout.writeObject(list4);
		}catch(Exception e){}
	}

}
