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

public class Store extends AppCompatActivity {
    private ImageView imageView27, imageView30, imageView28, imageView29, img_ManTwo, img_ManFi, img_ManTen, img_ManEi, img_ManEigh, imageView39;
    private TextView textView45, textView44, textView2, textView3, textView90, textView99, textView4, textView68, textView63, textView64, textView65, textView66, textView67;
    @SuppressLint("StaticFieldLeak")
    public static Context context_store;
    private TextView textView47, textView52, textView50, textView56, textView54, textView77;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        context_store = getApplicationContext();
        textView47 = findViewById(R.id.textView47);
        textView52 = findViewById(R.id.textView52);
        textView50 = findViewById(R.id.textView50);
        textView54 = findViewById(R.id.textView54);
        textView56 = findViewById(R.id.textView56);
        textView45 = findViewById(R.id.textView45);
        textView44 = findViewById(R.id.textView44);
        textView2 = findViewById(R.id.textView2);
        textView77 = findViewById(R.id.textView77);
        textView3 = findViewById(R.id.textView3);
        textView90 = findViewById(R.id.textView90);
        textView99 = findViewById(R.id.textView99);
        textView4 = findViewById(R.id.textView4);
        textView63 = findViewById(R.id.textView63);
        textView64 = findViewById(R.id.textView64);
        textView65 = findViewById(R.id.textView65);
        textView66 = findViewById(R.id.textView66);
        textView67 = findViewById(R.id.textView67);
        textView68 = findViewById(R.id.textView68);
        imageView27 = findViewById(R.id.imageView27);
        imageView39 = findViewById(R.id.imageView39);
        imageView30 = findViewById(R.id.imageView30);
        imageView28 = findViewById(R.id.imageView28);
        imageView29 = findViewById(R.id.imageView29);
        img_ManTwo = findViewById(R.id.img_ManTwo);
        img_ManFi = findViewById(R.id.img_ManFi);
        img_ManTen = findViewById(R.id.img_ManTen);
        img_ManEi = findViewById(R.id.img_ManEi);
        img_ManEigh = findViewById(R.id.img_ManEigh);
        RelativeLayout one = findViewById(R.id.one);
        RelativeLayout two = findViewById(R.id.two);
        RelativeLayout three = findViewById(R.id.three);
        RelativeLayout five = findViewById(R.id.five);
        RelativeLayout six = findViewById(R.id.six);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        textView68.startAnimation(anim);
        Font();
        GetDicCount();
        PushImage();
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(Store.this, LastStorePage.class);
                startActivity(next);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Store.this);
                builder.setTitle(getString(R.string.play_store_c))
                        .setMessage(getString(R.string.message4))
                        .setIcon(R.drawable.crocko_green)
                        .setCancelable(false)
                        .setPositiveButton(getString(R.string.yes),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        BuyAnimal();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(Store.this);
                builder.setTitle(getString(R.string.play_store_c))
                        .setMessage(getString(R.string.message5))
                        .setIcon(R.drawable.crocko_green)
                        .setCancelable(false)
                        .setPositiveButton(getString(R.string.yes),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        BuyPlanet();
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
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Store.this);
                builder.setTitle(getString(R.string.play_store_c))
                        .setMessage(getString(R.string.message6))
                        .setIcon(R.drawable.crocko_green)
                        .setCancelable(false)
                        .setPositiveButton(getString(R.string.yes),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        BuyProfessions();
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
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Store.this);
                builder.setTitle(getString(R.string.play_store_c))
                        .setMessage(getString(R.string.message7))
                        .setIcon(R.drawable.crocko_green)
                        .setCancelable(false)
                        .setPositiveButton(getString(R.string.yes),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        BuyTransport();
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

    public static Context getContextStore() {
        return context_store;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(Store.this, MainMenu.class);
        startActivity(back);
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
        textView68.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView64.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView65.setTypeface(Typeface.createFromAsset(
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
        int seven = R.drawable.starts;
        int eight = R.drawable.animals;
        int nine = R.drawable.worlds;
        int ten = R.drawable.professions;
        int eleven = R.drawable.ship;
        int twelve = R.drawable.coins;


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
                .into(img_ManEi);
        Glide
                .with(this)
                .load(eleven)
                .into(img_ManEigh);
        Glide
                .with(this)
                .load(twelve)
                .into(imageView39);

    }

    @SuppressLint("SetTextI18n")
    public void GetDicCount() {
        Context applicationContext = Store.getContextStore();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");
        String coins = sharedPreferences.getString("COIN", "");
        textView77.setText(coins + " " + getString(R.string.coinss));
        if (def_locale.contains("ru")) {
            String animal_ru = sharedPreferences.getString("RU_ANIMAL_CURSOR", "");
            String planet_ru = sharedPreferences.getString("RU_PLANET_CURSOR", "");
            String professions_ru = sharedPreferences.getString("RU_PROFESSIONS_CURSOR", "");
            String transport_ru = sharedPreferences.getString("RU_TRANSPORT_CURSOR", "");
            int start_int_ru = Integer.parseInt(sharedPreferences.getString("RU_EASY_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("RU_MEDIUM_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("RU_HARD_CURSOR", ""));
            String starting_ru = String.valueOf(start_int_ru);
            textView47.setText(getString(R.string.for_y) + "\n" + starting_ru + "\n" + getString(R.string.word));
            textView52.setText(getString(R.string.for_y) + "\n" + animal_ru + "\n" + getString(R.string.word));
            textView50.setText(getString(R.string.for_y) + "\n" + planet_ru + "\n" + getString(R.string.word));
            textView56.setText(getString(R.string.for_y) + "\n" + professions_ru + "\n" + getString(R.string.word));
            textView54.setText(getString(R.string.for_y) + "\n" + transport_ru + "\n" + getString(R.string.word));
        }
        if (def_locale.contains("en")) {
            String animal_en = sharedPreferences.getString("EN_ANIMAL_CURSOR", "");
            String planet_en = sharedPreferences.getString("EN_PLANET_CURSOR", "");
            String professions_en = sharedPreferences.getString("EN_PROFESSIONS_CURSOR", "");
            String transport_en = sharedPreferences.getString("EN_TRANSPORT_CURSOR", "");
            int start_int_en = Integer.parseInt(sharedPreferences.getString("EN_EASY_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("EN_MEDIUM_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("EN_HARD_CURSOR", ""));
            String starting_en = String.valueOf(start_int_en);
            textView47.setText(getString(R.string.for_y) + "\n" + starting_en + "\n" + getString(R.string.word));
            textView52.setText(getString(R.string.for_y) + "\n" + animal_en + "\n" + getString(R.string.word));
            textView50.setText(getString(R.string.for_y) + "\n" + planet_en + "\n" + getString(R.string.word));
            textView56.setText(getString(R.string.for_y) + "\n" + professions_en + "\n" + getString(R.string.word));
            textView54.setText(getString(R.string.for_y) + "\n" + transport_en + "\n" + getString(R.string.word));
        }
        if (def_locale.contains("de")) {
            String animal_de = sharedPreferences.getString("DE_ANIMAL_CURSOR", "");
            String planet_de = sharedPreferences.getString("DE_PLANET_CURSOR", "");
            String professions_de = sharedPreferences.getString("DE_PROFESSIONS_CURSOR", "");
            String transport_de = sharedPreferences.getString("DE_TRANSPORT_CURSOR", "");
            int start_int_de = Integer.parseInt(sharedPreferences.getString("DE_EASY_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("DE_MEDIUM_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("DE_HARD_CURSOR", ""));
            String starting_de = String.valueOf(start_int_de);
            textView47.setText(getString(R.string.for_y) + "\n" + starting_de + "\n" + getString(R.string.word));
            textView52.setText(getString(R.string.for_y) + "\n" + animal_de + "\n" + getString(R.string.word));
            textView50.setText(getString(R.string.for_y) + "\n" + planet_de + "\n" + getString(R.string.word));
            textView56.setText(getString(R.string.for_y) + "\n" + professions_de + "\n" + getString(R.string.word));
            textView54.setText(getString(R.string.for_y) + "\n" + transport_de + "\n" + getString(R.string.word));
        }
        if (def_locale.contains("es")) {
            String animal_es = sharedPreferences.getString("ES_ANIMAL_CURSOR", "");
            String planet_es = sharedPreferences.getString("ES_PLANET_CURSOR", "");
            String professions_es = sharedPreferences.getString("ES_PROFESSIONS_CURSOR", "");
            String transport_es = sharedPreferences.getString("ES_TRANSPORT_CURSOR", "");
            int start_int_es = Integer.parseInt(sharedPreferences.getString("ES_EASY_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("ES_MEDIUM_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("ES_HARD_CURSOR", ""));
            String starting_es = String.valueOf(start_int_es);
            textView47.setText(getString(R.string.for_y) + "\n" + starting_es + "\n" + getString(R.string.word));
            textView52.setText(getString(R.string.for_y) + "\n" + animal_es + "\n" + getString(R.string.word));
            textView50.setText(getString(R.string.for_y) + "\n" + planet_es + "\n" + getString(R.string.word));
            textView56.setText(getString(R.string.for_y) + "\n" + professions_es + "\n" + getString(R.string.word));
            textView54.setText(getString(R.string.for_y) + "\n" + transport_es + "\n" + getString(R.string.word));
        }
    }

    public void BuyAnimal() {
        Context applicationContext = Store.getContextStore();
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");
        String coins = sharedPreferences.getString("COIN", "");
        int animal_rus = Integer.parseInt(sharedPreferences.getString("RU_ANIMAL_CURSOR", ""));
        int animal_eng = Integer.parseInt(sharedPreferences.getString("EN_ANIMAL_CURSOR", ""));
        int animal_de = Integer.parseInt(sharedPreferences.getString("DE_ANIMAL_CURSOR", ""));
        int animal_es = Integer.parseInt(sharedPreferences.getString("ES_ANIMAL_CURSOR", ""));
        int coin = Integer.parseInt(coins);
        if (coin > 110) {
            if (def_locale.contains("ru") && animal_rus < 115) {
                int animal = Integer.parseInt(sharedPreferences.getString("RU_ANIMAL_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("RU_ANIMAL_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
            if (def_locale.contains("en") && animal_eng < 115) {
                int animal = Integer.parseInt(sharedPreferences.getString("EN_ANIMAL_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("EN_ANIMAL_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
            if (def_locale.contains("de") && animal_de < 115) {
                int animal = Integer.parseInt(sharedPreferences.getString("DE_ANIMAL_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("DE_ANIMAL_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
            if (def_locale.contains("es") && animal_es < 115) {
                int animal = Integer.parseInt(sharedPreferences.getString("ES_ANIMAL_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("ES_ANIMAL_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
        } else {
            Toast.makeText(applicationContext, getString(R.string.no_coin_store), Toast.LENGTH_SHORT).show();
        }
    }


    public void BuyPlanet() {
        Context applicationContext = Store.getContextStore();
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");
        String coins = sharedPreferences.getString("COIN", "");
        int planet_rus = Integer.parseInt(sharedPreferences.getString("RU_PLANET_CURSOR", ""));
        int planet_eng = Integer.parseInt(sharedPreferences.getString("EN_PLANET_CURSOR", ""));
        int planet_de = Integer.parseInt(sharedPreferences.getString("DE_PLANET_CURSOR", ""));
        int planet_es = Integer.parseInt(sharedPreferences.getString("ES_PLANET_CURSOR", ""));
        int coin = Integer.parseInt(coins);
        if (coin > 110) {
            if (def_locale.contains("ru") && planet_rus < 435) {
                int animal = Integer.parseInt(sharedPreferences.getString("RU_PLANET_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("RU_PLANET_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
            if (def_locale.contains("en") && planet_eng < 435) {
                int animal = Integer.parseInt(sharedPreferences.getString("EN_PLANET_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("EN_PLANET_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
            if (def_locale.contains("de") && planet_de < 435) {
                int animal = Integer.parseInt(sharedPreferences.getString("DE_PLANET_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("DE_PLANET_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
            if (def_locale.contains("es") && planet_es < 435) {
                int animal = Integer.parseInt(sharedPreferences.getString("ES_PLANET_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("ES_PLANET_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
        } else {
            Toast.makeText(applicationContext, getString(R.string.no_coin_store), Toast.LENGTH_SHORT).show();
        }
    }

    public void BuyProfessions() {
        Context applicationContext = Store.getContextStore();
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");
        String coins = sharedPreferences.getString("COIN", "");
        int professions_rus = Integer.parseInt(sharedPreferences.getString("RU_PROFESSIONS_CURSOR", ""));
        int professions_eng = Integer.parseInt(sharedPreferences.getString("EN_PROFESSIONS_CURSOR", ""));
        int professions_de = Integer.parseInt(sharedPreferences.getString("DE_PROFESSIONS_CURSOR", ""));
        int professions_es = Integer.parseInt(sharedPreferences.getString("ES_PROFESSIONS_CURSOR", ""));
        int coin = Integer.parseInt(coins);
        if (coin > 110) {
            if (def_locale.contains("ru") && professions_rus < 205) {
                int animal = Integer.parseInt(sharedPreferences.getString("RU_PROFESSIONS_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("RU_PROFESSIONS_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
            if (def_locale.contains("en") && professions_eng < 205) {
                int animal = Integer.parseInt(sharedPreferences.getString("EN_PROFESSIONS_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("EN_PROFESSIONS_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
            if (def_locale.contains("de") && professions_de < 205) {
                int animal = Integer.parseInt(sharedPreferences.getString("DE_PROFESSIONS_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("DE_PROFESSIONS_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
            if (def_locale.contains("es") && professions_es < 205) {
                int animal = Integer.parseInt(sharedPreferences.getString("ES_PROFESSIONS_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("ES_PROFESSIONS_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
        } else {
            Toast.makeText(applicationContext, getString(R.string.no_coin_store), Toast.LENGTH_SHORT).show();
        }
    }

    public void BuyTransport() {
        Context applicationContext = Store.getContextStore();
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");
        String coins = sharedPreferences.getString("COIN", "");
        int transport_rus = Integer.parseInt(sharedPreferences.getString("RU_TRANSPORT_CURSOR", ""));
        int transport_eng = Integer.parseInt(sharedPreferences.getString("EN_TRANSPORT_CURSOR", ""));
        int transport_de = Integer.parseInt(sharedPreferences.getString("DE_TRANSPORT_CURSOR", ""));
        int transport_es = Integer.parseInt(sharedPreferences.getString("ES_TRANSPORT_CURSOR", ""));
        int coin = Integer.parseInt(coins);
        if (coin > 110) {
            if (def_locale.contains("ru") && transport_rus < 195) {
                int animal = Integer.parseInt(sharedPreferences.getString("RU_TRANSPORT_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("RU_TRANSPORT_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
            if (def_locale.contains("en") && transport_eng < 195) {
                int animal = Integer.parseInt(sharedPreferences.getString("EN_TRANSPORT_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("EN_TRANSPORT_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
            if (def_locale.contains("de") && transport_de < 195) {
                int animal = Integer.parseInt(sharedPreferences.getString("DE_TRANSPORT_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("DE_TRANSPORT_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
            if (def_locale.contains("es") && transport_es < 195) {
                int animal = Integer.parseInt(sharedPreferences.getString("ES_TRANSPORT_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("ES_TRANSPORT_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(Store.this, Store.class);
                startActivity(refresh);
            }
        } else {
            Toast.makeText(applicationContext, getString(R.string.no_coin_store), Toast.LENGTH_SHORT).show();
        }
    }
}
