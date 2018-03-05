package com.competition.superclub.UI;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
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

public class RankActivity extends AppCompatActivity {

    private ImageView image_back;
    private TextView textView_title;
    private PullRefreshLayout pullRefreshLayout;

    private int flag;
    private View view_rank1, view_rank2, view_rank3, view_rank4, view_rank5;
    private ImageView image_rank_flag1, image_rank_flag2, image_rank_flag3, image_rank_flag4, image_rank_flag5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        flag = getIntent().getIntExtra("flag", 1);
        image_back = findViewById(R.id.image_back);
        textView_title = findViewById(R.id.textview_title);
        switch (flag){
            case 1:
                textView_title.setText("热度排行榜");
                break;
            case 2:
                textView_title.setText("荣誉排行榜");
                break;
            case 3:
                textView_title.setText("规模排行榜");
                break;
            case 4:
                textView_title.setText("颜值排行榜");
                break;
        }

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
                        Toast.makeText(RankActivity.this, "排行榜已更新！", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });

        view_rank1 = findViewById(R.id.item_rank_hot1);
        view_rank2 = findViewById(R.id.item_rank_hot2);
        view_rank3 = findViewById(R.id.item_rank_hot3);
        view_rank4 = findViewById(R.id.item_rank_hot4);
        view_rank5 = findViewById(R.id.item_rank_hot5);

        image_rank_flag1 = view_rank1.findViewById(R.id.image_rank_flag);
        image_rank_flag2 = view_rank2.findViewById(R.id.image_rank_flag);
        image_rank_flag3 = view_rank3.findViewById(R.id.image_rank_flag);
        image_rank_flag4 = view_rank4.findViewById(R.id.image_rank_flag);
        image_rank_flag5 = view_rank5.findViewById(R.id.image_rank_flag);
        switch (flag) {
            case 1:
                image_rank_flag1.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_hot));
                image_rank_flag2.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_hot2));
                image_rank_flag3.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_hot3));
                image_rank_flag4.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_hot3));
                image_rank_flag5.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_hot3));
                break;
            case 2:
                image_rank_flag1.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_honor_flag1));
                image_rank_flag2.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_honor_flag2));
                image_rank_flag3.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_honor_flag3));
                image_rank_flag4.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_honor_flag3));
                image_rank_flag5.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_honor_flag3));
                break;
            case 3:
                image_rank_flag1.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_member_flag1));
                image_rank_flag2.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_member_flag2));
                image_rank_flag3.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_member_flag3));
                image_rank_flag4.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_member_flag3));
                image_rank_flag5.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_member_flag3));
                break;
            case 4:
                image_rank_flag1.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_face_flag1));
                image_rank_flag2.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_face_flag2));
                image_rank_flag3.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_face_flag3));
                image_rank_flag4.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_face_flag3));
                image_rank_flag5.setImageDrawable(ContextCompat.getDrawable(RankActivity.this, R.mipmap.icon_face_flag3));
                break;
        }
    }
}
