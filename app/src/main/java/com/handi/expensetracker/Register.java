package com.handi.expensetracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Register extends AppCompatActivity {
    @BindView(R.id.txtUserName)
    EditText txtUserName;
    @BindView(R.id.txtNama) EditText txtNama;
    @BindView(R.id.txtEmail) EditText txtEmail;
    @BindView(R.id.txtPassword) EditText txtPass;
    @BindView(R.id.txtRePassword) EditText txtRepass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }
    public void btnRegisterClicked(View view)
    {
        if(!txtEmail.getText().toString().trim().isEmpty() && !txtNama.getText().toString().trim().isEmpty()&& !txtPass.getText().toString().trim().isEmpty() && !txtRepass.getText().toString().trim().isEmpty()&& !txtUserName.getText().toString().trim().isEmpty())
        {
            if(txtPass.getText().toString().trim().equals(txtRepass.getText().toString().trim()))
            {
                new AlertDialog.Builder(Register.this).setMessage("Apakah Anda yakin?").setCancelable(true).setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent myIntent = new Intent(Register.this,
                                Login.class);
                        startActivity(myIntent);
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();

            }
            else
            {
                new AlertDialog.Builder(Register.this).setMessage("Password tidak sama dengan RePassword").setCancelable(true).show();
            }

        }
        else
        {
            new AlertDialog.Builder(Register.this).setMessage("Masih ada yang kosong").setCancelable(true).show();
        }
    }
}
