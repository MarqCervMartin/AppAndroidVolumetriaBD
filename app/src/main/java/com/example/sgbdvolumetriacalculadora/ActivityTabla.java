package com.example.sgbdvolumetriacalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityTabla extends AppCompatActivity {
    private String nTablas,nColumnas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla);
        Bundle extras = getIntent().getExtras();
        nTablas = extras.getString("NTablas") ;
        nColumnas = extras.getString("NColumnas") ;


    }
}
