package com.mico.mablooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // sliding navbar textview choices
        TextView NavAbtUs = findViewById(R.id.cktxtAbtUs);                                                                                 //to about us page
        NavAbtUs.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AboutUs.class)));

        TextView NavReqForm = findViewById(R.id.cktxtReqForm);                                                                             //to blood req form
        NavReqForm.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, BloodReqForm.class)));

        TextView NavDonoForm = findViewById(R.id.cktxtDonorForm);                                                                          //to blood donor form
        NavDonoForm.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, blood_donor_form.class)));

        TextView NavBloodBank = findViewById(R.id.cktxtBloodBank);                                                                          //to blood bank page
        NavBloodBank.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, BloodBank.class)));

        TextView NavContactUs = findViewById(R.id.cktxtContactUs);                                                                          //to contact us page
        NavContactUs.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AboutUs.class)));

        // the 3 homepage buttons (same functionality as 3 of the 6 above but has extended text)
        Button btnReqForm = findViewById(R.id.btnReqForm);
        btnReqForm.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, BloodReqForm.class)));

        Button btnDonorForm = findViewById(R.id.btnDonorForm);
        btnDonorForm.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, blood_donor_form.class)));

        Button btnBloodBank = findViewById(R.id.btnBloodBank);
        btnBloodBank.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, BloodBank.class)));


    }
}