package ru.shilo.service;

import hw4_smale_project_with_hibirnate.DTO.UserDTO;
import hw4_smale_project_with_hibirnate.model.User;
import hw4_smale_project_with_hibirnate.repository.UserDAOImpl;
import hw4_smale_project_with_hibirnate.service.serviceAbstract.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDAOImpl userDAOImpl;

    public UserServiceImpl() {
        this.userDAOImpl = new UserDAOImpl();
    }

    public UserServiceImpl(UserDTO userDTO) {
        userDAOImpl = new UserDAOImpl(userDTO);
    }

    public UserServiceImpl(UserDAOImpl userDAOImpl) {
        this.userDAOImpl = userDAOImpl;
    }

    @Override
    public List<UserDTO> getAllUser() throws SQLException {
        List<UserDTO> users = userDAOImpl.getAllUser();
        users.forEach(System.out::println);
        return users;
    }


    @Override
    public void saveUser(User user) {
        userDAOImpl.saveUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDAOImpl.getUserById(id);
    }

    @Override
    public void deleteUserById(int id) {
        userDAOImpl.deleteUserById(id);
    }
}
