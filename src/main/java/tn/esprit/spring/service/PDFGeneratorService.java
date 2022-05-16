package tn.esprit.spring.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import tn.esprit.spring.entity.Inscription;

@Service
public class PDFGeneratorService {
	 public void export(HttpServletResponse response,Inscription inscription) throws IOException {
	        
		 	Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());

	        
	        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        fontTitle.setSize(18);
	        Paragraph paragraph = new Paragraph("Engagement", fontTitle);

	        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

	        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
	        fontParagraph.setSize(12);

	        Paragraph paragraph2 = new Paragraph("Je soussigné(e):"
	        		+ "Déclare sur l’honneur l’exactitude de toutes les informations figurant dans le présent dossier"
	        		+ "M’engage à respecter les programmes et référentiels de la formation « Compétences de Base en Prévention »"
	        		+ "", fontParagraph);
	        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

	        document.add(paragraph);
	        document.add(paragraph2);
	        document.close();
	                
	    }
}