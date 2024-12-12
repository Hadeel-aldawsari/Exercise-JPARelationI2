package com.example.exercisejparelationi1.Controller;


import com.example.exercisejparelationi1.ApiResponse.ApiResponse;
import com.example.exercisejparelationi1.Model.Course;
import com.example.exercisejparelationi1.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;



    @GetMapping("/get-all")
    public ResponseEntity getAll() {
        return ResponseEntity.status(200).body(courseService.getAll());

    }

        @PostMapping("/add/teacherId/{teacherId}")
    public ResponseEntity add(@PathVariable Integer teacherId, @RequestBody @Valid Course course){
        courseService.add(teacherId, course);
        return ResponseEntity.status(200).body(new ApiResponse("course added successfully"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Course course){
        courseService.update(id,course);
        return ResponseEntity.status(200).body(new ApiResponse("course updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){

        courseService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("course deleted successfully"));
    }


    @GetMapping("/get-teacher-by-courseid/{courseId}")
    public  ResponseEntity getTeacherName(@PathVariable Integer courseId){
    return ResponseEntity.status(200).body(courseService.getTeacherName(courseId));
    }




}

