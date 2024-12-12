package com.example.exercisejparelationi1.Controller;

import com.example.exercisejparelationi1.ApiResponse.ApiResponse;
import com.example.exercisejparelationi1.DTO.AddressDTO;
import com.example.exercisejparelationi1.Model.Address;
import com.example.exercisejparelationi1.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;


    @GetMapping("/get-all")
    public List<Address> getAll(){
        return addressService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity addProfile(@RequestBody @Valid AddressDTO addressDTO){
        addressService.add(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("address added successfully"));
    }


    @PutMapping("/update")
    public ResponseEntity updateProfile(@RequestBody @Valid AddressDTO addressDTO){
        addressService.update(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("address updated successfully"));
    }


}
