package hw5.smale.MVC.project.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher extends User {
    @Column(name = "category")
    private String category;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @Override
    public String toString() {
        return "Teacher{" +
                "category=" + category +
                ", section=" + section +
                '}';
    }



}
