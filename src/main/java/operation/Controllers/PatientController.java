package operation.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import operation.model.Patient;

import operation.service.PatientService;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PostMapping("/addPatient")
	public Patient addPatient(@RequestBody  Patient doc) {
		return patientService.addPatient(doc);
	}
	
	@PostMapping("/addPatients")
	public List<Patient> addPatients(@RequestBody  List<Patient> doc) {
		return patientService.addPatients(doc);
	}
	
	 @GetMapping("/getPatientByID/{id}")
	    public Patient getPatientById(@PathVariable String mat) {
	        return patientService.getPatientByID(mat);
	 }
	 
	 @GetMapping("/getAllPatients")
	    public List<Patient> getAllPatients() {
	        return patientService.getAllPatients();
	 }
	 
	 @PutMapping("/updatePatient")
	    public Patient updatePatient(@RequestBody Patient doc) {
	        return patientService.updatePatient(doc);
	 }
	 
	 @DeleteMapping("/deletePatientById/{cin}")
	    public boolean deletePatientByID(@PathVariable String cin) {
	        return patientService.deletePatientByID(cin);
	 }
	
}
