package com.competition.superclub.UI;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.competition.superclub.R;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;


import java.util.Arrays;
import java.util.List;

/**
 * Created by 黄庆 on 2018/2/25.
 */

public class ClubRegisterActivity extends AppCompatActivity {
    private ImageView image_back;
    private TextView textView_title;
    private TextView textView_function;

    private WheelView wheelView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_register);
        image_back = findViewById(R.id.image_back);
        textView_title = findViewById(R.id.textview_title);
        textView_title.setText("注册社团");
        textView_function = findViewById(R.id.textview_function);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        textView_function.setVisibility(View.VISIBLE);
        textView_function.setText("注册");
        textView_function.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClubRegisterActivity.this, ClubHomepageTestActivity.class);
                startActivity(intent);
            }
        });

        wheelView = findViewById(R.id.wheelview);
        wheelView.setWheelSize(3);
        wheelView.setLoop(true);
        wheelView.setWheelAdapter(new ArrayWheelAdapter(this)); // 文本数据源
        wheelView.setSkin(WheelView.Skin.Holo); // common皮肤
        wheelView.setWheelData(createMainDatas());  // 数据集合
        WheelView.WheelViewStyle style = new WheelView.WheelViewStyle();
        style.selectedTextSize = 20;
        style.textSize = 16;
        style.backgroundColor = Color.TRANSPARENT;
        wheelView.setStyle(style);
    }

    private List<String> createMainDatas() {
        String[] strings = {"综合", "IT", "音乐", "绘画", "围棋/象棋"};
        return Arrays.asList(strings);
    }
}
