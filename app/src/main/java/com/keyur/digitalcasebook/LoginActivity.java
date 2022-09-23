package com.keyur.digitalcasebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    ImageView img_view;
    Button btn_newcase, btn_existingcase;
    ConstraintLayout cons_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cons_layout = findViewById(R.id.constraintLayout);
        img_view = findViewById(R.id.Imagefinal);
        btn_newcase = findViewById(R.id.newcase);
        btn_existingcase = findViewById(R.id.existingcase);

        btn_newcase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,NewCase.class);
                startActivity(intent);
            }
        });

        btn_existingcase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Upcoming Feature",Toast.LENGTH_LONG).show();
            }
        });
    }
}