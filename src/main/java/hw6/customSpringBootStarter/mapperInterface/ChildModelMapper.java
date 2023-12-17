package hw6.customSpringBootStarter.mapperInterface;



import hw6.customSpringBootStarter.DTO.ChildDTO;
import hw6.customSpringBootStarter.model.Child;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChildModelMapper {
    ChildModelMapper INSTANCE = Mappers.getMapper(ChildModelMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "categoryInSports", target = "categoryInSports")
    @Mapping(source = "age", target = "age")
    ChildDTO toDTO(Child child);


}
