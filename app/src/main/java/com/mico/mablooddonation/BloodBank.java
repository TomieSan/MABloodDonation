package com.mico.mablooddonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class BloodBank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank);
        getSupportActionBar().hide();

        // navbar textview choices
        TextView NavHome = findViewById(R.id.cktxtHome);                                                                                    //to home page
        NavHome.setOnClickListener(view -> startActivity(new Intent(BloodBank.this, MainActivity.class)));

        TextView NavAbtUs = findViewById(R.id.cktxtAbtUs);                                                                                  //to about us page
        NavAbtUs.setOnClickListener(view -> startActivity(new Intent(BloodBank.this, AboutUs.class)));

        TextView NavReqForm = findViewById(R.id.cktxtReqForm);                                                                              //to blood req form
        NavReqForm.setOnClickListener(view -> startActivity(new Intent(BloodBank.this, BloodReqForm.class)));

        TextView NavDonoForm = findViewById(R.id.cktxtDonorForm);                                                                           //to blood donor form
        NavDonoForm.setOnClickListener(view -> startActivity(new Intent(BloodBank.this, blood_donor_form.class)));

        TextView NavContactUs = findViewById(R.id.cktxtContactUs);                                                                          //to contact us page
        NavContactUs.setOnClickListener(view -> startActivity(new Intent(BloodBank.this, ContactUs.class)));

        TextView ABmin = findViewById(R.id.ABminCtr);
        TextView ABplus = findViewById(R.id.ABplusCtr);
        TextView Amin = findViewById(R.id.AminCtr);
        TextView Aplus = findViewById(R.id.AplusCtr);
        TextView Bmin = findViewById(R.id.BminCtr);
        TextView Bplus = findViewById(R.id.BplusCtr);
        TextView Omin = findViewById(R.id.OminCtr);
        TextView Oplus = findViewById(R.id.OplusCtr);

        String url = "https://plusma-db-default-rtdb.asia-southeast1.firebasedatabase.app/";
        DatabaseReference database = FirebaseDatabase.getInstance(url).getReference();

        Query ABm = database.child("Donors").orderByChild("blood_Type").equalTo("AB-");
        Query ABp = database.child("Donors").orderByChild("blood_Type").equalTo("AB+");
        Query Am = database.child("Donors").orderByChild("blood_Type").equalTo("A-");
        Query Ap = database.child("Donors").orderByChild("blood_Type").equalTo("A+");
        Query Bm = database.child("Donors").orderByChild("blood_Type").equalTo("B-");
        Query Bp = database.child("Donors").orderByChild("blood_Type").equalTo("B+");
        Query Om = database.child("Donors").orderByChild("blood_Type").equalTo("O-");
        Query Op = database.child("Donors").orderByChild("blood_Type").equalTo("O+");

        ABm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ABmin.setText(String.valueOf(snapshot.getChildrenCount()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

        ABp.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ABplus.setText(String.valueOf(snapshot.getChildrenCount()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

        Am.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Amin.setText(String.valueOf(snapshot.getChildrenCount()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

        Ap.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Aplus.setText(String.valueOf(snapshot.getChildrenCount()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

        Bm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Bmin.setText(String.valueOf(snapshot.getChildrenCount()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

        Bp.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Bplus.setText(String.valueOf(snapshot.getChildrenCount()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

        Om.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Omin.setText(String.valueOf(snapshot.getChildrenCount()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

        Op.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Oplus.setText(String.valueOf(snapshot.getChildrenCount()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });
    }
}