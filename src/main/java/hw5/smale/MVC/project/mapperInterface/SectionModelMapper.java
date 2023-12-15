package hw5.smale.MVC.project.mapperInterface;



import hw5.smale.MVC.project.DTO.SectionDTO;
import hw5.smale.MVC.project.model.Section;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SectionModelMapper {
    SectionModelMapper INSTANCE = Mappers.getMapper(SectionModelMapper.class);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "sectionName",target = "sectionName")
    SectionDTO toDTO(Section section);
}
