package com.example.himanshu.bmicalcutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class bmiresult extends AppCompatActivity {

    TextView tvResult;

    Button btnShare,btnBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);

        btnBack=findViewById(R.id.btnBack);
        btnShare=findViewById(R.id.btnShare);


        Intent i=getIntent();
        double weight= Double.parseDouble(i.getStringExtra("weight"));
        double feet= Double.parseDouble(i.getStringExtra("feet"));
        double inch= Double.parseDouble(i.getStringExtra("inch"));

        while(feet>0)
        {inch+=12;
        feet--;}
        double height;
        height=inch*2.54;
        double bmi=weight/(height*height);
        bmi=bmi*1000;
        String msg=null;
        if(bmi<18.5)
            msg="you are underage";
        if(bmi>18.5&&bmi<25)
            msg="you are normal";
        if(bmi>=25&&bmi<30)
            msg="you are overweight";
        if(bmi>30)
            msg="you";

        tvResult.setText("bmi"+bmi+""+msg);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        final String messsage="your Bmi is"+bmi+""+msg;
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,messsage);
                startActivity(i);


            }
        });

    }
}
