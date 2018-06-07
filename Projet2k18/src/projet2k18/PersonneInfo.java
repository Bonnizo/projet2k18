package projet2k18;

import java.io.Serializable;

import javax.swing.ImageIcon;



public class PersonneInfo implements Serializable{

	private int id;
	static String prenom;
	private String nom;
	private String adresse;
	private String telephone;
	private String email;
	private ImageIcon photo;


	
	
	public PersonneInfo(int id, String prenom, String nom, String adresse, String telephone, String email, ImageIcon photo){
		
		this.id = id;
		this.prenom = prenom;
		this.nom = nom ;
		this.telephone = telephone;
		this.adresse = adresse;
		this.email = email;
		setPhoto(photo);
		
	}
	
	
	public void setPhoto(ImageIcon photo)
	{
		this.photo = photo;
		
	}



	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
		
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
