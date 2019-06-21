package com.example.sgbdvolumetriacalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //variable
    private Button btnCalcular;
    private EditText a,b,c,d,e;
    private TextView resultado;
    int num_rows, num_cols, fixed_data_size, num_variable_cols, max_var_size;


    public int getNum_rows() {
        return num_rows;
    }

    public void setNum_rows(int num_rows) {
        this.num_rows = num_rows;
    }

    public int getNum_cols() {
        return num_cols;
    }

    public void setNum_cols(int num_cols) {
        this.num_cols = num_cols;
    }

    public int getFixed_data_size() {
        return fixed_data_size;
    }

    public void setFixed_data_size(int fixed_data_size) {
        this.fixed_data_size = fixed_data_size;
    }

    public int getNum_variable_cols() {
        return num_variable_cols;
    }

    public void setNum_variable_cols(int num_variable_cols) {
        this.num_variable_cols = num_variable_cols;
    }

    public int getMax_var_size() {
        return max_var_size;
    }

    public void setMax_var_size(int max_var_size) {
        this.max_var_size = max_var_size;
    }

    private static final String DEBUG_TAG = "AppCompatActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = (EditText) findViewById(R.id.ETROWS);
        b = (EditText) findViewById(R.id.ETCOLS);
        c = (EditText) findViewById(R.id.ETTCLF);
        d = (EditText) findViewById(R.id.ETCLV);
        e = (EditText) findViewById(R.id.ETTCLV);
        resultado = (TextView) findViewById(R.id.TVR);
        btnCalcular = (Button) findViewById(R.id.BTNC);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Verificar();
            }
        });

    }

    public void Verificar(){

        if(a.getText().toString().isEmpty() || b.getText().toString().isEmpty() || c.getText().toString().isEmpty() ||
                d.getText().toString().isEmpty() ||e.getText().toString().isEmpty()){
            Toast.makeText(this,"Revise los campos", Toast.LENGTH_SHORT).show();
        }else{
            Calcular();
        }

    }
    public void Calcular(){
        setNum_rows(Integer.parseInt(a.getText().toString()));
        setNum_cols(Integer.parseInt(b.getText().toString()));
        setFixed_data_size(Integer.parseInt(c.getText().toString()));
        setNum_variable_cols(Integer.parseInt(d.getText().toString()));
        setMax_var_size(Integer.parseInt(e.getText().toString()));
        //Calculo del paso 3 Nullbitmap
        double null_bitmap = 2+((getNum_cols()+7)/8);
        int null_bitmap_entero = (int) Math.floor(null_bitmap);
        //Calculo del paso 4  variable data size
        int variable_data_size;
        if(getNum_variable_cols() == 0){
            variable_data_size = 0;
        }else{
            variable_data_size = 2+(getNum_variable_cols()*2)+getMax_var_size();
        }
        //Calculo del paso 5 row size
        int row_size = getFixed_data_size() + variable_data_size + null_bitmap_entero + 4;
        //Calculo del paso 6 rows per page
        double rows_per_page = 8096/(row_size+2);
        int rows_per_pages_entero = (int) Math.floor(rows_per_page);
        //Calculo del paso 7 num pages
        double num_pages = (double) (getNum_rows())/(rows_per_pages_entero);
        int num_pages_entero = (int) Math.ceil(num_pages);
        //calculo del paso 8 tamaño del monton
        int tamanio_del_monton = 8192*num_pages_entero;
        //Impresion en la caja de texto
        resultado.setText(String.valueOf(tamanio_del_monton)+" Bytes");
    }

}
