package com.competition.superclub.UI;

import android.content.Intent;
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
 * Created by 黄庆 on 2018/2/24.
 */

public class TrackActivity extends AppCompatActivity {

    private ImageView image_back;
    private TextView textView_title, textView_function;
    private PullRefreshLayout pullRefreshLayout;

    private View view1,view2,view3;
    private TextView textView_location1,textView_location2,textView_location3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        image_back = findViewById(R.id.image_back);
        textView_title = findViewById(R.id.textview_title);
        textView_title.setText("出游");
        /*textView_function = findViewById(R.id.textview_function);
        textView_function.setVisibility(View.VISIBLE);
        textView_function.setText("推荐");*/
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
                        Toast.makeText(TrackActivity.this, "出游信息已更新！", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
        view1=findViewById(R.id.layout_item_track1);
        view2=findViewById(R.id.layout_item_track2);
        view3=findViewById(R.id.layout_item_track3);
        textView_location1=view1.findViewById(R.id.textview_location);
        textView_location2=view2.findViewById(R.id.textview_location);
        textView_location3=view3.findViewById(R.id.textview_location);
        textView_location1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TrackActivity.this,SearchMapActivity.class);
                startActivity(intent);
            }
        });
        textView_location2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TrackActivity.this,SearchMapActivity.class);
                startActivity(intent);
            }
        });
        textView_location3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TrackActivity.this,SearchMapActivity.class);
                startActivity(intent);
            }
        });
    }

}
