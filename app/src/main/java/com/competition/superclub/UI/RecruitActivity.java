package com.competition.superclub.UI;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.competition.superclub.R;

/**
 * Created by 黄庆 on 2018/2/24.
 */

public class RecruitActivity extends AppCompatActivity {

    private ImageView image_back;
    private TextView textView_title;
    private PullRefreshLayout pullRefreshLayout;
    private View view1, view2, view3;
    private Button btn_apply1, btn_apply2, btn_apply3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruit);
        image_back = findViewById(R.id.image_back);
        textView_title = findViewById(R.id.textview_title);
        textView_title.setText("招新");
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        pullRefreshLayout = findViewById(R.id.pullRefreshLayout);
        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout.setRefreshing(false);
                        Toast.makeText(RecruitActivity.this, "招新信息已更新！", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
        view1 = findViewById(R.id.layout_item_recruit);
        view2 = findViewById(R.id.layout_item_recruit2);
        view3 = findViewById(R.id.layout_item_recruit3);
        btn_apply1=view1.findViewById(R.id.btn_apply);
        btn_apply2=view2.findViewById(R.id.btn_apply);
        btn_apply3=view3.findViewById(R.id.btn_apply);
        btn_apply1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecruitActivity.this,"申请成功",Toast.LENGTH_SHORT).show();
            }
        });
        btn_apply2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecruitActivity.this,"申请成功",Toast.LENGTH_SHORT).show();
            }
        });
        btn_apply3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecruitActivity.this,"申请成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
