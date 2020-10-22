package com.infocube.expense.ui.splash_screen;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.infocube.expense.R;
import com.infocube.expense.ui.main.MainActivity;
import com.infocube.expense.ui.signin.SignInActivity;

public class SplashActivity extends AppCompatActivity {

    private TextView textview;
    private ImageView imageview;
    private FirebaseAuth mAuth;
    private View v1, v2, v3, v4, v5;
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_disp);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

        }

        textview = (TextView) findViewById(R.id.textview);
        imageview = (ImageView) findViewById(R.id.imageview);
        Animation ani = AnimationUtils.loadAnimation(this, R.anim.myanima);
        textview.startAnimation(ani);
        imageview.startAnimation(ani);

        final Intent in = new Intent(SplashActivity.this, SignInActivity.class);
        v1 = (View) findViewById(R.id.v1);
        v2 = (View) findViewById(R.id.v2);
        v3 = (View) findViewById(R.id.v3);
        v4 = (View) findViewById(R.id.v4);
        v5 = (View) findViewById(R.id.v5);

        v1.setVisibility(View.INVISIBLE);
        v2.setVisibility(View.INVISIBLE);
        v3.setVisibility(View.INVISIBLE);
        v4.setVisibility(View.INVISIBLE);
        v5.setVisibility(View.INVISIBLE);
        i = 0;
        CountDownTimer ct = new CountDownTimer(3300, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                switch (i) {
                    case 0:
                        v2.setVisibility(View.INVISIBLE);
                        v3.setVisibility(View.INVISIBLE);
                        v4.setVisibility(View.INVISIBLE);
                        v5.setVisibility(View.INVISIBLE);

                        v1.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        v2.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        v3.setVisibility(View.VISIBLE);

                        break;
                    case 3:
                        v4.setVisibility(View.VISIBLE);

                        break;
                    case 4:
                        v5.setVisibility(View.VISIBLE);
                        break;


                }
                i = (i + 1) % 6;
            }

            @Override
            public void onFinish() {
                startActivity(in);
                finish();
            }
        };
        ct.start();


    }
}
