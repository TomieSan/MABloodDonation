package com.mico.mablooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().hide();

        // sliding navbar textview choices
        TextView NavHome = findViewById(R.id.cktxtHome);                                                                                   //to home page
        NavHome.setOnClickListener(view -> startActivity(new Intent(AboutUs.this, MainActivity.class)));

        TextView NavReqForm = findViewById(R.id.cktxtReqForm);                                                                             //to blood req form
        NavReqForm.setOnClickListener(view -> startActivity(new Intent(AboutUs.this, BloodReqForm.class)));

        TextView NavDonoForm = findViewById(R.id.cktxtDonorForm);                                                                          //to blood donor form
        NavDonoForm.setOnClickListener(view -> startActivity(new Intent(AboutUs.this, blood_donor_form.class)));

        TextView NavBloodBank = findViewById(R.id.cktxtBloodBank);                                                                          //to blood bank page
        NavBloodBank.setOnClickListener(view -> startActivity(new Intent(AboutUs.this, BloodBank.class)));

        TextView NavContactUs = findViewById(R.id.cktxtContactUs);                                                                          //to contact us page
        NavContactUs.setOnClickListener(view -> startActivity(new Intent(AboutUs.this, ContactUs.class)));
    }
}