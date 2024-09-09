package operation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import operation.model.EquipementMedical;
import operation.model.Patient;
import operation.repository.EquipementRepository;
import operation.repository.PatientRepository;

@Service
public class EquipementService {
	
	@Autowired
	EquipementRepository equipementRepository;
	
	public EquipementMedical addEquipement(EquipementMedical doc) {
		return equipementRepository.save(doc);
	}

	public List<EquipementMedical> addEquipements(List<EquipementMedical> doc) {
		return equipementRepository.saveAll(doc);
	}
	
	public EquipementMedical getEquipementByID(Long mat) {
        return equipementRepository.findById(mat).orElse(null);
    }
	
	public List<EquipementMedical> getAllEquipements() {
        return equipementRepository.findAll();
    }
	
	public EquipementMedical updateEquipement(EquipementMedical doc) {
		EquipementMedical existingEMP = (EquipementMedical) equipementRepository.findByNom(doc.getNom());
	        System.out.println(doc);
	        if(existingEMP == null) {
	            System.out.println("Emp not found");
	            return  equipementRepository.save(doc);
	        }else  {
	        
	            existingEMP.setNom(doc.getNom());
	            existingEMP.setQuantite(doc.getQuantite());
	            equipementRepository.save(existingEMP);
	        }
	        return doc;
	 }
	
	public boolean deleteEquipementByID(Long cin) {
		EquipementMedical existingEMP = equipementRepository.getById(cin);
        if(existingEMP != null) {
        	equipementRepository.deleteById(cin);
            return true;
        }
        return false;
    }
}
