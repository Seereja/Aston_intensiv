package hw5.smale.MVC.project.controller.mvc;


import hw5.smale.MVC.project.DTO.TeacherDTO;
import hw5.smale.MVC.project.mapperInterface.TeacherModelMapper;
import hw5.smale.MVC.project.model.Teacher;
import hw5.smale.MVC.project.service.TeacherService;
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
