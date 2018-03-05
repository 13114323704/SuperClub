package com.competition.superclub.UI;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.competition.superclub.CustomView.MyDialog;
import com.competition.superclub.R;

/**
 * Created by 黄庆 on 2018/2/24.
 */

public class HonorActivity extends AppCompatActivity{

    private ImageView image_back;
    private TextView textView_title;
    private PullRefreshLayout pullRefreshLayout;
    private View view1,view2;
    private Button btn_flower1,btn_flower2;
    private MyDialog myDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honor);
        image_back = findViewById(R.id.image_back);
        textView_title = findViewById(R.id.textview_title);
        textView_title.setText("荣誉");
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
                        Toast.makeText(HonorActivity.this, "荣誉信息已更新！", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });

        myDialog=new MyDialog(HonorActivity.this,R.style.dialogTheme, R.layout.dialog_flower);
        final Window window = myDialog.getWindow();
        window.setGravity(Gravity.CENTER);
        window.setWindowAnimations(R.style.fade_in_out);

        view1=findViewById(R.id.layout_item_honor1);
        view2=findViewById(R.id.layout_item_honor2);
        btn_flower1=view1.findViewById(R.id.btn_flower);
        btn_flower2=view2.findViewById(R.id.btn_flower);
        btn_flower1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();
                WindowManager.LayoutParams params = window.getAttributes();
                Point size = new Point();
                getWindowManager().getDefaultDisplay().getSize(size);
                params.width = (int) ((size.x) * 0.6);
                params.dimAmount = 0.0f;
                window.setAttributes(params);
                ImageView imageView_flower=myDialog.findViewById(R.id.image_flower);
                imageView_flower.setAnimation(AnimationUtils.loadAnimation(HonorActivity.this,R.anim.flower_scale_fade));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        myDialog.dismiss();
                    }
                },2000);
            }
        });
        btn_flower2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();
                WindowManager.LayoutParams params = window.getAttributes();
                Point size = new Point();
                getWindowManager().getDefaultDisplay().getSize(size);
                params.width = (int) ((size.x) * 0.6);
                params.dimAmount = 0.0f;
                window.setAttributes(params);
                ImageView imageView_flower=myDialog.findViewById(R.id.image_flower);
                imageView_flower.setAnimation(AnimationUtils.loadAnimation(HonorActivity.this,R.anim.flower_scale_fade));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        myDialog.dismiss();
                    }
                },2000);
            }
        });
    }
}
