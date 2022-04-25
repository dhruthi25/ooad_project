package com.simpleform.service;

import java.util.List;

import com.simpleform.model.CompanyModel;
import com.simpleform.repository.CompanyRepository;
import com.simpleform.repository.CompanyRepository2;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyRepository2 companyRepository2;

    public CompanyService(CompanyRepository companyRepository, CompanyRepository2 companyRepository2){
        this.companyRepository = companyRepository;
        this.companyRepository2 = companyRepository2;
    }

    public CompanyModel registerJob(String companyName, String position, String CTC, String location, String eligibility, String jd, String loginName){
        if(companyName == null || position == null){
            return null;
        }else{
            if(companyRepository.findFirstByCompanyNameAndPosition(companyName, position).isPresent()){
                System.out.println("Duplicate job");
                return null;
            }
            CompanyModel companyModel = new CompanyModel();
            companyModel.setCompanyName(companyName);
            companyModel.setPosition(position);
            companyModel.setCTC(CTC);
            companyModel.setLocation(location);
            companyModel.setEligibility(eligibility);
            companyModel.setJd(jd);
            companyModel.setLoginName(loginName);
            return companyRepository.save(companyModel);
        }
    }

    public List<CompanyModel> searchJob(){
        return companyRepository.findAll();
    } 

    public List<CompanyModel> deleteJob(String loginName){
        return companyRepository.findAllByLoginName(loginName);
    }


   public void deletedJob(String companyName, String position){
        companyRepository2.deleteJobsByCompanyNameAndPosition(companyName, position);
    }

}
