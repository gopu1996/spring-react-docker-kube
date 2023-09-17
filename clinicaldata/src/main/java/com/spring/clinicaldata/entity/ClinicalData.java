package com.spring.clinicaldata.entity;

import java.sql.Timestamp;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="clinicaldata")
@JsonIgnoreProperties({"patient"})
public class ClinicalData {
 
	@jakarta.persistence.Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String componentName;
	private String componentValue;
	@Column(name = "measured_date_time")
	private Timestamp measureDateTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="patient_id", nullable = false)
	private Patient patient;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getComponentValue() {
		return componentValue;
	}
	public void setComponentValue(String componentValue) {
		this.componentValue = componentValue;
	}
	public Timestamp getMeasureDateTime() {
		return measureDateTime;
	}
	public void setMeasureDateTime(Timestamp measureDateTime) {
		this.measureDateTime = measureDateTime;
	}

	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "ClinicalData [id=" + id + ", componentName=" + componentName + ", componentValue=" + componentValue
				+ ", measureDateTime=" + measureDateTime + "]";
	}

	
	
	
}
