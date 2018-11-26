package com.webtest_javamail.demo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.webtest.utils.Readfmark;

 

public class MailTest1 {

	   public static void send() throws MessagingException, IOException {
		   String info=ReadHTML.reMailString();
		    //邮件服务器
		   String host="smtp.163.com";
			//发件人
		   String from_mail = Readfmark.getPropertyValue("fromemail");
		   String from=from_mail;

			//收件人
		   String to_mail = Readfmark.getPropertyValue("toemail");
		   String to=to_mail;

		   //抄送人

		   String toCC1="13180686518@163.com";

		   String toCC2="1138322644@qq.com";

		   String username=from_mail;
		   String pass_word= Readfmark.getPropertyValue("password");
		   String password=pass_word;

			//邮件会话属性



		   Properties  p=new Properties();

		   	p.put("mail.smtp.host", host);


		   Session session=Session.getDefaultInstance(p,null);

		   		session.setDebug(true);
		   //创建Message信息

		   MimeMessage message=new MimeMessage(session);

		   //创建邮件发送者地址

		   Address fromAD = new InternetAddress(from,"刘琪");

		   //nternetAddress(from)

		   //设置邮件发送者

					message.setFrom(fromAD);	

		   //创建邮件的接收地址

		   Address toAD = new InternetAddress(to);

		   //创建抄送人数组

		   Address toCAD1=new InternetAddress(toCC1);

		   Address toCAD2=new InternetAddress(toCC2);

		   Address [] toCs={toCAD1,toCAD2};

		   //设置邮件的接收地址

					message.setRecipient(Message.RecipientType.TO,toAD);

					message.addRecipients(Message.RecipientType.CC,toCs );

			//设置发送时间

					message.setSentDate(new Date());

		   	//设置主题	

					message.setSubject("Hello JavaMail44");	

			// MimeMultipart类是一个容器类，包含MimeBodyPart类型的对象    	
			Multipart mainPart = new MimeMultipart();  
			//创建一个包含HTML内容的MimeBodyPart
			BodyPart body=new MimeBodyPart();
			//设置html内容
				body.setContent(info,"text/html;charset=utf-8");
			//将MimeMultipart设置为邮件内容
				mainPart.addBodyPart(body);
				message.setContent(mainPart);
			Transport transport=session.getTransport("smtp");
		   		transport.connect(host, username, password);
		   		transport.sendMessage(message,message.getAllRecipients());
		   		transport.close();
	   }
	   public static void main(String[] args) throws MessagingException, IOException  {
			// TODO Auto-generated method stub
		  send();
		}	

}
