package ru.shilo.service.serviceAbstract;



import ru.shilo.DTO.TeacherDTO;
import ru.shilo.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherService {
    public List<TeacherDTO> getAllTeacher() throws SQLException;

    void saveTeacher(Teacher teacher);

//    void saveTeacherAndSection(User user, Section section);

//    void saveUserAndTeacherAndSection(User user, Teacher teacher);

    TeacherDTO getTeacherById(int id);

    void deleteTeacherById(int id);
}
