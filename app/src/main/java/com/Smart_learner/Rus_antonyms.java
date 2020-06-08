package com.Smart_learner;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Rus_antonyms extends Menu{
    ImageView Image;    // Для картинки

    private Button button[] = new Button[4];                // Для выбора

    private Drawable baza_drawable [] = new Drawable[10];         //Все картинки

    private int[] num_text = {-1,-1,-1,-1};
    private String baza_text [] = new String[10];

    private int index_image;

    Random rnd = new Random();


    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Rus_antonyms.this, Menu.class);
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
        setContentView(R.layout.activity_rus_antonyms);

        Image = (ImageView) findViewById(R.id.imageView);

        button[0] = (Button) findViewById(R.id.click1);
        button[1] = (Button) findViewById(R.id.click2);
        button[2] = (Button) findViewById(R.id.click3);
        button[3] = (Button) findViewById(R.id.click4);

        for(int i=0; i<4; i++) {
            button[i].setBackgroundResource(R.drawable.button_styles);
            button[i].setOnClickListener(this);
        }
        initialization();
    }

    //База изобраений
    private void baza()
    {
        baza_drawable[0]=getDrawable(R.drawable.bistriy);
        baza_drawable[1]=getDrawable(R.drawable.medlenniy);
        baza_drawable[2]=getDrawable(R.drawable.chistiy);
        baza_drawable[3]=getDrawable(R.drawable.gryazniy);
        baza_drawable[4]=getDrawable(R.drawable.holodno);
        baza_drawable[5]=getDrawable(R.drawable.jarko);
        baza_drawable[6]=getDrawable(R.drawable.hydoy);
        baza_drawable[7]=getDrawable(R.drawable.tolstiy);
        baza_drawable[8]=getDrawable(R.drawable.legkiy);
        baza_drawable[9]=getDrawable(R.drawable.tyajoliy);

        baza_text [0]= "Медленный";
        baza_text [1]= "Быстрый";
        baza_text [2]= "Грязный";
        baza_text [3]= "Чистый";
        baza_text [4]= "Жарко";
        baza_text [5]= "Холодно";
        baza_text [6]= "Толстый";
        baza_text [7]= "Худой";
        baza_text [8]= "Тяжелый";
        baza_text [9]= "Легкий";
    }

    //Инициализация кнопок
    private void initialization(){
        index_image = rnd.nextInt(10);

        boolean flag =true;
        int index = 0;
        //Рандомное заполнение вариантов ответа
        do
        {
            int num = rnd.nextInt(10);
            for(int i=0; i<4; i++)
                if(num_text[i] == num)
                    flag = false;
            if(flag == true) {
                num_text[index] = num;
                index++;
            }
            else index --;
            if(index==4) {
                for (int i = 0; i < 4; i++) {
                    boolean flag_1 =true;
                    if (num_text[i] == index_image) {
                        flag_1 = false;
                        break;
                    }
                    if(flag_1==true && i==3) {
                        int k = rnd.nextInt(4);
                        num_text[k] = index_image;
                    }
                }
            }
            flag = true;
        }
        while(index != 4);
        output_on_display();
    }

    //Вывод на экран
    public void output_on_display()
    {
        Image.setBackground(baza_drawable[index_image]);

        for (int i = 0; i<4; i++){
            button[i].setText(baza_text[num_text[i]]);
        }
    }

    //Обработка нажатий
    private void click(int k)
    {
        if (num_text[k]==index_image){
            print(1);
        }
        else{
            print(0);
        }
    }


    TextView textView;
    Button next, menu;


    private void print( int num){
        setContentView(R.layout.activity_result);

        textView = (TextView) findViewById(R.id.text_result);

        next = (Button) findViewById(R.id.next);
        menu= (Button) findViewById(R.id.menu);

        next.setBackgroundResource(R.drawable.button_styles);
        menu.setBackgroundResource(R.drawable.button_styles);

        next.setOnClickListener(this);
        menu.setOnClickListener(this);

        if (num==1)
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
                //Intent intent1 = new Intent(Rus_antonyms.this, Rus_antonyms.class);
                //startActivity(intent1);
                break;
            case R.id.menu:
                Intent intent2 = new Intent(Rus_antonyms.this, Menu.class);
                startActivity(intent2);
                break;
        }
    }
}
