package com.example.sgbdvolumetriacalculadora;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class Splash_Activity extends AppCompatActivity {

    private final int Duracion_splash = 4000;
    private TextView t1,t2,t3;
    private Typeface Sans_Serif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(Splash_Activity.this, NoTablas.class);
                startActivity(intent);
                finish();
            };
        }, Duracion_splash);
        t1 = (TextView) findViewById(R.id.TV1);
        t2 = (TextView) findViewById(R.id.TV2);
        t3 = (TextView) findViewById(R.id.textView);

        String fuente = "fuentes/sansSerif.ttf";
        this.Sans_Serif = Typeface.createFromAsset(getAssets(),fuente);
        //t1 = (TextView) findViewById(R.id.TV1);
        t1.setTypeface(Sans_Serif);
        t2.setTypeface(Sans_Serif);
        t3.setTypeface(Sans_Serif);

    }
}
