package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Sudoku_Show_History extends AppCompatActivity {

    ListView lvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_show_history);
        lvShow = (ListView) findViewById(R.id.lvShow);
        show();
    }

    private void show() {
        String sql = "Select * from sudoku order by time ASC;";
        Cursor cursor = null;
        SimpleCursorAdapter adapter = null;
        cursor = Main_Index.db.rawQuery(sql, null);
        adapter = new SimpleCursorAdapter(this, R.layout.row, cursor, new String[]{"hard", "time", "date"}, new int[]{R.id.tvHard, R.id.tvTime, R.id.tvDate}, 0);
        lvShow.setAdapter(adapter);
    }
}
