package projet2k18;

import java.io.Serializable;




public class PersonneInfo implements Serializable{

	
/**
 * 
 *  <b>PersonneInfo permet de creer l'objet qui sera sérializé.</b>
 * <p>
 * L'objet PersonneInfo est la base qui permet la création des contacts 
 * C'est ici qu'on a les infos des contacts qui devront être  inscrits dans ContactAppli
 * </p>
 * 
 * 
 * 
 * 
 * 
 * @see ContactAppli
 * @author Victor
 */
	 
	private static final long serialVersionUID = 1L;
	public String prenom;
	public String nom;
	public String adresse;
	public String telephone;
	public String email;
	public String photo;




	
	
	public PersonneInfo(String prenom, String nom, String telephone, String adresse,String email, String photo){
		
		this.prenom = prenom;
		this.nom = nom ;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.photo = photo;
		
		
	}
public PersonneInfo(String prenom, String nom, String telephone, String adresse,String email){
		
		this.prenom = prenom;
		this.nom = nom ;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		
		
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}	


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}
	

}
