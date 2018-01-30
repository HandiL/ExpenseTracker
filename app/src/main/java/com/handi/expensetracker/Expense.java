package com.handi.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Expense extends AppCompatActivity {
    @BindView(R.id.txtAmount)
    EditText txtAmount;

    @BindView(R.id.cmbCategoryExpense)
    Spinner cmbCategoryExpense;

    @BindView(R.id.calendarView)
    CalendarView calendarView;

    @BindView(R.id.btnAdd)
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        ButterKnife.bind(this);
    }
    public void btnCategoryClick(View view)
    {
        Intent myIntent = new Intent(Expense.this,
                Category.class);
        startActivity(myIntent);
    }
    public void btnAddClick(View view)
    {
        Intent myIntent = new Intent(Expense.this,
                MainActivity.class);
        startActivity(myIntent);
    }
}
