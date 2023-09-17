package com.spring.clinicaldata.entity;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

	@jakarta.persistence.Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int Id;
	private String firstName;
	private String lastName;
	private int age;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "patient")
	private List<ClinicalData> clinicalDatas;


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public List<ClinicalData> getClinicalDatas() {
		return clinicalDatas;
	}

	public void setClinicalDatas(List<ClinicalData> clinicalDatas) {
		this.clinicalDatas = clinicalDatas;
	}

	@Override
	public String toString() {
		return "Patient [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", clinicalDatas=" + clinicalDatas + "]";
	}

	

}
