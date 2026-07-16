package com.vintagevault.dto;


public class AdminUserResponse {


    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String role;



    public AdminUserResponse() {

    }



    public AdminUserResponse(
            Long id,
            String firstName,
            String lastName,
            String email,
            String phoneNumber,
            String role) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;

    }



    public Long getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getRole() {
        return role;
    }

}