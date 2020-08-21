package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class UserRemoveDisplay extends JFrame
{
ArrayList<Actotal>list1;
	ArrayList<Create> list2;
	int p;
	public UserRemoveDisplay(String name)
	{
		p=Integer.parseInt(name);
		try
		{
		  FileInputStream fin=new FileInputStream("Regis.dat");
		  ObjectInputStream oin=new ObjectInputStream(fin);
		  list2=(ArrayList<Create>)oin.readObject();
		}catch(Exception e)
		{
			list2 = new ArrayList<Create>();
		}
		
		//int x = list2.size();
		//data=new String[x][12];
		int r=0,c=0;
		for(int i=0;i<list2.size();i++)
		{
			if(list2.get(i).getAc().equals(name))
			{
				r++;
				String r1=String.valueOf(r);
				//JOptionPane.showMessageDialog(this, "r"+r1);
				list2.remove(i);
			}
		
		}
		
		//JOptionPane.showMessageDialog(this, "After reding first time r = " + r);
		
		try	
		 {
		       FileOutputStream fout=new FileOutputStream("Regis.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(list2);
		}catch(Exception e){}

		
		
		
		
		try
		{
		  FileInputStream fin=new FileInputStream("actotal.dat");
		  ObjectInputStream oin=new ObjectInputStream(fin);
		  list1=(ArrayList<Actotal>)oin.readObject();
		}catch(Exception e)
		{
			list1 = new ArrayList<Actotal>();
		}
		
		
		
		
		
		for(int i=0;i<list1.size();)
		{
			
			//JOptionPane.showMessageDialog(this, "for loop i = " + i + "\nk = " + k);
			
			if(list1.get(i).getAccount()==p)
					
			{
				//JOptionPane.showMessageDialog(this, "iffffffffffff i = " + i + "\nk = " + k);
				
				c++;
				String c1=String.valueOf(c);
				//JOptionPane.showMessageDialog(this, "c"+c1);
				list1.remove(i);
			}
			else
			{
				i++;
			}
			
		
		} 
		
		
		//JOptionPane.showMessageDialog(this, "After reding first time c = " + c);
		 
		try	
		 {
		       FileOutputStream fout=new FileOutputStream("actotal.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(list1);
		}catch(Exception e){}
		/*for(Create re : list2)
		{
			if(re.getName().equals(name))
			{
				r++;
list2.remove(re);
			}
		}*/
			
      
        if(r==1)
        {
        	JOptionPane.showMessageDialog(this, "USER RECORD REMOVED");

        }
        else
        {
        	JOptionPane.showMessageDialog(this, "No Data Found");

        }
	}

}