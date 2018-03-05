package com.competition.superclub.Bean;

import android.graphics.drawable.Drawable;

/**
 * Created by 黄庆 on 2018/2/25.
 */

public class MemberInfo {
    private Drawable member_icon;
    private String member_name;
    private String member_signature;
    private String member_role;
    private String member_status;

    public MemberInfo() {
    }

    public Drawable getMember_icon() {
        return member_icon;
    }

    public void setMember_icon(Drawable member_icon) {
        this.member_icon = member_icon;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_signature() {
        return member_signature;
    }

    public void setMember_signature(String member_signature) {
        this.member_signature = member_signature;
    }

    public String getMember_role() {
        return member_role;
    }

    public void setMember_role(String member_role) {
        this.member_role = member_role;
    }

    public String getMember_status() {
        return member_status;
    }

    public void setMember_status(String member_status) {
        this.member_status = member_status;
    }
}
