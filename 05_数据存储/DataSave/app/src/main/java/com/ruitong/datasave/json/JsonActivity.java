package com.ruitong.datasave.json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.ruitong.datasave.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Em on 2016/7/14.
 */
public class JsonActivity extends AppCompatActivity {

//    {"key":"value"}

    public static final String JSON = "[{\"id\":1, \"name\":\"001号\", \"address\":\"民族大道\"},{\"id\":2, \"name\":\"002号\", \"address\":\"关山大道\"}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        List<Person> list = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(JSON);
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String name = jsonObject.getString("name");
                String address = jsonObject.getString("address");
                list.add(new Person(id, name, address));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        TextView tv = (TextView) findViewById(R.id.tv_json);
        tv.setText(list.toString());

        Log.d(getClass().getSimpleName(), "Person " + list.toString());
    }
}
