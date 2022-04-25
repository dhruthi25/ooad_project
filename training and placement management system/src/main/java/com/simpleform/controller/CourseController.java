package com.simpleform.controller;

import java.util.List;

import com.simpleform.model.CourseModel;
import com.simpleform.model.StudentModel;
//import com.simpleform.model.UsersModel;



import com.simpleform.service.CourseService;
import com.simpleform.service.StudentService;
import com.simpleform.service.UsersService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {
    
    private final CourseService courseService;

    private final StudentService studentService;

    //private final UsersService usersService;

    

    public CourseController(CourseService courseService, StudentService studentService, UsersService usersService) {
        this.courseService = courseService;
        this.studentService = studentService;
        //this.usersService = usersService;
    }


    @GetMapping("/add_course")
    public String getAddCoursePage(Model model){
        model.addAttribute("courseRequest", new CourseModel());
        return "add_course_page";
    }

    @GetMapping("/show_course")
    public String getShowCoursePage(Model model){
        List<CourseModel> searchedCourse = courseService.searchCourse();
        model.addAttribute("course_list", searchedCourse);
        return "show_course_page";
    }

    @GetMapping("/student_page")
    public String getShowCoursePage(){
        return "student_page";
    }

    @GetMapping("/faculty_page")
    public String getShowFacultyPage(){
        return "faculty_page";
    }

    @GetMapping("/apply_course")
    public String getApplyCoursePage(Model model){
        model.addAttribute("courseApply", new CourseModel());
        model.addAttribute("studentApply", new StudentModel());
        List<CourseModel> searchedCourse = courseService.searchCourse();
        model.addAttribute("course_list", searchedCourse);
        return "apply_course";
    }

    @PostMapping("/apply_course")
    public String ApplyCourse(@ModelAttribute StudentModel studentModel ){
        System.out.println("course apply request: " + studentModel);
        StudentModel appliedCourse = studentService.applyCourse(studentModel.getFname(), studentModel.getLname(), studentModel.getPno(), studentModel.getEmail(), studentModel.getResume(), studentModel.getCname());
        return appliedCourse == null ? "error_page" : "redirect:/student_page";
    }

    @GetMapping("/delete_course/{userLogin}")
    public String getDeleteCoursePage(@PathVariable String userLogin,  Model model){
        model.addAttribute("courseApply", new CourseModel());
        //model.addAttribute("usersApply", new UsersModel());
        List<CourseModel> deletedCourse = courseService.deleteCourse(userLogin);
        model.addAttribute("delete_course_list", deletedCourse);
        return "delete_course";
    }

    @PostMapping("/delete_course")
    public String DeleteCourse(@ModelAttribute CourseModel courseModel, @RequestParam(value = "cname") String courseName){
        System.out.println(courseName);
        courseService.deletedCourse(courseName);
        return "redirect:/";
    }


    /*
    @GetMapping("/add_report")
    public String getAddReportPage(Model model){
        model.addAttribute("reportRequest", new ReportModel());
        return "add_report_page";
    }*/


    @PostMapping("/add_course")
    public String Course(@ModelAttribute CourseModel courseModel){
        System.out.println("course request: " + courseModel);
        CourseModel registeredCourse = courseService.registerCourse(courseModel.getName(), courseModel.getFaculty(), courseModel.getDetails(), courseModel.getOutcomes(), courseModel.getPrerequisites());
        return registeredCourse == null ? "error_page" : "redirect:/";
    }

    /*
    @PostMapping("/add_course")
    public String Course(@ModelAttribute CourseModel courseModel){
        System.out.println("course request: " + courseModel);
        CourseModel registeredCourse = courseService.registerCourse(courseModel.getName(), courseModel.getFaculty(), courseModel.getDetails(), courseModel.getOutcomes(), courseModel.getPrerequisites());
        return registeredCourse == null ? "error_page" : "redirect:/";
    }
    */

}
