package com.simpleform.repository;

import java.util.List;
import java.util.Optional;

import com.simpleform.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyModel, Integer>{

    List<CompanyModel> findAll();

    //Optional<StudentModel> findFirstByFnameAndCname(String fname, String cname);

    Optional<CompanyModel> findFirstByCompanyNameAndPosition(String companyName, String position);

    List<CompanyModel> findAllByLoginName(String loginName);

}
