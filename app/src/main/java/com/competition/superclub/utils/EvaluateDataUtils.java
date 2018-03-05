package com.competition.superclub.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.competition.superclub.Bean.InfoEvaluate;
import com.competition.superclub.R;

/**
 * Created by 黄庆 on 2018/2/24.
 */

public class EvaluateDataUtils {
    public static InfoEvaluate getInfoEvaluateFirst(Context context){
        InfoEvaluate infoEvaluate=new InfoEvaluate();
        infoEvaluate.setUserIcon(ContextCompat.getDrawable(context, R.mipmap.icon_user7));
        infoEvaluate.setUserName("一楼专业户");
        infoEvaluate.setReleaseTime("下午16:25");
        infoEvaluate.setContent("一楼一楼一楼一楼！！！/doge/doge/doge");
        return infoEvaluate;
    }
    public static InfoEvaluate getInfoEvaluate1(Context context){
        InfoEvaluate infoEvaluate=new InfoEvaluate();
        infoEvaluate.setUserIcon(ContextCompat.getDrawable(context, R.mipmap.icon_user1));
        infoEvaluate.setUserName("超级社团萌新用户");
        infoEvaluate.setReleaseTime("下午16:20");
        infoEvaluate.setContent("哇，期待已久的发现杯俱乐部终于招新啦，想和大神们一起组队，没组队的小伙伴们快来呀！！！");
        return infoEvaluate;
    }
    public static InfoEvaluate getInfoEvaluate2(Context context){
        InfoEvaluate infoEvaluate=new InfoEvaluate();
        infoEvaluate.setUserIcon(ContextCompat.getDrawable(context, R.mipmap.icon_user2));
        infoEvaluate.setUserName("我是用户张三");
        infoEvaluate.setReleaseTime("下午13.21");
        infoEvaluate.setContent("我来啦我来啦，我也需要队员一起，有组队的木有！！！");
        return infoEvaluate;
    }
    public static InfoEvaluate getInfoEvaluate3(Context context){
        InfoEvaluate infoEvaluate=new InfoEvaluate();
        infoEvaluate.setUserIcon(ContextCompat.getDrawable(context, R.mipmap.icon_user3));
        infoEvaluate.setUserName("神奇的李四");
        infoEvaluate.setReleaseTime("下午14:08");
        infoEvaluate.setContent("作为在这里呆了一年的我来说，只想说一句话就是，想参加比赛的但是没报名的你还在等什么！/笑哭/笑哭");
        return infoEvaluate;
    }
    public static InfoEvaluate getInfoEvaluate4(Context context){
        InfoEvaluate infoEvaluate=new InfoEvaluate();
        infoEvaluate.setUserIcon(ContextCompat.getDrawable(context, R.mipmap.icon_user4));
        infoEvaluate.setUserName("隔壁的王五");
        infoEvaluate.setReleaseTime("12.22");
        infoEvaluate.setContent("想进，但是不知道招新的具体的时间和地点在哪里呢?");
        return infoEvaluate;
    }
    public static InfoEvaluate getInfoEvaluate5(Context context){
        InfoEvaluate infoEvaluate=new InfoEvaluate();
        infoEvaluate.setUserIcon(ContextCompat.getDrawable(context, R.mipmap.icon_user5));
        infoEvaluate.setUserName("努力的小明");
        infoEvaluate.setReleaseTime("上午11:59");
        infoEvaluate.setContent("终于等到你，发现杯俱乐部！！");
        return infoEvaluate;
    }
    public static InfoEvaluate getInfoEvaluate6(Context context){
        InfoEvaluate infoEvaluate=new InfoEvaluate();
        infoEvaluate.setUserIcon(ContextCompat.getDrawable(context, R.mipmap.icon_user6));
        infoEvaluate.setUserName("奋斗的小红");
        infoEvaluate.setReleaseTime("上午10:21");
        infoEvaluate.setContent("顶一个顶一个顶一个 ！！");
        return infoEvaluate;
    }

}
