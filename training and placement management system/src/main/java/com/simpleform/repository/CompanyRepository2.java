package com.simpleform.repository;

import javax.transaction.Transactional;

//import java.util.List;
//import java.util.Optional;

import com.simpleform.model.CompanyModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface CompanyRepository2 extends CrudRepository<CompanyModel, Integer>{
   @Modifying
    @Query("DELETE FROM CompanyModel where company_name = :companyName and position = :position")
    public void deleteJobsByCompanyNameAndPosition(@Param("companyName") String companyName, @Param("position") String position);


    

}

