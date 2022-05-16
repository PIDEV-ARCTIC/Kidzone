package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.Utilisateur;
import tn.esprit.spring.entity.type;

import tn.esprit.spring.controller.EmailSenderServicenour;
import tn.esprit.spring.repository.ReclamationRepository;
import tn.esprit.spring.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import dto.Reclamationtaux;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReclamationService implements Ireclamation {
	@Autowired
	ReclamationRepository repo;
	@Autowired
	UserService seruser;
	@Autowired
	EmailSenderServicenour es ;
	@Override
	public Reclamation ajouterReclamation(Reclamation r) {
		 repo.save(r);
		return r;
	}

	

	@Override
	public void deletReclamation(long idreclamation) {
	 repo.deleteById(idreclamation);
		
	}

	@Override
	public List<Reclamation> getallReclamation() {
		
		return   (List<Reclamation>) this.repo.findAll();
		
	}
	@Override
	public Reclamation updateReclamation(Reclamation r) {
		
		this.repo.save(r);
		return r;
	}

/*

	@Override
	public Reclamation addReclamation(Reclamation r, Long idutilisateur) {
		Utilisateur user = seruser.retrieveUser(idutilisateur);
		r.setUser(user);
		
		
		
		return repo.save(r);
	}

*/

	@Override
	public Reclamation retrieveReclamation(Long idreclamation) {
		// TODO Auto-generated method stub
		return repo.findById(idreclamation).get();
	}
	
	
	@Override
	public List<String> findbytype() {
		// TODO Auto-generated method stub
		return repo.findbytype();
	}

	@Override
	public List<String> findbytypenumber() {
		// TODO Auto-generated method stub
		return repo.findbytypenumber();
	}
	
	public List<Reclamationtaux> tauxParticipation(){
	    List<Reclamationtaux> eventList = new ArrayList<>();
	   
        eventList.add( convertdtoreclamation(type.OnEntreprise));
        eventList.add( convertdtoreclamation(type.OnService));

	       
	        eventList.add( convertdtoreclamation(type.OnEmployee));
	    
	    return  eventList;}
	
public Reclamationtaux convertdtoreclamation(type type  ){
	Reclamationtaux rt = new Reclamationtaux();
	rt.setTaux((int) repo.findAll().stream().filter(r->r.getTypereclamation().equals(type)).count()*100/repo.findAll().size()) ;
	rt.setText((int) repo.findAll().stream().filter(r->r.getTypereclamation().equals(type)).count()*100/repo.findAll().size()+"%");
	rt.setTitle(type.name());
	return rt;
	
}
	
	
	/*
 * 

	@Override

	public String BlockComplaint (long  idreclamation) {
		Reclamation com  = (Reclamation) repo.findById(idreclamation).get();
		String[] Badwords = {"shit" ,"badword" ,"euw"};
		String ret = null;
		String input = com.getDescription();
		for (String item : Badwords) {
				if (input.contains(item)) {
					com.setBlocked(true);
					repo.save(com);
					 ret ="Complaint blocked";
					 break ; 
					
					} 
					else 
						{com.setBlocked(false);
						ret="Complaint clean";
						}
				}			
		return ret;
	}
	*/
	
	///////////////////////////////////////////filtrage b fichier ecxcel
	/*
	public void scan(){
	List <Reclamation> complist = (List<Reclamation>) repo.findAll();
	List <Integer> comp_id = new ArrayList<Integer>();
	for(int i=0 ; i<complist.size() ;i++){
	String output = BadWordFilter.getCensoredText(complist.get(i).getDescription());
	if (output.length()>2){
	comp_id.add(complist.get(i).getIdreclamation());
	}
	}
	for(int j=0 ; j<comp_id.size() ;j++){
		repo.deleteById(comp_id.get(j));
	}
	}*/
	
	@Override
	public void forgotpass(String mail) {
		// TODO Auto-generated method stub
		log.info("tzzqté");
		Reclamation r = repo.findByMail(mail);

		final String username = "nourelhouda.fdhila@esprit.tn";
		final String password = "ogdw vsfe imbw pefj";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("nourelhouda.fdhila@esprit.tn"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
			message.setSubject("Reset Your Password");
			message.setText("This a non reply message from DariTn\n " + "Dear Client \n"
					+ "Please follow the following link to reser your password: \n" + "http://localhost:4200/update");

			Transport.send(message);

			

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}



	@Override
	public void getQuantiteRestante(long idreclamation) {

		Reclamation reclamation = (Reclamation) repo.findById(idreclamation).orElse(null);
		
		String q =reclamation.getMail();
		String msg="hello";
		String objet ="reclzmaton";
		
		String text = "la quantite de stock est ";
		//ENVOIE MAIL NO MORE STOCK
		es.SendEmail( q,msg,objet);
		
		// TODO Auto-generated method stub
		
	}




	
	
	
	}
	
	

	