package com.competition.superclub.UI;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.competition.superclub.Bean.InfoEvaluate;
import com.competition.superclub.CustomView.MyListView;
import com.competition.superclub.R;
import com.competition.superclub.utils.EvaluateDataUtils;

import java.util.ArrayList;

/**
 * Created by 黄庆 on 2018/2/24.
 */

public class DynamicInfoActivity extends AppCompatActivity {

    private PullRefreshLayout pullRefreshLayout;
    private ImageView image_back;
    private TextView textview_title;
    private ImageView imageView_club_icon;
    private TextView textView_club_name;
    private ImageView imageView_more;
    private TextView textView_content;
    private ImageView imageView_content1, imageView_content2, imageView_content3;

    private EvaluateAdapter evaluateAdapter;
    private ArrayList<InfoEvaluate> infoEvaluateArrayList = new ArrayList<>();
    private MyListView listView_evaluate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_info);
        initData();
        initView();
        initListener();
    }

    private void initData() {
        evaluateAdapter = new EvaluateAdapter(this);

        infoEvaluateArrayList.add(EvaluateDataUtils.getInfoEvaluateFirst(DynamicInfoActivity.this));
        infoEvaluateArrayList.add(EvaluateDataUtils.getInfoEvaluate1(DynamicInfoActivity.this));
        infoEvaluateArrayList.add(EvaluateDataUtils.getInfoEvaluate2(DynamicInfoActivity.this));
        infoEvaluateArrayList.add(EvaluateDataUtils.getInfoEvaluate3(DynamicInfoActivity.this));
        infoEvaluateArrayList.add(EvaluateDataUtils.getInfoEvaluate4(DynamicInfoActivity.this));
        infoEvaluateArrayList.add(EvaluateDataUtils.getInfoEvaluate5(DynamicInfoActivity.this));
        infoEvaluateArrayList.add(EvaluateDataUtils.getInfoEvaluate6(DynamicInfoActivity.this));
        for (int i = 0; i < 5; i++) {
            InfoEvaluate infoEvaluate = new InfoEvaluate();
            infoEvaluate.setUserIcon(ContextCompat.getDrawable(DynamicInfoActivity.this, R.mipmap.icon_user));
            infoEvaluate.setUserName("超级社团用户" + i);
            infoEvaluate.setReleaseTime("1" + i + ":35");
            infoEvaluate.setContent("这是一条很棒的评论！！！");
            infoEvaluateArrayList.add(infoEvaluate);
        }
        evaluateAdapter.listItem = infoEvaluateArrayList;
    }

    private void initView() {
        pullRefreshLayout = findViewById(R.id.pullRefreshLayout);
        image_back = findViewById(R.id.image_back);
        imageView_club_icon = findViewById(R.id.imageview_club_icon);
        imageView_club_icon.setImageDrawable(ContextCompat.getDrawable(DynamicInfoActivity.this, R.mipmap.icon_example_club));
        textView_club_name = findViewById(R.id.textview_club_name);
        textView_club_name.setText("发现杯俱乐部");
        textView_content = findViewById(R.id.textview_content);
        textView_content.setText("发现杯俱乐部正式招新啦，想参加的小伙伴们赶紧来我们社团吧，一起学习一起进步，你还在等什么！！！");
        imageView_content1 = findViewById(R.id.imageview_content1);
        imageView_content2 = findViewById(R.id.imageview_content2);
        imageView_content3 = findViewById(R.id.imageview_content3);
        imageView_content1.setVisibility(View.GONE);
        imageView_content2.setVisibility(View.GONE);
        imageView_content3.setVisibility(View.GONE);
        imageView_more = findViewById(R.id.imageview_more);
        textview_title = findViewById(R.id.textview_title);
        textview_title.setText("动态详情");
        listView_evaluate = findViewById(R.id.listview_evaluate);
        listView_evaluate.setAdapter(evaluateAdapter);
    }

    private void initListener() {
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imageView_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout.setRefreshing(false);
                        Toast.makeText(DynamicInfoActivity.this, "刷新成功", Toast.LENGTH_SHORT).show();
                    }
                }, 3000);
            }
        });
    }

    public class EvaluateAdapter extends BaseAdapter {

        private LayoutInflater mInflater;
        private ViewHolder_Evaluate holder;
        private ArrayList<InfoEvaluate> listItem = new ArrayList<>();

        public EvaluateAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return listItem.size();
        }

        @Override
        public Object getItem(int position) {
            return listItem.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.layout_item_dynamic_info, null);
                holder = new ViewHolder_Evaluate();
                holder.userIcon = convertView.findViewById(R.id.imageview_club_icon);
                holder.userName = convertView.findViewById(R.id.textview_club_name);
                holder.releaseTime = convertView.findViewById(R.id.textview_time);
                holder.content = convertView.findViewById(R.id.textview_content);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder_Evaluate) convertView.getTag();
            }

            holder.userIcon.setImageDrawable(listItem.get(position).getUserIcon());
            holder.userName.setText(listItem.get(position).getUserName());
            holder.releaseTime.setText(listItem.get(position).getReleaseTime());
            holder.content.setText(listItem.get(position).getContent());

            return convertView;
        }
    }

    public final class ViewHolder_Evaluate {
        public ImageView userIcon;
        public TextView userName;
        public TextView releaseTime;
        public TextView content;
    }
}
