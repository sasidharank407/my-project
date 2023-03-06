package com.bus.beans;



import org.springframework.beans.factory.annotation.Autowired;


public class Email {

    @Autowired
    public   Customer customer;
    
    private  String to;
    private  String subject;
    private String meaage;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMeaage() {
		return meaage;
	}
	public void setMeaage(String meaage) {
		this.meaage = meaage;
	}
	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Email [to=" + to + ", subject=" + subject + ", meaage=" + meaage + "]";
	}
	public Email(String to, String subject, String meaage) {
		super();
		this.to = to;
		this.subject = subject;
		this.meaage = meaage;
	}
    

    
}