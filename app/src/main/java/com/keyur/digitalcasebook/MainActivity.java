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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView img_view;
    ConstraintLayout cons_layout;
    EditText etusername , etpass;
    Button btn_login;
    TextView txt_fgpassword , txt_welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_view = findViewById(R.id.Imagefinal);
        cons_layout = findViewById(R.id.constraintLayout);
        etusername = findViewById(R.id.user_id);
        etpass = findViewById(R.id.password);
        btn_login = findViewById(R.id.bt_login);
        txt_fgpassword = findViewById(R.id.txt_forgetpassword);
        txt_welcome = findViewById(R.id.txtMainWelcome);



        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userid = etusername.getText().toString().trim();
                String idpassword = etpass.getText().toString().trim();
                if (userid.equals("keyur") && idpassword.equals("1234")){
                    Toast.makeText(MainActivity.this, "Login Successful",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                else{
                    if (!userid.equals("keyur")){
                        Toast.makeText(MainActivity.this, "Incorrect Username",Toast.LENGTH_SHORT).show();
                        etusername.setText(null);
                        etusername.setHint("Incorrect Username");
                        etusername.setHintTextColor(getResources().getColor(R.color.error, getTheme()));
                        etusername.clearFocus();
                    }

                    else {
                        Toast.makeText(MainActivity.this, "Incorrect Password",Toast.LENGTH_SHORT).show();
                        etpass.setText(null);
                        etpass.setHint("Incorrect Password");
                        etpass.setHintTextColor(getResources().getColor(R.color.error, getTheme()));
                        etpass.clearFocus();
                    }
                }

            }
        });


    }

}