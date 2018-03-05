package com.competition.superclub.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.competition.superclub.Bean.ClubReleaseInfo;
import com.competition.superclub.R;

import java.util.ArrayList;

/**
 * Created by 黄庆 on 2018/2/23.
 */

public class ClubDataUtils {
    public static ClubReleaseInfo getFaxianInfo(Context context){
        ClubReleaseInfo clubReleaseInfo=new ClubReleaseInfo();
        clubReleaseInfo.setClubIcon(ContextCompat.getDrawable(context, R.mipmap.icon_example_club));
        clubReleaseInfo.setClubName("发现杯俱乐部");
        clubReleaseInfo.setTime("上午8点");
        clubReleaseInfo.setContent("发现杯俱乐部正式招新啦，想参加的小伙伴们赶紧来我们社团吧，一起学习一起进步，你还在等什么！！！");
        clubReleaseInfo.setImage1(null);
        clubReleaseInfo.setImage2(null);
        clubReleaseInfo.setImage3(null);
        clubReleaseInfo.setAttention("关注" );
        clubReleaseInfo.setEvaluate("评论99+");
        clubReleaseInfo.setLike("点赞99+");
        return clubReleaseInfo;
    }

    public static ClubReleaseInfo getAndroidInfo(Context context){
        ClubReleaseInfo clubReleaseInfo=new ClubReleaseInfo();
        clubReleaseInfo.setClubIcon(ContextCompat.getDrawable(context, R.mipmap.icon_android_club));
        clubReleaseInfo.setClubName("安卓工作室");
        clubReleaseInfo.setTime("上午9:20");
        clubReleaseInfo.setContent("热烈庆祝安卓工作室成员突破200人，安卓工作室有你更精彩！！");
        clubReleaseInfo.setImage1(ContextCompat.getDrawable(context, R.mipmap.club_top_bg1));
        clubReleaseInfo.setImage2(null);
        clubReleaseInfo.setImage3(null);
        clubReleaseInfo.setAttention("关注" );
        clubReleaseInfo.setEvaluate("评论99+");
        clubReleaseInfo.setLike("点赞88");
        return clubReleaseInfo;
    }

    public static ClubReleaseInfo getEnglishInfo(Context context){
        ClubReleaseInfo clubReleaseInfo=new ClubReleaseInfo();
        clubReleaseInfo.setClubIcon(ContextCompat.getDrawable(context, R.mipmap.icon_english_club));
        clubReleaseInfo.setClubName("英语学习社");
        clubReleaseInfo.setTime("上午11:15");
        clubReleaseInfo.setContent("英语社每日一句--The great pleasure in life is doing what people say you cannot do！！");
        clubReleaseInfo.setImage1(null);
        clubReleaseInfo.setImage2(null);
        clubReleaseInfo.setImage3(null);
        clubReleaseInfo.setAttention("关注" );
        clubReleaseInfo.setEvaluate("评论69");
        clubReleaseInfo.setLike("点赞99+");
        return clubReleaseInfo;
    }

    public static ClubReleaseInfo getWebInfo(Context context){
        ClubReleaseInfo clubReleaseInfo=new ClubReleaseInfo();
        clubReleaseInfo.setClubIcon(ContextCompat.getDrawable(context, R.mipmap.icon_web_club));
        clubReleaseInfo.setClubName("web开发社");
        clubReleaseInfo.setTime("中午12:00");
        clubReleaseInfo.setContent("热烈庆祝web开发社换届成功，同时恭祝新社长--张三的上任！新社长颜值也很高哦！！");
        clubReleaseInfo.setImage1(ContextCompat.getDrawable(context, R.mipmap.user_zhangsan));
        clubReleaseInfo.setImage2(null);
        clubReleaseInfo.setImage3(null);
        clubReleaseInfo.setAttention("关注" );
        clubReleaseInfo.setEvaluate("评论55");
        clubReleaseInfo.setLike("点赞89");
        return clubReleaseInfo;
    }

    public static ClubReleaseInfo getPythonInfo(Context context){
        ClubReleaseInfo clubReleaseInfo=new ClubReleaseInfo();
        clubReleaseInfo.setClubIcon(ContextCompat.getDrawable(context, R.mipmap.icon_python_club));
        clubReleaseInfo.setClubName("python精英社");
        clubReleaseInfo.setTime("下午13:02");
        clubReleaseInfo.setContent("python正是当下IT火热的语言之一，想学Python的小伙伴们赶紧来吧，这里都是大神和精英，想成为python精英的就不要犹豫啦！！");
        clubReleaseInfo.setImage1(null);
        clubReleaseInfo.setImage2(null);
        clubReleaseInfo.setImage3(null);
        clubReleaseInfo.setAttention("关注" );
        clubReleaseInfo.setEvaluate("评论40");
        clubReleaseInfo.setLike("点赞62");
        return clubReleaseInfo;
    }

    public static ClubReleaseInfo getChessInfo(Context context){
        ClubReleaseInfo clubReleaseInfo=new ClubReleaseInfo();
        clubReleaseInfo.setClubIcon(ContextCompat.getDrawable(context, R.mipmap.icon_chess_club));
        clubReleaseInfo.setClubName("象棋社");
        clubReleaseInfo.setTime("下午13:35");
        clubReleaseInfo.setContent("明天将会在大会堂于下午两点开始正式举行校园象棋大赛--决赛，届时，小伙伴们记得来观看选手们精彩刺激的棋盘对决，也可以来为喜欢的选手加油助威哦！");
        clubReleaseInfo.setImage1(ContextCompat.getDrawable(context, R.mipmap.image_chess1));
        clubReleaseInfo.setImage2(ContextCompat.getDrawable(context, R.mipmap.image_chess2));
        clubReleaseInfo.setImage3(null);
        clubReleaseInfo.setAttention("关注" );
        clubReleaseInfo.setEvaluate("评论66");
        clubReleaseInfo.setLike("点赞99+");
        return clubReleaseInfo;
    }

    public static ClubReleaseInfo getArtInfo(Context context){
        ClubReleaseInfo clubReleaseInfo=new ClubReleaseInfo();
        clubReleaseInfo.setClubIcon(ContextCompat.getDrawable(context, R.mipmap.icon_art_club));
        clubReleaseInfo.setClubName("美术精英社");
        clubReleaseInfo.setTime("下午16:35");
        clubReleaseInfo.setContent("一波优秀成员的精美油画，觉得好记得点赞哦！");
        clubReleaseInfo.setImage1(ContextCompat.getDrawable(context, R.mipmap.image_art1));
        clubReleaseInfo.setImage2(ContextCompat.getDrawable(context, R.mipmap.image_art2));
        clubReleaseInfo.setImage3(ContextCompat.getDrawable(context, R.mipmap.image_art3));
        clubReleaseInfo.setAttention("关注" );
        clubReleaseInfo.setEvaluate("评论99+");
        clubReleaseInfo.setLike("点赞99+");
        return clubReleaseInfo;
    }
}
