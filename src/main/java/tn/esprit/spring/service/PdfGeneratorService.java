/*package tn.esprit.spring.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import tn.esprit.spring.Entity.Reglement;

@Service
public class PdfGeneratorService {
	 public void export(HttpServletResponse response,Reglement r) throws IOException {
	 	//Reglement r=new Reglement();
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());

	        document.open();
	        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        fontTitle.setSize(18);
	        //if(r.getEmployees()!= null){
	        //Paragraph paragraph = new Paragraph("Finanacial commitment of mr /miss "+r.getEmployees(), fontTitle);
	        Paragraph paragraph = new Paragraph("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii", fontTitle);

	        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

	        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
	        fontParagraph.setSize(12);

	        Paragraph paragraph2 = new Paragraph("tu est debiter de"+r.getMontant(), fontParagraph);
	        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

	        document.add(paragraph);
	        document.add(paragraph2);
	        document.close();
	       // }
	    }
}*/
