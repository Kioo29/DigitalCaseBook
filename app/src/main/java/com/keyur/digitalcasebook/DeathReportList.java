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

public class DeathReportList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference reference;
    DeathAdapter deathAdapter;
    ArrayList<deathReportInformation> list;
    Button Update,Delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_report_list);

        Update = findViewById(R.id.DeathUpdateBtn);
        Delete = findViewById(R.id.DeathDeleteBtn);

        recyclerView = findViewById(R.id.deathReportList);
        reference = FirebaseDatabase.getInstance().getReference("DeathReport");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        deathAdapter = new DeathAdapter(this,list);
        recyclerView.setAdapter(deathAdapter);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int i=0;
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    i++;

                    if(i==snapshot.getChildrenCount()){
                        deathReportInformation report = dataSnapshot.getValue(deathReportInformation.class);
                        list.add(report);

                    }


                }
                deathAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//      Delete the Data From Firebase as well as In UI when Delete Button was Clicked
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(DeathReportList.this,"Death Report Delete Successfully",Toast.LENGTH_LONG).show();

                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull  DataSnapshot snapshot) {
                        int i=0;

                        for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                            i++;
                            if(i==snapshot.getChildrenCount()){

                                list.remove(list.size()-1);
                                String key = dataSnapshot.getKey().toString();
                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("DeathReport/"+key);
                                reference.removeValue();
                                deathAdapter.notifyDataSetChanged();

                            }

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull  DatabaseError error) {

                    }
                });
            }
        });



        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeathReportList.this,UpdateDeathReport.class);
                startActivity(intent);
            }
        });
    }
}