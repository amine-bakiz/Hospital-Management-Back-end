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

import operation.model.Medecin;
import operation.service.MedecinService;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "http://localhost:4200")
public class MedecinController {
	
	
	@Autowired
	private MedecinService medecinService;
	
	@PostMapping("/addDoctor")
	public Medecin addMedecin(@RequestBody  Medecin doc) {
		return medecinService.addDoctor(doc);
	}
	
	@PostMapping("/addDoctors")
	public List<Medecin> addMedecins(@RequestBody  List<Medecin> doc) {
		return medecinService.addDoctors(doc);
	}
	
	 @GetMapping("/getDoctorByID/{id}")
	    public Medecin getDoctorById(@PathVariable String mat) {
	        return medecinService.getDoctorByID(mat);
	 }
	 
	 @GetMapping("/getAllDoctors")
	    public List<Medecin> getAllDoctors() {
	        return medecinService.getAllDoctors();
	 }
	 
	 @PutMapping("/updateDoctor")
	    public Medecin updateDoctor(@RequestBody Medecin doc) {
	        return medecinService.updateDoctor(doc);
	 }
	 
	 @DeleteMapping("/deleteDoctorById/{matricule}")
	    public boolean deleteDoctorByID(@PathVariable String matricule) {
	        return medecinService.deleteDoctorByID(matricule);
	 }
	

	
	
	

}
