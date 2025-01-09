package com.mico.mablooddonation;

public class Donor {

    private String Donor_Name;
    private String DOB;
    private String Gender;
    private String Email;
    private String Phone_Number;
    private String Blood_Type;

    public Donor() {

    }

    //parameterized constructor
    public Donor(String DName, String DDOB, String DGender, String DEmail, String DPhone, String DBloodType) {
        this.Donor_Name = DName;
        this.DOB = DDOB;
        this.Gender = DGender;
        this.Email = DEmail;
        this.Phone_Number = DPhone;
        this.Blood_Type = DBloodType;
    }

    public String getDonor_Name() {
        return Donor_Name;
    }

    public void setDonor_Name(String donor_Name) {
        Donor_Name = donor_Name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getBlood_Type() {
        return Blood_Type;
    }

    public void setBlood_Type(String blood_Type) {
        Blood_Type = blood_Type;
    }
}
