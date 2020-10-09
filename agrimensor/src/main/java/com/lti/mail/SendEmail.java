package com.lti.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * @author YOJAN Java version 1.8
 *
 */
public final class SendEmail {
	
	    //String toMail,String subjectMail,String context
	    public static void SendMail(String toMail,String password, String name, String role)
	    {
	     String host ="smtp.gmail.com" ;
	            String user ="yojansaini@gmail.com";
	            String pass = "FACEBOOK";
	            String to =toMail;                    //toMail;
	            String from ="Agrimensor@gmail.com";                              //"your email";
	            String subject = "User Approved" ;                           //subjectMail;
	            String messageText = "Congratulations "+name+"\n"+"You have been successfully registered as "+role+" and your account has been activated"+
	            "\n"+"You can sign-in to your account at http://localhost:4200/login with your credentials that are:"+"\n"
	            		+"Username: "+toMail +"\n"
	            		+"Password: "+password+"\n"+
	            		"Welcome to a journey towards one nation one market.";                        // context;
	            boolean sessionDebug = false;

	            Properties props = System.getProperties();

	            props.put("mail.smtp.starttls.enable", "true");
	            props.put("mail.smtp.host", host);
	            props.put("mail.smtp.port", "587");
	            props.put("mail.smtp.auth", "true");
	            props.put("mail.smtp.starttls.required", "true");
	            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	            Session mailSession = Session.getDefaultInstance(props, null);
	            mailSession.setDebug(sessionDebug);
	             try {
	             Message msg = new MimeMessage(mailSession);
	            msg.setFrom(new InternetAddress(from));
	            InternetAddress[] address = {new InternetAddress(to)};
	            msg.setRecipients(Message.RecipientType.TO, address);
	            msg.setSubject(subject); msg.setSentDate(new Date());
	            msg.setText(messageText);
	           Transport transport=mailSession.getTransport("smtp");
	           transport.connect(host, user, pass);
	           transport.sendMessage(msg, msg.getAllRecipients());
	           transport.close();
	           System.out.println("message send successfully");   
	        } catch (MessagingException e) {
	            throw new RuntimeException(e); 
	        }
	    }
	    
	    public static void ForgotPassword(String toMail,String password, String role)
	    {
	     String host ="smtp.gmail.com" ;
	            String user ="yojansaini@gmail.com";
	            String pass = "FACEBOOK";
	            String to =toMail;                    //toMail;
	            String from ="Agrimensor@gmail.com";                              //"your email";
	            String subject = "Lost Credentials Retireval" ;                           //subjectMail;
	            String messageText = "Hello "+role+"\n"+"You have been successfully verfied "+
	            "\n"+"You can sign-in to your account at http://localhost:4200/login with your credentials: "+"\n"
	            		+"Username: "+toMail +"\n"
	            		+"Password: "+password+"\n"+
	            		"Welcome to a journey towards one nation one market.";                        // context;
	            boolean sessionDebug = false;

	            Properties props = System.getProperties();

	            props.put("mail.smtp.starttls.enable", "true");
	            props.put("mail.smtp.host", host);
	            props.put("mail.smtp.port", "587");
	            props.put("mail.smtp.auth", "true");
	            props.put("mail.smtp.starttls.required", "true");
	            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	            Session mailSession = Session.getDefaultInstance(props, null);
	            mailSession.setDebug(sessionDebug);
	             try {
	             Message msg = new MimeMessage(mailSession);
	            msg.setFrom(new InternetAddress(from));
	            InternetAddress[] address = {new InternetAddress(to)};
	            msg.setRecipients(Message.RecipientType.TO, address);
	            msg.setSubject(subject); msg.setSentDate(new Date());
	            msg.setText(messageText);
	           Transport transport=mailSession.getTransport("smtp");
	           transport.connect(host, user, pass);
	           transport.sendMessage(msg, msg.getAllRecipients());
	           transport.close();
	           System.out.println("message send successfully");   
	        } catch (MessagingException e) {
	            throw new RuntimeException(e); 
	        }
	    }

}
