package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makarevich.dmitry.crock.room.De_Animal;
import com.makarevich.dmitry.crock.room.De_Easy;
import com.makarevich.dmitry.crock.room.De_Hard;
import com.makarevich.dmitry.crock.room.De_Medium;
import com.makarevich.dmitry.crock.room.De_Planet;
import com.makarevich.dmitry.crock.room.De_Professions;
import com.makarevich.dmitry.crock.room.De_Transport;
import com.makarevich.dmitry.crock.room.Eng_Animal;
import com.makarevich.dmitry.crock.room.Eng_Easy;
import com.makarevich.dmitry.crock.room.Eng_Hard;
import com.makarevich.dmitry.crock.room.Eng_Medium;
import com.makarevich.dmitry.crock.room.Eng_Planet;
import com.makarevich.dmitry.crock.room.Eng_Professions;
import com.makarevich.dmitry.crock.room.Eng_Transport;
import com.makarevich.dmitry.crock.room.Es_Animal;
import com.makarevich.dmitry.crock.room.Es_Easy;
import com.makarevich.dmitry.crock.room.Es_Hard;
import com.makarevich.dmitry.crock.room.Es_Medium;
import com.makarevich.dmitry.crock.room.Es_Planet;
import com.makarevich.dmitry.crock.room.Es_Professions;
import com.makarevich.dmitry.crock.room.Es_Transport;
import com.makarevich.dmitry.crock.room.MyAppDataBase;
import com.makarevich.dmitry.crock.room.Rus_Animal;
import com.makarevich.dmitry.crock.room.Rus_H;
import com.makarevich.dmitry.crock.room.Rus_M;
import com.makarevich.dmitry.crock.room.Rus_Planet;
import com.makarevich.dmitry.crock.room.Rus_Professions;
import com.makarevich.dmitry.crock.room.Rus_Transport;
import com.makarevich.dmitry.crock.room.Words;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class One_Normal extends AppCompatActivity {
    private ImageView imageView7, imageView8, imageView9, imageView20;
    private Button button3, button9;
    private TextView textView72, textView21, textView22, textView18, textView8, textView11, textView82, textView83;
    private RelativeLayout reel_back_norm;
    @SuppressLint("StaticFieldLeak")
    public static Context context_one_normal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one__normal);
        context_one_normal = getApplicationContext();
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView20 = findViewById(R.id.imageView20);
        textView72 = findViewById(R.id.textView72);
        textView21 = findViewById(R.id.textView21);
        textView22 = findViewById(R.id.textView22);
        textView18 = findViewById(R.id.textView18);
        textView82 = findViewById(R.id.textView82);
        textView8 = findViewById(R.id.textView8);
        reel_back_norm = findViewById(R.id.reel_back_norm);
        textView83 = findViewById(R.id.textView83);
        textView11 = findViewById(R.id.textView11);
        button3 = findViewById(R.id.button3);
        button9 = findViewById(R.id.button9);
        PushImage();
        Font();
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(One_Normal.this, Play_Mode.class);
                startActivity(back);
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayerOne();
                WordsOneNormal();
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayerTwo();
                WordsOneNormal();
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackCount();
            }
        });
    }

    private void BackCount() {
        button9.setVisibility(View.INVISIBLE);
        textView82.setVisibility(View.VISIBLE);
        textView83.setVisibility(View.VISIBLE);
        final CountDownTimer yourCountDownTimer = new CountDownTimer(6000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                textView82.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                textView82.setVisibility(View.INVISIBLE);
                textView83.setVisibility(View.INVISIBLE);
                reel_back_norm.setVisibility(View.INVISIBLE);
                WordsOneNormal();
                PlayerOne();
            }
        }.start();
    }

    public void Font() {
        textView8.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView11.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        button3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }

    public static Context getContexOneNormal() {
        return context_one_normal;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(One_Normal.this, Play_Mode.class);
        startActivity(back);
    }

    public void PushImage() {
        int second = R.drawable.ok;
        int third = R.drawable.player_one;
        int four = R.drawable.player_two;
        Glide
                .with(this)
                .load(second)
                .into(imageView9);
        Glide
                .with(this)
                .load(second)
                .into(imageView20);
        Glide
                .with(this)
                .load(third)
                .into(imageView7);
        Glide
                .with(this)
                .load(four)
                .into(imageView8);
    }

    private void PlayerOne() {
        textView72.setText(getString(R.string.player_one_g));
        imageView9.setVisibility(View.VISIBLE);
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView9.setVisibility(View.INVISIBLE);
                textView18.setText(" ");
                int score = Integer.parseInt(textView21.getText().toString()) + 1;
                textView21.setText(String.valueOf(score));
                textView72.setText(" ");
                WordsOneNormal();
                PlayerTwo();
            }
        });
    }

    private void PlayerTwo() {
        textView72.setText(getString(R.string.player_two_g));
        imageView20.setVisibility(View.VISIBLE);
        imageView20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView20.setVisibility(View.INVISIBLE);
                int score = Integer.parseInt(textView22.getText().toString()) + 1;
                textView22.setText(String.valueOf(score));
                textView72.setText(" ");
                textView18.setText(" ");
                WordsOneNormal();
                PlayerOne();
            }
        });
    }

    public void WordsOneNormal() {
        Context applicationContext = One_Normal.getContexOneNormal();
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");
        String play_game = sharedPreferences.getString("DICTIONARY_PLAY", "");
        Random rnd = new Random(System.currentTimeMillis());
        if (def_locale.contains("ru")) {
            if (play_game.contains("easy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Words> wordss = myAppDataBase.myinterface().getEasy_rus();
                for (Words wod : wordss) {
                    linkedList.add(wod.getEasy_rus());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("RU_EASY_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);

            }
            if (play_game.contains("medium")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Rus_M> wordss = myAppDataBase.myinterface().getMedium_rus();
                for (Rus_M rus_m : wordss) {
                    linkedList.add(rus_m.getMedium_rus());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("RU_MEDIUM_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("hard")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Rus_H> wordss = myAppDataBase.myinterface().getHard_rus();
                for (Rus_H rus_h : wordss) {
                    linkedList.add(rus_h.getHard_rus());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("RU_HARD_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("mixsy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Rus_H> wordss = myAppDataBase.myinterface().getHard_rus();
                for (Rus_H rus_h : wordss) {
                    linkedList.add(rus_h.getHard_rus());
                }
                int max_value = 700;
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("animal")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Rus_Animal> wordss = myAppDataBase.myinterface().getAnimal_rus();
                for (Rus_Animal rus_animal : wordss) {
                    linkedList.add(rus_animal.getAnimal_rus());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("RU_ANIMAL_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("planet")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Rus_Planet> wordss = myAppDataBase.myinterface().getPlanet_rus();
                for (Rus_Planet rus_planet : wordss) {
                    linkedList.add(rus_planet.getPlanet_rus());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("RU_PLANET_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("profession")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Rus_Professions> wordss = myAppDataBase.myinterface().getProfessions_rus();
                for (Rus_Professions rus_professions : wordss) {
                    linkedList.add(rus_professions.getProfessions_rus());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("RU_PROFESSIONS_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("transport")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Rus_Transport> wordss = myAppDataBase.myinterface().getTransport_rus();
                for (Rus_Transport rus_transport : wordss) {
                    linkedList.add(rus_transport.getTransport_rus());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("RU_TRANSPORT_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }

        }

        if (def_locale.contains("en")) {
            if (play_game.contains("easy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Easy> wordss = myAppDataBase.myinterface().getEasy_eng();
                for (Eng_Easy eng_easy : wordss) {
                    linkedList.add(eng_easy.getEasy_eng());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("EN_EASY_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);

            }
            if (play_game.contains("medium")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Medium> wordss = myAppDataBase.myinterface().getMedium_eng();
                for (Eng_Medium eng_medium : wordss) {
                    linkedList.add(eng_medium.getMedium_eng());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("EN_MEDIUM_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("hard")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Hard> wordss = myAppDataBase.myinterface().getHard_eng();
                for (Eng_Hard eng_hard : wordss) {
                    linkedList.add(eng_hard.getHard_eng());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("EN_HARD_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("mixsy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Hard> wordss = myAppDataBase.myinterface().getHard_eng();
                for (Eng_Hard eng_hard : wordss) {
                    linkedList.add(eng_hard.getHard_eng());
                }
                int max_value = 700;
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("animal")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Animal> wordss = myAppDataBase.myinterface().getAnimal_eng();
                for (Eng_Animal eng_animal : wordss) {
                    linkedList.add(eng_animal.getAnimal_eng());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("EN_ANIMAL_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("planet")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Planet> wordss = myAppDataBase.myinterface().getPlanet_eng();
                for (Eng_Planet eng_planet : wordss) {
                    linkedList.add(eng_planet.getPlanet_eng());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("EN_PLANET_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("profession")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Professions> wordss = myAppDataBase.myinterface().getProfessions_eng();
                for (Eng_Professions eng_professions : wordss) {
                    linkedList.add(eng_professions.getProfessions_eng());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("EN_PROFESSIONS_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("transport")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Transport> wordss = myAppDataBase.myinterface().getTransport_eng();
                for (Eng_Transport eng_transport : wordss) {
                    linkedList.add(eng_transport.getTransport_eng());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("EN_TRANSPORT_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }

        }
        if (def_locale.contains("de")) {
            if (play_game.contains("easy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Easy> wordss = myAppDataBase.myinterface().getDeutch_easy();
                for (De_Easy de_easy : wordss) {
                    linkedList.add(de_easy.getDeutch_easy());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("DE_EASY_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);

            }
            if (play_game.contains("medium")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Medium> wordss = myAppDataBase.myinterface().getDeutch_medium();
                for (De_Medium de_medium : wordss) {
                    linkedList.add(de_medium.getDeutch_medium());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("DE_MEDIUM_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("hard")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Hard> wordss = myAppDataBase.myinterface().getDeutch_hard();
                for (De_Hard de_hard : wordss) {
                    linkedList.add(de_hard.getDeutch_hard());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("DE_HARD_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("mixsy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Hard> wordss = myAppDataBase.myinterface().getDeutch_hard();
                for (De_Hard de_hard : wordss) {
                    linkedList.add(de_hard.getDeutch_hard());
                }
                int max_value = 700;
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("animal")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Animal> wordss = myAppDataBase.myinterface().getDeutch_animal();
                for (De_Animal de_animal : wordss) {
                    linkedList.add(de_animal.getDeutch_animal());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("DE_ANIMAL_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("planet")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Planet> wordss = myAppDataBase.myinterface().getDeutch_planet();
                for (De_Planet de_planet : wordss) {
                    linkedList.add(de_planet.getDeutch_planet());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("DE_PLANET_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("profession")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Professions> wordss = myAppDataBase.myinterface().getDeutch_professions();
                for (De_Professions de_professions : wordss) {
                    linkedList.add(de_professions.getDeutch_professions());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("DE_PROFESSIONS_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("transport")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Transport> wordss = myAppDataBase.myinterface().getDeutch_transport();
                for (De_Transport de_transport : wordss) {
                    linkedList.add(de_transport.getDeutch_transport());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("DE_TRANSPORT_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }

        }
        if (def_locale.contains("es")) {
            if (play_game.contains("easy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Easy> wordss = myAppDataBase.myinterface().getSpain_easy();
                for (Es_Easy es_easy : wordss) {
                    linkedList.add(es_easy.getSpain_easy());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("ES_EASY_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);

            }
            if (play_game.contains("medium")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Medium> wordss = myAppDataBase.myinterface().getSpain_medium();
                for (Es_Medium es_medium : wordss) {
                    linkedList.add(es_medium.getSpain_medium());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("ES_MEDIUM_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("hard")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Hard> wordss = myAppDataBase.myinterface().getHard_spain();
                for (Es_Hard es_hard : wordss) {
                    linkedList.add(es_hard.getHard_spain());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("ES_HARD_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("mixsy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Hard> wordss = myAppDataBase.myinterface().getHard_spain();
                for (Es_Hard es_hard : wordss) {
                    linkedList.add(es_hard.getHard_spain());
                }
                int max_value = 700;
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("animal")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Animal> wordss = myAppDataBase.myinterface().getAnimal_spain();
                for (Es_Animal es_animal : wordss) {
                    linkedList.add(es_animal.getAnimal_spain());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("ES_ANIMAL_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("planet")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Planet> wordss = myAppDataBase.myinterface().getPlanet_spain();
                for (Es_Planet es_planet : wordss) {
                    linkedList.add(es_planet.getPlanet_spain());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("ES_PLANET_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("profession")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Professions> wordss = myAppDataBase.myinterface().getProfesions_spain();
                for (Es_Professions es_professions : wordss) {
                    linkedList.add(es_professions.getProfesions_spain());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("ES_PROFESSIONS_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
            if (play_game.contains("transport")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Transport> wordss = myAppDataBase.myinterface().getTransport_spain();
                for (Es_Transport es_transport : wordss) {
                    linkedList.add(es_transport.getTransport_spain());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("ES_TRANSPORT_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                textView18.setText(string_ok);
            }
        }
    }
}
