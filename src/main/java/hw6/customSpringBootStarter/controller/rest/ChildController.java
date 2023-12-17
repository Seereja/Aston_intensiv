package hw6.customSpringBootStarter.controller.rest;


import hw6.customSpringBootStarter.model.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import hw6.customSpringBootStarter.DTO.ChildDTO;
import hw6.customSpringBootStarter.mapperInterface.ChildModelMapper;
import hw6.customSpringBootStarter.service.ChildService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/child")
public class ChildController {
    private final ChildService childService;

    @Autowired
    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping("/children")
    public List<ChildDTO> showAllChildren() {
        List<Child> children = childService.getChildren();
        return children.stream().map(ChildModelMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ChildDTO getChildById(@PathVariable Long id) {
        Child child = childService.getChildById(id);
        return ChildModelMapper.INSTANCE.toDTO(child);
    }

    @PostMapping
    public ChildDTO createChildren(@RequestBody Child child) {
        Child newChild = childService.create(child);
        return ChildModelMapper.INSTANCE.toDTO(newChild);
    }

    @PutMapping("/{id}")
    private ChildDTO update(@RequestBody Child child, @PathVariable Long id) {
        child.setId(id);
        Child newChild = childService.update(child, id);
        return ChildModelMapper.INSTANCE.toDTO(newChild);
    }

    @DeleteMapping("/{id}")
    private void deleteUserById(@PathVariable Long id) {
        childService.deleteChildById(id);
    }

    @GetMapping("/{id}/children")
    private List<ChildDTO> childrenBySectionId(@PathVariable Long id) {
        List<Child> children = childService.getAllBySectionId(id);
        return children.stream().map(ChildModelMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }


}

