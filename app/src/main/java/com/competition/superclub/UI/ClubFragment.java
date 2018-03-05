package com.competition.superclub.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.competition.superclub.R;
import com.competition.superclub.utils.DisplayUtil;

/**
 * Created by 黄庆 on 2018/2/10.
 */

public class ClubFragment extends Fragment {
    private View mainView;
    private ImageView image_back;
    private TextView textView_title;
    private TextView textView_message;

    //下拉刷新相关
    private PullRefreshLayout pullRefreshLayout;
    //用于处理下拉刷新事件
    private Handler handler = new Handler();

    private View view_faxian, view_android, view_english, view_web, view_python, view_chess, view_art;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_club, container, false);
        initData();
        initView();
        initListener();
        return mainView;
    }

    private void initData() {

    }

    private void initView() {
        //标题部分
        image_back = mainView.findViewById(R.id.image_back);
        image_back.setVisibility(View.GONE);
        textView_title = mainView.findViewById(R.id.textview_title);
        textView_title.setText("社团");
        textView_message = mainView.findViewById(R.id.textview_function);
        textView_message.setVisibility(View.VISIBLE);
        textView_message.setBackground(ContextCompat.getDrawable(getActivity(), R.mipmap.icon_club_register));
        textView_message.setText("");
        ViewGroup.LayoutParams lp = textView_message.getLayoutParams();
        lp.width = DisplayUtil.dip2px(getActivity(), 25);
        lp.height = DisplayUtil.dip2px(getActivity(), 25);
        textView_message.setLayoutParams(lp);

        pullRefreshLayout = mainView.findViewById(R.id.pullRefreshLayout);

        //下方七个列表项
        view_faxian = mainView.findViewById(R.id.item_club_info_layout1);
        view_android = mainView.findViewById(R.id.item_club_info_layout2);
        view_english = mainView.findViewById(R.id.item_club_info_layout3);
        view_web = mainView.findViewById(R.id.item_club_info_layout4);
        view_python = mainView.findViewById(R.id.item_club_info_layout5);
        view_chess = mainView.findViewById(R.id.item_club_info_layout6);
        view_art = mainView.findViewById(R.id.item_club_info_layout7);
    }

    private void initListener() {
        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout.setRefreshing(false);
                        Toast.makeText(getActivity(), "社团天地已成功更新", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
        view_faxian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClubHomepageActivity.class);
                intent.putExtra("flag", "1");
                startActivity(intent);
            }
        });
        view_android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClubHomepageActivity.class);
                intent.putExtra("flag","2");
                startActivity(intent);
            }
        });
        view_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClubHomepageActivity.class);
                intent.putExtra("flag","3");
                startActivity(intent);
            }
        });
        view_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClubHomepageActivity.class);
                intent.putExtra("flag","4");
                startActivity(intent);
            }
        });
        view_python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClubHomepageActivity.class);
                intent.putExtra("flag","5");
                startActivity(intent);
            }
        });
        view_chess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClubHomepageActivity.class);
                intent.putExtra("flag","6");
                startActivity(intent);
            }
        });
        view_art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClubHomepageActivity.class);
                intent.putExtra("flag","7");
                startActivity(intent);
            }
        });

        textView_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClubRegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
