package com.keyur.digitalcasebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class NewCase extends AppCompatActivity {

    ImageView img_view;
    ConstraintLayout cons_layout;
    Button btn_crimereport, btn_deathreport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_case2);

        img_view = findViewById(R.id.Imagefinal);
        cons_layout = findViewById(R.id.constraintLayout);

        btn_crimereport = findViewById(R.id.crimereport);
        btn_deathreport = findViewById(R.id.deathreport);


        btn_crimereport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewCase.this, CrimeReport.class);
                startActivity(intent);
            }
        });

        btn_deathreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewCase.this, DeathReport.class);
                startActivity(intent);
            }
        });

    }
}