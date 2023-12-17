package hw6.customSpringBootStarter.service;


import hw6.customSpringBootStarter.model.Section;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hw6.customSpringBootStarter.repository.SectionRepository;

import java.util.List;

@Service

public class SectionService {


    private final SectionRepository sectionRepository;

    @Autowired
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }


    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }


    public Section getSectionById(Long id) {
        return sectionRepository.findById(id).orElseThrow();
    }


    public Section create(Section section) {
        return sectionRepository.save(section);
    }


    public Section update(Section section, Long id) {
        section.setId(id);
        return sectionRepository.save(section);
    }


    public void deleteSectionById(Long id) {
        sectionRepository.deleteById(id);
    }


}
