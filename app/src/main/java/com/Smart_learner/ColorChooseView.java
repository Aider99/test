package com.Smart_learner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ColorChooseView extends Menu {

    int ColorCode= Paint.defaultColour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_choose_view);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
    }
    public void GoBack(View View){
        finish();
    }
    public void ColorPick(View View){
        openDialog(false);
    }
    private void openDialog (boolean supportAlpha){
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, ColorCode, supportAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                finish();
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                ColorCode = color;
                Intent ReturnColor = new Intent(ColorChooseView.this, Paint.class);
                ReturnColor.putExtra("ColorCode", ColorCode);
                setResult(RESULT_OK,ReturnColor);
                finish();
            }
        });
        dialog.show();
    }

}
