package operation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import operation.model.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient,String> {

	Optional<Patient> findByNom(String string);

}
