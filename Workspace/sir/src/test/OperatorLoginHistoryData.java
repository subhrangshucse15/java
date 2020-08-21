package test;

import java.io.Serializable;

import javax.swing.JFrame;

public class OperatorLoginHistoryData extends JFrame implements Serializable
{
	private String OperatorFirstName;
	private String OLoginDate;
	private String OLoginTime;
	private String OLogoutDate;
	private String OLogoutTime;
	public String getOperatorFirstName() {
		return OperatorFirstName;
	}
	public void setOperatorFirstName(String operatorFirstName) {
		OperatorFirstName = operatorFirstName;
	}
	public String getOLoginDate() {
		return OLoginDate;
	}
	public void setOLoginDate(String oLoginDate) {
		OLoginDate = oLoginDate;
	}
	public String getOLoginTime() {
		return OLoginTime;
	}
	public void setOLoginTime(String oLoginTime) {
		OLoginTime = oLoginTime;
	}
	public String getOLogoutDate() {
		return OLogoutDate;
	}
	public void setOLogoutDate(String oLogoutDate) {
		OLogoutDate = oLogoutDate;
	}
	public String getOLogoutTime() {
		return OLogoutTime;
	}
	public void setOLogoutTime(String oLogoutTime) {
		OLogoutTime = oLogoutTime;
	}
	
	

}
