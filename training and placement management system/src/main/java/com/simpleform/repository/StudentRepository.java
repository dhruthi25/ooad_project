package com.simpleform.repository;

import java.util.Optional;

import com.simpleform.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel, Integer>{
    Optional<StudentModel> findFirstByFnameAndCname(String fname, String cname);
}

