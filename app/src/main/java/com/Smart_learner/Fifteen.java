package com.Smart_learner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Fifteen extends Menu {


    Button[] button = new Button[16];
    //int[] game_num= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,0,15};
    private int[] game_num = {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18};         //Начальное положение игры,заполненное случайным числом не равным 0-15
    private int[] game_win = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};                   //Выграшное положение игры
    private String[] game_vivod = new String[16];
    TextView textView;
    Button next, menu;

    private void calculate() {
        Random rnd = new Random();
        //boolean end =false;
        boolean qw = true;
        int index = 0;
        do {
            int h = rnd.nextInt(16);
            for (int i = 0; i < 16; i++)
                if (game_num[i] == h)
                    qw = false;
            if (qw == true) {
                game_num[index] = h;
                index++;
            }
            qw = true;
        }
        while (index != 16);
    }

    private void vivod() {
        for (int i = 0; i < 16; i++) {                        //Преобазуем массив в STRING для удобного вывода
            if (game_num[i] != 0)
                game_vivod[i] = Integer.toString(game_num[i]);
            else                                        // в частности для того, чтобы вместо 0 выводилось пусто
                game_vivod[i] = "";
        }

        for (int i = 0; i < 16; i++)
            button[i].setText(game_vivod[i]);                 //Вывод игры на экран

        //Проверка на победу
        boolean pobeda = true;
        for (int i = 0; i < 15; i++) {
            if (game_num[i] != game_win[i])
                pobeda = false;
        }
        if (pobeda == true) {
            setContentView(R.layout.activity_result);
            textView = (TextView) findViewById(R.id.text_result);

            next = (Button) findViewById(R.id.next);
            menu = (Button) findViewById(R.id.menu);

            next.setBackgroundResource(R.drawable.button_styles);
            menu.setBackgroundResource(R.drawable.button_styles);

            next.setOnClickListener(this);
            menu.setOnClickListener(this);

            textView.setText("Поздравляем, вы выиграли :)");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restart();
    }

    private void restart() {
        setContentView(R.layout.activity_fifteen);

        button[0] = (Button) findViewById(R.id.button1);
        button[1] = (Button) findViewById(R.id.button2);
        button[2] = (Button) findViewById(R.id.button3);
        button[3] = (Button) findViewById(R.id.button4);
        button[4] = (Button) findViewById(R.id.button5);
        button[5] = (Button) findViewById(R.id.button6);
        button[6] = (Button) findViewById(R.id.button7);
        button[7] = (Button) findViewById(R.id.button8);
        button[8] = (Button) findViewById(R.id.button9);
        button[9] = (Button) findViewById(R.id.button10);
        button[10] = (Button) findViewById(R.id.button11);
        button[11] = (Button) findViewById(R.id.button12);
        button[12] = (Button) findViewById(R.id.button13);
        button[13] = (Button) findViewById(R.id.button14);
        button[14] = (Button) findViewById(R.id.button15);
        button[15] = (Button) findViewById(R.id.zero);

        calculate();
        vivod();

        for (int i = 0; i < 16; i++)
            button[i].setOnClickListener(this);

    }

    private void zamena(int k, int j) {
        int a = game_num[k];
        game_num[k] = game_num[j];
        game_num[j] = a;
    }

    @Override
    public void onClick(View view) {                    //Проверка всех соседних клеточек на наличие нуля
        switch (view.getId()) {
            case R.id.button1:
                if (game_num[1] == 0) {
                    zamena(0, 1);
                    vivod();
                }
                if (game_num[4] == 0) {
                    zamena(0, 4);
                    vivod();
                }
                break;
            case R.id.button2:
                if (game_num[0] == 0) {
                    zamena(1, 0);
                    vivod();
                }
                if (game_num[2] == 0) {
                    zamena(1, 2);
                    vivod();
                }
                if (game_num[5] == 0) {
                    zamena(1, 5);
                    vivod();
                }
                break;
            case R.id.button3:
                if (game_num[1] == 0) {
                    zamena(2, 1);
                    vivod();
                }
                if (game_num[3] == 0) {
                    zamena(2, 3);
                    vivod();
                }
                if (game_num[6] == 0) {
                    zamena(2, 6);
                    vivod();
                }
                break;
            case R.id.button4:
                if (game_num[2] == 0) {
                    zamena(3, 2);
                    vivod();
                }
                if (game_num[7] == 0) {
                    zamena(3, 7);
                    vivod();
                }
                break;
            case R.id.button5:
                if (game_num[0] == 0) {
                    zamena(4, 0);
                    vivod();
                }
                if (game_num[5] == 0) {
                    zamena(4, 5);
                    vivod();
                }
                if (game_num[8] == 0) {
                    zamena(4, 8);
                    vivod();
                }
                break;
            case R.id.button6:
                if (game_num[1] == 0) {
                    zamena(5, 1);
                    vivod();
                }
                if (game_num[4] == 0) {
                    zamena(5, 4);
                    vivod();
                }
                if (game_num[6] == 0) {
                    zamena(5, 6);
                    vivod();
                }
                if (game_num[9] == 0) {
                    zamena(5, 9);
                    vivod();
                }
                break;
            case R.id.button7:
                if (game_num[2] == 0) {
                    zamena(6, 2);
                    vivod();
                }
                if (game_num[5] == 0) {
                    zamena(6, 5);
                    vivod();
                }
                if (game_num[7] == 0) {
                    zamena(6, 7);
                    vivod();
                }
                if (game_num[10] == 0) {
                    zamena(6, 10);
                    vivod();
                }
                break;
            case R.id.button8:
                if (game_num[3] == 0) {
                    zamena(7, 3);
                    vivod();
                }
                if (game_num[6] == 0) {
                    zamena(7, 6);
                    vivod();
                }
                if (game_num[11] == 0) {
                    zamena(7, 11);
                    vivod();
                }
                break;
            case R.id.button9:
                if (game_num[4] == 0) {
                    zamena(8, 4);
                    vivod();
                }
                if (game_num[9] == 0) {
                    zamena(8, 9);
                    vivod();
                }
                if (game_num[12] == 0) {
                    zamena(8, 12);
                    vivod();
                }
                break;
            case R.id.button10:
                if (game_num[5] == 0) {
                    zamena(9, 5);
                    vivod();
                }
                if (game_num[8] == 0) {
                    zamena(9, 8);
                    vivod();
                }
                if (game_num[10] == 0) {
                    zamena(9, 10);
                    vivod();
                }
                if (game_num[13] == 0) {
                    zamena(9, 13);
                    vivod();
                }
                break;
            case R.id.button11:
                if (game_num[6] == 0) {
                    zamena(10, 6);
                    vivod();
                }
                if (game_num[9] == 0) {
                    zamena(10, 9);
                    vivod();
                }
                if (game_num[11] == 0) {
                    zamena(10, 11);
                    vivod();
                }
                if (game_num[14] == 0) {
                    zamena(10, 14);
                    vivod();
                }
                break;
            case R.id.button12:
                if (game_num[7] == 0) {
                    zamena(11, 7);
                    vivod();
                }
                if (game_num[10] == 0) {
                    zamena(11, 10);
                    vivod();
                }
                if (game_num[15] == 0) {
                    zamena(11, 15);
                    vivod();
                }
                break;
            case R.id.button13:
                if (game_num[8] == 0) {
                    zamena(12, 8);
                    vivod();
                }
                if (game_num[13] == 0) {
                    zamena(12, 13);
                    vivod();
                }
                break;
            case R.id.button14:
                if (game_num[9] == 0) {
                    zamena(13, 9);
                    vivod();
                }
                if (game_num[12] == 0) {
                    zamena(13, 12);
                    vivod();
                }
                if (game_num[14] == 0) {
                    zamena(13, 14);
                    vivod();
                }
                break;
            case R.id.button15:
                if (game_num[10] == 0) {
                    zamena(14, 10);
                    vivod();
                }
                if (game_num[13] == 0) {
                    zamena(14, 13);
                    vivod();
                }
                if (game_num[15] == 0) {
                    zamena(14, 15);
                    vivod();
                }
                break;
            case R.id.zero:
                if (game_num[11] == 0) {
                    zamena(15, 11);
                    vivod();
                }
                if (game_num[14] == 0) {
                    zamena(15, 14);
                    vivod();
                }
                break;
            case R.id.next:
                restart();
                //Intent intent1 = new Intent(Fifteen.this, Fifteen.class);
                //startActivity(intent1);
                break;
            case R.id.menu:
                Intent intent2 = new Intent(Fifteen.this, Menu.class);
                startActivity(intent2);
                break;
        }
    }
}