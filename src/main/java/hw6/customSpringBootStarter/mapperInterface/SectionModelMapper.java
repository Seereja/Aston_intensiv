package hw6.customSpringBootStarter.mapperInterface;



import hw6.customSpringBootStarter.DTO.SectionDTO;
import hw6.customSpringBootStarter.model.Section;
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
