package operation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import operation.model.EquipementMedical;

@Repository
public interface EquipementRepository extends JpaRepository<EquipementMedical,Long>{
	
	List<EquipementMedical> findByNom(String nom);

	


}
