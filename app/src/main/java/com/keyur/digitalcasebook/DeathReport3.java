package com.keyur.digitalcasebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DeathReport3 extends AppCompatActivity {

    ImageView img_view;
    ConstraintLayout cons_layout;
    EditText name, location, type, occ, nearestrelative, causeofdeath;
    Button btn_next, btn_back;
    TextView dthrpt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_report3);


        img_view = findViewById(R.id.Imagefinal);
        cons_layout = findViewById(R.id.constraintLayout);
        btn_next = findViewById(R.id.nxt);
        btn_back = findViewById(R.id.back);
        dthrpt = findViewById(R.id.txtdeathreport);
        name = findViewById(R.id.name);
        location = findViewById(R.id.location);
        type = findViewById(R.id.type);
        occ = findViewById(R.id.occupation);
        nearestrelative = findViewById(R.id.nrstrelative);
        causeofdeath = findViewById(R.id.cozofdeath);


//        we get the Information from Death Report 2 in Death Report 3
        String gender = getIntent().getStringExtra("keyGender");
        String age = getIntent().getStringExtra("keyAge");
        String Decent = getIntent().getStringExtra("keyDecent");
        String Hair = getIntent().getStringExtra("keyHair");
        String Eye = getIntent().getStringExtra("keyEye");
        String Build = getIntent().getStringExtra("keyBuild");
        String Complexion = getIntent().getStringExtra("keyComplexion");
        String Mark = getIntent().getStringExtra("keyMark");
        String Clothes = getIntent().getStringExtra("keyClothes");
        String Height = getIntent().getStringExtra("keyHeight");
        String Weight = getIntent().getStringExtra("keyWeight");


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Getting Information of Death Report 3
                String Name = name.getText().toString().trim();
                String Location = location.getText().toString().trim();
                String Type = type.getText().toString().trim();
                String Occupation = occ.getText().toString().trim();
                String NearRelative = nearestrelative.getText().toString().trim();
                String CauseOfDeath = causeofdeath.getText().toString().trim();

                Intent intent = new Intent(DeathReport3.this, DeathReport4.class);

//              Here We Pass the Information from Death Report 3 Activity to Death Report 4 Activity
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
                intent.putExtra("keyName",Name);
                intent.putExtra("keyLocation",Location);
                intent.putExtra("keyType",Type);
                intent.putExtra("keyOccupation",Occupation);
                intent.putExtra("keyNearRelative",NearRelative);
                intent.putExtra("keyCauseOfDeath",CauseOfDeath);

                startActivity(intent);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeathReport3.this, DeathReport2.class);
                startActivity(intent);
            }
        });

    }
}