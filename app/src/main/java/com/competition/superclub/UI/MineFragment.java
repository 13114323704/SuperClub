package com.competition.superclub.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.competition.superclub.R;

public class MineFragment extends Fragment {

    private View mainView;
    private LinearLayout line_favour, line_attention, line_read;
    private RelativeLayout rela_honor, rela_evaluate, rela_track, rela_advice, rela_about;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_mine, container, false);
        initData();
        initView();
        initListener();
        return mainView;
    }

    private void initData() {

    }

    private void initView() {
        line_favour = mainView.findViewById(R.id.line_favour);
        line_attention = mainView.findViewById(R.id.line_attention);
        line_read = mainView.findViewById(R.id.line_read);

        rela_honor = mainView.findViewById(R.id.user_honor_layout);
        rela_evaluate = mainView.findViewById(R.id.user_evaluate_layout);
        rela_track = mainView.findViewById(R.id.user_track_layout);
        rela_advice = mainView.findViewById(R.id.user_advice_layout);
        rela_about = mainView.findViewById(R.id.user_about_layout);
    }

    private void initListener() {
        line_favour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FavourActivity.class);
                startActivity(intent);
            }
        });
        line_attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AttentionActivity.class);
                startActivity(intent);
            }
        });
        line_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ReadActivity.class);
                startActivity(intent);
            }
        });
        rela_honor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MineHonorActivity.class);
                startActivity(intent);
            }
        });
        rela_evaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MineEvaluateActivity.class);
                startActivity(intent);
            }
        });
        rela_track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MineTrackActivity.class);
                startActivity(intent);
            }
        });
        rela_advice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "暂未开放", Toast.LENGTH_SHORT).show();
            }
        });
        rela_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
            }
        });
    }

}
