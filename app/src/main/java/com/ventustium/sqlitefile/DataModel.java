package com.ventustium.sqlitefile;

public class DataModel {
    int id;
    String nama;
    String password;

    public DataModel(int id, String nama, String password) {
        this.id = id;
        this.nama = nama;
        this.password = password;
    }

    public DataModel() {

    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
