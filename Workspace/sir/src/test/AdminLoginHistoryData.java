package test;

import java.io.Serializable;

import javax.swing.JFrame;

public class AdminLoginHistoryData extends JFrame implements Serializable
{
	private String ALoginDate;
	private String ALoginTime;
	private String ALogoutDate;
	private String ALogoutTime;
	public String getALoginDate() {
		return ALoginDate;
	}
	public void setALoginDate(String aLoginDate) {
		ALoginDate = aLoginDate;
	}
	public String getALoginTime() {
		return ALoginTime;
	}
	public void setALoginTime(String aLoginTime) {
		ALoginTime = aLoginTime;
	}
	public String getALogoutDate() {
		return ALogoutDate;
	}
	public void setALogoutDate(String aLogoutDate) {
		ALogoutDate = aLogoutDate;
	}
	public String getALogoutTime() {
		return ALogoutTime;
	}
	public void setALogoutTime(String aLogoutTime) {
		ALogoutTime = aLogoutTime;
	}
	
	
	

}
