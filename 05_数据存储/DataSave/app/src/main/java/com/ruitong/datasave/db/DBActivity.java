package com.ruitong.datasave.db;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.ruitong.datasave.R;

public class DBActivity extends AppCompatActivity implements View.OnClickListener {

    StudentDAO studentDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        studentDAO = new StudentDAO(this);

        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_find).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                Student student = new Student(003, "马克", (short) 18);
                studentDAO.add(student);
                Log.d(getClass().getSimpleName(), "db insert success!");
                break;
            case R.id.btn_find:
                Student student1 = studentDAO.find(003);
                Log.d(getClass().getSimpleName(), "get db data: " + student1.toString());
                break;
        }
    }
}
