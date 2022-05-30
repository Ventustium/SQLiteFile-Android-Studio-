package com.ventustium.sqlitefile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DBHandler mydb;
    List<DataModel> listdata;

    Button button;
    SwipeRefreshLayout swipeRefreshLayout;
    ListView mylv;



    private final View.OnClickListener myClickListener = view -> {
        Intent i = new Intent(this, AddUser.class);
        startActivity(i);
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mylv = findViewById(R.id.myListView);
        button = findViewById(R.id.AddUser);
        button.setOnClickListener(myClickListener);

        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(this::RefreshListener);

        mylv = findViewById(R.id.myListView);
        mydb = new DBHandler(this);
        updateList();
    }

    private void RefreshListener() {
        updateList();
        swipeRefreshLayout.setRefreshing(false);
    }


    public void updateList(){
        ArrayList<Integer> id = new ArrayList<>();
        ArrayList<String> nama = new ArrayList<>();
        ArrayList<String> password = new ArrayList<>();
        listdata = mydb.getAll();
        int dataCount = mydb.getDataCount();
        for(int i = 0; i < dataCount; i++){
            id.add(listdata.get(i).getId());
            nama.add(listdata.get(i).getNama());
            password.add(listdata.get(i).getPassword());
            Log.d("SQLData", "id: "+id+"\nNama: "+nama+"\nPassword: "+password);
        }

        CustomAdapter cAdapter = new CustomAdapter(getApplicationContext(), id, nama, password);
        mylv.setAdapter(cAdapter);
    }
}