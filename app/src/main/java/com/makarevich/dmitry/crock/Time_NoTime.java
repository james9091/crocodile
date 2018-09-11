package com.makarevich.dmitry.crock;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Time_NoTime extends AppCompatActivity {
    private ImageView imageView2, imageView6;
    private TextView textView8, textView11, textView14, textView, textView13, textView79, textView80;
    private Button button3, button7, button8;
    private RelativeLayout reel_white, reel_timer;
    public static Context contextTimeNoTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time__no_time);
        contextTimeNoTime = getApplicationContext();
        button3 = findViewById(R.id.button3);
        imageView2 = findViewById(R.id.imageView2);
        imageView6 = findViewById(R.id.imageView6);
        textView8 = findViewById(R.id.textView8);
        textView11 = findViewById(R.id.textView11);
        textView14 = findViewById(R.id.textView14);
        textView = findViewById(R.id.textView);
        textView80 = findViewById(R.id.textView80);
        textView13 = findViewById(R.id.textView13);
        textView79 = findViewById(R.id.textView79);
        button8 = findViewById(R.id.button8);
        button7 = findViewById(R.id.button7);
        reel_white = findViewById(R.id.reel_white);
        reel_timer = findViewById(R.id.reel_timer);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent back = new Intent(Time_NoTime.this, Dictionary_Level.class);
                //startActivity(back);
                NextP();
            }
        });
        PushImage();
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Intent time = new Intent(Time_NoTime.this, One_Time.class);
                //  startActivity(time);
                StartTime();
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent no_time = new Intent(Time_NoTime.this, One_Normal.class);
                // startActivity(no_time);
                StartNoTime();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MinusTenSec();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlusTenSec();
            }
        });
        Font();
    }

    public static Context getContextTimeNoTime() {
        return contextTimeNoTime;
    }

    private void Font() {
        textView8.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView11.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView13.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView14.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        button3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        button7.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        button8.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView79.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(Time_NoTime.this, Play_Mode.class);
        startActivity(back);
    }

    public void PushImage() {
        int second = R.drawable.time;
        int third = R.drawable.no_time;

        Glide
                .with(this)
                .load(second)
                .into(imageView2);
        Glide
                .with(this)
                .load(third)
                .into(imageView6);

    }

    private void StartTime() {
        textView13.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setTextColor(Color.parseColor("#8CCB5E"));
        reel_white.setVisibility(View.VISIBLE);
        reel_timer.setVisibility(View.VISIBLE);
        SharedPref.LastSetTime();
    }

    private void StartNoTime() {
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView13.setTextColor(Color.parseColor("#8CCB5E"));
        reel_white.setVisibility(View.INVISIBLE);
        reel_timer.setVisibility(View.INVISIBLE);
        SharedPref.LastSetNoTime();
    }

    private void MinusTenSec() {
        int timer = Integer.parseInt(textView80.getText().toString());
        if (timer > 20) {
            int ok = timer - 10;
            textView80.setText(String.valueOf(ok));
        } else {
            Toast.makeText(contextTimeNoTime, "Длительность раунда не может быть менее 20 секунд", Toast.LENGTH_SHORT).show();
        }
    }

    private void PlusTenSec() {
        int timer = Integer.parseInt(textView80.getText().toString());
        if (timer == 200) {
            Toast.makeText(contextTimeNoTime, "Данная игра не предусматривает такие длинные раунды", Toast.LENGTH_SHORT).show();
        } else {
            int ok = timer + 10;
            textView80.setText(String.valueOf(ok));
        }
    }

    private void NextP() {
        String proof = SharedPref.ReturnLastSet();
        if (proof.contains("none")) {
            Toast.makeText(contextTimeNoTime, "Выберите режим игры в котором вы хотите играть", Toast.LENGTH_SHORT).show();
        } else {
            String time = textView80.getText().toString();
            Context applicationContext = Time_NoTime.getContextTimeNoTime();
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("ROUND_TIME", time);
            edit.apply();
            edit.commit();
            if (proof.contains("time")) {
                Intent time_next = new Intent(Time_NoTime.this, One_Time.class);
                startActivity(time_next);
            }
            if (proof.contains("no")) {
                Intent time_next = new Intent(Time_NoTime.this, One_Normal.class);
                startActivity(time_next);
            }
        }
    }


}
