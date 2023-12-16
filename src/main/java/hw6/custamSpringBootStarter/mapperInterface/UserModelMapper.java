package hw6.custamSpringBootStarter.mapperInterface;


import hw6.custamSpringBootStarter.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import hw6.custamSpringBootStarter.DTO.UserDTO;

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
