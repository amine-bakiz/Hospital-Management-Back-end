package operation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import operation.model.EquipementMedical;
import operation.model.Medecin;
import operation.model.Operation;
import operation.model.Patient;
import operation.repository.EquipementRepository;
import operation.repository.MedecinRepository;
import operation.repository.OperationRepository;
import operation.repository.PatientRepository;

@Service
public class OperationService {
	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
	MedecinRepository medecinRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	EquipementRepository equipementRepository;
	
	public OperationService(OperationRepository operationRepository, MedecinRepository medecinRepository,
			PatientRepository patientRepository, EquipementRepository equipementRepository) {
		super();
		this.operationRepository = operationRepository;
		this.medecinRepository = medecinRepository;
		this.patientRepository = patientRepository;
		this.equipementRepository = equipementRepository;
	}
	public OperationService() {
		
	}
	public OperationService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
	public Operation createOperation(Operation ope) {
		
		List<Operation> existingOperations = operationRepository.findBySalleAndDateoperation(ope.getSalle(), ope.getDateoperation());
		    if (!existingOperations.isEmpty()) {
		    	throw new RuntimeException("can't add oeration");
		    }
	
		Optional<Patient> pat = patientRepository.findByNom(ope.getPat().getNom());
	//	if(pat.isEmpty()) {
    //		throw new RuntimeException("Patient not found.");
    //	}
		
    	Optional<Medecin> med = medecinRepository.findByNom(ope.getMed().getNom());
    	if(med.isEmpty()) {
    		throw new RuntimeException("Medecin not found");
    	}
    
    	List<EquipementMedical> existingEquipements = new ArrayList<>();
    	for (EquipementMedical equipement : ope.getEqui()) {
            if (equipement.getId() != null) {
                // Existing EquipementMedical with ID provided
                EquipementMedical existingEquipement = equipementRepository.findById(equipement.getId())
                        .orElseThrow(() -> new RuntimeException("Equipement with ID " + equipement.getId() + " not found."));
                existingEquipements.add(existingEquipement);
            } else if (equipement.getNom() != null) {
                // EquipementMedical based on name
                List<EquipementMedical> equipementList = equipementRepository.findByNom(equipement.getNom());
                if (equipementList.isEmpty()) {
                    // No existing EquipementMedical with the given name, create a new one
                    EquipementMedical newEquipement = new EquipementMedical();
                    newEquipement.setNom(equipement.getNom());
                    // Set other properties if needed
                    newEquipement = equipementRepository.save(newEquipement);
                    existingEquipements.add(newEquipement);
                } else if (equipementList.size() == 1) {
                    // Exactly one existing EquipementMedical with the given name
                    existingEquipements.add(equipementList.get(0));
                } else {
                    // Handle the case where multiple EquipementMedical records have the same name
                    // You may throw an exception, log a warning, or take other appropriate action
                    throw new RuntimeException("Multiple EquipementMedical records found with the same name: " + equipement.getNom());
                }
            } else {
                throw new RuntimeException("Equipement ID or Name is required for existing Equipements.");
            }
        }
    
    	ope.setEqui(existingEquipements);
    	ope.setPat(pat.get());
    	ope.setMed(med.get());
    	
        return operationRepository.save(ope);
	}
	
	public List<Operation> getAllOperation(){
	    	return operationRepository.findAll();
	    }
	    
	 public void deleteByid(Long id) {
		 operationRepository.deleteById(id);
	    }

}
