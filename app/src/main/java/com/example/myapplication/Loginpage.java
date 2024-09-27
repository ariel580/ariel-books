package com.example.myapplication;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Loginpage extends AppCompatActivity {
    Button finish_log_button;
    Button go_to_reg_button;
    TextView tvCdt;
    EditText etEmail,etPassword;
    UserDetails login = new UserDetails();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
       finish_log_button = findViewById(R.id.finish_log_button);
        go_to_reg_button = findViewById(R.id.go_to_reg_button);
        tvCdt = findViewById(R.id.tvCdt);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        finish_log_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable et = etEmail.getText();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                login.setEmail(etEmail.getText().toString());
                login.setPassword(etPassword.getText().toString());
                AlertDialog dialog = createdialog();
                dialog.show();
            }
        });
       go_to_reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Loginpage.this, Registerpage.class);
                startActivity(intent);
            }
        });
    }
    AlertDialog createdialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("would you like to proceed?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Loginpage.this, "you  will proceed shortly", Toast.LENGTH_SHORT).show();
                CountDownTimer countDownTimer = new CountDownTimer(5000 + 100,1000) {
                    @Override
                    public void onTick(long l) {
                        Log.i( TAG, "onTick: Seconds until finished" + l/1000);
                        String stCountdown = l/1000 + "";
                        tvCdt.setText("Start in:" + stCountdown+ "seconds");

                    }

                    @Override
                    public void onFinish() {
                        Intent intent = new Intent(Loginpage.this, Frontpage.class);
                        startActivity(intent);
                    }
                };
                countDownTimer.start();
            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Loginpage.this, "you  will return shortly", Toast.LENGTH_SHORT).show();
                CountDownTimer countDownTimer = new CountDownTimer(5000 + 100,1000) {
                    @Override
                    public void onTick(long l) {
                        Log.i( TAG, "onTick: Seconds until finished" + l/1000);
                        String stCountdown = l/1000 + "";
                        tvCdt.setText("Start in:" + stCountdown+ "seconds");
                    }

                    @Override
                    public void onFinish() {
                        Intent intent = new Intent(Loginpage.this, Frontpage.class);
                        startActivity(intent);
                    }
                };
                countDownTimer.start();
            }
        });
    return builder.create();}


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.ret_to_front){
            Intent intent = new Intent(Loginpage.this,Frontpage.class);
            startActivity(intent);
            return true;}
        if (id == R.id.close_app)
            finishAffinity();
        return super.onOptionsItemSelected(item);
    }
}