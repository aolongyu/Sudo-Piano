package com.example.sudoku;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Sudoku_Play extends AppCompatActivity {

    Chronometer ch ;
    EditText editText[][] = new EditText[9][9];

    Button btnSubmitTest;
    Button btnShowAnser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_play);

        init();
        getSupportActionBar().hide();//隐藏标题栏

        btnSubmitTest = (Button) findViewById(R.id.btnSubmitTest);
        btnShowAnser = (Button) findViewById(R.id.btnShowAnser);

        ch = (Chronometer) findViewById(R.id.timing);
        ch.setBase(SystemClock.elapsedRealtime() );
        //启动计时器
        ch.start();

        final Sudoku_Create_Number sudoku = new Sudoku_Create_Number();
        sudoku.CreateSudoku();
        for(int i = 1; i<=9; ++i){
            for(int j = 1; j<=9; ++j){
                String temp = String.valueOf(sudoku.num[i][j]);
                if(!temp.equals("0")) {
                    editText[i - 1][j - 1].setBackgroundColor(Color.parseColor("#66FFB3")); //更改背景颜色
                    editText[i - 1][j - 1].setFocusableInTouchMode(false);  //不可编辑
                    editText[i - 1][j - 1].setText(temp);
                }
            }
        }

        btnSubmitTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判断是否填写完整
                boolean flag = true;
                for(int i = 1; i<=9&&flag; ++i){
                    for(int j = 1; j<=9&&flag; ++j) {
                        if (editText[i - 1][j - 1].getText().toString().equals("")) {
                            flag = false;
                        }
                    }
                }

                if(flag) {
                    int test[][] = new int[11][11];
                    for (int i = 1; i <= 9; ++i) {
                        for (int j = 1; j <= 9; ++j) {
                            test[i][j] = Integer.parseInt(editText[i-1][j-1].getText().toString());
                        }
                    }

                    if(sudoku.CheckTrue(test)){
                        String HardLevel = null;
                        if(Sudoku_Create_Number.Hard == 20)
                        {
                            HardLevel = "困难";
                        }
                        else if(Sudoku_Create_Number.Hard == 30)
                        {
                            HardLevel = "进阶";
                        }
                        else
                        {
                            HardLevel = "简单";
                        }
                        String time = ch.getText().toString();
                        Main_Index.db = Main_Index.dbHelper.getWritableDatabase();
                        String sql = "Insert into  sudoku(hard, time) values ('" + HardLevel + "', '" + time + "');";
                        Main_Index.db.execSQL(sql);
                        Toast.makeText(Sudoku_Play.this, "恭喜您，完全正确", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(Sudoku_Play.this, "很遗憾，没有完全正确", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Sudoku_Play.this, "您还没有填写完整", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShowAnser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 1; i<=9; ++i){  //将所有数字赋值到框中
                    for(int j = 1; j<=9; ++j){
                        String temp1 = String.valueOf(sudoku.num[i][j]);
                        String temp2 = String.valueOf(sudoku.ans[i][j]);
                        if(temp1.equals("0")) {
                            editText[i - 1][j - 1].setFocusableInTouchMode(false);  //不可编辑
                            editText[i - 1][j - 1].setText(temp2);
                        }
                    }
                }
                btnSubmitTest.setClickable(false);  //提交测试按键不可用
                ch.stop();  //停止计时
            }
        });

    }

    public void init(){
        editText[0][0] = (EditText) findViewById(R.id.edt00);
        editText[0][1] = (EditText) findViewById(R.id.edt01);
        editText[0][2] = (EditText) findViewById(R.id.edt02);
        editText[0][3] = (EditText) findViewById(R.id.edt03);
        editText[0][4] = (EditText) findViewById(R.id.edt04);
        editText[0][5] = (EditText) findViewById(R.id.edt05);
        editText[0][6] = (EditText) findViewById(R.id.edt06);
        editText[0][7] = (EditText) findViewById(R.id.edt07);
        editText[0][8] = (EditText) findViewById(R.id.edt08);

        editText[1][0] = (EditText) findViewById(R.id.edt10);
        editText[1][1] = (EditText) findViewById(R.id.edt11);
        editText[1][2] = (EditText) findViewById(R.id.edt12);
        editText[1][3] = (EditText) findViewById(R.id.edt13);
        editText[1][4] = (EditText) findViewById(R.id.edt14);
        editText[1][5] = (EditText) findViewById(R.id.edt15);
        editText[1][6] = (EditText) findViewById(R.id.edt16);
        editText[1][7] = (EditText) findViewById(R.id.edt17);
        editText[1][8] = (EditText) findViewById(R.id.edt18);

        editText[2][0] = (EditText) findViewById(R.id.edt20);
        editText[2][1] = (EditText) findViewById(R.id.edt21);
        editText[2][2] = (EditText) findViewById(R.id.edt22);
        editText[2][3] = (EditText) findViewById(R.id.edt23);
        editText[2][4] = (EditText) findViewById(R.id.edt24);
        editText[2][5] = (EditText) findViewById(R.id.edt25);
        editText[2][6] = (EditText) findViewById(R.id.edt26);
        editText[2][7] = (EditText) findViewById(R.id.edt27);
        editText[2][8] = (EditText) findViewById(R.id.edt28);

        editText[3][0] = (EditText) findViewById(R.id.edt30);
        editText[3][1] = (EditText) findViewById(R.id.edt31);
        editText[3][2] = (EditText) findViewById(R.id.edt32);
        editText[3][3] = (EditText) findViewById(R.id.edt33);
        editText[3][4] = (EditText) findViewById(R.id.edt34);
        editText[3][5] = (EditText) findViewById(R.id.edt35);
        editText[3][6] = (EditText) findViewById(R.id.edt36);
        editText[3][7] = (EditText) findViewById(R.id.edt37);
        editText[3][8] = (EditText) findViewById(R.id.edt38);

        editText[4][0] = (EditText) findViewById(R.id.edt40);
        editText[4][1] = (EditText) findViewById(R.id.edt41);
        editText[4][2] = (EditText) findViewById(R.id.edt42);
        editText[4][3] = (EditText) findViewById(R.id.edt43);
        editText[4][4] = (EditText) findViewById(R.id.edt44);
        editText[4][5] = (EditText) findViewById(R.id.edt45);
        editText[4][6] = (EditText) findViewById(R.id.edt46);
        editText[4][7] = (EditText) findViewById(R.id.edt47);
        editText[4][8] = (EditText) findViewById(R.id.edt48);

        editText[5][0] = (EditText) findViewById(R.id.edt50);
        editText[5][1] = (EditText) findViewById(R.id.edt51);
        editText[5][2] = (EditText) findViewById(R.id.edt52);
        editText[5][3] = (EditText) findViewById(R.id.edt53);
        editText[5][4] = (EditText) findViewById(R.id.edt54);
        editText[5][5] = (EditText) findViewById(R.id.edt55);
        editText[5][6] = (EditText) findViewById(R.id.edt56);
        editText[5][7] = (EditText) findViewById(R.id.edt57);
        editText[5][8] = (EditText) findViewById(R.id.edt58);

        editText[6][0] = (EditText) findViewById(R.id.edt60);
        editText[6][1] = (EditText) findViewById(R.id.edt61);
        editText[6][2] = (EditText) findViewById(R.id.edt62);
        editText[6][3] = (EditText) findViewById(R.id.edt63);
        editText[6][4] = (EditText) findViewById(R.id.edt64);
        editText[6][5] = (EditText) findViewById(R.id.edt65);
        editText[6][6] = (EditText) findViewById(R.id.edt66);
        editText[6][7] = (EditText) findViewById(R.id.edt67);
        editText[6][8] = (EditText) findViewById(R.id.edt68);

        editText[7][0] = (EditText) findViewById(R.id.edt70);
        editText[7][1] = (EditText) findViewById(R.id.edt71);
        editText[7][2] = (EditText) findViewById(R.id.edt72);
        editText[7][3] = (EditText) findViewById(R.id.edt73);
        editText[7][4] = (EditText) findViewById(R.id.edt74);
        editText[7][5] = (EditText) findViewById(R.id.edt75);
        editText[7][6] = (EditText) findViewById(R.id.edt76);
        editText[7][7] = (EditText) findViewById(R.id.edt77);
        editText[7][8] = (EditText) findViewById(R.id.edt78);

        editText[8][0] = (EditText) findViewById(R.id.edt80);
        editText[8][1] = (EditText) findViewById(R.id.edt81);
        editText[8][2] = (EditText) findViewById(R.id.edt82);
        editText[8][3] = (EditText) findViewById(R.id.edt83);
        editText[8][4] = (EditText) findViewById(R.id.edt84);
        editText[8][5] = (EditText) findViewById(R.id.edt85);
        editText[8][6] = (EditText) findViewById(R.id.edt86);
        editText[8][7] = (EditText) findViewById(R.id.edt87);
        editText[8][8] = (EditText) findViewById(R.id.edt88);
    }


}
