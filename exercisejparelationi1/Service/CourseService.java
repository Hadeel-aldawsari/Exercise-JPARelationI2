package com.example.exercisejparelationi1.Service;

import com.example.exercisejparelationi1.ApiResponse.ApiException;
import com.example.exercisejparelationi1.Model.Course;
import com.example.exercisejparelationi1.Model.Teacher;
import com.example.exercisejparelationi1.Repository.CourseRepository;
import com.example.exercisejparelationi1.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    public List<Course> getAll(){
        if(courseRepository.findAll().isEmpty())
            throw new ApiException("there is no course added yet");
        return courseRepository.findAll();
    }

    //add course and assign the teacher at the same time
        public void add(Integer teacherId, Course course){
        Teacher t=teacherRepository.findTeacherById(teacherId);if(t==null)throw new ApiException("there is no teacher with this id");

        course.setTeacher(t);
        courseRepository.save(course);
    }

    public void update(Integer courseId,Course course){
        Course c=courseRepository.findCourseById(courseId);
        if(c==null)throw new ApiException("there is no course with this id");

        c.setName(course.getName());
        courseRepository.save(c);
    }

    public void delete(Integer courseId){
        Course c=courseRepository.findCourseById(courseId);
        if(c==null)throw new ApiException("there course with this id ");
        courseRepository.delete(c);
    }

    public String getTeacherName(Integer courseId){
        Course c=courseRepository.findCourseById(courseId);
        if(c==null)throw new ApiException("there course with this id ");

        Teacher teacher=c.getTeacher();
        return teacher.getName();
    }





}
