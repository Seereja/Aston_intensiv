package ru.shilo.mapper;


import ru.shilo.model.Section;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionMapper {
    public Section toSection(ResultSet resultSet) throws SQLException {
        Section section = new Section();
        section.setSectionName(resultSet.getString("name"));
        return section;
    }

    public Section toSectionOfString(ResultSet resultSet) throws SQLException {
        Section sections = new Section();
        sections.setSectionName(resultSet.getString("name"));
        return sections;
    }
}
