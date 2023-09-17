package com.spring.clinicaldata.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.clinicaldata.Expection.NoSuchRecordFoundException;
import com.spring.clinicaldata.Expection.PatientNotFoundException;
import com.spring.clinicaldata.entity.ClinicalData;
import com.spring.clinicaldata.entity.Patient;
import com.spring.clinicaldata.payload.PatientPayload;
import com.spring.clinicaldata.repo.PatientRepo;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {

	@Autowired
	PatientRepo patientRepo;
	
	Map<String,String> filter = new HashMap<>();

	@GetMapping("/patients")
	public PatientPayload getAllPatient(
			@RequestParam(value = "page",defaultValue = "0",required =  false) Integer page, 
			@RequestParam(value = "pageSize",defaultValue = "10",required =  false) Integer pageSize
			) throws NoSuchRecordFoundException {
		
		  Pageable p = PageRequest.of(page, pageSize);
		  Page<Patient> pagePatient = patientRepo.findAll(p);
		  List<Patient> listOfPatient = pagePatient.getContent();
		  
		    PatientPayload payload = new PatientPayload();
			payload.setPatients(listOfPatient);
			payload.setPageNumber(pagePatient.getNumber());
			payload.setPageSize(pagePatient.getSize());
			payload.setTotalElement(pagePatient.getTotalElements());
			payload.setTotalPages(pagePatient.getTotalPages());
			payload.setLastPage(pagePatient.isLast());
			
			if(listOfPatient.isEmpty()) {
				throw new NoSuchRecordFoundException("No Record Found");
			}else {
				return payload;
			}
			
	}

	@GetMapping("/patient/{id}")
	public Patient getPatient(@PathVariable int id) {
		return patientRepo.findById(id).orElseThrow(() -> new PatientNotFoundException(id));

	}

	@PostMapping("/addPatient")
	public Patient addPatient(@RequestBody Patient patient) {
		
		return patientRepo.save(patient);
	}

	@GetMapping("/patient/analyze/{id}")
	public Patient analyzePatient(@PathVariable int id) {
		Patient patient = patientRepo.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
		List<ClinicalData> clinicalDatas = patient.getClinicalDatas();
		ArrayList<ClinicalData> clinicalDataList = new ArrayList<>(clinicalDatas);
		for (ClinicalData eachEntry : clinicalDataList) {
			if(filter.containsKey(eachEntry.getComponentName())) {
				clinicalDatas.remove(eachEntry);
				continue;
			} else {
				filter.put(eachEntry.getComponentName(), null);
			}
			if (eachEntry.getComponentName().equals("hw")) {
				String[] heightAndWeight = eachEntry.getComponentValue().split("/");
				if (heightAndWeight != null && heightAndWeight.length > 1) {
					float heightInMeter = Float.parseFloat(heightAndWeight[0]) * (0.453F);
					float bmi = Float.parseFloat(heightAndWeight[1]) / (heightInMeter * heightInMeter);
					ClinicalData bmiClinicalData = new ClinicalData();
					bmiClinicalData.setComponentName("bmi");
					bmiClinicalData.setComponentValue(Float.toString(bmi));
					clinicalDatas.add(bmiClinicalData);
				}
			}
		}
		filter.clear();
		return patient;

	}

}
