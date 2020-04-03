package com.example.sudoku;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Sudoku_Difficult_Choice extends AppCompatActivity {

    Button btnSimple;
    Button btnMedium;
    Button btnAdvanced;
    Button btnHistory;
    Switch swcMusic;
    public static MediaPlayer player = null;
    public static AssetManager assetManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_difficult_choice);
        init();   //初始化
    }

    public void SoundMusic()
    {
        player = new MediaPlayer();
        assetManger = getAssets();
        try
        {
            AssetFileDescriptor fileDescriptor = assetManger.openFd("1.mp3");
            player.setDataSource(fileDescriptor.getFileDescriptor(), fileDescriptor.getStartOffset(), fileDescriptor.getLength());
            player.setLooping(true);
            player.prepare();
            player.start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void init(){
        btnSimple = (Button) findViewById(R.id.btnSimple);
        btnMedium = (Button) findViewById(R.id.btnMedium);
        btnAdvanced = (Button) findViewById(R.id.btnAdvanced);
        btnHistory = (Button) findViewById(R.id.btnHistory);

        swcMusic = (Switch) findViewById(R.id.swcMusic);
        SoundMusic();
        //简单
        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //###############
                Sudoku_Create_Number.Hard = 99;
                Intent intent = new Intent();
                intent.setClass(Sudoku_Difficult_Choice.this, Sudoku_Play.class);
                startActivity(intent);
            }
        });

        //进阶
        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //###############
                Sudoku_Create_Number.Hard = 30;
                Intent intent = new Intent();
                intent.setClass(Sudoku_Difficult_Choice.this, Sudoku_Play.class);
                startActivity(intent);
            }
        });

        //困难
        btnAdvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //###############
                Sudoku_Create_Number.Hard = 20;
                Intent intent = new Intent();
                intent.setClass(Sudoku_Difficult_Choice.this, Sudoku_Play.class);
                startActivity(intent);
            }
        });

        swcMusic.setChecked(true); //默认开启音乐

        swcMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SoundMusic();
                    Toast.makeText(Sudoku_Difficult_Choice.this, "开启", Toast.LENGTH_SHORT).show();
                } else {
                    player.stop();
                    Toast.makeText(Sudoku_Difficult_Choice.this, "关闭", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Sudoku_Difficult_Choice.this, Sudoku_Show_History.class);
                startActivity(intent);
            }
        });
    }

}
