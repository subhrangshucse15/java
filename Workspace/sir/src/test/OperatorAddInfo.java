package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class OperatorAddInfo 
{
	 ArrayList<OperatorRegData> list4;
		
		public OperatorAddInfo(OperatorRegData rg1)
		{
			try
			{
			   FileInputStream fin=new FileInputStream("Reg.dat");
			   ObjectInputStream oin=new ObjectInputStream(fin);
			   list4=(ArrayList<OperatorRegData>)oin.readObject();
			}catch(Exception e)
			 {
				 list4=new ArrayList<OperatorRegData>();
			 }
			
			 list4.add(rg1);
			 
			 try	
			 {
			       FileOutputStream fout=new FileOutputStream("Reg.dat");
			       ObjectOutputStream oout=new ObjectOutputStream(fout);
			       oout.writeObject(list4);
			}catch(Exception e){}
		
		}

}
