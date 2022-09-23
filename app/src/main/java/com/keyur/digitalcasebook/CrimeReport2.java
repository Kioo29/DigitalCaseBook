package com.keyur.digitalcasebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CrimeReport2 extends AppCompatActivity {

    private Spinner spinnerage;
    private RadioGroup radioGroup;
    private Button selectedRadioBtn;

    ImageView img_view;
    ConstraintLayout cons_layout;
    TextView crimerpt, sex, age;
    EditText email, lcofocc, reportingEmployee;
    Button btn_back, btn_next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_report2);

        radioGroup = findViewById(R.id.radioGroup);
        img_view = findViewById(R.id.Imagefinal);
        cons_layout = findViewById(R.id.constraintLayout);
        crimerpt = findViewById(R.id.txtcrimerpt);
        sex = findViewById(R.id.Sex);
        age = findViewById(R.id.Age);
        email = findViewById(R.id.Email);
        lcofocc = findViewById(R.id.LcOfOccurance);
        btn_back = findViewById(R.id.back);
        btn_next = findViewById(R.id.nxt);
        reportingEmployee = findViewById(R.id.rptemployee);


        spinnerage = findViewById(R.id.SpinnerAge);

        String[] Age = getResources().getStringArray(R.array.age);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Age);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerage.setAdapter(adapter);



//       we get the Information from CrimeReport 1 in CrimeReport 2
        String reportOf = getIntent().getStringExtra("keyReportOf");
        String fullName = getIntent().getStringExtra("keyFullName");
        String Address = getIntent().getStringExtra("keyAddress");
        String state = getIntent().getStringExtra("keyState");
        String phoneNum = getIntent().getStringExtra("keyPhoneNum");

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedRadioBtn = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
                String gender = selectedRadioBtn.getText().toString().trim();

                String Email = email.getText().toString().trim();
                String Investigator = reportingEmployee.getText().toString().trim();
                String locationOfOccurance = lcofocc.getText().toString().trim();
                String age =spinnerage.getSelectedItem().toString().trim();



                Intent intent = new Intent(CrimeReport2.this, CrimeReport3.class);
//              Here We Pass the Information from CrimeReport2 Activity to crimeReport 3 Activity
                intent.putExtra("keyReportOf",reportOf);
                intent.putExtra("keyFullName",fullName);
                intent.putExtra("keyAddress",Address);
                intent.putExtra("keyState",state);
                intent.putExtra("keyPhoneNum",phoneNum);
                intent.putExtra("keygender",gender);
                intent.putExtra("keyage",age);
                intent.putExtra("keyEmail",Email);
                intent.putExtra("keyInvestigator",Investigator);
                intent.putExtra("keylocationOfOccurance",locationOfOccurance);

                startActivity(intent);

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrimeReport2.this, CrimeReport.class);
                startActivity(intent);
            }
        });

    }
}