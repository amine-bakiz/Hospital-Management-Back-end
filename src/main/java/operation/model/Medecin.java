package operation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Medecin {
	
	@Id
	private String matricule;
	private String nom;
	private String prenom;
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Medecin(String nom) {
		super();
		this.nom = nom;
	}
	public Medecin() {
		
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
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
	
	

}
