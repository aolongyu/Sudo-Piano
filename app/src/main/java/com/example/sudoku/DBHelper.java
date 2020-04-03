package com.example.sudoku;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "myDBHelper";
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table sudoku (_id integer primary key autoincrement, hard varchar(50), time char(50), date TimeStamp NOT NULL DEFAULT CURRENT_TIMESTAMP)";
        db.execSQL(sql);
        Log.i(TAG, "onCreate DB");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

