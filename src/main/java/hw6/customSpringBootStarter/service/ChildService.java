package hw6.customSpringBootStarter.service;


import hw6.customSpringBootStarter.model.Child;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hw6.customSpringBootStarter.repository.ChildRepository;

import java.util.List;


@Service

public class ChildService {

    private final ChildRepository childRepository;

    @Autowired
    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }


    public List<Child> getChildren() {
        return childRepository.findAll();
    }


    public Child getChildById(Long id) {
        return childRepository.findById(id).orElseThrow();
    }


    public Child create(Child child) {
        return childRepository.save(child);
    }


    public Child update(Child child, Long id) {
        child.setId(id);
        return childRepository.save(child);
    }


    public void deleteChildById(Long id) {
        childRepository.deleteById(id);
    }


    public List<Child> getAllBySectionId(Long id) {
        return childRepository.findAllBySectionsId(id);

    }
}

