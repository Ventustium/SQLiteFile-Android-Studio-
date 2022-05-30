package com.ventustium.sqlitefile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


class CustomAdapter extends BaseAdapter{
    Context c;
    ArrayList<Integer> id;
    ArrayList<String> nama;
    ArrayList<String> password;
    LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<Integer> id, ArrayList<String> nama, ArrayList<String> password) {
        this.c = c;
        this.id = id;
        this.nama = nama;
        this.password = password;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return id.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams", "SetTextI18n"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.my_lv1_element, null);
        TextView tvid = view.findViewById(R.id.tvID);
        TextView tvnama = view.findViewById(R.id.tvNama);
        TextView tvpassword = view.findViewById(R.id.tvPassword);

        tvid.setText("ID: " + id.get(i));
        tvnama.setText("Nama: " + nama.get(i));
        tvpassword.setText("Password: " + password.get(i));
        return view;
    }
}


