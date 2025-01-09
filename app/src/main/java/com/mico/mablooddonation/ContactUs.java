package com.mico.mablooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        getSupportActionBar().hide();

        // navbar textview choices
        TextView NavHome = findViewById(R.id.cktxtHome);                                                                                    //to home page
        NavHome.setOnClickListener(view -> startActivity(new Intent(ContactUs.this, MainActivity.class)));

        TextView NavAbtUs = findViewById(R.id.cktxtAbtUs);                                                                                  //to about us page
        NavAbtUs.setOnClickListener(view -> startActivity(new Intent(ContactUs.this, AboutUs.class)));

        TextView NavReqForm = findViewById(R.id.cktxtReqForm);                                                                              //to blood req form
        NavReqForm.setOnClickListener(view -> startActivity(new Intent(ContactUs.this, BloodReqForm.class)));

        TextView NavDonoForm = findViewById(R.id.cktxtDonorForm);                                                                           //to blood donor form
        NavDonoForm.setOnClickListener(view -> startActivity(new Intent(ContactUs.this, blood_donor_form.class)));

        TextView NavBloodBank = findViewById(R.id.cktxtBloodBank);                                                                          //to blood bank page
        NavBloodBank.setOnClickListener(view -> startActivity(new Intent(ContactUs.this, BloodBank.class)));
    }
}