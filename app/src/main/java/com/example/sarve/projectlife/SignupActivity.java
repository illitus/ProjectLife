package com.example.sarve.projectlife;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    TextView login;
    Button signup;
    EditText name, email, cno, ec1, ec2, en1, en2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        login=findViewById(R.id.link_login);


        signup=findViewById(R.id.btn_signup);
        name=findViewById(R.id.input_name);
        email=findViewById(R.id.input_email);
        ec1=findViewById(R.id.input_cont1name);
        ec2=findViewById(R.id.input_cont2name);
        en1=findViewById(R.id.input_cont1num);
        en2=findViewById(R.id.input_cont2num);
        cno=findViewById(R.id.input_phoneno);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em=email.getText().toString();
                String nm=name.getText().toString();
                String dec1=ec1.getText().toString();
                String dec2=ec2.getText().toString();
                String den1=en1.getText().toString();
                String den2=en2.getText().toString();
                String dcno=cno.getText().toString();

                SQLiteDatabase db=openOrCreateDatabase("signup",MODE_PRIVATE,null);
                db.execSQL("create table if not exists details(email varchar primary key, name varchar, cno varchar, ec1 varchar, en1 varchar, ec2 varchar, en2 varchar)");
                db.execSQL("insert into details values('"+em+"','"+nm+"','"+dcno+"','"+dec1+"', '"+den1+"','"+dec2+"', '"+den2+"')");
                db.close();

                Toast.makeText(getApplicationContext(), "Account Successfully Created!", Toast.LENGTH_SHORT).show();

                finish();

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
