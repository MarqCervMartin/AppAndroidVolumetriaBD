package com.example.sgbdvolumetriacalculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoTablas extends AppCompatActivity {
    private EditText numTablas;
    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_tablas);

        numTablas = (EditText) findViewById(R.id.ETNT);
        btn1 = (Button) findViewById(R.id.btnAceptar);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inteNumcolum = new Intent(NoTablas.this, ActivityNoColumnas.class);
                inteNumcolum.putExtra("NTablas",numTablas.getText().toString());

                startActivity(inteNumcolum);

            }
        });
    }
}
