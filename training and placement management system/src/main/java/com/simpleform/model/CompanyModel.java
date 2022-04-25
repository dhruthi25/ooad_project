package com.simpleform.model;

//import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company_table")
public class CompanyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String companyName;

    String position;

    String CTC;

    String location;

    String eligibility;

    String jd;

    String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCTC() {
        return this.CTC;
    }

    public void setCTC(String cTC) {
        this.CTC = cTC;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEligibility() {
        return this.eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getJd() {
        return this.jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((CTC == null) ? 0 : CTC.hashCode());
        result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
        result = prime * result + ((eligibility == null) ? 0 : eligibility.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((jd == null) ? 0 : jd.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CompanyModel other = (CompanyModel) obj;
        if (CTC == null) {
            if (other.CTC != null)
                return false;
        } else if (!CTC.equals(other.CTC))
            return false;
        if (companyName == null) {
            if (other.companyName != null)
                return false;
        } else if (!companyName.equals(other.companyName))
            return false;
        if (eligibility == null) {
            if (other.eligibility != null)
                return false;
        } else if (!eligibility.equals(other.eligibility))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (jd == null) {
            if (other.jd != null)
                return false;
        } else if (!jd.equals(other.jd))
            return false;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (position == null) {
            if (other.position != null)
                return false;
        } else if (!position.equals(other.position))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CompanyModel [CTC=" + CTC + ", companyName=" + companyName + ", eligibility=" + eligibility + ", id="
                + id + ", jd=" + jd + ", location=" + location + ", position=" + position + "]";
    }

}
