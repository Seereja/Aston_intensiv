package ru.shilo.service;



import ru.shilo.DTO.ChildDTO;
import ru.shilo.model.Child;
import ru.shilo.repository.ChildDAOImp;
import ru.shilo.service.serviceAbstract.ChildService;

import java.util.List;


public class ChildServiceImpl implements ChildService {
    private final ChildDAOImp childDAOImp;
    private final ChildDTO childDTO;

    public ChildServiceImpl() {
        this.childDAOImp = new ChildDAOImp();

        this.childDTO = new ChildDTO();
    }

    public ChildServiceImpl(ChildDTO childDTO) {
        this.childDTO = childDTO;
        this.childDAOImp = new ChildDAOImp(this.childDTO);

    }


    @Override
    public List<ChildDTO> getAllChildren() {
        List<ChildDTO> children = childDAOImp.getAllChildren();
        children.forEach(System.out::println);
        return children;
    }

    @Override
    public void saveChildren(Child child) {
        childDAOImp.saveChildren(child);
    }

    @Override
    public ChildDTO getChildById(int id) {
        return childDAOImp.getChildById(id);
    }

    @Override
    public void deleteChildren(int id) {
        childDAOImp.deleteChildren(id);
    }

    @Override
    public List<Child> getAllChildrenAndSection() {
        List<Child> children = childDAOImp.getAllChildrenAndSection();
        children.stream().forEach(System.out::println);
        return children;
    }

    @Override
    public List<ChildDTO> getChildrenBySectionId(int id) {
        List<ChildDTO> children;
        children = childDAOImp.getChildrenBySectionId(id);
        children.forEach(System.out::println);
        return children;
    }

}

