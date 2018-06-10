package projet2k18;

import java.io.Serializable;




public class PersonneInfo implements Serializable{

	
	public String prenom;
	public String nom;
	public String adresse;
	public String telephone;
	public String email;



	
	
	public PersonneInfo(String prenom, String nom, String adresse, String telephone,String email){
		
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

}
