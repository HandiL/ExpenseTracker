package com.handi.expensetracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.handi.expensetracker.Entity.UserData;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Register extends AppCompatActivity {
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
    public void openLoginActivity(UserData userData){
        if(userData.getStatus()==1 && userData != null){
            Toast.makeText(this,userData.getMsg(),Toast.LENGTH_SHORT).show();
            Intent move=new Intent(Register.this,Login.class);
            this.startActivity(move);
            this.finish();
        }
        else{
            Toast.makeText(this,this.getResources().getString(R.string.T_Register_Failed),Toast.LENGTH_SHORT).show();
        }
    }
    public void btnRegisterClicked(View view)
    {
        if(!txtEmail.getText().toString().trim().isEmpty() && !txtNama.getText().toString().trim().isEmpty()&& !txtPass.getText().toString().trim().isEmpty() && !txtRepass.getText().toString().trim().isEmpty())
        {
            if(txtPass.getText().toString().trim().equals(txtRepass.getText().toString().trim()))
            {
                AddUserTask addUserTask = new AddUserTask(this);
                addUserTask.execute(txtEmail.getText().toString().trim(),txtPass.getText().toString().trim(),txtNama.getText().toString().trim());
                /*new AlertDialog.Builder(Register.this).setMessage("Apakah Anda yakin?").setCancelable(true).setPositiveButton("Ya", new DialogInterface.OnClickListener() {
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
                }).show();*/
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
