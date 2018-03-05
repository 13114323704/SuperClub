package com.competition.superclub.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.competition.superclub.Bean.MemberInfo;
import com.competition.superclub.R;
import com.competition.superclub.utils.MemberDataUtils;

import java.util.ArrayList;

/**
 * Created by 黄庆 on 2018/2/25.
 */

public class MemberManageActivity extends AppCompatActivity {

    private ImageView image_back;
    private TextView textView_title, textView_function;
    private ListView listView;
    private MemberInfoAdapter memberInfoAdapter;
    private ArrayList<MemberInfo> memberInfoArrayList = new ArrayList<>();
    private int[] statusList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_manage);
        image_back = findViewById(R.id.image_back);
        textView_title = findViewById(R.id.textview_title);
        textView_title.setText("成员管理");
        textView_function = findViewById(R.id.textview_function);
        textView_function.setVisibility(View.VISIBLE);
        textView_function.setText("踢出");
        textView_function.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<MemberInfo> tempList=new ArrayList<>();
                tempList.clear();
                for(int i=0;i<statusList.length;i++){
                    if(statusList[i]==0){
                        tempList.add(memberInfoArrayList.get(i));
                    }
                }
                memberInfoArrayList.clear();
                for(MemberInfo memberInfo:tempList){
                    memberInfoArrayList.add(memberInfo);
                }
                memberInfoAdapter.notifyDataSetChanged();
                statusList=new int[memberInfoArrayList.size()];
                for(int i=0;i<statusList.length;i++){
                    statusList[i]=0;
                }
                Toast.makeText(MemberManageActivity.this,"强制退出成员成功",Toast.LENGTH_SHORT).show();
            }
        });
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listView = findViewById(R.id.listview_member);

        memberInfoArrayList.clear();
        memberInfoArrayList.add(MemberDataUtils.getMemberInfo1(MemberManageActivity.this));
        memberInfoArrayList.add(MemberDataUtils.getMemberInfo2(MemberManageActivity.this));
        memberInfoArrayList.add(MemberDataUtils.getMemberInfo3(MemberManageActivity.this));
        memberInfoArrayList.add(MemberDataUtils.getMemberInfo4(MemberManageActivity.this));
        memberInfoArrayList.add(MemberDataUtils.getMemberInfo5(MemberManageActivity.this));
        memberInfoArrayList.add(MemberDataUtils.getMemberInfo6(MemberManageActivity.this));
        memberInfoArrayList.add(MemberDataUtils.getMemberInfo7(MemberManageActivity.this));
        memberInfoArrayList.add(MemberDataUtils.getMemberInfo8(MemberManageActivity.this));

        memberInfoAdapter = new MemberInfoAdapter(this);
        memberInfoAdapter.listItem = memberInfoArrayList;
        listView.setAdapter(memberInfoAdapter);

        statusList=new int[memberInfoArrayList.size()];
        for(int i=0;i<statusList.length;i++){
            statusList[i]=0;
        }
    }

    public class MemberInfoAdapter extends BaseAdapter {

        private LayoutInflater mInflater;
        private ViewHolder_MemberInfo holder;
        private ArrayList<MemberInfo> listItem = new ArrayList<>();

        public MemberInfoAdapter(Context context) {
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
                convertView = mInflater.inflate(R.layout.item_listview_member_info, null);
                holder = new ViewHolder_MemberInfo();
                holder.imageView_member = convertView.findViewById(R.id.imageview_member);
                holder.textView_name = convertView.findViewById(R.id.textview_name);
                holder.textView_status = convertView.findViewById(R.id.textview_status);
                holder.textView_signature = convertView.findViewById(R.id.textview_signature);
                holder.textView_role = convertView.findViewById(R.id.textview_role);
                holder.checkBox= convertView.findViewById(R.id.checkbox);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder_MemberInfo) convertView.getTag();
            }

            holder.imageView_member.setImageDrawable(listItem.get(position).getMember_icon());
            holder.textView_name.setText(listItem.get(position).getMember_name());
            holder.textView_status.setText(listItem.get(position).getMember_status());
            holder.textView_signature.setText(listItem.get(position).getMember_signature());
            holder.textView_role.setText(listItem.get(position).getMember_role());
            if (listItem.get(position).getMember_role().equals("社长")) {
                holder.textView_role.setTextColor(getResources().getColor(R.color.red));
            } else if (listItem.get(position).getMember_role().equals("副社长")) {
                holder.textView_role.setTextColor(getResources().getColor(R.color.golden));
            } else if (listItem.get(position).getMember_role().equals("管理员")) {
                holder.textView_role.setTextColor(getResources().getColor(R.color.orange));
            }
            holder.checkBox.setChecked(false);
            holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        statusList[position]=1;
                    }else{
                        statusList[position]=0;
                    }
                }
            });
            return convertView;
        }
    }

    public final class ViewHolder_MemberInfo {
        public ImageView imageView_member;
        public TextView textView_name;
        public TextView textView_status;
        public TextView textView_signature;
        public TextView textView_role;
        public CheckBox checkBox;
    }
}
