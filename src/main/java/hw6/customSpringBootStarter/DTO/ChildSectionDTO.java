package hw6.customSpringBootStarter.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChildSectionDTO {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String categoryInSports;
    private String sectionName;

    @Override
    public String toString() {
        return "ChildSectionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", categoryInSports='" + categoryInSports + '\'' +
                ", sectionName='" + sectionName + '\'' +
                '}';
    }
}
