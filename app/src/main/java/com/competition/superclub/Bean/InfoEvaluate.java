package com.competition.superclub.Bean;

import android.graphics.drawable.Drawable;

/**
 * Created by 黄庆 on 2018/2/24.
 */

public class InfoEvaluate {
    private String userName;
    private Drawable userIcon;
    private String releaseTime;
    private String content;

    public InfoEvaluate() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Drawable getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(Drawable userIcon) {
        this.userIcon = userIcon;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
