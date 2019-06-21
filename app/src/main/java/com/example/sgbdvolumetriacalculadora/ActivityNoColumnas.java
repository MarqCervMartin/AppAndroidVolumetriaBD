package com.example.sgbdvolumetriacalculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityNoColumnas extends AppCompatActivity {
    private String notablas;
    private EditText columnas;
    private Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_columnas);
        Bundle extras = getIntent().getExtras();
        notablas = extras.getString("NTablas") ;
        columnas = (EditText) findViewById(R.id.ETC);
        btn2 = (Button) findViewById(R.id.btnACols);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intetablas = new Intent(ActivityNoColumnas.this, ActivityTabla.class);
                intetablas.putExtra("NTablas",notablas);
                intetablas.putExtra("NColumnas",columnas.getText().toString());

                startActivity(intetablas);
            }
        });


    }
}
