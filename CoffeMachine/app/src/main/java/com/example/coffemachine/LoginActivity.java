package com.example.coffemachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText editTextPersonName;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextPersonName=findViewById(R.id.editTextPersonName);
        editTextPassword=findViewById(R.id.editTextPassword);
    }

    public void onClickBut(View view) {
        String name=editTextPersonName.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();
        if (!name.isEmpty() && !password.isEmpty()) {
            Intent intent = new Intent(this, CreateMachine.class);
            intent.putExtra("name", name);
            intent.putExtra("password", password);
            startActivity(intent);
        }else{
            Toast.makeText(this,R.string.ErrorButtonCoffee,Toast.LENGTH_LONG).show();
        }
    }
}