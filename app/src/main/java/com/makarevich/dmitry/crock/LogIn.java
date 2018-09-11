package com.makarevich.dmitry.crock;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private ImageView img_Form, imageView36;
    private EditText et_MailR, et_PassR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        firebaseAuth = FirebaseAuth.getInstance();
        img_Form = findViewById(R.id.img_Form);
        imageView36 = findViewById(R.id.imageView36);
        Button btn_LogIn = findViewById(R.id.btn_LogIn);
        et_PassR = findViewById(R.id.et_PassR);
        et_MailR = findViewById(R.id.et_MailR);
        Button btn_Registration = findViewById(R.id.btn_Registration);
        Button btn_Registration2 = findViewById(R.id.btn_Registration2);
        btn_Registration2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(LogIn.this, MainMenu.class);
                startActivity(next);
            }
        });
        btn_Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LogIn();
            }
        });
        btn_LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(LogIn.this, Registration.class);
                startActivity(back);
            }
        });
        PushImage();
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(LogIn.this, Registration.class);
        startActivity(back);
    }

    public void PushImage() {
        int first = R.drawable.crocko_green;
        int second = R.drawable.login;
        Glide
                .with(this)
                .load(second)
                .into(img_Form);
        Glide
                .with(this)
                .load(first)
                .into(imageView36);
    }

    public LogIn() {
        try {

            String email = et_MailR.getText().toString().trim();
            String password = et_PassR.getText().toString().trim();
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, getString(R.string.please), Toast.LENGTH_SHORT).show();
            } else {
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(LogIn.this, getString(R.string.succes), Toast.LENGTH_SHORT).show();
                                    Intent next = new Intent(LogIn.this, MainMenu.class);
                                    startActivity(next);
                                }
                            }
                        });
            }
        } catch (Exception e) {
        }


    }
}
