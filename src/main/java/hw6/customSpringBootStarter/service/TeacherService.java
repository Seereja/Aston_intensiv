package hw6.customSpringBootStarter.service;



import hw6.customSpringBootStarter.model.Teacher;
import hw6.customSpringBootStarter.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }


    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElseThrow();
    }


    public Teacher create(Teacher teacher) {
        return teacherRepository.save(teacher);
    }


    public Teacher update(Teacher teacher, Long id) {
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }


    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }

}
