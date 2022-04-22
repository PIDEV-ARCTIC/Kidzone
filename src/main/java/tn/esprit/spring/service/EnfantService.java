package tn.esprit.spring.service;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;


import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;

import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.repository.EnfantRepository;
//import tn.esprit.spring.service.*;
//import tn.esprit.spring.service.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;



@Service
public class EnfantService  {

	@Autowired
	EnfantRepository EnfantRepository;
	
	public List <Enfant> GetEnfant(){
		return EnfantRepository.findAll();
	}
	public Enfant GetEnfantbyName(String nomprenomenfant) {
		return EnfantRepository.findByNomprenomenfant(nomprenomenfant);
	
	}
	public Enfant GetEnfantbyID(Long idenfant) {
		return EnfantRepository.findById(idenfant).get();
	
	}
	public Enfant addEnfant(Enfant Enfant) {
		return EnfantRepository.save(Enfant);
	}
	
	public void deleteEnfant(Long idenfant) {
		EnfantRepository.deleteById(idenfant);
		
	}
	public Enfant UpdateEnfant(Enfant Enfant){
		Enfant existingEnfant = EnfantRepository.findById(Enfant.getIdenfant()).orElse(null);
		existingEnfant.setAge(Enfant.getAge());
		existingEnfant.setClasse(Enfant.getClasse());
		existingEnfant.setJardin(Enfant.getJardin());
		existingEnfant.setNomprenomenfant(Enfant.getNomprenomenfant());
		existingEnfant.setNomprenomparent(Enfant.getNomprenomparent());
		existingEnfant.setNumtel(Enfant.getNumtel());
		existingEnfant.setPhoto(Enfant.getPhoto());
		return EnfantRepository.save(Enfant);
	}
	public byte[] genrateAndDownloadQRCode(Enfant enfant, int width, int height, String filePath) throws Exception{

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode( enfant.getIdenfant()+"\n"+enfant.getNomprenomenfant()+"\n"+
				enfant.getAge() + "\n" + enfant.getClasse() + "\n"+enfant.getPhoto()+"\n"+enfant.getNomprenomparent()+"\n"+enfant.getMail()+"\n"+enfant.getNumtel()+"\n"
				+ enfant.getJardin() + "\n", BarcodeFormat.QR_CODE, width, height);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
		
		Path path = FileSystems.getDefault().getPath(filePath);
		
		FileOutputStream out = new FileOutputStream(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "png", path);
		
		System.out.println(out);
		
		return byteArrayOutputStream.toByteArray();

	}
	public String readQRCode(String qrcodeImage) throws Exception {
		BufferedImage bufferedImage = ImageIO.read(new File(qrcodeImage));
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		Result result = new MultiFormatReader().decode(binaryBitmap);
		return result.getText();}

	public Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Enfant ajouterEnfant(String nomprenomenfant, 
			String age, 
			String classe, 
			String photo, 
			String nomprenomparent,
			String numtel,
			String mail,
			String qrCodeImageEnfant,
			tn.esprit.spring.entity.Jardin jardin){
		
		Enfant p = new Enfant();
		p.setNomprenomenfant(nomprenomenfant);
		p.setAge(age);
		p.setClasse(classe);
		p.setPhoto(photo);
		p.setNomprenomparent(nomprenomparent);
		p.setNumtel(numtel);
		p.setMail(mail);
		p.setQrCodeImageEnfant(qrCodeImageEnfant);
		p.setJardin(jardin);
		
		return EnfantRepository.save(p);
	}
	
	public byte[] genrateAndDownloadQRCode2(String text, int width, int height, String filePath) throws Exception{

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
		
		Path path = FileSystems.getDefault().getPath(filePath);
		
		FileOutputStream out = new FileOutputStream(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "png", path);
		
		System.out.println(out);
		
		return byteArrayOutputStream.toByteArray();

	}

	
	
}