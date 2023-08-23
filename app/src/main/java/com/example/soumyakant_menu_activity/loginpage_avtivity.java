package com.example.soumyakant_menu_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class loginpage_avtivity extends AppCompatActivity {
    EditText editTextEmail;
    EditText editTextPassword;
    TextView textView;
    Button button;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage_avtivity);

        editTextEmail = findViewById(R.id.editTextone);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        textView = findViewById(R.id.textviewone);
        button = findViewById(R.id.buttonnext);

        databaseHelper = new DatabaseHelper(this);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginpage_avtivity.this, signuppage_activity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (isValidCredentials(username, password)) {

                    Intent intent = new Intent(loginpage_avtivity.this, menupageActivity.class);
                    startActivity(intent);
                } else {

                    Toast.makeText(loginpage_avtivity.this, "Enter valid username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean isValidCredentials(String username, String password) {

        return databaseHelper.checkUserByUsername (username);
    }


}
