package com.edu.udea.mezclandocolores.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {

    private Context c;

    public DbHelper(Context context) {
        super(context, StatusContract.DB_NAME, null, StatusContract.DB_VERSION);
        this.c = context.getApplicationContext();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + StatusContract.TABLE_PRIMARY + " ("
                + StatusContract.Column_Primary_Color.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + StatusContract.Column_Primary_Color.NAME + " TEXT NOT NULL,"
                + StatusContract.Column_Primary_Color.CODE + " TEXT NOT NULL)");

        db.execSQL("CREATE TABLE " + StatusContract.TABLE_SECONDARY + " ("
                + StatusContract.Column_Primary_Color.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + StatusContract.Column_Secondary_Color.COLOR1 + " INTEGER NOT NULL,"
                + StatusContract.Column_Secondary_Color.COLOR2 + " INTEGER NOT NULL,"
                + StatusContract.Column_Secondary_Color.RESULT + " INTEGER NOT NULL)");

        insertData(db);


    }

    private void insertData(SQLiteDatabase db) {

        Color color = new Color("Azúl","0000ff"); //1
        db.insert(StatusContract.TABLE_PRIMARY, null, color.toContentValues());
        color = new Color("Amarillo","ffff00"); //2
        db.insert(StatusContract.TABLE_PRIMARY, null, color.toContentValues());
        color = new Color("Rojo","ff0000");//3
        db.insert(StatusContract.TABLE_PRIMARY, null, color.toContentValues());
        color = new Color("Violeta","8B00FF");//4
        db.insert(StatusContract.TABLE_PRIMARY, null, color.toContentValues());
        color = new Color("Naranja","FFA000");//5
        db.insert(StatusContract.TABLE_PRIMARY, null, color.toContentValues());
        color = new Color("Verde","00ff00");//6
        db.insert(StatusContract.TABLE_PRIMARY, null, color.toContentValues());
        color = new Color("Amarillo verdoso","ADFF2F");//7
        db.insert(StatusContract.TABLE_PRIMARY, null, color.toContentValues());
        color = new Color("Amarillo ocaso","FFAA00");//8
        db.insert(StatusContract.TABLE_PRIMARY, null, color.toContentValues());
        color = new Color("Bronce","CD7F32");//9
        db.insert(StatusContract.TABLE_PRIMARY, null, color.toContentValues());
        color = new Color("Escarlata","FF2400");//10
        db.insert(StatusContract.TABLE_PRIMARY, null, color.toContentValues());
        color = new Color("Azúl - Verde","00ffff");//11
        db.insert(StatusContract.TABLE_PRIMARY, null, color.toContentValues());
        color = new Color("Caramelo","883801");//12
        db.insert(StatusContract.TABLE_PRIMARY, null, color.toContentValues());

        db.insert(StatusContract.TABLE_SECONDARY, null, toContentV(1,2,6));
        db.insert(StatusContract.TABLE_SECONDARY, null, toContentV(1,3,4));
        db.insert(StatusContract.TABLE_SECONDARY, null, toContentV(1,6,11));
        db.insert(StatusContract.TABLE_SECONDARY, null, toContentV(1,4,12));
        db.insert(StatusContract.TABLE_SECONDARY, null, toContentV(2,1,6));
        db.insert(StatusContract.TABLE_SECONDARY, null, toContentV(2,3,5));
        db.insert(StatusContract.TABLE_SECONDARY, null, toContentV(2,6,7));
        db.insert(StatusContract.TABLE_SECONDARY, null, toContentV(2,5,8));
        db.insert(StatusContract.TABLE_SECONDARY, null, toContentV(3,1,4));
        db.insert(StatusContract.TABLE_SECONDARY, null, toContentV(3,2,5));
        db.insert(StatusContract.TABLE_SECONDARY, null, toContentV(3,4,9));
        db.insert(StatusContract.TABLE_SECONDARY, null, toContentV(3,5,10));




    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + StatusContract.TABLE_TERTIARY);
        db.execSQL("DROP TABLE IF EXISTS " + StatusContract.TABLE_SECONDARY);
        db.execSQL("DROP TABLE IF EXISTS " + StatusContract.TABLE_PRIMARY);
        onCreate(db);

    }
    public ContentValues toContentV(int a, int b, int c){
        ContentValues values = new ContentValues();
        values.put(StatusContract.Column_Secondary_Color.COLOR1, a);
        values.put(StatusContract.Column_Secondary_Color.COLOR2, b);
        values.put(StatusContract.Column_Secondary_Color.RESULT, c);
        return values;
    }


}
