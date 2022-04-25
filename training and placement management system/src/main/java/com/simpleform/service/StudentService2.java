package com.simpleform.service;


import com.simpleform.model.StudentModel2;
import com.simpleform.repository.StudentRepository2;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService2 {

    private final StudentRepository2 studentRepository2;

    public StudentService2(StudentRepository2 studentRepository2){
        this.studentRepository2 = studentRepository2;
    }

    public StudentModel2 applyJob(String fname, String lname, String pno, String email, String resume, String companyName, String positionName){
        if(fname == null || companyName == null){
            return null;
        }else{
            StudentModel2 studentModel2 = new StudentModel2();
            studentModel2.setFname(fname);
            studentModel2.setLname(lname);
            studentModel2.setPno(pno);
            studentModel2.setEmail(email);
            studentModel2.setResume(resume);
            studentModel2.setCompanyName(companyName);
            studentModel2.setPositionName(positionName);
            return studentRepository2.save(studentModel2);
        }
    }
}
