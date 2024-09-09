package operation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Patient {

	@Id
	private String cin;
	private String nom;
	private String prenom;
	private int age;
	private String sexe;
	
	public Patient(String nom) {
		super();
		this.nom = nom;
	}
	public Patient() {
		
	}
	public Patient(String cin, String nom, String prenom, int age, String sexe) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.sexe = sexe;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	@Override
	public String toString() {
		return "Patient [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", sexe=" + sexe + "]";
	}
	
	
}
