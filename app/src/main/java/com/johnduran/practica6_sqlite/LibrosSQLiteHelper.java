package com.johnduran.practica6_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by John Duran on 01/11/2017.
 */

public class LibrosSQLiteHelper extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE Libros (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "libro TEXT,"+
            "autor  TEXT,"+
            "persona TEXT,"+
            "telefono TEXT)";

    public LibrosSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Libros");
        sqLiteDatabase.execSQL(sqlCreate);
    }

}
