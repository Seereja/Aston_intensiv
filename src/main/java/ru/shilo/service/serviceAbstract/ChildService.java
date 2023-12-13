package ru.shilo.service.serviceAbstract;



import ru.shilo.DTO.ChildDTO;
import ru.shilo.model.Child;

import java.sql.SQLException;
import java.util.List;

public interface ChildService {
    public List<ChildDTO> getAllChildren() throws SQLException;

    void saveChildren(Child child);

    ChildDTO getChildById(int id);

    void deleteChildren(int id);

    public List<Child> getAllChildrenAndSection();

    List<ChildDTO> getChildrenBySectionId(int id) throws ClassNotFoundException;
}
