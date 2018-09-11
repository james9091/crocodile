package com.makarevich.dmitry.crock;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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

public class Registration extends AppCompatActivity {
    private ImageView img_Form, imageView35;
    private EditText et_MailR, et_PassR;
    private FirebaseAuth firebaseAuth;
    public static Context contextOfApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        contextOfApplication = getApplicationContext();
        firebaseAuth = FirebaseAuth.getInstance();
        et_MailR = findViewById(R.id.et_MailR);
        et_PassR = findViewById(R.id.et_PassR);
        img_Form = findViewById(R.id.img_Form);
        imageView35 = findViewById(R.id.imageView35);
        Button btn_LogIn = findViewById(R.id.btn_LogIn);
        Button btn_Registration = findViewById(R.id.btn_Registration);
        Button btn_Registration3 = findViewById(R.id.btn_Registration3);
        PushImage();
        btn_Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase_registration();
                String test = SharedPref.ReturnMainProof();
                if (test.contains("yes")) {
                    Intent next = new Intent(Registration.this, MainMenu.class);
                    startActivity(next);
                } else {
                    SharedPref.MainProof();
                    SharedPref.getDefaultSharedPreferences();
                    Intent next = new Intent(Registration.this, MainMenu.class);
                    startActivity(next);
                }
            }
        });
        btn_Registration3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Registration.this);
                builder.setTitle("Предупреждение")
                        .setMessage("Если вы пропустите регистрацию, то ваши рекорды и накопленные монеты не будут сохраняться")
                        .setIcon(R.drawable.crocko_green)
                        .setCancelable(false)
                        .setPositiveButton(getString(R.string.skip_m),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        String test = SharedPref.ReturnMainProof();
                                        if (test.contains("yes")) {
                                            Intent next = new Intent(Registration.this, LogIn.class);
                                            startActivity(next);
                                        } else {
                                            SharedPref.MainProof();
                                            SharedPref.getDefaultSharedPreferences();
                                            Intent next = new Intent(Registration.this, MainMenu.class);
                                            startActivity(next);
                                        }
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
        img_Form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(Registration.this, MainMenu.class);
                startActivity(next);
            }
        });
        btn_LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(Registration.this, LogIn.class);
                startActivity(login);

            }
        });


    }

    public static Context getContextOfApplication() {
        return contextOfApplication;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, getString(R.string.pereh_naz), Toast.LENGTH_SHORT).show();
    }

    public void Firebase_registration() {
        try {
            String email = et_MailR.getText().toString();
            String password = et_PassR.getText().toString();
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Registration.this, getString(R.string.reg_succ), Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Registration.this, getString(R.string.reg_bad), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } catch (Exception e) {
            Toast.makeText(contextOfApplication, getString(R.string.something_error), Toast.LENGTH_SHORT).show();
        }
    }


    public void PushImage() {
        int first = R.drawable.crocko_green;
        int second = R.drawable.registratuion;
        Glide
                .with(this)
                .load(second)
                .into(img_Form);
        Glide
                .with(this)
                .load(first)
                .into(imageView35);

    }

}
