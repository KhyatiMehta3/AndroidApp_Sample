package com.example.internship_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private static String USER_NAME1 = "blah";
    private static String USER_PASSWORD1 = "more_blah";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void onSubmitClick(View v) {
        EditText user_name = (EditText) findViewById(R.id.userName);
        EditText user_pass = (EditText) findViewById(R.id.userPassword);
        if((user_name.getText().toString().equals(USER_NAME1)) &&(user_pass.getText().toString().equals(USER_PASSWORD1))){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Wrong UserName or Password!", Toast.LENGTH_SHORT).show();
        }
    }
}
