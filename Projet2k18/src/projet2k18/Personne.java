package projet2k18;

public class Personne {

	
	protected String prenom ;
	protected String nom ;
	protected String adresse;
	protected String telephone;
	protected String email;
	protected String anniversaire;
	
	
	
	
	public Personne (String prenom , String nom,String adresse,String telephone, String email,String anniversaire) {
		
		
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.anniversaire = anniversaire;
		
		
		
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




	public String getAnniversaire() {
		return anniversaire;
	}




	public void setAnniversaire(String anniversaire) {
		this.anniversaire = anniversaire;
	}
}
