package com.example.exercisejparelationi1.Controller;

import com.example.exercisejparelationi1.ApiResponse.ApiResponse;
import com.example.exercisejparelationi1.Model.Teacher;
import com.example.exercisejparelationi1.Repository.TeacherRepository;
import com.example.exercisejparelationi1.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
private final TeacherService teacherService;

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body( teacherService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Teacher teacher){

        teacherService.add(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){

        teacherService.update(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        teacherService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher deleted successfully"));
    }


    @GetMapping("/get-teacher-details/{teacherId}")
    public ResponseEntity getTeacherDetails(@PathVariable Integer teacherId){
        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(teacherId));
    }

}
