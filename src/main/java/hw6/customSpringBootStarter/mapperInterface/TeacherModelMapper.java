package hw6.customSpringBootStarter.mapperInterface;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import hw6.customSpringBootStarter.DTO.TeacherDTO;
import hw6.customSpringBootStarter.model.Teacher;

@Mapper
public interface TeacherModelMapper {
    TeacherModelMapper INSTANCE = Mappers.getMapper(TeacherModelMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "category", target = "category")
    @Mapping(source = "age", target = "age")
    TeacherDTO toDTO(Teacher teacher);
}
