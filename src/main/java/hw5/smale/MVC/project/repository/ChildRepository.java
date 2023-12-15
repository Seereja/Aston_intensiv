package hw5.smale.MVC.project.repository;




import hw5.smale.MVC.project.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {


    public List<Child> findAllBySectionsId(Long sectionsId);

}
