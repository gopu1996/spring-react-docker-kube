package com.spring.clinicaldata.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.clinicaldata.entity.ClinicalData;

public interface ClinicalDataRepo  extends JpaRepository<ClinicalData ,Integer>{

}
