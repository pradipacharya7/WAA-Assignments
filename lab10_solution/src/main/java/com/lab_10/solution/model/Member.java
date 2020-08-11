package com.lab_10.solution.model;

import javax.validation.constraints.*;
import java.io.Serializable;

public class Member implements Serializable {
	@NotBlank
	@Size(min = 4,max = 50)
	private String firstName;
	@NotBlank
	@Size(min = 4,max = 50)
	private String lastName;
	@NotNull
	@Min(value = 20,message = "{Member.age}")
	@Max(60)
	private Integer age;
	@NotNull
	@Min( value = 1000,message = "{Member.Number.lessthan}")
	@Max(9999)
	private Integer memberNumber;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(Integer memberNumber) {
		this.memberNumber = memberNumber;
	}

}
