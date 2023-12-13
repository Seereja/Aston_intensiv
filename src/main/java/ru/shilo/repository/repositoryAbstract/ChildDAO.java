package ru.shilo.repository.repositoryAbstract;




import ru.shilo.DTO.ChildDTO;
import ru.shilo.model.Child;
import ru.shilo.model.User;

import java.util.List;

public interface ChildDAO {
    public List<ChildDTO> getAllChildren();

    public List<Child> getAllChildrenAndSection();

    void saveChildren(User user);

    ChildDTO getChildById(int id);

    void deleteChildren(int id);

    List<ChildDTO> getChildrenBySectionId(int id) throws ClassNotFoundException;

}
