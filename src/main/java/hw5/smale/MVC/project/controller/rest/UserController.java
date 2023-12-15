package hw5.smale.MVC.project.controller.rest;


import hw5.smale.MVC.project.mapperInterface.UserModelMapper;
import hw5.smale.MVC.project.model.User;
import hw5.smale.MVC.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import hw5.smale.MVC.project.DTO.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<UserDTO> getAllUser() {
        List<User> users = userService.getAllUsers();
        return users.stream()
                .map(UserModelMapper.INSTANCE::toUserDTO)
                .collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public UserDTO getChildById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return UserModelMapper.INSTANCE.toUserDTO(user);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return UserModelMapper.INSTANCE.toUserDTO(newUser);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@RequestBody User user, @PathVariable Long id) {
        user.setId(id);
        User newUser = userService.updateUser(user, id);
        return UserModelMapper.INSTANCE.toUserDTO(newUser);

    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
