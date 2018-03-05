package com.competition.superclub.UI;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.competition.superclub.R;

/**
 * Created by 黄庆 on 2018/2/25.
 */

public class AboutActivity extends AppCompatActivity {
    private ImageView image_back;
    private TextView textView_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        image_back = findViewById(R.id.image_back);
        textView_title = findViewById(R.id.textview_title);
        textView_title.setText("关于我们");
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
