package com.spring.clinicaldata.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.clinicaldata.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer>{

}
