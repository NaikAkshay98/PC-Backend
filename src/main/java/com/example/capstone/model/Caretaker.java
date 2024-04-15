package com.example.capstone.model;

public class Caretaker {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String photo;
    private String hourlyRate;
    private String yearOfExperience;
    private String caretakerRating;


    public Caretaker() {
    }

    public Caretaker(String firstName, String lastName, String email, String password, String phone, 
                     String photo, String hourlyRate, String yearOfExperience, String caretakerRating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.photo = photo;
        this.hourlyRate = hourlyRate;
        this.yearOfExperience = yearOfExperience;
        this.caretakerRating = caretakerRating;
    }

    // Getters and setters for all the fields
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(String yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public String getCaretakerRating() {
        return caretakerRating;
    }

    public void setCaretakerRating(String caretakerRating) {
        this.caretakerRating = caretakerRating;
    }
}
