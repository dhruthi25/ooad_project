package com.simpleform.repository;

import javax.transaction.Transactional;

//import java.util.List;
//import java.util.Optional;

import com.simpleform.model.CourseModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface CourseRepository2 extends CrudRepository<CourseModel, Integer>{
   @Modifying
    @Query("DELETE FROM CourseModel where name = :courseName")
    public void deleteCoursesByCourseName(@Param("courseName") String courseName);
}
