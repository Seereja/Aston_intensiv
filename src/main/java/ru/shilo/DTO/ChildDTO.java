package ru.shilo.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChildDTO {
    private Long id;
    private String name;
    private String surname;
    private String categoryInSports;
    private int age;

    @Override
    public String toString() {
        return "ChildDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", categoryInSports='" + categoryInSports + '\'' +
                ", age=" + age +
                '}';
    }
}
