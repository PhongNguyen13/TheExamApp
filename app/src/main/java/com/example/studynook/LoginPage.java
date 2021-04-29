package com.example.studynook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    private EditText username, password;
    private Button login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, SignUpPage.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = username.getText().toString();
                String userPw = password.getText().toString();

                if (userId.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(), "You must enter a name to login!", Toast.LENGTH_SHORT);
                    t.show();
                    username.setError("Enter a valid username");
                }
                if (userPw.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(), "You must enter a password to login!", Toast.LENGTH_SHORT);
                    t.show();
                    password.setError("Enter a valid password");
                }
                else if (!userId.isEmpty() && !userPw.isEmpty()) {
                    Intent in = new Intent(LoginPage.this, HomePage.class);
                    in.putExtra("userId",userId);
                    in.putExtra("userPw",userPw);
                    startActivity(in);
                }
            }
        });
    }
}

