package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AdminLoginHistoryAddInfo
{
	ArrayList<AdminLoginHistoryData> list4;
	
	public AdminLoginHistoryAddInfo(AdminLoginHistoryData rg1)
	{
		try
		{
		   FileInputStream fin=new FileInputStream("AdminLoginData.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<AdminLoginHistoryData>)oin.readObject();
		}catch(Exception e)
		 {
			 list4=new ArrayList<AdminLoginHistoryData>();
		 }
		
		 list4.add(rg1);
		 
		 try	
		 {
		       FileOutputStream fout=new FileOutputStream("AdminLoginData.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(list4);
		}catch(Exception e){}
	}

}
