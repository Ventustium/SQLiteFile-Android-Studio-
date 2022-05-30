package com.ventustium.sqlitefile;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddUser extends AppCompatActivity {
    DataModel usermodel;
    DBHandler mydb;

    Button BSubmit;
    EditText ETName, ETPassword, ETReEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        BSubmit = findViewById(R.id.submit);
        ETName = findViewById(R.id.editTextTextPersonName);
        ETPassword = findViewById(R.id.editTextTextPassword);
        ETReEnter = findViewById(R.id.editTextTextPassword2);
        mydb = new DBHandler(this);
        BSubmit.setOnClickListener(view -> addUser());
    }

    public void addUser() {
        String nama = ETName.getText().toString();
        String password = ETPassword.getText().toString();
        String reEnter = ETReEnter.getText().toString();
        if (nama.isEmpty())
            Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_SHORT).show();
        else if (password.isEmpty())
            Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
        else if (!password.equals(reEnter))
            Toast.makeText(getApplicationContext(), "Password don't Match", Toast.LENGTH_SHORT).show();
        else {
            Log.d("AddData", nama + password);
            usermodel = new DataModel(0, nama, password);
            mydb.insertUser(usermodel);
            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}