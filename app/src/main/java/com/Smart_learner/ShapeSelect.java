package com.Smart_learner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class ShapeSelect extends Menu {

    SeekBar brushSz;
    private String brush;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_select);
        SetDefault();
        Button Round = findViewById(R.id.Round);
        Round.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brush = "ROUND";
                SendBrush();
            }
        });
        Button Square = findViewById(R.id.Square);
        Square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brush = "SQUARE";
                SendBrush();
            }
        });
    }

    public void SendBrush(){
        brushSz = findViewById(R.id.BrushWidth);
        int size= brushSz.getProgress();
        Intent ReturnBrush = new Intent(this, Paint.class);
        ReturnBrush.putExtra("Size", size);
        ReturnBrush.putExtra("Shape",brush);
        setResult(RESULT_OK,ReturnBrush);
    }
    public void Back(View View){
        SendBrush();
        finish();
    }
    private void SetDefault(){
        if(Paint.defaultSize!= 0){
            brushSz = findViewById(R.id.BrushWidth);
            brushSz.setProgress(Paint.defaultSize);
        }
        if(Paint.defaultShape!= ""){
            brush = Paint.defaultShape;
        }
    }
}
