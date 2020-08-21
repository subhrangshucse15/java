package test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SavingsUpdate 
{
	public SavingsUpdate(int acc,int total)
	{
		ArrayList<Depo> list4;
		String ac,amt;
		
		ac = String.valueOf(acc);
		amt = String.valueOf(total);
		try
		{
		   FileInputStream fin=new FileInputStream("fixed.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<Depo>)oin.readObject();
		}catch(Exception e)
		 {
			 list4=new ArrayList<Depo>();
		 }
			
		 for(int i = 0 ;i<list4.size();i++)
		 {
			 if(list4.get(i).getSavingsacc().equals(ac))
			 {
				 list4.get(i).setSavingsaccbal(amt);
				 //list4.remove(i);
			 } 
		 }
			 
		try	
		{
		   FileOutputStream fout=new FileOutputStream("fixed.dat");
		   ObjectOutputStream oout=new ObjectOutputStream(fout);
		   oout.writeObject(list4);
		}catch(Exception e){}
		
	}
}
