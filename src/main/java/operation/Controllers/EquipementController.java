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
import operation.model.EquipementMedical;
import operation.service.EquipementService;

@RestController
@RequestMapping("/equipemets")
@CrossOrigin(origins = "http://localhost:4200")
public class EquipementController {
	@Autowired
	EquipementService equipementService;
	

	@PostMapping("/addEquipemet")
	public EquipementMedical addEquipemet(@RequestBody  EquipementMedical doc) {
		return equipementService.addEquipement(doc);
	}
	
	@PostMapping("/addPatients")
	public List<EquipementMedical> addEquipemets(@RequestBody  List<EquipementMedical> doc) {
		return equipementService.addEquipements(doc);
	}
	
	 @GetMapping("/getPatientByID/{id}")
	    public EquipementMedical getEquipemetById(@PathVariable Long mat) {
	        return equipementService.getEquipementByID(mat);
	 }
	 
	 @GetMapping("/getAllEquipemets")
	    public List<EquipementMedical> getAllEquipemets() {
	        return equipementService.getAllEquipements();
	 }
	 
	 @PutMapping("/updateEquipemet")
	    public EquipementMedical updateEquipemet(@RequestBody EquipementMedical doc) {
	        return equipementService.updateEquipement(doc);
	 }
	 
	 @DeleteMapping("/deleteEquipemetsById/{id}")
	    public boolean deleteEquipemetByID(@PathVariable Long id) {
	        return equipementService.deleteEquipementByID(id);
	 }
	

}
