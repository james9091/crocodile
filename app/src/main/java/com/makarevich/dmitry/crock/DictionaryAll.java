package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DictionaryAll extends AppCompatActivity {
    private ImageView imageView27, imageView31, imageView30, imageView28, imageView29, imageView32, img_ManTwo, img_ManFi, img_ManTen, img_ManEi, img_ManEigh;
    private TextView textView45, textView44, textView2, textView3, textView90, textView99, textView4;
    @SuppressLint("StaticFieldLeak")
    public static Context context_dictionary_all;
    private TextView textView47, textView52, textView50, textView56, textView54;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary__all);
        context_dictionary_all = getApplicationContext();
        textView45 = findViewById(R.id.textView45);
        textView44 = findViewById(R.id.textView44);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView90 = findViewById(R.id.textView90);
        textView99 = findViewById(R.id.textView99);
        textView4 = findViewById(R.id.textView4);
        textView47 = findViewById(R.id.textView47);
        textView52 = findViewById(R.id.textView52);
        textView50 = findViewById(R.id.textView50);
        textView54 = findViewById(R.id.textView54);
        textView56 = findViewById(R.id.textView56);
        imageView27 = findViewById(R.id.imageView27);
        imageView31 = findViewById(R.id.imageView31);
        imageView30 = findViewById(R.id.imageView30);
        imageView28 = findViewById(R.id.imageView28);
        imageView29 = findViewById(R.id.imageView29);
        imageView32 = findViewById(R.id.imageView32);
        img_ManTwo = findViewById(R.id.img_ManTwo);
        img_ManFi = findViewById(R.id.img_ManFi);
        img_ManTen = findViewById(R.id.img_ManTen);
        img_ManEi = findViewById(R.id.img_ManEi);
        img_ManEigh = findViewById(R.id.img_ManEigh);
        RelativeLayout one = findViewById(R.id.one);
        RelativeLayout two = findViewById(R.id.two);
        RelativeLayout three = findViewById(R.id.three);
        RelativeLayout six = findViewById(R.id.six);
        RelativeLayout five = findViewById(R.id.five);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Next();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.Play_Animal();
                SharedPref.Perehod_Two();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.Play_Planet();
                SharedPref.Perehod_Two();
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.Play_Kids();
                SharedPref.Perehod_Two();
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.Play_Profession();
                SharedPref.Perehod_Two();
            }
        });
        PushImage();
        Font();
        GetDicCount();
    }

    public static Context getContexDictionaryAll() {
        return context_dictionary_all;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(DictionaryAll.this, Play_Mode.class);
        startActivity(back);
    }

    public void Next() {
        Intent next = new Intent(DictionaryAll.this, Dictionary_Level.class);
        startActivity(next);
    }

    public void Font() {
        textView45.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView2.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView4.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView44.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView90.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView99.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }

    public void PushImage() {

        int first = R.drawable.crocko_green;
        int second = R.drawable.sad;
        int third = R.drawable.medium;
        int four = R.drawable.easy;
        int five = R.drawable.hard;
        int six = R.drawable.mixsy;
        int seven = R.drawable.starts;
        int eight = R.drawable.animals;
        int nine = R.drawable.worlds;
        int ten = R.drawable.professions;
        int eleven = R.drawable.ship;


        Glide
                .with(this)
                .load(first)
                .into(imageView27);
        Glide
                .with(this)
                .load(second)
                .into(imageView31);
        Glide
                .with(this)
                .load(third)
                .into(imageView30);
        Glide
                .with(this)
                .load(four)
                .into(imageView28);
        Glide
                .with(this)
                .load(five)
                .into(imageView29);
        Glide
                .with(this)
                .load(six)
                .into(imageView32);
        Glide
                .with(this)
                .load(seven)
                .into(img_ManTwo);
        Glide
                .with(this)
                .load(eight)
                .into(img_ManFi);
        Glide
                .with(this)
                .load(nine)
                .into(img_ManTen);
        Glide
                .with(this)
                .load(ten)
                .into(img_ManEi);
        Glide
                .with(this)
                .load(eleven)
                .into(img_ManEigh);

    }

    @SuppressLint("SetTextI18n")
    public void GetDicCount() {

        Context applicationContext = DictionaryAll.getContexDictionaryAll();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");

        if (def_locale.contains("ru")) {
            String animal_ru = sharedPreferences.getString("RU_ANIMAL_CURSOR", "");
            String planet_ru = sharedPreferences.getString("RU_PLANET_CURSOR", "");
            String professions_ru = sharedPreferences.getString("RU_PROFESSIONS_CURSOR", "");
            String transport_ru = sharedPreferences.getString("RU_TRANSPORT_CURSOR", "");
            int start_int_ru = Integer.parseInt(sharedPreferences.getString("RU_EASY_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("RU_MEDIUM_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("RU_HARD_CURSOR", ""));
            String starting_ru = String.valueOf(start_int_ru);
            textView47.setText(getString(R.string.good) + "\n" + starting_ru + "\n" + getString(R.string.word));
            textView52.setText(getString(R.string.good) + "\n" + animal_ru + "\n" + getString(R.string.word));
            textView50.setText(getString(R.string.good) + "\n" + planet_ru + "\n" + getString(R.string.word));
            textView56.setText(getString(R.string.good) + "\n" + professions_ru + "\n" + getString(R.string.word));
            textView54.setText(getString(R.string.good) + "\n" + transport_ru + "\n" + getString(R.string.word));
        }
        if (def_locale.contains("en")) {
            String animal_en = sharedPreferences.getString("EN_ANIMAL_CURSOR", "");
            String planet_en = sharedPreferences.getString("EN_PLANET_CURSOR", "");
            String professions_en = sharedPreferences.getString("EN_PROFESSIONS_CURSOR", "");
            String transport_en = sharedPreferences.getString("EN_TRANSPORT_CURSOR", "");
            int start_int_en = Integer.parseInt(sharedPreferences.getString("EN_EASY_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("EN_MEDIUM_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("EN_HARD_CURSOR", ""));
            String starting_en = String.valueOf(start_int_en);
            textView47.setText(getString(R.string.good) + "\n" + starting_en + "\n" + getString(R.string.word));
            textView52.setText(getString(R.string.good) + "\n" + animal_en + "\n" + getString(R.string.word));
            textView50.setText(getString(R.string.good) + "\n" + planet_en + "\n" + getString(R.string.word));
            textView56.setText(getString(R.string.good) + "\n" + professions_en + "\n" + getString(R.string.word));
            textView54.setText(getString(R.string.good) + "\n" + transport_en + "\n" + getString(R.string.word));
        }
        if (def_locale.contains("de")) {
            String animal_de = sharedPreferences.getString("DE_ANIMAL_CURSOR", "");
            String planet_de = sharedPreferences.getString("DE_PLANET_CURSOR", "");
            String professions_de = sharedPreferences.getString("DE_PROFESSIONS_CURSOR", "");
            String transport_de = sharedPreferences.getString("DE_TRANSPORT_CURSOR", "");
            int start_int_de = Integer.parseInt(sharedPreferences.getString("DE_EASY_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("DE_MEDIUM_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("DE_HARD_CURSOR", ""));
            String starting_de = String.valueOf(start_int_de);
            textView47.setText(getString(R.string.good) + "\n" + starting_de + "\n" + getString(R.string.word));
            textView52.setText(getString(R.string.good) + "\n" + animal_de + "\n" + getString(R.string.word));
            textView50.setText(getString(R.string.good) + "\n" + planet_de + "\n" + getString(R.string.word));
            textView56.setText(getString(R.string.good) + "\n" + professions_de + "\n" + getString(R.string.word));
            textView54.setText(getString(R.string.good) + "\n" + transport_de + "\n" + getString(R.string.word));
        }
        if (def_locale.contains("es")) {
            String animal_es = sharedPreferences.getString("ES_ANIMAL_CURSOR", "");
            String planet_es = sharedPreferences.getString("ES_PLANET_CURSOR", "");
            String professions_es = sharedPreferences.getString("ES_PROFESSIONS_CURSOR", "");
            String transport_es = sharedPreferences.getString("ES_TRANSPORT_CURSOR", "");
            int start_int_es = Integer.parseInt(sharedPreferences.getString("ES_EASY_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("ES_MEDIUM_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("ES_HARD_CURSOR", ""));
            String starting_es = String.valueOf(start_int_es);
            textView47.setText(getString(R.string.good) + "\n" + starting_es + "\n" + getString(R.string.word));
            textView52.setText(getString(R.string.good) + "\n" + animal_es + "\n" + getString(R.string.word));
            textView50.setText(getString(R.string.good) + "\n" + planet_es + "\n" + getString(R.string.word));
            textView56.setText(getString(R.string.good) + "\n" + professions_es + "\n" + getString(R.string.word));
            textView54.setText(getString(R.string.good) + "\n" + transport_es + "\n" + getString(R.string.word));
        }


    }
}
