package com.handi.expensetracker;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity {
    @BindView(R.id.txtUserName) EditText txtUserName;
    @BindView(R.id.txtPassword) EditText txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    public void btnLoginClick(View view)
    {
        if(txtPass.getText().toString().equals("Admin") && txtUserName.getText().toString().equals("Admin"))
        {
            Intent myIntent = new Intent(Login.this,
                    MainActivity.class);
            startActivity(myIntent);
        }
        else
        {
            new AlertDialog.Builder(Login.this).setMessage("Id atau Password Salah").setCancelable(true).show();
        }

    }

    public void btnRegisterClick(View view)
    {
        Intent myIntent = new Intent(Login.this,
                Register.class);
        startActivity(myIntent);
    }
}
