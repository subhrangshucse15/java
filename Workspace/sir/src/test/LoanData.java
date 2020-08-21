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
public class LoanData extends JFrame implements Serializable
{
private String bankacc;
public String getBankacc() {
	return bankacc;
}
public void setBankacc(String bankacc) {
	this.bankacc = bankacc;
}
private String acc;
private String amnt;
private String acctype;
private String terms;
private String Rate;
private String date;
private String time;
private String approve;
public String getApprove() {
	return approve;
}
public void setApprove(String approve) {
	this.approve = approve;
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
public String getAmnt() {
	return amnt;
}
public void setAmnt(String amnt) {
	this.amnt = amnt;
}
public String getAcctype() {
	return acctype;
}
public void setAcctype(String type) {
	this.acctype = type;
}
public String getTerms() {
	return terms;
}
public void setTerms(String terms) {
	this.terms = terms;
}
public String getRate() {
	return Rate;
}
public void setRate(String rate) {
	Rate = rate;
}
}