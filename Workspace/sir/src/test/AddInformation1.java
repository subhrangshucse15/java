package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AddInformation1
{
   ArrayList<Create> list4;
  // ArrayList<Create>list2;
	
	public AddInformation1(Create rg1)
	{
		try
		{
		   FileInputStream fin=new FileInputStream("Regis.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<Create>)oin.readObject();
		}catch(Exception e)
		 {
			 list4=new ArrayList<Create>();
		 }
		
		 list4.add(rg1);
		 
		 try	
		 {
		       FileOutputStream fout=new FileOutputStream("Regis.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(list4);
		}catch(Exception e){}
	
	}
}
