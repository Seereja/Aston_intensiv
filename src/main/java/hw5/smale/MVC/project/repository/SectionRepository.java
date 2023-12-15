package hw5.smale.MVC.project.repository;


import hw5.smale.MVC.project.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {


}
