package ru.shilo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SectionDTO {

    private Integer id;
    private String sectionName;

    @Override
    public String toString() {
        return "SectionDTO{" +
                "id=" + id +
                ", sectionName='" + sectionName + '\'' +
                '}';
    }
}
