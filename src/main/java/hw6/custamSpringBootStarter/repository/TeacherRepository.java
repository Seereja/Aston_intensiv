package hw6.custamSpringBootStarter.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hw6.custamSpringBootStarter.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

//    public List<Teacher> findAllBySectionsId(Long id);
}
