package com.spring.clinicaldata.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.clinicaldata.Expection.PatientNotFoundException;
import com.spring.clinicaldata.dto.ClinicalDataRequest;
import com.spring.clinicaldata.entity.ClinicalData;
import com.spring.clinicaldata.entity.Patient;
import com.spring.clinicaldata.repo.ClinicalDataRepo;
import com.spring.clinicaldata.repo.PatientRepo;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicalDataController {
	
	@Autowired
	ClinicalDataRepo clinicalDataRepo;
	
	@Autowired
	PatientRepo patientRepo;

	@PostMapping("/addClinicalData")
	public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest clinicalDataRequest ) {
		Timestamp appTime =  new Timestamp(new Date().getTime());
		Patient patientId = patientRepo.findById(clinicalDataRequest.getPatientId()).orElseThrow(()-> new PatientNotFoundException(clinicalDataRequest.getPatientId()));
		ClinicalData clinicalData = new ClinicalData();
		clinicalData.setComponentName(clinicalDataRequest.getComponentName());
		clinicalData.setComponentValue(clinicalDataRequest.getComponentValue());
		clinicalData.setPatient(patientId);
		clinicalData.setMeasureDateTime(appTime);

		return clinicalDataRepo.save(clinicalData);
	}
}
