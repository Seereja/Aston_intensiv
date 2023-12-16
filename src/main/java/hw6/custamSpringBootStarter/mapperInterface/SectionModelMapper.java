package hw6.custamSpringBootStarter.mapperInterface;



import hw6.custamSpringBootStarter.DTO.SectionDTO;
import hw6.custamSpringBootStarter.model.Section;
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
