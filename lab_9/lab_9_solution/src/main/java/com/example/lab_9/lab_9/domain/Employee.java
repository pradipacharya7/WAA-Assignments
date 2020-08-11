package com.example.lab_9.lab_9.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Employee  {
	
 
	@NotBlank
	@Size(min = 4,max = 50)
 	private String firstName;
	@NotBlank
	@Size(min = 4,max = 50)
 	private String lastName;
	@Email
 	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return " name "+firstName+" lastname "+lastName+" email "+email;
	}

}
