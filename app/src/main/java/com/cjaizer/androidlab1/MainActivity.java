package com.cjaizer.androidlab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button restart;
    ImageView view1, view2, view3, view4, view5, view6, view7, view8, view9, view10, view11, view12, view13, view14, view15, view16;
    List<ImageView> listOfViews = new ArrayList<>();
    List<Drawable> listOfImages = new ArrayList<>();
    ImageView button1;
    ImageView button2;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();

        restart.setOnClickListener(v -> {
            for (ImageView view : listOfViews) {
                setUp();
                view.setVisibility(View.VISIBLE);
                view.setImageResource(R.color.design_default_color_primary);
            }
            counter = 0;
            button1 = null;
            button2 = null;
        });

        for (ImageView view : listOfViews) {
            view.setOnClickListener(v -> {
                if (button1 == null & button1 != view) {
                    view.setImageDrawable(listOfImages.get(listOfViews.indexOf(view)));
                    button1 = view;
                } else if (button1 != view) {
                    view.setImageDrawable(listOfImages.get(listOfViews.indexOf(view)));
                    button2 = view;
                    checkWin();
                }
            });
        }
    }

    void checkWin(){
        for (ImageView view : listOfViews) {
            view.setClickable(false);
        }
        new Handler().postDelayed(() -> {
            if (button1.getDrawable().getConstantState().equals(button2.getDrawable().getConstantState())) {
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                ++counter;
                if (counter == 8) {
                    Toast.makeText(this, "Win", Toast.LENGTH_LONG).show();
                }
            } else {
                button1.setImageResource(R.color.design_default_color_primary);
                button2.setImageResource(R.color.design_default_color_primary);

            }
            button1 = null;
            button2 = null;
            for (ImageView view : listOfViews) {
                view.setClickable(true);
            }
        },1000);
    }

    void setUp(){
        restart = findViewById(R.id.restart);
        view1 = findViewById(R.id.imageView1);
        view2 = findViewById(R.id.imageView2);
        view3 = findViewById(R.id.imageView3);
        view4 = findViewById(R.id.imageView4);
        view5 = findViewById(R.id.imageView5);
        view6 = findViewById(R.id.imageView6);
        view7 = findViewById(R.id.imageView7);
        view8 = findViewById(R.id.imageView8);
        view9 = findViewById(R.id.imageView9);
        view10 = findViewById(R.id.imageView10);
        view11 = findViewById(R.id.imageView11);
        view12 = findViewById(R.id.imageView12);
        view13 = findViewById(R.id.imageView13);
        view14 = findViewById(R.id.imageView14);
        view15 = findViewById(R.id.imageView15);
        view16 = findViewById(R.id.imageView16);
        listOfViews = new ArrayList<>(Arrays.asList(view1, view2, view3, view4, view5, view6, view7, view8, view9,
                view10, view11, view12, view13, view14, view15, view16));
        for (ImageView view : listOfViews) {
            view.setImageResource(R.color.design_default_color_primary);
        }
        listOfImages = new ArrayList<>(Arrays.asList(getDrawable(R.drawable.ic_one), getDrawable(R.drawable.ic_one),
                getDrawable(R.drawable.ic_two), getDrawable(R.drawable.ic_two), getDrawable(R.drawable.ic_three),
                getDrawable(R.drawable.ic_three), getDrawable(R.drawable.ic_four), getDrawable(R.drawable.ic_four),
                getDrawable(R.drawable.ic_five), getDrawable(R.drawable.ic_five), getDrawable(R.drawable.ic_six),
                getDrawable(R.drawable.ic_six), getDrawable(R.drawable.ic_seven), getDrawable(R.drawable.ic_seven),
                getDrawable(R.drawable.ic_eight), getDrawable(R.drawable.ic_eight)));
        Collections.shuffle(listOfImages);
    }
}