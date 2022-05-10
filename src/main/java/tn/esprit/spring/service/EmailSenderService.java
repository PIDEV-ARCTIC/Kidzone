package tn.esprit.spring.service;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.mysql.cj.Session;

import tn.esprit.spring.Entity.Reglement;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailSender;
 
	
	public void  sendEmail(String toEmail,String subject, String body){
		Properties props = new Properties();
		props.put("mail.smtp.ssl.enable", "true");
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("arwa.esprit@esprit.tn");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		
		System.out.println("mail sent syccessfully ...");
	}
	
public void email(Reglement reglement,String toEmail, String subject, String body) throws MessagingException {
		

		String smtpHost = "smtp.gmail.com"; //replace this with a valid host
	    int smtpPort = 587; //replace this with a valid port*/

	    String sender = "arwa.bejaoui@esprit.tn"; //replace this with a valid sender email address
	    String recipient = "arwa.bejaoui@esprit.tn"; //replace this with a valid recipient email address
	   // String content = "test"; //this will be the text of the email
	     //this will be the subject of the email
	    String password = "jqiuzgujdidifkdd"; 
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);

	    Properties properties = new Properties();
	    properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.starttls.enable", "true");
	    properties.put("mail.smtp.host", smtpHost);
	    properties.put("mail.smtp.port", smtpPort);  
	    
	    //Session session = Session.getDefaultInstance(properties, null);
	    Session session = Session.getDefaultInstance(properties,   
                new javax.mail.Authenticator() {   
            protected PasswordAuthentication getPasswordAuthentication() {   
                return new PasswordAuthentication(sender,password);    }   });

	    ByteArrayOutputStream outputStream = null;

	    try {           
	        //construct the text body part
	        MimeBodyPart textBodyPart = new MimeBodyPart();
	        textBodyPart.setText(body);
	        
	        
	        
	        //now write the PDF content to the output stream
	        outputStream = new ByteArrayOutputStream();
	        writePdf(outputStream,reglement);
	        byte[] bytes = outputStream.toByteArray();

	        //construct the pdf body part
	        DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
	        MimeBodyPart pdfBodyPart = new MimeBodyPart();
	        pdfBodyPart.setDataHandler(new DataHandler(dataSource));
	        pdfBodyPart.setFileName("reglement.pdf");

	        //construct the mime multi part
	        MimeMultipart mimeMultipart = new MimeMultipart();
	        mimeMultipart.addBodyPart(textBodyPart);
	        mimeMultipart.addBodyPart(pdfBodyPart);
	        
	        //create the sender/recipient addresses
	        InternetAddress iaSender = new InternetAddress(sender);
	        InternetAddress iaRecipient = new InternetAddress(toEmail);

	        //construct the mime message
	        MimeMessage mimeMessage = new MimeMessage(session);
	        mimeMessage.setSender(iaSender);
	        mimeMessage.setSubject(subject);
	        mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
	        mimeMessage.setContent(mimeMultipart);

	        //send off the email
	        Transport.send(mimeMessage);

	        System.out.println("sent from " + sender + 
	                ", to " + recipient + 
	                "; server = " + "smtp.gmail.com" + ", port = " + 587);         
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        //clean off
	        if(null != outputStream) {
	            try { outputStream.close(); outputStream = null; }
	            catch(Exception ex) { }
	        }
	    }
	}
		public void writePdf(OutputStream outputStream,Reglement reglement) throws Exception {
			
			long idtier= reglement.getIdtier();
			
			Document document = new Document(PageSize.A4);
		    PdfWriter.getInstance(document, outputStream);
		    document.open();
		    Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        fontTitle.setSize(18);
	        Paragraph paragraph = new Paragraph("Engagement", fontTitle);

	        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

	        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
	        fontParagraph.setSize(12);

	        Paragraph paragraph2 = new Paragraph( "\n"+"le tier "+"  "+reglement.getIdtier()+"est "+""+reglement.getSensoperation()+"ée de "+"  "+ "montant "+" "+reglement.getMontant()+"\n"+
	        		 "Déclare sur l’honneur l’exactitude de toutes les informations figurant dans le présent dossier" +"\n"
	        		+ "Fait le " +reglement.getDateoperation() + "\n" + "Signature", fontParagraph);

	        document.add(paragraph);
	        document.add(paragraph2);
		    document.close();
	}
}
