package hw6.customSpringBootStarter.controller.mvc;


import hw6.customSpringBootStarter.mapperInterface.UserModelMapper;
import hw6.customSpringBootStarter.model.User;
import hw6.customSpringBootStarter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import hw6.customSpringBootStarter.DTO.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/mvc/user")
@EnableWebMvc
public class UserControllerMvc {

    private final UserService userService;

    @Autowired
    public UserControllerMvc(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public String getAllUser(Model model) {
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOs = users.stream()
                .map(UserModelMapper.INSTANCE::toUserDTO)
                .collect(Collectors.toList());
        model.addAttribute("allUsers", userDTOs);
        return "user/users";
    }


    @GetMapping("/{id}")
    public String getChildById(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        UserDTO userDTO = UserModelMapper.INSTANCE.toUserDTO(user);
        model.addAttribute("userGetId", userDTO);
        return "user/user_page";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new UserDTO()); // Добавление пустого DTO в модель для заполнения в форме
        return "user/new_user"; // Возвращение view для отображения формы
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/new_user"; // Возврат к форме в случае ошибок валидации
        }
        userService.createUser(user);
        return "redirect:/mvc/user/users"; // Перенаправление после успешного создания пользователя
    }


    @GetMapping("/{id}/edit")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        if (user == null) {
            return "redirect:/error-page"; // Если пользователь не найден, перенаправляем на страницу ошибки
        }
        UserDTO userDTO = UserModelMapper.INSTANCE.toUserDTO(user);
        model.addAttribute("user", userDTO);
        return "user/edit_user"; // Имя вашего HTML файла для редактирования пользователя
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute("user") UserDTO userDTO,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "user/edit_user"; // Возвращает к форме редактирования если есть ошибки валидации
        }
        User user = userService.getUserById(id);
        if (user == null) {
            return "redirect:/error-page"; // Перенаправляем на страницу ошибки, если пользователь не найден
        }
        UserModelMapper.INSTANCE.updateUserFromDTO(userDTO, user);
        userService.updateUser(user, id); // Обновление данных пользователя в базе данных
        return "redirect:/mvc/user/users"; // Редирект на страницу просмотра данного пользователя
    }

}


//    @DeleteMapping("/{id}")
//    @ResponseBody
//    private void deleteUserById(@PathVariable Long id) {
//        userService.deleteUserById(id);
//    }

