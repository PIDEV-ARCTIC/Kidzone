package tn.esprit.spring.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import tn.esprit.spring.entity.Absence;
import tn.esprit.spring.entity.Employee;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.repository.AbsenceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@Service
public class EmailPdf {
	

		@Autowired
		AbsenceRepository absenceRepository;
	public void CreatePdf(){
			java.util.List<Absence> absences = absenceRepository.findAll(); 
	try
	{
	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props, new javax.mail.Authenticator()
	    {
	        protected PasswordAuthentication getPasswordAuthentication()
	        {
	            return new PasswordAuthentication("mohamedelhedi.benaissa@gmail.com", "lzbzoqcxwswktvjb");
	        }
	    });
	    Message msg = new MimeMessage(session);
	    msg.setFrom(new InternetAddress("mohamedelhedi.benaissa@gmail.com", false));

	    msg.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse("mohamedelhedi.benaissa@gmail.com"));
	    msg.setSubject("Email Sent Successfully ! ");
	    msg.setSentDate(new Date());

	    MimeBodyPart messageBodyPart = new MimeBodyPart();
	    
	    messageBodyPart.setContent("Bonjour, ceci est la "+"Liste d'absence : " +" ",
	            "text/html");

	    Multipart multipart = new MimeMultipart();
	    multipart.addBodyPart(messageBodyPart);

	    MimeBodyPart attachPart = new MimeBodyPart();
	    attachPart.attachFile("D:\\absencePDF.pdf");
	    multipart.addBodyPart(attachPart);
	    msg.setContent(multipart);
	    Transport.send(msg);
	}
	catch (Exception exe)
	{
	    exe.printStackTrace();
	}
	// Generating Pdf

	try {
	    // creation of the document with a certain size and certain margins
	    Document document = new Document(PageSize.A4, 20, 20, 20, 20);
	    // creating table and set the column width
	    PdfPTable table = new PdfPTable(4);
	    float widths[] = {2,2,2,3};
	    table.setWidths(widths);
	    // add cell of table - header cell
	    PdfPCell cell1 = new PdfPCell(new Phrase("Full Name"));
	    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    cell1.setBackgroundColor(new BaseColor(250, 253, 250));
	    cell1.setPadding(20);
	    table.addCell(cell1);

	    
	    PdfPCell cell2 = new PdfPCell(new Phrase("Start Date"));
	    cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	    cell2.setBackgroundColor(new BaseColor(250, 253, 250));
	    cell2.setPadding(20);
	    table.addCell(cell2);

	    PdfPCell cell3 = new PdfPCell(new Phrase("Periode"));
	    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	    cell3.setBackgroundColor(new BaseColor(250, 253, 250));
	    cell3.setPadding(20);
	    table.addCell(cell3);

	   
	    PdfPCell cell4 = new PdfPCell(new Phrase("Cause"));
	    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
	    cell4.setBackgroundColor(new BaseColor(250, 253, 250));
	    cell4.setPadding(20);
	    table.addCell(cell4);
    	PdfPCell cell = new PdfPCell();
	    for (Absence item : absences) {
	    	cell = new PdfPCell(new Phrase(item.getEmployee().getNomEmployee()+" "+item.getEmployee().getPrenomEmployee()));
		    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		    cell.setPadding(20);
		    table.addCell(cell);
		    cell = new PdfPCell(new Phrase(item.getDatedebut()+""));
		    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		    cell.setPadding(20);
		    table.addCell(cell);
		    cell = new PdfPCell(new Phrase(item.getPeriode()));
		    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		    cell.setPadding(20);
		    table.addCell(cell);
		    cell = new PdfPCell(new Phrase(item.getCause()));
		    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		    cell.setPadding(20);
		    table.addCell(cell);

	    }
	    File file = new File("D:\\absencePDF.pdf");
	        // write the all into a file and save it.
	    PdfWriter.getInstance(document, new FileOutputStream(file));

	    document.open();
	    //Title
	    Paragraph title = new Paragraph("* Absence List *");
	    Date date = new Date(System.currentTimeMillis());
	    Paragraph d = new Paragraph(date.toString());
	    title.setAlignment(Element.ALIGN_CENTER);
	    d.setAlignment(Element.ALIGN_CENTER);

	    Chunk linebreak = new Chunk(new DottedLineSeparator());
	    Paragraph contact = new Paragraph("Contact Us : ");
	    contact.setAlignment(Element.ALIGN_CENTER);
	    //Generating QrCode
	    BarcodeQRCode barcodeQRCode = new BarcodeQRCode("Phone Number : 25060761", 1000, 1000, null);
	    Image codeQrImage = barcodeQRCode.getImage();
	    codeQrImage.scaleAbsolute(100, 100);
	    codeQrImage.setAlignment(Element.ALIGN_CENTER);
	    document.add(title);
	    document.add(linebreak);
	    document.add(d);
	    document.add(linebreak);
	    document.add(table);
	    document.add(linebreak);
	    document.add(contact);
	    document.add(codeQrImage);
	    document.add(linebreak);
	    document.close();

	    System.out.println("Pdf Generated successfully.");
	} catch (DocumentException a) {
	    a.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 

	//end Generating Pdf

}}
