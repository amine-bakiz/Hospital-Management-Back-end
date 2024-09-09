package operation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import operation.model.Medecin;
@Repository
public interface MedecinRepository extends JpaRepository<Medecin,String> {

	Optional<Medecin> findByNom(String nom);

}
