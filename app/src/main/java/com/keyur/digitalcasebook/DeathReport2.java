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

public class DeathReport2 extends AppCompatActivity {

    private Spinner spinnerheight, spinnerweight;
    TextView dthrpt, height;
    EditText build, complexion, mark, clothes;
    Button btn_next, btn_back;
    ImageView img_view;
    ConstraintLayout cons_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_report2);

        img_view = findViewById(R.id.Imagefinal);
        cons_layout = findViewById(R.id.constraintLayout);
        dthrpt = findViewById(R.id.txtdeathreport);
        height = findViewById(R.id.Height);
        build = findViewById(R.id.build);
        complexion = findViewById(R.id.complexion);
        mark = findViewById(R.id.marks);
        clothes = findViewById(R.id.clothes);
        btn_next = findViewById(R.id.nxt);
        btn_back = findViewById(R.id.back);

        spinnerheight = findViewById(R.id.SpinnerHeight);

        String[] height = getResources().getStringArray(R.array.height);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, height);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerheight.setAdapter(adapter);


        spinnerweight = findViewById(R.id.SpinnerWeight);

        String[] weight = getResources().getStringArray(R.array.weight);
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, weight);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerweight.setAdapter(adapter2);

//      we get the Information from Death Report 1 in Death Report 2
        String gender = getIntent().getStringExtra("keyGender");
        String age = getIntent().getStringExtra("keyAge");
        String Decent = getIntent().getStringExtra("keyDecent");
        String Hair = getIntent().getStringExtra("keyHair");
        String Eye = getIntent().getStringExtra("keyEye");


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               Getting Information of Death Report 2
                String Build = build.getText().toString().trim();
                String Complexion = complexion.getText().toString().trim();
                String Mark = mark.getText().toString().trim();
                String Clothes = clothes.getText().toString().trim();
                String Height =spinnerheight.getSelectedItem().toString().trim();
                String Weight =spinnerweight.getSelectedItem().toString().trim();


                Intent intent = new Intent(DeathReport2.this, DeathReport3.class);

//              Here We Pass the Information from Death Report 2 Activity to Death Report 3 Activity

                intent.putExtra("keyGender",gender);
                intent.putExtra("keyAge",age);
                intent.putExtra("keyDecent",Decent);
                intent.putExtra("keyHair",Hair);
                intent.putExtra("keyEye",Eye);
                intent.putExtra("keyBuild",Build);
                intent.putExtra("keyComplexion",Complexion);
                intent.putExtra("keyMark",Mark);
                intent.putExtra("keyClothes",Clothes);
                intent.putExtra("keyHeight",Height);
                intent.putExtra("keyWeight",Weight);

                startActivity(intent);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeathReport2.this, DeathReport.class);
                startActivity(intent);
            }
        });


    }
}