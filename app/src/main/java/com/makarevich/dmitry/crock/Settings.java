package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Settings extends AppCompatActivity {
    private ImageView imageView3, imageView4, imageView5, img_Play, img_Book, img_Ekstr, imageView24, imageView23, imageView22, imageView25;
    private TextView text_User, text_User2, text_User3, textView2, textView3, textView4;
    @SuppressLint("StaticFieldLeak")
    public static Context context_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        context_settings = getApplicationContext();
        RelativeLayout three = findViewById(R.id.five);
        text_User = findViewById(R.id.text_User);
        text_User2 = findViewById(R.id.text_User2);
        text_User3 = findViewById(R.id.text_User3);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        imageView25 = findViewById(R.id.imageView25);
        imageView24 = findViewById(R.id.imageView24);
        imageView23 = findViewById(R.id.imageView23);
        imageView22 = findViewById(R.id.imageView22);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        img_Play = findViewById(R.id.img_Play);
        img_Book = findViewById(R.id.img_Book);
        img_Ekstr = findViewById(R.id.img_Ekstr);
        PushImage();
        Font();
        img_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.LangRu();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Settings.this);
                builder.setTitle(getString(R.string.about_developer))
                        .setMessage("Тут будет какой-то текст")
                        .setIcon(R.drawable.crocko_green)
                        .setCancelable(false)
                        .setNegativeButton(getString(R.string.back),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }

        });
        imageView25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeLanguage change = new ChangeLanguage();
                change.Spain();
            }
        });
        imageView22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeLanguage change = new ChangeLanguage();
                change.Russian();
            }
        });
        imageView23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeLanguage change = new ChangeLanguage();
                change.English();
            }
        });
        imageView24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeLanguage change = new ChangeLanguage();
                change.Germany();
            }
        });
    }

    public static Context getContexSetings() {
        return context_settings;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(Settings.this, MainMenu.class);
        startActivity(back);
    }

    public void PushImage() {
        int first = R.drawable.crocko_green;
        int second = R.drawable.language;
        int third = R.drawable.gaming;
        int four = R.drawable.ninj;
        int five = R.drawable.germany;
        int six = R.drawable.england;
        int seven = R.drawable.russian;
        int eight = R.drawable.spain;
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
                .into(img_Play);
        Glide
                .with(this)
                .load(third)
                .into(img_Book);
        Glide
                .with(this)
                .load(four)
                .into(img_Ekstr);
        Glide
                .with(this)
                .load(five)
                .into(imageView24);
        Glide
                .with(this)
                .load(six)
                .into(imageView23);
        Glide
                .with(this)
                .load(seven)
                .into(imageView22);
        Glide
                .with(this)
                .load(eight)
                .into(imageView25);
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
