package com.example.exercisejparelationi1.Repository;

import com.example.exercisejparelationi1.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course findCourseById(Integer id);
}
