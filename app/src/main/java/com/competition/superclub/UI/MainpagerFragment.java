package com.competition.superclub.UI;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.competition.superclub.Bean.ClubReleaseInfo;
import com.competition.superclub.R;
import com.competition.superclub.utils.ClubDataUtils;
import com.competition.superclub.utils.TabLayoutUtils;

import java.util.ArrayList;

/**
 * Created by 黄庆 on 2018/2/10.
 */

public class MainpagerFragment extends Fragment {

    private View mainView;

    private View view_info_hot, view_info_attention, view_info_local, view_info_all;
    private PullRefreshLayout pullRefreshLayout_hot, pullRefreshLayout_attention, pullRefreshLayout_local, pullRefreshLayout_all;
    private Handler handler = new Handler();
    private ClubReleaseInfoAdapter hotReleaseInfoAdapter, attentionReleaseInfoAdapter, localReleaseInfoAdapter, allReleaseInfoAdapter;
    private ArrayList<ClubReleaseInfo> hotReleaseInfoList = new ArrayList<>();
    private ArrayList<ClubReleaseInfo> attentionReleaseInfoList = new ArrayList<>();
    private ArrayList<ClubReleaseInfo> localReleaseInfoList = new ArrayList<>();
    private ArrayList<ClubReleaseInfo> allReleaseInfoList = new ArrayList<>();

