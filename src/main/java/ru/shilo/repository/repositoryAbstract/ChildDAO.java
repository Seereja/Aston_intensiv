package ru.shilo.repository.repositoryAbstract;


import hw4_smale_project_with_hibirnate.DTO.ChildDTO;
import hw4_smale_project_with_hibirnate.model.Child;
import hw4_smale_project_with_hibirnate.model.User;

import java.util.List;

public interface ChildDAO {
    public List<ChildDTO> getAllChildren();

    public List<Child> getAllChildrenAndSection();

    void saveChildren(User user);

    ChildDTO getChildById(int id);

    void deleteChildren(int id);

    List<ChildDTO> getChildrenBySectionId(int id) throws ClassNotFoundException;

}
