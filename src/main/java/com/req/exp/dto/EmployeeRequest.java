package com.req.exp.dto;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class EmployeeRequest {
	private int id;
	// Note : Notblank means notnull+notempty
	@NotBlank(message = "Name cannot be blank")
	private String name;
	@Min(18)
	@Max(70)
	private int age;
	@Min(15000)
	@Max(1000000)
	private String salary;
	@Email(message = "email is not valid")
	private String email;
	@NotNull
//	@Pattern(regexp = "^\\d{10}$", message = "Invalid Mobile number") It shud be STring to use this
	private int mobile;
	@NotNull(message = "Nationality cannot be null")
	private String nationality;
}
