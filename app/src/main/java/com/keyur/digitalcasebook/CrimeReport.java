package com.keyur.digitalcasebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CrimeReport extends AppCompatActivity {

    private Spinner spinnerstate;

    ImageView img_view;
    ConstraintLayout cons_layout;
    EditText rpt, phnum, flname, adds;
    Button btn_nxt, btn_back;
    TextView report, crimerpt, state ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_report);

        img_view = findViewById(R.id.Imagefinal);
        cons_layout = findViewById(R.id.constraintLayout);
        rpt = findViewById(R.id.Reportof);
        phnum = findViewById(R.id.PhoneNumber);
        flname = findViewById(R.id.fllname);
        adds = findViewById(R.id.address);
        btn_nxt = findViewById(R.id.nxt);
        report = findViewById(R.id.txtreport);
        crimerpt = findViewById(R.id.txtcrimerpt);
        btn_back = findViewById(R.id.back);


        state = findViewById(R.id.state);

        spinnerstate = findViewById(R.id.spinnerstate);
        String[] state = getResources().getStringArray(R.array.state);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, state);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerstate.setAdapter(adapter);


        btn_nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Getting Information From Investigator and store it into respective String Variable
                String reportOf = rpt.getText().toString().trim();
                String fullName = flname.getText().toString().trim();
                String Address = adds.getText().toString().trim();
                String state =spinnerstate.getSelectedItem().toString().trim();
                String phoneNum = phnum.getText().toString().trim();



                Intent intent = new Intent(CrimeReport.this, CrimeReport2.class);
//              Here We Pass the Information in CrimeReport2 Activity
                intent.putExtra("keyReportOf",reportOf);
                intent.putExtra("keyFullName",fullName);
                intent.putExtra("keyAddress",Address);
                intent.putExtra("keyState",state);
                intent.putExtra("keyPhoneNum",phoneNum);

                startActivity(intent);



            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrimeReport.this, NewCase.class);
                startActivity(intent);
            }
        });

    }
}