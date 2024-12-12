package com.example.exercisejparelationi1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "course name should not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @ManyToOne
    @JoinColumn(name="teacher_id",referencedColumnName = "id")
    @JsonIgnore
    private Teacher teacher;
}
