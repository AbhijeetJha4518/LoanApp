package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @NotEmpty(message = "Name cannot be empty")
	    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	    private String name;
	    
	    @NotNull(message = "Password is required")
	    @Size(min = 8, message = "Password must be at least 8 characters long")
	    private String password;

	    @NotEmpty(message = "Email cannot be empty")
	    @Email(message = "Email should be valid")
	    private String email;

	    @NotEmpty(message = "Phone number cannot be empty")
	    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
	     private String phoneNumber;

//	    @NotEmpty(message = "Address cannot be empty")
	    private String address;
	    

}
