package com.simpleform.service;


import com.simpleform.model.StudentModel;
import com.simpleform.repository.StudentRepository;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public StudentModel applyCourse(String fname, String lname, String pno, String email, String resume, String cname){
        if(fname == null || cname == null){
            return null;
        }else{
            if(studentRepository.findFirstByFnameAndCname(fname, cname).isPresent()){
                System.out.println("Already registered");
                return null;
            }
            StudentModel studentModel = new StudentModel();
            studentModel.setFname(fname);
            studentModel.setLname(lname);
            studentModel.setPno(pno);
            studentModel.setEmail(email);
            studentModel.setResume(resume);
            studentModel.setCname(cname);
            return studentRepository.save(studentModel);
        }
    }
}
