package me.imli.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    StudentDBDao studentDBDao;

    EditText etSID;
    EditText etName;
    EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        studentDBDao = new StudentDBDao(MainActivity.this);


        etSID = findViewById(R.id.et_id);
        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);

        Button btnInster = findViewById(R.id.btn_inster);
        Button btnUpdate = findViewById(R.id.btn_update);
        Button btnDel = findViewById(R.id.btn_del);
        Button btnQuery = findViewById(R.id.btn_query);

        btnInster.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnQuery.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_inster:
                Student student1 = new Student();
                student1.sid = Integer.valueOf(etSID.getText().toString());
                student1.name = etName.getText().toString();
                student1.age = Integer.valueOf(etAge.getText().toString());
                studentDBDao.insert(student1);
                // 弹出提示
                Toast.makeText(MainActivity.this, "插入成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_update:
                Student student2 = new Student();
                student2.sid = Integer.valueOf(etSID.getText().toString());
                student2.name = etName.getText().toString();
                student2.age = Integer.valueOf(etAge.getText().toString());
                studentDBDao.update(student2);
                // 弹出提示
                Toast.makeText(MainActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_del:
                int id1 = Integer.valueOf(etSID.getText().toString());
                studentDBDao.delete(id1);
                // 弹出提示
                Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_query:
                int id2 = Integer.valueOf(etSID.getText().toString());
                Student student = studentDBDao.query(id2);
                // 显示查询出来的学生信息
                Toast.makeText(MainActivity.this, student.toString(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
