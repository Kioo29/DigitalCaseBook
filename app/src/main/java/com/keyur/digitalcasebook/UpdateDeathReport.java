package com.keyur.digitalcasebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateDeathReport extends AppCompatActivity {

    EditText gender,age,decent,hair,eye,build,complexion,marks,cloths,height,weight,name,location,type,occupation,relative,causeOfDeath,timeOfDeath,timeOfReport,dateOfReport;
    Button UpdateButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatedeathpopup);

        gender = findViewById(R.id.uptDeathGender);
        age = findViewById(R.id.uptDeathAge);
        decent = findViewById(R.id.uptDeathDecent);
        hair = findViewById(R.id.uptDeathHair);
        eye = findViewById(R.id.uptDeathEye);
        build = findViewById(R.id.uptDeathBuild);
        complexion = findViewById(R.id.uptDeathComplexion);
        marks = findViewById(R.id.uptDeathMarks);
        cloths = findViewById(R.id.uptDeathCloths);
        height = findViewById(R.id.uptDeathHeight);
        weight = findViewById(R.id.uptDeathWeight);
        name = findViewById(R.id.uptDeathName);
        location = findViewById(R.id.uptDeathLocation);
        type = findViewById(R.id.uptDeathType);
        occupation = findViewById(R.id.uptDeathOccupation);
        relative = findViewById(R.id.uptDeathRelative);
        causeOfDeath = findViewById(R.id.uptDeathCauseOfDeath);
        timeOfDeath = findViewById(R.id.uptDeathTimeOfDeath);
        timeOfReport = findViewById(R.id.uptDeathTimeOfReport);
        dateOfReport = findViewById(R.id.uptDeathDateOfReport);

        UpdateButton = findViewById(R.id.btnUpdate);

        UpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Gender = gender.getText().toString().trim();
                String Age = age.getText().toString().trim();
                String Decent = decent.getText().toString().trim();
                String Hair = hair.getText().toString().trim();
                String Eye = eye.getText().toString().trim();
                String Build = build.getText().toString().trim();
                String Complexion = complexion.getText().toString().trim();
                String Marks = marks.getText().toString().trim();
                String Cloths = cloths.getText().toString().trim();
                String Height = height.getText().toString().trim();
                String Weight = weight.getText().toString().trim();
                String Name = name.getText().toString().trim();
                String Location = location.getText().toString().trim();
                String Type = type.getText().toString().trim();
                String Occupation = occupation.getText().toString().trim();
                String Relative = relative.getText().toString().trim();
                String CauseOfDeath = causeOfDeath.getText().toString().trim();
                String TimeOfDeath = timeOfDeath.getText().toString().trim();
                String TimeOfReport = timeOfReport.getText().toString().trim();
                String DateOfReport = dateOfReport.getText().toString().trim();

                Toast.makeText(UpdateDeathReport.this,"Death Report Updated Successfully",Toast.LENGTH_LONG).show();

//                UpdateDeathReportInfo UpdateInfo = new UpdateDeathReportInfo(Gender,Age,Decent,Hair,Eye,Build,Complexion,Marks,Cloths,Height,Weight,Name,Location,Type,Occupation,Relative,CauseOfDeath,TimeOfDeath,TimeOfReport,DateOfReport);

                deathReportInformation info = new deathReportInformation(Gender,Age,Decent,Hair,Eye,Build,Complexion,Marks,Cloths,Height,Weight,Name,Location,Type,Occupation,Relative,CauseOfDeath,TimeOfDeath,TimeOfReport,DateOfReport);

                reference = FirebaseDatabase.getInstance().getReference("DeathReport");

                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull  DataSnapshot snapshot) {
                        int i=0;

                        for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                            i++;
                            if(i==snapshot.getChildrenCount()){

                                String key = dataSnapshot.getKey().toString();
                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("DeathReport/"+key);
                                reference.setValue(info);
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull  DatabaseError error) {

                    }
                });

            }
        });

        reference = FirebaseDatabase.getInstance().getReference("DeathReport");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                int i=0;

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    i++;
                    if(i==snapshot.getChildrenCount()){
                        deathReportInformation info = dataSnapshot.getValue(deathReportInformation.class);

                        gender.setText(info.getGender());
                        age.setText(info.getAge());
                        decent.setText(info.getDecent());
                        hair.setText(info.getHair());
                        eye.setText(info.getEye());
                        build.setText(info.getBuild());
                        complexion.setText(info.getComplexion());
                        marks.setText(info.getMark());
                        cloths.setText(info.getClothes());
                        height.setText(info.getHeight());
                        weight.setText(info.getWeight());
                        name.setText(info.getName());
                        location.setText(info.getLocation());
                        type.setText(info.getType());
                        occupation.setText(info.getOccupation());
                        relative.setText(info.getNearRelative());
                        causeOfDeath.setText(info.getCauseOfDeath());
                        timeOfDeath.setText(info.getTimeOfDeath());
                        timeOfReport.setText(info.getTimeOfReport());
                        dateOfReport.setText(info.getDateOfReport());

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });

        

    }
}