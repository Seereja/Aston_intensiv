package ru.shilo.service.serviceAbstract;

import hw4_smale_project_with_hibirnate.DTO.TeacherDTO;
import hw4_smale_project_with_hibirnate.model.Teacher;

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
