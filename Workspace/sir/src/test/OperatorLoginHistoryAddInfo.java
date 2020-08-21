package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class OperatorLoginHistoryAddInfo
{
	ArrayList<OperatorLoginHistoryData> list4;
	
	public OperatorLoginHistoryAddInfo(OperatorLoginHistoryData rg1)
	{
		try
		{
		   FileInputStream fin=new FileInputStream("OperatorLoginData.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<OperatorLoginHistoryData>)oin.readObject();
		}catch(Exception e)
		 {
			 list4=new ArrayList<OperatorLoginHistoryData>();
		 }
		
		 list4.add(rg1);
		 
		 try	
		 {
		       FileOutputStream fout=new FileOutputStream("OperatorLoginData.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(list4);
		}catch(Exception e){}
	}

}
