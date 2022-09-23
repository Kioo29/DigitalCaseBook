package com.keyur.digitalcasebook;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CrimeAdapter extends RecyclerView.Adapter<CrimeAdapter.CrimeViewHolder> {

    android.content.Context context;
    ArrayList<crimeReportInformation> list;

    public CrimeAdapter(Context context, ArrayList<crimeReportInformation> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CrimeViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.creportlist,parent,false);
        return new CrimeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  CrimeAdapter.CrimeViewHolder holder, int position) {
        crimeReportInformation report = list.get(position);
        holder.ReportOf.setText(report.getReportOf());
        holder.FullName.setText(report.getFullName());
        holder.Address.setText(report.getAddress());
        holder.State.setText(report.getState());
        holder.PhoneNo.setText(report.getPhoneNum());
        holder.Gender.setText(report.getGender());
        holder.Age.setText(report.getAge());
        holder.Email.setText(report.getEmail());
        holder.Investigator.setText(report.getInvestigator());
        holder.locOfOccurance.setText(report.getLocationOfOccurance());
        holder.dateOfOccurance.setText(report.getDateOfOccurance());
        holder.timeOfOccurance.setText(report.getTimeOfOccurance());
        holder.dateOfReport.setText(report.getDateOfReport());
        holder.timeOfReport.setText(report.getTimeOfReport());



        


    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CrimeViewHolder extends RecyclerView.ViewHolder{

        TextView ReportOf,FullName,Address,State,PhoneNo,Gender,Age,Email,Investigator,locOfOccurance,dateOfOccurance,timeOfOccurance,dateOfReport,timeOfReport;


        public CrimeViewHolder(@NonNull  View itemView) {


            super(itemView);
            ReportOf = itemView.findViewById(R.id.crimereportof);
            FullName= itemView.findViewById(R.id.crimereportFullName);
            Address = itemView.findViewById(R.id.crimereportAddress);
            State = itemView.findViewById(R.id.crimereportState);
            PhoneNo = itemView.findViewById(R.id.crimereportPhoneNumber);
            Gender = itemView.findViewById(R.id.crimereportGender);
            Age = itemView.findViewById(R.id.crimereportAge);
            Email = itemView.findViewById(R.id.crimereportEmail);
            Investigator = itemView.findViewById(R.id.crimereportInvestigator);
            locOfOccurance = itemView.findViewById(R.id.crimereportloOfOccurance);
            dateOfOccurance = itemView.findViewById(R.id.crimereportdateOfOccurance);
            timeOfOccurance = itemView.findViewById(R.id.crimereportTimeOfOccurance);
            dateOfReport = itemView.findViewById(R.id.crimereportDateOfReport);
            timeOfReport = itemView.findViewById(R.id.crimereportTimeOfReport);


        }
    }

}
