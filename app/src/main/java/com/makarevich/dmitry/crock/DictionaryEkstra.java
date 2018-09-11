package com.makarevich.dmitry.crock;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DictionaryEkstra extends AppCompatActivity {
    private ImageView imageView3, imageView4, imageView5, img_ManTwo, img_ManFi, img_ManEigh;
    private TextView text_User, text_User2, text_User3, textView2, textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary__ekstra);
        TextView textView32;
        textView32 = findViewById(R.id.textView32);
        TextView textView33 = findViewById(R.id.textView33);
        TextView textView34 = findViewById(R.id.textView34);
        text_User = findViewById(R.id.text_User);
        text_User2 = findViewById(R.id.text_User2);
        text_User3 = findViewById(R.id.text_User3);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        img_ManTwo = findViewById(R.id.img_ManTwo);
        img_ManFi = findViewById(R.id.img_ManFi);
        img_ManEigh = findViewById(R.id.img_ManEigh);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        textView32.startAnimation(anim);
        textView33.startAnimation(anim);
        textView34.startAnimation(anim);
        PushImage();
        Font();
    }

    @Override
    public void onBackPressed() {
        Intent bac = new Intent(DictionaryEkstra.this, MainMenu.class);
        startActivity(bac);
    }

    public void PushImage() {
        int first = R.drawable.crocko_green;
        int second = R.drawable.easy;
        int third = R.drawable.medium;
        int four = R.drawable.hard;
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
    }
}
