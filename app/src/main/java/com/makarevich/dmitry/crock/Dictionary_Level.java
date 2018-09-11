package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Dictionary_Level extends AppCompatActivity {
    private ImageView imageView3, imageView4, imageView5, img_ManTwo, img_ManFi, img_ManEigh, img_ManSI;
    private TextView text_User, text_User2, text_User3, textView2, textView3, textView4, textView47;
    @SuppressLint("StaticFieldLeak")
    public static Context context_dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        context_dictionary = getApplicationContext();
        text_User = findViewById(R.id.text_User);
        text_User2 = findViewById(R.id.text_User2);
        text_User3 = findViewById(R.id.text_User3);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView47 = findViewById(R.id.textView47);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        img_ManTwo = findViewById(R.id.img_ManTwo);
        img_ManFi = findViewById(R.id.img_ManFi);
        img_ManEigh = findViewById(R.id.img_ManEigh);
        img_ManSI = findViewById(R.id.img_ManSI);
        RelativeLayout one = findViewById(R.id.one);
        RelativeLayout two = findViewById(R.id.two);
        RelativeLayout five = findViewById(R.id.five);
        RelativeLayout fives = findViewById(R.id.fives);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.getDicOne();
                SharedPref.Perehod();
                SharedPref.Play_Start_Easy();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.getDicTwo();
                SharedPref.Perehod();
                SharedPref.Play_Start_Medium();
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.getDicTree();
                SharedPref.Perehod();
                SharedPref.Play_Start_Hard();
            }
        });
        fives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.Perehod();
                SharedPref.Play_Start_Mixsy();

            }
        });

        PushImage();
        Font();
    }

    public static Context getContexDictionary() {
        return context_dictionary;
    }

    @Override
    public void onBackPressed() {
        Intent bac = new Intent(Dictionary_Level.this, Play_Mode.class);
        startActivity(bac);
    }

    public void PushImage() {
        int first = R.drawable.crocko_green;
        int second = R.drawable.easy;
        int third = R.drawable.medium;
        int four = R.drawable.hard;
        int five = R.drawable.mixsy;
        Glide
                .with(this)
                .load(first)
                .into(imageView3);
        Glide
                .with(this)
                .load(first)
                .into(imageView4);
        Glide
                .with(this)
                .load(first)
                .into(imageView5);
        Glide
                .with(this)
                .load(second)
                .into(img_ManTwo);
        Glide
                .with(this)
                .load(third)
                .into(img_ManFi);
        Glide
                .with(this)
                .load(four)
                .into(img_ManEigh);
        Glide
                .with(this)
                .load(five)
                .into(img_ManSI);
    }

    public void Font() {
        text_User.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView2.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView4.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        text_User2.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        text_User3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView47.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }
}
