package com.example.himanshu.bmicalcutor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText etName,etSurname;
Button btnSubmit;
 SharedPreferences sp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.etName);
        etSurname=findViewById(R.id.etsurname);
        btnSubmit=findViewById(R.id.btnSubmit);
        sp1=getSharedPreferences("user data",MODE_PRIVATE);



        if(sp1.getBoolean("ret",false==false)) {

            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = etName.getText().toString();
                    String surname = etSurname.getText().toString();


                    SharedPreferences.Editor editor = sp1.edit();
                    editor.putString("name", name);
                    editor.putString("surname", surname);
                    editor.commit();
                    editor.putBoolean("ret", true);
                    Intent i = new Intent(getApplicationContext(), bmidata.class);
                    startActivity(i);
                    finish();


                }
            });
        }
                else

                {Intent i= new Intent(getApplicationContext(),bmidata.class);
                    startActivity(i);
                    finish();
                }




        


    }
}
