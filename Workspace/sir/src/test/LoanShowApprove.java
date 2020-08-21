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

public class LoanShowApprove extends JFrame
{
	
	String heading[]={"Bank A/C no","Loan A/C no","Loan Amount","Loan Type","Terms","Rate","Date","Time"};
	String data[][];
	ArrayList<LoanData> list2 = new ArrayList<LoanData>();
	LoanShowApprove()
	{
		super("PENDING LOAN REQUEST FOR APPROVAL");
		try//read from file
		{
			FileInputStream fin=new FileInputStream("loan.dat");
			ObjectInputStream oin=new ObjectInputStream(fin);
			list2=(ArrayList<LoanData>)oin.readObject();
			//reading all account withdraw info
	
	
	
			data = new String[list2.size()][heading.length+1];
	
			for(LoanData re : list2)
			{
				if(re.getApprove().equals("False"))
				{
					int r=0;		
					data[r][0]=re.getBankacc();
					data[r][1]=re.getAcc();
					data[r][2]=re.getAmnt();
					data[r][3]=re.getAcctype();
					data[r][4]=re.getTerms();
					data[r][5]=re.getRate();
					data[r][6]=re.getDate();
					data[r][7]=re.getTime();
							
				
					r++;
				}
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
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			//System.out.println(e.toString());
			JOptionPane.showMessageDialog(this, "No file found in data base", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
