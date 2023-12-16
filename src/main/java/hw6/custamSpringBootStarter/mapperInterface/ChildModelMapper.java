package hw6.custamSpringBootStarter.mapperInterface;



import hw6.custamSpringBootStarter.DTO.ChildDTO;
import hw6.custamSpringBootStarter.model.Child;
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
