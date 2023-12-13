package ru.shilo.service;


import jakarta.transaction.Transactional;
import ru.shilo.DTO.TeacherDTO;
import ru.shilo.model.Teacher;
import ru.shilo.repository.TeacherDAOImpl;
import ru.shilo.service.serviceAbstract.TeacherService;

import java.sql.SQLException;
import java.util.List;


public class TeacherServiceImpl implements TeacherService {

    private final TeacherDAOImpl teacherDAOImpl;

    public TeacherServiceImpl(TeacherDAOImpl teacherDAOImpl) {
        this.teacherDAOImpl = teacherDAOImpl;
    }

    public TeacherServiceImpl() {
        this.teacherDAOImpl = new TeacherDAOImpl();
    }

    @Override
    @Transactional
    public List<TeacherDTO> getAllTeacher() throws SQLException {
        List<TeacherDTO> teachers = teacherDAOImpl.getAllTeacher();
        teachers.stream().forEach(System.out::println);
        return teachers;
    }

    @Override
    @Transactional
    public void saveTeacher(Teacher teacher) {
        teacherDAOImpl.saveTeacher(teacher);
    }

//    @Override
//    public void saveUserAndTeacherAndSection(User user, Teacher teacher) {
//        teacherDAOImpl.saveUserAndTeacherAndSection(user, teacher);
//    }

    @Override
    public TeacherDTO getTeacherById(int id) {
        return teacherDAOImpl.getTeacherById(id);
    }

    @Override
    @Transactional
    public void deleteTeacherById(int id) {
        teacherDAOImpl.deleteTeacherById(id);
    }
}
