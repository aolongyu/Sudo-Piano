package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.io.IOException;

public class Piano extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    public  MediaPlayer player = null;
    AssetManager assetManger = null;
    private SoundPool sp;//声明一个SoundPool
    private int music;//定义一个整型用load（）；来设置suondID

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);
        init();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏

    }
    public void SoundMusic(String num)
    {

        assetManger = getAssets();
        try
        {
            player = new MediaPlayer();
            AssetFileDescriptor fileDescriptor;
            switch (num) {
                case "1": fileDescriptor = assetManger.openFd("1 C.mp3");
                    break;
                case "2": fileDescriptor = assetManger.openFd("2 D.mp3");
                    break;
                case "3": fileDescriptor = assetManger.openFd("3 E.mp3");
                    break;
                case "4": fileDescriptor = assetManger.openFd("4 F.mp3");
                    break;
                case "5": fileDescriptor = assetManger.openFd("5 G.mp3");
                    break;
                case "6": fileDescriptor = assetManger.openFd("6 A.mp3");
                    break;
                case "7": fileDescriptor = assetManger.openFd("7 B.mp3");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + num);
            }

            player.setDataSource(fileDescriptor.getFileDescriptor(), fileDescriptor.getStartOffset(), fileDescriptor.getLength());
            player.prepare();
            player.start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void init()
    {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        if(Sudoku_Difficult_Choice.player!=null)
        {
            Sudoku_Difficult_Choice.player.stop();
        }
        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SoundMusic("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SoundMusic("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SoundMusic("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SoundMusic("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SoundMusic("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SoundMusic("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SoundMusic("7");
            }
        });
    }
}
