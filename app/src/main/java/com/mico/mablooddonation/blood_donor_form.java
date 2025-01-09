package com.mico.mablooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class blood_donor_form extends AppCompatActivity implements OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_donor_form);
        getSupportActionBar().hide();

        // navbar textview choices
        TextView NavHome = findViewById(R.id.cktxtHome);                                                                                    //to home page
        NavHome.setOnClickListener(view -> startActivity(new Intent(blood_donor_form.this, MainActivity.class)));

        TextView NavAbtUs = findViewById(R.id.cktxtAbtUs);                                                                                  //to about us page
        NavAbtUs.setOnClickListener(view -> startActivity(new Intent(blood_donor_form.this, AboutUs.class)));

        TextView NavReqForm = findViewById(R.id.cktxtReqForm);                                                                              //to blood req form
        NavReqForm.setOnClickListener(view -> startActivity(new Intent(blood_donor_form.this, BloodReqForm.class)));

        TextView NavBloodBank = findViewById(R.id.cktxtBloodBank);                                                                          //to blood bank page
        NavBloodBank.setOnClickListener(view -> startActivity(new Intent(blood_donor_form.this, BloodBank.class)));

        TextView NavContactUs = findViewById(R.id.cktxtContactUs);                                                                          //to contact us page
        NavContactUs.setOnClickListener(view -> startActivity(new Intent(blood_donor_form.this, ContactUs.class)));

        EditText DonName = findViewById(R.id.editTxtFname);
        EditText DonDOB = findViewById(R.id.editTxtDOB);
        Spinner gender_choice = findViewById(R.id.spnr_Gender);
        EditText DonEmail = findViewById(R.id.editTxtEmailAdr);
        EditText DonPhone = findViewById(R.id.editTxtContactNo);
        Spinner blood_type = findViewById(R.id.spnr_BloodType);
        Button submit = findViewById(R.id.btnSubmit);

        // drop down menu for gender and blood type
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.gender_arr, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender_choice.setAdapter(adapter1);
        gender_choice.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.blood_types_arr, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        blood_type.setAdapter(adapter2);
        blood_type.setOnItemSelectedListener(this);

        submit.setOnClickListener(view -> {
            String url = "https://plusma-db-default-rtdb.asia-southeast1.firebasedatabase.app/";
            FirebaseDatabase database = FirebaseDatabase.getInstance(url);
            DatabaseReference myRef = database.getReference("Donors");

            String DName = DonName.getText().toString();
            String DDOB = DonDOB.getText().toString();
            String DGender = gender_choice.getSelectedItem().toString();
            String DEmail = DonEmail.getText().toString();
            String DPhone = DonPhone.getText().toString();
            String DBloodType = blood_type.getSelectedItem().toString();

            Donor Dnr = new Donor(DName, DDOB, DGender, DEmail, DPhone, DBloodType);
            myRef.child(DName).setValue(Dnr);

            Toast.makeText(getApplicationContext(), "Registered as Donor!", Toast.LENGTH_LONG).show();
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}