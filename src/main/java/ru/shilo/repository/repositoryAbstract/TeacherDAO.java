package ru.shilo.repository.repositoryAbstract;



import ru.shilo.DTO.TeacherDTO;
import ru.shilo.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDAO {
    public List<TeacherDTO> getAllTeacher() throws SQLException;

    void saveTeacher(Teacher teacher);

    TeacherDTO getTeacherById(int id);

    void deleteTeacherById(int id);
}
