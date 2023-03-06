package com.bus.service;



import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.beans.Customer;
import com.bus.beans.Email;
import com.bus.beans.OrderHistory;


 
// Annotation
@Service

// Class
// Implementing EmailService interface
public class emailservice {
	
	
	@Autowired
	private CustomerRepo repo;
	@Bean
	public JavaMailSender getJavaMailSender() {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gamil.com");
		mailSender.setPort(567);
		mailSender.setUsername("lalitharamya502@gmail.com");
		mailSender.setPassword("upkvxqhzajwuufjl");
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smpt");
		props.put("mail.ampt.starttls.enable", "true");
		props.put("mail.debug", "true");
				
		return mailSender;
		
	}
	@Autowired
	private JavaMailSender emailSender;
	 public String sendBookingEmail(String to,String subject,String Mmssage,OrderHistory booking) 
	 {
		 SimpleMailMessage simplemessage =new SimpleMailMessage();
		 simplemessage.setTo(to);
		 simplemessage.setSubject("this is Subject");
		 simplemessage.setText("hello"+booking.gethId()+"has been confirmed.\n"
				 +"Your booking for"+ booking.getMovieName()+"\n"
				 +"Date:"+ booking.getShowOnDate() +"\n"
				 +"Name:"+ booking.getCustomer()+"/n"
				 +"Seats:"+ booking.getSeat()+"/n"
				 +"Thankyou for using our filim booking System.\n"
				 +"Regards,\n"
				 +"The Filim Booking Team");
		 emailSender.send(simplemessage);
		return "mailsend succesfully";
		 
	 }
	
	
	
	
}

	

	


 

