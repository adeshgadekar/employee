package com.project.springboot.employees.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmployeeRequest {

    @NotBlank(message = "First name is mandatory")
    @Size(min = 3 , max = 50 , message = "first name is between 3 and 50")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 3 , max = 50 , message = "last name is between 3 and 50")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "please provide a valid email")
    private String email;

    public EmployeeRequest(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

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
