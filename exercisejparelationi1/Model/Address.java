package com.example.exercisejparelationi1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private Integer id;

@Column(columnDefinition = "varchar(20) not null")
private String area;

@Column(columnDefinition = "varchar(50) not null")
private String street;

@Column(columnDefinition = "int not null")
private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
