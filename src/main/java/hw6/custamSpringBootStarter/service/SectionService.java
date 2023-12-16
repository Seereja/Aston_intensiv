package hw6.custamSpringBootStarter.service;


import hw6.custamSpringBootStarter.model.Section;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hw6.custamSpringBootStarter.repository.SectionRepository;

import java.util.List;

@Service
@Transactional
public class SectionService {


    private final SectionRepository sectionRepository;

    @Autowired
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Transactional
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    @Transactional
    public Section getSectionById(Long id) {
        return sectionRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Section create(Section section) {
        return sectionRepository.save(section);
    }

    @Transactional
    public Section update(Section section, Long id) {
        section.setId(id);
        return sectionRepository.save(section);
    }

    @Transactional
    public void deleteSectionById(Long id) {
        sectionRepository.deleteById(id);
    }


}
