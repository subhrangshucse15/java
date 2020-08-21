package test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class LockerUpdate 
{
	public LockerUpdate(int acc,int total)
	{
		ArrayList<LockerData> list4;
		String ac,amt;
		
		ac = String.valueOf(acc);
		amt = String.valueOf(total);
		try
		{
		   FileInputStream fin=new FileInputStream("locker.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<LockerData>)oin.readObject();
		}catch(Exception e)
		 {
			 list4=new ArrayList<LockerData>();
		 }
			
		 for(int i = 0 ;i<list4.size();i++)
		 {
			 if(list4.get(i).getAcc().equals(ac))
			 {
				 list4.get(i).setBal(amt);
				 //list4.remove(i);
			 } 
		 }
			 
		try	
		{
		   FileOutputStream fout=new FileOutputStream("locker.dat");
		   ObjectOutputStream oout=new ObjectOutputStream(fout);
		   oout.writeObject(list4);
		}catch(Exception e){}
		
	}
}
