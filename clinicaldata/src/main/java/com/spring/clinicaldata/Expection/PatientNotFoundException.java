package com.spring.clinicaldata.Expection;

public class PatientNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientNotFoundException(int id) {
		 super("Could not find employee " + id);
	}
	
	

}
