package ru.shilo.service;



import ru.shilo.model.Child;
import ru.shilo.repository.ChildDAO;

import java.sql.SQLException;
import java.util.List;

public class ChildDAOImpl {
    private final ChildDAO childDAO;

    public ChildDAOImpl(ChildDAO childDAO) {
        this.childDAO = childDAO;

    }

    public List<Child> getChildrenForSectionId(int id) {
        List<Child> children = null;
        try {
            children = childDAO.getChildrenForSectionId(id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        children.stream().map(Child::getName).forEach(System.out::println);
        return children;
    }
}

