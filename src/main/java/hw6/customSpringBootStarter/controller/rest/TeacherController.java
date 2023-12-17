package hw6.customSpringBootStarter.controller.rest;


import hw6.customSpringBootStarter.DTO.TeacherDTO;
import hw6.customSpringBootStarter.mapperInterface.TeacherModelMapper;
import hw6.customSpringBootStarter.model.Teacher;
import hw6.customSpringBootStarter.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping("/teachers")
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teachers = teacherService.getTeachers();
        return teachers.stream()
                .map(TeacherModelMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TeacherDTO getTeacherById(@PathVariable Long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        return TeacherModelMapper
                .INSTANCE
                .toDTO(teacher);
    }

    @PostMapping
    public TeacherDTO createTeacher(@RequestBody Teacher teacher) {
        Teacher newTeacher = teacherService.create(teacher);
        return TeacherModelMapper.INSTANCE.toDTO(newTeacher);
    }

    @PutMapping("/{id}")
    private TeacherDTO update(
            @RequestBody Teacher teacher,
            @PathVariable Long id) {
        Teacher newTeacher = teacherService.update(teacher, id);
        return TeacherModelMapper.INSTANCE.toDTO(newTeacher);
    }

    @DeleteMapping("/{id}")
    private void deleteUserById(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
    }

//    @GetMapping("/{id}/teachers")
//    private List<TeacherDTO> TeacherBySectionId(@PathVariable Long id) {
//        List<Teacher> teachers = teacherService.getAllBySectionId(id);
//        return teachers
//                .stream()
//                .map(TeacherModelMapper.INSTANCE::toDTO)
//                .collect(Collectors.toList());
//    }


}
