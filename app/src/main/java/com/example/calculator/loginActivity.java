package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    EditText varusername , varpassword;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            varusername = findViewById(R.id.uname);
            varpassword = findViewById(R.id.pass);
            btnlogin = findViewById(R.id.btnlogin);
            SharedPreferences objsharedpreferences = getApplicationContext().getSharedPreferences("dataauth",MODE_PRIVATE);
            SharedPreferences.Editor objeditor = objsharedpreferences.edit();
            objeditor.putString("setusername" , "ariz");
            objeditor.putString("setpassword", "admin");
            objeditor.commit();



            SharedPreferences objShared = getSharedPreferences("dataauth", Context.MODE_PRIVATE);
            String objuname = objShared.getString("setusername" ,null);
            String objpass = objShared.getString("setpassword" ,null);

            btnlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        if (varusername.getText().toString().equals(objuname) && varpassword.getText().toString().equals(objpass)) {
                            Intent intent = new Intent(loginActivity.this,MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(),"Auth Error", Toast.LENGTH_SHORT).show();
                        }

                }
            });

        }
}