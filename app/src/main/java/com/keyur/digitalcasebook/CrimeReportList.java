package com.keyur.digitalcasebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CrimeReportList extends AppCompatActivity {


    RecyclerView recyclerView;
    DatabaseReference reference;
    CrimeAdapter crimeAdapter;
    ArrayList<crimeReportInformation> list;
    Button DeleteBtn;
    Button UpdateBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_report_list);

        DeleteBtn = findViewById(R.id.btnDelete);
        UpdateBtn = findViewById(R.id.btnUpdate);

        recyclerView = findViewById(R.id.crimeReportList);
        reference = FirebaseDatabase.getInstance().getReference("crimeReport");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        crimeAdapter = new CrimeAdapter(this,list);
        recyclerView.setAdapter(crimeAdapter);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                int i=0;

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    i++;
                    if(i==snapshot.getChildrenCount()){
                        crimeReportInformation report = dataSnapshot.getValue(crimeReportInformation.class);
                        list.add(report);
                    }

                }
                crimeAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });


//        Delete the Data From Firebase as well as In UI when Delete Button is Clicked
        DeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(CrimeReportList.this,"Crime Report Delete Successfully",Toast.LENGTH_LONG).show();

                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull  DataSnapshot snapshot) {
                        int i=0;

                        for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                            i++;
                            if(i==snapshot.getChildrenCount()){

                                list.remove(list.size()-1);
                                String key = dataSnapshot.getKey().toString();
                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("crimeReport/"+key);
                                reference.removeValue();
                                crimeAdapter.notifyDataSetChanged();
                            }

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull  DatabaseError error) {

                    }
                });
            }
        });

        UpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrimeReportList.this,UpdateCrimeReport.class);
                startActivity(intent);
            }
        });
    }



    
}