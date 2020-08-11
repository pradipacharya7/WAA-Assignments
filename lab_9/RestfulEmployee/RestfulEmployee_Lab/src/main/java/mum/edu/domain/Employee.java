package mum.edu.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.stream.XMLInputFactory;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Employee  {
	@NotBlank()
	@Size(min = 4,max = 50,message = "Firstname is not Valid")
 	private String firstName;
	@NotBlank
	@Size(min = 4,max = 50, message = "Lastname is not Valid")
 	private String lastName;
	@Email(message = "Please Enter a valid email")
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

}
