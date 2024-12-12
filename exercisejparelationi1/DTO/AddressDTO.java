package com.example.exercisejparelationi1.DTO;

import com.example.exercisejparelationi1.Model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AddressDTO {
    private Integer teacher_id;

    @NotEmpty(message = "area should not be empty")
    @Size(min = 3,message = "enter valid area,at least 3 character")
    private String area;

    @NotEmpty(message = "street should not be empty")
    @Size(min = 3,message = "enter valid street , at least 3 character")
    private String street;

    @NotNull(message = "building number should no be empty")
    @Positive(message = "building number should be positive")
    private Integer buildingNumber;


}


