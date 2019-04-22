package com.example.switchingimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageViewUp,imageViewDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewUp = findViewById(R.id.imageUp);
        imageViewDown = findViewById(R.id.imageDown);
    }

    public void onBtnClicked(View v){
        showImageView(v);
    }

    private void showImageView(View v){
        switch (v.getId()){
            case R.id.btnUp:
                imageViewUp.setVisibility(View.VISIBLE);
                imageViewDown.setVisibility(View.INVISIBLE);
                break;
            case R.id.btnDown:
                imageViewUp.setVisibility(View.INVISIBLE);
                imageViewDown.setVisibility(View.VISIBLE);
                break;
        }
    }
}
