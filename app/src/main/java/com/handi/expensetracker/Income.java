package com.handi.expensetracker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Income extends AppCompatActivity {
    @BindView(R.id.txtAmount)
    EditText txtAmount;

    @BindView(R.id.cmbCategoryIncome)
    Spinner cmbCategoryIncome;

    @BindView(R.id.txtDate)
    EditText txtDate;

    @BindView(R.id.btnAdd)
    Button btnAdd;
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

    public void onClickTxtDate(View v) {
        new DatePickerDialog(this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }
    Calendar myCalendar=Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateText();
        }
    };
    private void updateText() {
        String myFormat = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        txtDate.setText(sdf.format(myCalendar.getTime()));
    }
}
