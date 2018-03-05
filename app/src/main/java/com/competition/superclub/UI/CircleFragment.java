package com.competition.superclub.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.competition.superclub.R;
import com.competition.superclub.utils.DisplayUtil;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by 黄庆 on 2018/2/7.
 */

public class CircleFragment extends Fragment {
    private View mainView;
    private ImageView image_back;
    private TextView textView_title;
    private TextView textView_scan;
    private PullRefreshLayout pullRefreshLayout;
    //用于处理下拉刷新事件
    private Handler pullRefresh_handler = new Handler();
    //图片轮播相关控件
    private ViewPager mViewPaper;
    private List<ImageView> images;
    // 存放图片的id
    private int[] imageIds = new int[]{R.mipmap.a, R.mipmap.b,
            R.mipmap.c, R.mipmap.d, R.mipmap.e};
    private List<View> dots;
    private int currentItem;
    // 记录上一次点的位置
    private int oldPosition = 0;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;
    //接收子线程传递过来的数据,用于处理图片轮播事件
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            mViewPaper.setCurrentItem(currentItem);
        }

        ;
    };
    private Button btn_recruit, btn_honor, btn_track;
    private LinearLayout line_hot, line_honor, line_member, line_face;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_circle, container, false);
        initData();
        initView();
        initListener();
        return mainView;
    }

    private void initData() {
        // 显示的图片
        images = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }

        // 显示的小点
        dots = new ArrayList<View>();
        dots.add(mainView.findViewById(R.id.dot_0));
        dots.add(mainView.findViewById(R.id.dot_1));
        dots.add(mainView.findViewById(R.id.dot_2));
        dots.add(mainView.findViewById(R.id.dot_3));
        dots.add(mainView.findViewById(R.id.dot_4));
    }

    private void initView() {
        image_back = mainView.findViewById(R.id.image_back);
        image_back.setVisibility(View.GONE);
        textView_title = mainView.findViewById(R.id.textview_title);
        textView_title.setText("发现");
        textView_scan = mainView.findViewById(R.id.textview_function);
        textView_scan.setVisibility(View.VISIBLE);
        textView_scan.setBackground(ContextCompat.getDrawable(getActivity(), R.mipmap.icon_scan));
        textView_scan.setText("");
        ViewGroup.LayoutParams lp = textView_scan.getLayoutParams();
        lp.width = DisplayUtil.dip2px(getActivity(), 25);
        lp.height = DisplayUtil.dip2px(getActivity(), 25);
        textView_scan.setLayoutParams(lp);

        pullRefreshLayout = mainView.findViewById(R.id.pullRefreshLayout);
        mViewPaper = mainView.findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);

        btn_recruit = mainView.findViewById(R.id.btn_recruit);
        btn_honor = mainView.findViewById(R.id.btn_honor);
        btn_track = mainView.findViewById(R.id.btn_track);

        line_hot = mainView.findViewById(R.id.line_hot);
        line_honor = mainView.findViewById(R.id.line_honor);
        line_member = mainView.findViewById(R.id.line_member);
        line_face = mainView.findViewById(R.id.line_face);
    }

    private void initListener() {
        textView_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivityForResult(new Intent(getActivity(), CaptureActivity.class), 0);
            }
        });
        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pullRefresh_handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout.setRefreshing(false);
                        Toast.makeText(getActivity(), "已更新最新资讯", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
        mViewPaper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

                dots.get(position).setBackgroundResource(
                        R.drawable.dot_focused);
                dots.get(oldPosition).setBackgroundResource(
                        R.drawable.dot_normal);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
        btn_recruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RecruitActivity.class);
                startActivity(intent);
            }
        });
        btn_honor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HonorActivity.class);
                startActivity(intent);
            }
        });
        btn_track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrackActivity.class);
                startActivity(intent);
            }
        });

        line_hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RankActivity.class);
                intent.putExtra("flag", 1);
                startActivity(intent);
            }
        });
        line_honor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RankActivity.class);
                intent.putExtra("flag", 2);
                startActivity(intent);
            }
        });
        line_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RankActivity.class);
                intent.putExtra("flag", 3);
                startActivity(intent);
            }
        });
        line_face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RankActivity.class);
                intent.putExtra("flag", 4);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            try {
                String result = data.getExtras().getString("result");
                Toast.makeText(getActivity(), "扫描结果为" + result, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getActivity(), "您取消了扫描", Toast.LENGTH_LONG).show();
            }
        }
    }

    //利用线程池定时执行动画轮播
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new ViewPageTask(), 3,
                3, TimeUnit.SECONDS);
    }

    @Override
    public void onStop() {
        super.onStop();
        scheduledExecutorService.shutdown();
    }

    private class ViewPageTask implements Runnable {

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);
        }
    }

    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            view.removeView(images.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            view.addView(images.get(position));
            return images.get(position);
        }

    }
}
