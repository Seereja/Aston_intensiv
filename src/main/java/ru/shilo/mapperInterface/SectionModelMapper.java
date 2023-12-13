package ru.shilo.mapperInterface;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.shilo.DTO.SectionDTO;
import ru.shilo.model.Section;

@Mapper
public interface SectionModelMapper {
    SectionModelMapper INSTANCE = Mappers.getMapper(SectionModelMapper.class);
    @Mapping(source = "id", target = "id")
    SectionDTO toDTO(Section section);
}
