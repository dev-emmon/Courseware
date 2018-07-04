package me.imli.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text);
        textView.setText("Abc");

        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 单击事件
            }
        });

        button.setOnLongClickListener(this);


        CheckBox cb1 = findViewById(R.id.cb_1);
        CheckBox cb2 = findViewById(R.id.cb_2);

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "选中了", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "取消选中", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "选中了", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "取消选中", Toast.LENGTH_SHORT).show();
                }
            }
        });

        RadioGroup rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = group.findViewById(checkedId);
                Toast.makeText(MainActivity.this, "选中了" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onLongClick(View v) {
        // 长按事件
        return false;
    }
}
