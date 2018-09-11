package com.makarevich.dmitry.crock;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainStore extends AppCompatActivity {
    private ImageView imageView3, imageView4, imageView5, img_Play, img_Book, img_Settings, img_Buy;
    private TextView text_User, text_User2, text_User3, textView5, textView555, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_store);
        text_User = findViewById(R.id.text_User);
        text_User2 = findViewById(R.id.text_User2);
        text_User3 = findViewById(R.id.text_User3);
        textView5 = findViewById(R.id.textView5);
        textView555 = findViewById(R.id.textView555);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        img_Play = findViewById(R.id.img_Play);
        img_Book = findViewById(R.id.img_Book);
        img_Settings = findViewById(R.id.img_Settings);
        img_Buy = findViewById(R.id.img_Buy);
        RelativeLayout one = findViewById(R.id.one);
        RelativeLayout two = findViewById(R.id.two);
        RelativeLayout fit = findViewById(R.id.fit);
        RelativeLayout fitsn = findViewById(R.id.fitsn);
        PushPic();
        Font();
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent one = new Intent(MainStore.this, Store.class);
                startActivity(one);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent two = new Intent(MainStore.this, EarnCoins.class);
                startActivity(two);
            }
        });
        fit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fit = new Intent(MainStore.this, BuyCoinForCash.class);
                startActivity(fit);
            }
        });
        fitsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainStore.this, getString(R.string.are_you_buy_game), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(MainStore.this, MainMenu.class);
        startActivity(back);
    }

    private void PushPic() {

        int first = R.drawable.crocko_green;
        int second = R.drawable.alphabet;
        int third = R.drawable.watch;
        int four = R.drawable.coin_wallet;
        int five = R.drawable.buy;

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
                .into(img_Settings);
        Glide
                .with(this)
                .load(five)
                .into(img_Buy);

    }

    public void Font() {
        text_User.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        text_User2.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        text_User3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView5.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView555.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView2.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }

}
