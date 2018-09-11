package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.firebase.auth.FirebaseAuth;

public class MainMenu extends AppCompatActivity implements RewardedVideoAdListener {
    private ImageView imageView3, imageView4, imageView5, img_Play, img_Book, img_Settings;
    private ImageView img_exit, img_share;
    private FirebaseAuth firebaseAuth;
    private TextView text_User, textView2, textView3, textView5, text_User2, text_User3, textView75;
    private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/5224354917";
    private static final String APP_ID = "ca-app-pub-3940256099942544~3347511713";
    private RewardedVideoAd rewardedVideoAd;
    @SuppressLint("StaticFieldLeak")
    public static Context context_main_menu;
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        dataBase = new DataBase(this);
        context_main_menu = getApplicationContext();
        text_User = findViewById(R.id.text_User);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView5);
        textView75 = findViewById(R.id.textView75);
        text_User2 = findViewById(R.id.text_User2);
        text_User3 = findViewById(R.id.text_User3);
        firebaseAuth = FirebaseAuth.getInstance();
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        img_Play = findViewById(R.id.img_Play);
        img_Book = findViewById(R.id.img_Book);
        img_Settings = findViewById(R.id.img_Settings);
        img_exit = findViewById(R.id.img_exit);
        img_share = findViewById(R.id.img_share);
        RelativeLayout one = findViewById(R.id.one);
        RelativeLayout two = findViewById(R.id.two);
        RelativeLayout fit = findViewById(R.id.fit);
        PushPic();
        Font();
        GetCoins();
        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(this);
        MobileAds.initialize(this, APP_ID);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //android.os.Process.killProcess(android.os.Process.myPid());
                //finishAffinity();
                Intent play_mode = new Intent(MainMenu.this, Play_Mode.class);
                startActivity(play_mode);

            }
        });
        fit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(MainMenu.this, Settings.class);
                startActivity(next);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent store = new Intent(MainMenu.this, MainStore.class);
                startActivity(store);
            }
        });
        img_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExitAcc();
            }
        });
        img_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareIt();
            }
        });
        loadRewardedVideoAd();
        SharedPref.MainMenuSetNone();
    }

    public static Context getContextMainMenu() {
        return context_main_menu;
    }

    private void loadRewardedVideoAd() {
        if (!rewardedVideoAd.isLoaded()) {
            rewardedVideoAd.loadAd(AD_UNIT_ID, new AdRequest.Builder().build());
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, getString(R.string.pereh_naz), Toast.LENGTH_SHORT).show();
    }

    private void PushPic() {

        int first = R.drawable.crocko_green;
        int second = R.drawable.joystick;
        int four = R.drawable.dollar;
        int five = R.drawable.settings;
        int six = R.drawable.exit;
        int seven = R.drawable.share;

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
                .load(four)
                .into(img_Book);
        Glide
                .with(this)
                .load(five)
                .into(img_Settings);
        Glide
                .with(this)
                .load(six)
                .into(img_exit);
        Glide
                .with(this)
                .load(seven)
                .into(img_share);
    }

    public void Font() {
        text_User.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView2.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        textView5.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        text_User2.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        text_User3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }

    private void ExitAcc() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                MainMenu.this);
        Resources res = getResources();
        String one = res.getString(R.string.exit);
        String two = res.getString(R.string.yes);
        String three = res.getString(R.string.noo);

        quitDialog.setTitle(one);

        quitDialog.setPositiveButton(two, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        firebaseAuth.signOut();
                        finish();
                        Intent exit = new Intent(MainMenu.this, LogIn.class);
                        startActivity(exit);

                    }
                }
        );

        quitDialog.setNegativeButton(three, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), R.string.continu, Toast.LENGTH_SHORT).show();

            }
        });

        quitDialog.show();
    }

    private void ShareIt() {
        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String textToSend = getString(R.string.sha_ref);
        intent.putExtra(Intent.EXTRA_TEXT, textToSend);
        try {
            startActivity(Intent.createChooser(intent, getString(R.string.crocodile)));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("SetTextI18n")
    public void GetCoins() {
        String test = SharedPref.GetMainMenuCoins();
        textView75.setText(test + " " + getString(R.string.coinss));
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
        loadRewardedVideoAd();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        Toast.makeText(this, "Теперь вам доступен Экстра Уровень", Toast.LENGTH_LONG).show();
        Intent ekstra = new Intent(MainMenu.this, DictionaryEkstra.class);
        startActivity(ekstra);
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

}
