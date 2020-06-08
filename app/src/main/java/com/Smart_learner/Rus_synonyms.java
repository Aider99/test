package com.Smart_learner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Rus_synonyms extends Menu{
    TextView Text;    // Для картинки

    private Button button[] = new Button[4];                // Для выбора

    private String baza_synonims [][] = new String[20][2];         //Все картинки

    private int num_text [] = new int [4];

    private int win;
    private int index_flag;

    TextView textView;
    Button next, menu;

    Random rnd = new Random();

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Rus_synonyms.this, Menu.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baza();
        restart();
    }

    private void restart(){
        setContentView(R.layout.activity_rus_synonims);

        Text = (TextView) findViewById(R.id.text_synonims);

        button[0] = (Button) findViewById(R.id.click1);
        button[1] = (Button) findViewById(R.id.click2);
        button[2] = (Button) findViewById(R.id.click3);
        button[3] = (Button) findViewById(R.id.click4);

        for(int i=0; i<4; i++) {
            num_text[i] = -1;
            button[i].setBackgroundResource(R.drawable.button_styles);
            button[i].setOnClickListener(this);
        }
        initialization();
    }

    //База изобраений
    private void baza()
    {
        baza_synonims [0][0] = "Белый";
        baza_synonims [0][1] = "Белоснежный";

        baza_synonims [1][0] = "Беспокоиться";
        baza_synonims [1][1] = "Тревожиться";

        baza_synonims [2][0] = "Блестеть";
        baza_synonims [2][1] = "Сиять";

        baza_synonims [3][0] = "Большой";
        baza_synonims [3][1] = "Огромный";

        baza_synonims [4][0] = "Вежливый";
        baza_synonims [4][1] = "Воспитанный";

        baza_synonims [5][0] = "Видеть";
        baza_synonims [5][1] = "Наблюдать";

        baza_synonims [6][0] = "Гореть";
        baza_synonims [6][1] = "Пылать";

        baza_synonims [7][0] = "Дерзкий";
        baza_synonims [7][1] = "Грубый";

        baza_synonims [8][0] = "Жаркий";
        baza_synonims [8][1] = "Горячий";

        baza_synonims [9][0] = "Жадный";
        baza_synonims [9][1] = "Алчный";

        baza_synonims [10][0] = "Источник";
        baza_synonims [10][1] = "Родник";

        baza_synonims [11][0] = "Красный";
        baza_synonims [11][1] = "Алый";

        baza_synonims [12][0] = "Неловкий";
        baza_synonims [12][1] = "Неуклюжий";

        baza_synonims [13][0] = "Перерыв";
        baza_synonims [13][1] = "Пауза";

        baza_synonims [14][0] = "Пища";
        baza_synonims [14][1] = "Еда";

        baza_synonims [15][0] = "Праздник";
        baza_synonims [15][1] = "Торжество";

        baza_synonims [16][0] = "Прохлада";
        baza_synonims [16][1] = "Свежесть";

        baza_synonims [17][0] = "Родина";
        baza_synonims [17][1] = "Отчизна";

        baza_synonims [18][0] = "Сказать";
        baza_synonims [18][1] = "Молвить";

        baza_synonims [19][0] = "Холод";
        baza_synonims [19][1] = "Мороз";
    }

    //Инициализация кнопок
    private void initialization(){
        boolean flag =true;
        int index = 0;
        //Рандомное заполнение вариантов ответа
        do {
            int num = rnd.nextInt(20);
            for(int i =0; i<4; i++)
                if(num_text[i] == num)
                    flag = false;
            if(flag == true) {
                num_text[index] = num;
                index++;
            }
            else index--;
            flag = true;
        }
        while(index != 4);
        win = rnd.nextInt(4);
        index_flag = rnd.nextInt(2);
        output_on_display();
    }

    //Вывод на экран
    private void output_on_display()
    {
        Text.setText(baza_synonims[num_text[win]][index_flag]);

        for (int i = 0; i<4; i++){
            if(index_flag == 1)
                button[i].setText(baza_synonims[num_text[i]][0]);
            else
                button[i].setText(baza_synonims[num_text[i]][1]);
        }
    }

    //Обработка нажатий
    private void click(int k) {
        if (k == win) print(1);
        else print(0);
    }

    private void print( int num_flag){
        setContentView(R.layout.activity_result);
        textView = (TextView) findViewById(R.id.text_result);

        next = (Button) findViewById(R.id.next);
        menu= (Button) findViewById(R.id.menu);

        next.setBackgroundResource(R.drawable.button_styles);
        menu.setBackgroundResource(R.drawable.button_styles);

        next.setOnClickListener(this);
        menu.setOnClickListener(this);

        if (num_flag==1)
            textView.setText("Молодец, ты ответил правильно.");
        else
            textView.setText("Неправильно, давай продолжать.");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click1:
                click(0);
                break;
            case R.id.click2:
                click(1);
                break;
            case R.id.click3:
                click(2);
                break;
            case R.id.click4:
                click(3);
                break;
            case R.id.next:
                restart();
                //Intent intent1 = new Intent(Rus_synonyms.this, Rus_synonyms.class);
                //startActivity(intent1);
                break;
            case R.id.menu:
                Intent intent2 = new Intent(Rus_synonyms.this, Menu.class);
                startActivity(intent2);
                break;
        }
    }
}
