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
public class Depo extends JFrame implements Serializable
{
private String savingsacc;
private String fixeddepoacc;
private String savingsaccbal;
private String fixedamnt;
private String terms;
private String rate;
private String date;
private String time;
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
public String getSavingsacc() {
	return savingsacc;
}
public void setSavingsacc(String savingsacc) {
	this.savingsacc = savingsacc;
}
public String getFixeddepoacc() {
	return fixeddepoacc;
}
public void setFixeddepoacc(String fixeddepoacc) {
	this.fixeddepoacc = fixeddepoacc;
}
public String getSavingsaccbal() {
	return savingsaccbal;
}
public void setSavingsaccbal(String savingsaccbal) {
	this.savingsaccbal = savingsaccbal;
}
public String getFixedamnt() {
	return fixedamnt;
}
public void setFixedamnt(String fixedamnt) {
	this.fixedamnt = fixedamnt;
}
public String getTerms() {
	return terms;
}
public void setTerms(String terms) {
	this.terms = terms;
}
public String getRate() {
	return rate;
}
public void setRate(String rate) {
	this.rate = rate;
}


}
