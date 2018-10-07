package com.example.sarve.projectlife;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {

    TextView register;
    EditText eml, pw;
    RelativeLayout log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        register=findViewById(R.id.textView2);
        eml=findViewById(R.id.editText);
        pw=findViewById(R.id.editText2);
        log=findViewById(R.id.rl);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SQLiteDatabase db = openOrCreateDatabase("signup", MODE_PRIVATE, null);
                    Cursor c = db.rawQuery("select cno from details where email='" + eml.getText().toString() + "'", null);
                    if (c.moveToFirst()) {
                        do {
                            if (c.getString(0).equals(pw.getText().toString())) {
                                Toast.makeText(SigninActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();




                                SharedPreferences sharedPreferences = getSharedPreferences("your_preferences", Activity.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("mail", eml.getText().toString());
                                editor.apply();



//                                Cursor d = db.rawQuery("select name from details where email='" + eml.getText().toString() + "'", null);
//                                String nm = "temp";
//                                if(d.moveToNext()) {
//                                    nm =d.getString(0);
//                                }
                                Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(SigninActivity.this, "Please check your password", Toast.LENGTH_SHORT).show();
                            }

                        } while (c.moveToNext());
                    } else {
                        Toast.makeText(SigninActivity.this, "Please check your email", Toast.LENGTH_SHORT).show();
                    }

                    db.close();
                }
                catch (Exception e){
                    Toast.makeText(SigninActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }


        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });



    }

}
