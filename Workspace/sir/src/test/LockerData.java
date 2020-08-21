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

import javax.swing.*;
public class LockerData extends JFrame implements Serializable
{
private String acc;
private String lockno;
private String bal;
private String terms;
private String date;
private String time;
private String decision;
public String getDecision() {
	return decision;
}
public void setDecision(String decision) {
	this.decision = decision;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getAcc() {
	return acc;
}
public void setAcc(String acc) {
	this.acc = acc;
}
public String getLockno() {
	return lockno;
}
public void setLockno(String lockno) {
	this.lockno = lockno;
}
public String getBal() {
	return bal;
}
public void setBal(String bal) {
	this.bal = bal;
}
public String getTerms() {
	return terms;
}
public void setTerms(String terms) {
	this.terms = terms;
}


}
