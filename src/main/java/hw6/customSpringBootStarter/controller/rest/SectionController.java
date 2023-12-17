package hw6.customSpringBootStarter.controller.rest;


import hw6.customSpringBootStarter.DTO.SectionDTO;
import hw6.customSpringBootStarter.mapperInterface.SectionModelMapper;
import hw6.customSpringBootStarter.model.Section;
import hw6.customSpringBootStarter.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/section")
public class SectionController {
    private final SectionService sectionService;

    @Autowired
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping("/sections")
    public List<SectionDTO> showAllSections() {
        List<Section> sections = sectionService.getAllSections();
        return sections.stream().map(SectionModelMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SectionDTO getSectionById(@PathVariable Long id) {
        Section section = sectionService.getSectionById(id);
        return SectionModelMapper.INSTANCE.toDTO(section);
    }

    @PostMapping
    public SectionDTO createSection(@RequestBody Section section) {
        Section newSection = sectionService.create(section);
        return SectionModelMapper.INSTANCE.toDTO(newSection);
    }

    @PutMapping("/{id}")
    private SectionDTO update(@RequestBody Section section, @PathVariable Long id) {
        Section newSection = sectionService.update(section, id);
        return SectionModelMapper.INSTANCE.toDTO(newSection);
    }

    @DeleteMapping("/{id}")
    private void deleteSectionById(@PathVariable Long id) {
        sectionService.deleteSectionById(id);
    }


}

