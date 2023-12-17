package hw6.customSpringBootStarter.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hw6.customSpringBootStarter.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
