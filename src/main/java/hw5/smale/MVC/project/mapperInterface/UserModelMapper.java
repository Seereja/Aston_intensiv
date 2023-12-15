package hw5.smale.MVC.project.mapperInterface;


import hw5.smale.MVC.project.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import hw5.smale.MVC.project.DTO.UserDTO;

@Mapper
public interface UserModelMapper {
    UserModelMapper INSTANCE = Mappers.getMapper(UserModelMapper.class);

    //    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "age", target = "age")
    UserDTO toUserDTO(User user);

    void updateUserFromDTO(UserDTO dto, @MappingTarget User entity);

}
