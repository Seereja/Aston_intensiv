package hw6.customSpringBootStarter.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hw6.customSpringBootStarter.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

//    public List<Teacher> findAllBySectionsId(Long id);
}
