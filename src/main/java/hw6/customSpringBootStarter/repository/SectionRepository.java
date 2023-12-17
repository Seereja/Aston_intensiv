package hw6.customSpringBootStarter.repository;


import hw6.customSpringBootStarter.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {


}
