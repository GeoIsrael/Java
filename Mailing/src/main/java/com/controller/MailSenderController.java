package com.controller;

	import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
	import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
import javax.mail.internet.AddressException;

import com.model.SendMail2;

	public class MailSenderController {

		static int cnt = 0;
	    public static void main(String[] args) throws IOException, AddressException, MessagingException {

	    	
			
//	       text 
	    	
	    	
	    	String subject = "Осенняя распродажа систем видеонаблюдения. Скидки 20 процентов до конца октября на весь прайс";
	       	String body = "Наша компания является официальным дистрибьютором оборудования систем безопасности и профессионального видеонаблюдения MATRIX. "
	       			+ "Производим поставки оборудования по всей России, производим оплату по наличному и безналичному расчету. " + "\n" 
	       			+ "Оперативная отправка оборудования транспортнй компанией в день оплаты. "
	       			+ "При заказе более 10000 рублей производим отправку за наш счет. "
	       		    + "До конца октября скидка 20% на все позиции в прайс - листе. "
	       			+ "ООО <АудитПожарСервис>  https://aps-site.ru " + "\n" +
	       		    "sales@aps-site.ru, тел: +7(343) 226-40-61 (многоканальный) " + "\n" +
	       			"Заявку можно оформить по телефону или на сайте в разделе ПРАЙС НА ОБОРУДОВАНИЕ"
	       		    ;
	       	

	
	       	
	       	
//	       	Session       	
	    	    	
	    	String host = "smtp.timeweb.ru";
	        Properties properties = System.getProperties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "465");
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.auth", "true");
	        properties.put ("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        properties.put ("mail.smtp.starttls.enable", "true");
	        
	        
	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

	            protected PasswordAuthentication getPasswordAuthentication() {

	                return new PasswordAuthentication("sales@aps-site.ru", "n64qcY7Z");

	            }

	        });
	        
	        File file = new File("/home/g/input/EmailsRepository/39000");
	    	BufferedReader reader = null;

	    	try {
	    	    reader = new BufferedReader(new FileReader(file));
	    	    String text = null;
	    	    

	    	    while ((text = reader.readLine()) != null) {
	    	        System.out.println(text);
	    	        SendMail2.sendImageEmail(session, text, subject, body);    
	    	        System.out.println(cnt++);
	    	    }
	    	} catch (FileNotFoundException e) {
	    	    e.printStackTrace();
	    	} catch (IOException e) {
	    	    e.printStackTrace();
	    	} finally {
	    	    try {
	    	        if (reader != null) {
	    	            reader.close();
	    	           
	    	        }
	    	    } catch (IOException e) {
	    	    }
	    	}

	        
	        


	        
	    }
	}
	        
