package com.makarevich.dmitry.crock;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class RulesOneToOne extends AppCompatActivity {
    private Button button3;
    private TextView textView8,textView11,textView12;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules__one_to_one);
        button3 = findViewById(R.id.button3);
        textView8=findViewById(R.id.textView8);
        textView11=findViewById(R.id.textView11);
        textView12=findViewById(R.id.textView12);
        imageView = findViewById(R.id.imageView);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dictionary = new Intent(RulesOneToOne.this, DictionaryAll.class);
                startActivity(dictionary);
            }
        });
        PushImage();
        Font();
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(RulesOneToOne.this, Play_Mode.class);
        startActivity(back);
    }

    public void PushImage() {
        int first = R.drawable.rules;
        Glide
                .with(this)
                .load(first)
                .into(imageView);
    }
    public void Font() {
        textView8.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView11.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView12.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        button3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }
}
