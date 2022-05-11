package tn.esprit.spring.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.BodyPart;
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

import tn.esprit.spring.controller.BusController;
import tn.esprit.spring.entity.Inscription;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class EmailInscriptionService {
	
	@Autowired
	private JavaMailSender mailSender;	
	@Autowired
	private EnfantService enfantService;	
	
	@Autowired
	private BusController busController;
	
	public void sendSimpleMessage(
		      String toEmail, String subject, String body ,String pathToAttachment) throws MessagingException {
		        
		        //SimpleMailMessage message = new SimpleMailMessage();
		        MimeMessage message = mailSender.createMimeMessage();
		        
		        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		        
		        helper.setFrom("youssef.skhiri@esprit.tn");
		        helper.setTo(toEmail); 
		        helper.setSubject(subject); 
		        helper.setText(body);
		        
		        
		        FileSystemResource fileSystem = new FileSystemResource(new File(pathToAttachment));
		        helper.addAttachment(fileSystem.getFilename(), fileSystem);
		        
		        mailSender.send(message);
		        System.out.println("Mail envoyé");
		        
		    }
	
	public void email(Inscription inscription,String toEmail, String subject, String body) throws MessagingException {
		

		String smtpHost = "smtp.gmail.com"; //replace this with a valid host
	    int smtpPort = 587; //replace this with a valid port*/

	    String sender = "youssef.skhiri@esprit.tn"; //replace this with a valid sender email address
	    String recipient = "youssef.skhiri@esprit.tn"; //replace this with a valid recipient email address
	   // String content = "test"; //this will be the text of the email
	     //this will be the subject of the email
	    String password = "hcbuasohhzbdnupw"; 
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
	        writePdf(outputStream,inscription);
	        byte[] bytes = outputStream.toByteArray();

	        //construct the pdf body part
	        DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
	        MimeBodyPart pdfBodyPart = new MimeBodyPart();
	        pdfBodyPart.setDataHandler(new DataHandler(dataSource));
	        pdfBodyPart.setFileName("Inscription.pdf");

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
		public void writePdf(OutputStream outputStream,Inscription inscription) throws Exception {
			
			long idenfant= inscription.getEnfant().getIdenfant();
			
			Document document = new Document(PageSize.A4);
		    PdfWriter.getInstance(document, outputStream);
		    document.open();
		    Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        fontTitle.setSize(18);
	        Paragraph paragraph = new Paragraph("Engagement", fontTitle);

	        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

	        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
	        fontParagraph.setSize(12);

	        Paragraph paragraph2 = new Paragraph("Je soussigné(e):" + enfantService.FindNameParent(idenfant) + " " + enfantService.FindSurNameChild(idenfant)+ " parent de "+enfantService.FindNameChild(idenfant)+" "+enfantService.FindSurNameChild(idenfant)+ "\n"
	        		+ "Déclare sur l’honneur l’exactitude de toutes les informations figurant dans le présent dossier" +"\n"
	        		+ "Fait le " + inscription.getDateoperation() + "\n" + "Signature", fontParagraph);

	        document.add(paragraph);
	        document.add(paragraph2);
		    document.close();
	}


}