    private ListView listView_hot, listView_attention, listView_local, listView_all;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<View> viewContainter = new ArrayList<View>();
    private ArrayList<String> titleContainer = new ArrayList<String>();
    private PagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mainView = inflater.inflate(R.layout.fragment_mainpager, container, false);
        initData();
        initView();
        initListener();
        return mainView;
    }

    private void initData() {
        hotReleaseInfoList.clear();
        attentionReleaseInfoList.clear();
        localReleaseInfoList.clear();
        allReleaseInfoList.clear();

        hotReleaseInfoList.add(ClubDataUtils.getFaxianInfo(getActivity()));
        hotReleaseInfoList.add(ClubDataUtils.getAndroidInfo(getActivity()));
        hotReleaseInfoList.add(ClubDataUtils.getChessInfo(getActivity()));
        hotReleaseInfoList.add(ClubDataUtils.getArtInfo(getActivity()));
        hotReleaseInfoList.add(ClubDataUtils.getWebInfo(getActivity()));
        hotReleaseInfoList.add(ClubDataUtils.getEnglishInfo(getActivity()));
        hotReleaseInfoList.add(ClubDataUtils.getPythonInfo(getActivity()));


        attentionReleaseInfoList.add(ClubDataUtils.getFaxianInfo(getActivity()));
        attentionReleaseInfoList.add(ClubDataUtils.getArtInfo(getActivity()));

        localReleaseInfoList.add(ClubDataUtils.getEnglishInfo(getActivity()));
        localReleaseInfoList.add(ClubDataUtils.getPythonInfo(getActivity()));

        allReleaseInfoList.add(ClubDataUtils.getChessInfo(getActivity()));
        allReleaseInfoList.add(ClubDataUtils.getAndroidInfo(getActivity()));
        allReleaseInfoList.add(ClubDataUtils.getWebInfo(getActivity()));


        view_info_hot = LayoutInflater.from(getActivity()).inflate(R.layout.view_list_releaseinfo_hot, null);
        view_info_attention = LayoutInflater.from(getActivity()).inflate(R.layout.view_list_releaseinfo_attention, null);
        view_info_local = LayoutInflater.from(getActivity()).inflate(R.layout.view_list_releaseinfo_local, null);
        view_info_all = LayoutInflater.from(getActivity()).inflate(R.layout.view_list_releaseinfo_all, null);

        viewContainter.clear();
        titleContainer.clear();

        viewContainter.add(view_info_hot);
        viewContainter.add(view_info_attention);
        viewContainter.add(view_info_local);
        viewContainter.add(view_info_all);

        titleContainer.add("热门");
        titleContainer.add("关注");
        titleContainer.add("校内");
        titleContainer.add("全国");
    }

    private void initView() {
        viewPager = mainView.findViewById(R.id.viewPager);
        tabLayout = mainView.findViewById(R.id.tablayout);
        adapter = new PagerAdapter() {
            // viewpager中的组件数量
            @Override
            public int getCount() {
                return viewContainter.size();
            }

            // 滑动切换的时候销毁当前的组件
            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(viewContainter.get(position));
            }

            // 每次滑动的时候生成的组件
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewContainter.get(position));
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

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        TabLayoutUtils.setIndicator(tabLayout, 15, 15);

        initInfoHot();
        initInfoAttention();
        initInfoLocal();
        initInfoAll();
    }

    private void initListener() {

    }

    private void initInfoHot() {
        listView_hot = view_info_hot.findViewById(R.id.listview_releaseinfo_hot);
        pullRefreshLayout_hot = view_info_hot.findViewById(R.id.pullRefreshLayout);
        pullRefreshLayout_hot.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout_hot.setRefreshing(false);
                        Toast.makeText(getActivity(), "热门资讯已更新！", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
        hotReleaseInfoAdapter = new ClubReleaseInfoAdapter(getActivity());
        hotReleaseInfoAdapter.listItem = hotReleaseInfoList;
        listView_hot.setAdapter(hotReleaseInfoAdapter);
        listView_hot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),DynamicInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initInfoAttention() {
        listView_attention = view_info_attention.findViewById(R.id.listview_releaseinfo_attention);
        pullRefreshLayout_attention = view_info_attention.findViewById(R.id.pullRefreshLayout);
        pullRefreshLayout_attention.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout_attention.setRefreshing(false);
                        Toast.makeText(getActivity(), "关注资讯已更新！", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
        attentionReleaseInfoAdapter = new ClubReleaseInfoAdapter(getActivity());
        attentionReleaseInfoAdapter.listItem = attentionReleaseInfoList;
        listView_attention.setAdapter(attentionReleaseInfoAdapter);
    }

    private void initInfoLocal() {
        listView_local = view_info_local.findViewById(R.id.listview_releaseinfo_local);
        pullRefreshLayout_local = view_info_local.findViewById(R.id.pullRefreshLayout);
        pullRefreshLayout_local.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout_local.setRefreshing(false);
                        Toast.makeText(getActivity(), "校内资讯已更新！", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
        localReleaseInfoAdapter = new ClubReleaseInfoAdapter(getActivity());
        localReleaseInfoAdapter.listItem = localReleaseInfoList;
        listView_local.setAdapter(localReleaseInfoAdapter);
    }

    private void initInfoAll() {
        listView_all = view_info_all.findViewById(R.id.listview_releaseinfo_all);
        pullRefreshLayout_all = view_info_all.findViewById(R.id.pullRefreshLayout);
        pullRefreshLayout_all.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout_all.setRefreshing(false);
                        Toast.makeText(getActivity(), "全国资讯已更新！", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
        allReleaseInfoAdapter = new ClubReleaseInfoAdapter(getActivity());
        allReleaseInfoAdapter.listItem = allReleaseInfoList;
        listView_all.setAdapter(allReleaseInfoAdapter);
    }

    public class ClubReleaseInfoAdapter extends BaseAdapter {

        private LayoutInflater mInflater;
        private ViewHolder_ReleaseInfo holder;
        private ArrayList<ClubReleaseInfo> listItem = new ArrayList<>();

        public ClubReleaseInfoAdapter(Context context) {
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
        public View getView(final int position,View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item_club_info_release, null);
                holder = new ViewHolder_ReleaseInfo();
                holder.imageView_club = convertView.findViewById(R.id.imageview_club_icon);
                holder.textView_name = convertView.findViewById(R.id.textview_club_name);
                holder.textView_time = convertView.findViewById(R.id.textview_time);
                holder.textView_content = convertView.findViewById(R.id.textview_content);
                holder.imageView_content1 = convertView.findViewById(R.id.imageview_content1);
                holder.imageView_content2 = convertView.findViewById(R.id.imageview_content2);
                holder.imageView_content3 = convertView.findViewById(R.id.imageview_content3);
                holder.textView_attention = convertView.findViewById(R.id.textview_attention);
                holder.textView_evaluate = convertView.findViewById(R.id.textview_evaluate);
                holder.textView_like = convertView.findViewById(R.id.textview_like);
                holder.imageView_more = convertView.findViewById(R.id.imageview_more);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder_ReleaseInfo) convertView.getTag();
            }

            holder.imageView_club.setImageDrawable(listItem.get(position).getClubIcon());
            holder.textView_name.setText(listItem.get(position).getClubName());
            holder.textView_time.setText(listItem.get(position).getTime());
            holder.textView_content.setText(listItem.get(position).getContent());

            holder.imageView_content1.setTag(listItem.get(position).getImage1());
            holder.imageView_content2.setTag(listItem.get(position).getImage2());
            holder.imageView_content3.setTag(listItem.get(position).getImage3());


            if (holder.imageView_content1.getTag() != null && holder.imageView_content1.getTag().equals(listItem.get(position).getImage1())) {
                if (listItem.get(position).getImage1() != null) {
                    holder.imageView_content1.setImageDrawable(listItem.get(position).getImage1());
                }
            } else {
                holder.imageView_content1.setVisibility(View.GONE);
            }

            if (holder.imageView_content2.getTag() != null && holder.imageView_content2.getTag().equals(listItem.get(position).getImage2())) {
                if (listItem.get(position).getImage2() != null) {
                    holder.imageView_content2.setImageDrawable(listItem.get(position).getImage2());
                }
            } else {
                holder.imageView_content2.setVisibility(View.GONE);
            }

            if (holder.imageView_content3.getTag() != null && holder.imageView_content3.getTag().equals(listItem.get(position).getImage3())) {
                if (listItem.get(position).getImage3() != null) {
                    holder.imageView_content3.setImageDrawable(listItem.get(position).getImage3());
                }
            } else {
                holder.imageView_content3.setVisibility(View.GONE);
            }
            holder.textView_attention.setText(listItem.get(position).getAttention());
            holder.textView_evaluate.setText(listItem.get(position).getEvaluate());
            holder.textView_like.setText(listItem.get(position).getLike());
            holder.imageView_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            final ImageView imageView=convertView.findViewById(R.id.image_attention);
            holder.textView_attention.setOnClickListener(new View.OnClickListener() {
                boolean isAttention=false;
                @Override
                public void onClick(View v) {
                    isAttention=!isAttention;
                    if(isAttention){
                        imageView.setImageResource(R.mipmap.icon_attention_select);
                    }else{
                        imageView.setImageResource(R.mipmap.icon_attention);
                    }
                }
            });
            final ImageView imageView_like=convertView.findViewById(R.id.image_like);
            holder.textView_like.setOnClickListener(new View.OnClickListener() {
                boolean isLike=false;
                @Override
                public void onClick(View v) {
                    isLike=!isLike;
                    if(isLike){
                        imageView_like.setImageResource(R.mipmap.icon_like_select);
                    }else{
                        imageView_like.setImageResource(R.mipmap.icon_like);
                    }
                }
            });
            holder.textView_evaluate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getActivity(),DynamicInfoActivity.class);
                    startActivity(intent);
                }
            });
            return convertView;
        }
    }

    public final class ViewHolder_ReleaseInfo {
        public ImageView imageView_club;
        public TextView textView_name;
        public TextView textView_time;
        public TextView textView_content;
        public ImageView imageView_content1;
        public ImageView imageView_content2;
        public ImageView imageView_content3;
        public TextView textView_attention;
        public TextView textView_evaluate;
        public TextView textView_like;
        public ImageView imageView_more;
    }
}
