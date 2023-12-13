package ru.shilo.service;

import hw4_smale_project_with_hibirnate.DTO.SectionDTO;
import hw4_smale_project_with_hibirnate.model.Section;
import hw4_smale_project_with_hibirnate.repository.SectionDAOImp;
import hw4_smale_project_with_hibirnate.service.serviceAbstract.SectionService;

import java.util.List;

public class SectionServiceImpl implements SectionService {

    private final SectionDAOImp sectionDAOImp;


    public SectionServiceImpl(SectionDAOImp sectionDAO) {
        this.sectionDAOImp = sectionDAO;
    }

    public SectionServiceImpl() {
        this.sectionDAOImp = new SectionDAOImp();
    }

    @Override
    public SectionDTO findSectionByTeacherId(int id) {
        return sectionDAOImp.findSectionByTeacherId(id);
    }

    @Override
    public List<SectionDTO> getAllSection() {
        List<SectionDTO> sections = sectionDAOImp.getAllSection();
        sections.forEach(System.out::println);
        return sections;
    }

    @Override
    public void saveSection(Section section) {
        sectionDAOImp.saveSection(section);
    }

    @Override
    public SectionDTO getSectionById(int id) {
        return sectionDAOImp.getSectionById(id);
    }

    @Override
    public void deleteSectionById(int id) {
        sectionDAOImp.deleteSectionById(id);
    }



}
