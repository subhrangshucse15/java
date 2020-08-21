package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TotalUpdate 
{
	public TotalUpdate(int acc,int total)
	{
		ArrayList<Create> list4;
		String ac,amt;
		
		ac = String.valueOf(acc);
		amt = String.valueOf(total);
		
		try
		{
		   FileInputStream fin=new FileInputStream("Regis.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<Create>)oin.readObject();
		}catch(Exception e)
		 {
			 list4=new ArrayList<Create>();
		 }
			
		 for(int i = 0 ;i<list4.size();i++)
		 {
			 if(list4.get(i).getAc().equals(ac))
			 {
				 list4.get(i).setInitialamnt(amt);
				 //list4.remove(i);
			 } 
		 }
			 
		try	
		{
		   FileOutputStream fout=new FileOutputStream("Regis.dat");
		   ObjectOutputStream oout=new ObjectOutputStream(fout);
		   oout.writeObject(list4);
		}catch(Exception e){}
		
	}
		
}

