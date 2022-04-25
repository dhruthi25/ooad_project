package com.simpleform.service;

import java.util.List;

import com.simpleform.model.CourseModel;
import com.simpleform.repository.CourseRepository;
import com.simpleform.repository.CourseRepository2;

//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseRepository2 courseRepository2;
    

    public CourseService(CourseRepository courseRepository, CourseRepository2 courseRepository2){
        this.courseRepository = courseRepository;
        this.courseRepository2 = courseRepository2;
    }

    public CourseModel registerCourse(String name, String faculty, String details, String outcomes, String prerequisites){
        if(name == null || faculty == null){
            return null;
        }else{
            if(courseRepository.findFirstByName(name).isPresent()){
                System.out.println("Duplicate course");
                return null;
            }
            CourseModel courseModel = new CourseModel();
            courseModel.setName(name);
            courseModel.setFaculty(faculty);
            courseModel.setDetails(details);
            courseModel.setOutcomes(outcomes);
            courseModel.setPrerequisites(prerequisites);
            return courseRepository.save(courseModel);
        }
    }

    public List<CourseModel> searchCourse(){
        return courseRepository.findAll();
    } 

    public List<CourseModel> deleteCourse(String faculty){
        return courseRepository.findAllByFaculty(faculty);
    }

    public void deletedCourse(String cname){
        courseRepository2.deleteCoursesByCourseName(cname);
    }
}
