package com.Smart_learner;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class Puzzle extends Menu {
        ImageButton imButton[] = new ImageButton[9];    // Для элементов пазла

        Button return_the_menu_button;
        Button next_button;

        Drawable baza_drawable [][] = new Drawable[9][9];         //Все элементы картинок

        Drawable drawable [] = new Drawable[9];         //начальное положение
        Drawable win_drawable [] = new Drawable[9];     //Победный исход
        String win_text [] = new String[9];

        TextView TXT;
        int click=0;
        int index=0;
        int h;
        Random rnd = new Random();

        @Override
        public void onBackPressed(){
            Intent intent = new Intent(Puzzle.this, Menu.class);
            startActivity(intent);
            finish();
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            baza();
            restart();
        }

        private void restart()
        {
            setContentView(R.layout.activity_puzzle);


            imButton[0] = (ImageButton) findViewById(R.id.imageButton1);
            imButton[1] = (ImageButton) findViewById(R.id.imageButton2);
            imButton[2] = (ImageButton) findViewById(R.id.imageButton3);
            imButton[3] = (ImageButton) findViewById(R.id.imageButton4);
            imButton[4] = (ImageButton) findViewById(R.id.imageButton5);
            imButton[5] = (ImageButton) findViewById(R.id.imageButton6);
            imButton[6] = (ImageButton) findViewById(R.id.imageButton7);
            imButton[7] = (ImageButton) findViewById(R.id.imageButton8);
            imButton[8] = (ImageButton) findViewById(R.id.imageButton9);


            for(int i=0; i<9; i++) {
                imButton[i].setOnClickListener(this);
            }

            initialization();
        }

        //Перемешивание
        private void mixing() {
            for(int i=0; i<10; i++){
                int h = rnd.nextInt(9);
                int j = rnd.nextInt(9);
                replacement(h,j);
            }
            output_on_display();
        }

        //База изобраений
        private void baza()
         {
            baza_drawable[0][0]=getDrawable(R.drawable.doctor1);
            baza_drawable[0][1]=getDrawable(R.drawable.doctor2);
            baza_drawable[0][2]=getDrawable(R.drawable.doctor3);
            baza_drawable[0][3]=getDrawable(R.drawable.doctor4);
            baza_drawable[0][4]=getDrawable(R.drawable.doctor5);
            baza_drawable[0][5]=getDrawable(R.drawable.doctor6);
            baza_drawable[0][6]=getDrawable(R.drawable.doctor7);
            baza_drawable[0][7]=getDrawable(R.drawable.doctor8);
            baza_drawable[0][8]=getDrawable(R.drawable.doctor9);

            baza_drawable[1][0]=getDrawable(R.drawable.driver1);
            baza_drawable[1][1]=getDrawable(R.drawable.driver2);
            baza_drawable[1][2]=getDrawable(R.drawable.driver3);
            baza_drawable[1][3]=getDrawable(R.drawable.driver4);
            baza_drawable[1][4]=getDrawable(R.drawable.driver5);
            baza_drawable[1][5]=getDrawable(R.drawable.driver6);
            baza_drawable[1][6]=getDrawable(R.drawable.driver7);
            baza_drawable[1][7]=getDrawable(R.drawable.driver8);
            baza_drawable[1][8]=getDrawable(R.drawable.driver9);

            baza_drawable[2][0]=getDrawable(R.drawable.hairdresser1);
            baza_drawable[2][1]=getDrawable(R.drawable.hairdresser2);
            baza_drawable[2][2]=getDrawable(R.drawable.hairdresser3);
            baza_drawable[2][3]=getDrawable(R.drawable.hairdresser4);
            baza_drawable[2][4]=getDrawable(R.drawable.hairdresser5);
            baza_drawable[2][5]=getDrawable(R.drawable.hairdresser6);
            baza_drawable[2][6]=getDrawable(R.drawable.hairdresser7);
            baza_drawable[2][7]=getDrawable(R.drawable.hairdresser8);
            baza_drawable[2][8]=getDrawable(R.drawable.hairdresser9);

            baza_drawable[3][0]=getDrawable(R.drawable.carpenter1);
            baza_drawable[3][1]=getDrawable(R.drawable.carpenter2);
            baza_drawable[3][2]=getDrawable(R.drawable.carpenter3);
            baza_drawable[3][3]=getDrawable(R.drawable.carpenter4);
            baza_drawable[3][4]=getDrawable(R.drawable.carpenter5);
            baza_drawable[3][5]=getDrawable(R.drawable.carpenter6);
            baza_drawable[3][6]=getDrawable(R.drawable.carpenter7);
            baza_drawable[3][7]=getDrawable(R.drawable.carpenter8);
            baza_drawable[3][8]=getDrawable(R.drawable.carpenter9);

            baza_drawable[4][0]=getDrawable(R.drawable.farmer1);
            baza_drawable[4][1]=getDrawable(R.drawable.farmer2);
            baza_drawable[4][2]=getDrawable(R.drawable.farmer3);
            baza_drawable[4][3]=getDrawable(R.drawable.farmer4);
            baza_drawable[4][4]=getDrawable(R.drawable.farmer5);
            baza_drawable[4][5]=getDrawable(R.drawable.farmer6);
            baza_drawable[4][6]=getDrawable(R.drawable.farmer7);
            baza_drawable[4][7]=getDrawable(R.drawable.farmer8);
            baza_drawable[4][8]=getDrawable(R.drawable.farmer9);

            baza_drawable[5][0]=getDrawable(R.drawable.painter1);
            baza_drawable[5][1]=getDrawable(R.drawable.painter2);
            baza_drawable[5][2]=getDrawable(R.drawable.painter3);
            baza_drawable[5][3]=getDrawable(R.drawable.painter4);
            baza_drawable[5][4]=getDrawable(R.drawable.painter5);
            baza_drawable[5][5]=getDrawable(R.drawable.painter6);
            baza_drawable[5][6]=getDrawable(R.drawable.painter7);
            baza_drawable[5][7]=getDrawable(R.drawable.painter8);
            baza_drawable[5][8]=getDrawable(R.drawable.painter9);

            baza_drawable[6][0]=getDrawable(R.drawable.pilot1);
            baza_drawable[6][1]=getDrawable(R.drawable.pilot2);
            baza_drawable[6][2]=getDrawable(R.drawable.pilot3);
            baza_drawable[6][3]=getDrawable(R.drawable.pilot4);
            baza_drawable[6][4]=getDrawable(R.drawable.pilot5);
            baza_drawable[6][5]=getDrawable(R.drawable.pilot6);
            baza_drawable[6][6]=getDrawable(R.drawable.pilot7);
            baza_drawable[6][7]=getDrawable(R.drawable.pilot8);
            baza_drawable[6][8]=getDrawable(R.drawable.pilot9);

            baza_drawable[7][0]=getDrawable(R.drawable.sailor1);
            baza_drawable[7][1]=getDrawable(R.drawable.sailor2);
            baza_drawable[7][2]=getDrawable(R.drawable.sailor3);
            baza_drawable[7][3]=getDrawable(R.drawable.sailor4);
            baza_drawable[7][4]=getDrawable(R.drawable.sailor5);
            baza_drawable[7][5]=getDrawable(R.drawable.sailor6);
            baza_drawable[7][6]=getDrawable(R.drawable.sailor7);
            baza_drawable[7][7]=getDrawable(R.drawable.sailor8);
            baza_drawable[7][8]=getDrawable(R.drawable.sailor9);

            baza_drawable[8][0]=getDrawable(R.drawable.sempstress1);
            baza_drawable[8][1]=getDrawable(R.drawable.sempstress2);
            baza_drawable[8][2]=getDrawable(R.drawable.sempstress3);
            baza_drawable[8][3]=getDrawable(R.drawable.sempstress4);
            baza_drawable[8][4]=getDrawable(R.drawable.sempstress5);
            baza_drawable[8][5]=getDrawable(R.drawable.sempstress6);
            baza_drawable[8][6]=getDrawable(R.drawable.sempstress7);
            baza_drawable[8][7]=getDrawable(R.drawable.sempstress8);
            baza_drawable[8][8]=getDrawable(R.drawable.sempstress9);

            win_text [0]= "Доктор";
            win_text [1]= "Водитель";
            win_text [2]= "Парихмахер";
            win_text [3]= "Столяр";
            win_text [4]= "Фермер";
            win_text [5]= "Художник";
            win_text [6]= "Пилот";
            win_text [7]= "Моряк";
            win_text [8]= "Швея";
        }

        //Инициализация кнопок
        private void initialization(){
            h = rnd.nextInt(9);

            win_drawable[0] = drawable[0] = baza_drawable[h][0];
            win_drawable[1] = drawable[1] = baza_drawable[h][1];
            win_drawable[2] = drawable[2] = baza_drawable[h][2];
            win_drawable[3] = drawable[3] = baza_drawable[h][3];
            win_drawable[4] = drawable[4] = baza_drawable[h][4];
            win_drawable[5] = drawable[5] = baza_drawable[h][5];
            win_drawable[6] = drawable[6] = baza_drawable[h][6];
            win_drawable[7] = drawable[7] = baza_drawable[h][7];
            win_drawable[8] = drawable[8] = baza_drawable[h][8];

            mixing();
        }

        //Вывод на экран
        private void output_on_display()
        {
            for(int i=0; i<9; i++) {
                imButton[i].setBackground(drawable[i]);
            }

            //Проверка на правильность пазла
            boolean win = true;
            for(int i = 0; i<9; i++)
            {
                if(win_drawable[i] != drawable[i])
                    win=false; }
            if(win==true) {
                setContentView(R.layout.activity_puzzle_result);
                TXT = (TextView) findViewById(R.id.you_win);
                TXT.setText("Профессия: "+win_text[h]);

                imButton[0] = (ImageButton) findViewById(R.id.imageButton1);
                imButton[1] = (ImageButton) findViewById(R.id.imageButton2);
                imButton[2] = (ImageButton) findViewById(R.id.imageButton3);
                imButton[3] = (ImageButton) findViewById(R.id.imageButton4);
                imButton[4] = (ImageButton) findViewById(R.id.imageButton5);
                imButton[5] = (ImageButton) findViewById(R.id.imageButton6);
                imButton[6] = (ImageButton) findViewById(R.id.imageButton7);
                imButton[7] = (ImageButton) findViewById(R.id.imageButton8);
                imButton[8] = (ImageButton) findViewById(R.id.imageButton9);

                for(int i=0; i<9; i++) {
                    imButton[i].setBackground(drawable[i]);
                }

                return_the_menu_button = (Button) findViewById(R.id.return_the_menu_button1);
                return_the_menu_button.setOnClickListener(this);

                next_button = (Button) findViewById(R.id.next_button);
                next_button.setOnClickListener(this);

                return_the_menu_button.setBackgroundResource(R.drawable.button_styles);
                next_button.setBackgroundResource(R.drawable.button_styles);
            }
        }

        //Меняет местами два выбранных элемента
        private void replacement(int k,int j)
        {
            Drawable a = drawable[k];
            drawable[k] = drawable[j];
            drawable[j] = a;
        }

        //Обработка нажатий
        private void click(int k)
        {
            if (index==0){
                click=k;
                index++;}
            else{
                replacement(click,k);
                index=0;}
            output_on_display();
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageButton1:
                    click(0);
                    break;
                case R.id.imageButton2:
                    click(1);
                    break;
                case R.id.imageButton3:
                    click(2);
                    break;
                case R.id.imageButton4:
                    click(3);
                    break;
                case R.id.imageButton5:
                    click(4);
                    break;
                case R.id.imageButton6:
                    click(5);
                    break;
                case R.id.imageButton7:
                    click(6);
                    break;
                case R.id.imageButton8:
                    click(7);
                    break;
                case R.id.imageButton9:
                    click(8);
                    break;
                case R.id.return_the_menu_button1:
                    Intent intent1 = new Intent(Puzzle.this, Menu.class);
                    startActivity(intent1);
                    break;
                case R.id.next_button:
                    restart();
                    //Intent intent2 = new Intent(Puzzle.this, Puzzle.class);
                    //startActivity(intent2);
                    break;
            }
        }
}