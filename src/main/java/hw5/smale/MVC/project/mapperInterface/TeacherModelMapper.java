package hw5.smale.MVC.project.mapperInterface;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import hw5.smale.MVC.project.DTO.TeacherDTO;
import hw5.smale.MVC.project.model.Teacher;

@Mapper
public interface TeacherModelMapper {
    TeacherModelMapper INSTANCE = Mappers.getMapper(TeacherModelMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "category", target = "category")
    @Mapping(source = "age", target = "age")
    TeacherDTO toDTO(Teacher teacher);
}
