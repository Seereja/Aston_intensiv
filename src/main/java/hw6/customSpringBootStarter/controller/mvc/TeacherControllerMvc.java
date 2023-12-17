package hw6.customSpringBootStarter.controller.mvc;


import hw6.customSpringBootStarter.DTO.TeacherDTO;
import hw6.customSpringBootStarter.mapperInterface.TeacherModelMapper;
import hw6.customSpringBootStarter.model.Teacher;
import hw6.customSpringBootStarter.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/teacher")
@EnableWebMvc
public class TeacherControllerMvc {
    private final TeacherService teacherService;

    @Autowired
    public TeacherControllerMvc(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping("/teachers")
    @ResponseBody
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teachers = teacherService.getTeachers();
        return teachers.stream()
                .map(TeacherModelMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public TeacherDTO getTeacherById(@PathVariable Long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        return TeacherModelMapper
                .INSTANCE
                .toDTO(teacher);
    }

    @PostMapping
    @ResponseBody
    public TeacherDTO createTeacher(@RequestBody Teacher teacher) {
        Teacher newTeacher = teacherService.create(teacher);
        return TeacherModelMapper.INSTANCE.toDTO(newTeacher);
    }

    @PutMapping("/{id}")
    @ResponseBody
    private TeacherDTO update(
            @RequestBody Teacher teacher,
            @PathVariable Long id) {
        Teacher newTeacher = teacherService.update(teacher, id);
        return TeacherModelMapper.INSTANCE.toDTO(newTeacher);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
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
