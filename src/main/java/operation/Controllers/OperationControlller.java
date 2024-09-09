package operation.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import operation.model.Operation;
import operation.service.OperationService;

@RestController
@RequestMapping("/operation")
@CrossOrigin(origins = "http://localhost:4200")
public class OperationControlller {
	
	@Autowired
	OperationService operationService;
	
	@GetMapping("/getAllOperation")
    public ResponseEntity<List<Operation>> getOperations(){
		List<Operation> operations = operationService.getAllOperation();
		return new ResponseEntity<>(operations, HttpStatus.OK);
	}
	
	@PostMapping("/addOperation")
    public Operation ajouterOperation(@RequestBody Operation ope) {
	        //Operation createdOperation = operationService.createOperation(ope);
	        return operationService.createOperation(ope);
	    }
	
	@DeleteMapping("/deleteOperationById/{id}")
	public ResponseEntity<Void> supprimerOperation(@PathVariable Long id){
		operationService.deleteByid(id);
		return ResponseEntity.noContent().build();
	}

}
