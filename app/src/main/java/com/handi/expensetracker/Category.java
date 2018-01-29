package com.handi.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Category extends AppCompatActivity {
    @BindView(R.id.txtCategoryName)
    EditText txtCategoryName;

    @BindView(R.id.cmbCategory)
    Spinner cmbCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
    }
    public void btnAddClick(View view)
    {
        Intent myIntent = new Intent(Category.this,
                MainActivity.class);
        startActivity(myIntent);
    }
}
