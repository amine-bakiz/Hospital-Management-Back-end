package operation.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import operation.model.Operation;
@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {

	List<Operation> findBySalleAndDateoperation(String salle, LocalDate dateoperation);

}
