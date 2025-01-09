package com.mico.mablooddonation;

public class Recipient {

    private String Recipient_Name;
    private String DOB;
    private String Gender;
    private String Email;
    private String Phone_Number;
    private String Blood_Type;

    public Recipient() {         //default constructor

    }

    //parameterized constructor
    public Recipient(String RName, String RDOB, String RGender, String REmail, String RPhone, String RBloodType) {
        this.Recipient_Name = RName;
        this.DOB = RDOB;
        this.Gender = RGender;
        this.Email = REmail;
        this.Phone_Number = RPhone;
        this.Blood_Type = RBloodType;
    }

    public String getRecipientName() {
        return Recipient_Name;
    }

    public void setRecipientName(String name) {
        Recipient_Name = name;
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
        this.Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String number) {
        this.Phone_Number = number;
    }

    public String getBlood_Type() {
        return Blood_Type;
    }

    public void setBlood_Type(String blood_Type) {
        Blood_Type = blood_Type;
    }
}


