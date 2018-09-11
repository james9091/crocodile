package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class LastStorePage extends AppCompatActivity {

    private ImageView imageView27, imageView30, imageView40, imageView28, imageView29, img_ManTwo, img_ManFi, img_ManTen;
    private TextView textView45, textView44, textView2, textView3, textView90, textView68, textView63, textView66, textView67;
    private TextView textView47, textView52, textView50, textView78;
    @SuppressLint("StaticFieldLeak")
    public static Context context_last_store_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_store_page);
        context_last_store_page = getApplicationContext();
        textView47 = findViewById(R.id.textView47);
        textView52 = findViewById(R.id.textView52);
        textView50 = findViewById(R.id.textView50);
        textView45 = findViewById(R.id.textView45);
        textView44 = findViewById(R.id.textView44);
        textView78 = findViewById(R.id.textView78);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView90 = findViewById(R.id.textView90);
        textView63 = findViewById(R.id.textView63);
        textView66 = findViewById(R.id.textView66);
        textView67 = findViewById(R.id.textView67);
        textView68 = findViewById(R.id.textView68);
        imageView27 = findViewById(R.id.imageView27);
        imageView30 = findViewById(R.id.imageView30);
        imageView28 = findViewById(R.id.imageView28);
        imageView29 = findViewById(R.id.imageView29);
        imageView40 = findViewById(R.id.imageView40);
        img_ManTwo = findViewById(R.id.img_ManTwo);
        img_ManFi = findViewById(R.id.img_ManFi);
        img_ManTen = findViewById(R.id.img_ManTen);
        RelativeLayout one = findViewById(R.id.one);
        RelativeLayout two = findViewById(R.id.two);
        RelativeLayout three = findViewById(R.id.three);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        textView68.startAnimation(anim);
        Font();
        PushImage();
        getC();
        GetDicCount();
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LastStorePage.this);
                builder.setTitle(getString(R.string.play_store_c))
                        .setMessage(getString(R.string.message1))
                        .setIcon(R.drawable.crocko_green)
                        .setCancelable(false)
                        .setPositiveButton(getString(R.string.yes),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        BuyStartEasy();
                                    }
                                })
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

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LastStorePage.this);
                builder.setTitle(getString(R.string.play_store_c))
                        .setMessage(getString(R.string.message2))
                        .setIcon(R.drawable.crocko_green)
                        .setCancelable(false)
                        .setPositiveButton(getString(R.string.yes),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        BuyStartMedium();
                                    }
                                })
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
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LastStorePage.this);
                builder.setTitle(getString(R.string.play_store_c))
                        .setMessage(getString(R.string.message3))
                        .setIcon(R.drawable.crocko_green)
                        .setCancelable(false)
                        .setPositiveButton(getString(R.string.yes),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        BuyStartHard();
                                    }
                                })
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

    }

    public static Context getContextLastStorePage() {
        return context_last_store_page;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(LastStorePage.this, MainMenu.class);
        startActivity(back);
    }

    public void Font() {
        textView45.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView2.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView44.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView90.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView68.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView63.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView66.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView67.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }

    public void PushImage() {

        int first = R.drawable.crocko_green;
        int third = R.drawable.wallet;
        int four = R.drawable.cart;
        int five = R.drawable.sale;
        int seven = R.drawable.easy;
        int eight = R.drawable.medium;
        int nine = R.drawable.hard;
        int ten = R.drawable.coins;
        Glide
                .with(this)
                .load(first)
                .into(imageView27);
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
                .into(imageView40);
    }

    @SuppressLint("SetTextI18n")
    private void GetDicCount() {

        Context apl = LastStorePage.getContextLastStorePage();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(apl);
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");

        if (def_locale.contains("ru")) {
            String easy_ru = sharedPreferences.getString("RU_EASY_CURSOR", "");
            String medium_ru = sharedPreferences.getString("RU_MEDIUM_CURSOR", "");
            String hard_ru = sharedPreferences.getString("RU_HARD_CURSOR", "");
            textView47.setText(getString(R.string.good) + "\n" + easy_ru + "\n" + getString(R.string.word));
            textView52.setText(getString(R.string.good) + "\n" + medium_ru + "\n" + getString(R.string.word));
            textView50.setText(getString(R.string.good) + "\n" + hard_ru + "\n" + getString(R.string.word));

        }
        if (def_locale.contains("en")) {
            String easy_en = sharedPreferences.getString("EN_EASY_CURSOR", "");
            String medium_en = sharedPreferences.getString("EN_MEDIUM_CURSOR", "");
            String hard_en = sharedPreferences.getString("EN_HARD_CURSOR", "");
            textView47.setText(getString(R.string.good) + "\n" + easy_en + "\n" + getString(R.string.word));
            textView52.setText(getString(R.string.good) + "\n" + medium_en + "\n" + getString(R.string.word));
            textView50.setText(getString(R.string.good) + "\n" + hard_en + "\n" + getString(R.string.word));
        }
        if (def_locale.contains("de")) {
            String easy_de = sharedPreferences.getString("DE_EASY_CURSOR", "");
            String medium_de = sharedPreferences.getString("DE_MEDIUM_CURSOR", "");
            String hard_de = sharedPreferences.getString("DE_HARD_CURSOR", "");
            textView47.setText(getString(R.string.good) + "\n" + easy_de + "\n" + getString(R.string.word));
            textView52.setText(getString(R.string.good) + "\n" + medium_de + "\n" + getString(R.string.word));
            textView50.setText(getString(R.string.good) + "\n" + hard_de + "\n" + getString(R.string.word));
        }
        if (def_locale.contains("es")) {
            String easy_es = sharedPreferences.getString("ES_EASY_CURSOR", "");
            String medium_es = sharedPreferences.getString("ES_MEDIUM_CURSOR", "");
            String hard_es = sharedPreferences.getString("ES_HARD_CURSOR", "");
            textView47.setText(getString(R.string.good) + "\n" + easy_es + "\n" + getString(R.string.word));
            textView52.setText(getString(R.string.good) + "\n" + medium_es + "\n" + getString(R.string.word));
            textView50.setText(getString(R.string.good) + "\n" + hard_es + "\n" + getString(R.string.word));
        }
    }

    @SuppressLint("SetTextI18n")
    public void getC() {
        Context applicationContext = LastStorePage.getContextLastStorePage();
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        String coins = sharedPreferences.getString("COIN", "");
        textView78.setText(coins + " " + getString(R.string.coinss));
    }

    public void BuyStartEasy() {
        Context applicationContext = LastStorePage.getContextLastStorePage();
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");
        String coins = sharedPreferences.getString("COIN", "");
        int easy_rus = Integer.parseInt(sharedPreferences.getString("RU_EASY_CURSOR", ""));
        int easy_eng = Integer.parseInt(sharedPreferences.getString("EN_EASY_CURSOR", ""));
        int easy_de = Integer.parseInt(sharedPreferences.getString("DE_EASY_CURSOR", ""));
        int easy_es = Integer.parseInt(sharedPreferences.getString("ES_EASY_CURSOR", ""));
        int coin = Integer.parseInt(coins);
        if (coin > 110) {
            if (def_locale.contains("ru") && easy_rus < 980) {
                int animal = Integer.parseInt(sharedPreferences.getString("RU_EASY_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("RU_EASY_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("en") && easy_eng < 980) {
                int animal = Integer.parseInt(sharedPreferences.getString("EN_EASY_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("EN_EASY_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("de") && easy_de < 980) {
                int animal = Integer.parseInt(sharedPreferences.getString("DE_EASY_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("DE_EASY_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("es") && easy_es < 980) {
                int animal = Integer.parseInt(sharedPreferences.getString("ES_EASY_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("ES_EASY_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
        } else {
            Toast.makeText(applicationContext, getString(R.string.no_coin_store), Toast.LENGTH_SHORT).show();
        }
    }

    public void BuyStartMedium() {
        Context applicationContext = LastStorePage.getContextLastStorePage();
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");
        String coins = sharedPreferences.getString("COIN", "");
        int medium_rus = Integer.parseInt(sharedPreferences.getString("RU_MEDIUM_CURSOR", ""));
        int medium_eng = Integer.parseInt(sharedPreferences.getString("EN_MEDIUM_CURSOR", ""));
        int medium_de = Integer.parseInt(sharedPreferences.getString("DE_MEDIUM_CURSOR", ""));
        int medium_es = Integer.parseInt(sharedPreferences.getString("ES_MEDIUM_CURSOR", ""));
        int coin = Integer.parseInt(coins);
        if (coin > 110) {
            if (def_locale.contains("ru") && medium_rus < 2310) {
                int animal = Integer.parseInt(sharedPreferences.getString("RU_MEDIUM_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("RU_MEDIUM_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("en") && medium_eng < 2310) {
                int animal = Integer.parseInt(sharedPreferences.getString("EN_MEDIUM_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("EN_MEDIUM_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("de") && medium_de < 2310) {
                int animal = Integer.parseInt(sharedPreferences.getString("DE_MEDIUM_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("DE_MEDIUM_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("es") && medium_es < 2310) {
                int animal = Integer.parseInt(sharedPreferences.getString("ES_MEDIUM_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("ES_MEDIUM_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
        } else {
            Toast.makeText(applicationContext, getString(R.string.no_coin_store), Toast.LENGTH_SHORT).show();
        }
    }

    public void BuyStartHard() {
        Context applicationContext = LastStorePage.getContextLastStorePage();
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");
        String coins = sharedPreferences.getString("COIN", "");
        int hard_rus = Integer.parseInt(sharedPreferences.getString("RU_HARD_CURSOR", ""));
        int hard_eng = Integer.parseInt(sharedPreferences.getString("EN_HARD_CURSOR", ""));
        int hard_de = Integer.parseInt(sharedPreferences.getString("DE_HARD_CURSOR", ""));
        int hard_es = Integer.parseInt(sharedPreferences.getString("ES_HARD_CURSOR", ""));
        int coin = Integer.parseInt(coins);
        if (coin > 110) {
            if (def_locale.contains("ru") && hard_rus < 2020) {
                int animal = Integer.parseInt(sharedPreferences.getString("RU_HARD_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("RU_HARD_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("en") && hard_eng < 2020) {
                int animal = Integer.parseInt(sharedPreferences.getString("EN_HARD_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("EN_HARD_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("de") && hard_de < 2020) {
                int animal = Integer.parseInt(sharedPreferences.getString("DE_HARD_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("DE_HARD_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("es") && hard_es < 2020) {
                int animal = Integer.parseInt(sharedPreferences.getString("ES_HARD_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("ES_HARD_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
        } else {
            Toast.makeText(applicationContext, getString(R.string.no_coin_store), Toast.LENGTH_SHORT).show();
        }
    }
}