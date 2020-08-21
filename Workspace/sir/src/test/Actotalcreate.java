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
public class Actotalcreate extends JFrame
{
	private String sysdate,systime;
	//ArrayList<Create> list1;
	Actotal sd=new Actotal();
	Actotalcreate(int a,int b,int d,int t)
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
		
		sd.setAccount(a);
		sd.setWithdraw1(b);
		sd.setDepo(d);
		sd.setTotal(t);
		sd.setDate(sysdate);
		sd.setTime(systime);
		ArrayList<Actotal> list4;
		try
		{
		   FileInputStream fin=new FileInputStream("actotal.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<Actotal>)oin.readObject();
		}catch(Exception e)
		 {
			 list4=new ArrayList<Actotal>();
		 }
		
		 list4.add(sd);
		 
		 try	
		 {
		       FileOutputStream fout=new FileOutputStream("actotal.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(list4);
		}catch(Exception e){}
	
	}
}
