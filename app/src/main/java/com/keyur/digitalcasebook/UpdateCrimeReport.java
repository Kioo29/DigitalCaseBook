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

public class UpdateCrimeReport extends AppCompatActivity {

    EditText updateReport,updateFullName,updateAddress,updateState,updatePhoneNo,updateSex,updateAge,updateEmail,updateInvestigator,updateOccurance,updateDateOfOccu,updateTimeOccu,updateTimeOfReport,updateOfDateOfReport;
    Button UpdateBtn;
    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_popup);

        updateReport = findViewById(R.id.uptReport);
        updateFullName = findViewById(R.id.uptFullName);
        updateAddress = findViewById(R.id.uptAdd);
        updateState = findViewById(R.id.uptState);
        updatePhoneNo = findViewById(R.id.uptPhNo);
        updateSex = findViewById(R.id.uptSex);
        updateAge = findViewById(R.id.uptAge);
        updateEmail = findViewById(R.id.uptEmail);
        updateInvestigator = findViewById(R.id.uptInvestigator);
        updateOccurance = findViewById(R.id.uptOccurance);
        updateDateOfOccu = findViewById(R.id.uptdateOccu);
        updateTimeOccu = findViewById(R.id.uptTimeOccu);
        updateTimeOfReport = findViewById(R.id.uptTimeReport);
        updateOfDateOfReport = findViewById(R.id.uptdateReport);
        UpdateBtn = findViewById(R.id.btnUpdate);

        UpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ReportOf = updateReport.getText().toString().trim();
                String FullName = updateFullName.getText().toString().trim();
                String Address = updateAddress.getText().toString().trim();
                String State = updateState.getText().toString().trim();
                String Phone = updatePhoneNo.getText().toString().trim();
                String Sex = updateSex.getText().toString().trim();
                String Age = updateAge.getText().toString().trim();
                String Email = updateEmail.getText().toString().trim();
                String Investigator = updateInvestigator.getText().toString().trim();
                String Occurance = updateOccurance.getText().toString().trim();
                String DateOccu = updateDateOfOccu.getText().toString().trim();
                String TimeOccu = updateTimeOccu.getText().toString().trim();
                String TimeOfReport = updateTimeOfReport.getText().toString().trim();
                String DateOfReport = updateOfDateOfReport.getText().toString().trim();

                Toast.makeText(UpdateCrimeReport.this,"Crime Report Update Successfully",Toast.LENGTH_LONG).show();

//                UpdateCrimeReportInfo UpdateInfo = new UpdateCrimeReportInfo(ReportOf,FullName,Address,State,Phone,Sex,Age,Email,Investigator,Occurance,DateOccu,TimeOccu,TimeOfReport,DateOfReport,);
                crimeReportInformation info = new crimeReportInformation(ReportOf,FullName,Address,State,Phone,Sex,Age,Email,Investigator,Occurance,DateOccu,TimeOccu,TimeOfReport,DateOfReport);
                reference = FirebaseDatabase.getInstance().getReference("crimeReport");


                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull  DataSnapshot snapshot) {
                        int i=0;

                        for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                            i++;
                            if(i==snapshot.getChildrenCount()){

                                String key = dataSnapshot.getKey().toString();
                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("crimeReport/"+key);
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
        reference = FirebaseDatabase.getInstance().getReference("crimeReport");


        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                int i=0;

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    i++;
                    if(i==snapshot.getChildrenCount()){

                        crimeReportInformation Info = dataSnapshot.getValue(crimeReportInformation.class);
                        updateFullName.setText(Info.getFullName());
                        updateReport.setText(Info.getReportOf());
                        updateAddress.setText(Info.getAddress());
                        updateState.setText(Info.getState());
                        updatePhoneNo.setText(Info.getPhoneNum());
                        updateSex.setText(Info.getGender());
                        updateAge.setText(Info.getAge());
                        updateEmail.setText(Info.getEmail());
                        updateInvestigator.setText(Info.getInvestigator());
                        updateOccurance.setText(Info.getLocationOfOccurance());
                        updateDateOfOccu.setText(Info.getDateOfOccurance());
                        updateTimeOccu.setText(Info.getTimeOfOccurance());
                        updateTimeOfReport.setText(Info.getTimeOfReport());
                        updateOfDateOfReport.setText(Info.getDateOfReport());

                    }

                }


            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });

    }
}