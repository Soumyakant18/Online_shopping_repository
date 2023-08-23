package com.example.soumyakant_menu_activity;

import android.content.Context;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class inputvalildationclass {

    private Context context;

    public inputvalildationclass(Context context) {
        this.context=context;
    }

public boolean isInputEditTextFilled(TextInputEditText textInputEdittext, TextInputLayout textInputLayout, String message){
String value=textInputEdittext.getText ().toString ().trim ();
if (value.isEmpty ()){
    textInputLayout.setError (message);
    return false;
}
else {
    textInputLayout.setErrorEnabled (false);
}
return true;
}

    public boolean isInputEditTextEmail(TextInputEditText textInputEdittext, TextInputLayout textInputLayout, String message) {
        String value = textInputEdittext.getText ().toString ().trim ();
        if (value.isEmpty ()|| !android.util.Patterns.EMAIL_ADDRESS.matcher (value).matches ()){
            textInputLayout.setError (message);
            return false;
        }else {
            textInputLayout.setErrorEnabled (false);
        }
        return true;
    }

    public boolean iisInputEdittextMatches(TextInputEditText textInputEditText1,TextInputEditText textInputEditText2,TextInputLayout textInputLayout,String message){

        String value1 = Objects.requireNonNull (textInputEditText1.getText ( )).toString ().trim ();
        String value2 = Objects.requireNonNull (textInputEditText2.getText ( )).toString ().trim ();
        if (!value1.contentEquals (value2)){
            textInputLayout.setError(message);
            return false;
        }
        else {
            textInputLayout.setErrorEnabled (false);
        }
        return true;
    }
}

