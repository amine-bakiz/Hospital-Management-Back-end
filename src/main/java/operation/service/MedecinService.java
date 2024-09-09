package operation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import operation.model.Medecin;
import operation.repository.MedecinRepository;

@Service
public class MedecinService {
	@Autowired
	private MedecinRepository medecinRepository;
	
	public Medecin addDoctor(Medecin doc) {
		return medecinRepository.save(doc);
	}

	public List<Medecin> addDoctors(List<Medecin> doc) {
		return medecinRepository.saveAll(doc);
	}
	
	public Medecin getDoctorByID(String mat) {
        return medecinRepository.findById(mat).orElse(null);
    }
	
	public List<Medecin> getAllDoctors() {
        return medecinRepository.findAll();
    }
	
	public Medecin updateDoctor(Medecin doc) {
		  Medecin existingEMP = medecinRepository.findById(doc.getMatricule()).orElse(null);
	        System.out.println(doc);
	        if(existingEMP == null) {
	            System.out.println("Emp not found");
	            return  medecinRepository.save(doc);
	        }else  {
	            existingEMP.setMatricule(doc.getMatricule());
	            existingEMP.setNom(doc.getNom());
	            existingEMP.setPrenom(doc.getPrenom());
	            medecinRepository.save(existingEMP);
	        }
	        return doc;
	 }
	
	public boolean deleteDoctorByID(String matricule) {
		Medecin existingEMP = medecinRepository.getById(matricule);
        if(existingEMP != null) {
        	medecinRepository.deleteById(matricule);
            return true;
        }
        return false;
    }

}
