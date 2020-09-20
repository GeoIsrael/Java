package com.model;


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail2 {

	private static String from = "sales@aps-site.ru";
	
	
    public static void sendImageEmail(Session session, String to, String subject, String body) throws AddressException, MessagingException {
  	
    	
    	Message message = new MimeMessage(session);
    	message.setFrom(new InternetAddress(from));
    	message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));   
    	message.setSubject(subject);
    	message.setText(body);
    	 
    	
   	
    	BodyPart messageBodyPart1 = new MimeBodyPart();  
        messageBodyPart1.setText(body);  
    
    	
        
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
        
        String filename = "/home/g/Desktop/Business/price.xls";
        DataSource source = new FileDataSource(filename);  
        messageBodyPart2.setDataHandler(new DataHandler(source));  
        messageBodyPart2.setFileName("price.xls");  
    	
        Multipart multipart = new MimeMultipart();  
        multipart.addBodyPart(messageBodyPart1);  
        multipart.addBodyPart(messageBodyPart2);  
      
        message.setContent(multipart);  
         
    	

        
        // Used to debug SMTP issues
//        session.setDebug(true);

        
        //
        try {
           
            System.out.println("sending..."+ to);
            Transport.send(message);
            System.out.println("Sent message successfully....");
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}