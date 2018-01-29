package com.handi.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Income extends AppCompatActivity {
    @BindView(R.id.txtAmount)
    EditText txtAmount;

    @BindView(R.id.cmbCategoryExpense)
    Spinner cmbCategoryExpense;

    @BindView(R.id.calendarView)
    CalendarView calendarView;

    @BindView(R.id.btnAdd)
    Spinner btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        ButterKnife.bind(this);
    }
    public void btnCategoryClick(View view)
    {
        Intent myIntent = new Intent(Income.this,
                Category.class);
        startActivity(myIntent);
    }
    public void btnAddClick(View view)
    {
        Intent myIntent = new Intent(Income.this,
                MainActivity.class);
        startActivity(myIntent);
    }
}
