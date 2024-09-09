package operation.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class Operation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private LocalDate dateoperation;
	
	
	private String salle;
	
	@ManyToOne
	private Patient pat;
	@ManyToOne
	private Medecin med;
	@ManyToMany
	private List<EquipementMedical> equi;

	public Operation() {
		
	}
	public Operation(Long id, LocalDate date_debut, String salle, Patient pat, Medecin med,List<EquipementMedical> equi) {
		super();
		this.id = id;
		this.dateoperation = date_debut;
		this.salle = salle;
		this.pat = pat;
		this.med = med;
		this.equi = new ArrayList<>(equi);
	}
	public String getSalle() {
		return salle;
	}
	public void setSalle(String salle) {
		this.salle = salle;
	}
	public List<EquipementMedical> getEqui() {
		return equi;
	}
	public void setEqui(List<EquipementMedical> equi) {
		this.equi = equi;
	}
	public Patient getPat() {
		return pat;
	}
	public void setPat(Patient pat) {
		this.pat = pat;
	}
	public Medecin getMed() {
		return med;
	}
	public void setMed(Medecin med) {
		this.med = med;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDateoperation() {
		return dateoperation;
	}
	public void setDateoperation(LocalDate date_debut) {
		this.dateoperation = date_debut;
	}
	
	
	
	
}
