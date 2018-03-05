package com.competition.superclub.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.competition.superclub.Bean.MemberInfo;
import com.competition.superclub.R;

/**
 * Created by 黄庆 on 2018/2/25.
 */

public class MemberDataUtils {
    public static MemberInfo getMemberInfo1(Context context){
        MemberInfo memberInfo=new MemberInfo();
        memberInfo.setMember_icon(ContextCompat.getDrawable(context, R.mipmap.icon_user_example2));
        memberInfo.setMember_name("张三");
        memberInfo.setMember_status("刚刚活跃");
        memberInfo.setMember_signature("这个人很懒，什么也没有留下");
        memberInfo.setMember_role("社长");
        return  memberInfo;
    }
    public static MemberInfo getMemberInfo2(Context context){
        MemberInfo memberInfo=new MemberInfo();
        memberInfo.setMember_icon(ContextCompat.getDrawable(context, R.mipmap.icon_user1));
        memberInfo.setMember_name("李四");
        memberInfo.setMember_status("十分钟前活跃");
        memberInfo.setMember_signature("努力才会等来成功!!");
        memberInfo.setMember_role("副社长");
        return  memberInfo;
    }
    public static MemberInfo getMemberInfo3(Context context){
        MemberInfo memberInfo=new MemberInfo();
        memberInfo.setMember_icon(ContextCompat.getDrawable(context, R.mipmap.icon_user2));
        memberInfo.setMember_name("赵四");
        memberInfo.setMember_status("一小时前活跃");
        memberInfo.setMember_signature("一步一个脚印，会成功的");
        memberInfo.setMember_role("管理员");
        return  memberInfo;
    }
    public static MemberInfo getMemberInfo4(Context context){
        MemberInfo memberInfo=new MemberInfo();
        memberInfo.setMember_icon(ContextCompat.getDrawable(context, R.mipmap.icon_user3));
        memberInfo.setMember_name("王六");
        memberInfo.setMember_status("刚刚活跃");
        memberInfo.setMember_signature("不要心急，生活节奏很重要");
        memberInfo.setMember_role("管理员");
        return  memberInfo;
    }
    public static MemberInfo getMemberInfo5(Context context){
        MemberInfo memberInfo=new MemberInfo();
        memberInfo.setMember_icon(ContextCompat.getDrawable(context, R.mipmap.icon_user4));
        memberInfo.setMember_name("大白白");
        memberInfo.setMember_status("昨天活跃");
        memberInfo.setMember_signature("这个人很懒，什么也没有留下");
        memberInfo.setMember_role("成员");
        return  memberInfo;
    }
    public static MemberInfo getMemberInfo6(Context context){
        MemberInfo memberInfo=new MemberInfo();
        memberInfo.setMember_icon(ContextCompat.getDrawable(context, R.mipmap.icon_user5));
        memberInfo.setMember_name("大萌新");
        memberInfo.setMember_status("三小时前活跃");
        memberInfo.setMember_signature("错了没事，重头再来");
        memberInfo.setMember_role("成员");
        return  memberInfo;
    }
    public static MemberInfo getMemberInfo7(Context context){
        MemberInfo memberInfo=new MemberInfo();
        memberInfo.setMember_icon(ContextCompat.getDrawable(context, R.mipmap.icon_user6));
        memberInfo.setMember_name("小萌新");
        memberInfo.setMember_status("五小时前活跃");
        memberInfo.setMember_signature("这个人很懒，什么也没有留下");
        memberInfo.setMember_role("成员");
        return  memberInfo;
    }
    public static MemberInfo getMemberInfo8(Context context){
        MemberInfo memberInfo=new MemberInfo();
        memberInfo.setMember_icon(ContextCompat.getDrawable(context, R.mipmap.icon_user7));
        memberInfo.setMember_name("小白白");
        memberInfo.setMember_status("刚刚活跃");
        memberInfo.setMember_signature("我是一只小可爱");
        memberInfo.setMember_role("成员");
        return  memberInfo;
    }

}
