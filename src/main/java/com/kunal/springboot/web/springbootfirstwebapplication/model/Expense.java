package com.kunal.springboot.web.springbootfirstwebapplication.model;
//try to keep var name starting with lowercase.
//after creating new table at enter at least one record in table so as to 
//insert new values through this.
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="expenses_23")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private int Credit;
	private int Debit;
	private String Foor;
	private String reason;
	private String Date;
	private int Balance;

	public Expense() {
		super();
	}
	
	public Expense(int credit, int debit, String foor, String reason, String date, int balance) {
		super();
		this.Credit = credit;
		this.Debit = debit;
		this.Foor = foor;
		this.reason = reason;
		this.Date = date;
		this.Balance = balance;
	}

	public int getCredit() {
		return Credit;
	}

	public void setCredit(int credit) {
		this.Credit = credit;
	}

	public int getDebit() {
		return Debit;
	}

	public void setDebit(int debit) {
		this.Debit = debit;
	}

	public String getFoor() {
		return Foor;
	}

	public void setFoor(String foor) {
		this.Foor = foor;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		this.Date = date;
	}

	public int getBalance() {
		return Balance;
	}

	public void setBalance(int balance) {
		this.Balance = balance;
	}

	@Override
	public String toString() {
		return "Expense [credit=" + Credit + ", debit=" + Debit + ", foor=" + Foor + ", reason=" + reason + ", date="
				+ Date + ", balance=" + Balance + "]";
	}

}
