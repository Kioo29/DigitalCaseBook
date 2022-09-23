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

public class CrimeReport3 extends AppCompatActivity {

    private DatePickerDialog datePickerDialog, dateBtn;
    private Button dateButton, dateButtons;


    ImageView img_view;
    ConstraintLayout cons_layout;
    TextView dateofoccurance, crimerpt, reportdetail;
    int hour, minute, h, m;
    Button timebutton, time_btn, btn_finish, btn_back;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_report3);

        img_view = findViewById(R.id.Imagefinal);
        cons_layout = findViewById(R.id.constraintLayout);
        dateofoccurance = findViewById(R.id.dtofoccurance);
        crimerpt = findViewById(R.id.txtcrimerpt);
        timebutton = findViewById(R.id.timebutton);
        btn_finish = findViewById(R.id.finish);
        btn_back = findViewById(R.id.back);
        reportdetail = findViewById(R.id.report);
        time_btn = findViewById(R.id.time_btn);

//      Getting All Info From All CrimeReports
        String reportOf = getIntent().getStringExtra("keyReportOf");
        String fullName = getIntent().getStringExtra("keyFullName");
        String Address = getIntent().getStringExtra("keyAddress");
        String state = getIntent().getStringExtra("keyState");
        String phoneNum = getIntent().getStringExtra("keyPhoneNum");
        String gender = getIntent().getStringExtra("keygender");
        String age = getIntent().getStringExtra("keyage");
        String Email = getIntent().getStringExtra("keyEmail");
        String Investigator = getIntent().getStringExtra("keyInvestigator");
        String locationOfOccurance = getIntent().getStringExtra("keylocationOfOccurance");


        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dateOfOccurance = dateButton.getText().toString().trim();
                String timeOfOccurance = timebutton.getText().toString().trim();
                String dateOfReport = dateButtons.getText().toString().trim();
                String timeOfReport = time_btn.getText().toString().trim();


                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("crimeReport");

                crimeReportInformation reportInfo = new crimeReportInformation(reportOf,fullName,Address,state,phoneNum,gender,age,Email,Investigator,locationOfOccurance,dateOfOccurance,timeOfOccurance,dateOfReport,timeOfReport);

                reference.push().setValue(reportInfo);

                Toast.makeText(CrimeReport3.this,"Crime Report successfully submitted",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CrimeReport3.this,CrimeReportList.class);
                startActivity(intent);

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrimeReport3.this, CrimeReport2.class);
                startActivity(intent);
            }
        });


        initDatePicker();
        dateButton = findViewById(R.id.datepickerbutton);
        dateButton.setText(getTodaysDate());


        initDatePickers();
        dateButtons = findViewById(R.id.date_btn);
        dateButtons.setText(getTodaysDate());


    }

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





    private String getTodaysDate2() {
        Calendar cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH);
        m = m + 1;
        int d = cal.get(Calendar.DAY_OF_MONTH);

        return makeDateString(d, m, y);
    }

    private void initDatePickers() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker1, int y, int m, int d) {

                m = m + 1;
                String date = makeDateStrings(d, m, y);
                dateButtons.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH);
        int d = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        dateBtn = new DatePickerDialog(this, style, dateSetListener, y, m, d);

    }

    private String makeDateStrings(int d, int m, int y) {
        return  getMonthFormats(m) + " " + d + " " + y;
    }

    private String getMonthFormats(int m) {
        if (m == 1)
            return "JAN";

        if (m == 2)
            return "FEB";

        if (m == 3)
            return "MAR";

        if (m == 4)
            return "APR";

        if (m == 5)
            return "MAY";

        if (m == 6)
            return "JUN";

        if (m == 7)
            return "JUL";

        if (m == 8)
            return "AUG";

        if (m == 9)
            return "SEP";

        if (m == 10)
            return "OCT";

        if (m == 11)
            return "NOV";

        if (m == 12)
            return "DEC";

        return "JAN";
    }

    public void DatePicker(View view) {
        dateBtn.show();
    }


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
}