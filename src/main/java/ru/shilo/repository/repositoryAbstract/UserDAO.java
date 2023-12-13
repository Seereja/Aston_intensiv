package ru.shilo.repository.repositoryAbstract;



import ru.shilo.DTO.UserDTO;
import ru.shilo.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public List<UserDTO> getAllUser() throws SQLException;


    void saveUser(User user);

    User getUserById(int id);

    void deleteUserById(int id);
}
