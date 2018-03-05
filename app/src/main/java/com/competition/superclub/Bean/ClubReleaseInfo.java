package com.competition.superclub.Bean;

import android.graphics.drawable.Drawable;

/**
 * Created by 黄庆 on 2018/2/8.
 */

public class ClubReleaseInfo {
    private String clubName;
    private Drawable clubIcon;
    private String time;
    private String content;
    private Drawable image1;
    private Drawable image2;
    private Drawable image3;
    private String attention;
    private String evaluate;
    private String like;

    public ClubReleaseInfo(){

    }

    public ClubReleaseInfo(String clubName, Drawable clubIcon, String time, String content, Drawable image1, Drawable image2, Drawable image3, String attention, String evaluate, String like) {
        this.clubName = clubName;
        this.clubIcon = clubIcon;
        this.time = time;
        this.content = content;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.attention = attention;
        this.evaluate = evaluate;
        this.like = like;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Drawable getClubIcon() {
        return clubIcon;
    }

    public void setClubIcon(Drawable clubIcon) {
        this.clubIcon = clubIcon;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Drawable getImage1() {
        return image1;
    }

    public void setImage1(Drawable image1) {
        this.image1 = image1;
    }

    public Drawable getImage2() {
        return image2;
    }

    public void setImage2(Drawable image2) {
        this.image2 = image2;
    }

    public Drawable getImage3() {
        return image3;
    }

    public void setImage3(Drawable image3) {
        this.image3 = image3;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
