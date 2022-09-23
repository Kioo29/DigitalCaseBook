package com.keyur.digitalcasebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DeathAdapter extends RecyclerView.Adapter<DeathAdapter.DeathViewHolder> {

    android.content.Context context;
    ArrayList<deathReportInformation> list;

    public DeathAdapter(Context context, ArrayList<deathReportInformation> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DeathViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.deathreportlist,parent,false);
        return new DeathViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  DeathAdapter.DeathViewHolder holder, int position) {

        deathReportInformation report = list.get(position);

        holder.Gender.setText(report.getGender());
        holder.Age.setText(report.getAge());
        holder.Decent.setText(report.getDecent());
        holder.Hair.setText(report.getHair());
        holder.Eye.setText(report.getEye());
        holder.Build.setText(report.getBuild());
        holder.Complexion.setText(report.getComplexion());
        holder.Marks.setText(report.getMark());
        holder.Cloths.setText(report.getClothes());
        holder.Height.setText(report.getHeight());
        holder.Weight.setText(report.getWeight());
        holder.Name.setText(report.getName());
        holder.Location.setText(report.getLocation());
        holder.Type.setText(report.getType());
        holder.Occupation.setText(report.getOccupation());
        holder.Relative.setText(report.getNearRelative());
        holder.CauseOfDeath.setText(report.getCauseOfDeath());
        holder.TimeOfDeath.setText(report.getTimeOfDeath());
        holder.TimeOfReport.setText(report.getTimeOfReport());
        holder.DateOfReport.setText(report.getDateOfReport());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class DeathViewHolder extends RecyclerView.ViewHolder{

        TextView Gender,Age,Decent,Hair,Eye,Build,Complexion,Marks,Cloths,Height,Weight,Name,Location,Type,Occupation,Relative,CauseOfDeath,TimeOfDeath,TimeOfReport,DateOfReport;

        public DeathViewHolder(@NonNull  View itemView) {
            super(itemView);

            Gender = itemView.findViewById(R.id.deathreportGender);
            Age= itemView.findViewById(R.id.deathreportAge);
            Decent = itemView.findViewById(R.id.deathreportDecent);
            Hair = itemView.findViewById(R.id.deathreportHair);
            Eye = itemView.findViewById(R.id.deathreportEye);
            Build = itemView.findViewById(R.id.deathreportBuild);
            Complexion = itemView.findViewById(R.id.deathreportComplexion);
            Marks = itemView.findViewById(R.id.deathreportMarks);
            Cloths = itemView.findViewById(R.id.deathreportCloths);
            Height = itemView.findViewById(R.id.deathreportHeight);
            Weight = itemView.findViewById(R.id.deathreportWeight);
            Name = itemView.findViewById(R.id.deathreportName);
            Location = itemView.findViewById(R.id.deathreportLocation);
            Type = itemView.findViewById(R.id.deathreportType);
            Occupation = itemView.findViewById(R.id.deathreportOccupation);
            Relative = itemView.findViewById(R.id.deathreportRelative);
            CauseOfDeath = itemView.findViewById(R.id.deathreportCozOfDeath);
            TimeOfDeath = itemView.findViewById(R.id.deathreportTimeOfDeath);
            TimeOfReport = itemView.findViewById(R.id.deathreportTimeOfReport);
            DateOfReport = itemView.findViewById(R.id.deathreportDateOfReport);

        }
    }
}
