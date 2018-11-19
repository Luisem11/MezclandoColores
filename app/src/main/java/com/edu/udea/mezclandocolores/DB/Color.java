package com.edu.udea.mezclandocolores.DB;

import android.content.ContentValues;

public class Color {
    int id;
    private String  name, code;

    public Color(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(StatusContract.Column_Primary_Color.NAME, name);
        values.put(StatusContract.Column_Primary_Color.CODE, code);
        return values;
    }

}
