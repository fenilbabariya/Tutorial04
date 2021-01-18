package com.rku_18fotca11002.tutorial04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText textView,edtUsername,edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin =findViewById(R.id.btnLogin);
        edtUsername = findViewById(R.id.txtuname);
        edtPassword =   findViewById(R.id.txtPsw);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName = edtUsername.getText().toString();
                String psw = edtPassword.getText().toString();

                if(uName.equals("")) {
                    Toast.makeText(MainActivity.this, "Username can not be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(psw.equals("")) {
                    Toast.makeText(MainActivity.this, "Password can not be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(psw.length() < 6){
                    Toast.makeText(MainActivity.this, "Password must not be less than 6 character", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(uName).matches()){
                    Toast.makeText(MainActivity.this, "Username must be proper Email Address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(uName.equals("admin@gmail.com") && psw.equals("123456")){
                    Intent intent = new Intent(MainActivity.this,NextActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(MainActivity.this, "Login Denied", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}