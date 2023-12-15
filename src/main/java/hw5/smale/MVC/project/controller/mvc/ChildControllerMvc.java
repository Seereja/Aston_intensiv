package hw5.smale.MVC.project.controller.mvc;


import hw5.smale.MVC.project.DTO.ChildDTO;
import hw5.smale.MVC.project.model.Child;
import hw5.smale.MVC.project.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import hw5.smale.MVC.project.mapperInterface.ChildModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/child")
@EnableWebMvc
public class ChildControllerMvc {
    private final ChildService childService;

    @Autowired
    public ChildControllerMvc(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping("/children")
    public String showAllChildren(Model model) {
        List<Child> children = childService.getChildren();
        List<ChildDTO> childDTOS = children.stream()
                .map(ChildModelMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        model.addAttribute("allChild", childDTOS);
        return "children/children_page";

    }

    @GetMapping("/{id}")
    @ResponseBody
    public ChildDTO getChildById(@PathVariable Long id) {
        Child child = childService.getChildById(id);
        return ChildModelMapper.INSTANCE.toDTO(child);
    }

    @PostMapping
    @ResponseBody
    public ChildDTO createChildren(@RequestBody Child child) {
        Child newChild = childService.create(child);
        return ChildModelMapper.INSTANCE.toDTO(newChild);
    }

    @PutMapping("/{id}")
    @ResponseBody
    private ChildDTO update(@RequestBody Child child, @PathVariable Long id) {
        Child newChild = childService.update(child, id);
        return ChildModelMapper.INSTANCE.toDTO(newChild);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    private void deleteUserById(@PathVariable Long id) {
        childService.deleteChildById(id);
    }

    @GetMapping("/{id}/children")
    public String childrenBySectionId(@PathVariable Long id, Model model) {
        List<Child> children = childService.getAllBySectionId(id);
        List<ChildDTO> childDTOS = children.stream()
                .map(ChildModelMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        model.addAttribute("allChildrenByIdSection", childDTOS);
        return "children/childrenBySectionId_page";
    }


}

