package operation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import operation.model.Patient;
import operation.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	
	public Patient addPatient(Patient doc) {
		return patientRepository.save(doc);
	}

	public List<Patient> addPatients(List<Patient> doc) {
		return patientRepository.saveAll(doc);
	}
	
	public Patient getPatientByID(String mat) {
        return patientRepository.findById(mat).orElse(null);
    }
	
	public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
	
	public Patient updatePatient(Patient doc) {
		    Patient existingEMP = patientRepository.findById(doc.getCin()).orElse(null);
	        System.out.println(doc);
	        if(existingEMP == null) {
	            System.out.println("Emp not found");
	            return  patientRepository.save(doc);
	        }else  {
	            existingEMP.setCin(doc.getCin());
	            existingEMP.setNom(doc.getNom());
	            existingEMP.setPrenom(doc.getPrenom());
	            existingEMP.setAge(doc.getAge());
	            existingEMP.setSexe(doc.getSexe());
	            patientRepository.save(existingEMP);
	        }
	        return doc;
	 }
	
	public boolean deletePatientByID(String cin) {
		Patient existingEMP = patientRepository.getById(cin);
        if(existingEMP != null) {
        	patientRepository.deleteById(cin);
            return true;
        }
        return false;
    }

}
