package com.example.admin.userdetails;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    public EditText username, password, emailId, phoneno;

    public String un, pw, ed, pn;
    public Button signUp;
    public boolean value = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        emailId = findViewById(R.id.emailId);
        phoneno = findViewById(R.id.phoneno);

        signUp = findViewById(R.id.signUp);

        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int length = 0;
                length = username.getText().toString().trim().length();
                if (length == 0) {
                    username.setError("please enter username");
                    username.requestFocus();
                } else if (length < 8) {
                    username.setError("username must have 8 chars");
                    username.requestFocus();
                }


            }
        });
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p = 0;
                p = password.getText().toString().trim().length();
                if (p == 0) {
                    password.setError("please enter username");
                    password.requestFocus();
                } else if (p < 8) {
                    password.setError("password must have 8 chars");
                    password.requestFocus();
                }

            }
        });
        emailId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int e = 0;
                e = emailId.getText().toString().trim().length();
                if (e == 0) {
                    emailId.setError("please enter emailId");
                    emailId.requestFocus();
                }


            }
        });
        phoneno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = 0;
                num = phoneno.getText().toString().trim().length();
                if (num == 0) {
                    phoneno.setError("please enter phoneno");
                    phoneno.requestFocus();
                }else if (num < 8) {
                    phoneno.setError("phoneno must have 10 digits");
                    phoneno.requestFocus();
                }


            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int l = 0, p = 0, e = 0, ph = 0;
                l = username.getText().toString().trim().length();
                p = password.getText().toString().trim().length();
                e = emailId.getText().toString().trim().length();
                ph = phoneno.getText().toString().trim().length();

                if (l == 0 || l < 8) {
                    username.setError("Please enter user");
                    username.requestFocus();
                } else if (p == 0) {
                    password.setError("Please enter  password");
                    password.requestFocus();
                } else if (e == 0) {
                    emailId.setError("Please enter user");
                    emailId.requestFocus();
                } else if (ph == 0) {
                    phoneno.setError("Please enter  password");
                    phoneno.requestFocus();
                } else {
                    un = username.getText().toString().trim();
                    pw = password.getText().toString().trim();
                    ed = emailId.getText().toString().trim();
                    pn = phoneno.getText().toString().trim();
                    value = true;
                }
                if (value) {
                    Database db = new Database(getApplicationContext());
                    db.saveData(un, pw, ed, pn);

                    startActivity(new Intent(SignUp.this, MainActivity.class));

                }

            }
        });
    }
}



