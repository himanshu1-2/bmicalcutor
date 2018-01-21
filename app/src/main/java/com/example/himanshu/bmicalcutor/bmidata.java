package com.example.himanshu.bmicalcutor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class bmidata extends AppCompatActivity {
TextView tvWelcome;
Spinner spFeet,spInch;
EditText etWeight;
    Button btnCalculate;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmidata);

        tvWelcome=findViewById(R.id.tvWelcome);
        btnCalculate=findViewById(R.id.btnCalculate);
        spFeet=findViewById(R.id.spFeet);
        spInch=findViewById(R.id.spInch);
        etWeight=findViewById(R.id.etWeight);
        sp=getSharedPreferences("userdata",MODE_PRIVATE);
        String name=sp.getString("name",null);
        String surname=sp.getString("surname","");
        tvWelcome.setText("welcome"+name);
        String [] feet={"1","2","3","4","5","6","7"};
        ArrayAdapter adapter=new ArrayAdapter(this ,android.R.layout.simple_spinner_item,feet);
        spFeet.setAdapter(adapter);


          String []inch= {"1","2","3","4","5","6","7","8","9","10","11"};
        ArrayAdapter adapter1=new ArrayAdapter(this ,android.R.layout.simple_spinner_item,inch);
        spInch.setAdapter(adapter);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String weight=etWeight.getText().toString();
                String feet=spFeet.getSelectedItem().toString();
                String inch=spInch.getSelectedItem().toString();

                Intent i= new Intent(getApplicationContext(),bmiresult.class);
                i.putExtra("weight",weight);
                i.putExtra("feet",feet);
                i.putExtra("inch",inch);
                startActivity(i);

            }






        });



    }
}
