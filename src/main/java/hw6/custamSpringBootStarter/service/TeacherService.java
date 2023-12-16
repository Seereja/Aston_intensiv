package hw6.custamSpringBootStarter.service;



import hw6.custamSpringBootStarter.model.Teacher;
import hw6.custamSpringBootStarter.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Transactional
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @Transactional
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Teacher create(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Transactional
    public Teacher update(Teacher teacher, Long id) {
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }

    @Transactional
    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }

}
