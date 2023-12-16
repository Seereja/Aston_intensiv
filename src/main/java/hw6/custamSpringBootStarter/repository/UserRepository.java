package hw6.custamSpringBootStarter.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hw6.custamSpringBootStarter.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
