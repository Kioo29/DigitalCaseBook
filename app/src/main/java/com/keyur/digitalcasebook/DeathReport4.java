package com.keyur.digitalcasebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Locale;

public class DeathReport4 extends AppCompatActivity {

    ImageView img_view;
    ConstraintLayout cons_layout;
    TextView dthrpt;
    Button btn_finish, btn_back, timebutton, time_btn;
    int hour, minute, h, m;

    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_report4);


        img_view = findViewById(R.id.Imagefinal);
        cons_layout = findViewById(R.id.constraintLayout);
        dthrpt = findViewById(R.id.txtdeathreport);
        btn_finish = findViewById(R.id.finish);
        btn_back = findViewById(R.id.back);
        timebutton = findViewById(R.id.timebutton);
        time_btn = findViewById(R.id.time_btn);

        initDatePicker();
        dateButton = findViewById(R.id.datepickerbutton);
        dateButton.setText(getTodaysDate());


//      we get the Information from Death Report 3 in Death Report 4
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
        String Name = getIntent().getStringExtra("keyName");
        String Location = getIntent().getStringExtra("keyLocation");
        String Type = getIntent().getStringExtra("keyType");
        String Occupation = getIntent().getStringExtra("keyOccupation");
        String NearRelative = getIntent().getStringExtra("keyNearRelative");
        String CauseOfDeath = getIntent().getStringExtra("keyCauseOfDeath");

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String timeOfDeath = timebutton.getText().toString().trim();
                String dateOfReport = dateButton.getText().toString().trim();
                String timeOfReport = time_btn.getText().toString().trim();

                Toast.makeText(DeathReport4.this, "Death Report successfully submitted", Toast.LENGTH_SHORT).show();

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("DeathReport");

                deathReportInformation reportInfo = new deathReportInformation(gender,age,Decent,Hair,Eye,Build,Complexion,Mark,Clothes,Height,Weight,Name,Location,Type,Occupation,NearRelative,CauseOfDeath,timeOfDeath,dateOfReport,timeOfReport);
                reference.push().setValue(reportInfo);

                Intent intent = new Intent(DeathReport4.this,DeathReportList.class);
                startActivity(intent);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeathReport4.this, DeathReport3.class);
                startActivity(intent);
            }
        });

    }


    // Time picker
    public void popTimePicker(View view) {

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;

                String amPm;
                if (hour>=12){
                    amPm = "PM";
                }else{
                    amPm = "AM";
                }

                timebutton.setText(String.format(Locale.getDefault(), "%02d:%02d"+" "+ amPm,hour, minute));
            }
        };

        int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, hour, minute,true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    //Time Picker
    public void popTime(View view) {

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedH, int selectedM) {
                h = selectedH;
                m = selectedM;

                String amPm;
                if (h>=12){
                    amPm = "PM";
                }else{
                    amPm = "AM";
                }

                time_btn.setText(String.format(Locale.getDefault(), "%02d:%02d"+" "+ amPm, h, m));
            }
        };

        int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, h, m,true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();

    }

    // Use to Show Date
    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        return makeDateString(day, month, year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);

    }

    private String makeDateString(int day, int month, int year) {
        return  getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month) {
        if (month == 1)
            return "JAN";

        if (month == 2)
            return "FEB";

        if (month == 3)
            return "MAR";

        if (month == 4)
            return "APR";

        if (month == 5)
            return "MAY";

        if (month == 6)
            return "JUN";

        if (month == 7)
            return "JUL";

        if (month == 8)
            return "AUG";

        if (month == 9)
            return "SEP";

        if (month == 10)
            return "OCT";

        if (month == 11)
            return "NOV";

        if (month == 12)
            return "DEC";

        return "JAN";
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }

}