package com.example.movs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float previousX, previousY;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt = (TextView) findViewById(R.id.text);
        View fondo = findViewById(R.id.fondo);
        fondo.setOnTouchListener((v, e) -> {
            float x, y;
            x = e.getX();
            y = e.getY();
            switch(e.getAction()){
                case MotionEvent.ACTION_DOWN:
                    txt.setText("DOWN");
                    previousX = e.getX();
                    previousY = e.getY();
                    break;
                case MotionEvent.ACTION_UP:
                    txt.setText("UP");
                    break;
                case MotionEvent.ACTION_MOVE:
                    if(y < previousY){
                        if(x < previousX){
                            txt.setText("ARRIBA - IZQUIERDA");
                        }
                        else if(x > previousX){
                            txt.setText("ARRIBA - DERECHA");
                        }
                        else{
                            txt.setText("ARRIBA");
                        }
                    }
                    else if(y > previousY){
                        if(x < previousX){
                            txt.setText("ABAJO - IZQUIERDA");
                        }
                        else if(x > previousX){
                            txt.setText("ABAJO - DERECHA");
                        }
                        else{
                            txt.setText("ABAJO");
                        }
                    }
                    else{
                        if(x < previousX){
                            txt.setText("IZQUIERDA");
                        }
                        else if(x > previousX){
                            txt.setText("DERECHA");
                        }
                    }

                    break;

            }
            return true;
        });
    }
}