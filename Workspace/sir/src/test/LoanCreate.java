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

public class LoanCreate extends JFrame
{
	private String sysdate,systime;
	LoanCreate(String a,String b,String c,String d,String e,String f)
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
			LoanData b1=new LoanData();
			b1.setAcc(a);
			b1.setAmnt(b);
			b1.setAcctype(c);
			b1.setTerms(d);
			b1.setRate(e);
			b1.setBankacc(f);
			b1.setDate(sysdate);
			b1.setTime(systime);
			b1.setApprove("False");
			ArrayList<LoanData> list4;
			try
			{
			   FileInputStream fin=new FileInputStream("loan.dat");
			   ObjectInputStream oin=new ObjectInputStream(fin);
			   list4=(ArrayList<LoanData>)oin.readObject();
			}catch(Exception e1)
			 {
				 list4=new ArrayList<LoanData>();
			 }
			
			 list4.add(b1);
			 
			 try	
			 {
			       FileOutputStream fout=new FileOutputStream("loan.dat");
			       ObjectOutputStream oout=new ObjectOutputStream(fout);
			       oout.writeObject(list4);
			}catch(Exception e1){}

	}
}