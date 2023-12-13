package ru.shilo.mapperInterface;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.shilo.DTO.ChildDTO;
import ru.shilo.model.Child;

@Mapper
public interface ChildModelMapper {
    ChildModelMapper INSTANCE = Mappers.getMapper(ChildModelMapper.class);
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "categoryInSports", target = "categoryInSports")
    @Mapping(source = "age", target = "age")
    ChildDTO toDTO(Child child);
}
