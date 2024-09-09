package operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import operation.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

	
	User findByUserId(String userId);
	
}
