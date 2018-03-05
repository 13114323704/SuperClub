package com.competition.superclub.UI;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.competition.superclub.CustomView.AutofitViewPager;
import com.competition.superclub.CustomView.MyDialog;
import com.competition.superclub.CustomView.MyScrollView;
import com.competition.superclub.R;
import com.competition.superclub.utils.DisplayUtil;
import com.competition.superclub.utils.TabLayoutUtils;
import com.competition.superclub.utils.ViewUtil;

import java.util.ArrayList;

/**
 * Created by 黄庆 on 2018/2/25.
 */

public class ClubHomepageTestActivity extends AppCompatActivity {
    private AutofitViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<View> viewContainter = new ArrayList<View>();
    private ArrayList<String> titleContainer = new ArrayList<String>();
    private View view1, view2, view3, view4;
    private PagerAdapter adapter;

    private ListView listView1, listView2, listView3, listView4;

    private MyScrollView myScrollView;
    private RelativeLayout relativeLayout_top_container;
    private RelativeLayout relativeLayout_center_container;

    private ImageView imageView_back, imageView_function;
    private MyDialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_homepage_test);

        initData();
        initView();
        initListener();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        myDialog.dismiss();
    }

    private void initData() {
        view1 = LayoutInflater.from(this).inflate(R.layout.tab1, null);
        view2 = LayoutInflater.from(this).inflate(R.layout.tab2, null);
        view3 = LayoutInflater.from(this).inflate(R.layout.tab3, null);
        view4 = LayoutInflater.from(this).inflate(R.layout.tab4, null);

        viewContainter.add(view1);
        viewContainter.add(view2);
        viewContainter.add(view3);
        viewContainter.add(view4);

        titleContainer.add("主页");
        titleContainer.add("荣誉");
        titleContainer.add("出游");
        titleContainer.add("相册");

        adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewContainter.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(viewContainter.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewContainter.get(position));
                //viewContainter.get(position).setId(position);
                return viewContainter.get(position);
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public int getItemPosition(Object object) {

                return super.getItemPosition(object);
            }

            @Override
            public CharSequence getPageTitle(int position) {

                return titleContainer.get(position);
            }
        };
    }

    private void initView() {
        relativeLayout_top_container = findViewById(R.id.top_container_layout);
        relativeLayout_center_container = findViewById(R.id.center_container_layout);
        myScrollView = findViewById(R.id.myScrollView);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabs);
        imageView_back = findViewById(R.id.imageview_back);
        imageView_function = findViewById(R.id.imageview_function);

        listView1 = view1.findViewById(R.id.listview);
        listView2 = view2.findViewById(R.id.listview);
        listView3 = view3.findViewById(R.id.listview);
        listView4 = view4.findViewById(R.id.listview);

        listView1.setAdapter(new ClubMainPageAdapter(this));
        listView2.setAdapter(new ClubHonorAdapter(this));
        listView3.setAdapter(new ClubTrackAdapter(this));
        listView4.setAdapter(new ClubPhotoAdapter(this));

        ViewUtil.setListViewHeightBasedOnChildren(listView1);
        ViewUtil.setListViewHeightBasedOnChildren(listView2);
        ViewUtil.setListViewHeightBasedOnChildren(listView3);
        ViewUtil.setListViewHeightBasedOnChildren(listView4);

        viewPager.setAdapter(adapter);
        int height = ViewUtil.getListViewHeight(listView1);
        ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
        layoutParams.height = height;
        viewPager.setLayoutParams(layoutParams);
        tabLayout.setupWithViewPager(viewPager);
        TabLayoutUtils.setIndicator(tabLayout, 25, 25);


    }

    private void initListener() {
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        myDialog = new MyDialog(ClubHomepageTestActivity.this, R.style.dialogTheme,
                R.layout.dialog_manage_club);
        final Window window = myDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.enter_from_bottom);
        imageView_function.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();
                WindowManager.LayoutParams params = window.getAttributes();
                Point size = new Point();
                getWindowManager().getDefaultDisplay().getSize(size);
                params.width = size.x;
                params.dimAmount = 0.4f;
                window.setAttributes(params);

                RelativeLayout manage_club = myDialog.findViewById(R.id.relative_manage_club);
                RelativeLayout cancel = myDialog.findViewById(R.id.relative_cancel);
                manage_club.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ClubHomepageTestActivity.this, ClubManageActivity.class);
                        startActivity(intent);
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });
            }
        });
        myScrollView.setOnScrollListener(new MyScrollView.OnScrollListener() {
            @Override
            public void onScroll(int scrollY) {
                if (scrollY >= DisplayUtil.dip2px(ClubHomepageTestActivity.this, 200)) {
                    if (tabLayout.getParent() != relativeLayout_top_container) {
                        relativeLayout_center_container.removeView(tabLayout);
                        relativeLayout_top_container.addView(tabLayout);
                    }
                } else {
                    if (tabLayout.getParent() != relativeLayout_center_container) {
                        relativeLayout_top_container.removeView(tabLayout);
                        relativeLayout_center_container.addView(tabLayout);
                    }
                }
            }
        });
    }

    public class ClubMainPageAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public ClubMainPageAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (position == 0) {
                convertView = mInflater.inflate(R.layout.layout_club_detailinfo_test, null);
            } else if (position == 1) {
                convertView = mInflater.inflate(R.layout.layout_textview_end, null);
            } else {
                convertView = mInflater.inflate(R.layout.item_listview, null);
            }
            return convertView;
        }
    }

    public class ClubHonorAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public ClubHonorAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (position == 0) {
                convertView = mInflater.inflate(R.layout.layout_textview_end, null);
            } else {
                convertView = mInflater.inflate(R.layout.item_listview, null);
            }
            return convertView;
        }
    }

    public class ClubTrackAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public ClubTrackAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (position == 0) {
                convertView = mInflater.inflate(R.layout.layout_textview_end, null);
            } else {
                convertView = mInflater.inflate(R.layout.item_listview, null);
            }
            return convertView;
        }
    }

    public class ClubPhotoAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public ClubPhotoAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (position == 0) {
                convertView = mInflater.inflate(R.layout.layout_textview_end, null);
            } else {
                convertView = mInflater.inflate(R.layout.item_listview, null);
            }
            return convertView;
        }
    }
}
