package hw6.custamSpringBootStarter.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "children")
public class Child extends User {
    @Column(name = "categoryinsports")
    private String categoryInSports;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.MERGE,})
    @JoinTable(name = "children_section",
            joinColumns = @JoinColumn(name = "child_id"),
            foreignKey = @ForeignKey(name = "FK_CHILDREN_SECTIONS"),
            inverseJoinColumns = @JoinColumn(name = "section_id"),
            inverseForeignKey = @ForeignKey(name = "FK_SECTIONS_CHILDREN"))
    private Set<Section> sections;

    @Override
    public String toString() {
        return "Child{" +
                "categoryInSports='" + categoryInSports + '\'' +
                ", sections=" + sections +
                '}';
    }
}
