package ru.shilo.repository.repositoryAbstract;

import hw4_smale_project_with_hibirnate.DTO.SectionDTO;
import hw4_smale_project_with_hibirnate.model.Section;

import java.sql.SQLException;
import java.util.List;

public interface SectionDAO {

    public SectionDTO findSectionByTeacherId(int id);

    public List<SectionDTO> getAllSection() throws SQLException;

    void saveSection(Section section);

    SectionDTO getSectionById(int id);

    void deleteSectionById(int id);

}
