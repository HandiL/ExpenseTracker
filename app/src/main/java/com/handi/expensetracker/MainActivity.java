package com.handi.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnExpenseClick(View view)
    {
        Intent myIntent = new Intent(MainActivity.this,
                Expense.class);
        startActivity(myIntent);
    }
    public void btnIncomeClick(View view)
    {
        Intent myIntent = new Intent(MainActivity.this,
                Income.class);
        startActivity(myIntent);
    }
    public void btnOverViewClick(View view)
    {
        Intent myIntent = new Intent(MainActivity.this,
                OverView.class);
        startActivity(myIntent);
    }
    public void btnLogOutClick(View view)
    {
        Intent myIntent = new Intent(MainActivity.this,
                Login.class);
        startActivity(myIntent);
    }
}
