package test;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Color;
import java.util.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener; //to sense mouse click
import java.awt.event.ActionEvent; 
import java.io.Serializable;
import java.util.Calendar;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.*;

public class LockerCreate extends JFrame
{
	private String sysdate,systime;
	LockerCreate(String a,String b,String c,String d)
	{

        Calendar cal = Calendar.getInstance();
		
		String cday = ""+cal.get(Calendar.DATE);
		int x =cal.get(Calendar.MONTH);
		String cmonth = ""+(x+1);
		String cyear =""+cal.get(Calendar.YEAR);
		sysdate = cday+"/"+cmonth+"/"+cyear;
		
		String chr = ""+cal.get(Calendar.HOUR_OF_DAY);
		String cmin = ""+cal.get(Calendar.MINUTE);
		String csec =""+cal.get(Calendar.SECOND);
		systime = chr+":"+cmin+":"+csec;
		LockerData b2=new LockerData();
		b2.setAcc(a);
		b2.setLockno(b);
		b2.setBal(c);
		b2.setTerms(d);
		b2.setDecision("False");
		b2.setDate(sysdate);
		b2.setTime(systime);
		ArrayList<LockerData> list4;
		try
		{
		   FileInputStream fin=new FileInputStream("locker.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<LockerData>)oin.readObject();
		}catch(Exception e1)
		 {
			 list4=new ArrayList<LockerData>();
		 }
		
		 list4.add(b2);
		 
		 try	
		 {
		       FileOutputStream fout=new FileOutputStream("locker.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(list4);
		}catch(Exception e1){}


	
	}
	
}
