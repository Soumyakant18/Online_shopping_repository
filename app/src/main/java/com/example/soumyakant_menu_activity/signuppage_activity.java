package com.example.soumyakant_menu_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class signuppage_activity extends AppCompatActivity {

    TextInputLayout textInputLayoutUser,textInputLayoutEmailYour,textInputLayoutPass,textInputLayoutConfirm;
    EditText ed1,ed2,ed3,ed4 ;
    TextView textView ;
    Button button ;

    private DatabaseHelper databaseHelper;
    public inputvalildationclass inputValidation;
     com.example.soumyakant_menu_activity.User User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_signuppage);

        textInputLayoutUser=(TextInputLayout)findViewById (R.id.textInputLayoutUsername);
        textInputLayoutEmailYour=(TextInputLayout)findViewById (R.id.textInputLayoutEmail);
      textInputLayoutPass=(TextInputLayout)findViewById (R.id.textInputLayoutPassword);
      textInputLayoutConfirm=(TextInputLayout)findViewById (R.id.textInputLayoutConfirmPassword);


        ed1=(EditText)findViewById (R.id.editTextUsername);
        ed2=(EditText) findViewById (R.id.editTextEmail);
        ed3=(EditText) findViewById (R.id.editTextPassword);
        ed4 = (EditText) findViewById (R.id.editTextConfirmPassword);
        textView= (TextView) findViewById (R.id.textviewone);
        button= (Button) findViewById (R.id.buttonsignup);

        databaseHelper = new  DatabaseHelper (signuppage_activity.this);
        inputValidation = new inputvalildationclass(signuppage_activity.this);
      User = new User ("John Doe", "john@example.com");

        textView.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent (signuppage_activity.this, loginpage_avtivity.class);
                startActivity (intent);
            }
        });

        button.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                if (!inputValidation.isInputEditTextFilled ((TextInputEditText) ed1,textInputLayoutUser,"Enter full name")){
                    return;
                }
                if (!inputValidation.isInputEditTextFilled ((TextInputEditText) ed2,textInputLayoutEmailYour,"Enter valid Email")){
                    return;
                }
                if (!inputValidation.isInputEditTextEmail ((TextInputEditText) ed2,textInputLayoutEmailYour,"Enter valid email")){
                    return;
                }
                if (!inputValidation.isInputEditTextFilled ((TextInputEditText) ed3,textInputLayoutPass,"Enter password")){
                    return;
                }
                if (!inputValidation.iisInputEdittextMatches ((TextInputEditText) ed3, (TextInputEditText) ed4, textInputLayoutConfirm, "password does not matches")) {
                    return;
                }
                String email = ed2.getText().toString().trim();
                String password = ed3.getText().toString().trim();
                String confirmPassword = ed4.getText().toString().trim();

                if (!databaseHelper.checkUserByUsername (email) && password.equals(confirmPassword)) {
                    User.setName(ed1.getText().toString().trim());
                    User.setEmail(email);
                    User.setPassword(password);


                    databaseHelper.addUser(User);

                    Toast.makeText(signuppage_activity.this, "Account created successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(signuppage_activity.this, loginpage_avtivity.class);
                    startActivity(intent);
                } else {
                    if (databaseHelper.checkUserByUsername (email)) {
                        Toast.makeText(signuppage_activity.this, "E-mail already used", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(signuppage_activity.this, "Password mismatch", Toast.LENGTH_LONG).show();
                    }
                }


            }
        });
    }
}