package com.handi.expensetracker;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.handi.expensetracker.Entity.UserData;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity {
    @BindView(R.id.txtEmail) EditText txtEmail;
    @BindView(R.id.txtPassword) EditText txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    public void btnLoginClick(View view)
    {
        if(!TextUtils.isEmpty(txtEmail.getText().toString().trim()) && !TextUtils.isEmpty(txtPass.getText().toString().trim())){
            UserLoginTask userLoginTask=new UserLoginTask(this);
            userLoginTask.execute(txtEmail.getText().toString().trim(),txtPass.getText().toString().trim());
        }else{
            Toast.makeText(this,"Please fill email and password",Toast.LENGTH_SHORT).show();
        }
    }

    public void btnRegisterClick(View view)
    {
        Intent myIntent = new Intent(Login.this,
                Register.class);
        startActivity(myIntent);
    }

    public void openMainActivity(UserData userData){
        if(userData.getStatus()==1 && userData != null && userData.getUser() != null){
            Toast.makeText(this,userData.getMsg(),Toast.LENGTH_SHORT).show();
            Intent move=new Intent(Login.this,MainActivity.class);
            this.startActivity(move);
            this.finish();
        }
        else{
            Toast.makeText(this,this.getResources().getString(R.string.T_user_not_valid),Toast.LENGTH_SHORT).show();
        }
    }
}
