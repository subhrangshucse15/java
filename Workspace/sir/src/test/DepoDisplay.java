package test;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;

public class DepoDisplay extends JFrame
{
	public DepoDisplay()
	{
		super("FIXED DEPOSIT DETAILS");
		String heading[]={"Savings Acc no","Fixed Deposit Acc no","Savings Acc bal","Fixed Deposit Amnt","Terms","Rate","Date","Time"};
		String data[][];
		ArrayList<Depo> list;
		try
		{
			FileInputStream fin=new FileInputStream("fixed.dat");
			ObjectInputStream oin=new ObjectInputStream(fin);
			list=(ArrayList<Depo>)oin.readObject();
			
			
			data = new String[list.size()][heading.length+1];
			
			
			int r=0;
			for(Depo re : list)
			{
				data[r][0]=re.getSavingsacc();
				data[r][1]=re.getFixeddepoacc();
				data[r][2]=re.getSavingsaccbal();
				data[r][3]=re.getFixedamnt();
				data[r][4]=re.getTerms();
				data[r][5]=re.getRate();
				data[r][6]=re.getDate();
				data[r][7]=re.getTime();
				
				r++;
	}

		Container con=getContentPane();
		con.setLayout(new BorderLayout());//refer copy
		
		JTable datatable=new JTable(data, heading);//datatable is the obj of the JTABLE,data is the array
		JScrollPane jsp=new JScrollPane(datatable);
		
		con.add(new JLabel("All Registration Details"),BorderLayout.NORTH);
		con.add(jsp,BorderLayout.CENTER);//jsp=jscrollpane
		
		setSize(650, 300);
		
		setLocation(200, 200);
		setVisible(true);
	}catch(Exception e)
	{
		//e.printStackTrace();
		//System.out.println(e.toString());
		JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
}