package com.petit.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.petit.NavActivityTEST;
import com.petit.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText Name;
    private EditText Password;
    private Button LoginButton;
    private String ErrorePassword = "Password o Username errati";
    private TextView textView;
    private TextView registrati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petit_login);

        Name = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        LoginButton = (Button) findViewById(R.id.button_login);
        textView = (TextView) findViewById(R.id.string);
        registrati = findViewById(R.id.registrati_link);

        registrati.setOnClickListener(this);
        LoginButton.setOnClickListener(this);

    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("")) && (userPassword.equals(""))) {
            Intent intent = new Intent(LoginActivity.this, NavActivityTEST.class);
            startActivity(intent);
        } else {
            textView.setText(ErrorePassword);
        }
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_login:
                validate(Name.getText().toString(), Password.getText().toString());
                break;
            case R.id.registrati_link:
                Intent intent = new Intent(LoginActivity.this, RegistrazioneActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
