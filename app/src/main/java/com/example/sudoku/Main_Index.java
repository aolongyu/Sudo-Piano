package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main_Index extends AppCompatActivity {
    public static Main_Index ma = null;
    Button btnSudoku;
    Button btnPiano;
    private final String DB_name = "data.dbSudoku";
    private final int DB_VERSION = 1;
    public static SQLiteDatabase db;
    public static DBHelper dbHelper;
    ImageView homeImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_index);
        dbHelper = new DBHelper(this, DB_name, null, DB_VERSION);
        init();
        ma = this;

    }

    public void init() {
        btnSudoku = (Button) findViewById(R.id.btnSudoku);
        btnPiano = (Button) findViewById(R.id.btnPiano);
        db = dbHelper.getReadableDatabase();
        if(Sudoku_Difficult_Choice.player!=null)
        {
            Sudoku_Difficult_Choice.player.stop();
        }
        btnSudoku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Main_Index.this, Sudoku_Difficult_Choice.class);
                startActivity(intent);
            }
        });

        btnPiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Main_Index.this, Piano.class);
                startActivity(intent);
            }
        });
    }
}
