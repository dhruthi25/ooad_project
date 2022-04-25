package com.simpleform.repository;

import java.util.List;
import java.util.Optional;

import com.simpleform.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<CourseModel, Integer>{

    Optional<CourseModel> findFirstByName(String name);

    List<CourseModel> findAll();

    List<CourseModel> findAllByFaculty(String faculty);
/*
    @Modifying
    @Query("delete from course_table where name = :courseName")
    public void deleteCoursesByCourseName(@Param("courseName") String courseName);
*/
}
