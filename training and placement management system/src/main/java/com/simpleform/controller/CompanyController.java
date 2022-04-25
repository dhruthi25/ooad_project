package com.simpleform.controller;

import java.util.List;

import com.simpleform.model.CompanyModel;
import com.simpleform.service.CompanyService;


import com.simpleform.model.StudentModel2;
import com.simpleform.service.StudentService2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CompanyController {
    
    private final CompanyService companyService;

    private final StudentService2 studentService2;


    public CompanyController(CompanyService companyService, StudentService2 studentService2) {
        this.companyService = companyService;
        this.studentService2 = studentService2;
    }


    @GetMapping("/company_page")
    public String getShowCompanyPage(){
        return "company_page";
    }


    @GetMapping("/add-job/{userLogin}")
    public String getJobPage(Model model,  @PathVariable String userLogin){
        model.addAttribute("jobRequest", new CompanyModel());
        System.out.println(userLogin);
        return "add_job_page";
    }

    @PostMapping("/add-job/{userLogin}")
    public String Job(@ModelAttribute CompanyModel companyModel,  @PathVariable String userLogin){
        System.out.println("job request: " + companyModel);
        System.out.println(userLogin);
        CompanyModel registeredJob = companyService.registerJob(companyModel.getCompanyName(), companyModel.getPosition(), companyModel.getCTC(), companyModel.getLocation(), companyModel.getEligibility(), companyModel.getJd(), userLogin);
        return registeredJob == null ? "error_page" : "redirect:/";
    }

    @GetMapping("/delete-job/{userLogin}")
    public String getDeleteJobPage(@PathVariable String userLogin,  Model model){
        model.addAttribute("jobApply", new CompanyModel());
        //model.addAttribute("usersApply", new UsersModel());
        List<CompanyModel> deletedJobs = companyService.deleteJob(userLogin);
        System.out.println(userLogin);
        model.addAttribute("delete_job_list", deletedJobs);
        System.out.println(deletedJobs);
        return "delete_job";
    }


    
    @PostMapping("/delete_job")
    public String DeleteCourse(@ModelAttribute CompanyModel companyModel, @RequestParam(value = "companyName") String companyName, @RequestParam(value = "position") String position){
        System.out.println(companyName);
        System.out.println(position);
        companyService.deletedJob(companyName, position);
        return "redirect:/";
    }


    @GetMapping("/show_job")
    public String getShowJobPage(Model model){
        List<CompanyModel> searchedJob = companyService.searchJob();
        model.addAttribute("job_list", searchedJob);
        return "show_job_page";
    }

    @GetMapping("/apply_job")
    public String getApplyJobPage(Model model){
        model.addAttribute("jobApply", new CompanyModel());
        model.addAttribute("studentApply", new StudentModel2());
        List<CompanyModel> searchedJobs = companyService.searchJob();
        model.addAttribute("job_list", searchedJobs);
        return "apply_job";
    }

    @PostMapping("/apply_job")
    public String ApplyJob(@ModelAttribute StudentModel2 studentModel2 ){
        System.out.println("job apply request: " + studentModel2);
        StudentModel2 appliedJob = studentService2.applyJob(studentModel2.getFname(), studentModel2.getLname(), studentModel2.getPno(), studentModel2.getEmail(), studentModel2.getResume(), studentModel2.getCompanyName(), studentModel2.getPositionName());
        return appliedJob == null ? "error_page" : "redirect:/student_page";
    }


}
