package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registerpage extends AppCompatActivity {
    EditText Text;
    EditText etEmailAddress2;
    EditText etTextPassword2;
    EditText etTextPassword3;
    EditText etPhone;
    Button finish_reg_button;
    UserDetails registraition = new UserDetails();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerpage);
        finish_reg_button = findViewById(R.id.finish_reg_button);
        etPhone = findViewById(R.id.etPhone);
        etEmailAddress2 = findViewById(R.id.etEmailAddress2);
        etTextPassword2 = findViewById(R.id.etTextPassword2);
        etTextPassword3 = findViewById(R.id.etTextPassword3);
        Text = findViewById(R.id.Text);
        finish_reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable et = etEmailAddress2.getText();
                String email = etEmailAddress2.getText().toString();
                String password = etTextPassword2.getText().toString();
                String password2 = etTextPassword3.getText().toString();
                String name = Text.getText().toString();
                String phone = etPhone.getText().toString();
                registraition.setName(Text.getText().toString());
                registraition.setEmail(etEmailAddress2.getText().toString());
                registraition.setPassword(etTextPassword2.getText().toString());
                registraition.setPassword2(etTextPassword3.getText().toString());
                registraition.setPhone(etPhone.getText().toString());
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.firstmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int iid = item.getItemId();
        if (iid == R.id.ret_to_front){
            Intent intent = new Intent(Registerpage.this,Frontpage.class);
            startActivity(intent);
            return true;}
        if (iid == R.id.close_app){
            finishAffinity();
        }
        return super.onOptionsItemSelected(item);
    }
}
