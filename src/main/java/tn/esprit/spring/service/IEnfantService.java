package tn.esprit.spring.service;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

import tn.esprit.spring.entity.Enfant;

//import aces.esprit.entity.AgeRecommandationProduct;
//import aces.esprit.entity.GenderRecommandation;
//import aces.esprit.entity.Product;

public interface IEnfantService {
	
	//void addProduct(Product product);
	//List<Product> getAllProducts();
	//Product getProductById(int id);
//	void updateProduct(Product product, int idProd);
	void deleteProductById(int id);
	void deleteAllProducts();
	public void affectProductToCategory(int idProd, int idCat);
	public List<String> getAllProductsNamesByCategory(int idCat);

	int getNbrProducts();
	///List<Product> getNewProducts();
	String readAndCheckImage(String path) throws FileNotFoundException, IOException, NotFoundException, ChecksumException, FormatException;
	
	void generateImageBarcode(int idProd, String image_name, String barcode);
	
	void generateImageBarcodee(String image_name, String barcode) throws Exception;
	
	byte[] genrateAndDownloadQRCode(String text, int width, int height, String filePath) throws Exception;
	byte[] getBarCodeImage(String text, int width, int height, String filePath) throws Exception;
	//List<Product> RecommendedProduct(int id);

	
	List<String> search(String keyword);
	
	//void desaffecterProductFromCategory(int idProd, int idCat);
	
//	Product addOneProduct(String name, String imgNameBarcode, String imgName, String barcode) throws Exception;
	
	 Enfant ajouterEnfant(String nomprenomenfant, 
				String age, 
				String classe, 
				String photo, 
				String qrCodeImageEnfant);



	
}
