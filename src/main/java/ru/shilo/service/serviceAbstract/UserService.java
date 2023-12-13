package ru.shilo.service.serviceAbstract;


import ru.shilo.DTO.UserDTO;
import ru.shilo.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public List<UserDTO> getAllUser() throws SQLException;

    void saveUser(User user);

    User getUserById(int id);

    void deleteUserById(int id);
}
