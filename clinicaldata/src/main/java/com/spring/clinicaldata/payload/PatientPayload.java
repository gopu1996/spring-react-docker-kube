package com.spring.clinicaldata.payload;

import java.util.List;

import com.spring.clinicaldata.entity.Patient;

public class PatientPayload {
	
	private List<Patient> patients;
	private int pageNumber;
	private int pageSize;
	private Long totalElement;
	private int totalPages;
	private boolean lastPage;
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotalElement() {
		return totalElement;
	}
	public void setTotalElement(Long totalElement) {
		this.totalElement = totalElement;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	

}
