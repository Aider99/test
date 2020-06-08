package com.Smart_learner;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Music extends Menu{
    Random rnd = new Random();

    private int win_num, win_num_but ;
    TextView textView;
    Button menu, resert;
    Button play, pause;
    private int correct_answer =0, answer=0;
    private int rand_music_index[] = new int[]{-1,-1,-1,-1};

    Button[] click_button = new Button[5];  //Массив кнопок для ввода

    MediaPlayer mPlayer;

    private int [] sounds = new int[]{R.raw.antoshka, R.raw.buratino, R.raw.chipdeyl,
            R.raw.ejik, R.raw.leto, R.raw.neyklyje, R.raw.sleda,
            R.raw.vodyanoy, R.raw.ylibka, R.raw.zima};

    private String [] sounds_name = new String[] {
            "Антошка",
            "Буратино",
            "Чип и Дейл",
            "Верь мне, Ежик (Смешарики)",
            "Песня про лето (Дед Мороз и Лето)",
            "Пусть бегут неуклюже (Чебурашка)",
            "Про следы (Маша и Медведь)",
            "Я Водяной",
            "От улыбки",
            "Кабы не было зимы (Простокваино)"};

    //При нажатии системной кнопки "Назад" - выход в главное меню и завершение проигрывание мелодии
    @Override
    public void onBackPressed(){
        mPlayer.stop();
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        finish();
    }

    //Рандомное определение вариантов ответа и расположение правильных ответов в нём
    private void rand() {
        int index = 0;
        int num;
        boolean flag = true;
        do
        {
            num = rnd.nextInt(sounds.length);
            for(int i=0; i<4; i++)
                if(rand_music_index[i] == num)
                    flag = false;
            if(flag == true) {
                rand_music_index[index] = num;
                index++;
            }
            flag = true;
        }
        while(index != 4);

        win_num_but=rnd.nextInt(4);
        win_num = rand_music_index[win_num_but];
    }

    private void output(){
        for (int i = 0; i<4; i++) {
            click_button[i].setBackgroundResource(R.drawable.button_styles);
            click_button[i].setEnabled(true);
        }
        click_button[4].setEnabled(false);

        rand();
        mPlayer=MediaPlayer.create(this, sounds[win_num]);
        for(int i=0;i<4;i++) {
            click_button[i].setText(sounds_name[rand_music_index[i]]);
        }

    }

    //Объявление всех кнопок
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restart();
    }

    private void restart()
    {
        setContentView(R.layout.activity_music);
        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        play.setBackgroundResource(R.drawable.button_styles);
        pause.setBackgroundResource(R.drawable.button_styles);

        click_button[0] = (Button) findViewById(R.id.click1);
        click_button[1] = (Button) findViewById(R.id.click2);
        click_button[2] = (Button) findViewById(R.id.click3);
        click_button[3] = (Button) findViewById(R.id.click4);
        click_button[4] = (Button) findViewById(R.id.button_music_next);

        click_button[4].setBackgroundResource(R.drawable.button_styles);

        for (int i = 0; i<5; i++)
            click_button[i].setOnClickListener(this);

        output();
    }

    //проверка
    private void chek(int win_index, int num){
        stop();
        answer++;
        click_button[num].setBackgroundResource(R.drawable.wrong);
        click_button[win_num_but].setBackgroundResource(R.drawable.right);
        if(win_num == win_index) {
            correct_answer++;
        }

        for (int i = 0; i<4; i++)
            click_button[i].setEnabled(false);
        click_button[4].setEnabled(true);
    }

    //Проигрывать, пауза, остановить мелодию
    public void play(View view) {
        mPlayer.start();
    }
    public void pause(View view) {
        mPlayer.pause();
    }
    public void stop() {
        mPlayer.stop();
    }

    private void print(int win){
        setContentView(R.layout.activity_result);

        textView = (TextView) findViewById(R.id.text_result);

        resert = (Button) findViewById(R.id.next);
        menu= (Button) findViewById(R.id.menu);

        resert.setBackgroundResource(R.drawable.button_styles);
        menu.setBackgroundResource(R.drawable.button_styles);

        resert.setOnClickListener(this);
        menu.setOnClickListener(this);

        textView.setText("Твой результат:"+'\n'+win+" из 5");
    }

    //Обработка нажатия
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click1:
                chek(rand_music_index[0],0);
                break;
            case R.id.click2:
                chek(rand_music_index[1],1);
                break;
            case R.id.click3:
                chek(rand_music_index[2],2);
                break;
            case R.id.click4:
                chek(rand_music_index[3],3);
                break;
            case R.id.button_music_next:
                if(answer==5)   print(correct_answer);
                output();
                break;
            case R.id.next:
                restart();
                //Intent inten = new Intent(Music.this, Music.class);
                //startActivity(inten);
                break;
            case R.id.menu:
                Intent intent = new Intent(Music.this, Menu.class);
                startActivity(intent);
                break;
        }
    }
}