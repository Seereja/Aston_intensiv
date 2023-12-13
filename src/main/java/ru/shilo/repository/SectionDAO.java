package ru.shilo.repository;

import ru.shilo.config.DBConfig;
import ru.shilo.mapper.SectionMapper;
import ru.shilo.model.Section;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionDAO {

    private final DBConfig dbConfig;

    private final SectionMapper sectionMapper;

    public SectionDAO(DBConfig dbConfig, SectionMapper sectionMapper) {
        this.dbConfig = dbConfig;
        this.sectionMapper = sectionMapper;
    }

    public SectionDAO(DBConfig dbConfig, SectionMapper sectionMapper, DBConfig dbConfig1, SectionMapper sectionMapper1) {
        this.dbConfig = dbConfig1;
        this.sectionMapper = sectionMapper1;
    }

    public Section findSectionByTeacherId(int id) throws SQLException, ClassNotFoundException {

        Section section = new Section();
        try (Connection connection = DBConfig.connection()) {
            //получаем коннекшн
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT sections.id, sections.name " +
                            "FROM teachers " +
                            "JOIN sections ON teachers.section_id = sections.id " +
                            "WHERE teachers.id = ?;");
            preparedStatement.setInt(1, id);
            //получаем ресултсет
            ResultSet resultSet = preparedStatement.executeQuery();
            //достаем из резултсет
            while (resultSet.next()) {
                section = sectionMapper.toSectionOfString(resultSet);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return section;
    }
}

