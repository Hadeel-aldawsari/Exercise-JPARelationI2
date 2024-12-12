package com.example.exercisejparelationi1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(10) not null")
    @NotEmpty(message = "name should not be empty")
    private String name;

    @NotNull(message = "age should not be empty")
    @Min(value = 18,message = "age should be at least 18")
    @Positive(message = "enter valued age")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @Column(columnDefinition = "varchar(50) not null")
    @Email(message = "enter valid email")
    private String email;

    @NotNull(message = "salary should not eb empty")
    @Positive(message = "enter valid salary")
    @Column(columnDefinition = "DECIMAL(10, 2) not null")
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;


    @OneToMany(cascade = CascadeType.ALL,mappedBy ="teacher" )
    private Set<Course> Course;

}
