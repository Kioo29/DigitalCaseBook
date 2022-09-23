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
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class DeathReport extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Spinner spinnerage;
    private Button selectedRadioBtn;


    ImageView img_view;
    ConstraintLayout cons_layout;
    EditText decent, hair, eye;
    Button btn_next, btn_back;
    TextView dthrpt, description, age, sex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_report);

        radioGroup = findViewById(R.id.radioGroup);
        img_view = findViewById(R.id.Imagefinal);
        cons_layout = findViewById(R.id.constraintLayout);
        decent = findViewById(R.id.decent);
        hair = findViewById(R.id.hair);
        eye = findViewById(R.id.eye);
        btn_next = findViewById(R.id.nxt);
        btn_back = findViewById(R.id.back);
        dthrpt = findViewById(R.id.txtdeathreport);
        description = findViewById(R.id.textView);
        age = findViewById(R.id.Age);
        sex = findViewById(R.id.Sex);


        spinnerage = findViewById(R.id.SpinnerAge);

        String[] Age = getResources().getStringArray(R.array.age);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Age);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerage.setAdapter(adapter);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Getting Death report 1 Information from Investigator
                selectedRadioBtn = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
                String gender = selectedRadioBtn.getText().toString().trim();
                String age =spinnerage.getSelectedItem().toString().trim();
                String Decent = decent.getText().toString().trim();
                String Hair = hair.getText().toString().trim();
                String Eye = eye.getText().toString().trim();


                Intent intent = new Intent(DeathReport.this, DeathReport2.class);
//              Here We Pass the Information in Death Report 2 Activity
                intent.putExtra("keyGender",gender);
                intent.putExtra("keyAge",age);
                intent.putExtra("keyDecent",Decent);
                intent.putExtra("keyHair",Hair);
                intent.putExtra("keyEye",Eye);

                startActivity(intent);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeathReport.this, NewCase.class);
                startActivity(intent);
            }
        });
    }
}