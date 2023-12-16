package hw6.custamSpringBootStarter.service;



import hw6.custamSpringBootStarter.model.Child;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hw6.custamSpringBootStarter.repository.ChildRepository;

import java.util.List;


@Service
@Transactional
public class ChildService {

    private final ChildRepository childRepository;
    @Autowired
    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @Transactional
    public List<Child> getChildren() {
        return childRepository.findAll();
    }

    @Transactional
    public Child getChildById(Long id) {
        return childRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Child create(Child child) {
        return childRepository.save(child);
    }

    @Transactional
    public Child update(Child child, Long id) {
        child.setId(id);
        return childRepository.save(child);
    }

    @Transactional
    public void deleteChildById(Long id) {
        childRepository.deleteById(id);
    }

    @Transactional
    public List<Child> getAllBySectionId(Long id) {
        return childRepository.findAllBySectionsId(id);

    }
}

