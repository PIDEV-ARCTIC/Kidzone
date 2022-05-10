package tn.esprit.spring.service;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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

import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.repository.JardinRepository;
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
	@Autowired
	JardinRepository JardinRepository;
	
	public List <Enfant> GetEnfant(){
		return EnfantRepository.findAll();
	}
	/*public Enfant GetEnfantbyName(String nomprenomenfant) {
		return EnfantRepository.findByNomprenomenfant(nomprenomenfant);
	
	}*/
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
		existingEnfant.setNomenfant(Enfant.getNomenfant());
		existingEnfant.setPrenomenfant(Enfant.getPrenomenfant());
		existingEnfant.setAdresseEnfant(Enfant.getAdresseEnfant());
		existingEnfant.setNomprenomparent(Enfant.getNomprenomparent());
		existingEnfant.setNumtel(Enfant.getNumtel());
		existingEnfant.setPhoto(Enfant.getPhoto());
		return EnfantRepository.save(Enfant);
	}
	public byte[] genrateAndDownloadQRCode(Enfant enfant, int width, int height, String filePath) throws Exception{

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode( enfant.getIdenfant()+"\n"+enfant.getNomenfant()+"\n"+enfant.getPrenomenfant()+"\n"+enfant.getAdresseEnfant()+"\n"+
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

	public Enfant ajouterEnfant(String nomenfant,
			String prenomenfant,
			String adresseEnfant,
			String age, 
			String classe, 
			String photo, 
			String nomprenomparent,
			String numtel,
			String gender,
			String mail,
			String qrCodeImageEnfant,
			long idjardin){
		
		Jardin jardin = JardinRepository.findByIdjardin(idjardin);
		Enfant p = new Enfant();
		p.setNomenfant(nomenfant);
		p.setPrenomenfant(prenomenfant);
		p.setAdresseEnfant(adresseEnfant);
		p.setAge(age);
		p.setClasse(classe);
		p.setPhoto(photo);
		p.setNomprenomparent(nomprenomparent);
		p.setNumtel(numtel);
		p.setGender(gender);
		p.setMail(mail);
		p.setQrCodeImageEnfant(qrCodeImageEnfant);
		p.setJardin(jardin);
		
		return EnfantRepository.save(p);
	}
	public Enfant ajouterphoto( 
			String photo){
		
		Enfant p = new Enfant();
	
		p.setPhoto(photo);
		
		return EnfantRepository.save(p);
	}
	
	private void saveFile(InputStream inputStream, String path){
		try{
			OutputStream outputStream = new FileOutputStream(new File(path));
			int read = 0;
			byte [] bytes = new byte[1024];
			while((read = inputStream.read(bytes)) != 1){
				outputStream.write(bytes, 0, read);
			}
			outputStream.flush();
			outputStream.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
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
	public String FindMailParent(long idenfant){
		 return EnfantRepository.findById(idenfant).get().getMail();
	}
	
	public String FindNameParent(long idenfant){
		 return EnfantRepository.findById(idenfant).get().getNomprenomparent();
	}
	
	public String FindNameChild(long idenfant){
		 return EnfantRepository.findById(idenfant).get().getNomenfant();
	}
	public String FindSurNameChild(long idenfant){
		 return EnfantRepository.findById(idenfant).get().getPrenomenfant();
	}
	

	
	
}