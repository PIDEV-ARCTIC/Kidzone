package tn.esprit.spring.service;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Fournisseur;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.service.*;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;

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
import javax.imageio.ImageIO;

@Service
public class FournisseurService  {

	@Autowired
	FournisseurRepository fournisseurRepository;
	
	public Fournisseur addFournisseur(Fournisseur f) {
		return fournisseurRepository.save(f);
	}
	public void deleteFournisseur(long id) {
		// TODO Auto-generated method stub
		fournisseurRepository.deleteById(id);
		

		
	}
	public Fournisseur updateFournisseur(Fournisseur f) {
		// TODO Auto-generated method stub
		return fournisseurRepository.save(f);
	}
	public List <Fournisseur> GetFournisseur(){
		return fournisseurRepository.findAll();
	}
	public Fournisseur FindFournisseur(long id){
		return fournisseurRepository.findById(id).get();
	}
	public Fournisseur UpdateFournisseur(Fournisseur f){
		Fournisseur existingFournisseu = fournisseurRepository.findById(f.getIdfournisseur()).orElse(null);
		existingFournisseu.setDomaine(f.getDomaine());existingFournisseu.setMailfournisseur(f.getMailfournisseur());
		existingFournisseu.setNomfournisseur(f.getNomfournisseur());existingFournisseu.setPrenomfournisseur(f.getPrenomfournisseur());
		existingFournisseu.setTelfournisseur(f.getTelfournisseur());
		return fournisseurRepository.save(f);
	}
	public Fournisseur GetFournByName(String NomFournisseur) {
		return fournisseurRepository.findByNomfournisseur(NomFournisseur);
	
	}
	
	public String FindMailF(long id){
		 return fournisseurRepository.findById(id).get().getMailfournisseur();
	}


}
