package com.simpleform.repository;

import com.simpleform.model.StudentModel2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository2 extends JpaRepository<StudentModel2, Integer>{
    //Optional<StudentModel2> findFirstByFnameAndCname(String fname, String cname);
}

