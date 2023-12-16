package hw6.custamSpringBootStarter.controller.rest;


import hw6.custamSpringBootStarter.mapperInterface.UserModelMapper;
import hw6.custamSpringBootStarter.model.User;
import hw6.custamSpringBootStarter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import hw6.custamSpringBootStarter.DTO.UserDTO;

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
