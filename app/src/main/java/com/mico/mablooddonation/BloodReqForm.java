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

public class BloodReqForm extends AppCompatActivity implements OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_req_form);
        getSupportActionBar().hide();

        // navbar textview choices
        TextView NavHome = findViewById(R.id.cktxtHome);                                                                                    //to home page
        NavHome.setOnClickListener(view -> startActivity(new Intent(BloodReqForm.this, MainActivity.class)));

        TextView NavAbtUs = findViewById(R.id.cktxtAbtUs);                                                                                  //to about us page
        NavAbtUs.setOnClickListener(view -> startActivity(new Intent(BloodReqForm.this, AboutUs.class)));

        TextView NavDonoForm = findViewById(R.id.cktxtDonorForm);                                                                           //to blood donor form
        NavDonoForm.setOnClickListener(view -> startActivity(new Intent(BloodReqForm.this, blood_donor_form.class)));

        TextView NavBloodBank = findViewById(R.id.cktxtBloodBank);                                                                          //to blood bank page
        NavBloodBank.setOnClickListener(view -> startActivity(new Intent(BloodReqForm.this, BloodBank.class)));

        TextView NavContactUs = findViewById(R.id.cktxtContactUs);                                                                          //to contact us page
        NavContactUs.setOnClickListener(view -> startActivity(new Intent(BloodReqForm.this, ContactUs.class)));

        EditText RecName = findViewById(R.id.editTxtFname);
        EditText RecDOB = findViewById(R.id.editTxtDOB);
        Spinner gender_choice = findViewById(R.id.spnr_Gender);
        EditText RecEmail = findViewById(R.id.editTxtEmailAdr);
        EditText RecPhone = findViewById(R.id.editTxtContactNo);
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
            DatabaseReference myRef = database.getReference("Recipients");

            String RName = RecName.getText().toString();
            String RDOB = RecDOB.getText().toString();
            String RGender = gender_choice.getSelectedItem().toString();
            String REmail = RecEmail.getText().toString();
            String RPhone = RecPhone.getText().toString();
            String RBloodType = blood_type.getSelectedItem().toString();

            Recipient Rec = new Recipient(RName, RDOB, RGender, REmail, RPhone, RBloodType);
            myRef.child(RName).setValue(Rec);

            Toast.makeText(getApplicationContext(), "Registered as Recipient!", Toast.LENGTH_LONG).show();
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}