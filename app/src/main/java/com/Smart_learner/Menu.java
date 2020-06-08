package com.Smart_learner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity implements View.OnClickListener {


    //Button menu_button_math, menu_button_rus, menu_button_puzzle, menu_button_paint, menu_button_music, menu_button_fifteen;

    Button[] menu_button = new Button[7];
    Button[] menu_rus_button = new Button[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menu_button[0] = (Button) findViewById(R.id.button_menu1);
        menu_button[1] = (Button) findViewById(R.id.button_menu2);
        menu_button[2] = (Button) findViewById(R.id.button_menu3);
        menu_button[3] = (Button) findViewById(R.id.button_menu4);
        menu_button[4] = (Button) findViewById(R.id.button_menu5);
        menu_button[5] = (Button) findViewById(R.id.button_menu6);
        menu_button[6] = (Button) findViewById(R.id.button_exit);

        for(int i=0; i<menu_button.length; i++) {
            menu_button[i].setOnClickListener(this);
        }
    }

    private void russian()
    {
        setContentView(R.layout.activity_rus_menu);

        menu_rus_button[0] = (Button) findViewById(R.id.button_antonyms);
        menu_rus_button[1] = (Button) findViewById(R.id.button_synonyms);

        for(int i=0; i<menu_rus_button.length; i++) {
            menu_rus_button[i].setBackgroundResource(R.drawable.button_styles);
            menu_rus_button[i].setOnClickListener(this);
        }

    }

    public void appExit () {
        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_menu1:
                Intent intent1 = new Intent(Menu.this, Mathematic.class);
                startActivity(intent1);
                break;
            case R.id.button_menu2:
                russian();
                break;
            case R.id.button_menu3:
                Intent intent3 = new Intent(Menu.this, Puzzle.class);
                startActivity(intent3);
                break;
            case R.id.button_menu4:
                Intent intent4 = new Intent(Menu.this, Paint.class);
                startActivity(intent4);
                break;
            case R.id.button_menu5:
                Intent intent5 = new Intent(Menu.this, Music.class);
                startActivity(intent5);
                break;
            case R.id.button_menu6:
                Intent intent6 = new Intent(Menu.this, Fifteen.class);
                startActivity(intent6);
                break;
            case R.id.button_exit:
                appExit();
                break;
            case R.id.button_antonyms:
                Intent intent7 = new Intent(Menu.this, Rus_antonyms.class);
                startActivity(intent7);
                break;
            case R.id.button_synonyms:
                Intent intent8 = new Intent(Menu.this, Rus_synonyms.class);
                startActivity(intent8);
                break;
        }
    }
}