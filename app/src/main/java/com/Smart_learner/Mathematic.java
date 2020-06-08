package com.Smart_learner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Mathematic extends Menu{

    private int result;                             //Результат выражения
    private int math_index;                         //Индекс математического выражения

    private String math[] = {"+","-","*","/"};      //Возможные действия

    private int num_1, num_2;                       //Значения выражения

    Random rnd = new Random();

    private int click_num[] = new int[9];

    Button[] result_button = new Button[5]; //Массив для вывода выражения
    Button[] click_button = new Button[9];  //Массив кнопок для ввода

    private int click = 1;
    private int click_1, click_2;


    //При нажатии системной кнопки "Назад" - выход в главное меню
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        finish();
    }

    //Рандомное определение вариантов ответа и расположение правильных ответов в нём
    private void rand() {
        boolean flag =true;
        int index = 0;
        int num;
        int rnd_num_1=0, rnd_num_2=0;

        //Рандомное заполнение вариантов ответа
        do
        {
            num = rnd.nextInt(100);
            for(int i=0; i<9; i++)
                if(click_num[i] == num)
                    flag = false;
            if(flag == true) {
                click_num[index] = num;
                index++;
            }
            flag = true;
        }
        while(index != 9);

        //Проверка наличия правильных ответов в вариантах
        //При отсутствии его, рандомная вставка
        for (int i = 0; i<2; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0) {
                    if (click_num[j] == num_1)
                        break;
                    else if (j == 8) {
                        rnd_num_1 = rnd.nextInt(9);
                        click_num[rnd_num_1] = num_1;
                    }
                } else {
                    if (click_num[j] == num_2)
                        break;
                    else if (j == 8) {
                        do {
                            rnd_num_2 = rnd.nextInt(9);
                        } while (rnd_num_2 == rnd_num_1);
                        click_num[rnd_num_2] = num_2;
                    }
                }
            }
        }

        //Вывод вариантов ответа
        for (int i=0; i<9; i++) {
            click_button[i].setText(Integer.toString(click_num[i]));
        }
    }

    //Рандомное определения математичекого действия, членов выражения и результата, а также вывод на экран
    private void output_on_display(){

        math_index = rnd.nextInt(4);
        result_button[1].setText(math[math_index]);
        do{
            if (math_index!=3)
                result = rnd.nextInt(100);
            else
                result = rnd.nextInt(10);
        }while (result==0);

        result_button[4].setText(Integer.toString(result));

        switch (math_index) {
            case 0:     // Сложение
                num_1=rnd.nextInt(result);
                num_2 = result - num_1;
                break;
            case 1:     // Вычитание
                num_2=rnd.nextInt(result);
                num_1 = result + num_2;
                break;
            case 2:     // Умножение
                do{
                    num_1 = rnd.nextInt(result);
                    num_2 = result/num_1;
                }while(result%num_1!=0 || num_1==0);
                break;
            case 3:     // Деление
                do{ num_2 = rnd.nextInt(10);
                }while(num_2==0);
                num_1 = result * num_2;
                break;
        }
        rand();
    }

    //Объявление всех кнопок и перезапуск приложения
    private void restart(){
        setContentView(R.layout.activity_math);

        result_button[0] = (Button) findViewById(R.id.button1);
        result_button[1] = (Button) findViewById(R.id.button2);
        result_button[2] = (Button) findViewById(R.id.button3);
        result_button[3] = (Button) findViewById(R.id.button4);
        result_button[4] = (Button) findViewById(R.id.button5);

        click_button[0] = (Button) findViewById(R.id.click1);
        click_button[1] = (Button) findViewById(R.id.click2);
        click_button[2] = (Button) findViewById(R.id.click3);
        click_button[3] = (Button) findViewById(R.id.click4);
        click_button[4] = (Button) findViewById(R.id.click5);
        click_button[5] = (Button) findViewById(R.id.click6);
        click_button[6] = (Button) findViewById(R.id.click7);
        click_button[7] = (Button) findViewById(R.id.click8);
        click_button[8] = (Button) findViewById(R.id.click9);

        for (int i = 0; i<9; i++) {
            if (i < 5) result_button[i].setBackgroundResource(R.drawable.button_styles_v2);
            click_button[i].setOnClickListener(this);
        }

        output_on_display();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restart();
    }

    private String win;
    TextView textView;
    Button next, menu;

    private void print( int win){
        setContentView(R.layout.activity_result);
        textView = (TextView) findViewById(R.id.text_result);

        next = (Button) findViewById(R.id.next);
        menu= (Button) findViewById(R.id.menu);

        next.setBackgroundResource(R.drawable.button_styles);
        menu.setBackgroundResource(R.drawable.button_styles);

        next.setOnClickListener(this);
        menu.setOnClickListener(this);
        String message = Integer.toString(click_1) + math[math_index] + Integer.toString(click_2) + "=" + Integer.toString(result);
        if (win==1)
            textView.setText("Выражение \n" + message + " составлено правильно. \n" + "Молодец, давай продолжать.");
        else
            textView.setText("Выражение \n" + message + " составлено неправильно. \n" + " Не расстраивайся, попробуй ещё раз.");
    }

    //проверка
    private void chek(){
        switch (math_index) {
            case 0:
                if (click_1 + click_2 == result)    print(1);
                else print(0);
                break;
            case 1:     // Вычитание
                if (click_1 - click_2 == result)    print(1);
                else print(0);
                break;
            case 2:     // Умножение
                if (click_1 * click_2 == result)    print(1);
                else print(0);
                break;
            case 3:     // Деление
                if (click_1 / click_2 == result)   print(1);
                else print(0);
                break;
        }
    }

    //Обработка нажатия
    private void click_funk (int number){
        if (click == 1)
        {
            click_1=number;
            result_button[0].setText(Integer.toString(click_1));
            click++;
        }
        else
        {
            click_2=number;
            result_button[2].setText(Integer.toString(click_2));
            click--;
            chek();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click1:
                click_funk(click_num[0]);
                break;
            case R.id.click2:
                click_funk(click_num[1]);
                break;
            case R.id.click3:
                click_funk(click_num[2]);
                break;
            case R.id.click4:
                click_funk(click_num[3]);
                break;
            case R.id.click5:
                click_funk(click_num[4]);
                break;
            case R.id.click6:
                click_funk(click_num[5]);
                break;
            case R.id.click7:
                click_funk(click_num[6]);
                break;
            case R.id.click8:
                click_funk(click_num[7]);
                break;
            case R.id.click9:
                click_funk(click_num[8]);
                break;
            case R.id.next:
                restart();
                //Intent intent1 = new Intent(Mathematic.this, Mathematic.class);
                //startActivity(intent1);
                break;
            case R.id.menu:
                Intent intent2 = new Intent(Mathematic.this, Menu.class);
                startActivity(intent2);
                break;
        }
    }
}