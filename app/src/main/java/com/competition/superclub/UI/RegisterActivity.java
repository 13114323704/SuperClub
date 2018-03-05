package com.competition.superclub.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.competition.superclub.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 黄庆 on 2018/2/5.
 */

public class RegisterActivity extends AppCompatActivity{

    private ImageView image_back;
    private Spinner spinner_hobby;
    private List<String> list_spinner_data = new ArrayList<>();
    private ArrayAdapter<String> adapter_spinner;
    private TextView textView_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        image_back=this.findViewById(R.id.image_back);
        spinner_hobby=this.findViewById(R.id.spinner_hobby);
        textView_title=this.findViewById(R.id.textview_title);

        textView_title.setText("用户注册");

        list_spinner_data.clear();
        list_spinner_data.add("选择兴趣爱好");
        list_spinner_data.add("篮球");
        list_spinner_data.add("乒乓球");
        list_spinner_data.add("书法绘画");
        list_spinner_data.add("魔术娱乐");
        list_spinner_data.add("电影欣赏");
        list_spinner_data.add("音乐欣赏");
        adapter_spinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list_spinner_data);
        adapter_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_hobby.setAdapter(adapter_spinner);

        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
