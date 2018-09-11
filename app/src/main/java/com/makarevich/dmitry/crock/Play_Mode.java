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

public class Play_Mode extends AppCompatActivity {
    private ImageView imageView3, imageView4, imageView5, img_ManOne, img_ManTwo, img_WomOne, img_manT, img_ManF, img_ManFi, img_WomTw, img_ManSix, img_ManSev, img_ManEigh;
    private TextView text_User, text_User2, text_User3, textView2, textView3, textView4;
    @SuppressLint("StaticFieldLeak")
    public static Context context_play_mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play__mode);
        context_play_mode = getApplicationContext();
        text_User = findViewById(R.id.text_User);
        text_User2 = findViewById(R.id.text_User2);
        text_User3 = findViewById(R.id.text_User3);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        img_ManOne = findViewById(R.id.img_ManOne);
        img_ManTwo = findViewById(R.id.img_ManTwo);
        img_WomOne = findViewById(R.id.img_WomOne);
        img_manT = findViewById(R.id.img_manT);
        img_ManF = findViewById(R.id.img_ManF);
        img_ManFi = findViewById(R.id.img_ManFi);
        img_WomTw = findViewById(R.id.img_WomTw);
        img_ManSix = findViewById(R.id.img_ManSix);
        img_ManSev = findViewById(R.id.img_ManSev);
        img_ManEigh = findViewById(R.id.img_ManEigh);
        RelativeLayout one = findViewById(R.id.one);
        RelativeLayout two = findViewById(R.id.two);
        RelativeLayout three = findViewById(R.id.five);
        PushImg();
        Font();
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.getOne();
                Intent one = new Intent(Play_Mode.this, RulesOneToOne.class);
                startActivity(one);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent comand = new Intent(Play_Mode.this, RulesComand.class);
                startActivity(comand);
                SharedPref.getTwo();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent comvscom = new Intent(Play_Mode.this, RulesCommandToCommand.class);
                startActivity(comvscom);
                SharedPref.getTree();
            }
        });
    }

    public static Context getContextPlayMode() {
        return context_play_mode;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(Play_Mode.this, MainMenu.class);
        startActivity(back);

    }

    private void PushImg() {
        int first = R.drawable.crocko_green;
        int second = R.drawable.man_two;
        int third = R.drawable.man_three;
        int four = R.drawable.man_one;
        int five = R.drawable.wom_one;
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
                .into(img_ManOne);
        Glide
                .with(this)
                .load(third)
                .into(img_ManTwo);
        Glide
                .with(this)
                .load(five)
                .into(img_WomOne);
        Glide
                .with(this)
                .load(four)
                .into(img_manT);
        Glide
                .with(this)
                .load(third)
                .into(img_ManF);
        Glide
                .with(this)
                .load(second)
                .into(img_ManFi);
        Glide
                .with(this)
                .load(five)
                .into(img_WomTw);
        Glide
                .with(this)
                .load(third)
                .into(img_ManSix);
        Glide
                .with(this)
                .load(four)
                .into(img_ManSev);
        Glide
                .with(this)
                .load(second)
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
