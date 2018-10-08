package com.example.admin.userdetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button signIn;
    public TextView signUp;

    EditText emailId;
    EditText password;
    boolean b = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailId = findViewById(R.id.emailId);
        password = findViewById(R.id.password);

        signIn = findViewById(R.id.signIn);
        signUp = findViewById(R.id.signUp);

        emailId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(emailId.getText().toString().trim().length()==0) {
                    emailId.setError("please enter emailId");
                    emailId.requestFocus();
                }

            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(emailId.getText().toString().trim().length()==0) {
                    emailId.setError("Please enter emailId");
                    emailId.requestFocus();
                }
                else if(password.getText().toString().trim().length()==0) {
                    password.setError("Please enter  password");
                    password.requestFocus();
                }

                else {
                    Database p=new Database(MainActivity.this);
                    boolean value=p.authenticateUser(emailId.getText().toString().trim(),password.getText().toString().trim());
                    if(value) {
                        startActivity(new Intent(MainActivity.this, UserListActivity.class));
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Invalid User",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUp.class));
            }
        });

    }
}

