package com.test.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.textInputLayout);
        password = findViewById(R.id.textInputLayout2);

    }

    private boolean validateEmail(){
        String emailInput=email.getEditText().getText().toString().trim();
        if(emailInput.isEmpty()){

            email.setError("Field Cannot be Empty");
            return false;
        }
        else {
            email.setError(null);
            return true;
        }

    }
    private boolean validatePassword(){
        String passwordInput=password.getEditText().getText().toString().trim();
        if(passwordInput.isEmpty()){

            password.setError("Field Cannot be Empty");
            return false;
        }
        else if(passwordInput.length()<8) {
            password.setError("Please create a strong password");
            return false;
        }
        else {
            password.setError(null);
            return true;
        }

    }






    public void confirmInput(View V) {
    if(!validateEmail()|validatePassword()){
        return;
    }
    String input="Email" + email.getEditText().getText().toString();
    input += "\n";
    input+="Password"+password.getEditText().getText().toString();
    input += "\n";
        Toast.makeText(this,input,Toast.LENGTH_SHORT).show();
    }

}


