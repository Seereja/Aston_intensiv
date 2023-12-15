package hw5.smale.MVC.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hw5.smale.MVC.project.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

//    public List<Teacher> findAllBySectionsId(Long id);
}
