package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OperatorLogoutHistoryAddInfo  extends JFrame
{
	ArrayList<OperatorLoginHistoryData> list4;
	
	public OperatorLogoutHistoryAddInfo(OperatorLoginHistoryData rg1)
	{
		try
		{
		   FileInputStream fin=new FileInputStream("OperatorLoginData.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<OperatorLoginHistoryData>)oin.readObject();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "No file found in database", "Error", JOptionPane.ERROR_MESSAGE);
			list4=new ArrayList<OperatorLoginHistoryData>();
		}
		
		//list4.get(i).setInitialamnt(amt);
		list4.get(list4.size()-1).setOLogoutDate(rg1.getOLogoutDate());
		list4.get(list4.size()-1).setOLogoutTime(rg1.getOLogoutTime());
		
		
		//list4.add(rg1);
		 
		try	
		{
			FileOutputStream fout=new FileOutputStream("OperatorLoginData.dat");
			ObjectOutputStream oout=new ObjectOutputStream(fout);
			oout.writeObject(list4);
		}catch(Exception e){}
	}

}
