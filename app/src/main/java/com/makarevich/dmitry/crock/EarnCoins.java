package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class EarnCoins extends AppCompatActivity implements RewardedVideoAdListener {
    private ImageView imageView26, imageView33, imageView37;
    private TextView textView59, textView60, textView61, textView58, textView48, textView57, textView62;
    @SuppressLint("StaticFieldLeak")
    public static Context context_earn_coins;
    private static final String AD_UNIT_ID = "ca-app-pub-1771512599501543/8702164834";
    private static final String APP_ID = "ca-app-pub-1771512599501543~5943428142";
    private RewardedVideoAd rewardedVideoAd;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earn__coins);
        context_earn_coins = getApplicationContext();
        textView62 = findViewById(R.id.textView62);
        textView59 = findViewById(R.id.textView59);
        textView60 = findViewById(R.id.textView60);
        textView61 = findViewById(R.id.textView61);
        textView58 = findViewById(R.id.textView58);
        textView48 = findViewById(R.id.textView48);
        textView57 = findViewById(R.id.textView57);
        imageView26 = findViewById(R.id.imageView26);
        imageView33 = findViewById(R.id.imageView33);
        imageView37 = findViewById(R.id.imageView37);
        PushPic();
        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(this);
        MobileAds.initialize(this, APP_ID);
        imageView33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startVideoAd();
            }
        });
        loadRewardedVideoAd();
        Font();
        String test = SharedPref.getCoin();
        textView62.setText(test + " " + getString(R.string.coinss));
    }

    public void startVideoAd() {
        if (rewardedVideoAd.isLoaded()) {
            rewardedVideoAd.show();
            Toast.makeText(this, getString(R.string.starting_watching), Toast.LENGTH_SHORT).show();
        }
    }

    private void loadRewardedVideoAd() {
        if (!rewardedVideoAd.isLoaded()) {
            rewardedVideoAd.loadAd(AD_UNIT_ID, new AdRequest.Builder().build());
        }
    }

    public static Context getContexEarnCoins() {
        return context_earn_coins;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(EarnCoins.this, MainMenu.class);
        startActivity(back);
    }

    private void PushPic() {

        int first = R.drawable.watch;
        int second = R.drawable.play_p;
        int third = R.drawable.coins;

        Glide
                .with(this)
                .load(first)
                .into(imageView26);
        Glide
                .with(this)
                .load(second)
                .into(imageView33);
        Glide
                .with(this)
                .load(third)
                .into(imageView37);

    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }


    @Override
    public void onRewardedVideoAdClosed() {

        Toast.makeText(context_earn_coins, getString(R.string.ok), Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onRewarded(RewardItem rewardItem) {
        SharedPref.Coins();
        String test = SharedPref.getCoin();
        Toast.makeText(context_earn_coins, getString(R.string.you_earned_coins), Toast.LENGTH_SHORT).show();
        textView62.setText(test + " " + getString(R.string.coinss));
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    public void Font() {
        textView59.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView60.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView61.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView62.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView58.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView57.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView48.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));

    }
}
